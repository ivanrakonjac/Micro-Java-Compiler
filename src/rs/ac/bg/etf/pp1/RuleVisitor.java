package rs.ac.bg.etf.pp1;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

public class RuleVisitor extends VisitorAdaptor {
	
	int nVars = 0;
	
	Logger log = Logger.getLogger(getClass());
	
	Struct boolType = new Struct(Struct.Bool);
	
	boolean errorDetected = false;
	
	Struct latestFindType = null;
	int declarationLine;
	
	int lastConstNum;
	char lastConstChar;
	int lastConstBool;
	
	Obj currentMethod = null;
	
	boolean returnFound = false;
	
	List<List<Struct>> actualParams = new ArrayList<List<Struct>>();
	List<Obj> calledMethodsList = new ArrayList<Obj>();
	
	
	boolean switchDefaultFound = false;
	boolean switchYieldFound = false;
	List<Integer> switchCaseValues = new ArrayList<Integer>();
	Struct switchReturnValue;

	boolean inTheLoop = false;
	boolean inTheSwitch = false;

	public RuleVisitor() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
		
		for (Obj o : Tab.find("chr").getLocalSymbols()) {
			o.setFpPos(1);
		}
		
		for (Obj o : Tab.find("ord").getLocalSymbols()) {
			o.setFpPos(1);
		}
		
		for (Obj o : Tab.find("len").getLocalSymbols()) {
			o.setFpPos(1);
		}
	}

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}

	public void visit(ProgramName programName) {
		programName.obj = Tab.insert(Obj.Prog, programName.getProgramName(), Tab.noType);
		Tab.openScope();
	}
	
	public void visit(Program program) {
		
		Obj mainMethod = Tab.find("main");
		
		if(mainMethod == Tab.noObj) {
			report_error("Semanticka greska: morate dodati main fju!", null);
		}
		else if(mainMethod.getType() != Tab.noType) {
			report_error("Semanticka greska: main fja mora vracati VOID tip!", null);
		}
		else {
			int fpCnt = 0;
			
			for(Obj obj : mainMethod.getLocalSymbols()) {
				fpCnt += obj.getFpPos();
			}
			
			if(fpCnt > 0) {
				report_error("Semanticka greska: main nema parametre, aman!", null);
			}
		}
		
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgramName().obj);
		Tab.closeScope();
		
	}
	
	/***************************************** Type ******************************************/
	
	public void visit(Type type) {
	
		Obj typeNode = Tab.find(type.getType());
		if(typeNode == Tab.noObj) {
			report_error("Semanticka greska: Tip " + type.getType() + " nije pronadjen u tabeli simbola", null);
			type.struct=  Tab.noType;
		}
		else {
			if(Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
				latestFindType = type.struct;
				declarationLine = type.getLine();
			}
			else { 
				report_error("Semanticka greska: Tip " + type.getType() + " nije validan", type);
				type.struct = Tab.noType;
			}
		}
	}
	
	/***************************************** Type - end ******************************************/
	
	/***************************************** VarDeclaration ******************************************/
	public void visit(VarDeclaration varDeclaration) {
		if(Tab.currentScope.findSymbol(varDeclaration.getVarName()) != null) {
			report_error("Semanticka greska: Varijabla " + varDeclaration.getVarName() + " je vec deklarisana", null);
		}
		else {
			report_info("--VarDeclaration " + varDeclaration.getVarName() + " na liniji " + declarationLine, null);
			Tab.insert(Obj.Var, varDeclaration.getVarName(), latestFindType);
		}
	}
	
	public void visit(VarDeclArray varDeclArray) {
		if(Tab.currentScope.findSymbol(varDeclArray.getVariableName()) != null) {
			report_error("Semanticka greska: Varijabla " + varDeclArray.getVariableName() + " je vec deklarisana", null);
		}
		else {
			report_info("--VarDeclArray " + varDeclArray.getVariableName() + " na liniji " + declarationLine, null);
			Tab.insert(Obj.Var, varDeclArray.getVariableName(), new Struct(Struct.Array, latestFindType));
		}
	}
	
	public void visit(VarDeclExt varDeclExt) {
		if(Tab.currentScope.findSymbol(varDeclExt.getVarName()) != null) {
			report_error("Semanticka greska: Varijabla " + varDeclExt.getVarName() + " je vec deklarisana", null);
		}
		else {
			report_info("--VarDeclExt " + varDeclExt.getVarName() + " na liniji " + declarationLine, null);
			Tab.insert(Obj.Var, varDeclExt.getVarName(), latestFindType);
		}
	}
	
	public void visit(VarDeclArrayExt varDeclArrayExt) {
		if(Tab.currentScope.findSymbol(varDeclArrayExt.getVarName()) != null) {
			report_error("Semanticka greska: Promenljiva " + varDeclArrayExt.getVarName() + " je vec deklarisana", null);
		}
		else {
			report_info("--VarDeclArrayExt " + varDeclArrayExt.getVarName() + " na liniji " + declarationLine, null);
			Obj varNode = Tab.insert(Obj.Var, varDeclArrayExt.getVarName(), new Struct(Struct.Array, latestFindType));
		}
	}
	/***************************************** VarDeclaration - end ******************************************/
	
	/***************************************** ConstDecl ******************************************/
	
	public void visit(SingleConstAssign singleConstAssign) {
		
		Obj constObj = Tab.currentScope.findSymbol(singleConstAssign.getConstName());
		
		if(constObj != null) {
			report_error("Semanticka greska: Konstanta sa imenom " + singleConstAssign.getConstName() + " je vec deklarisana!", null);	
			return;
		}
		
		Obj insertedConst = Tab.insert(Obj.Con, singleConstAssign.getConstName(), latestFindType);
		
		
		if(latestFindType == Tab.intType) {
			
			if(lastConstNum == -1) {
				report_error("Semanticka greska: Konstanta " + singleConstAssign.getConstName() + " je tipa int!", null);	
				return;
			}
			
			insertedConst.setAdr(lastConstNum);
			report_info("--SingleConstAssignInt " + singleConstAssign.getConstName() + "= " + lastConstNum + " na liniji " + declarationLine, null);
		}
		else if(latestFindType == Tab.charType) {
			
			if(lastConstChar == 0) {
				report_error("Semanticka greska: Konstanta " + singleConstAssign.getConstName() + " je tipa char!", null);	
				return;
			}
			
			insertedConst.setAdr(lastConstChar);
			report_info("--SingleConstAssignChar " + singleConstAssign.getConstName() + "= " + lastConstChar + " na liniji " + declarationLine, null);
		}
		else if(latestFindType == boolType) {
			
			if(lastConstBool == -1) {
				report_error("Semanticka greska: Konstanta " + singleConstAssign.getConstName() + " je tipa bool!", null);	
				return;
			}
			
			insertedConst.setAdr(lastConstBool);
			report_info("--SingleConstAssignBool " + singleConstAssign.getConstName() + "= " + lastConstBool + " na liniji " + declarationLine, null);
		}
		
		
	}
	
	public void visit(NumConstValue constValue) {
		
		lastConstChar = 0;
		lastConstBool = -1;
		lastConstNum = constValue.getConstVal();;	
	}
	
	public void visit(CharConstValue charConstValue) {
		
		lastConstNum = -1;
		lastConstBool = -1;
		lastConstChar = charConstValue.getConstVal();;
	}
	
	public void visit(BoolConstValue boolConstValue) {
		
		lastConstNum = -1;
		lastConstChar = 0;
		lastConstBool = boolConstValue.getConstVal().equalsIgnoreCase("true") ? 1 : 0;
		
	}
	
	/***************************************** ConstDecl - end ******************************************/
	
	/***************************************** MethodDecl ******************************************/
	
	public void visit(MethodDecl methodDecl) {
		if(!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Semanticka greska: Metodi " + currentMethod.getName() + " fali RETURN iskaz!", null);	
			return;
		}
		
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		returnFound = false;
		currentMethod = null;
	}
	 
	public void visit(MethodTypeName methodTypeName) {
		if(Tab.currentScope.findSymbol(methodTypeName.getMethName()) != null) {
			report_error("Semanticka greska: Metod " + methodTypeName.getMethName() + " je vec deklarisan!", null);	
			return;
		}
		else {
			report_info("--MethodTypeName " + methodTypeName.getMethName(), methodTypeName);
		}
		
		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getMethodRetType().struct);
		methodTypeName.obj = currentMethod;
		Tab.openScope();
	}
	
	public void visit(MethodReturnType methodReturnType) {
		methodReturnType.struct = methodReturnType.getType().struct;
	}
	
	public void visit(VoidRetType voidRetType) {
		voidRetType.struct = Tab.noType;
	}
	
	
	/***************************************** MethodDecl - end ******************************************/
	
	/***************************************** FormParams ******************************************/
	
	public void visit(FormParam formParam) {
		Obj checkParam = Tab.currentScope.findSymbol(formParam.getParamName());
		if(checkParam != null) {
			report_error("Semanticka greska: Varijabla " +formParam.getParamName() + " je vec deklarisana!", null);	
			return;
		}
		else {
			report_info("--FormParam " + formParam.getParamName() + " u metodi " + currentMethod.getName(), formParam);
			Obj insertedParam = Tab.insert(Obj.Var, formParam.getParamName(), formParam.getType().struct);
			insertedParam.setFpPos(1);
		}
	}
	
	public void visit(FormParamArray formParamArray) {
		Obj checkArrayParam = Tab.currentScope.findSymbol(formParamArray.getParamName());
		if(checkArrayParam != null) {
			
		}
		else {
			report_info("--FormParamArray " + formParamArray.getParamName() + " u metodi " + currentMethod.getName(), formParamArray);
			Obj insertedParam = Tab.insert(Obj.Var, formParamArray.getParamName(), new Struct(Struct.Array, formParamArray.getType().struct));
			insertedParam.setFpPos(1);
		}
	}
	
	/***************************************** FormParams - end ******************************************/
	
	/***************************************** ActPars ******************************************/
	
	public void visit(MultipleParams multipleParams) {
		this.actualParams.get(0).add(multipleParams.getExpr().struct);
	}
	
	public void visit(OneParam oneParam) {
		this.actualParams.get(0).add(oneParam.getExpr().struct);
	}
	
	/***************************************** ActPars - end ******************************************/
	
	/***************************************** DesignatorStatement ******************************************/
	
	public void visit(DesignatorAssign designatorAssign) {
		boolean isVar = designatorAssign.getDesignator().obj.getKind() == Obj.Var;
		boolean isArrayElem = designatorAssign.getDesignator().obj.getKind() == Obj.Elem;
		
		if(!( isArrayElem || isVar )) {
			report_error("Semanticka greska na liniji: " + designatorAssign.getLine() + ". Simbol moze biti samo varijabla ili elem niza!", null);	
			return;	
		}
		
		boolean isAssignableTo = designatorAssign.getExpr().struct.assignableTo(designatorAssign.getDesignator().obj.getType());
		
		if(isAssignableTo) {
			report_info("--Varijabla dobija vrednost ", designatorAssign);
		}
		else {
			report_error("Semanticka greska na liniji: " + designatorAssign.getLine() + ". Tipovi nisu kompatibilni!", null);	
			return;	
		}
	}
	
	public void visit(ProcCall procCall) {
		Obj procDesignatorObj = procCall.getDesignator().obj;
		
		if(procDesignatorObj.getKind() != Obj.Meth) {
			procCall.struct = Tab.noType;
			report_error("Semanticka greska na liniji: " + procCall.getLine() + ". Pozvano ime: "+ procDesignatorObj.getName() + " NIJE funkcija!", null);	
			return;	
		}
		else {
			report_info("--ProcCall " + procDesignatorObj.getName() + " na liniji " + procCall.getLine(), null);
			procCall.struct = procDesignatorObj.getType();
			
			int formParsNum = 0;
			for(Obj o : procDesignatorObj.getLocalSymbols()) {
				formParsNum = formParsNum + o.getFpPos();
			}
			
			if(actualParams.get(0).size() != formParsNum) {
				report_error("Semanticka greska na liniji: " + procCall.getLine() + ". Broj prosledjenih parametara nije dobar!", null);	
				return;
			}
			int i = 0;
			for(Obj o : procDesignatorObj.getLocalSymbols()) {
				if(o.getFpPos() == 0) continue;
				if(this.actualParams.get(0).get(i++) != o.getType()) {
					report_error("Semanticka greska:  prosledjeni parametri funkcije " + this.calledMethodsList.get(0).getName() + " se ne slazu sa formalnim parametrima funkcije ", procCall);
					break;
				}
			}
			
			this.calledMethodsList.remove(0);
			this.actualParams.remove(0);
		}
	}
	
	
	public void visit(VariableInc variableInc) {
	
		boolean isNotArrElem = variableInc.getDesignator().obj.getKind() != Obj.Elem;
		boolean isNotVar = variableInc.getDesignator().obj.getType().getKind() != Obj.Var;
		
		if(isNotArrElem && isNotVar) {
			report_error("Semanticka greska na liniji: " + variableInc.getLine() + " : simbol mora biti VARIJABLA ili ELEMENT NIZA!", null);
		}
		else if(variableInc.getDesignator().obj.getType() != Tab.intType) {
			report_error("Semanticka greska na liniji: " + variableInc.getLine() + " varijabla mora biti INT", null);
		}
		else {
			report_info("--Varijabla " + variableInc.getDesignator().obj.getName() + " INC ", variableInc);
		}
	}
	
	public void visit(VariableDec variableDec) {
		
		boolean isNotArrElem = variableDec.getDesignator().obj.getKind() != Obj.Elem;
		boolean isNotVar = variableDec.getDesignator().obj.getType().getKind() != Obj.Var;
		
		if(isNotArrElem && isNotVar) {
			report_error("Semanticka greska na liniji: " + variableDec.getLine() + " : simbol mora biti VARIJABLA ili ELEMENT NIZA!", null);
		}
		else if(variableDec.getDesignator().obj.getType() != Tab.intType) {
			report_error("Semanticka greska na liniji: " + variableDec.getLine() + " varijabla mora biti INT", null);
		}
		else {
			report_info("--Varijabla " + variableDec.getDesignator().obj.getName() + " DEC ", variableDec);
		}
	}
	
	/***************************************** DesignatorStatement - end ******************************************/
	
	/***************************************** Designator ******************************************/
	
	public void visit(DesignatorBasic designatorBasic) {
		Obj desObj = Tab.find(designatorBasic.getVarName());
		
		if(desObj == Tab.noObj) {
			report_error("Semanticka greska na liniji: " + designatorBasic.getLine() + ". Naziv: " + designatorBasic.getVarName() + " nije deklarisan!", null);	
			return;
		}
		else if (desObj.getKind() == Obj.Meth) {
			this.calledMethodsList.add(0, desObj);
			this.actualParams.add(0, new ArrayList<Struct>());	
		}
		
		designatorBasic.obj = desObj;
		
	}
	
	public void visit(DesignatorArray designatorArray) {
		if(designatorArray.getDesignatorArrayName().obj == Tab.noObj) {
			designatorArray.obj = Tab.noObj;
			return;
		}
		else if(designatorArray.getDesignatorArrayName().obj.getKind() == Obj.Meth) {
			this.calledMethodsList.add(0, designatorArray.getDesignatorArrayName().obj);
			this.actualParams.add(0, new ArrayList<Struct>());
		}
		
		if(designatorArray.getExpr().struct != Tab.intType) {
			report_error("Semanticka greska na liniji: " + designatorArray.getLine() + ". Indeks niza mora biti int!", designatorArray);	
			designatorArray.obj = Tab.noObj;
			return;
		}
		else {
			designatorArray.obj = new Obj(Obj.Elem, "", designatorArray.getDesignatorArrayName().obj.getType().getElemType());
		}
	}
	
	public void visit(DesArrName desArrName) {
		Obj arrTypeObj = Tab.find(desArrName.getVarName());
		
		if(arrTypeObj == Tab.noObj) {
			report_error("Semanticka greska na liniji: " + desArrName.getLine() + ". Niz nije deklarisan!", desArrName);	
			desArrName.obj=  Tab.noObj;
			return;
		}
		else if(arrTypeObj.getType().getKind() != Struct.Array) {
			report_error("Semanticka greska na liniji: " + desArrName.getLine() + ". Tip mora biti niz!", desArrName);	
			desArrName.obj=  Tab.noObj;
			return;
		}
		
		desArrName.obj = arrTypeObj;
	}
	
	/***************************************** Designator - end ******************************************/
	
	/***************************************** Factor ******************************************/
	
	public void visit(Var var) {
		var.struct = var.getDesignator().obj.getType();
	}
	
	public void visit(FunctionCall functionCall) {
		Obj funcObj = functionCall.getDesignator().obj;
		
		if(funcObj.getKind() != Obj.Meth) {
			report_error("Semanticka greska: na liniji " + functionCall.getLine() + ", FunctionCall: " + funcObj.getName() + " nije funkcija!", null);
			functionCall.struct = Tab.noType;
		}
		else {
			
			
			report_info("--FunctionCall " + funcObj.getName() + " ", functionCall);
			functionCall.struct = funcObj.getType();
			
			int paramsNum = 0;
			for(Obj o : funcObj.getLocalSymbols()) {
				paramsNum = paramsNum +  o.getFpPos();
			}
			
			if(this.actualParams.get(0).size() != paramsNum) {
				report_error("Semanticka greska: " + " broj prosledjenih parametara u pozivu funkcije " + funcObj.getName() + " nije dobar, ", functionCall);	
				return;
			}
			
			int i = 0;
			for(Obj o : funcObj.getLocalSymbols()) {
				if(o.getFpPos() == 0) continue;
				if(actualParams.get(0).get(i++) != o.getType()) {
					report_error("Semanticka greska: " + "prosledjeni parametri funkcije " + calledMethodsList.get(0).getName() + " se ne slazu sa formalnim parametrima, ", functionCall);	
					break;
					
				}
			}
			
			calledMethodsList.remove(0);
			actualParams.remove(0);
		}
	}
	
	public void visit(NumberConst numberConst) {
		numberConst.struct = Tab.intType;
	}
	
	public void visit(CharConst charConst) {
		charConst.struct = Tab.charType;
	}
	
	public void visit(BoolConst boolConst) {
		boolConst.struct = boolType;
	}
	
	public void visit(NewOp newOp) {
		if(newOp.getType().struct.getKind() != Struct.Class) {
			report_error("Semanticka greska: na liniji " + newOp.getLine() + ": promenljiva uz operator NEW mora biti klasa!", null);
			return;
		}
		newOp.struct = new Struct(Struct.Class, newOp.getType().struct);
	}
	
	public void visit(NewArray newArray) {
		if(newArray.getExpr().struct != Tab.intType) {
			report_error("Semanticka greska: na liniji " + newArray.getLine() + ". Duzina niza mora biti INT!", null);
			return;
		}
		else {
			report_info("--NewArray ", newArray);
			newArray.struct = new Struct(Struct.Array, newArray.getType().struct);
		}
	}
	
	public void visit(FactExpr expr) {
		expr.struct = expr.getExpr().struct;
	}
	
	/***************************************** Factor - end ******************************************/
	
	/***************************************** Term ******************************************/
	
	public void visit(FactorTerm term) {
		term.struct = term.getFactor().struct;
	}
	
	public void visit(MulopTerm mulopTerm) {
		Struct term = mulopTerm.getTerm().struct;
		Struct factor = mulopTerm.getFactor().struct;
		
		if(term == Tab.intType && term.equals(factor)) {
			mulopTerm.struct = factor;
		}
		else {
			report_error("Semanticka greska: na liniji " + mulopTerm.getLine() + ", tipovi NISU kompatibilni!", null);
			mulopTerm.struct = Tab.noType;
		}
	}
	
	/***************************************** Term - end ******************************************/
	
	/***************************************** BasicExpr ******************************************/
	
	public void visit(AddExpr addExpr) {
		Struct basicExprTerm = addExpr.getBasicExpr().struct;
		Struct term = addExpr.getTerm().struct;
		
		if(term == Tab.intType && basicExprTerm.equals(term)) {
			addExpr.struct = term;
		} 
		else {
			report_error("Semanticka greska: na liniji " + addExpr.getLine() + ", tipovi NISU kompatibilni!", null);
			addExpr.struct = Tab.noType;
		}
	}
	
	public void visit(TermExpr termExpr) {
		termExpr.struct = termExpr.getTerm().struct;
	}
	/***************************************** BasicExpr - end ******************************************/
	
	/***************************************** Expr ******************************************/
	
	public void visit(BasicExprr basicExprr) {
		
		boolean isInstanceofMinus = basicExprr.getOptionalMinus() instanceof Minus;
		boolean isInt = basicExprr.getBasicExpr().struct.equals(Tab.intType);
		
		if( isInstanceofMinus && !isInt) {
			report_error("Semanticka greska: na liniji " + basicExprr.getLine() + ", imamo minus ali tip NIJE int!", null);
			basicExprr.struct = Tab.noType;
			return;
		}
		else
			basicExprr.struct = basicExprr.getBasicExpr().struct;
	}
	
	public void visit(SwitchExp switchExp) {
		if(switchExp.getExpr().struct != Tab.intType) {
			report_error("Semanticka greska: na linji " + switchExp.getLine() + ". Switch prima samo INT! ", null);
			switchExp.struct = Tab.noType;
			return;
		}
		else {
			switchExp.struct = switchReturnValue;
		}
		
		if(!switchDefaultFound) {
			report_error("Semanticka greska: nije pronadjena DEFAULT labela ", switchExp);
		}
		
		if(!switchYieldFound) {
			report_error("Semanticka greska: nije pronadjena YIELD labela ", switchExp);
		}
		
		switchDefaultFound = false;
		switchYieldFound = false;
		inTheLoop = false;
		switchCaseValues.clear();
	}
	
	public void visit(SwitchExpr expr) {
		this.inTheSwitch = true;
		this.switchCaseValues.clear();
	}
	
	public void visit(CaseStmt caseStmt) {
		if(switchCaseValues.contains(caseStmt.getN1())) {
			report_error("Semanticka greska: ne moze u vise caseova ista vrednost!; Nadjena vrednost: " + caseStmt.getN1() + " ", caseStmt);
			return;
		}
		else {
			switchCaseValues.add(caseStmt.getN1());
		}
	}
	
	public void visit(DefaultStmt stmt) {
		switchDefaultFound = true;
	}
	
	/***************************************** Expr - end ******************************************/
	
	/***************************************** Statement ******************************************/
	
	public void visit(DoWhileStmt stmt) {
		inTheLoop = false;
	}
	
	public void visit(DoStmt stmt) {
		inTheLoop = true;
	}
	
	public void visit(BreakStmt breakStmt) {
		if(!inTheLoop) {
			report_error("Semanticka greska : break moze samo unutar petlji, ", breakStmt);
		}
	}
	
	public void visit(ContinueStmt continueStmt) {
		if(!inTheLoop) {
			report_error("Semanticka greska : continue moze samo unutar petlji, ", continueStmt);
		}
	}
	
	public void visit(ReturnStmt returnStmt) {
		returnFound = true;
		
		Struct exprStruct = returnStmt.getExpr().struct;
		
		if(!currentMethod.getType().compatibleWith(exprStruct)) {
			report_error("Semanticka greska : return val metode " + currentMethod.getName() + " se ne poklapa sa return tipom, ", returnStmt);
		}
	}
	
	public void visit(ReturnNoValStmt returnNoValStmt) {
		returnFound = false;
		if(!currentMethod.getType().compatibleWith(Tab.noType)) {
			report_error("Semanticka greska : metoda " + currentMethod.getName() + " MORA imati neki povratni parametar, ", returnNoValStmt);
		}
	}
	
	public void visit(ReadStmt readStmt) {
		
		boolean isNotArrElem = readStmt.getDesignator().obj.getKind() != Obj.Elem;
		boolean isNotVar = readStmt.getDesignator().obj.getKind() != Obj.Var;
		
		if( isNotArrElem && isNotVar) {
			report_error("Semanticka greska: Simbol nije element niza ili varijabla, ", readStmt);	
			return;
		}
		
		boolean isInt = readStmt.getDesignator().obj.getType() == Tab.intType;
		boolean isChar = readStmt.getDesignator().obj.getType() == Tab.charType;
		boolean isBool = readStmt.getDesignator().obj.getType() == boolType;
		
		if(!( isInt || isChar || isBool)) {
			report_error("Semanticka greska : parametar READ mora biti int, char ili bool, ", readStmt);
			return;
		}
	}
	
	public void visit(PrintStmt printStmt) {
		
		boolean isInt = printStmt.getExpr().struct.equals(Tab.intType);
		boolean isChar = printStmt.getExpr().struct.equals(Tab.charType);
		boolean isBool = printStmt.getExpr().struct.equals(boolType);
		
		if(!( isInt || isChar || isBool )) {
			report_error("Semanticka greska : parametar PRINT funkcije mora biti int, char ili bool, ", printStmt);
		}
	}
	
	public void visit(PrintExprStmt printExprStmt) {
		
		boolean isInt = printExprStmt.getExpr().struct.equals(Tab.intType);
		boolean isChar = printExprStmt.getExpr().struct.equals(Tab.charType);
		boolean isBool = printExprStmt.getExpr().struct.equals(boolType);
		
		if(!( isInt || isChar || isBool )) {
			report_error("Semanticka greska : parametar PRINT funkcije mora biti int, char ili bool, ", printExprStmt);
		}
	}
	
	public void visit(YieldStmt yieldStmt) {
		if(!inTheSwitch) {
			report_error("Semanticka greska : YIELD moze samo unutar switcha,  ", yieldStmt);
			yieldStmt.struct = Tab.noType;
			return;
		}
		else {
			yieldStmt.struct = yieldStmt.getExpr().struct;
			switchReturnValue = yieldStmt.struct;
		}
	}
	
	public void visit(YieldStatmnt yieldStatmnt) {
		if(switchDefaultFound) {
			switchYieldFound = true;
		}
	}
	
	/***************************************** Statement - end ******************************************/
	
	/***************************************** Condition ******************************************/
	
	public void visit(Condition condition) {
		condition.struct = condition.getCondTermList().struct;
	}
	
	public void visit(OrCond orCond) {
		Struct condTypeFirst = orCond.getCondTermList().struct;
		Struct condTypeSecond = orCond.getCondTerm().struct;
		
		boolean is1Bool = condTypeFirst.getKind() == boolType.getKind();
		boolean is2Bool = condTypeSecond.getKind() == boolType.getKind();
		
		if( is1Bool && is2Bool ) {
			orCond.struct = boolType;
			report_info("--Uslov u ifu ok ", orCond);
		}
		else {
			orCond.struct = Tab.noType;
			report_error("Semanticka greska: izraz u if-i NIJE bool tipa, ", orCond);
		}
	}
	
	public void visit(CondSimple condSimple) {
		
		boolean isNotBool = condSimple.getCondTerm().struct.getKind() != boolType.getKind();
		
		if(isNotBool) {
			report_error("Semanticka greska: Uslov u if naredbi NIJE bool tipa, ", condSimple);
			condSimple.struct = Tab.noType;
			return;
		}
		else {
			report_info("--Uslov u ifu ok, ", condSimple);
			condSimple.struct = boolType;
		}
	}
	
	public void visit(CondTerm condTerm) {
		condTerm.struct = condTerm.getCondFactList().struct;
	}
	
	public void visit(AndCond andCond) {
		Struct condFirst = andCond.getCondFactList().struct;
		Struct condSecond = andCond.getCondFact().struct;
		
		boolean iscond1Bool = condFirst.getKind() == boolType.getKind();
		boolean iscond2Bool = condSecond.getKind() == boolType.getKind();
		
		if(!(iscond1Bool && iscond2Bool )) {
			report_error("Semanticka greska: Uslovi nisu BOOL tipa, ", andCond);
			andCond.struct = Tab.noType;
			return;
		}
		else {
			andCond.struct = boolType;
		}
	}
	
	public void visit(CondTermSimple condTermSimple) {
		condTermSimple.struct = condTermSimple.getCondFact().struct;
	}
	
	public void visit(CondExpr condExpr) {
		condExpr.struct = condExpr.getExpr().struct;
	}
	
	public void visit(CondRelop condRelop) {
		Struct exprFirst = condRelop.getExpr().struct;
		Struct exprSecond = condRelop.getExpr1().struct;
		
		boolean iscompatibleWith = exprFirst.compatibleWith(exprSecond);
		
		if(!iscompatibleWith) {
			report_error("Semanticka greska: tipovi expr nisu kompatibilni, ", condRelop);
			condRelop.struct = Tab.noType;
			return;
		}
		else {
			condRelop.struct = boolType;
		}
	}
	
	/***************************************** Condition - end ******************************************/

	public boolean passed(){
    	return !errorDetected;
    }
}
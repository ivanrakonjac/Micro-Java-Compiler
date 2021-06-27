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
			report_error("Semanticka greska: Varijabla " +formParamArray.getParamName() + " je vec deklarisana!", null);	
			return;	
		}
		else {
			report_info("--FormParamArray " + formParamArray.getParamName() + " u metodi " + currentMethod.getName(), formParamArray);
			Obj insertedParam = Tab.insert(Obj.Var, formParamArray.getParamName(), new Struct(Struct.Array, formParamArray.getType().struct));
			insertedParam.setFpPos(1);
		}
	}
	
	/***************************************** FormParams - end ******************************************/
}
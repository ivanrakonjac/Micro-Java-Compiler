package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor {
	
	Logger log = Logger.getLogger(getClass());
	
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	private int mainPc;
	
	Struct methodRetType = null;
	
	boolean ifStarted = false;
	
	Stack<Boolean> minusIsHappend = new Stack<Boolean>();
	
	Stack<Integer> condTermSkip = new Stack<Integer>();
	Stack<Integer> conditionSkip = new Stack<Integer>();
	Stack<Integer> trueSkip = new Stack<Integer>();
	Stack<Integer> elseSkip = new Stack<Integer>();
	
	Stack<Integer> doStart = new Stack<Integer>();
	List<Stack<Integer>> doWhileBreakAddr = new ArrayList<Stack<Integer>>();
	
	Map<String, Integer> labels = new HashMap<String, Integer>();
	Map<String, ArrayList<Integer>> patchAdr = new HashMap<String, ArrayList<Integer>>();
	
	Stack<Integer> stackForYields = new Stack<Integer>();
	boolean foundFirstCase = false;
	int addrForPatch;
	boolean foundYield = false;
	
	/***************************************** Statement *****************************************/
	
	public void visit(ReturnStmt returnStmt) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(ReturnNoValStmt retNoValStmt) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(ReadStmt readStmt) {
		
		boolean isDesignEqualsChar = readStmt.getDesignator().obj.getType().equals(Tab.charType);
		
		if(isDesignEqualsChar) {
			Code.put(Code.bread);
		}
		else {
			Code.put(Code.read);
		}
		
		Code.store(readStmt.getDesignator().obj);
	}
	
	public void visit(PrintStmt printStmt) {
		
		Code.loadConst(0);
		
		boolean isExprEqualsChar = printStmt.getExpr().struct.equals(Tab.charType);
				
		if(isExprEqualsChar) {
			Code.put(Code.bprint);
		}
		else {
			Code.put(Code.print);
		}
		
	}
	
	public void visit(PrintExprStmt printExprStmt) {
		
		Code.loadConst(printExprStmt.getN2());
		
		boolean isExprEqualsChar = printExprStmt.getExpr().struct.equals(Tab.charType);
		
		if(isExprEqualsChar) {
			Code.put(Code.bprint);
		}
		else {
			Code.put(Code.print);
		}	
		
	}
	
	public void visit(IfStmt ifStmt) {
		ifStarted = true;
	}
	
	/***************************************** Statement - end *****************************************/
	
	/***************************************** Factor *****************************************/
	
	public void visit(Var var) {
		
		Obj desObj = var.getDesignator().obj;
		Code.load(desObj);
		
		if(minusIsHappend.peek() == true) {
			Code.put(Code.neg);
			minusIsHappend.pop();
			minusIsHappend.push(false);  
		}
	}
	
	public void visit(NumberConst numberConst) {
		
		Integer numConst = numberConst.getNumConst();
		Code.loadConst(numConst);
		
		if(minusIsHappend.peek() == true) {
			Code.put(Code.neg);
			minusIsHappend.pop();
			minusIsHappend.push(false);  
		}
	}
	
	public void visit(FactExpr factExpr) {
		
		if(minusIsHappend.peek() == true) {
			Code.put(Code.neg);
			minusIsHappend.pop();
			minusIsHappend.push(false);  
		}
		
	}
	
	public void visit(CharConst charConst) {
		Character chrConst = charConst.getCharConst();
		Code.loadConst(chrConst);
	}
	
	public void visit(BoolConst BoolConst) {
		
		if(BoolConst.getBoolConst().equals("true")) {
			Code.loadConst(1);
		}
		else {
			Code.loadConst(0);
		}
	}
	
	public void visit(NewArray newArray) {
		Code.put(Code.newarray);
		
		if(newArray.getType().struct == Tab.charType) {
			Code.put(0);
		}
		else {
			Code.put(1);
		}
		
	}
	
	public void visit(FunctionCall functionCall) {
		Obj functionObj = functionCall.getDesignator().obj;
		int dest_adr = functionObj.getAdr() - Code.pc;
		
		Code.put(Code.call);
		Code.put2(dest_adr);
		
		if(minusIsHappend.peek() == true) {
			Code.put(Code.neg);
			minusIsHappend.pop();
			minusIsHappend.push(false);  
		}
	}
	
	/***************************************** Factor - end *****************************************/
	
	/***************************************** Designator - end *****************************************/
	
	public void visit(DesignatorArrayName designatorArrayName) {
		Code.load(designatorArrayName.obj);
	}
	
	/***************************************** Designator - end *****************************************/
	
	/***************************************** Designator Statement *****************************************/
	
	public void visit(DesignatorAssign designatorAssign) {
		Code.store(designatorAssign.getDesignator().obj);
	}
	
	public void visit(ProcCall procCall) {
		Obj procCallObj = procCall.getDesignator().obj;
		int dest_adr = procCallObj.getAdr() - Code.pc;
		
		Code.put(Code.call);
		Code.put2(dest_adr);
		
		if(procCall.getDesignator().obj.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
	}
	
	public void visit(VariableInc variableInc) {
		
		boolean isElem = variableInc.getDesignator().obj.getKind() == Obj.Elem;
		
		if(isElem) {
			Code.put(Code.dup2);
		}	
		
		Code.load(variableInc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(variableInc.getDesignator().obj);
	}
	
	public void visit(VariableDec variableDec) {
		
		boolean isElem = variableDec.getDesignator().obj.getKind() == Obj.Elem;
				
		if(isElem) {
			Code.put(Code.dup2);
		}

		Code.load(variableDec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(variableDec.getDesignator().obj);
	}
	
	/***************************************** Designator Statement - end *****************************************/
	
	/***************************************** Expr *****************************************/
	
	public void visit(BasicExpr basicExpr) {
		minusIsHappend.pop();
	}
	
	public void visit(Minus minus) {
		minusIsHappend.push(true);
	}
	public void visit(NoMinus noMinus) {
		minusIsHappend.push(false);
	}
	
	/***************************************** Expr - end *****************************************/
	
	/***************************************** Method Call *****************************************/
	
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(MethodTypeName methodTypeName) {
		
		methodTypeName.obj.setAdr(Code.pc);
		
		boolean isMain = methodTypeName.getMethName().equals("main");
		
		if(isMain) {
			mainPc = Code.pc;
		}
		
		methodRetType = methodTypeName.getMethodRetType().struct;
		
//		if(methodRetType == Tab.noType) {
//			report_info("--MethodTypeName " + methodTypeName.getMethName() + " ret type = VOID", methodTypeName);
//		}
//		else if(methodRetType == Tab.intType) {
//			report_info("--MethodTypeName " + methodTypeName.getMethName() + " ret type = INT", methodTypeName);
//		}
//		else if(methodRetType == Tab.charType) {
//			report_info("--MethodTypeName " + methodTypeName.getMethName() + " ret type = CHAR", methodTypeName);
//		}
//		else {
//			report_info("--MethodTypeName " + methodTypeName.getMethName() + " ret type = BOOL", methodTypeName);
//		}
		
		
		
		int formalParamCnt = 0;
		for(Obj obj: methodTypeName.obj.getLocalSymbols()) {
			formalParamCnt = formalParamCnt + obj.getFpPos();
		}
		
		
		Code.put(Code.enter);
		Code.put(formalParamCnt);
		Code.put(methodTypeName.obj.getLocalSymbols().size());
	}
	
	/***************************************** Method Call - end *****************************************/
	
	/***************************************** If *****************************************/

	public void visit(CondExpr condExpr) {
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0);
		condTermSkip.push(Code.pc - 2);
	}
	
	public void visit(CondRelop compareExpr) {
		Code.putFalseJump(getRelOp(compareExpr.getRelop()), 0);
		condTermSkip.push(Code.pc - 2);
	}
	
	public void visit(CondTerm condTerm) {
		Code.putJump(0);
		conditionSkip.push(Code.pc - 2);
		
		while(!condTermSkip.empty()) {
			Code.fixup(condTermSkip.pop());
		}
	}
	
	public void visit(Condition condition) {
		Code.putJump(0);
		trueSkip.push(Code.pc - 2);
		
		while(!conditionSkip.empty()) {
			Code.fixup(conditionSkip.pop());
		}
	}
	
	public void visit(ElseTerm elseTerminal) {
		Code.putJump(0);
		elseSkip.push(Code.pc - 2);
		
		Code.fixup(trueSkip.pop());
	}
	
	public void visit(ElseStatmt elseStatement) {
		Code.fixup(elseSkip.pop());
	}
	
	public void visit(NoElseStmt noElseStatement) {
		Code.fixup(trueSkip.pop());
	}
	
	/***************************************** If - end *****************************************/
	
	/***************************************** Addop *****************************************/
	
	public void visit(AddExpr addExpr) {
		
		boolean isaddExrInstOfAddOp = addExpr.getAddop() instanceof AddOper;
		
		if(isaddExrInstOfAddOp) {
			Code.put(Code.add);
		}
		else {
			Code.put(Code.sub);
		}
	}
	
	/***************************************** Addop - end *****************************************/
	
	/***************************************** Mulop *****************************************/
		
	public void visit(MulopTerm mulopTerm) {
		
		boolean isMulOp = mulopTerm.getMulop() instanceof MulOper;
		boolean isDiv =  mulopTerm.getMulop() instanceof DivOper;
		
		if(isMulOp) {
			Code.put(Code.mul);
		}
		else if(isDiv) {
			Code.put(Code.div);
		}
		else {
			Code.put(Code.rem);
		}
	}
		
	/***************************************** Mulop - end *****************************************/
	
	/***************************************** DoWhile *****************************************/

	public void visit(DoStmt doStmt) {
		doStart.push(Code.pc);
		doWhileBreakAddr.add(0, new Stack<Integer>());
	}
	
	public void visit(DoWhileStmt doWhileStmt) {
		Code.putJump(doStart.pop());
		
		Code.fixup(trueSkip.pop());
		
		while(!doWhileBreakAddr.get(0).empty()) {
			Code.fixup(doWhileBreakAddr.get(0).pop());
		}
		
		doWhileBreakAddr.remove(0);
	}
	
	public void visit(ContinueStmt continueStmt) {
		Code.putJump(doStart.peek());
	}
	
	public void visit(BreakStmt breakStmt) {
		Code.putJump(0);
		doWhileBreakAddr.get(0).push(Code.pc - 2);
	}

	/***************************************** DoWhile - end *****************************************/

	/***************************************** GOTO *****************************************/
	
	public void visit(GotoStmt gotoStmt) {
		if(labels.get(gotoStmt.getLabelname()) != null) {
			Code.putJump(labels.get(gotoStmt.getLabelname()));
		}
		else {
			Code.putJump(0);
			
			if(patchAdr.containsKey(gotoStmt.getLabelname())) {
				patchAdr.get(gotoStmt.getLabelname()).add(Code.pc - 2);
			}
			else {
				ArrayList<Integer> listOfAddr = new ArrayList<Integer>();
				listOfAddr.add(Code.pc - 2);
				patchAdr.put(gotoStmt.getLabelname(), listOfAddr);
			}
		}
	}
	
	public void visit(Label label) {
		labels.put(label.getLabelName(), Code.pc);
		
		if(patchAdr.containsKey(label.getLabelName())) {
			while(!patchAdr.get(label.getLabelName()).isEmpty()) {
				Code.fixup(patchAdr.get(label.getLabelName()).remove(0));
			}
		}
	}
	
	/***************************************** GOTO - end *****************************************/
	
	/***************************************** Switch *****************************************/
	
	public void visit(SwitchExp switchExp) {
		while(!stackForYields.empty()) {
			Code.fixup(stackForYields.pop());
		}
	}
	
	public void visit(SwitchExpr switchExpr) {
		foundFirstCase = true;
	}
	
	public void visit(SingleCaseLine singleCaseLine) {
		
		if(foundFirstCase == true) {
			Code.put(Code.dup);
			Code.loadConst(singleCaseLine.getN1());
			Code.putFalseJump(Code.eq, 0);
			foundFirstCase = false;
			addrForPatch = Code.pc - 2;
		}
		else {
			Code.fixup(addrForPatch);
			Code.put(Code.dup);
			Code.loadConst(singleCaseLine.getN1());
			Code.putFalseJump(Code.eq, 0);
			addrForPatch = Code.pc - 2;

		}
	}
	
	public void visit(CaseStmt caseStmt) {
		if(!foundYield) {
			Code.put(Code.dup);
			Code.putJump(Code.pc + 8);
		}
		foundYield = false;
	}
	
	public void visit(DefaultStmt defaultStmt) {
		Code.loadConst(10);
		Code.fixup(addrForPatch);
	}
	
	public void visit(YieldStmt yieldStmt) {
		foundYield = true;
		Code.putJump(0);
		stackForYields.push(Code.pc - 2);
	}
	
	/***************************************** Switch - end *****************************************/
	
	/***************************************** Util *****************************************/
	
	private void ordChrLenMethodsInitialization() {
		Obj ord = Tab.find("ord");
		ord.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		Obj chr = Tab.find("chr");
		chr.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		Obj len = Tab.find("len");
		len.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	private int getRelOp(Relop relop) {
		if(relop instanceof EqualsOper)
			return Code.eq;
		if(relop instanceof NotEqualsOper)
			return Code.ne;
		if(relop instanceof GreaterOper)
			return Code.gt;
		if(relop instanceof GreaterEqOper)
			return Code.ge;
		if(relop instanceof LessOper)
			return Code.lt;
		if(relop instanceof LessEqOper)
			return Code.le;
		return 0;
		
	}
	
	public int getMainPc() {
		return mainPc;
	}
	
	/***************************************** Util - end *****************************************/
}

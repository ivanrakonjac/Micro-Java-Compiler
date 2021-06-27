package rs.ac.bg.etf.pp1;


import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;
	/*
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(MethodTypeName methodTypeName) {
		int fpCnt = 0;
		for(Obj obj: methodTypeName.obj.getLocalSymbols())
			fpCnt += obj.getFpPos();
		
		
		Code.put(Code.enter);
		Code.put(fpCnt);
		Code.put(methodTypeName.obj.getLocalSymbols().size());
		
		if(methodTypeName.getMethName().equals("main")) {
			mainPc = Code.pc;
		}
	}
	
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(RetStmt retStmt) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(RetNoValStmt retNoValStmt) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(NumConst NumConst) {
		Code.loadConst(NumConst.getNumConst());
	}
	
	public void visit(CharConst CharConst) {
		Code.loadConst(CharConst.getCharConst());
	}
	
	public void visit(BoolConst BoolConst) {
		Code.loadConst(BoolConst.getBoolConst().equalsIgnoreCase("true") ? 1 : 0);
	}
	
	public void visit(DesAssign desAssign) {
		Code.store(desAssign.getDesignator().obj);
	}
	
	public void visit(Var var) {
		Code.load(var.getDesignator().obj);
	}
	
	
	public void visit(PrintStmt printStmt) {
		Code.loadConst(0);
		if(printStmt.getExpr().struct.equals(Tab.charType))
			Code.put(Code.bprint);
		else
			Code.put(Code.print);
		
	}
	
	public void visit(PrintStmtwithNumber printStmtwithNumber) {
		Code.loadConst(printStmtwithNumber.getN2());
		if(printStmtwithNumber.getExpr().struct.equals(Tab.charType))
			Code.put(Code.bprint);
		else
			Code.put(Code.print);
		
	}
	
	public void visit(ReadStmt readStmt) {
		if(readStmt.getDesignator().obj.getType().equals(Tab.charType))
			Code.put(Code.bread);
		else
			Code.put(Code.read);
		Code.store(readStmt.getDesignator().obj);
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
	
	public void visit(DesignatorArrayName designatorArrayName) {
		Code.load(designatorArrayName.obj);
	}
	
	Map<String, Integer> labels = new HashMap<String, Integer>();
	Map<String, ArrayList<Integer>> patchAdr = new HashMap<String, ArrayList<Integer>>();
	
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
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(Code.pc - 2);
				patchAdr.put(gotoStmt.getLabelname(), list);
			}
		}
	}
	
	
	public void visit(Label label) {
		labels.put(label.getLabelname(), Code.pc);
		
		if(patchAdr.containsKey(label.getLabelname())) {
			while(!patchAdr.get(label.getLabelname()).isEmpty()) {
				Code.fixup(patchAdr.get(label.getLabelname()).remove(0));
			}
		}
	}*/
}

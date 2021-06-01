package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor{
	
	int varDeclCounter = 0;
	
	public void visit(VarDecl varDecl) {
		varDeclCounter++;
	}
	
	int methodDeclCounter = 0;
	
	public void visit(MethodDecl methodDecl) {
		methodDeclCounter++;
	}
	
	int formalParamDeclCounter = 0;
	
	public void visit(FormalParamDecl formalParamDecl) {
		formalParamDeclCounter++;
	}
	
	int termExprCounter = 0;
	
	public void visit(TermExpr termExpr) {
		termExprCounter++;
	}
	
	int actualParamsCounter = 0;
	
	public void visit(ActualParams actualParams) {
		actualParamsCounter++;
	}
	
	

	/*int printCallCount = 0;
	int varDeclCount = 0;
	
	Logger log = Logger.getLogger(getClass());

	public void visit(VarDecl vardecl){
		varDeclCount++;
	}
	
    public void visit(PrintStmt print) {
		printCallCount++;
	}*/

}

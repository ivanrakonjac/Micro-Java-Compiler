package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.FormParamDecl;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {
	protected int count;
	
	public int getCount() {
		return count;
	}
	
	public static class FormParamCounter extends CounterVisitor {
		public void visit(FormParamDecl formParamDecl) {
			count++;
		}
	}
}

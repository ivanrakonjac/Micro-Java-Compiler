// generated with ast extension for cup
// version 0.8
// 29/5/2021 20:25:30


package rs.ac.bg.etf.pp1.ast;

public class NoActualParams extends ActualParams {

    public NoActualParams () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoActualParams(\n");

        buffer.append(tab);
        buffer.append(") [NoActualParams]");
        return buffer.toString();
    }
}

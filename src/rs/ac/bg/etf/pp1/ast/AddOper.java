// generated with ast extension for cup
// version 0.8
// 27/5/2021 13:46:58


package rs.ac.bg.etf.pp1.ast;

public class AddOper extends Addop {

    public AddOper () {
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
        buffer.append("AddOper(\n");

        buffer.append(tab);
        buffer.append(") [AddOper]");
        return buffer.toString();
    }
}
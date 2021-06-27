// generated with ast extension for cup
// version 0.8
// 27/5/2021 22:50:50


package rs.ac.bg.etf.pp1.ast;

public class BoolConstValue extends Value {

    private String constVal;

    public BoolConstValue (String constVal) {
        this.constVal=constVal;
    }

    public String getConstVal() {
        return constVal;
    }

    public void setConstVal(String constVal) {
        this.constVal=constVal;
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
        buffer.append("BoolConstValue(\n");

        buffer.append(" "+tab+constVal);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolConstValue]");
        return buffer.toString();
    }
}

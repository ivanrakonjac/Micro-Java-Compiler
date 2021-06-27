// generated with ast extension for cup
// version 0.8
// 27/5/2021 22:50:50


package rs.ac.bg.etf.pp1.ast;

public class SingleConstAssign extends Constant {

    private String constName;
    private Value Value;

    public SingleConstAssign (String constName, Value Value) {
        this.constName=constName;
        this.Value=Value;
        if(Value!=null) Value.setParent(this);
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public Value getValue() {
        return Value;
    }

    public void setValue(Value Value) {
        this.Value=Value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Value!=null) Value.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Value!=null) Value.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Value!=null) Value.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleConstAssign(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(Value!=null)
            buffer.append(Value.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleConstAssign]");
        return buffer.toString();
    }
}

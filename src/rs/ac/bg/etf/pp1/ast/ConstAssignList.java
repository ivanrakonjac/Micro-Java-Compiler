// generated with ast extension for cup
// version 0.8
// 29/5/2021 20:25:30


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignList extends ConstAssign {

    private ConstAssign ConstAssign;
    private Constant Constant;

    public ConstAssignList (ConstAssign ConstAssign, Constant Constant) {
        this.ConstAssign=ConstAssign;
        if(ConstAssign!=null) ConstAssign.setParent(this);
        this.Constant=Constant;
        if(Constant!=null) Constant.setParent(this);
    }

    public ConstAssign getConstAssign() {
        return ConstAssign;
    }

    public void setConstAssign(ConstAssign ConstAssign) {
        this.ConstAssign=ConstAssign;
    }

    public Constant getConstant() {
        return Constant;
    }

    public void setConstant(Constant Constant) {
        this.Constant=Constant;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstAssign!=null) ConstAssign.accept(visitor);
        if(Constant!=null) Constant.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstAssign!=null) ConstAssign.traverseTopDown(visitor);
        if(Constant!=null) Constant.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstAssign!=null) ConstAssign.traverseBottomUp(visitor);
        if(Constant!=null) Constant.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstAssignList(\n");

        if(ConstAssign!=null)
            buffer.append(ConstAssign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Constant!=null)
            buffer.append(Constant.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignList]");
        return buffer.toString();
    }
}

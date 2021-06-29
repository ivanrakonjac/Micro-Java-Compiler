// generated with ast extension for cup
// version 0.8
// 29/5/2021 20:25:30


package rs.ac.bg.etf.pp1.ast;

public class ConstParamDecl extends ParamDecl {

    private ParamDecl ParamDecl;
    private ConstDecl ConstDecl;

    public ConstParamDecl (ParamDecl ParamDecl, ConstDecl ConstDecl) {
        this.ParamDecl=ParamDecl;
        if(ParamDecl!=null) ParamDecl.setParent(this);
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
    }

    public ParamDecl getParamDecl() {
        return ParamDecl;
    }

    public void setParamDecl(ParamDecl ParamDecl) {
        this.ParamDecl=ParamDecl;
    }

    public ConstDecl getConstDecl() {
        return ConstDecl;
    }

    public void setConstDecl(ConstDecl ConstDecl) {
        this.ConstDecl=ConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ParamDecl!=null) ParamDecl.accept(visitor);
        if(ConstDecl!=null) ConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ParamDecl!=null) ParamDecl.traverseTopDown(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ParamDecl!=null) ParamDecl.traverseBottomUp(visitor);
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstParamDecl(\n");

        if(ParamDecl!=null)
            buffer.append(ParamDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstParamDecl]");
        return buffer.toString();
    }
}

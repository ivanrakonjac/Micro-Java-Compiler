// generated with ast extension for cup
// version 0.8
// 27/5/2021 13:46:57


package rs.ac.bg.etf.pp1.ast;

public class VarParamDecl extends ParamDecl {

    private ParamDecl ParamDecl;
    private VarDecl VarDecl;

    public VarParamDecl (ParamDecl ParamDecl, VarDecl VarDecl) {
        this.ParamDecl=ParamDecl;
        if(ParamDecl!=null) ParamDecl.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public ParamDecl getParamDecl() {
        return ParamDecl;
    }

    public void setParamDecl(ParamDecl ParamDecl) {
        this.ParamDecl=ParamDecl;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ParamDecl!=null) ParamDecl.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ParamDecl!=null) ParamDecl.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ParamDecl!=null) ParamDecl.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarParamDecl(\n");

        if(ParamDecl!=null)
            buffer.append(ParamDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarParamDecl]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 27/5/2021 13:46:57


package rs.ac.bg.etf.pp1.ast;

public class VarDeclArrayExt extends VarDeclExtension {

    private VarDeclExtension VarDeclExtension;
    private String varName;

    public VarDeclArrayExt (VarDeclExtension VarDeclExtension, String varName) {
        this.VarDeclExtension=VarDeclExtension;
        if(VarDeclExtension!=null) VarDeclExtension.setParent(this);
        this.varName=varName;
    }

    public VarDeclExtension getVarDeclExtension() {
        return VarDeclExtension;
    }

    public void setVarDeclExtension(VarDeclExtension VarDeclExtension) {
        this.VarDeclExtension=VarDeclExtension;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclExtension!=null) VarDeclExtension.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclExtension!=null) VarDeclExtension.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclExtension!=null) VarDeclExtension.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclArrayExt(\n");

        if(VarDeclExtension!=null)
            buffer.append(VarDeclExtension.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclArrayExt]");
        return buffer.toString();
    }
}

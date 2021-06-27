// generated with ast extension for cup
// version 0.8
// 27/5/2021 13:46:57


package rs.ac.bg.etf.pp1.ast;

public class VarDeclArray extends VarDecl {

    private Type Type;
    private String variableName;
    private VarDeclExtension VarDeclExtension;

    public VarDeclArray (Type Type, String variableName, VarDeclExtension VarDeclExtension) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.variableName=variableName;
        this.VarDeclExtension=VarDeclExtension;
        if(VarDeclExtension!=null) VarDeclExtension.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName=variableName;
    }

    public VarDeclExtension getVarDeclExtension() {
        return VarDeclExtension;
    }

    public void setVarDeclExtension(VarDeclExtension VarDeclExtension) {
        this.VarDeclExtension=VarDeclExtension;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarDeclExtension!=null) VarDeclExtension.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclExtension!=null) VarDeclExtension.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclExtension!=null) VarDeclExtension.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclArray(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+variableName);
        buffer.append("\n");

        if(VarDeclExtension!=null)
            buffer.append(VarDeclExtension.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclArray]");
        return buffer.toString();
    }
}

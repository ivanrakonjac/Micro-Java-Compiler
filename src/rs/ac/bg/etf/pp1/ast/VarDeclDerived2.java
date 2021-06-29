// generated with ast extension for cup
// version 0.8
// 29/5/2021 20:25:30


package rs.ac.bg.etf.pp1.ast;

public class VarDeclDerived2 extends VarDecl {

    public VarDeclDerived2 () {
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
        buffer.append("VarDeclDerived2(\n");

        buffer.append(tab);
        buffer.append(") [VarDeclDerived2]");
        return buffer.toString();
    }
}

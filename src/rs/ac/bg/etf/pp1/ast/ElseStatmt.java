// generated with ast extension for cup
// version 0.8
// 29/5/2021 20:25:30


package rs.ac.bg.etf.pp1.ast;

public class ElseStatmt extends ElseStmt {

    private ElseTerminal ElseTerminal;
    private Statement Statement;

    public ElseStatmt (ElseTerminal ElseTerminal, Statement Statement) {
        this.ElseTerminal=ElseTerminal;
        if(ElseTerminal!=null) ElseTerminal.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ElseTerminal getElseTerminal() {
        return ElseTerminal;
    }

    public void setElseTerminal(ElseTerminal ElseTerminal) {
        this.ElseTerminal=ElseTerminal;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ElseTerminal!=null) ElseTerminal.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ElseTerminal!=null) ElseTerminal.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ElseTerminal!=null) ElseTerminal.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ElseStatmt(\n");

        if(ElseTerminal!=null)
            buffer.append(ElseTerminal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ElseStatmt]");
        return buffer.toString();
    }
}

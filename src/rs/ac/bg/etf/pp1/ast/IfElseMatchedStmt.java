// generated with ast extension for cup
// version 0.8
// 29/5/2021 22:56:33


package rs.ac.bg.etf.pp1.ast;

public class IfElseMatchedStmt extends Statement {

    private IfStmt IfStmt;
    private Condition Condition;
    private Statement Statement;
    private ElseStmt ElseStmt;

    public IfElseMatchedStmt (IfStmt IfStmt, Condition Condition, Statement Statement, ElseStmt ElseStmt) {
        this.IfStmt=IfStmt;
        if(IfStmt!=null) IfStmt.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ElseStmt=ElseStmt;
        if(ElseStmt!=null) ElseStmt.setParent(this);
    }

    public IfStmt getIfStmt() {
        return IfStmt;
    }

    public void setIfStmt(IfStmt IfStmt) {
        this.IfStmt=IfStmt;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ElseStmt getElseStmt() {
        return ElseStmt;
    }

    public void setElseStmt(ElseStmt ElseStmt) {
        this.ElseStmt=ElseStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfStmt!=null) IfStmt.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(ElseStmt!=null) ElseStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfStmt!=null) IfStmt.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ElseStmt!=null) ElseStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfStmt!=null) IfStmt.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ElseStmt!=null) ElseStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfElseMatchedStmt(\n");

        if(IfStmt!=null)
            buffer.append(IfStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElseStmt!=null)
            buffer.append(ElseStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfElseMatchedStmt]");
        return buffer.toString();
    }
}

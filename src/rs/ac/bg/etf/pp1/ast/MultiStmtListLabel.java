// generated with ast extension for cup
// version 0.8
// 29/5/2021 20:25:30


package rs.ac.bg.etf.pp1.ast;

public class MultiStmtListLabel extends StmtList {

    private StmtList StmtList;
    private Label Label;
    private Statement Statement;

    public MultiStmtListLabel (StmtList StmtList, Label Label, Statement Statement) {
        this.StmtList=StmtList;
        if(StmtList!=null) StmtList.setParent(this);
        this.Label=Label;
        if(Label!=null) Label.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StmtList getStmtList() {
        return StmtList;
    }

    public void setStmtList(StmtList StmtList) {
        this.StmtList=StmtList;
    }

    public Label getLabel() {
        return Label;
    }

    public void setLabel(Label Label) {
        this.Label=Label;
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
        if(StmtList!=null) StmtList.accept(visitor);
        if(Label!=null) Label.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StmtList!=null) StmtList.traverseTopDown(visitor);
        if(Label!=null) Label.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StmtList!=null) StmtList.traverseBottomUp(visitor);
        if(Label!=null) Label.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiStmtListLabel(\n");

        if(StmtList!=null)
            buffer.append(StmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Label!=null)
            buffer.append(Label.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiStmtListLabel]");
        return buffer.toString();
    }
}

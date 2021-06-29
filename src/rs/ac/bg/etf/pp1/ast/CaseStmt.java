// generated with ast extension for cup
// version 0.8
// 29/5/2021 22:56:33


package rs.ac.bg.etf.pp1.ast;

public class CaseStmt implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private CaseLine CaseLine;
    private CaseColon CaseColon;
    private StmtList StmtList;

    public CaseStmt (CaseLine CaseLine, CaseColon CaseColon, StmtList StmtList) {
        this.CaseLine=CaseLine;
        if(CaseLine!=null) CaseLine.setParent(this);
        this.CaseColon=CaseColon;
        if(CaseColon!=null) CaseColon.setParent(this);
        this.StmtList=StmtList;
        if(StmtList!=null) StmtList.setParent(this);
    }

    public CaseLine getCaseLine() {
        return CaseLine;
    }

    public void setCaseLine(CaseLine CaseLine) {
        this.CaseLine=CaseLine;
    }

    public CaseColon getCaseColon() {
        return CaseColon;
    }

    public void setCaseColon(CaseColon CaseColon) {
        this.CaseColon=CaseColon;
    }

    public StmtList getStmtList() {
        return StmtList;
    }

    public void setStmtList(StmtList StmtList) {
        this.StmtList=StmtList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CaseLine!=null) CaseLine.accept(visitor);
        if(CaseColon!=null) CaseColon.accept(visitor);
        if(StmtList!=null) StmtList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CaseLine!=null) CaseLine.traverseTopDown(visitor);
        if(CaseColon!=null) CaseColon.traverseTopDown(visitor);
        if(StmtList!=null) StmtList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CaseLine!=null) CaseLine.traverseBottomUp(visitor);
        if(CaseColon!=null) CaseColon.traverseBottomUp(visitor);
        if(StmtList!=null) StmtList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CaseStmt(\n");

        if(CaseLine!=null)
            buffer.append(CaseLine.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CaseColon!=null)
            buffer.append(CaseColon.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StmtList!=null)
            buffer.append(StmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CaseStmt]");
        return buffer.toString();
    }
}

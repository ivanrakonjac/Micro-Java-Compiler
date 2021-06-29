// generated with ast extension for cup
// version 0.8
// 29/5/2021 22:56:33


package rs.ac.bg.etf.pp1.ast;

public class CaseesAndDef extends CasesAndDefault {

    private CaseList CaseList;
    private DefaultStmt DefaultStmt;
    private StmtList StmtList;

    public CaseesAndDef (CaseList CaseList, DefaultStmt DefaultStmt, StmtList StmtList) {
        this.CaseList=CaseList;
        if(CaseList!=null) CaseList.setParent(this);
        this.DefaultStmt=DefaultStmt;
        if(DefaultStmt!=null) DefaultStmt.setParent(this);
        this.StmtList=StmtList;
        if(StmtList!=null) StmtList.setParent(this);
    }

    public CaseList getCaseList() {
        return CaseList;
    }

    public void setCaseList(CaseList CaseList) {
        this.CaseList=CaseList;
    }

    public DefaultStmt getDefaultStmt() {
        return DefaultStmt;
    }

    public void setDefaultStmt(DefaultStmt DefaultStmt) {
        this.DefaultStmt=DefaultStmt;
    }

    public StmtList getStmtList() {
        return StmtList;
    }

    public void setStmtList(StmtList StmtList) {
        this.StmtList=StmtList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CaseList!=null) CaseList.accept(visitor);
        if(DefaultStmt!=null) DefaultStmt.accept(visitor);
        if(StmtList!=null) StmtList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CaseList!=null) CaseList.traverseTopDown(visitor);
        if(DefaultStmt!=null) DefaultStmt.traverseTopDown(visitor);
        if(StmtList!=null) StmtList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CaseList!=null) CaseList.traverseBottomUp(visitor);
        if(DefaultStmt!=null) DefaultStmt.traverseBottomUp(visitor);
        if(StmtList!=null) StmtList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CaseesAndDef(\n");

        if(CaseList!=null)
            buffer.append(CaseList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DefaultStmt!=null)
            buffer.append(DefaultStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StmtList!=null)
            buffer.append(StmtList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CaseesAndDef]");
        return buffer.toString();
    }
}

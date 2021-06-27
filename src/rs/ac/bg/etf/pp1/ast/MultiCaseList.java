// generated with ast extension for cup
// version 0.8
// 27/5/2021 13:46:58


package rs.ac.bg.etf.pp1.ast;

public class MultiCaseList extends CaseList {

    private CaseList CaseList;
    private CaseStmt CaseStmt;

    public MultiCaseList (CaseList CaseList, CaseStmt CaseStmt) {
        this.CaseList=CaseList;
        if(CaseList!=null) CaseList.setParent(this);
        this.CaseStmt=CaseStmt;
        if(CaseStmt!=null) CaseStmt.setParent(this);
    }

    public CaseList getCaseList() {
        return CaseList;
    }

    public void setCaseList(CaseList CaseList) {
        this.CaseList=CaseList;
    }

    public CaseStmt getCaseStmt() {
        return CaseStmt;
    }

    public void setCaseStmt(CaseStmt CaseStmt) {
        this.CaseStmt=CaseStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CaseList!=null) CaseList.accept(visitor);
        if(CaseStmt!=null) CaseStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CaseList!=null) CaseList.traverseTopDown(visitor);
        if(CaseStmt!=null) CaseStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CaseList!=null) CaseList.traverseBottomUp(visitor);
        if(CaseStmt!=null) CaseStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiCaseList(\n");

        if(CaseList!=null)
            buffer.append(CaseList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CaseStmt!=null)
            buffer.append(CaseStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiCaseList]");
        return buffer.toString();
    }
}

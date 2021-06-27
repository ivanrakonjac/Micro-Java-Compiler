// generated with ast extension for cup
// version 0.8
// 27/5/2021 22:50:50


package rs.ac.bg.etf.pp1.ast;

public class SwitchExp extends Expr {

    private SwitchExpr SwitchExpr;
    private Expr Expr;
    private CaseList CaseList;

    public SwitchExp (SwitchExpr SwitchExpr, Expr Expr, CaseList CaseList) {
        this.SwitchExpr=SwitchExpr;
        if(SwitchExpr!=null) SwitchExpr.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.CaseList=CaseList;
        if(CaseList!=null) CaseList.setParent(this);
    }

    public SwitchExpr getSwitchExpr() {
        return SwitchExpr;
    }

    public void setSwitchExpr(SwitchExpr SwitchExpr) {
        this.SwitchExpr=SwitchExpr;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public CaseList getCaseList() {
        return CaseList;
    }

    public void setCaseList(CaseList CaseList) {
        this.CaseList=CaseList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SwitchExpr!=null) SwitchExpr.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(CaseList!=null) CaseList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchExpr!=null) SwitchExpr.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(CaseList!=null) CaseList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchExpr!=null) SwitchExpr.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(CaseList!=null) CaseList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchExp(\n");

        if(SwitchExpr!=null)
            buffer.append(SwitchExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CaseList!=null)
            buffer.append(CaseList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchExp]");
        return buffer.toString();
    }
}

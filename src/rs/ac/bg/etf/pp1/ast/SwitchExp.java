// generated with ast extension for cup
// version 0.8
// 29/5/2021 20:25:30


package rs.ac.bg.etf.pp1.ast;

public class SwitchExp extends Expr {

    private SwitchExpr SwitchExpr;
    private Expr Expr;
    private CasesAndDefault CasesAndDefault;

    public SwitchExp (SwitchExpr SwitchExpr, Expr Expr, CasesAndDefault CasesAndDefault) {
        this.SwitchExpr=SwitchExpr;
        if(SwitchExpr!=null) SwitchExpr.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.CasesAndDefault=CasesAndDefault;
        if(CasesAndDefault!=null) CasesAndDefault.setParent(this);
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

    public CasesAndDefault getCasesAndDefault() {
        return CasesAndDefault;
    }

    public void setCasesAndDefault(CasesAndDefault CasesAndDefault) {
        this.CasesAndDefault=CasesAndDefault;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SwitchExpr!=null) SwitchExpr.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(CasesAndDefault!=null) CasesAndDefault.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchExpr!=null) SwitchExpr.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(CasesAndDefault!=null) CasesAndDefault.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchExpr!=null) SwitchExpr.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(CasesAndDefault!=null) CasesAndDefault.traverseBottomUp(visitor);
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

        if(CasesAndDefault!=null)
            buffer.append(CasesAndDefault.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchExp]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 27/5/2021 22:50:50


package rs.ac.bg.etf.pp1.ast;

public class FormParamss extends FormParams {

    private FormParams FormParams;
    private FormParamDecl FormParamDecl;

    public FormParamss (FormParams FormParams, FormParamDecl FormParamDecl) {
        this.FormParams=FormParams;
        if(FormParams!=null) FormParams.setParent(this);
        this.FormParamDecl=FormParamDecl;
        if(FormParamDecl!=null) FormParamDecl.setParent(this);
    }

    public FormParams getFormParams() {
        return FormParams;
    }

    public void setFormParams(FormParams FormParams) {
        this.FormParams=FormParams;
    }

    public FormParamDecl getFormParamDecl() {
        return FormParamDecl;
    }

    public void setFormParamDecl(FormParamDecl FormParamDecl) {
        this.FormParamDecl=FormParamDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParams!=null) FormParams.accept(visitor);
        if(FormParamDecl!=null) FormParamDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParams!=null) FormParams.traverseTopDown(visitor);
        if(FormParamDecl!=null) FormParamDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParams!=null) FormParams.traverseBottomUp(visitor);
        if(FormParamDecl!=null) FormParamDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParamss(\n");

        if(FormParams!=null)
            buffer.append(FormParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParamDecl!=null)
            buffer.append(FormParamDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParamss]");
        return buffer.toString();
    }
}

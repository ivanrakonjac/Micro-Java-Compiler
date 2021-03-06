// generated with ast extension for cup
// version 0.8
// 29/5/2021 22:56:34


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Mulop Mulop);
    public void visit(Constant Constant);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(CondTermList CondTermList);
    public void visit(MethodRetType MethodRetType);
    public void visit(ElseStmt ElseStmt);
    public void visit(FormParamDecl FormParamDecl);
    public void visit(Addop Addop);
    public void visit(CaseLine CaseLine);
    public void visit(Factor Factor);
    public void visit(CasesAndDefault CasesAndDefault);
    public void visit(CondFactList CondFactList);
    public void visit(Designator Designator);
    public void visit(Term Term);
    public void visit(CaseList CaseList);
    public void visit(Value Value);
    public void visit(FormParams FormParams);
    public void visit(ActualParams ActualParams);
    public void visit(StmtList StmtList);
    public void visit(OptionalFormPars OptionalFormPars);
    public void visit(VarDeclExtension VarDeclExtension);
    public void visit(ElseTerminal ElseTerminal);
    public void visit(VarDeclList VarDeclList);
    public void visit(Expr Expr);
    public void visit(YieldStatement YieldStatement);
    public void visit(ActPars ActPars);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(SwitchExpr SwitchExpr);
    public void visit(BasicExpr BasicExpr);
    public void visit(ConstAssign ConstAssign);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(DesignatorArrayName DesignatorArrayName);
    public void visit(CondFact CondFact);
    public void visit(CaseColon CaseColon);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(OptionalMinus OptionalMinus);
    public void visit(ParamDecl ParamDecl);
    public void visit(ModOper ModOper);
    public void visit(DivOper DivOper);
    public void visit(MulOper MulOper);
    public void visit(SubOper SubOper);
    public void visit(AddOper AddOper);
    public void visit(LessEqOper LessEqOper);
    public void visit(LessOper LessOper);
    public void visit(GreaterEqOper GreaterEqOper);
    public void visit(GreaterOper GreaterOper);
    public void visit(NotEqualsOper NotEqualsOper);
    public void visit(EqualsOper EqualsOper);
    public void visit(AssignOper AssignOper);
    public void visit(FactExpr FactExpr);
    public void visit(NewArray NewArray);
    public void visit(NewOp NewOp);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumberConst NumberConst);
    public void visit(FunctionCall FunctionCall);
    public void visit(Var Var);
    public void visit(YieldStatmnt YieldStatmnt);
    public void visit(DefaultStmt DefaultStmt);
    public void visit(CaseCol CaseCol);
    public void visit(SingleCaseLine SingleCaseLine);
    public void visit(CaseStmt CaseStmt);
    public void visit(NoCase NoCase);
    public void visit(MultiCaseList MultiCaseList);
    public void visit(CaseesAndDef CaseesAndDef);
    public void visit(SwitchTerm SwitchTerm);
    public void visit(OneParam OneParam);
    public void visit(MultipleParams MultipleParams);
    public void visit(NoActualParams NoActualParams);
    public void visit(ActualParamss ActualParamss);
    public void visit(Label Label);
    public void visit(NoStmt NoStmt);
    public void visit(MultiStmtListLabel MultiStmtListLabel);
    public void visit(MultiStmtList MultiStmtList);
    public void visit(ElseTerm ElseTerm);
    public void visit(NoElseStmt NoElseStmt);
    public void visit(ElseStatmt ElseStatmt);
    public void visit(CondRelop CondRelop);
    public void visit(CondExpr CondExpr);
    public void visit(CondTermSimple CondTermSimple);
    public void visit(AndCond AndCond);
    public void visit(FactorTerm FactorTerm);
    public void visit(MulopTerm MulopTerm);
    public void visit(CondTerm CondTerm);
    public void visit(CondSimple CondSimple);
    public void visit(OrCond OrCond);
    public void visit(Condition Condition);
    public void visit(DoStmt DoStmt);
    public void visit(NoMinus NoMinus);
    public void visit(Minus Minus);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(SwitchExp SwitchExp);
    public void visit(BasicExprr BasicExprr);
    public void visit(DesArrName DesArrName);
    public void visit(DesignatorArray DesignatorArray);
    public void visit(DesignatorBasic DesignatorBasic);
    public void visit(VariableDec VariableDec);
    public void visit(VariableInc VariableInc);
    public void visit(ProcCall ProcCall);
    public void visit(DesignatorAssign DesignatorAssign);
    public void visit(IfStmt IfStmt);
    public void visit(GotoStmt GotoStmt);
    public void visit(BasicStmt BasicStmt);
    public void visit(PrintExprStmt PrintExprStmt);
    public void visit(PrintStmt PrintStmt);
    public void visit(ReadStmt ReadStmt);
    public void visit(ReturnNoValStmt ReturnNoValStmt);
    public void visit(ReturnStmt ReturnStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(YieldStmt YieldStmt);
    public void visit(DoWhileStmt DoWhileStmt);
    public void visit(IfElseMatchedStmt IfElseMatchedStmt);
    public void visit(DesignStmt DesignStmt);
    public void visit(Type Type);
    public void visit(FormParamArray FormParamArray);
    public void visit(FormParam FormParam);
    public void visit(NoFormParams NoFormParams);
    public void visit(FormParamss FormParamss);
    public void visit(VoidRetType VoidRetType);
    public void visit(MethodReturnType MethodReturnType);
    public void visit(NoFormPars NoFormPars);
    public void visit(OptionalFormalParams OptionalFormalParams);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(MethodDecl MethodDecl);
    public void visit(NoMethodDeclarations NoMethodDeclarations);
    public void visit(MethodDeclarationList MethodDeclarationList);
    public void visit(NoVarDecl NoVarDecl);
    public void visit(VarDeclarationList VarDeclarationList);
    public void visit(NoVarDeclMore NoVarDeclMore);
    public void visit(VarDeclArrayExt VarDeclArrayExt);
    public void visit(VarDeclExt VarDeclExt);
    public void visit(VarDeclDerived2 VarDeclDerived2);
    public void visit(VarDeclDerived1 VarDeclDerived1);
    public void visit(VarDeclArray VarDeclArray);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(BoolConstValue BoolConstValue);
    public void visit(CharConstValue CharConstValue);
    public void visit(NumConstValue NumConstValue);
    public void visit(SingleConstAssign SingleConstAssign);
    public void visit(OneConstAssign OneConstAssign);
    public void visit(ConstAssignList ConstAssignList);
    public void visit(ConstDecl ConstDecl);
    public void visit(ProgramName ProgramName);
    public void visit(NoParamDecl NoParamDecl);
    public void visit(VarParamDecl VarParamDecl);
    public void visit(ConstParamDecl ConstParamDecl);
    public void visit(Program Program);

}

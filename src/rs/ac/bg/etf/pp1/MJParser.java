
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Tue Jun 01 21:33:45 CEST 2021
//----------------------------------------------------

package rs.ac.bg.etf.pp1;

import java_cup.runtime.*;
import org.apache.log4j.*;
import rs.ac.bg.etf.pp1.ast.*;

/** CUP v0.10k generated parser.
  * @version Tue Jun 01 21:33:45 CEST 2021
  */
public class MJParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public MJParser() {super();}

  /** Constructor which sets the default scanner. */
  public MJParser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\040\000\002\003\010\000\002\002\004\000\002\005" +
    "\004\000\002\005\002\000\002\006\005\000\002\013\004" +
    "\000\002\013\002\000\002\007\013\000\002\010\003\000" +
    "\002\010\002\000\002\011\005\000\002\011\003\000\002" +
    "\012\004\000\002\004\003\000\002\022\004\000\002\022" +
    "\002\000\002\014\006\000\002\014\007\000\002\014\005" +
    "\000\002\014\004\000\002\016\005\000\002\016\003\000" +
    "\002\020\003\000\002\021\003\000\002\021\003\000\002" +
    "\021\006\000\002\023\003\000\002\023\002\000\002\024" +
    "\005\000\002\024\003\000\002\015\003\000\002\017\003" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\073\000\004\016\005\001\002\000\004\002\075\001" +
    "\002\000\004\021\006\001\002\000\006\017\ufffe\021\ufffe" +
    "\001\002\000\006\017\010\021\013\001\002\000\006\020" +
    "\ufffb\021\ufffb\001\002\000\004\021\014\001\002\000\006" +
    "\017\uffff\021\uffff\001\002\000\004\021\ufff4\001\002\000" +
    "\004\012\015\001\002\000\006\017\ufffd\021\ufffd\001\002" +
    "\000\006\020\020\021\013\001\002\000\004\021\022\001" +
    "\002\000\004\002\001\001\002\000\006\020\ufffc\021\ufffc" +
    "\001\002\000\004\013\023\001\002\000\006\014\ufff8\021" +
    "\013\001\002\000\004\021\074\001\002\000\006\011\072" +
    "\014\ufff9\001\002\000\004\014\030\001\002\000\006\011" +
    "\ufff6\014\ufff6\001\002\000\006\017\ufffe\021\ufffe\001\002" +
    "\000\006\017\032\021\013\001\002\000\012\004\ufff2\005" +
    "\ufff2\020\ufff2\021\ufff2\001\002\000\012\004\034\005\035" +
    "\020\037\021\041\001\002\000\004\013\066\001\002\000" +
    "\010\006\046\012\064\021\041\001\002\000\012\004\ufff3" +
    "\005\ufff3\020\ufff3\021\ufff3\001\002\000\006\020\ufffa\021" +
    "\ufffa\001\002\000\004\010\042\001\002\000\016\007\uffe3" +
    "\010\uffe3\011\uffe3\012\uffe3\013\uffe3\014\uffe3\001\002\000" +
    "\006\006\046\021\041\001\002\000\012\007\uffeb\011\uffeb" +
    "\012\uffeb\014\uffeb\001\002\000\012\007\uffec\011\uffec\012" +
    "\uffec\014\uffec\001\002\000\006\007\056\012\062\001\002" +
    "\000\012\007\uffea\011\uffea\012\uffea\014\uffea\001\002\000" +
    "\014\007\uffe9\011\uffe9\012\uffe9\013\050\014\uffe9\001\002" +
    "\000\010\006\046\014\uffe6\021\041\001\002\000\004\014" +
    "\061\001\002\000\010\007\056\011\uffe4\014\uffe4\001\002" +
    "\000\006\011\054\014\uffe7\001\002\000\006\006\046\021" +
    "\041\001\002\000\010\007\056\011\uffe5\014\uffe5\001\002" +
    "\000\006\006\uffe2\021\uffe2\001\002\000\006\006\046\021" +
    "\041\001\002\000\012\007\uffed\011\uffed\012\uffed\014\uffed" +
    "\001\002\000\012\007\uffe8\011\uffe8\012\uffe8\014\uffe8\001" +
    "\002\000\012\004\ufff1\005\ufff1\020\ufff1\021\ufff1\001\002" +
    "\000\006\007\056\012\065\001\002\000\012\004\uffee\005" +
    "\uffee\020\uffee\021\uffee\001\002\000\012\004\uffef\005\uffef" +
    "\020\uffef\021\uffef\001\002\000\006\006\046\021\041\001" +
    "\002\000\006\007\056\014\070\001\002\000\004\012\071" +
    "\001\002\000\012\004\ufff0\005\ufff0\020\ufff0\021\ufff0\001" +
    "\002\000\004\021\013\001\002\000\006\011\ufff7\014\ufff7" +
    "\001\002\000\006\011\ufff5\014\ufff5\001\002\000\004\002" +
    "\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\073\000\004\003\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\005\006\001\001\000\006\004\010" +
    "\006\011\001\001\000\004\013\015\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\004\016\007\020\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\012\004\023\010\025\011\024\012\026\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\005\030\001\001\000\006\004" +
    "\010\006\011\001\001\000\004\022\032\001\001\000\006" +
    "\014\035\015\037\001\001\000\002\001\001\000\012\015" +
    "\046\016\062\020\043\021\042\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\012\015\046\016\044\020\043\021\042\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\017\056\001\001\000" +
    "\002\001\001\000\002\001\001\000\016\015\046\016\051" +
    "\020\043\021\042\023\050\024\052\001\001\000\002\001" +
    "\001\000\004\017\056\001\001\000\002\001\001\000\012" +
    "\015\046\016\054\020\043\021\042\001\001\000\004\017" +
    "\056\001\001\000\002\001\001\000\010\015\046\020\057" +
    "\021\042\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\017\056\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\015\046\016\066\020\043\021" +
    "\042\001\001\000\004\017\056\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\004\023\012\072\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$MJParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$MJParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$MJParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {

	Symbol s = this.getScanner().next_token();
	if (s != null && s.value != null) 
		log.info(s.toString() + " " + s.value.toString());
	return s;

    }



	Logger log = Logger.getLogger(getClass());
   
   
    // slede redefinisani metodi za prijavu gresaka radi izmene teksta poruke
     
    public void report_fatal_error(String message, Object info) throws java.lang.Exception {
      done_parsing();
      report_error(message, info);
    }
  
    public void syntax_error(Symbol cur_token) {
        report_error("\nSintaksna greska", cur_token);
    }
  
    public void unrecovered_syntax_error(Symbol cur_token) throws java.lang.Exception {
        report_fatal_error("Fatalna greska, parsiranje se ne moze nastaviti", cur_token);
    }

    public void report_error(String message, Object info) {
    	StringBuilder msg = new StringBuilder(message); 
    	if (info instanceof Symbol)
            msg.append (" na liniji ").append(((Symbol)info).left);
        log.error(msg.toString());
    }



}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$MJParser$actions {
  private final MJParser parser;

  /** Constructor */
  CUP$MJParser$actions(MJParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$MJParser$do_action(
    int                        CUP$MJParser$act_num,
    java_cup.runtime.lr_parser CUP$MJParser$parser,
    java.util.Stack            CUP$MJParser$stack,
    int                        CUP$MJParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$MJParser$result;

      /* select the action based on the action number */
      switch (CUP$MJParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // Addop ::= PLUS 
            {
              Addop RESULT = null;
		 RESULT=new Addop(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(13/*Addop*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // Designator ::= IDENT 
            {
              Designator RESULT = null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new Designator(name); RESULT.setLine(nameleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(11/*Designator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // ActualParamList ::= Expr 
            {
              ActualParamList RESULT = null;
		int E1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int E1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Expr E1 = (Expr)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new ActualParam(E1); RESULT.setLine(E1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(18/*ActualParamList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // ActualParamList ::= ActualParamList COMMA Expr 
            {
              ActualParamList RESULT = null;
		int A1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left;
		int A1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).right;
		ActualParamList A1 = (ActualParamList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).value;
		int E2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int E2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Expr E2 = (Expr)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new ActualParams(A1, E2); RESULT.setLine(A1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(18/*ActualParamList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // ActualPars ::= 
            {
              ActualPars RESULT = null;
		 RESULT=new NoActuals(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(17/*ActualPars*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // ActualPars ::= ActualParamList 
            {
              ActualPars RESULT = null;
		int A1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int A1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		ActualParamList A1 = (ActualParamList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new Actuals(A1); RESULT.setLine(A1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(17/*ActualPars*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // Factor ::= Designator LPAREN ActualPars RPAREN 
            {
              Factor RESULT = null;
		int funcleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left;
		int funcright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).right;
		Designator func = (Designator)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).value;
		int A1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int A1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		ActualPars A1 = (ActualPars)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new FuncCall(func, A1); RESULT.setLine(funcleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(15/*Factor*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // Factor ::= Designator 
            {
              Factor RESULT = null;
		int dleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Designator d = (Designator)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new Var(d); RESULT.setLine(dleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(15/*Factor*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // Factor ::= NUMBER 
            {
              Factor RESULT = null;
		 RESULT=new Const(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(15/*Factor*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // Term ::= Factor 
            {
              Term RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Factor t = (Factor)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new Term(t); RESULT.setLine(tleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(14/*Term*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // Expr ::= Term 
            {
              Expr RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Term t = (Term)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new TermExpr(t); RESULT.setLine(tleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(12/*Expr*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // Expr ::= Expr Addop Term 
            {
              Expr RESULT = null;
		int teleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left;
		int teright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).right;
		Expr te = (Expr)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).value;
		int A1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int A1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		Addop A1 = (Addop)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Term t = (Term)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new AddExpr(te, A1, t); RESULT.setLine(teleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(12/*Expr*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // Statement ::= RETURN SEMI 
            {
              Statement RESULT = null;
		 RESULT=new ReturnNoExpr(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*Statement*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // Statement ::= RETURN Expr SEMI 
            {
              Statement RESULT = null;
		int tleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		Expr t = (Expr)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new ReturnExpr(t); RESULT.setLine(tleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*Statement*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // Statement ::= PRINT LPAREN Expr RPAREN SEMI 
            {
              Statement RESULT = null;
		int E1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left;
		int E1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).right;
		Expr E1 = (Expr)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).value;
		 RESULT=new PrintStmt(E1); RESULT.setLine(E1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*Statement*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // Statement ::= Designator EQUAL Expr SEMI 
            {
              Statement RESULT = null;
		int destleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left;
		int destright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).right;
		Designator dest = (Designator)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		Expr e = (Expr)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new Assignment(dest, e); RESULT.setLine(destleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*Statement*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // StatementList ::= 
            {
              StatementList RESULT = null;
		 RESULT=new NoStmt(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(16/*StatementList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // StatementList ::= StatementList Statement 
            {
              StatementList RESULT = null;
		int S1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int S1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		StatementList S1 = (StatementList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		int S2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int S2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		Statement S2 = (Statement)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new Statements(S1, S2); RESULT.setLine(S1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(16/*StatementList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // Type ::= IDENT 
            {
              Type RESULT = null;
		int typeNameleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int typeNameright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		String typeName = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new Type(typeName); RESULT.setLine(typeNameleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(2/*Type*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // FormalParamDecl ::= Type IDENT 
            {
              FormalParamDecl RESULT = null;
		int varTypeleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int varTyperight = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		Type varType = (Type)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		int varNameleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int varNameright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		String varName = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new FormalParamDecl(varType, varName); RESULT.setLine(varTypeleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(8/*FormalParamDecl*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // FormalParamList ::= FormalParamDecl 
            {
              FormalParamList RESULT = null;
		int F1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int F1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		FormalParamDecl F1 = (FormalParamDecl)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new SingleFormalParamDecl(F1); RESULT.setLine(F1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(7/*FormalParamList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // FormalParamList ::= FormalParamList COMMA FormalParamDecl 
            {
              FormalParamList RESULT = null;
		int F1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left;
		int F1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).right;
		FormalParamList F1 = (FormalParamList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).value;
		int F2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int F2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		FormalParamDecl F2 = (FormalParamDecl)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new FormalParamDecls(F1, F2); RESULT.setLine(F1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(7/*FormalParamList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // FormPars ::= 
            {
              FormPars RESULT = null;
		 RESULT=new NoFormParam(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(6/*FormPars*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // FormPars ::= FormalParamList 
            {
              FormPars RESULT = null;
		int F1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int F1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		FormalParamList F1 = (FormalParamList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new FormParams(F1); RESULT.setLine(F1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(6/*FormPars*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // MethodDecl ::= Type IDENT LPAREN FormPars RPAREN VarDeclList LBRACE StatementList RBRACE 
            {
              MethodDecl RESULT = null;
		int retTypeleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-8)).left;
		int retTyperight = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-8)).right;
		Type retType = (Type)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-8)).value;
		int methNameleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-7)).left;
		int methNameright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-7)).right;
		String methName = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-7)).value;
		int F1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-5)).left;
		int F1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-5)).right;
		FormPars F1 = (FormPars)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-5)).value;
		int V2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left;
		int V2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).right;
		VarDeclList V2 = (VarDeclList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).value;
		int S3left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int S3right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		StatementList S3 = (StatementList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new MethodDecl(retType, methName, F1, V2, S3); RESULT.setLine(retTypeleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(5/*MethodDecl*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-8)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // MethodDeclList ::= 
            {
              MethodDeclList RESULT = null;
		 RESULT=new NoMethodDecl(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(9/*MethodDeclList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // MethodDeclList ::= MethodDeclList MethodDecl 
            {
              MethodDeclList RESULT = null;
		int M1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int M1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		MethodDeclList M1 = (MethodDeclList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		int M2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int M2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		MethodDecl M2 = (MethodDecl)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new MethodDeclarations(M1, M2); RESULT.setLine(M1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(9/*MethodDeclList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // VarDecl ::= Type IDENT SEMI 
            {
              VarDecl RESULT = null;
		int varTypeleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left;
		int varTyperight = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).right;
		Type varType = (Type)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).value;
		int varNameleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int varNameright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		String varName = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new VarDecl(varType, varName); RESULT.setLine(varTypeleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(4/*VarDecl*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-2)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // VarDeclList ::= 
            {
              VarDeclList RESULT = null;
		 RESULT=new NoVarDecl(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*VarDeclList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // VarDeclList ::= VarDeclList VarDecl 
            {
              VarDeclList RESULT = null;
		int V1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int V1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		VarDeclList V1 = (VarDeclList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		int V2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int V2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		VarDecl V2 = (VarDecl)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new VarDeclarations(V1, V2); RESULT.setLine(V1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*VarDeclList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= Program EOF 
            {
              SyntaxNode RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		Program start_val = (Program)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		RESULT = start_val;
              CUP$MJParser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$MJParser$parser.done_parsing();
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // Program ::= PROG IDENT VarDeclList LBRACE MethodDeclList RBRACE 
            {
              Program RESULT = null;
		int I1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).left;
		int I1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).right;
		String I1 = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).value;
		int V2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left;
		int V2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).right;
		VarDeclList V2 = (VarDeclList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).value;
		int M3left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int M3right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		MethodDeclList M3 = (MethodDeclList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new Program(I1, V2, M3); RESULT.setLine(I1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(1/*Program*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-5)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}


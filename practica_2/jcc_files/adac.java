/* Generated By:JavaCC: Do not edit this line. adac.java */
package traductor;


import java.lang.reflect.Field;
public class adac implements adacConstants {
    public static void main(String[] args) {
        adac parser;

        try {
                if(args.length == 0) { //entrada desde stdin
                                parser = new adac(System.in);
                        }
                        else { //entrada desde fichero en args[0]
                    parser = new adac(new java.io.FileInputStream(args[0]));
                        }
                        parser.S(); //invoca símbolo inicial de la gramática
                }
                catch (java.io.FileNotFoundException e) {
                        System.err.println ("Fichero " + args[0] + " no encontrado.");
                }
                catch (TokenMgrError e) {
                System.err.println("LEX_ERROR: " + e.getMessage());
        }
        catch (ParseException e) {
                System.err.println("SINT_ERROR: " + e.getMessage());
        }
    }

//GENERAL
  static final public void S() throws ParseException {
    label_1:
    while (true) {
      instruccion();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tBOOL:
      case tCHAR:
      case tINT:
      case tIF:
      case tPROCEDURE:
      case tFUNCTION:
      case tID:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
  }

  static final public void instruccion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tID:
      inst_asig();
      jj_consume_token(tPCOMA);
      break;
    case tPROCEDURE:
    case tFUNCTION:
      inst_declaracion_metodo();
      break;
    case tBOOL:
    case tCHAR:
    case tINT:
      inst_declaracion_variable();
      jj_consume_token(tPCOMA);
      break;
    case tIF:
      inst_seleccion();
      jj_consume_token(tEND);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//DECLARACION VARIABLES
  static final public void inst_declaracion_variable() throws ParseException {
    tipos();
    jj_consume_token(tID);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tCOMA:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(tCOMA);
      jj_consume_token(tID);
    }
  }

//DECLARACION METODO
  static final public void inst_declaracion_metodo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tPROCEDURE:
      inst_declaracion_proc();
      break;
    case tFUNCTION:
      inst_declaracion_func();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    declaracion_variables();
    jj_consume_token(tBEGIN);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tID:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      instruccion_en_metodo();
    }
    jj_consume_token(tEND);
  }

  static final public void instruccion_en_metodo() throws ParseException {
    inst_asig();
    jj_consume_token(tPCOMA);
  }

  static final public void declaracion_variables() throws ParseException {
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tBOOL:
      case tCHAR:
      case tINT:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      inst_declaracion_variable();
      jj_consume_token(tPCOMA);
    }
  }

//FUNCION
  static final public void inst_declaracion_func() throws ParseException {
    jj_consume_token(tFUNCTION);
    jj_consume_token(tID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tPOPEN:
      argumentos();
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    jj_consume_token(tIS);
  }

//PROCEDIMIENTO
  static final public void inst_declaracion_proc() throws ParseException {
    jj_consume_token(tPROCEDURE);
    jj_consume_token(tID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tPOPEN:
      argumentos();
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    jj_consume_token(tIS);
  }

  static final public void inst_seleccion() throws ParseException {
    jj_consume_token(tIF);
    expr();
    jj_consume_token(tTHEN);
    instruccion();
    masIf();
  }

  static final public void masIf() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tELSE:
      jj_consume_token(tELSE);
      instruccion();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
  }

// Regla relativa a los argumentos que se le pasa a una función
  static final public void argumentos() throws ParseException {
    jj_consume_token(tPOPEN);
    label_5:
    while (true) {
      list_params();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tREF:
      case tVAL:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
    }
    jj_consume_token(tPCLOSE);
  }

  static final public void list_params() throws ParseException {
    parametro();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tCOMA:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      jj_consume_token(tCOMA);
      parametro();
    }
  }

  static final public void parametro() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tREF:
      jj_consume_token(tREF);
      tipos();
      jj_consume_token(tID);
      break;
    case tVAL:
      jj_consume_token(tVAL);
      tipos();
      jj_consume_token(tID);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void tipos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tINT:
      jj_consume_token(tINT);
      break;
    case tCHAR:
      jj_consume_token(tCHAR);
      break;
    case tBOOL:
      jj_consume_token(tBOOL);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//ASIGNACIONES
  static final public void inst_asig() throws ParseException {
    asignable();
    jj_consume_token(tASIGNACION);
    expr();
  }

  static final public void asignable() throws ParseException {
    if (jj_2_1(2)) {
      jj_consume_token(tID);
      jj_consume_token(tCOPEN);
      expr();
      jj_consume_token(tCCLOSE);
    } else if (jj_2_2(2)) {
      jj_consume_token(tID);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void expr() throws ParseException {
    factor();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case tSUMA:
      case tRESTA:
      case tMUL:
      case tDIV:
      case tMENOR:
      case tMAYOR:
      case tMENORI:
      case tMAYORI:
      case tIGUAL:
      case tOR:
      case tAND:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_7;
      }
      operador();
      factor();
    }
  }

  static final public void operador() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tSUMA:
      jj_consume_token(tSUMA);
      break;
    case tRESTA:
      jj_consume_token(tRESTA);
      break;
    case tMUL:
      jj_consume_token(tMUL);
      break;
    case tDIV:
      jj_consume_token(tDIV);
      break;
    case tOR:
      jj_consume_token(tOR);
      break;
    case tAND:
      jj_consume_token(tAND);
      break;
    case tIGUAL:
      jj_consume_token(tIGUAL);
      break;
    case tMAYOR:
      jj_consume_token(tMAYOR);
      break;
    case tMAYORI:
      jj_consume_token(tMAYORI);
      break;
    case tMENOR:
      jj_consume_token(tMENOR);
      break;
    case tMENORI:
      jj_consume_token(tMENORI);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void factor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case tNUM:
      jj_consume_token(tNUM);
      break;
    case tCAD:
      jj_consume_token(tCAD);
      break;
    default:
      jj_la1[15] = jj_gen;
      if (jj_2_3(2)) {
        jj_consume_token(tID);
        jj_consume_token(tCOPEN);
        expr();
        jj_consume_token(tCCLOSE);
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case tID:
          jj_consume_token(tID);
          break;
        case tPOPEN:
          jj_consume_token(tPOPEN);
          expr();
          jj_consume_token(tPCLOSE);
          break;
        case tNOT:
          jj_consume_token(tNOT);
          factor();
          break;
        default:
          jj_la1[16] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_3_3() {
    if (jj_scan_token(tID)) return true;
    if (jj_scan_token(tCOPEN)) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_scan_token(tID)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_scan_token(tID)) return true;
    if (jj_scan_token(tCOPEN)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public adacTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  /** Whether we are looking ahead. */
  static private boolean jj_lookingAhead = false;
  static private boolean jj_semLA;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[17];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x6780,0x6780,0x10000000,0x6000,0x0,0x380,0x0,0x0,0x800,0x0,0x10000000,0x0,0x380,0xcf000000,0xcf000000,0xc00000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x10000,0x10000,0x0,0x0,0x10000,0x0,0x20,0x20,0x0,0xc000,0x0,0xc000,0x0,0x607,0x607,0x0,0x10820,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[3];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public adac(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public adac(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new adacTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public adac(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new adacTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public adac(adacTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(adacTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = jj_lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[50];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 17; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 50; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 3; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}

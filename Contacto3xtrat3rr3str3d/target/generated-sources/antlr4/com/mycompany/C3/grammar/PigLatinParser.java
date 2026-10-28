// Generated from com/mycompany/C3/grammar/PigLatinParser.g4 by ANTLR 4.13.2
package com.mycompany.C3.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PigLatinParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMENTARIO_BLOQUE=1, COMENTARIO_LINEA=2, WS=3, IMPORT=4, SEC_VARIABLES=5, 
		SEC_PRINCIPAL=6, FIN_PROGRAMA=7, ESTO=8, SERIES=9, NUMERUS=10, TEXTUM=11, 
		DECIMALIS=12, LITTERA=13, BOOL=14, NOVUS=15, VERUM=16, FALSUS=17, NULO=18, 
		SI=19, ALITER=20, FINIS=21, DUM=22, FACERE=23, PER=24, PERGE=25, INTERRUMPE=26, 
		IMPRIMIR=27, LEER=28, INCREMENTO=29, DECREMENTO=30, IGUAL_IGUAL=31, DIFERENTE=32, 
		MENOR_IGUAL=33, MAYOR_IGUAL=34, MENOR=35, MAYOR=36, AND=37, OR=38, NOT=39, 
		MAS=40, MENOS=41, MULT=42, DIV=43, MOD=44, IGUAL=45, PAR_IZQ=46, PAR_DER=47, 
		COR_IZQ=48, COR_DER=49, LLA_IZQ=50, LLA_DER=51, PUNTO=52, COMA=53, DOSPUNTOS=54, 
		PUNTO_COMA=55, DECIMAL_LIT=56, ENTERO_LIT=57, CADENA_LIT=58, CARACTER_LIT=59, 
		ID=60, ERROR_CHAR=61;
	public static final int
		RULE_programa = 0, RULE_importacion = 1, RULE_ruta = 2, RULE_seccionVariables = 3, 
		RULE_seccionPrincipal = 4, RULE_declaracion = 5, RULE_declaracionSimple = 6, 
		RULE_valorInferido = 7, RULE_dimension = 8, RULE_valor = 9, RULE_inicializadorLista = 10, 
		RULE_bloque = 11, RULE_sentencia = 12, RULE_aliterSi = 13, RULE_aliter = 14, 
		RULE_asignacion = 15, RULE_perInicio = 16, RULE_perActualizacion = 17, 
		RULE_acceso = 18, RULE_inicioAcceso = 19, RULE_sufijo = 20, RULE_objetoNuevo = 21, 
		RULE_argumentos = 22, RULE_expr = 23, RULE_literal = 24, RULE_tipo = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "importacion", "ruta", "seccionVariables", "seccionPrincipal", 
			"declaracion", "declaracionSimple", "valorInferido", "dimension", "valor", 
			"inicializadorLista", "bloque", "sentencia", "aliterSi", "aliter", "asignacion", 
			"perInicio", "perActualizacion", "acceso", "inicioAcceso", "sufijo", 
			"objetoNuevo", "argumentos", "expr", "literal", "tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'import'", null, null, "'FINIS'", "'esto'", 
			"'series'", "'numerus'", "'textum'", "'decimalis'", "'littera'", "'bool'", 
			"'novus'", "'verum'", "'falsus'", "'null'", "'si'", "'aliter'", "'finis'", 
			"'dum'", "'facere'", "'per'", "'perge'", "'interrumpe'", "'>>'", "'<<'", 
			"'++'", "'--'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", "'&&'", 
			"'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'.'", "','", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMENTARIO_BLOQUE", "COMENTARIO_LINEA", "WS", "IMPORT", "SEC_VARIABLES", 
			"SEC_PRINCIPAL", "FIN_PROGRAMA", "ESTO", "SERIES", "NUMERUS", "TEXTUM", 
			"DECIMALIS", "LITTERA", "BOOL", "NOVUS", "VERUM", "FALSUS", "NULO", "SI", 
			"ALITER", "FINIS", "DUM", "FACERE", "PER", "PERGE", "INTERRUMPE", "IMPRIMIR", 
			"LEER", "INCREMENTO", "DECREMENTO", "IGUAL_IGUAL", "DIFERENTE", "MENOR_IGUAL", 
			"MAYOR_IGUAL", "MENOR", "MAYOR", "AND", "OR", "NOT", "MAS", "MENOS", 
			"MULT", "DIV", "MOD", "IGUAL", "PAR_IZQ", "PAR_DER", "COR_IZQ", "COR_DER", 
			"LLA_IZQ", "LLA_DER", "PUNTO", "COMA", "DOSPUNTOS", "PUNTO_COMA", "DECIMAL_LIT", 
			"ENTERO_LIT", "CADENA_LIT", "CARACTER_LIT", "ID", "ERROR_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PigLatinParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PigLatinParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public SeccionPrincipalContext seccionPrincipal() {
			return getRuleContext(SeccionPrincipalContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PigLatinParser.EOF, 0); }
		public List<ImportacionContext> importacion() {
			return getRuleContexts(ImportacionContext.class);
		}
		public ImportacionContext importacion(int i) {
			return getRuleContext(ImportacionContext.class,i);
		}
		public SeccionVariablesContext seccionVariables() {
			return getRuleContext(SeccionVariablesContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(52);
				importacion();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEC_VARIABLES) {
				{
				setState(58);
				seccionVariables();
				}
			}

			setState(61);
			seccionPrincipal();
			setState(62);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportacionContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(PigLatinParser.IMPORT, 0); }
		public RutaContext ruta() {
			return getRuleContext(RutaContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public ImportacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterImportacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitImportacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitImportacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportacionContext importacion() throws RecognitionException {
		ImportacionContext _localctx = new ImportacionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(IMPORT);
			setState(65);
			ruta();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_COMA) {
				{
				setState(66);
				match(PUNTO_COMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RutaContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParser.ID, i);
		}
		public List<TerminalNode> PUNTO() { return getTokens(PigLatinParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(PigLatinParser.PUNTO, i);
		}
		public RutaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterRuta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitRuta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitRuta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RutaContext ruta() throws RecognitionException {
		RutaContext _localctx = new RutaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ruta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(ID);
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				match(PUNTO);
				setState(71);
				match(ID);
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PUNTO );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionVariablesContext extends ParserRuleContext {
		public TerminalNode SEC_VARIABLES() { return getToken(PigLatinParser.SEC_VARIABLES, 0); }
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public SeccionVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSeccionVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSeccionVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSeccionVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionVariablesContext seccionVariables() throws RecognitionException {
		SeccionVariablesContext _localctx = new SeccionVariablesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_seccionVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(SEC_VARIABLES);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESTO || _la==SERIES) {
				{
				{
				setState(77);
				declaracion();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionPrincipalContext extends ParserRuleContext {
		public TerminalNode SEC_PRINCIPAL() { return getToken(PigLatinParser.SEC_PRINCIPAL, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public TerminalNode FIN_PROGRAMA() { return getToken(PigLatinParser.FIN_PROGRAMA, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SeccionPrincipalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionPrincipal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSeccionPrincipal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSeccionPrincipal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSeccionPrincipal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionPrincipalContext seccionPrincipal() throws RecognitionException {
		SeccionPrincipalContext _localctx = new SeccionPrincipalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_seccionPrincipal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(SEC_PRINCIPAL);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152921505140048640L) != 0)) {
				{
				{
				setState(84);
				sentencia();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FIN_PROGRAMA) {
				{
				setState(90);
				match(FIN_PROGRAMA);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(91);
					match(PUNTO_COMA);
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionSimpleContext declaracionSimple() {
			return getRuleContext(DeclaracionSimpleContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			declaracionSimple();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_COMA) {
				{
				setState(97);
				match(PUNTO_COMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionSimpleContext extends ParserRuleContext {
		public DeclaracionSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionSimple; }
	 
		public DeclaracionSimpleContext() { }
		public void copyFrom(DeclaracionSimpleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclArregloContext extends DeclaracionSimpleContext {
		public TerminalNode SERIES() { return getToken(PigLatinParser.SERIES, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<DimensionContext> dimension() {
			return getRuleContexts(DimensionContext.class);
		}
		public DimensionContext dimension(int i) {
			return getRuleContext(DimensionContext.class,i);
		}
		public InicializadorListaContext inicializadorLista() {
			return getRuleContext(InicializadorListaContext.class,0);
		}
		public DeclArregloContext(DeclaracionSimpleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclVariableContext extends DeclaracionSimpleContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public DeclVariableContext(DeclaracionSimpleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclInferidaContext extends DeclaracionSimpleContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public ValorInferidoContext valorInferido() {
			return getRuleContext(ValorInferidoContext.class,0);
		}
		public DeclInferidaContext(DeclaracionSimpleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclInferida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclInferida(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclInferida(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclObjetoContext extends DeclaracionSimpleContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public List<TerminalNode> DOSPUNTOS() { return getTokens(PigLatinParser.DOSPUNTOS); }
		public TerminalNode DOSPUNTOS(int i) {
			return getToken(PigLatinParser.DOSPUNTOS, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DeclObjetoContext(DeclaracionSimpleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclObjeto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclObjeto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclObjeto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionSimpleContext declaracionSimple() throws RecognitionException {
		DeclaracionSimpleContext _localctx = new DeclaracionSimpleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracionSimple);
		int _la;
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new DeclObjetoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(ESTO);
				setState(101);
				match(ID);
				setState(102);
				match(DOSPUNTOS);
				setState(103);
				expr(0);
				setState(104);
				match(DOSPUNTOS);
				setState(105);
				tipo();
				}
				break;
			case 2:
				_localctx = new DeclVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(ESTO);
				setState(108);
				match(ID);
				setState(109);
				match(DOSPUNTOS);
				setState(110);
				tipo();
				setState(112);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(111);
					valor();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new DeclInferidaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				match(ESTO);
				setState(115);
				match(ID);
				setState(116);
				match(DOSPUNTOS);
				setState(117);
				valorInferido();
				}
				break;
			case 4:
				_localctx = new DeclArregloContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(SERIES);
				setState(119);
				match(ID);
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(120);
					dimension();
					}
					}
					setState(123); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COR_IZQ );
				setState(125);
				match(DOSPUNTOS);
				setState(126);
				tipo();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LLA_IZQ) {
					{
					setState(127);
					inicializadorLista();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValorInferidoContext extends ParserRuleContext {
		public ObjetoNuevoContext objetoNuevo() {
			return getRuleContext(ObjetoNuevoContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ValorInferidoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valorInferido; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValorInferido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValorInferido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValorInferido(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorInferidoContext valorInferido() throws RecognitionException {
		ValorInferidoContext _localctx = new ValorInferidoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_valorInferido);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOVUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				objetoNuevo();
				}
				break;
			case VERUM:
			case FALSUS:
			case NULO:
			case DECIMAL_LIT:
			case ENTERO_LIT:
			case CADENA_LIT:
			case CARACTER_LIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DimensionContext extends ParserRuleContext {
		public TerminalNode COR_IZQ() { return getToken(PigLatinParser.COR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COR_DER() { return getToken(PigLatinParser.COR_DER, 0); }
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDimension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(COR_IZQ);
			setState(137);
			expr(0);
			setState(138);
			match(COR_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValorContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InicializadorListaContext inicializadorLista() {
			return getRuleContext(InicializadorListaContext.class,0);
		}
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_valor);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOVUS:
			case VERUM:
			case FALSUS:
			case NULO:
			case NOT:
			case MENOS:
			case PAR_IZQ:
			case DECIMAL_LIT:
			case ENTERO_LIT:
			case CADENA_LIT:
			case CARACTER_LIT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				expr(0);
				}
				break;
			case LLA_IZQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				inicializadorLista();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicializadorListaContext extends ParserRuleContext {
		public TerminalNode LLA_IZQ() { return getToken(PigLatinParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(PigLatinParser.LLA_DER, 0); }
		public List<ValorContext> valor() {
			return getRuleContexts(ValorContext.class);
		}
		public ValorContext valor(int i) {
			return getRuleContext(ValorContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(PigLatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParser.COMA, i);
		}
		public InicializadorListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializadorLista; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterInicializadorLista(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitInicializadorLista(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitInicializadorLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializadorListaContext inicializadorLista() throws RecognitionException {
		InicializadorListaContext _localctx = new InicializadorListaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inicializadorLista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(LLA_IZQ);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2234984432606347264L) != 0)) {
				{
				setState(145);
				valor();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(146);
					match(COMA);
					setState(147);
					valor();
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(155);
			match(LLA_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LLA_IZQ() { return getToken(PigLatinParser.LLA_IZQ, 0); }
		public TerminalNode LLA_DER() { return getToken(PigLatinParser.LLA_DER, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(LLA_IZQ);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152921505140048640L) != 0)) {
				{
				{
				setState(158);
				sentencia();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			match(LLA_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaContext extends ParserRuleContext {
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	 
		public SentenciaContext() { }
		public void copyFrom(SentenciaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenAsignacionContext extends SentenciaContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenAsignacionContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenSiContext extends SentenciaContext {
		public TerminalNode SI() { return getToken(PigLatinParser.SI, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public List<AliterSiContext> aliterSi() {
			return getRuleContexts(AliterSiContext.class);
		}
		public AliterSiContext aliterSi(int i) {
			return getRuleContext(AliterSiContext.class,i);
		}
		public AliterContext aliter() {
			return getRuleContext(AliterContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenSiContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenSi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenSi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenSi(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenFacereContext extends SentenciaContext {
		public TerminalNode FACERE() { return getToken(PigLatinParser.FACERE, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode DUM() { return getToken(PigLatinParser.DUM, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenFacereContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenFacere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenFacere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenFacere(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenPergeContext extends SentenciaContext {
		public TerminalNode PERGE() { return getToken(PigLatinParser.PERGE, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenPergeContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenPerge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenPerge(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenPerge(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenLeerContext extends SentenciaContext {
		public TerminalNode LEER() { return getToken(PigLatinParser.LEER, 0); }
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenLeerContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenLeer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenLeer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenLeer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenLlamadaContext extends SentenciaContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenLlamadaContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenLlamada(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenInterrumpeContext extends SentenciaContext {
		public TerminalNode INTERRUMPE() { return getToken(PigLatinParser.INTERRUMPE, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenInterrumpeContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenInterrumpe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenInterrumpe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenInterrumpe(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenDeclaracionContext extends SentenciaContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public SenDeclaracionContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenImprimirContext extends SentenciaContext {
		public List<TerminalNode> IMPRIMIR() { return getTokens(PigLatinParser.IMPRIMIR); }
		public TerminalNode IMPRIMIR(int i) {
			return getToken(PigLatinParser.IMPRIMIR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenImprimirContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenImprimir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenImprimir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenImprimir(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenPerContext extends SentenciaContext {
		public TerminalNode PER() { return getToken(PigLatinParser.PER, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public List<TerminalNode> PUNTO_COMA() { return getTokens(PigLatinParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(PigLatinParser.PUNTO_COMA, i);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public PerInicioContext perInicio() {
			return getRuleContext(PerInicioContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PerActualizacionContext perActualizacion() {
			return getRuleContext(PerActualizacionContext.class,0);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public SenPerContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenPer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenPer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenPer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenIncrementoContext extends SentenciaContext {
		public Token op;
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode INCREMENTO() { return getToken(PigLatinParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(PigLatinParser.DECREMENTO, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenIncrementoContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenIncremento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenIncremento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenIncremento(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenDumContext extends SentenciaContext {
		public TerminalNode DUM() { return getToken(PigLatinParser.DUM, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(PigLatinParser.PUNTO_COMA, 0); }
		public SenDumContext(SentenciaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSenDum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSenDum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSenDum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentencia);
		int _la;
		try {
			int _alt;
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new SenDeclaracionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				declaracion();
				}
				break;
			case 2:
				_localctx = new SenAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				asignacion();
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(168);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 3:
				_localctx = new SenIncrementoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				acceso();
				setState(172);
				((SenIncrementoContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
					((SenIncrementoContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(173);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 4:
				_localctx = new SenImprimirContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				match(IMPRIMIR);
				setState(177);
				expr(0);
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(178);
						match(IMPRIMIR);
						setState(179);
						expr(0);
						}
						} 
					}
					setState(184);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(185);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 5:
				_localctx = new SenLeerContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(188);
					acceso();
					}
				}

				setState(191);
				match(LEER);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(192);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 6:
				_localctx = new SenLlamadaContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(195);
				acceso();
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(196);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 7:
				_localctx = new SenSiContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(199);
				match(SI);
				setState(200);
				match(PAR_IZQ);
				setState(201);
				expr(0);
				setState(202);
				match(PAR_DER);
				setState(203);
				bloque();
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(204);
						aliterSi();
						}
						} 
					}
					setState(209);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALITER) {
					{
					setState(210);
					aliter();
					}
				}

				setState(213);
				match(FINIS);
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(214);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 8:
				_localctx = new SenDumContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(217);
				match(DUM);
				setState(218);
				match(PAR_IZQ);
				setState(219);
				expr(0);
				setState(220);
				match(PAR_DER);
				setState(221);
				bloque();
				setState(222);
				match(FINIS);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(223);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 9:
				_localctx = new SenFacereContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(226);
				match(FACERE);
				setState(227);
				bloque();
				setState(228);
				match(DUM);
				setState(229);
				match(PAR_IZQ);
				setState(230);
				expr(0);
				setState(231);
				match(PAR_DER);
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(232);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 10:
				_localctx = new SenPerContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(235);
				match(PER);
				setState(236);
				match(PAR_IZQ);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152921504606847744L) != 0)) {
					{
					setState(237);
					perInicio();
					}
				}

				setState(240);
				match(PUNTO_COMA);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2233858532699504640L) != 0)) {
					{
					setState(241);
					expr(0);
					}
				}

				setState(244);
				match(PUNTO_COMA);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(245);
					perActualizacion();
					}
				}

				setState(248);
				match(PAR_DER);
				setState(249);
				bloque();
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINIS) {
					{
					setState(250);
					match(FINIS);
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PUNTO_COMA) {
						{
						setState(251);
						match(PUNTO_COMA);
						}
					}

					}
				}

				}
				break;
			case 11:
				_localctx = new SenPergeContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(256);
				match(PERGE);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(257);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case 12:
				_localctx = new SenInterrumpeContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(260);
				match(INTERRUMPE);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(261);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AliterSiContext extends ParserRuleContext {
		public TerminalNode ALITER() { return getToken(PigLatinParser.ALITER, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public AliterSiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliterSi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAliterSi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAliterSi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAliterSi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliterSiContext aliterSi() throws RecognitionException {
		AliterSiContext _localctx = new AliterSiContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_aliterSi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(ALITER);
			setState(267);
			match(PAR_IZQ);
			setState(268);
			expr(0);
			setState(269);
			match(PAR_DER);
			setState(270);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AliterContext extends ParserRuleContext {
		public TerminalNode ALITER() { return getToken(PigLatinParser.ALITER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public AliterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAliter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAliter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAliter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliterContext aliter() throws RecognitionException {
		AliterContext _localctx = new AliterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_aliter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(ALITER);
			setState(273);
			bloque();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends ParserRuleContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(PigLatinParser.IGUAL, 0); }
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			acceso();
			setState(276);
			match(IGUAL);
			setState(277);
			valor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PerInicioContext extends ParserRuleContext {
		public DeclaracionSimpleContext declaracionSimple() {
			return getRuleContext(DeclaracionSimpleContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public PerInicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perInicio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterPerInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitPerInicio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitPerInicio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerInicioContext perInicio() throws RecognitionException {
		PerInicioContext _localctx = new PerInicioContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_perInicio);
		try {
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
			case SERIES:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				declaracionSimple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				asignacion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PerActualizacionContext extends ParserRuleContext {
		public Token op;
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode INCREMENTO() { return getToken(PigLatinParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(PigLatinParser.DECREMENTO, 0); }
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public PerActualizacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_perActualizacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterPerActualizacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitPerActualizacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitPerActualizacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerActualizacionContext perActualizacion() throws RecognitionException {
		PerActualizacionContext _localctx = new PerActualizacionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_perActualizacion);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				acceso();
				setState(284);
				((PerActualizacionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
					((PerActualizacionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				asignacion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccesoContext extends ParserRuleContext {
		public InicioAccesoContext inicioAcceso() {
			return getRuleContext(InicioAccesoContext.class,0);
		}
		public List<SufijoContext> sufijo() {
			return getRuleContexts(SufijoContext.class);
		}
		public SufijoContext sufijo(int i) {
			return getRuleContext(SufijoContext.class,i);
		}
		public AccesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acceso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAcceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAcceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAcceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccesoContext acceso() throws RecognitionException {
		AccesoContext _localctx = new AccesoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_acceso);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			inicioAcceso();
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(290);
					sufijo();
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InicioAccesoContext extends ParserRuleContext {
		public InicioAccesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicioAcceso; }
	 
		public InicioAccesoContext() { }
		public void copyFrom(InicioAccesoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccIdContext extends InicioAccesoContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public AccIdContext(InicioAccesoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAccId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAccId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAccId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccLlamadaContext extends InicioAccesoContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public AccLlamadaContext(InicioAccesoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAccLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAccLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAccLlamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicioAccesoContext inicioAcceso() throws RecognitionException {
		InicioAccesoContext _localctx = new InicioAccesoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_inicioAcceso);
		int _la;
		try {
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new AccLlamadaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(ID);
				setState(297);
				match(PAR_IZQ);
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2233858532699504640L) != 0)) {
					{
					setState(298);
					argumentos();
					}
				}

				setState(301);
				match(PAR_DER);
				}
				break;
			case 2:
				_localctx = new AccIdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(302);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SufijoContext extends ParserRuleContext {
		public SufijoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sufijo; }
	 
		public SufijoContext() { }
		public void copyFrom(SufijoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SufIndiceContext extends SufijoContext {
		public TerminalNode COR_IZQ() { return getToken(PigLatinParser.COR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COR_DER() { return getToken(PigLatinParser.COR_DER, 0); }
		public SufIndiceContext(SufijoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSufIndice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSufIndice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSufIndice(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SufAtributoContext extends SufijoContext {
		public TerminalNode PUNTO() { return getToken(PigLatinParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public SufAtributoContext(SufijoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSufAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSufAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSufAtributo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SufMetodoContext extends SufijoContext {
		public TerminalNode PUNTO() { return getToken(PigLatinParser.PUNTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public SufMetodoContext(SufijoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSufMetodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSufMetodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSufMetodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SufijoContext sufijo() throws RecognitionException {
		SufijoContext _localctx = new SufijoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sufijo);
		int _la;
		try {
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new SufMetodoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(PUNTO);
				setState(306);
				match(ID);
				setState(307);
				match(PAR_IZQ);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2233858532699504640L) != 0)) {
					{
					setState(308);
					argumentos();
					}
				}

				setState(311);
				match(PAR_DER);
				}
				break;
			case 2:
				_localctx = new SufAtributoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				match(PUNTO);
				setState(313);
				match(ID);
				}
				break;
			case 3:
				_localctx = new SufIndiceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				match(COR_IZQ);
				setState(315);
				expr(0);
				setState(316);
				match(COR_DER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjetoNuevoContext extends ParserRuleContext {
		public TerminalNode NOVUS() { return getToken(PigLatinParser.NOVUS, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ObjetoNuevoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objetoNuevo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterObjetoNuevo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitObjetoNuevo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitObjetoNuevo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjetoNuevoContext objetoNuevo() throws RecognitionException {
		ObjetoNuevoContext _localctx = new ObjetoNuevoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_objetoNuevo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(NOVUS);
			setState(321);
			match(ID);
			setState(322);
			match(PAR_IZQ);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2233858532699504640L) != 0)) {
				{
				setState(323);
				argumentos();
				}
			}

			setState(326);
			match(PAR_DER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(PigLatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParser.COMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArgumentos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArgumentos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			expr(0);
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(329);
				match(COMA);
				setState(330);
				expr(0);
				}
				}
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAccesoContext extends ExprContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public ExprAccesoContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprAcceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprAcceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprAcceso(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOrContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(PigLatinParser.OR, 0); }
		public ExprOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNuevoContext extends ExprContext {
		public ObjetoNuevoContext objetoNuevo() {
			return getRuleContext(ObjetoNuevoContext.class,0);
		}
		public ExprNuevoContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprNuevo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprNuevo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprNuevo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAditivaContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MAS() { return getToken(PigLatinParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(PigLatinParser.MENOS, 0); }
		public ExprAditivaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprAditiva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprAditiva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprAditiva(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRelacionalContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MENOR() { return getToken(PigLatinParser.MENOR, 0); }
		public TerminalNode MAYOR() { return getToken(PigLatinParser.MAYOR, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(PigLatinParser.MENOR_IGUAL, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(PigLatinParser.MAYOR_IGUAL, 0); }
		public ExprRelacionalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprRelacional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIgualdadContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IGUAL_IGUAL() { return getToken(PigLatinParser.IGUAL_IGUAL, 0); }
		public TerminalNode IGUAL() { return getToken(PigLatinParser.IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(PigLatinParser.DIFERENTE, 0); }
		public ExprIgualdadContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprIgualdad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprIgualdad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParentesisContext extends ExprContext {
		public TerminalNode PAR_IZQ() { return getToken(PigLatinParser.PAR_IZQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PAR_DER() { return getToken(PigLatinParser.PAR_DER, 0); }
		public ExprParentesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprParentesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprParentesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprParentesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnariaContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PigLatinParser.NOT, 0); }
		public TerminalNode MENOS() { return getToken(PigLatinParser.MENOS, 0); }
		public ExprUnariaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprUnaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprUnaria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprUnaria(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAndContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(PigLatinParser.AND, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLiteralContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExprLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultiplicativaContext extends ExprContext {
		public ExprContext izq;
		public Token op;
		public ExprContext der;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(PigLatinParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(PigLatinParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(PigLatinParser.MOD, 0); }
		public ExprMultiplicativaContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExprMultiplicativa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExprMultiplicativa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExprMultiplicativa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PAR_IZQ:
				{
				_localctx = new ExprParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(337);
				match(PAR_IZQ);
				setState(338);
				expr(0);
				setState(339);
				match(PAR_DER);
				}
				break;
			case VERUM:
			case FALSUS:
			case NULO:
			case DECIMAL_LIT:
			case ENTERO_LIT:
			case CADENA_LIT:
			case CARACTER_LIT:
				{
				_localctx = new ExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(341);
				literal();
				}
				break;
			case NOVUS:
				{
				_localctx = new ExprNuevoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(342);
				objetoNuevo();
				}
				break;
			case ID:
				{
				_localctx = new ExprAccesoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(343);
				acceso();
				}
				break;
			case NOT:
			case MENOS:
				{
				_localctx = new ExprUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(344);
				((ExprUnariaContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MENOS) ) {
					((ExprUnariaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(345);
				expr(7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(368);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(366);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultiplicativaContext(new ExprContext(_parentctx, _parentState));
						((ExprMultiplicativaContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(348);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(349);
						((ExprMultiplicativaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30786325577728L) != 0)) ) {
							((ExprMultiplicativaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(350);
						((ExprMultiplicativaContext)_localctx).der = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprAditivaContext(new ExprContext(_parentctx, _parentState));
						((ExprAditivaContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(351);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(352);
						((ExprAditivaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MAS || _la==MENOS) ) {
							((ExprAditivaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(353);
						((ExprAditivaContext)_localctx).der = expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprRelacionalContext(new ExprContext(_parentctx, _parentState));
						((ExprRelacionalContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(354);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(355);
						((ExprRelacionalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0)) ) {
							((ExprRelacionalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(356);
						((ExprRelacionalContext)_localctx).der = expr(5);
						}
						break;
					case 4:
						{
						_localctx = new ExprIgualdadContext(new ExprContext(_parentctx, _parentState));
						((ExprIgualdadContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(357);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(358);
						((ExprIgualdadContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 35190814539776L) != 0)) ) {
							((ExprIgualdadContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(359);
						((ExprIgualdadContext)_localctx).der = expr(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						((ExprAndContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(360);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(361);
						((ExprAndContext)_localctx).op = match(AND);
						setState(362);
						((ExprAndContext)_localctx).der = expr(3);
						}
						break;
					case 6:
						{
						_localctx = new ExprOrContext(new ExprContext(_parentctx, _parentState));
						((ExprOrContext)_localctx).izq = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(363);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(364);
						((ExprOrContext)_localctx).op = match(OR);
						setState(365);
						((ExprOrContext)_localctx).der = expr(2);
						}
						break;
					}
					} 
				}
				setState(370);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode ENTERO_LIT() { return getToken(PigLatinParser.ENTERO_LIT, 0); }
		public TerminalNode DECIMAL_LIT() { return getToken(PigLatinParser.DECIMAL_LIT, 0); }
		public TerminalNode CADENA_LIT() { return getToken(PigLatinParser.CADENA_LIT, 0); }
		public TerminalNode CARACTER_LIT() { return getToken(PigLatinParser.CARACTER_LIT, 0); }
		public TerminalNode VERUM() { return getToken(PigLatinParser.VERUM, 0); }
		public TerminalNode FALSUS() { return getToken(PigLatinParser.FALSUS, 0); }
		public TerminalNode NULO() { return getToken(PigLatinParser.NULO, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1080863910569377792L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode NUMERUS() { return getToken(PigLatinParser.NUMERUS, 0); }
		public TerminalNode TEXTUM() { return getToken(PigLatinParser.TEXTUM, 0); }
		public TerminalNode DECIMALIS() { return getToken(PigLatinParser.DECIMALIS, 0); }
		public TerminalNode LITTERA() { return getToken(PigLatinParser.LITTERA, 0); }
		public TerminalNode BOOL() { return getToken(PigLatinParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152921504606878720L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 23:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u0178\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0005\u00006\b\u0000\n\u0000\f\u0000"+
		"9\t\u0000\u0001\u0000\u0003\u0000<\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001D\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0004\u0002I\b\u0002\u000b\u0002\f\u0002"+
		"J\u0001\u0003\u0001\u0003\u0005\u0003O\b\u0003\n\u0003\f\u0003R\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0005\u0004V\b\u0004\n\u0004\f\u0004Y\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004]\b\u0004\u0003\u0004_\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0003\u0005c\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006q\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0004\u0006z\b\u0006\u000b\u0006\f\u0006{\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u0081\b\u0006\u0003\u0006\u0083\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0087\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0003\t\u008f\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0095\b\n\n\n\f\n\u0098\t\n\u0003\n\u009a\b\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00a0\b\u000b\n\u000b\f\u000b\u00a3\t\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u00aa\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00af\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u00b5\b\f\n\f\f\f\u00b8\t\f\u0001\f\u0003\f\u00bb\b\f\u0001\f\u0003"+
		"\f\u00be\b\f\u0001\f\u0001\f\u0003\f\u00c2\b\f\u0001\f\u0001\f\u0003\f"+
		"\u00c6\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00ce"+
		"\b\f\n\f\f\f\u00d1\t\f\u0001\f\u0003\f\u00d4\b\f\u0001\f\u0001\f\u0003"+
		"\f\u00d8\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00e1\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00ea\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u00ef\b\f\u0001\f\u0001\f"+
		"\u0003\f\u00f3\b\f\u0001\f\u0001\f\u0003\f\u00f7\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00fd\b\f\u0003\f\u00ff\b\f\u0001\f\u0001\f\u0003\f"+
		"\u0103\b\f\u0001\f\u0001\f\u0003\f\u0107\b\f\u0003\f\u0109\b\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u011a\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u0120\b\u0011\u0001\u0012\u0001\u0012\u0005\u0012\u0124"+
		"\b\u0012\n\u0012\f\u0012\u0127\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u012c\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0130\b"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0136"+
		"\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u013f\b\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0145\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u014c\b\u0016\n\u0016\f\u0016"+
		"\u014f\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u015b\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u016f\b\u0017\n\u0017\f\u0017\u0172\t\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0000\u0001.\u001a"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02\u0000\b\u0001\u0000\u001d\u001e\u0002\u0000\'"+
		"\'))\u0001\u0000*,\u0001\u0000()\u0001\u0000!$\u0002\u0000\u001f --\u0002"+
		"\u0000\u0010\u00128;\u0002\u0000\n\u000e<<\u01a3\u00007\u0001\u0000\u0000"+
		"\u0000\u0002@\u0001\u0000\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006"+
		"L\u0001\u0000\u0000\u0000\bS\u0001\u0000\u0000\u0000\n`\u0001\u0000\u0000"+
		"\u0000\f\u0082\u0001\u0000\u0000\u0000\u000e\u0086\u0001\u0000\u0000\u0000"+
		"\u0010\u0088\u0001\u0000\u0000\u0000\u0012\u008e\u0001\u0000\u0000\u0000"+
		"\u0014\u0090\u0001\u0000\u0000\u0000\u0016\u009d\u0001\u0000\u0000\u0000"+
		"\u0018\u0108\u0001\u0000\u0000\u0000\u001a\u010a\u0001\u0000\u0000\u0000"+
		"\u001c\u0110\u0001\u0000\u0000\u0000\u001e\u0113\u0001\u0000\u0000\u0000"+
		" \u0119\u0001\u0000\u0000\u0000\"\u011f\u0001\u0000\u0000\u0000$\u0121"+
		"\u0001\u0000\u0000\u0000&\u012f\u0001\u0000\u0000\u0000(\u013e\u0001\u0000"+
		"\u0000\u0000*\u0140\u0001\u0000\u0000\u0000,\u0148\u0001\u0000\u0000\u0000"+
		".\u015a\u0001\u0000\u0000\u00000\u0173\u0001\u0000\u0000\u00002\u0175"+
		"\u0001\u0000\u0000\u000046\u0003\u0002\u0001\u000054\u0001\u0000\u0000"+
		"\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000"+
		"\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000:<\u0003"+
		"\u0006\u0003\u0000;:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=>\u0003\b\u0004\u0000>?\u0005\u0000\u0000\u0001"+
		"?\u0001\u0001\u0000\u0000\u0000@A\u0005\u0004\u0000\u0000AC\u0003\u0004"+
		"\u0002\u0000BD\u00057\u0000\u0000CB\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000D\u0003\u0001\u0000\u0000\u0000EH\u0005<\u0000\u0000FG\u0005"+
		"4\u0000\u0000GI\u0005<\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u0005"+
		"\u0001\u0000\u0000\u0000LP\u0005\u0005\u0000\u0000MO\u0003\n\u0005\u0000"+
		"NM\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000"+
		"\u0000PQ\u0001\u0000\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000SW\u0005\u0006\u0000\u0000TV\u0003\u0018\f\u0000UT\u0001"+
		"\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000X^\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000"+
		"\u0000Z\\\u0005\u0007\u0000\u0000[]\u00057\u0000\u0000\\[\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^Z\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\t\u0001\u0000\u0000\u0000"+
		"`b\u0003\f\u0006\u0000ac\u00057\u0000\u0000ba\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000c\u000b\u0001\u0000\u0000\u0000de\u0005\b\u0000"+
		"\u0000ef\u0005<\u0000\u0000fg\u00056\u0000\u0000gh\u0003.\u0017\u0000"+
		"hi\u00056\u0000\u0000ij\u00032\u0019\u0000j\u0083\u0001\u0000\u0000\u0000"+
		"kl\u0005\b\u0000\u0000lm\u0005<\u0000\u0000mn\u00056\u0000\u0000np\u0003"+
		"2\u0019\u0000oq\u0003\u0012\t\u0000po\u0001\u0000\u0000\u0000pq\u0001"+
		"\u0000\u0000\u0000q\u0083\u0001\u0000\u0000\u0000rs\u0005\b\u0000\u0000"+
		"st\u0005<\u0000\u0000tu\u00056\u0000\u0000u\u0083\u0003\u000e\u0007\u0000"+
		"vw\u0005\t\u0000\u0000wy\u0005<\u0000\u0000xz\u0003\u0010\b\u0000yx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u00056\u0000\u0000"+
		"~\u0080\u00032\u0019\u0000\u007f\u0081\u0003\u0014\n\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0083"+
		"\u0001\u0000\u0000\u0000\u0082d\u0001\u0000\u0000\u0000\u0082k\u0001\u0000"+
		"\u0000\u0000\u0082r\u0001\u0000\u0000\u0000\u0082v\u0001\u0000\u0000\u0000"+
		"\u0083\r\u0001\u0000\u0000\u0000\u0084\u0087\u0003*\u0015\u0000\u0085"+
		"\u0087\u00030\u0018\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u000f\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u00050\u0000\u0000\u0089\u008a\u0003.\u0017\u0000\u008a\u008b\u00051"+
		"\u0000\u0000\u008b\u0011\u0001\u0000\u0000\u0000\u008c\u008f\u0003.\u0017"+
		"\u0000\u008d\u008f\u0003\u0014\n\u0000\u008e\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0013\u0001\u0000\u0000\u0000"+
		"\u0090\u0099\u00052\u0000\u0000\u0091\u0096\u0003\u0012\t\u0000\u0092"+
		"\u0093\u00055\u0000\u0000\u0093\u0095\u0003\u0012\t\u0000\u0094\u0092"+
		"\u0001\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0094"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u009a"+
		"\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u0091"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u00053\u0000\u0000\u009c\u0015\u0001"+
		"\u0000\u0000\u0000\u009d\u00a1\u00052\u0000\u0000\u009e\u00a0\u0003\u0018"+
		"\f\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u00053\u0000\u0000\u00a5\u0017\u0001\u0000\u0000\u0000"+
		"\u00a6\u0109\u0003\n\u0005\u0000\u00a7\u00a9\u0003\u001e\u000f\u0000\u00a8"+
		"\u00aa\u00057\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\u0109\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0003$\u0012\u0000\u00ac\u00ae\u0007\u0000\u0000\u0000\u00ad\u00af\u0005"+
		"7\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u0109\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u001b"+
		"\u0000\u0000\u00b1\u00b6\u0003.\u0017\u0000\u00b2\u00b3\u0005\u001b\u0000"+
		"\u0000\u00b3\u00b5\u0003.\u0017\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bb\u00057\u0000\u0000\u00ba"+
		"\u00b9\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb"+
		"\u0109\u0001\u0000\u0000\u0000\u00bc\u00be\u0003$\u0012\u0000\u00bd\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c1\u0005\u001c\u0000\u0000\u00c0\u00c2"+
		"\u00057\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c2\u0109\u0001\u0000\u0000\u0000\u00c3\u00c5\u0003"+
		"$\u0012\u0000\u00c4\u00c6\u00057\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u0109\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0005\u0013\u0000\u0000\u00c8\u00c9\u0005.\u0000\u0000"+
		"\u00c9\u00ca\u0003.\u0017\u0000\u00ca\u00cb\u0005/\u0000\u0000\u00cb\u00cf"+
		"\u0003\u0016\u000b\u0000\u00cc\u00ce\u0003\u001a\r\u0000\u00cd\u00cc\u0001"+
		"\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d4\u0003"+
		"\u001c\u000e\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0005"+
		"\u0015\u0000\u0000\u00d6\u00d8\u00057\u0000\u0000\u00d7\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u0109\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005\u0016\u0000\u0000\u00da\u00db\u0005.\u0000"+
		"\u0000\u00db\u00dc\u0003.\u0017\u0000\u00dc\u00dd\u0005/\u0000\u0000\u00dd"+
		"\u00de\u0003\u0016\u000b\u0000\u00de\u00e0\u0005\u0015\u0000\u0000\u00df"+
		"\u00e1\u00057\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e1\u0109\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\u0005\u0017\u0000\u0000\u00e3\u00e4\u0003\u0016\u000b\u0000\u00e4\u00e5"+
		"\u0005\u0016\u0000\u0000\u00e5\u00e6\u0005.\u0000\u0000\u00e6\u00e7\u0003"+
		".\u0017\u0000\u00e7\u00e9\u0005/\u0000\u0000\u00e8\u00ea\u00057\u0000"+
		"\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ea\u0109\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\u0018\u0000"+
		"\u0000\u00ec\u00ee\u0005.\u0000\u0000\u00ed\u00ef\u0003 \u0010\u0000\u00ee"+
		"\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f2\u00057\u0000\u0000\u00f1\u00f3"+
		"\u0003.\u0017\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f6\u0005"+
		"7\u0000\u0000\u00f5\u00f7\u0003\"\u0011\u0000\u00f6\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0005/\u0000\u0000\u00f9\u00fe\u0003\u0016\u000b"+
		"\u0000\u00fa\u00fc\u0005\u0015\u0000\u0000\u00fb\u00fd\u00057\u0000\u0000"+
		"\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000"+
		"\u00fd\u00ff\u0001\u0000\u0000\u0000\u00fe\u00fa\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0109\u0001\u0000\u0000\u0000"+
		"\u0100\u0102\u0005\u0019\u0000\u0000\u0101\u0103\u00057\u0000\u0000\u0102"+
		"\u0101\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u0109\u0001\u0000\u0000\u0000\u0104\u0106\u0005\u001a\u0000\u0000\u0105"+
		"\u0107\u00057\u0000\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0001\u0000\u0000\u0000\u0107\u0109\u0001\u0000\u0000\u0000\u0108\u00a6"+
		"\u0001\u0000\u0000\u0000\u0108\u00a7\u0001\u0000\u0000\u0000\u0108\u00ab"+
		"\u0001\u0000\u0000\u0000\u0108\u00b0\u0001\u0000\u0000\u0000\u0108\u00bd"+
		"\u0001\u0000\u0000\u0000\u0108\u00c3\u0001\u0000\u0000\u0000\u0108\u00c7"+
		"\u0001\u0000\u0000\u0000\u0108\u00d9\u0001\u0000\u0000\u0000\u0108\u00e2"+
		"\u0001\u0000\u0000\u0000\u0108\u00eb\u0001\u0000\u0000\u0000\u0108\u0100"+
		"\u0001\u0000\u0000\u0000\u0108\u0104\u0001\u0000\u0000\u0000\u0109\u0019"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0005\u0014\u0000\u0000\u010b\u010c"+
		"\u0005.\u0000\u0000\u010c\u010d\u0003.\u0017\u0000\u010d\u010e\u0005/"+
		"\u0000\u0000\u010e\u010f\u0003\u0016\u000b\u0000\u010f\u001b\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0005\u0014\u0000\u0000\u0111\u0112\u0003\u0016"+
		"\u000b\u0000\u0112\u001d\u0001\u0000\u0000\u0000\u0113\u0114\u0003$\u0012"+
		"\u0000\u0114\u0115\u0005-\u0000\u0000\u0115\u0116\u0003\u0012\t\u0000"+
		"\u0116\u001f\u0001\u0000\u0000\u0000\u0117\u011a\u0003\f\u0006\u0000\u0118"+
		"\u011a\u0003\u001e\u000f\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u0119"+
		"\u0118\u0001\u0000\u0000\u0000\u011a!\u0001\u0000\u0000\u0000\u011b\u011c"+
		"\u0003$\u0012\u0000\u011c\u011d\u0007\u0000\u0000\u0000\u011d\u0120\u0001"+
		"\u0000\u0000\u0000\u011e\u0120\u0003\u001e\u000f\u0000\u011f\u011b\u0001"+
		"\u0000\u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120#\u0001\u0000"+
		"\u0000\u0000\u0121\u0125\u0003&\u0013\u0000\u0122\u0124\u0003(\u0014\u0000"+
		"\u0123\u0122\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000"+
		"\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000"+
		"\u0126%\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128"+
		"\u0129\u0005<\u0000\u0000\u0129\u012b\u0005.\u0000\u0000\u012a\u012c\u0003"+
		",\u0016\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u0130\u0005/\u0000"+
		"\u0000\u012e\u0130\u0005<\u0000\u0000\u012f\u0128\u0001\u0000\u0000\u0000"+
		"\u012f\u012e\u0001\u0000\u0000\u0000\u0130\'\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u00054\u0000\u0000\u0132\u0133\u0005<\u0000\u0000\u0133\u0135\u0005"+
		".\u0000\u0000\u0134\u0136\u0003,\u0016\u0000\u0135\u0134\u0001\u0000\u0000"+
		"\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000"+
		"\u0000\u0137\u013f\u0005/\u0000\u0000\u0138\u0139\u00054\u0000\u0000\u0139"+
		"\u013f\u0005<\u0000\u0000\u013a\u013b\u00050\u0000\u0000\u013b\u013c\u0003"+
		".\u0017\u0000\u013c\u013d\u00051\u0000\u0000\u013d\u013f\u0001\u0000\u0000"+
		"\u0000\u013e\u0131\u0001\u0000\u0000\u0000\u013e\u0138\u0001\u0000\u0000"+
		"\u0000\u013e\u013a\u0001\u0000\u0000\u0000\u013f)\u0001\u0000\u0000\u0000"+
		"\u0140\u0141\u0005\u000f\u0000\u0000\u0141\u0142\u0005<\u0000\u0000\u0142"+
		"\u0144\u0005.\u0000\u0000\u0143\u0145\u0003,\u0016\u0000\u0144\u0143\u0001"+
		"\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0001"+
		"\u0000\u0000\u0000\u0146\u0147\u0005/\u0000\u0000\u0147+\u0001\u0000\u0000"+
		"\u0000\u0148\u014d\u0003.\u0017\u0000\u0149\u014a\u00055\u0000\u0000\u014a"+
		"\u014c\u0003.\u0017\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014c\u014f"+
		"\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000\u0000\u0000\u014d\u014e"+
		"\u0001\u0000\u0000\u0000\u014e-\u0001\u0000\u0000\u0000\u014f\u014d\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\u0006\u0017\uffff\uffff\u0000\u0151\u0152"+
		"\u0005.\u0000\u0000\u0152\u0153\u0003.\u0017\u0000\u0153\u0154\u0005/"+
		"\u0000\u0000\u0154\u015b\u0001\u0000\u0000\u0000\u0155\u015b\u00030\u0018"+
		"\u0000\u0156\u015b\u0003*\u0015\u0000\u0157\u015b\u0003$\u0012\u0000\u0158"+
		"\u0159\u0007\u0001\u0000\u0000\u0159\u015b\u0003.\u0017\u0007\u015a\u0150"+
		"\u0001\u0000\u0000\u0000\u015a\u0155\u0001\u0000\u0000\u0000\u015a\u0156"+
		"\u0001\u0000\u0000\u0000\u015a\u0157\u0001\u0000\u0000\u0000\u015a\u0158"+
		"\u0001\u0000\u0000\u0000\u015b\u0170\u0001\u0000\u0000\u0000\u015c\u015d"+
		"\n\u0006\u0000\u0000\u015d\u015e\u0007\u0002\u0000\u0000\u015e\u016f\u0003"+
		".\u0017\u0007\u015f\u0160\n\u0005\u0000\u0000\u0160\u0161\u0007\u0003"+
		"\u0000\u0000\u0161\u016f\u0003.\u0017\u0006\u0162\u0163\n\u0004\u0000"+
		"\u0000\u0163\u0164\u0007\u0004\u0000\u0000\u0164\u016f\u0003.\u0017\u0005"+
		"\u0165\u0166\n\u0003\u0000\u0000\u0166\u0167\u0007\u0005\u0000\u0000\u0167"+
		"\u016f\u0003.\u0017\u0004\u0168\u0169\n\u0002\u0000\u0000\u0169\u016a"+
		"\u0005%\u0000\u0000\u016a\u016f\u0003.\u0017\u0003\u016b\u016c\n\u0001"+
		"\u0000\u0000\u016c\u016d\u0005&\u0000\u0000\u016d\u016f\u0003.\u0017\u0002"+
		"\u016e\u015c\u0001\u0000\u0000\u0000\u016e\u015f\u0001\u0000\u0000\u0000"+
		"\u016e\u0162\u0001\u0000\u0000\u0000\u016e\u0165\u0001\u0000\u0000\u0000"+
		"\u016e\u0168\u0001\u0000\u0000\u0000\u016e\u016b\u0001\u0000\u0000\u0000"+
		"\u016f\u0172\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000"+
		"\u0170\u0171\u0001\u0000\u0000\u0000\u0171/\u0001\u0000\u0000\u0000\u0172"+
		"\u0170\u0001\u0000\u0000\u0000\u0173\u0174\u0007\u0006\u0000\u0000\u0174"+
		"1\u0001\u0000\u0000\u0000\u0175\u0176\u0007\u0007\u0000\u0000\u01763\u0001"+
		"\u0000\u0000\u000027;CJPW\\^bp{\u0080\u0082\u0086\u008e\u0096\u0099\u00a1"+
		"\u00a9\u00ae\u00b6\u00ba\u00bd\u00c1\u00c5\u00cf\u00d3\u00d7\u00e0\u00e9"+
		"\u00ee\u00f2\u00f6\u00fc\u00fe\u0102\u0106\u0108\u0119\u011f\u0125\u012b"+
		"\u012f\u0135\u013e\u0144\u014d\u015a\u016e\u0170";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
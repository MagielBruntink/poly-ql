// Generated from QLang.g4 by ANTLR 4.1

import ast.expr.Expr;
import ast.expr.IdentLiteral;
import ast.expr.binExpr.*;
import ast.expr.unExpression.*;
import ast.expr.literal.*;
import ast.expr.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLangParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, WS=19, COMMENT=20, NewLine=21, Ident=22, Int=23, Str=24, 
		Bool=25;
	public static final String[] tokenNames = {
		"<INVALID>", "')'", "'+'", "'*'", "'-'", "'('", "'<'", "'!='", "'<='", 
		"'&&'", "'||'", "'>'", "'integer'", "'string'", "'=='", "'/'", "'>='", 
		"'boolean'", "'!'", "WS", "COMMENT", "NewLine", "Ident", "Int", "Str", 
		"Bool"
	};
	public static final int
		RULE_unExpr = 0, RULE_primary = 1, RULE_mulExpr = 2, RULE_addExpr = 3, 
		RULE_relExpr = 4, RULE_andExpr = 5, RULE_orExpr = 6, RULE_type = 7;
	public static final String[] ruleNames = {
		"unExpr", "primary", "mulExpr", "addExpr", "relExpr", "andExpr", "orExpr", 
		"type"
	};

	@Override
	public String getGrammarFileName() { return "QLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class UnExprContext extends ParserRuleContext {
		public Expr result;
		public PrimaryContext y;
		public UnExprContext x;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnExprContext unExpr() {
			return getRuleContext(UnExprContext.class,0);
		}
		public UnExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterUnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitUnExpr(this);
		}
	}

	public final UnExprContext unExpr() throws RecognitionException {
		UnExprContext _localctx = new UnExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_unExpr);
		try {
			setState(31);
			switch (_input.LA(1)) {
			case 5:
			case Ident:
			case Int:
			case Str:
			case Bool:
				enterOuterAlt(_localctx, 1);
				{
				setState(16); ((UnExprContext)_localctx).y = primary();
				((UnExprContext)_localctx).result =  ((UnExprContext)_localctx).y.result;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19); match(2);
				setState(20); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Pos(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 3);
				{
				setState(23); match(4);
				setState(24); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Neg(((UnExprContext)_localctx).x.result); 
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 4);
				{
				setState(27); match(18);
				setState(28); ((UnExprContext)_localctx).x = unExpr();
				 ((UnExprContext)_localctx).result =  new Not(((UnExprContext)_localctx).x.result); 
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

	public static class PrimaryContext extends ParserRuleContext {
		public Expr result;
		public OrExprContext x;
		public Token Bool;
		public Token Int;
		public Token Ident;
		public Token Str;
		public TerminalNode Ident() { return getToken(QLangParser.Ident, 0); }
		public TerminalNode Bool() { return getToken(QLangParser.Bool, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode Str() { return getToken(QLangParser.Str, 0); }
		public TerminalNode Int() { return getToken(QLangParser.Int, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primary);
		try {
			setState(46);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				setState(33); match(5);
				setState(34); ((PrimaryContext)_localctx).x = orExpr();
				setState(35); match(1);
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).x.result; 
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 2);
				{
				setState(38); ((PrimaryContext)_localctx).Bool = match(Bool);
				 ((PrimaryContext)_localctx).result =  new BoolLiteral(Boolean.parseBoolean((((PrimaryContext)_localctx).Bool!=null?((PrimaryContext)_localctx).Bool.getText():null)));
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 3);
				{
				setState(40); ((PrimaryContext)_localctx).Int = match(Int);
				((PrimaryContext)_localctx).result =  new IntLiteral(Integer.parseInt((((PrimaryContext)_localctx).Int!=null?((PrimaryContext)_localctx).Int.getText():null)));
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 4);
				{
				setState(42); ((PrimaryContext)_localctx).Ident = match(Ident);
				((PrimaryContext)_localctx).result =  new IdentLiteral((((PrimaryContext)_localctx).Ident!=null?((PrimaryContext)_localctx).Ident.getText():null));
				}
				break;
			case Str:
				enterOuterAlt(_localctx, 5);
				{
				setState(44); ((PrimaryContext)_localctx).Str = match(Str);
				((PrimaryContext)_localctx).result =  new StrLiteral((((PrimaryContext)_localctx).Str!=null?((PrimaryContext)_localctx).Str.getText():null));
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

	public static class MulExprContext extends ParserRuleContext {
		public Expr result;
		public UnExprContext lhs;
		public Token op;
		public UnExprContext rhs;
		public UnExprContext unExpr(int i) {
			return getRuleContext(UnExprContext.class,i);
		}
		public List<UnExprContext> unExpr() {
			return getRuleContexts(UnExprContext.class);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitMulExpr(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mulExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); ((MulExprContext)_localctx).lhs = unExpr();
			 ((MulExprContext)_localctx).result = ((MulExprContext)_localctx).lhs.result; 
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3 || _la==15) {
				{
				{
				setState(50);
				((MulExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==3 || _la==15) ) {
					((MulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(51); ((MulExprContext)_localctx).rhs = unExpr();
				 
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("*")) {
				        ((MulExprContext)_localctx).result =  new Mul(_localctx.result, ((MulExprContext)_localctx).rhs.result);
				      }
				      if ((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null).equals("/")) {
				        ((MulExprContext)_localctx).result =  new Div(_localctx.result, ((MulExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(58);
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

	public static class AddExprContext extends ParserRuleContext {
		public Expr result;
		public MulExprContext lhs;
		public Token op;
		public MulExprContext rhs;
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitAddExpr(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_addExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); ((AddExprContext)_localctx).lhs = mulExpr();
			 ((AddExprContext)_localctx).result = ((AddExprContext)_localctx).lhs.result; 
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2 || _la==4) {
				{
				{
				setState(61);
				((AddExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==2 || _la==4) ) {
					((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(62); ((AddExprContext)_localctx).rhs = mulExpr();
				 
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("+")) {
				        ((AddExprContext)_localctx).result =  new Add(_localctx.result, ((AddExprContext)_localctx).rhs.result);
				      }
				      if ((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null).equals("-")) {
				        ((AddExprContext)_localctx).result =  new Sub(_localctx.result, ((AddExprContext)_localctx).rhs.result);      
				      }
				    
				}
				}
				setState(69);
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

	public static class RelExprContext extends ParserRuleContext {
		public Expr result;
		public AddExprContext lhs;
		public Token op;
		public AddExprContext rhs;
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitRelExpr(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_relExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); ((RelExprContext)_localctx).lhs = addExpr();
			 ((RelExprContext)_localctx).result = ((RelExprContext)_localctx).lhs.result; 
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 8) | (1L << 11) | (1L << 14) | (1L << 16))) != 0)) {
				{
				{
				setState(72);
				((RelExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 8) | (1L << 11) | (1L << 14) | (1L << 16))) != 0)) ) {
					((RelExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(73); ((RelExprContext)_localctx).rhs = addExpr();
				 
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("<")) {
				        ((RelExprContext)_localctx).result =  new LT(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("<=")) {
				        ((RelExprContext)_localctx).result =  new LEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);      
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals(">")) {
				        ((RelExprContext)_localctx).result =  new GT(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals(">=")) {
				        ((RelExprContext)_localctx).result =  new GEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);      
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("==")) {
				        ((RelExprContext)_localctx).result =  new Eq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				      if ((((RelExprContext)_localctx).op!=null?((RelExprContext)_localctx).op.getText():null).equals("!=")) {
				        ((RelExprContext)_localctx).result =  new NEq(_localctx.result, ((RelExprContext)_localctx).rhs.result);
				      }
				    
				}
				}
				setState(80);
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

	public static class AndExprContext extends ParserRuleContext {
		public Expr result;
		public RelExprContext lhs;
		public RelExprContext rhs;
		public List<RelExprContext> relExpr() {
			return getRuleContexts(RelExprContext.class);
		}
		public RelExprContext relExpr(int i) {
			return getRuleContext(RelExprContext.class,i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitAndExpr(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_andExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); ((AndExprContext)_localctx).lhs = relExpr();
			 ((AndExprContext)_localctx).result = ((AndExprContext)_localctx).lhs.result; 
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==9) {
				{
				{
				setState(83); match(9);
				setState(84); ((AndExprContext)_localctx).rhs = relExpr();
				 ((AndExprContext)_localctx).result =  new And(_localctx.result, ((AndExprContext)_localctx).rhs.result); 
				}
				}
				setState(91);
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

	public static class OrExprContext extends ParserRuleContext {
		public Expr result;
		public AndExprContext lhs;
		public AndExprContext rhs;
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitOrExpr(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); ((OrExprContext)_localctx).lhs = andExpr();
			 ((OrExprContext)_localctx).result =  ((OrExprContext)_localctx).lhs.result; 
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==10) {
				{
				{
				setState(94); match(10);
				setState(95); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).result =  new Or(_localctx.result, ((OrExprContext)_localctx).rhs.result); 
				}
				}
				setState(102);
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

	public static class TypeContext extends ParserRuleContext {
		public Types result;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLangListener ) ((QLangListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(109);
			switch (_input.LA(1)) {
			case 17:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); match(17);
				((TypeContext)_localctx).result =  new BoolType();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 2);
				{
				setState(105); match(13);
				((TypeContext)_localctx).result =  new StrType();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 3);
				{
				setState(107); match(12);
				((TypeContext)_localctx).result =  new IntType();
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\33r\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\"\n\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\49\n\4\f\4\16\4<\13\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5D\n\5\f\5\16\5G\13\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6O\n\6\f\6\16\6R\13\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7Z\n\7\f\7\16\7]\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\be\n\b\f\b\16\bh"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tp\n\t\3\t\2\n\2\4\6\b\n\f\16\20\2\5\4"+
		"\2\5\5\21\21\4\2\4\4\6\6\6\2\b\n\r\r\20\20\22\22w\2!\3\2\2\2\4\60\3\2"+
		"\2\2\6\62\3\2\2\2\b=\3\2\2\2\nH\3\2\2\2\fS\3\2\2\2\16^\3\2\2\2\20o\3\2"+
		"\2\2\22\23\5\4\3\2\23\24\b\2\1\2\24\"\3\2\2\2\25\26\7\4\2\2\26\27\5\2"+
		"\2\2\27\30\b\2\1\2\30\"\3\2\2\2\31\32\7\6\2\2\32\33\5\2\2\2\33\34\b\2"+
		"\1\2\34\"\3\2\2\2\35\36\7\24\2\2\36\37\5\2\2\2\37 \b\2\1\2 \"\3\2\2\2"+
		"!\22\3\2\2\2!\25\3\2\2\2!\31\3\2\2\2!\35\3\2\2\2\"\3\3\2\2\2#$\7\7\2\2"+
		"$%\5\16\b\2%&\7\3\2\2&\'\b\3\1\2\'\61\3\2\2\2()\7\33\2\2)\61\b\3\1\2*"+
		"+\7\31\2\2+\61\b\3\1\2,-\7\30\2\2-\61\b\3\1\2./\7\32\2\2/\61\b\3\1\2\60"+
		"#\3\2\2\2\60(\3\2\2\2\60*\3\2\2\2\60,\3\2\2\2\60.\3\2\2\2\61\5\3\2\2\2"+
		"\62\63\5\2\2\2\63:\b\4\1\2\64\65\t\2\2\2\65\66\5\2\2\2\66\67\b\4\1\2\67"+
		"9\3\2\2\28\64\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\7\3\2\2\2<:\3\2\2"+
		"\2=>\5\6\4\2>E\b\5\1\2?@\t\3\2\2@A\5\6\4\2AB\b\5\1\2BD\3\2\2\2C?\3\2\2"+
		"\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GE\3\2\2\2HI\5\b\5\2IP\b\6"+
		"\1\2JK\t\4\2\2KL\5\b\5\2LM\b\6\1\2MO\3\2\2\2NJ\3\2\2\2OR\3\2\2\2PN\3\2"+
		"\2\2PQ\3\2\2\2Q\13\3\2\2\2RP\3\2\2\2ST\5\n\6\2T[\b\7\1\2UV\7\13\2\2VW"+
		"\5\n\6\2WX\b\7\1\2XZ\3\2\2\2YU\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2"+
		"\\\r\3\2\2\2][\3\2\2\2^_\5\f\7\2_f\b\b\1\2`a\7\f\2\2ab\5\f\7\2bc\b\b\1"+
		"\2ce\3\2\2\2d`\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\17\3\2\2\2hf\3\2"+
		"\2\2ij\7\23\2\2jp\b\t\1\2kl\7\17\2\2lp\b\t\1\2mn\7\16\2\2np\b\t\1\2oi"+
		"\3\2\2\2ok\3\2\2\2om\3\2\2\2p\21\3\2\2\2\n!\60:EP[fo";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
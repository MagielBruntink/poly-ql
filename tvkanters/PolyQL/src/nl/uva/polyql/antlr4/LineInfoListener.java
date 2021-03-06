package nl.uva.polyql.antlr4;

import nl.uva.polyql.antlr4.QuestionnaireParser.CalcquestionContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_andContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_atomContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_eqContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_numContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_orContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_prodContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_sumContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.Expr_unaryContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.IfstatementContext;
import nl.uva.polyql.antlr4.QuestionnaireParser.QuestionContext;
import nl.uva.polyql.ast.LineInfo;

public class LineInfoListener extends QuestionnaireBaseListener {

    @Override
    public void exitCalcquestion(final CalcquestionContext ctx) {
        if (ctx.cq != null) {
            ctx.cq.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitQuestion(final QuestionContext ctx) {
        if (ctx.q != null) {
            ctx.q.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitIfstatement(final IfstatementContext ctx) {
        if (ctx.is != null) {
            ctx.is.setLineInfo(new LineInfo(ctx));
        }
        if (ctx.es != null) {
            ctx.es.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitExpr_and(final Expr_andContext ctx) {
        if (ctx.e != null) {
            ctx.e.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitExpr_atom(final Expr_atomContext ctx) {
        if (ctx.e != null) {
            ctx.e.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitExpr_eq(final Expr_eqContext ctx) {
        if (ctx.e != null) {
            ctx.e.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitExpr_num(final Expr_numContext ctx) {
        if (ctx.e != null) {
            ctx.e.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitExpr_or(final Expr_orContext ctx) {
        if (ctx.e != null) {
            ctx.e.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitExpr_prod(final Expr_prodContext ctx) {
        if (ctx.e != null) {
            ctx.e.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitExpr_sum(final Expr_sumContext ctx) {
        if (ctx.e != null) {
            ctx.e.setLineInfo(new LineInfo(ctx));
        }
    }

    @Override
    public void exitExpr_unary(final Expr_unaryContext ctx) {
        if (ctx.e != null) {
            ctx.e.setLineInfo(new LineInfo(ctx));
        }
    }
}

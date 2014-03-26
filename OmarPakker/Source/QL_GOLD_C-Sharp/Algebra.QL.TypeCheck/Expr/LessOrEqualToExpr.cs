﻿using System;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
    public class LessOrEqualToExpr : BinaryExpr, ITypeCheckExpr
    {
        private static readonly ITypeCheckType ExpressionUpperBound = new RealType();

        public LessOrEqualToExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }

        public override ITypeCheckType TypeCheck(TypeEnvironment env)
        {
            ITypeCheckType a = Expr1.TypeCheck(env);
            ITypeCheckType b = Expr2.TypeCheck(env);

            if (!a.CompatibleWith(ExpressionUpperBound) || !a.CompatibleWith(b))
            {
                env.ReportError(String.Format("Comparison using '<=' not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
                    a, b), SourceStartPosition, SourceEndPosition);
            }

            return new BoolType();
        }
    }
}

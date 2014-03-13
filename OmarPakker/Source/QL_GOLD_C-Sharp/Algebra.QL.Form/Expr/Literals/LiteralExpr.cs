﻿using System;
using Algebra.QL.Core.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public abstract class LiteralExpr<V> : LiteralExpr<IFormType, V>, IFormExpr
    {
        public event Action ValueChanged;
        public virtual object ExpressionValue
        {
            get { return Value; }
            set
            {
                Value = (V)value;
                if (ValueChanged != null)
                {
                    ValueChanged();
                }
            }
        }
        public IFormType ExpressionType { get { return Type; } }

        protected LiteralExpr(V value)
            : base(value)
        {

        }

        public abstract IFormExpr Clone();

        public void Dispose()
        {
            ExpressionValue = default(V);
        }
    }
}
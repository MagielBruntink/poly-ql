﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions
{
    public class Unary_Expression : IExpression
    {
        protected IExpression _left;
        protected Type _typeLeft;
        protected int _linenr;

        public Unary_Expression(IExpression left, int linenr)
        {
            this._left = left;
            this._linenr = linenr;
        }

        public Type Type
        {
            get
            {
                if (this._typeLeft != null)
                    return this._typeLeft;

                this._typeLeft = this._left.GetType();
                return this._typeLeft;
            }
        }

        public bool CheckType()
        {
            return this._left.CheckType();
        }
    }
}

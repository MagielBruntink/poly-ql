﻿using QSLib.Types;
using QSLib.Values;
using System.ComponentModel;

namespace QSLib.Expressions.Binary
{
    class Or : Binary_Expression
    {

        public Or(QSExpression a, QSExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "||";
        }

        public override Value Evaluate()
        {
            this._value = this._left.Evaluate().Or(this._right.Evaluate());
            this.OnPropertyChanged("GetValue");
            return this._value;
        }


        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}

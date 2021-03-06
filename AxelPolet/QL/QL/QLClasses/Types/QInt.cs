﻿using Antlr4.Runtime;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Types
{
    public class QInt : QType
    {
        public override QType GetType()
        {
            return this;
        }

        public override string ToString()
        {
            return "QInt";
        }

        public override QValue UndefinedValue()
        {
            return new IntValue(0);
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            return true;
        }

        #endregion

        #region Double Dispatch Implementation

        public override bool IsCompatibleWith(QType type)
        {
            return type.IsCompatibleWithQInt(this);
        }

        public override bool IsCompatibleWithQInt(QInt type)
        {
            return true;
        }

        #endregion
    }
}
﻿using Antlr4.Runtime;
using QL.TypeChecker;

namespace QL.QLClasses.Types
{
    public class QInt : QBaseType
    {
        public override QBaseType GetType()
        {
            return this;
        }

        public override string ToString()
        {
            return "QInt";
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            return true;
        }

        #endregion

        #region Double Dispatch Implementation

        public override bool IsCompatibleWith(QBaseType type)
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
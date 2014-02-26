﻿using QL.TypeChecker;

namespace QL.QLClasses.Types
{
    public class QBool : QBaseType
    {
        public override QBaseType GetType()
        {
            return this;
        }

        public override bool CheckType(ref QLTypeError error)
        {
            return true;
        }

        #region Double Dispatch Implementation

        public override bool IsCompatibleWith(QBaseType type)
        {
            return type.IsCompatibleWithQBool(this);
        }

        public override bool IsCompatibleWithQBool(QBool type)
        {
            return true;
        }

        #endregion
    }
}

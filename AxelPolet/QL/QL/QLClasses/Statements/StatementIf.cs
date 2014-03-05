﻿using System.Collections.Generic;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class StatementIf : StatementBase
    {
        private readonly ExpressionBase _condition;
        private readonly List<StatementBase> _body;
        private readonly StatementIf _elseIfStatement;

        public StatementIf(ExpressionBase condition, List<StatementBase> body, StatementIf elseIfStatement = null)
        {
            _condition = condition;
            _body = body;
            _elseIfStatement = elseIfStatement;
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            //when else statement, condition is null
            if (_condition != null)
            {
                if (!_condition.CheckType(typeErrors))
                    return false;

                if (!_condition.GetResultType().IsCompatibleWith(new QBool()))
                {
                    typeErrors.ReportError(new QLTypeError
                    {
                        Message = string.Format("Condition is not a boolean. Got QType '{0}'", _condition.GetResultType()),
                        TokenInfo = _condition.TokenInfo
                    });
                    return false;
                }
            }
            
            foreach (StatementBase statement in _body)
            {
                if (!statement.CheckType(typeErrors))
                    return false;
            }

            if (_elseIfStatement != null)
                return _elseIfStatement.CheckType(typeErrors);

            return true;
        }
    }
}

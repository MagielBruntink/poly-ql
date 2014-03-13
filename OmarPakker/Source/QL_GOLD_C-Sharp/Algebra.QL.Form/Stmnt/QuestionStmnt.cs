﻿using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Stmnt
{
    public class QuestionStmnt : TextExprStmnt<IFormExpr>, IFormStmnt
    {
        public QuestionStmnt(string text, IFormExpr e)
            : base(text, e)
        {

        }

        public FrameworkElement BuildForm()
        {
            StackPanel sp = new StackPanel();
            sp.Orientation = Orientation.Horizontal;
            sp.Children.Add(new Label() { Width = 200, Content = Text });
            sp.Children.Add(Expression.ExpressionType.BuildElement(Expression, true));

            return sp;
        }

        public IFormStmnt Clone()
        {
            return new QuestionStmnt(Text, Expression.Clone());
        }

        public void Dispose()
        {
            Expression.Dispose();
        }
    }
}
﻿using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Stmnt
{
    public class LabelStmnt : TextExprStmnt<IFormExpr>, IFormStmnt
    {
        public LabelStmnt(string text, IFormExpr e)
            : base(text, e)
        {

        }

        public FrameworkElement BuildForm(ValueEnvironment vEnv, TypeEnvironment tEnv)
        {
            StackPanel sp = new StackPanel();
            sp.Orientation = Orientation.Horizontal;
            sp.Children.Add(new Label() { Width = 200, Content = Text });
            sp.Children.Add(Expression.BuildForm(tEnv).BuildElement(Expression.Evaluate(vEnv), false));

            return sp;
        }
    }
}
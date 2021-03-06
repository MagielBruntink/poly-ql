﻿using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Form.Environment;

namespace Algebra.QL.Form.Stmnt
{
    public class StatementsStmnt : CompStmnt<IFormStmnt>, IFormStmnt
    {
        public StatementsStmnt(IFormStmnt a, IFormStmnt b)
            : base(a, b)
        {

        }

        public FrameworkElement BuildForm(IValueEnvironment vEnv, ITypeEnvironment tEnv)
        {
            StackPanel sp = new StackPanel();
            sp.Children.Add(Statement1.BuildForm(vEnv, tEnv));
            sp.Children.Add(Statement2.BuildForm(vEnv, tEnv));

            return sp;
        }
    }
}

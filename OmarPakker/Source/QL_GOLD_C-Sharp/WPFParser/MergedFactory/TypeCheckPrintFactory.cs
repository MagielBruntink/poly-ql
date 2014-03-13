﻿using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.TypeCheck.Factory;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Factory;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.Print.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;

namespace WPFParser.MergedFactory
{
    public class TypeCheckPrintFactory
		: ExtFactoryCombination<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType,
          IPrintExpr, IPrintStmnt, IPrintType, ExtTypeCheckFactory, PrintFactory>
    {
        public TypeCheckPrintFactory()
            : base(new ExtTypeCheckFactory(), new PrintFactory())
        {

        }
    }
}
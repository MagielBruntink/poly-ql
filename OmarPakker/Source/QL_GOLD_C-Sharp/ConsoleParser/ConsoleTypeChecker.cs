﻿using System;
using System.IO;
using System.Reflection;
using GOLD;
using Grammar;
using QL_Grammar.QLTypeCheck;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Factory;
using QL_Grammar.QLTypeCheck.Helpers;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace ConsoleParser
{
    public class ConsoleTypeChecker
	{
        public ConsoleTypeChecker()
            : base()
        {
			var parser = new QLParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckFactory>();
            parser.Factory = new QLTypeCheckFactory();

            parser.OnReduction += OnReduction;
            parser.OnCompletion += OnCompletion;
            parser.OnGroupError += OnGroupError;
            parser.OnInternalError += OnInternalError;
            parser.OnNotLoadedError += OnNotLoadedError;
            parser.OnLexicalError += OnLexicalError;
            parser.OnSyntaxError += OnSyntaxError;

            Assembly a = parser.Factory.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_Grammar.Grammar.QL_Grammar.egt")));
            parser.Parse(System.IO.File.OpenText(@"..\..\..\..\..\Grammar\QL_Test.txt"));
        }

        private void OnReduction(int line, int column, Reduction r, object newObj)
        {
            int count = r.Count();
            string dataOutput = String.Empty;

			for (int i = 0; i < count; i++)
			{
				object data = r.get_Data(i);
				if (data != null)
				{
					dataOutput += data;
				}
			}

            Console.WriteLine(String.Format("R: {0}, C: {1}, D: {2}", r.Parent.Text(), count, dataOutput));

			if (newObj is ITypeCheck)
			{
                ((ITypeCheck)newObj).SourcePosition = new Tuple<int, int>(line, column);
			}
        }

        private void OnCompletion(object root)
        {
            TypeCheckData data = new TypeCheckData();
			data.OnTypeCheckError += (msg, error) =>
			{
				Console.ForegroundColor = error ? ConsoleColor.Red : ConsoleColor.Yellow;
				Console.WriteLine(msg);
				Console.ResetColor();
			};

			((ITypeCheckStmnt)root).TypeCheck(data);
			data.VerifyTopDownDependencies();

            Console.WriteLine("PARSING COMPLETED!");
        }

		private void OnGroupError()
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine("ERROR: Unexpected EOF. (Group Error)");
			Console.ResetColor();
		}

		private void OnInternalError()
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine("ERROR: INTERNAL ERROR");
			Console.ResetColor();
		}

		private void OnNotLoadedError()
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine("ERROR: Grammar file was not loaded");
			Console.ResetColor();
		}

		private void OnLexicalError(int line, int column, object token)
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine(String.Format("ERROR: Unknown token '{0}' found on line {1} column {2}", token, line, column));
			Console.ResetColor();
		}

		private void OnSyntaxError(int line, int column, object token, string expected)
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine(String.Format("ERROR: Unexpected token '{0}' on line {1} column {2}. Expected: {3}",
				token, line, column, expected));
			Console.ResetColor();
		}
	}
}
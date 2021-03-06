﻿using QSLib.AST.Expressions.Literals;
using QSLib.AST.Expressions.Unary;
using QSLib;
using QSLib.AST.Types;
using QSLib.Visitors;
using System;
namespace QSLib.AST.Statements
{
    public class Question : IStatement
    {
        private string _id;
        private string _text;
        private int _lineNr;
        private QSType _type;

        #region Constructors
        public Question(QSType type, string text, string id, int lineNr)
        {
            this._type = type;
            this._text = text;
            this._id = id;
            this._lineNr = lineNr;
        }
        #endregion

        #region Getters
        public string Id
        {
            get
            {
                return this._id;
            }
        }

        public QSType Type
        {
            get
            {
                return this._type;
            }
        }

        public string Text
        {
            get
            {
                return this._text.ToString();
            }
        }

        public int Line
        {
            get
            {
                return this._lineNr;
            }
        }
        #endregion

        #region TypeChecker
        public T Accept<T>(IStatementVisitor<T> checker)
        {
            return (T)checker.Visit(this);
        }
        #endregion

    }

}

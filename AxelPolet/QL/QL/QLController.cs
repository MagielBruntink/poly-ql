﻿using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using QL.Interpreter;
using QL.QLClasses;
using QL.TypeChecker;

namespace QL
{
    public class QLController
    {
        private QLParser _parser;
        private IParseTree _parseTree;
        
        public Questionnaire AST { get; private set; }
        
        public List<string> LexerErrors { get; private set; }
        public List<string> ParserErrors { get; private set; }
        
        public QLMemory Memory { get; private set; }  
        public QLTypeChecker TypeChecker { get; private set; }
        
        public QLController()
        {
            LexerErrors = new List<string>();
            ParserErrors = new List<string>();
            Memory = new QLMemory();
            TypeChecker = new QLTypeChecker();
        }

        public Questionnaire BuildAST(string inputString)
        {
            MemoryStream inputStream = new MemoryStream(Encoding.UTF8.GetBytes(inputString ?? ""));

            AntlrInputStream antlrInputStream = new AntlrInputStream(inputStream);
            QLLexer lexer = new QLLexer(antlrInputStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            _parser = new QLParser(tokens);

            //Replaxe lexer/parser error listeners
            lexer.RemoveErrorListeners();
            _parser.RemoveErrorListeners();
            lexer.AddErrorListener(new LexerErrorListener() { OnError = LexerErrors.Add });
            _parser.AddErrorListener(new ParserErrorListener() { OnError = ParserErrors.Add });

            //set manager on partial parser class
            _parser.SetIdManager(Memory);

            //build AST
            _parseTree = _parser.questionnaire();
            AST = _parser.GetAST();

            //check for lexer/parser errors
            if (!LexerErrors.Any() && !ParserErrors.Any())
            {
                TypeChecker.Run(AST);
            }

            return AST;
        }

        public void GenerateGUI()
        {
            QLGuiBuilder guiBuilder = new QLGuiBuilder();
            AST.Build(guiBuilder);

            GUIMain main = new GUIMain(guiBuilder.GetGUI());
            main.Initialize();
            main.ShowDialog();
        }

        public string GetParseTreeString()
        {
            return _parseTree.ToStringTree(_parser);
        }
    }
}
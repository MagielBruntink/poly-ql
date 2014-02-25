package main.nl.uva.parser;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import main.nl.uva.g4.FormGrammarLexer;
import main.nl.uva.g4.FormGrammarParser;
import main.nl.uva.parser.elements.ParserForm;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(final String[] args) throws Exception {
        test3();
    }

    public static void test3() throws Exception {
        // Get sample file input stream
        File file = new File("questionaire.txt");
        FileInputStream fis = new FileInputStream(file);

        // create a CharStream that reads from file input stream
        ANTLRInputStream input = new ANTLRInputStream(fis);

        // create a lexer that feeds off of input CharStream
        FormGrammarLexer lexer = new FormGrammarLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        FormGrammarParser parser = new FormGrammarParser(tokens);

        List<ParserForm> pf = parser.forms().data;

        for (ParserForm f : pf) {
            System.out.println(f);
        }
    }
}

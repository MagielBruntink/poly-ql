package org.uva.sea.ql.parser.antlr.QL4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AntlrVisitor;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.DuplicateLabelChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.DuplicateQuestionChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.InvalidTypeChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.QLErrorVisitor;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.UndefQuestionChecker;

import QL4.QL4Lexer;
import QL4.QL4Parser;

/**
 * This class will request a file and attempt to visit it using QL4 parser
 * generated by applying antlr4 on QL4 grammar
 * 
 * @author Sammie Katt
 * 
 */
public class QL4 {

	/**
	 * Main function for the QL DSL language. 
	 * This class requests a file to parse, and generates
	 * a question UI.
	 * 
	 * @param args
	 *            are ignored
	 * @throws IOException
	 *             if ANTLRFileStream fails to find file
	 */
	public static void main(String[] args) throws IOException {

		// get questionary
		String fileToParse = chooseFile();

		// process file into tokens
		ANTLRFileStream fStream = new ANTLRFileStream(fileToParse);
		QL4Lexer lexer = new QL4Lexer(fStream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create antlr tree from tokens
		QL4Parser parser = new QL4Parser(tokens);
		ParseTree tree = parser.form();

		// parse antlr tree into own abstract tree
		AntlrVisitor ASTParser = new AntlrVisitor();
		Form ast = (Form) tree.accept(ASTParser);
		
		// perform checks on extracted AST
		List<QLErrorMsg> checks = checkErrors(ast);
		
		System.err.println(checks);
	}

	/**
	 * Uses JFileChooser to let the user browse and pick a file and returns the
	 * path
	 * 
	 * @return the path of the file the user has chosen
	 */
	private static String chooseFile() {
		// initiate JFileChooser and set settings
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Please choose the file to parse");
		chooser.setAcceptAllFileFilterUsed(false);

		// request file
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath();
		}

		// exit if no file was chosen
		System.err.println("Error at choosing file");
		System.exit(0);
		return null;
	}
	
	/**
	 * Checks a form for errors and warnings by visiting
	 * the form with several visitors 
	 * @param ast
	 * @return
	 */
	private static List<QLErrorMsg> checkErrors(Form ast) {
		// holds all errors and warning msgs generated
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		// the checker that will perform several checks on our ast input 
		QLErrorVisitor ASTChecker;
		
		ASTChecker = new UndefQuestionChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new DuplicateLabelChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new DuplicateQuestionChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new InvalidTypeChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		return msgs;
	}
}

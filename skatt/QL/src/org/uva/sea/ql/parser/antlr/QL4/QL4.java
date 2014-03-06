package org.uva.sea.ql.parser.antlr.QL4;

import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AntlrVisitor;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.QLVisitor;

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
		
		System.out.println(ast);
		
		// typecheck abstract tree
		QLVisitor ASTChecker = new QLVisitor();
		List<QLErrorMsg> checks = ast.accept(ASTChecker);
		
		System.out.println(checks);
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
}

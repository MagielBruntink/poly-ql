package org.uva.sea.ql.parser.antlr.QL4;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import QL4.*;

/**
 * This class will request a file and attempt to visit it using QL4 
 * parser generated by applying antlr4 on QL4 grammar
 * @author Sammie Katt
 *
 */
public class QL4 {
	
	/**
	 * Automatically called, ignores 
	 * @param args are ignored
	 * @throws Exception generated by incorrectly (according to QL4 grammar) syntax in files 
	 */
	public static void main(String[] args) throws Exception {
		
		String fileToParse = chooseFile();
		
		// create a CharStream that reads the file
		ANTLRInputStream iStream = new ANTLRInputStream(fileToParse);
		
		// create a lexer that from the input stream
		QL4Lexer lexer = new QL4Lexer(iStream);
		
		// create a tokens from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser from the tokens
		QL4Parser parser = new QL4Parser(tokens);
		
		// create a tree from the parser by initiating the top element
		ParseTree tree = parser.form(); 
		
		// visit the tree with our own QL4 visitor
		QL4Visitor visitor = new QL4Visitor();
		visitor.visit(tree);
		 
	}
	
	/**
	 * Uses JFileChooser to let the user browse and pick a file and returns the path
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
		System.exit(0);
		return null;
	}
}

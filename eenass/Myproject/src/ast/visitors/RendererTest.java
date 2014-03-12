package ast.visitors;

import gui.render.Renderer;

import javax.swing.SwingUtilities;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import typecheck.ErrorList;
import typecheck.SymbolTable;
import typecheck.TypeChecker;
import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;
import ast.statement.Form;

public class RendererTest {
	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			 @Override
			 public void run() {
				 Renderer r = new Renderer();
				 r.render(get_inputForm()).setVisible(true);
			 }
		 });
	 }
	 
	 public static Form get_inputForm(){
		 String form = "form Box1HouseOwning {" +
			 "\nhasSoldHouse: \"Did you sell a house in 2010?\" boolean}";
//			 "\nhasBoughtHouse: \"Did you by a house in 2010?\" boolean"+
//			 "\nhasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean"+
//			 "\nif (hasSoldHouse == false) {"+
//			 "\nsellingPrice: \"Price the house was sold for:\" integer "+
//			 "\nprivateDebt: \"Private debts for the sold house:\" integer"+
//			"\nvalueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)"+
//			"\n}"+
//			"\nelse {"+
//			"\nvalueResidue1: \"Value residue:\" integer(sellingPrice - privateDebt)"+
//			"\n}" +
//			"\n}";
		 ANTLRInputStream input = new ANTLRInputStream(form);
			QLangLexer lexer = new QLangLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			QLangParser parser = new QLangParser(tokens);
			ASTNode tree = parser.form().result;
					
			SymbolTable symb = new SymbolTable();
			ErrorList errors= new ErrorList();
			TypeChecker checker = new TypeChecker(symb, errors);
			boolean result = checker.check_symb(tree, symb, errors);
			System.out.println("result is " + result);
			if(result) return (Form) tree;
			return null;
		 
	 }
}

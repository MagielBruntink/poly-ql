package org.uva.sea.ql.parser.antlr.QL4;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Conditional;
import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Value.QL4Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Value.QL4Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Value.QL4Type;

import QL4.QL4BaseVisitor;
import QL4.QL4Parser;

/**
 * A visitor for the QL4 grammar. Visits a tree parsed by the Antlr4
 * generated QL4parser on the QL4 grammar. Extends the QL4BaseVisitor
 * generated by Antrl4 and implements any function that needs
 * a more sophisticated visit  than depth first
 * @author Sammie Katt
 *
 */
public class QL4Visitor extends QL4BaseVisitor<QL4Tree> {

  // Handles the information printed
  boolean verbose = true;

  /**
   * Specifies behavior when visiting the form 
   * it will simply visit its structures and return the tree
   * generated throughout the visiting process
   * 
   * @param ctx is the context of the structures
   * @return the generated tree by visiting its childs
   */
  public QL4Tree visitForm(QL4Parser.FormContext ctx) {
	  if (verbose) 
	      System.out.println("Visiting Form");
	
	  return new QL4Form(ctx.structures().accept(this));
  }
  
  /**
   * Returns a structures object, containing its structure in a list
   * 
   * @param ctx is the structures context from which structure(s) are extracted
   * @return the structures object
   */
  public QL4Tree visitStructures(QL4Parser.StructuresContext ctx) {
	  if (verbose)
		  System.out.println("Visiting structures");
		  
	  List<QL4Tree> structures = new ArrayList<QL4Tree>();
	  
	  for (QL4Parser.StructureContext struct : ctx.structure()) {
		  structures.add(struct.accept(this));
	  }
	  
	  return new QL4Structures(structures);
  }

  /**
   * Returns a conditional object containing the expressions
   * and structures of the if/elseif/else in the context
   * @param ctx the conditional context
   * @return a conditional object 
   */
  public QL4Tree visitConditional(QL4Parser.ConditionalContext ctx) {
	 if (verbose)  
		 System.out.println("Visiting conditional");
	 
	 // define if/else (if available) conditions
	 QL4Tree ifExpr = ctx.ifexpr.accept(this);
	 QL4Tree ifStruc = ctx.ifstruc.accept(this);
	 QL4Tree elseStruc = null;
	 
	 if (ctx.elsestruc != null) {
		 elseStruc = ctx.elsestruc.accept(this);
	 } 
	 
	 // define elseifConditions and their structs by looping over them in ctx
	 List<QL4Tree> elseifExprs = new ArrayList<QL4Tree>();
	 List<QL4Tree> elseifStrucs = new ArrayList<QL4Tree>();
	 /*
	 for (QL4Parser.ExpressionContext elseifExpr : ctx.) {
		 elseifConditions.add(elseif.accept(this));
	 }
	 */
	 
	 return new QL4Conditional(ifExpr, elseifExprs, 
			 ifStruc, elseifStrucs, elseStruc);
  }
  
  /**
   * Returns a question object, containing its content:
   * Type, label, id and value (question.computed is false)
   * @param ctx regquestion context
   * @return a ql4question object
   */
  public QL4Tree visitRegQuestion(QL4Parser.RegQuestionContext ctx) {
	  if (verbose) 
		  System.out.println("Visiting RegQuestion");
	  
	  QL4Tree id = new QL4Identifier(ctx.IDENTIFIER().getText());
	  QL4Tree label = new QL4Label(ctx.LABEL().getText());
	  QL4Tree type = new QL4Type(ctx.TYPE().getText());
	  
	  return new QL4Question(id, label, type); 
  }
  
  /**
   * Returns a Question object, containing its content:
   * Type, label, id and value (question.computed is true)
   * @param ctx computed question context
   * @return a qlquestion object
   */
  public QL4Tree visitCompQuestion(QL4Parser.CompQuestionContext ctx) {
	  if (verbose) 
		  System.out.println("Visiting CompQuestion");
	  
	  QL4Tree id = new QL4Identifier(ctx.IDENTIFIER().getText());
	  QL4Tree label = new QL4Label(ctx.LABEL().getText());
	  QL4Tree type = new QL4Type(ctx.TYPE().getText());
	  QL4Tree value = ctx.expression().accept(this);
	  
	  return new QL4Question(id, label, type, value); 
  }
}

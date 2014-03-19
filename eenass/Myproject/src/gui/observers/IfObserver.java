package gui.observers;

import gui.Evaluator;
import gui.render.State;

import javax.swing.JComponent;

import ast.expr.Identifier;
import ast.expr.evaluate.Bool;
import ast.expr.evaluate.Value;
import ast.statement.IfStatement;

public class IfObserver extends ControlObserver{
	
	private final IfStatement ifStat;
	protected JComponent ifPanel;
	private final State state;

	public IfObserver(IfStatement ifStat, JComponent ifComp, State state) {
		super();
		this.ifStat = ifStat;
		this.ifPanel = ifComp;
		this.state = state;		
	}
	
	@Override
	public void evaluate() {
		Value val = ifStat.getExpr().accept(new Evaluator(state.getEnvValues())); 
		boolean visible = ((Bool)val).getValue();
		ifPanel.setVisible(visible);	
	}

}

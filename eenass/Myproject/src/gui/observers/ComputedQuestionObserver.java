package gui.observers;

import gui.Evaluator;
import gui.component.ComputedWidget;
import gui.render.State;
import ast.expr.value.Value;
import ast.statement.ComputedQuestion;

public class ComputedQuestionObserver extends WidgetObserver{
	
	private ComputedQuestion statement;
	private ComputedWidget panel;
	private State state;

	public ComputedQuestionObserver(ComputedQuestion statement, ComputedWidget panel, State state) {
		this.statement = statement;
		this.panel = panel;
		this.state = state;
	}

	@Override
	public void evaluate() {
		Value val = statement.getExpr().accept(new Evaluator(state.getEnvValues()));
		panel.setValue(val);
		panel.getComponent().setVisible(true);
		
	}

}

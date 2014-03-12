package org.uva.sea.ql.gui.widget;

import java.util.Observable;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.State;

public abstract class Control extends Observable {

	private Identifier identifier;
	private State state;
	private Value value;
	
	public Control(Identifier identifier, State state) {
		this.identifier = identifier;
		this.state = state;
	}

	public abstract JComponent UIElement();

	public abstract void setEnabled(boolean isEnabled);

	public abstract void setValue(Value value);
	
	public Value getValue(){
		return value;
	}
	
	public State getState(){
		return state;
	}
	
	public Identifier getIdentifier(){
		return identifier;
	}
}

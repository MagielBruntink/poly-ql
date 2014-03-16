package edu.uva.softwarecons.ui;

import edu.uva.softwarecons.model.value.StringValue;
import edu.uva.softwarecons.model.value.Value;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class InputQuestionHBox extends QuestionHBox{

    protected final TextField textField;

    protected InputQuestionHBox(String questionId, boolean textFieldDisabled, EventHandler<ActionEvent> eventHandler,  TextField textField) {
        super(questionId);
        this.textField = textField;
        textField.setDisable(textFieldDisabled);
        getChildren().add(textField);
        textField.setId(questionId);
        textField.setOnAction(eventHandler);
    }

    @Override
    public Value getValue() {
        return new StringValue(textField.getText());
    }

    @Override
    public void updateValue(Node node) {
        textField.setText(((TextField)node).getText());
    }
}

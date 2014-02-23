package nl.uva.polyql.model.expressions;

import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Types;

public abstract class Expression {

    public abstract Types getReturnType();

    public abstract Object getValue();

    public abstract Set<Question> getReferencedQuestions();
}

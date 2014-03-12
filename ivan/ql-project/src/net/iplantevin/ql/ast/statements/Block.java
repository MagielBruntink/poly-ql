package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.visitors.IStatementVisitor;

import java.util.List;

/**
 * Block: a list of statements.
 *
 * @author Ivan
 */
public class Block extends Statement {
    private final List<Statement> statements;

    public Block(List<Statement> statements, LineInfo lineInfo) {
        super(lineInfo);
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        String block = "\n{\n";
        for (Statement statement : statements) {
            block += statement.toString();
        }
        block += "}\n";
        return block;
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

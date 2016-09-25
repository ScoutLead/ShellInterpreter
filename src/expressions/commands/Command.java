package expressions.commands;

import expressions.AbstractExpression;
import expressions.Variable;

import java.util.List;

/**
 * Created by Yurii on 18.09.2016.
 */
public abstract class  Command implements AbstractExpression {
    protected List<Flag> flags;
    protected List<Variable> arguments;
}

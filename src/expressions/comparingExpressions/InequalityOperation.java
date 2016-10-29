package expressions.comparingExpressions;

import expressions.AbstractExpression;
import expressions.BooleanExpression;
import expressions.NumberExpression;

/**
 * Created by Yurii on 29.10.2016.
 */
public abstract class InequalityOperation implements AbstractExpression {
    protected double a;
    protected double b;
    protected InequalityOperation(NumberExpression a, NumberExpression b) {
        this.a = ((Number) a.interpret()).doubleValue();
        this.b = ((Number) b.interpret()).doubleValue();
    }

}

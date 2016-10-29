package expressions.comparingExpressions;

import expressions.NumberExpression;

/**
 * Created by Yurii on 29.10.2016.
 */
public class EqualExpression extends InequalityOperation {
    protected EqualExpression(NumberExpression a, NumberExpression b) {
        super(a, b);
    }

    @Override
    public Object interpret() {
        return a == b;
    }
}

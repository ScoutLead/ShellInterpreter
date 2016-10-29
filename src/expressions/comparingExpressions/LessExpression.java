package expressions.comparingExpressions;

import expressions.NumberExpression;

/**
 * Created by Yurii on 29.10.2016.
 */
public class LessExpression extends InequalityOperation {
    protected LessExpression(NumberExpression a, NumberExpression b) {
        super(a, b);
    }

    @Override
    public Object interpret() {
        return a < b;
    }
}

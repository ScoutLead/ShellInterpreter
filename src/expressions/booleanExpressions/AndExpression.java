package expressions.booleanExpressions;

import expressions.BooleanExpression;

/**
 * Created by Yurii on 29.10.2016.
 */
public class AndExpression extends BooleanOperation {
    protected AndExpression(BooleanExpression a, BooleanExpression b) {
        super(a, b);
    }

    @Override
    public Object interpret() {
        return a && b;
    }
}

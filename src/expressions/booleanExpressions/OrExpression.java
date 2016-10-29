package expressions.booleanExpressions;

import expressions.BooleanExpression;

/**
 * Created by Yurii on 29.10.2016.
 */
public class OrExpression extends BooleanOperation {
    protected OrExpression(BooleanExpression a, BooleanExpression b) {
        super(a, b);
    }

    @Override
    public Object interpret() {
        return a || b;
    }
}

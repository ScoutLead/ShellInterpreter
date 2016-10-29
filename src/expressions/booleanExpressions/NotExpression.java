package expressions.booleanExpressions;

import expressions.BooleanExpression;

/**
 * Created by Yurii on 29.10.2016.
 */
public class NotExpression extends BooleanOperation{
    protected NotExpression(BooleanExpression a) {
        super(a);
    }

    @Override
    public Object interpret() {
        return !a;
    }
}

package expressions.booleanExpressions;

import expressions.AbstractExpression;
import expressions.BooleanExpression;

import javax.swing.*;

/**
 * Created by Yurii on 29.10.2016.
 */
public abstract class BooleanOperation implements AbstractExpression {
    protected boolean a;
    protected boolean b;
    protected BooleanOperation(BooleanExpression a, BooleanExpression b) {
        this.a = (boolean)a.interpret();
        this.b = (boolean)b.interpret();
    }

    protected BooleanOperation(BooleanExpression a) {
        this.a = (boolean)a.interpret();
        this.b = false;
    }

}

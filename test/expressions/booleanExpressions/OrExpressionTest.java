package expressions.booleanExpressions;

import expressions.BooleanExpression;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yurii on 29.10.2016.
 */
public class OrExpressionTest {

    @Test
    public void interpret_TrueExpr_FalseExpr_ReturnTrue() {
        BooleanExpression trueExpr = new BooleanExpression("true");
        BooleanExpression falseExpr = new BooleanExpression("false");
        OrExpression and = new OrExpression(trueExpr, falseExpr);
        boolean expected = true;

        boolean actual = (boolean) and.interpret();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void interpret_FalseExpr_FalseExpr_ReturnFalse() {
        BooleanExpression trueExpr1 = new BooleanExpression("false");
        BooleanExpression trueExpr2 = new BooleanExpression("false");
        OrExpression and = new OrExpression(trueExpr1, trueExpr2);
        boolean expected = false;

        boolean actual = (boolean) and.interpret();

        Assert.assertEquals(expected,actual);
    }
}

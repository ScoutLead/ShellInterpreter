package expressions.booleanExpressions;

import expressions.BooleanExpression;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yurii on 29.10.2016.
 */
public class AndExpressionTest {

    @Test
    public void interpret_TrueExpr_FalseExpr_ReturnFalse() {
        BooleanExpression trueExpr = new BooleanExpression("true");
        BooleanExpression falseExpr = new BooleanExpression("false");
        AndExpression and = new AndExpression(trueExpr, falseExpr);
        boolean expected = false;

        boolean actual = (boolean) and.interpret();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void interpret_TrueExpr_TrueExpr_ReturnTrue() {
        BooleanExpression trueExpr1 = new BooleanExpression("true");
        BooleanExpression trueExpr2 = new BooleanExpression("true");
        AndExpression and = new AndExpression(trueExpr1, trueExpr2);
        boolean expected = true;

        boolean actual = (boolean) and.interpret();

        Assert.assertEquals(expected,actual);
    }
}

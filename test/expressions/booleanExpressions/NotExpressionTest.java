package expressions.booleanExpressions;

import expressions.BooleanExpression;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yurii on 29.10.2016.
 */
public class NotExpressionTest {
    @Test
    public void interpret_TrueExpr_ReturnFalse() {
        BooleanExpression trueExpr = new BooleanExpression("true");

        NotExpression not = new NotExpression(trueExpr);
        boolean expected = false;

        boolean actual = (boolean) not.interpret();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void interpret_FalseExpr_ReturnTrue() {
        BooleanExpression falseExpr = new BooleanExpression("false");
        NotExpression not = new NotExpression(falseExpr);
        boolean expected = true;

        boolean actual = (boolean) not.interpret();

        Assert.assertEquals(expected,actual);
    }
}

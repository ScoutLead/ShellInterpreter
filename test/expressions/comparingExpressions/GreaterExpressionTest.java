package expressions.comparingExpressions;

import expressions.NumberExpression;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yurii on 29.10.2016.
 */
public class GreaterExpressionTest {
    @Test
    public void interpret_NumberExprInt_NumberExprInt_ReturnTrue() {
        NumberExpression intExpr1 = new NumberExpression("234");
        NumberExpression intExpr2 = new NumberExpression("240");
        GreaterExpression less = new GreaterExpression(intExpr2,intExpr1);
        boolean expected = true;

        boolean actual = (boolean) less.interpret();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void interpret_NumberExprDouble_NumberExprInt_ReturnFalse() {
        NumberExpression intExpr1 = new NumberExpression("241.77777777");
        NumberExpression intExpr2 = new NumberExpression("240");
        GreaterExpression less = new GreaterExpression(intExpr2,intExpr1);
        boolean expected = false;

        boolean actual = (boolean) less.interpret();

        Assert.assertEquals(expected,actual);
    }
}

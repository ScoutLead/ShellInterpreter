package expressions.comparingExpressions;

import expressions.BooleanExpression;
import expressions.NumberExpression;
import expressions.booleanExpressions.AndExpression;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yurii on 29.10.2016.
 */
public class LessExpressionTest {

    @Test
    public void interpret_NumberExprInt_NumberExprInt_ReturnTrue() {
        NumberExpression intExpr1 = new NumberExpression("234");
        NumberExpression intExpr2 = new NumberExpression("240");
        LessExpression less = new LessExpression(intExpr1, intExpr2);
        boolean expected = true;

        boolean actual = (boolean) less.interpret();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void interpret_NumberExprDouble_NumberExprInt_ReturnFalse() {
        NumberExpression intExpr1 = new NumberExpression("239.77777777");
        NumberExpression intExpr2 = new NumberExpression("240");
        LessExpression less = new LessExpression(intExpr2, intExpr1);
        boolean expected = false;

        boolean actual = (boolean) less.interpret();

        Assert.assertEquals(expected,actual);
    }
}

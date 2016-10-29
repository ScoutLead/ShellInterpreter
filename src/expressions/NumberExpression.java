package expressions;



/**
 * Created by Yurii on 02.10.2016.
 */
public class NumberExpression extends StringLiteralExpression {

    public NumberExpression(final String  value) {
        super(value);
    }
    @Override
    public Object interpret() {
        try {
            Integer a = Integer.valueOf(value);
            return a;
        } catch (NumberFormatException e){
            return Double.valueOf(value);
        }

    }

}

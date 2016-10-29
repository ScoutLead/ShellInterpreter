package expressions;

/**
 * Created by Yurii on 29.10.2016.
 */
public class BooleanExpression extends StringLiteralExpression {
    public BooleanExpression(String value) {
        super(value);
    }

    @Override
    public Object interpret() {
        Boolean a = Boolean.valueOf(value);
        return a;

    }
}

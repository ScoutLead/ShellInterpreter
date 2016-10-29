package expressions;

/**
 * Created by Yurii on 18.09.2016.
 */
public class Variable extends StringLiteralExpression{
    private String name;

    private AbstractExpression expression;

    public Variable(String name, AbstractExpression expression) {
        super((String) expression.interpret());
        this.name = name;
        this.expression = expression;
    }

    @Override
    public Object interpret() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

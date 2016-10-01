package lexical_analizator;

/**
 * Created by Yurii on 25.09.2016.
 */
public class Token {
    private TokenType type;

    private Object value;

    public Token(Object ob, TokenType type) {
        value = ob;
        this.type = type;
    }

    private TokenType createTokenType(Object t) {
        if(t instanceof String) {
            String s = t.toString();
            if(s.matches("^([-+/*])")) {
                return  TokenType.OPERATOR;
            } else if(s.matches("^([0-9]*[.])?[0-9]+$")) {
                return TokenType.NUMBER;
            }
        }
        return TokenType.UNDEFINED;
    }

    public TokenType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (type != token.type) return false;
        return value != null ? value.equals(token.value) : token.value == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}

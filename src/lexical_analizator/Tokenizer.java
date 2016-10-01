package lexical_analizator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yurii on 26.09.2016.
 */
public class Tokenizer {
    private String context;
    private String anySymbolRegex = "(.*\\s*)|(\\s*.w*)";
    private List<Token> tokens = new ArrayList<>();
    public Tokenizer(String context) {
        this.context = context;
    }

    public void tokenize() throws Exception {
        tokenize(context);
    }

    private void tokenize(String context) throws Exception {
        int index = -1;
        if(context.isEmpty())return;
        if(isOperator(context)) {
            index = addToken(context, "^([*\\-\\+\\/\\=])", TokenType.OPERATOR);
        } else if(isNumber(context)) {
            index = addToken(context, "^([0-9]*[.])?[0-9]+", TokenType.NUMBER);
        } else if(isSign(context)){
            index = addToken(context, "^[\\(\\{\\)\\}\\;\\,]", TokenType.SIGN);
        } else if(isReservedWord(context)){
            index = addToken(context, "^(if|while)", TokenType.RESERVED_WORD);
        } else if(isString(context)){
            index = addToken(context, "^'.*'", TokenType.STRING);
        } else if(isVariable(context)){
            index = addToken(context, "^\\$[_a-zA-Z]\\w*", TokenType.VARIABLE);
        } else if(isFlag(context)){
            index = addToken(context, "^&[a-zA-Z]", TokenType.FLAG);
        } else if(isCommand(context)){
            index = addToken(context, "^(cd|print)", TokenType.COMMAND);
        }  else if(!isWhiteSpaces(context)){
            tokens.add(new Token(context, TokenType.UNDEFINED));
        }
        if(index != -1)
        tokenize(context.substring(index));

    }

    private boolean isFlag(String context) {
        return context.matches("^\\s*&[a-zA-Z].*");
    }

    private boolean isCommand(String context) {
        return context.matches("^\\s*(cd|print) *\\(.*");
    }

    private boolean isWhiteSpaces(String context) {
        return context.matches("^\\s*");
    }

    private boolean isVariable(String context) {
        return context.matches("^\\s*\\$[_a-zA-Z]\\w*.*");
    }

    private boolean isReservedWord(String context) {
        return context.matches("^\\s*(if|while) *\\(.*");
    }

    private boolean isString(String context) {
        return context.matches("^\\s*'.*'.*");
    }


    private boolean isSign(String context) {
        return context.matches("^\\s*[\\(\\{\\)\\}\\;\\,].*");
    }

    private boolean isOperator(String context) {
        return context.matches("^\\s*([\\-\\+\\/*\\=]).*");
    }

    private boolean isNumber(String context) {
        return context.matches("^\\s*([0-9]*[.])?[0-9]+.*");
    }


    private int addToken(String context,String regex, TokenType type) {

        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(context.replaceFirst("^ *",""));
        String token = "";
        if(matcher.find()){
            token = matcher.group();
            tokens.add(new Token(token, type));
        }
        return context.indexOf(token)+token.length();
    }

    public List<Token> getResult() {
        return Collections.unmodifiableList(tokens);
    }
}

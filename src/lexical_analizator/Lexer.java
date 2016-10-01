package lexical_analizator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yurii on 25.09.2016.
 */
public class Lexer {
    public static List<Token> tokenize(String s) throws Exception {
        Tokenizer tokenizer = new Tokenizer(s);
        tokenizer.tokenize();
        return tokenizer.getResult();
//        ArrayList<Token> tokens = new ArrayList<>();
//        if(s.isEmpty())return tokens;
//        StringBuilder builder = new StringBuilder(s);
//        char[] array = s.toCharArray();
//        for(int i = 0;i<array.length;i++) {
//            if(String.valueOf(builder.charAt(i)).matches("^([-+/*])")) {
//                tokens.add(new Token(String.valueOf(builder.charAt(i)),TokenType.OPERATOR));
//            } else if(builder.substring(i).matches("^([0-9]*[.])?[0-9]+")) {
//                Pattern p = Pattern.compile("^([0-9]*[.])?[0-9]+");
//                Matcher matcher = p.matcher(builder.substring(i));
//                if(matcher.find()){
//                    tokens.add(new Token(matcher.group(),TokenType.NUMBER));
//                }
//            }  else {
//                tokens.add(new Token(builder.substring(i), TokenType.UNDEFINED));
//            }
//        }
//
//        return tokens;
    }
}

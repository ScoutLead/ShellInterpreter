package lexical_analizator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Yurii on 25.09.2016.
 */
public class LexerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void tokenize_emptyExpression_returnEmptyToken() {
        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean expected = true;

        boolean actual = tokens.isEmpty();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tokenize_singlePlusOperator_returnTokenWithOperator() {
        Token expected = new Token("+", TokenType.OPERATOR);

        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("+");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Token actual = tokens.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tokenize_singleStringWithSpaces_returnTokenWithString() {
        List<Token> expected = new ArrayList<>();
        expected.add(new Token("'hi'", TokenType.STRING));

        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("   'hi'  ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, tokens);
    }

    @Test
    public void tokenize_singleFlagWithSpaces_returnTokenWithFlag() {
        List<Token> expected = new ArrayList<>();
        expected.add(new Token("&a", TokenType.FLAG));

        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("   &a  ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, tokens);
    }

    @Test
    public void tokenize_singleVariable_returnTokenWithVariable() {
        List<Token> expected = new ArrayList<>();
        expected.add(new Token("$expected", TokenType.VARIABLE));
        expected.add(new Token("=", TokenType.OPERATOR));
        expected.add(new Token("5", TokenType.NUMBER));
        expected.add(new Token(";", TokenType.SIGN));

        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("$expected = 5;");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, tokens);
    }

    @Test
    public void tokenize_singleCommand_returnTokens() {
        List<Token> expected = new ArrayList<>();
        expected.add(new Token("cd", TokenType.COMMAND));
        expected.add(new Token("(", TokenType.SIGN));
        expected.add(new Token("'D:\\Univer'", TokenType.STRING));
        expected.add(new Token(")", TokenType.SIGN));
        expected.add(new Token(";", TokenType.SIGN));

        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("cd ('D:\\Univer')  ;");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, tokens);
    }

    @Test
    public void tokenize_singleCommandWithFlag_returnTokens() {
        List<Token> expected = new ArrayList<>();
        expected.add(new Token("cd", TokenType.COMMAND));
        expected.add(new Token("(", TokenType.SIGN));
        expected.add(new Token("&f", TokenType.FLAG));
        expected.add(new Token(",", TokenType.SIGN));
        expected.add(new Token("&d", TokenType.FLAG));
        expected.add(new Token(",", TokenType.SIGN));
        expected.add(new Token("'D:\\Univer'", TokenType.STRING));
        expected.add(new Token(")", TokenType.SIGN));
        expected.add(new Token(";", TokenType.SIGN));

        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("cd (&f,&d,'D:\\Univer')  ;");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, tokens);
    }

    @Test
    public void tokenize_singleCommandWithVariables_returnTokens() {
        List<Token> expected = new ArrayList<>();
        expected.add(new Token("cd", TokenType.COMMAND));
        expected.add(new Token("(", TokenType.SIGN));
        expected.add(new Token("$a", TokenType.VARIABLE));
        expected.add(new Token(")", TokenType.SIGN));
        expected.add(new Token(";", TokenType.SIGN));

        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("cd ($a)  ;");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, tokens);
    }

    @Test
    public void tokenize_MinusOperatorAndNumber_returnTokens() {
        Token expectedMinus = new Token("-", TokenType.OPERATOR);
        Token expectedNumber = new Token("5", TokenType.NUMBER);
        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(expectedMinus);
        expectedTokens.add(expectedNumber);


        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("-5");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expectedTokens, tokens);
    }

    @Test
    public void tokenize_MinusOperatorAndNumberWithSpaces_returnTokens()  {
        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token("1", TokenType.NUMBER));
        expectedTokens.add(new Token("+", TokenType.OPERATOR));
        expectedTokens.add(new Token("12.5", TokenType.NUMBER));


        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize(" 1 +  12.5");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expectedTokens, tokens);
    }

    @Test
    public void tokenize_ComplexExpression_returnTokens() {
        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token("1", TokenType.NUMBER));
        expectedTokens.add(new Token("+", TokenType.OPERATOR));
        expectedTokens.add(new Token("2", TokenType.NUMBER));
        expectedTokens.add(new Token("*", TokenType.OPERATOR));
        expectedTokens.add(new Token("3", TokenType.NUMBER));
        expectedTokens.add(new Token("/", TokenType.OPERATOR));
        expectedTokens.add(new Token("(", TokenType.SIGN));
        expectedTokens.add(new Token("4", TokenType.NUMBER));
        expectedTokens.add(new Token("-", TokenType.OPERATOR));
        expectedTokens.add(new Token("5", TokenType.NUMBER));
        expectedTokens.add(new Token(")", TokenType.SIGN));


        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("1+2 *3 /  (4-5)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expectedTokens, tokens);
    }

    @Test
    public void tokenize_BlockOfCode_returnTokens() {
        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token("$a", TokenType.VARIABLE));
        expectedTokens.add(new Token("=", TokenType.OPERATOR));
        expectedTokens.add(new Token("1", TokenType.NUMBER));
        expectedTokens.add(new Token("while", TokenType.RESERVED_WORD));
        expectedTokens.add(new Token("(", TokenType.SIGN));
        expectedTokens.add(new Token("$a", TokenType.VARIABLE));
        expectedTokens.add(new Token(")", TokenType.SIGN));
        expectedTokens.add(new Token("{", TokenType.SIGN));
        expectedTokens.add(new Token("cd", TokenType.COMMAND));
        expectedTokens.add(new Token("(", TokenType.SIGN));
        expectedTokens.add(new Token("&d", TokenType.FLAG));
        expectedTokens.add(new Token(",", TokenType.SIGN));
        expectedTokens.add(new Token("'sdf'", TokenType.STRING));
        expectedTokens.add(new Token(")", TokenType.SIGN));
        expectedTokens.add(new Token(";", TokenType.SIGN));
        expectedTokens.add(new Token("}", TokenType.SIGN));


        List<Token> tokens = null;
        try {
            tokens = Lexer.tokenize("$a=1;\n while($a){cd( &d, 'sdf' )  ; \n}");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expectedTokens, tokens);
    }


}
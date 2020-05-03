/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerdesign;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fozca
 */
public class Tokenizer {

    private ArrayList<TokenData> tokenList;
    private String str;
    private Token lastToken;
    private boolean pushBack;
    String[] keywords = {"boolean", "break", "catch", "char", "continue", "do", "double", "else", "float", "for", "if", "int", "String", "while", "true", "false", "+", "-", "*", "/", "%", "(", ")", "{", "}", "[", "]", ";", ",", ".", "&&", "||", "=="};

    public Tokenizer(String str) {
        this.tokenList = new ArrayList<TokenData>();
        this.str = str;

    //    tokenList.add(new TokenData(Pattern.compile("^((-)?[0-9]+)"), TokenType.INTEGER_LITERAL));
        tokenList.add(new TokenData(Pattern.compile("[a-c]"), TokenType.STRING_LITERAL));
    }

    public Token nextToken() {
        str = str.trim();
        if (pushBack) {
            pushBack = false;
            return lastToken;
        }
        if (str.isEmpty()) {
            return (lastToken = new Token("", TokenType.EMPTY));
        }
        for (TokenData data : tokenList) {
            Matcher matcher = data.getPattern().matcher(str);
            if (matcher.find()) {
                String token = matcher.group().trim();
                str = matcher.replaceFirst("");
                if (data.getType() == TokenType.STRING_LITERAL) {
                    return (lastToken = new Token(token, TokenType.STRING_LITERAL));
                } else {
                    return (lastToken = new Token(token, data.getType()));
                }
            }
        }
        throw new IllegalStateException("Error"+str);
    }

    public boolean hasNextToken() {
        return !str.isEmpty();
    }

    public void pushBack() {
        if (lastToken == null) {
            this.pushBack = true;
        }
    }
}

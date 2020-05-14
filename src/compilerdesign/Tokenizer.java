/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerdesign;

import java.io.*;
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
    private Operations operation = new Operations();;

    public Tokenizer(String str) {
        this.tokenList = new ArrayList<TokenData>();
        this.str = str;
        tokenList.add(new TokenData(Pattern.compile("^([a-zA-Z][a-zA-z0-9]*)^"),TokenType.IDENTIFIER));
        tokenList.add(new TokenData(Pattern.compile("yaz\\(\"(\\S+)\"\\);"), TokenType.STRING_LITERAL));
        tokenList.add(new TokenData(Pattern.compile("yaz\\((\\S+)\\);"), TokenType.INTEGER_LITERAL));
        tokenList.add(new TokenData(Pattern.compile("yaz\\(('\\S+')\\);"), TokenType.KEYWORDS));
        for (String t:new String[]{"Eğer\\ \\((\\S+)\\).{."}) {
            tokenList.add(new TokenData(Pattern.compile(t), TokenType.TOKEN));
        }
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
                switch (data.getType()) {
                    case INTEGER_LITERAL:
                        int deger=operation.hesapla(matcher.group(1));
                        return (lastToken = new Token(String.valueOf(deger), TokenType.INTEGER_LITERAL));
                    case STRING_LITERAL:           
                        return (lastToken = new Token(matcher.group(1), TokenType.STRING_LITERAL));
                    case TOKEN:
                        System.out.println(matcher.group(1));
                       // operation.Tamsayi(matcher.group(1));
                        return (lastToken = new Token(matcher.group(), TokenType.TOKEN));
                    default:
                        return (lastToken = new Token(token, data.getType()));
                }
            }
        }
        return null;
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

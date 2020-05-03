/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerdesign;

import java.util.regex.Pattern;

/**
 *
 * @author fozca
 */
public class TokenData {
    private Pattern pattern;
    private TokenType tokenType;

    public TokenData(Pattern pattern, TokenType tokenType) {
        this.pattern = pattern;
        this.tokenType = tokenType;
    } 
    public Pattern getPattern(){
        return pattern;
    }
    public TokenType getType(){
        return tokenType;
    }
}

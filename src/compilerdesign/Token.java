/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerdesign;

/**
 *
 * @author fozca
 */
public class Token {

    private String Token;
    private TokenType tokenType;

    public Token(String Token, TokenType tokenType) {
        this.Token = Token;
        this.tokenType = tokenType;
    }

    public String getToken() {
        return Token;
    }

    public TokenType tokenType() {
        return tokenType;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerdesign;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*; 

/**
 *
 * @author fozca
 */
public class CompilerDesign {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br;
        try {       
            br = new BufferedReader(new FileReader("test.txt"));
            Tokenizer tokenizer=new Tokenizer(br.readLine());
            while(tokenizer.hasNextToken()){
                System.out.println(tokenizer.nextToken().getToken());   
            }    
        } catch (IOException ex) {
            System.out.println("Dosya Bulunamadı..!");
        }
    }
}

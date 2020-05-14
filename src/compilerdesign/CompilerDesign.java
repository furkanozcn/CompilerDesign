/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerdesign;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

        BufferedReader input;
        try {
            input = new BufferedReader(new FileReader("test.txt"));
            String satir;
            while ((satir = input.readLine()) != null) {
                Tokenizer tokenizer = new Tokenizer(satir);
                while (tokenizer.hasNextToken()) {
                    tokenizer.nextToken().getToken();
                }
            }
        } catch (IOException ex) {
            System.out.println("Dosya Bulunamadı..!");
        }
    }
}

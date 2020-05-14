/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilerdesign;

import java.io.PrintStream;

/**
 *
 * @author fozca
 */
public class Operations {
    

    public Operations() {
        
    }
     public void hesapla(String x){
         String sayilar[]=x.split("[0-9]+");
         String islemler[]=x.split("[+-/*]");
         int sayi = Integer.parseInt(islemler[0]);
    for(int i=1;i<islemler.length;i++){
             switch (sayilar[i]) {
                 case "+":
                     sayi += Integer.parseInt(islemler[i]);
                     break;
                 case "-":
                     sayi -= Integer.parseInt(islemler[i]);
                     break;
                 case "/":
                     sayi /= Integer.parseInt(islemler[i]);
                     break;
                 case "*":
                     sayi *= Integer.parseInt(islemler[i]);
                     break;
                 default:
                     break;
             }
    }
        yaz(sayi);
     }
     public String Eger(String x,String y){
         boolean deger=Boolean.parseBoolean(x);
         if(deger){
             System.out.println("test");
         }
        return null; 
     }
     public void yaz(int x){
        PrintStream out = new PrintStream(System.out);
        out.println(x);
}
     public void yazdir(String x){
        PrintStream out = new PrintStream(System.out);
        out.println(x);
}
}

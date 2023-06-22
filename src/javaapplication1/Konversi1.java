/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author Saiful
 */
public class Konversi1 {
      String hasil = "";
      public String konversi(int angka){ 
         int bagi = 0;
         int banding = 0;
         while(angka > 0){
             this.hasil = (angka % 2) + this.hasil;
             angka = angka / 2 ;
         }
         return this.hasil;
      }
     public static void main(String[] args) {
        // TODO code application logic here
        Konversi1 kdtb = new Konversi1();
         Scanner input = new Scanner(System.in);
        System.out.print("Input Angka : ");
        int angkaDesimal = input.nextInt();
        System.out.println("Hasil : "+kdtb.konversi(angkaDesimal)); 
    }
}

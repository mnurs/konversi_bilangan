package javaapplication1;
import java.util.Scanner;
public class KonversiDesimalToBinner { 
    String output = "";
    public String koonversi(int angkaDesimal,String output){
        int temp1,temp2;
        if(angkaDesimal <= 8){
            switch(angkaDesimal) {
                case 0: this.output = output + "000"; break;
                case 1: this.output = output + "001"; break;
                case 2: this.output = output + "010"; break;
                case 3: this.output = output + "011"; break;
                case 4: this.output = output + "100"; break;
                case 5: this.output = output + "101"; break;
                case 6: this.output = output + "110"; break;
                case 7: this.output = output + "111"; break;  
              }
        }else{
             temp1 = (int)(angkaDesimal / 8);  
             koonversi(temp1,this.output) ;
             temp2 = angkaDesimal % 8;  
             koonversi(temp2,this.output); 
        }
        return this.output;
    } 
    public static void main(String[] args) { 
        KonversiDesimalToBinner kdtb = new KonversiDesimalToBinner();
        Scanner input = new Scanner(System.in);
        System.out.print("Input Angka : ");
        int angkaDesimal = input.nextInt();
        System.out.println("Hasil : "+kdtb.koonversi(angkaDesimal, kdtb.output));
    }
}

package mypact;

import java.util.Scanner;
import lib.mylib;

public class test {

    public static void main(String[] args) {
      mylib.printstr();
        String aaa="ABC=";
        float bbb=14;
        System.out.println("Az  "+aaa+bbb);
        System.out.print("tx ");
        System.out.printf("F-%30.8f",bbb/10);
        // Ввод данных
        System.out.printf("%nВведите целое число-");
        Scanner input = new Scanner(System.in);
        int myInt = input.nextInt();
        System.out.printf("%nВведено:  %d.%n%n",myInt);
    }
}

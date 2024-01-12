package mypact;

import java.util.Scanner;
import lib.mylib;

public class test {
    public static void main(String[] args) {
      mylib.printstr();// Запуск библиотечного метода
        String aaa="ABC=";
        float bbb=14;

        System.out.printf("%nРабота метода main родительского test.class%n");
        System.out.println("Az  "+aaa+bbb);
        System.out.print("tx ");
        System.out.printf("F-%30.8f",bbb/10);
        // Ввод данных
        System.out.printf("%nВведите целое число-");
        Scanner input = new Scanner(System.in);
        int myInt = input.nextInt();
        System.out.printf("%nВведено:  %d.%n%n",myInt);
    }
    public  static void test1print(String ttt) {
        System.out.printf("%n"+ttt);
    }

}

class test2 extends test{
    public static void main(String[] args) {
        test1print("Вызов унаследованного метода test1print");
        mylib.printstr();// Запуск библиотечного метода

        System.out.printf("%nРабота метода main дочернего test2.class"); 
	int  zxc=11;
	for(int i=0; i<zxc;i++){
	    System.out.printf("%n" +i+" Test2main"); 
	}
        System.out.printf("%n***%n"); 
    }
}

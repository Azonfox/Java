// Test записи данных по определенным позициям в файл
import java.io.*;

class Field {
    int fpos;
    int lengh;
    String name = new String();
    String data = new String();
}

class Rrecord {
    int recpos=0;

    void write()  throws IOException {
    // Используем класс свободного доступа к файлу
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(recpos);
	fout.writeUTF("12345asdf"); 

	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
   }
/*
    void read()  throws IOException {
    // Используем класс свободного доступа к файлу
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(recpos+fname.fpos);
	fname.name=fout.readUTF(); 

	fout.close(); // Закрыть файл!
      } catch(IOException e) {
        System.out.println("I/O Error: " + e);
      }
  }

    void print(){
	System.out.println(fname.name); 
//	System.out.println(user); 
//	System.out.println(pass); 
//	System.out.println(memo); 
    }
*/
}


class dbfields {
  public static void main(String args[]) throws IOException {

//        Field fname = new Field();
//	Field fuser = new Field();
//	Field fpass = new Field();
//	Field fmemo = new Field();

	fname.fpos=0;
	fname.lengh=0;
	fname.name="Name";
        fname.data="1234567890123456";


    Rrecord recx = new Rrecord();
    recx.write();
//    recx.read();
    // Печатаем 
    System.out.println("Печатаем  данные записи");
//    recx.print();
  }
}

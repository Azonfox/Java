// Test записи данных по определенным позициям в файл
import java.io.*;

class Rrecord {
    byte lengh;
    String name = new String();
    String user = new String();
    String pass = new String();
    String memo = new String();

    void write(int pos)  throws IOException {
    // Используем класс свободного доступа к файлу
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(pos);
	fout.writeUTF(name.substring(0,10)); 
	fout.seek(pos+12);
	fout.writeUTF(user.substring(0,10)); 
	fout.seek(pos+24);
	fout.writeUTF(pass.substring(0,10)); 
	fout.seek(pos+36);
	fout.writeUTF(memo.substring(0,10)); 
	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
   }

    void read(int pos)  throws IOException {
    // Используем класс свободного доступа к файлу
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(pos);
	name=fout.readUTF(); 
	fout.seek(pos+12);
	user=fout.readUTF(); 
	fout.seek(pos+24);
	pass=fout.readUTF(); 
	fout.seek(pos+36);
	memo=fout.readUTF(); 
	fout.close(); // Закрыть файл!
      } catch(IOException e) {
        System.out.println("I/O Error: " + e);
      }
  }

    void print(){
	System.out.println(name); 
	System.out.println(user); 
	System.out.println(pass); 
	System.out.println(memo); 
    }
}


class dbfields {
  public static void main(String args[]) throws IOException {
    Rrecord recx = new Rrecord();
    recx.name="123456789012345";
    recx.user="123456789012345";
    recx.pass="123456789012345";
    recx.memo="123456789012345";
    recx.write(0);
    recx.read(0);
    // Печатаем 
    System.out.println("Печатаем  данные записи");
    recx.print();
  }
}

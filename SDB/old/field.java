// Test записи данных по определенным позициям в файл
import java.io.*;

class Field {
    int recpos=0;
    int pos;
    int lengh;
    String name = new String();
    String data = new String();
    String buffer = new String();

    void write()  throws IOException {
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(recpos);
	fout.writeInt(pos); 
	fout.writeInt(lengh); 
	fout.writeUTF(name); 
	fout.writeUTF(data); 

	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
  }

    void read()  throws IOException {
    // Используем класс свободного доступа к файлу
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(recpos+4+4+8);
	buffer=fout.readUTF(); 

	fout.close(); // Закрыть файл!
      } catch(IOException e) {
        System.out.println("I/O Error: " + e);
      }
   }

    void print()  throws IOException {
    // Печатаем 
    System.out.println("Печатаем  данные записи");
    System.out.println(name); 
    System.out.println(buffer);
    }
}

class dbfields {
  public static void main(String args[]) throws IOException {

    Field fields = new Field();
        fields.recpos=0;
        fields.pos=0;
        fields.lengh=10;
        fields.name="Имя";
        fields.data="Данные";    
    
	fields.write();
	fields.read();
	fields.print();
  }
}

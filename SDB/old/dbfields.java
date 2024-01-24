// Test записи данных по определенным позициям в файл
import java.io.*;

class Field {
    int recpos=0;
    int pos;
    int lengh;
    String name = new String();
    String data = new String();
    String tmp = new String();

    void write()  throws IOException {
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(recpos+pos);
	for(int i=0; i<lengh;i++) tmp+='-';
	fout.writeUTF((data+tmp).substring(0,lengh)); 

	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
  }

    void read()  throws IOException {
    // Используем класс свободного доступа к файлу
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","r")) {
	fout.seek(recpos+pos);
	data=fout.readUTF(); 

	fout.close(); // Закрыть файл!
      } catch(IOException e) {
        System.out.println("I/O Error: " + e);
      }
   }

    void print()  throws IOException {
    // Печатаем 
    System.out.println("Печатаем  данные записи");
    System.out.println(name); 
    System.out.println(data);
    }
}

class dbfields {
  public static void main(String args[]) throws IOException {

    Field fields = new Field();
        fields.recpos=0;
        fields.pos=0;
        fields.lengh=50;
        fields.name="Имя";
        fields.data="Очень Новые Данные";    
    
	fields.write();
	fields.read();
	fields.print();
  }
}

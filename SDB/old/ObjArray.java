// Test записи данных по определенным позициям в файл
import java.io.*;

class Field {
    int pos;
    int lengh;
    String name = new String();
    String data = new String();

    public Field(int pos, int lengh, String name, String data){
	this.pos=pos;
	this.lengh=lengh;
	this.name=name;
	this.data=data;
    }
}

class dbfields {
  public static void main(String args[]){
	int recpos=0;
	String buffer = new String();

    Field[] fields = new Field[4];
        fields[0] = new Field(0, 10,"Имя0","Данные0");
        fields[1] = new Field(11,10,"Имя1","Данные1");
        fields[2] = new Field(21,10,"Имя2","Данные2");
        fields[3] = new Field(31,10,"Имя3","Данные3");

      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(recpos);
	fout.writeInt(fields[3].pos); 
	fout.writeInt(fields[3].lengh); 
	fout.writeUTF(fields[3].name); 
	fout.writeUTF(fields[3].data); 

	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
   
//    void read()  throws IOException {
    // Используем класс свободного доступа к файлу
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(recpos+4+4+9);
	buffer=fout.readUTF(); 

	fout.close(); // Закрыть файл!
      } catch(IOException e) {
        System.out.println("I/O Error: " + e);
      }
 // }
    // Печатаем 
    System.out.println("Печатаем  данные записи");
    System.out.println(fields[2].name); 
    System.out.println(buffer);
  }
}

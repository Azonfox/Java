// Test записи данных по определенным позициям в файл
import java.io.*;

class dbHead{
    byte vers;	  // Версия 
    int datapos;  // Адрес начала данных
    int recleng;  // Длина записи с флагом
    int reccount; // Количество записей в базе
    int reserv=0; // Резерв


}


class Field {
    int recpos=0;
    int pos;
    int lengh;
    String name = new String();
    String data = new String();
    String  tmp = new String();

    void setField(int recpos,int pos, int lengh,String name,String data){
        this.recpos=recpos;
        this.pos=pos;
        this.lengh=lengh;
        this.name=name;
        this.data=data;    
    }

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
    System.out.println(data.length());
    }
}

class dbrecord {
      Field fieldx = new Field();

    void writeRecord()  throws IOException {
      fieldx.setField(0,150,26,"Имя3","Record-Новые Данные"); 
      fieldx.write();
    }

    void printRecord()  throws IOException {
      fieldx.setField(0,150,26,"Имя3","Record-Новые Данные"); 
      fieldx.read();
      fieldx.print();
    }
}

class dbfields {
  public static void main(String args[]) throws IOException {

    Field fields = new Field();
    dbrecord recx = new dbrecord();
    recx.writeRecord();
    recx.printRecord();

    fields.setField(0,0,26,"Имя1","data-Новые Данные"); 
	fields.write();
	fields.read();
	fields.print();

    fields.setField(0,64,26,"Имя2","DANABASE-Новые Данные"); 
	fields.write();
	fields.read();
	fields.print();
  }
}

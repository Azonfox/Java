// Test записи данных по определенным позициям в файл
import java.io.*;

class Head{
    // Описание заголовка
    byte vers;	    // Версия 
    int datapos;    // Адрес начала данных
    int recleng;    // Длина записи с флагом
    int reccount;   // Количество записей в базе
    int fieldpos;   // Адрес описания полей
    int fieldcount; // Количество полей
    // Заполнеие заголовка 
    void setHead(byte vers,int datapos,int recleng, int reccount, int fieldpos, int fieldcount){
	this.vers 	=vers;
	this.datapos	=datapos;
	this.recleng	=recleng;
	this.reccount	=reccount;
	this.fieldpos	=fieldpos;
	this.fieldcount	=fieldcount;
    }
    // Запись заголовка на постоянное место в файл
    void writeHead()  throws IOException {
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(0);	fout.writeByte(vers);
	fout.seek(1);	fout.writeInt(datapos);
	fout.seek(5);	fout.writeInt(recleng);
	fout.seek(9);	fout.writeInt(reccount);
	fout.seek(13);	fout.writeInt(fieldpos);
	fout.seek(18);	fout.writeInt(fieldcount);
 	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
    }
    // Чтение заголовка 
    void readHead()  throws IOException {
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(0);	vers=      fout.readByte();
	fout.seek(1);	datapos=   fout.readInt();
	fout.seek(5);	recleng=   fout.readInt();
	fout.seek(9);	reccount=  fout.readInt();
	fout.seek(13);	fieldpos=  fout.readInt();
	fout.seek(18);	fieldcount=fout.readInt();
 	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
    }
    // Печать заголовка
    void printHead() throws IOException {
        
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	// Читаем сам заголовок
	fout.seek(0);	vers=      fout.readByte();
	fout.seek(1);	datapos=   fout.readInt();
	fout.seek(5);	recleng=   fout.readInt();
	fout.seek(9);	reccount=  fout.readInt();
	fout.seek(13);	fieldpos=  fout.readInt();
	fout.seek(18);	fieldcount=fout.readInt();
	// Печатаем его
       System.out.println("------------------");
       System.out.println("Печать заголовка:");
       System.out.println("vers-      "+vers);
       System.out.println("datapos-   "+datapos);
       System.out.println("recleng-   "+recleng);
       System.out.println("reccount-  "+reccount);
       System.out.println("fieldpos-  "+fieldpos);
       System.out.println("fieldcount-"+fieldcount);
       System.out.println("------------------");
    // Печать с чтением из файла описания всех полей в заголовке БД
        System.out.println("Печать определения полей:");
        System.out.println("----------------------------------------------------------");
       for(int i=0; i<fieldcount;i++){
        System.out.print("Поле: "+i);
	fout.seek(fieldpos+32*i);
	System.out.print("  ftype-"  +fout.readByte());
	System.out.print("  fpos-"   +fout.readInt());
	System.out.print("  flengh-" +fout.readInt());
	System.out.println("  fname-"+fout.readUTF());
       }	
	fout.close(); // Закрыть файл!
      } catch(IOException e) {
         System.out.println("I/O Error: " + e);
      }
      System.out.println("----------------------------------------------------------");
    }
}


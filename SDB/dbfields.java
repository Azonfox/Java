// Test записи данных по определенным позициям в файл
import java.io.*;

class dbHead{
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
    // Печать заголовка
    void printHead(){
      System.out.println("------------------");
      System.out.println("Печать заголовка:");
       System.out.println("vers-      "+vers);
       System.out.println("datapos-   "+datapos);
       System.out.println("recleng-   "+recleng);
       System.out.println("reccount-  "+reccount);
       System.out.println("fieldpos-  "+fieldpos);
       System.out.println("fieldcount-"+fieldcount);
        System.out.println("------------------");
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
	fout.seek(0);	vers=fout.readByte();
	fout.seek(1);	datapos=fout.readInt();
	fout.seek(5);	recleng=fout.readInt();
	fout.seek(9);	reccount=fout.readInt();
	fout.seek(13);	fieldpos=fout.readInt();
	fout.seek(18);	fieldcount=fout.readInt();
 	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
    }
//-------------------------------------------------------------------------
    // Описание поля - 24 байта
    byte ftype;	// Тип данных
    int fpos;	// Позиция поля в записи
    int flengh;	// Длина
    String fname = new String(); // ENG наименование строго 10 байт!
    // Заполнить описание поля
    void setField(byte ftype,int fpos, int flengh,String fname){
        this.ftype=ftype; 
        this.fpos=fpos;	  
        this.flengh=flengh;
        this.fname=fname;  
    }
    // Записать описание поля в заголовок файла
    void writePfield(int fieldnum)  throws IOException {
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(18);	fout.writeInt(fieldcount);
	fout.seek(fieldpos+32*fieldnum);
	fout.writeByte(ftype);
	fout.writeInt(fpos);
	fout.writeInt(flengh);
	fout.writeUTF(fname);
	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
  }
    // Печать описание поля в заголовке файла
    void printPfield()  throws IOException {
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
        System.out.println("Печать определения полей");
        System.out.println("----------------------------------------------------------");
       for(int i=0; i<fieldcount;i++){
        System.out.print("Поле: "+i);
	fout.seek(fieldpos+32*i);
	System.out.print("  ftype-"+fout.read());
	System.out.print("  fpos-"+fout.readInt());
	System.out.print("  flengh-"+fout.readInt());
	System.out.println("  fname-"+fout.readUTF());
       }	
	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
      System.out.println("----------------------------------------------------------");
  }
}

class dbfields {
  public static void main(String args[]) throws IOException {
    // Изначально удалим файл, иначе мусор и накладки
    File filedel = new File("dbf1.txt");
    if(filedel.delete()){
        System.out.println("Файл данных удален-очистка!");
    }
    // Запозняем заголовок в файле
    /* Версия,   Адрес начала данных,  Длина записи с флагом, 
    Количество записей в базе,  Адрес описания полей,  Количество полей
    */
    dbHead dbHeadx = new dbHead();
    dbHeadx.setHead((byte)15,255,32,2,32,5);
    dbHeadx.writeHead();
    dbHeadx.readHead();
    dbHeadx.printHead();

    /* Описание поля
	Тип данных, Позиция поля в записи, Длина, наименование-10Eng 
    */
    dbHeadx.setField((byte)5,0,20,"Name1-----");
    dbHeadx.writePfield(0);
    dbHeadx.setField((byte)5,0,20,"Name2-----");
    dbHeadx.writePfield(1);
    dbHeadx.setField((byte)5,0,20,"Name3-----");
    dbHeadx.writePfield(2);
    dbHeadx.setField((byte)5,0,20,"Name4-----");
    dbHeadx.writePfield(3);
    dbHeadx.setField((byte)5,0,20,"Name5-----");
    dbHeadx.writePfield(4);
    dbHeadx.printPfield();
  }
}

//	for(int i=0; i<lengh;i++) tmp+='-';
//	fout.writeUTF((data+tmp).substring(0,lengh)); 


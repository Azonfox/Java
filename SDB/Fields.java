// Test записи данных по определенным позициям в файл
import java.io.*;

class Fields {
    int fieldposx;   // Адрес полей
    int fieldcountx; // Количество полей
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
    // Изменить  описание поля в заголовке файла по номеру
    void writePfield(int fieldnum)  throws IOException {
      try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(13);	fieldposx=fout.readInt();
	fout.seek(fieldposx+32*fieldnum);
	fout.writeByte(ftype);
	fout.writeInt(fpos);
	fout.writeInt(flengh);
	fout.writeUTF(fname);
	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
  }
    // Добавить описание поля в заголовок файла по номеру
    void addField(byte ftype,int fpos, int flengh,String fname)  throws IOException {
    try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	fout.seek(13);	fieldposx=fout.readInt();
	fout.seek(18);	fieldcountx=fout.readInt();
	fout.seek(fieldposx+32*fieldcountx);
	fout.writeByte(ftype);
	fout.writeInt(fpos);
	fout.writeInt(flengh);
	fout.writeUTF(fname);
        fieldcountx++; // Изменим счетчик полей в заголовке  
	fout.seek(18);	fout.writeInt(fieldcountx);
	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      System.out.println("I/O Error: " + e);
      }
  }

}


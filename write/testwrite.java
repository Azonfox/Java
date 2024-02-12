// Test записи различных данных по определенным позициям в файл
package myPacket;
import java.io.*;

class testwrite {
  public static void main(String args[]) throws IOException {
    byte   b=10;
    short  s=500;
    int    i=9876;
    long   l=123456;
    float  f=1234.56789F;
    double d=1234.56789D;
    char   c='А';
    String buffer  = new String();
    buffer="BSILFDC* - тестовая строка";

    // Изначально удалим файл, иначе мусор и накладки
    File filedel = new File("dbf1.txt");
    if(filedel.delete()){
        System.out.println("Файл данных удален-очистка!");
    }

    try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	// Запись различных данных по своим местам
	fout.seek(0);   fout.writeByte(b); 
	fout.seek(16); 	fout.writeShort(s); 
	fout.seek(32); 	fout.writeInt(i); 
	fout.seek(48); 	fout.writeLong(l); 
	fout.seek(64); 	fout.writeFloat(f); 
	fout.seek(80); 	fout.writeDouble(d); 
	fout.seek(96); 	fout.writeChar(c); 
	fout.seek(112);	fout.writeUTF(buffer); 

	// Читаем данные из своих мест и печатаем их
        System.out.println("Читаем данные:");
	fout.seek(0);   System.out.println(fout.readByte()); 
	fout.seek(16); 	System.out.println(fout.readShort()); 
	fout.seek(32); 	System.out.println(fout.readInt()); 
	fout.seek(48); 	System.out.println(fout.readLong()); 
	fout.seek(64); 	System.out.println(fout.readFloat()); 
	fout.seek(80); 	System.out.println(fout.readDouble()); 
	fout.seek(96); 	System.out.println(fout.readChar()); 
	fout.seek(112);	System.out.println(fout.readUTF()); 

	fout.close(); // Закрыть файл!
    } catch(IOException e) {
      	System.out.println("I/O Error: " + e);
    }
  }
}

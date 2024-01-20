// Test записи текстровых! данных по определенным позициям в файл
import java.io.*;

class dbfile {
  public static void main(String args[]) throws IOException {
    int i=9876;
    float f=1234.56789F+1;
    String buf    = new String();
    String buffer = new String();
    buf="This второе символьное поле";
    buffer=buf.substring(0,10); // Вырезаем 10 символов без учета UTF

    // Используем класс свободного доступа к файлу
    try (RandomAccessFile fout = new RandomAccessFile("dbf1.txt","rw")) {
	// Запись различных данных по своим местам
	fout.writeInt(i); // Integer
	fout.seek(16);
	fout.writeFloat(f); // Float
	fout.seek(32);
	// Перед началом строки writeUTF ставит счетчик из двух байт!!!
	fout.writeUTF("TEST-Прошлого файла"); // UTF TXT
	fout.seek(80);
	fout.writeUTF(buffer); // UTF TXT
	fout.writeInt(13); //00 00 00 0D  - 4 байти INTEGER

	// Читаем данные из своих мест и печатаем их после изменений
        System.out.println("Читаем данные из своих мест и печатаем их после изменений");
	fout.seek(0);
	i=fout.readInt()+1;
	System.out.println(i);
	fout.seek(16);
	f=fout.readFloat()+1;
	System.out.println(f);
	fout.seek(32);
	buffer=fout.readUTF()+"+дополнение";
	System.out.println(buffer);
	fout.seek(80);
	buffer=fout.readUTF()+"+окончание";
	System.out.println(buffer);

	fout.close(); // Закрыть файл!
    } catch(IOException e) {
      System.out.println("I/O Error: " + e);
    }
  }
}

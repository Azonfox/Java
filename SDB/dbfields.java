// Test записи данных по определенным позициям в файл
import java.io.*;

class dbfields {
  public static void main(String args[]) throws IOException {

    // Запозняем заголовок в файле
    /* Версия,   Адрес начала данных,  Длина записи с флагом, 
    Количество записей в базе,  Адрес описания полей,  Количество полей
    */
    Head dbHeadx = new Head();
//    dbHeadx.setHead((byte)15,255,32,2,32,0);
//    dbHeadx.writeHead();
    dbHeadx.readHead(); // Читаем всегда- это отправная точка работы

    Fields dbFields = new Fields();
    //	Тип данных, Позиция поля в записи, Длина, наименование-10Eng 
    dbFields.addField((byte)5,20,20,"Name01----");
    dbFields.addField((byte)8,21,30,"Name02----");
    dbHeadx.printHead();
  }
}

    // Изначально удалим файл, иначе мусор и накладки
/*    File filedel = new File("dbf1.txt");
    if(filedel.delete()){
        System.out.println("Файл данных удален-очистка!");
    }
*/
//	for(int i=0; i<lengh;i++) tmp+='-';
//	fout.writeUTF((data+tmp).substring(0,lengh)); 


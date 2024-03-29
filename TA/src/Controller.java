package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import java.util.GregorianCalendar;
import java.io.*;

public class Controller {
    @FXML  private Text txtText;
    @FXML  private TextArea  txtArea;
    @FXML  private Button btnExit;
    @FXML  private Button btnText;
    private String msg;
    private String namefile;
    private boolean  pass;

    @FXML void initialize(){
	// Срабатывает при запуске окна
      	System.out.println("Initialize");
    }

    // Считывание файла в TextArea
    public void btnTextClick(ActionEvent event) throws IOException {
	
	// Работаем с датой в Calendar
        GregorianCalendar data1 = new GregorianCalendar();
        System.out.println(data1.get(GregorianCalendar.DAY_OF_MONTH)); ///////////
	// Проверка пароля и формирование соответствующего имени файла
	if(txtArea.getText().equals("azfox"+data1.get(GregorianCalendar.DAY_OF_MONTH))) {
	    pass=true;
	    txtText.setText("Записная книжка.");
	} else {
	    pass=false;
	    txtText.setText("Записная книжка");
	} 
	namefile = pass ? "st.txt" : "brrr.txt";
       System.out.println(namefile); //////////////////////////

	BufferedReader br = null; 
      try {
	File file = new File(namefile);
	// Если файла нет то создаем и пишем в него сообщение
	if(!file.exists()) {
	  file.createNewFile();
	  PrintWriter pw = new PrintWriter(file);
	  pw.print("Ваш текст..");
          pw.close(); // Закрыть файл!
	}
	// Читаем файл в TextArea
	br = new BufferedReader(new FileReader(namefile));
	// Читаем построчно и добавляем конец строки
	String line;
        msg="";
	while((line=br.readLine()) !=null)
	    msg=msg+line+"\n";
      } catch(IOException e) {
      	System.out.println("I/O Error: " + e);
      } finally {
        br.close();
      }
      txtArea.setText(msg); // Записываем в TextArea
   }

    // Выход из приложения с записью TextArea  в файл
    public void btnExitClick(ActionEvent event) {
      // Если в TextArea ничего не менялось-просто выходим!
      if(!txtArea.getText().equals(" Ваш текст...")) {
	// Проверка пароля
	if(pass) namefile="st.txt";
	 else    namefile="brrr.txt";
        // Если файла нет то создаем, и пишем в него из TexArea
       try {
	File file = new File(namefile);
	if(!file.exists()) 
	   file.createNewFile();
	PrintWriter pw = new PrintWriter(file);
	pw.print(txtArea.getText());
        pw.close(); // Закрыть файл!
        } catch(IOException e) {
        System.out.println("I/O Error: " + e);
        }
      }
	// Выводим в терминал TextArea  как отладку
	System.out.println(txtArea.getText()); //////////////////////////////
	// Выход из приложения
	System.exit(0);
    }
}

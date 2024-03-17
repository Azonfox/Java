package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.*;


public class Controller {

    @FXML  private Text txtText;
    @FXML  private TextArea  txtArea;
    @FXML  private Button btnExit;
    @FXML  private Button btnText;
    private String msg;
    private String namefile;
    private boolean  pass;

    // Считывание файла в TextArea
    public void btnTextClick(ActionEvent event) throws IOException {
	 txtText.setText("Редактор текста");
	// Проверка пароля и соответствующее имя файла
	if(txtArea.getText().equals("azfox"))
	    pass=true;
	else
	    pass=false;
	if(pass)
	    namefile="st.txt"; // истинное имя файла
	else 
	    namefile="brrr.txt"; // левый файл
      System.out.println(namefile);

	BufferedReader br = null; 
      try {
	File file = new File(namefile);
	// Если файла нет то создаем и пишем в него сообщение
	if(!file.exists()) {
	  file.createNewFile();
	  PrintWriter pw = new PrintWriter(file);
	  pw.println("Ваш текст..");
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
	// Проверка пароля
	if(pass)
	    namefile="st.txt";
	else
	    namefile="brrr.txt";
	// Если файла нет то создаем, и пишем в него из TexArea
      try {
	File file = new File(namefile);
	if(!file.exists())
	   file.createNewFile();
	PrintWriter pw = new PrintWriter(file);
	pw.println(txtArea.getText());
        pw.close(); // Закрыть файл!
        } catch(IOException e) {
        System.out.println("I/O Error: " + e);
        }
	// Выводим в терминал набранный текст как отладку
	System.out.println(txtArea.getText());
	// Выход из приложения
	System.exit(0);
    }
}

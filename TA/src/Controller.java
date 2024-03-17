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

    @FXML  private Text question_text;
    @FXML  private TextArea  txtArea;
    @FXML  private Button btnExit;
    @FXML  private Button btnText;
    private String msg;

    public void btnTextClick(ActionEvent event) throws IOException {
	BufferedReader br = null; 
//      msg="qqqqqqqqqq";
      try {
	File file = new File("st.txt");
	// Если файла нет то создаем и пишем в него
	if(!file.exists()) {
	  file.createNewFile();
	  PrintWriter pw = new PrintWriter(file);
	  pw.println("Файл создан заново!");
          pw.close(); // Закрыть файл!
	}
	// Читаем файл в TextArea
	br = new BufferedReader(new FileReader("st.txt"));
	String line;
	while((line=br.readLine()) !=null)
	    msg=msg+line+"\n";
	    
      } catch(IOException e) {
      	System.out.println("I/O Error: " + e);
      } finally {
        br.close();
      }
      txtArea.setText(msg);
   }

    public void btnExitClick(ActionEvent event) {
	// Выводим в терминал набранный текст
	System.out.println(txtArea.getText());
	// Выход из приложения
	System.exit(0);
    }
}

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

    public void btnTextClick(ActionEvent event) {

      try (RandomAccessFile fout = new RandomAccessFile("/home/azfox/PROJECT/JAVA/TA/st.txt","rw")) {
	// Читаем данные из своих мест и печатаем их
	msg="qqqqqqqqqq";
	fout.seek(0);
	msg=fout.readUTF();
	fout.close(); // Закрыть файл!
      } catch(IOException e) {
      	System.out.println("I/O Error: " + e);
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

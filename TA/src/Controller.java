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

public class Controller {

    @FXML  private Text question_text;
    @FXML  private TextArea  txtArea;
    @FXML  private Button btnExit;
    @FXML  private Button btnText;
    private String msg;

    public void btnTextClick(ActionEvent event) {
	// Выводим в TextArea  msg текст
	msg="Новейший текст MSG InputButton";
        txtArea.setText(msg);
    }

    public void btnExitClick(ActionEvent event) {
	// Выводим в терминал набранный текст
	System.out.println(txtArea.getText());
	// Выход из приложения
	System.exit(0);
    }
}

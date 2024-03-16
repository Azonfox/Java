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

    @FXML
    private Text question_text;
    
    @FXML
    private TextArea  txtArea;

   // Выход из приложения
    @FXML
    private Button btnExit;
    public void btnExitClick(ActionEvent event) {
	System.out.println(txtArea.getText());
	System.exit(0);
    }
}

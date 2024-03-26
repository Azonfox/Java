
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class JavaFXApplication extends Application {     
  
    public static void main(String[] args) {
        Application.launch(JavaFXApplication.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) {
	// Открытие окна
        primaryStage.setTitle("Тестирование GUI-SplitPane");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 350, Color.BLUE); // XY
        primaryStage.setScene(scene);
        primaryStage.show();        
        
	// ***Корневая материнская панель
        SplitPane sp=new SplitPane();
        sp.setLayoutX(10);
        sp.setLayoutY(10);             
        sp.setCursor(Cursor.TEXT);
        sp.setStyle("-fx-border-width:4pt;-fx-border-color:yellow;");
        sp.setPrefSize(480, 300); //XY
        sp.setTooltip(new Tooltip("sp-Tool Tip text"));          
        sp.setOrientation(Orientation.HORIZONTAL);
        // Основной  отдел
        VBox vboxR = new VBox();
        Text textH=new Text("textH-Средний раздел");
        textH.setStyle("-fx-font:bold 14pt Arial;");
        Text textHC=new Text("textHC- корневой части");
        textHC.setStyle("-fx-font:bold 12pt Arial");
        Text textC=new Text("textC-Font-представляет шрифт текста,\n\nи узел отображения текста");
        textC.setStyle("-fx-font: 10pt Arial");  
        textC.setWrappingWidth(160); // Размер области переноса текста

	// Создаем кнопку
        Button btnON = new Button();
        btnON.setLayoutX(50);
        btnON.setLayoutY(150);
        btnON.setText("Выход1");
        btnON.setTooltip(new Tooltip("btn2-Tool Tip text"));          
        btnON.setStyle("-fx-font: bold italic 12pt Arial;" 		+ 		
	    "-fx-text-fill: #660000;    -fx-background-color: #ff99ff;" +	
	    "-fx-border-width: 3px;     -fx-border-radius: 10;"		+ 		
	    "-fx-background-radius: 30; -fx-border-color: #660066;" );       
        btnON.setPrefSize(200,30);       
        // Выход из приложения
        btnON.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {               
	      System.exit(0);
	    }
	});
        vboxR.getChildren().addAll(textH,textHC,textC,btnON);
        vboxR.setSpacing(20);

	// ***Правая панель
        SplitPane spR=new SplitPane();
        spR.setOrientation(Orientation.VERTICAL);        
        // ...правый верхний отдел
	VBox vboxRT = new VBox();
        Text textRT=new Text("ВЕРХ:\nvboxRTop");
        textRT.setStyle("-fx-font:bold 12pt Arial");
        vboxRT.getChildren().addAll(textRT);        
        // ...правый нижний отдел
	VBox vboxRB = new VBox();
        Text textRB=new Text("НИЗ:\nvboxRBott");
        textRB.setStyle("-fx-font:bold 12pt Arial");
        vboxRB.getChildren().addAll(textRB);
        spR.getItems().addAll(vboxRT,vboxRB);
        spR.setDividerPositions(0.3); // Положение разделителя
    
	// ***Левая панель
        SplitPane spL=new SplitPane();
        spL.setOrientation(Orientation.VERTICAL);        
        // ...левый верхний отдел
	VBox vboxLT = new VBox();
        Text textT=new Text("ВЕРХ:\nvboxLTop");
        textT.setStyle("-fx-font:bold 12pt Arial");
        vboxLT.getChildren().addAll(textT);        
        // ...левый нижний отдел
	VBox vboxLB = new VBox();
        Text textB=new Text("НИЗ:\nvboxLBott");
        textB.setStyle("-fx-font:bold 12pt Arial");
        vboxLB.getChildren().addAll(textB);
        spL.getItems().addAll(vboxLT,vboxLB);
        spL.setDividerPositions(0.6); // Положение разделителя
        // Формируем левую, среднюю и правую панель по-порядку
        sp.getItems().addAll(spL,vboxR,spR);
        sp.setDividerPositions(0.4);  // Положение разделителя
        // Формируем корневую панель
        root.getChildren().add(sp);        

	// Создаем кнопку на основном окне
        Button btn = new Button();
        btn.setLayoutX(500/2-50); // расчет центра
        btn.setLayoutY(315);
        btn.setText("Выход2");
        btn.setTooltip(new Tooltip("btn-Tool Tip text"));          
        btn.setPrefSize(100,20);       
        // Выход из приложения
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {               
	      System.exit(0);
	    }
	});
        root.getChildren().add(btn);        

    }
}

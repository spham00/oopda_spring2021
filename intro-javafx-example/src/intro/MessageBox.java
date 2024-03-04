package intro;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox {
	
    public static void show(String message, String title) {
        Stage stage = new Stage();       
        stage.initModality(Modality.APPLICATION_MODAL);       
        stage.setTitle(title);       
        stage.setMinWidth(250);       
        Label lbl = new Label();       
        lbl.setText(message);
        Button btnOK = new Button();       
        btnOK.setText("OK");
        btnOK.setOnAction(e -> stage.close());       
        VBox pane = new VBox(20);       
        pane.getChildren().addAll(lbl, btnOK);
        pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: AntiqueWhite;");
		pane.setPadding(new Insets(20,20,20,20)); // top, left, bottom, right		
        Scene scene = new Scene(pane);       
        stage.setScene(scene);
        stage.showAndWait(); // ensures the message box is modal      
    }
}

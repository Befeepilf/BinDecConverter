/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bindecconverter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author moritz
 */
public class BinDecConverter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text title = new Text("Binary to Decimal");
        title.setFont(Font.font("Helvetica", 20));
        grid.add(title, 0, 0);
        
        TextField binaryTF = new TextField();
        grid.add(binaryTF, 1, 1);
        
        Label binaryLBL = new Label("binary");
        grid.add(binaryLBL, 0, 1);
        
        Button button = new Button();
        button.setText("Convert");
        grid.add(button, 0, 2);
        
        Scene scene = new Scene(grid, 250, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}

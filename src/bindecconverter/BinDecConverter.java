/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bindecconverter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author befeepilf
 */
public class BinDecConverter extends Application {
    public static int mode = 0;
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setGridLinesVisible(true);
        
        Text title = new Text("Binary to Decimal");
        title.setFont(Font.font("Helvetica", 20));
        title.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                switch(mode) {
                    case 0:
                        title.setText("Decimal to Binary");
                        grid.getChildren().remove(1, 6);
                        
                        //order is important
                        addDecimal(grid, 1);
                        addBinary(grid, 2);
                        addButton(grid);
                        
                        grid.getChildren().get(2).requestFocus(); //focus upper textfield
                        mode = 1;
                        break;
                    case 1:
                        title.setText("Binary to Decimal");
                        grid.getChildren().remove(1, 6);
                        
                        //order is important
                        addBinary(grid, 1);
                        addDecimal(grid, 2);
                        addButton(grid);
                        
                        grid.getChildren().get(2).requestFocus(); //focus upper textfield
                        mode = 0;
                        break;
                    default:
                        System.err.println("unknown mode: " + mode);
                        System.exit(0);
                }
            }
            
        });
        grid.add(title, 0, 0, 2, 1);
        
        addBinary(grid, 1);
        
        addDecimal(grid, 2);
        
        addButton(grid);
        
        Scene scene = new Scene(grid, 250, 250);
        
        primaryStage.setTitle("Binary & Decimal Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void addBinary(GridPane grid, int row) {
        Label binaryLBL = new Label("binary");
        grid.add(binaryLBL, 0, row);
        
        TextField binaryTF = new TextField();
        grid.add(binaryTF, 1, row);
    }
    
    public void addDecimal(GridPane grid, int row) {
        Label decimalLBL = new Label("decimal");
        grid.add(decimalLBL, 0, row);
        
        TextField decimalTF = new TextField();
        grid.add(decimalTF, 1, row);
    }
    
    public void addButton(GridPane grid) {
        Button button = new Button("Convert");
        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TextField node = new TextField();
                node = (TextField) grid.getChildren().get(2);
                String input = node.getText();
                node = (TextField) grid.getChildren().get(4);
                node.setText(convert(input));
            }
            
        });
        
        HBox hbBtn = new HBox();
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(button);
        grid.add(hbBtn, 1, 3);
    }
    
    public String convert(String input) {
        String out = "";
        switch(mode) {
            case 0:
                String bin = input;
                int o = 0;
                for(int i = bin.length(); i > 0; i--) {
                    if(bin.charAt(i - 1) == '1') {
                        o += Math.pow(2, bin.length() - i);
                    }
                }
                out += o;
                break;
            case 1:
                int dec = Integer.parseInt(input);
                while(dec > 0) {
                  out += dec % 2;
                  dec = dec / 2;
                }
                out = new StringBuffer(out).reverse().toString();
                break;
            default:
                System.err.println("unknown mode: " + mode);
                System.exit(0);    
        }
        return out;
    }
}

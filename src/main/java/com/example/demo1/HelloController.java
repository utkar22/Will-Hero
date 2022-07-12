package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private Label welcomeText;
    @FXML private CheckBox select;
    @FXML private Button chung;
    @FXML private Label checker;
    @FXML private Button move;
    //@FXML private Platform platform;
    //@FXML private  Hero og;
    @FXML AnchorPane trial = new AnchorPane();


    @FXML private Button settings;

    public void ShiftScene(ActionEvent event) throws IOException {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane gameplayParent = FXMLLoader.load(getClass().getResource("test.fxml"));
        //Parent gameplayParent = (Parent) loader.load();

        Stage window;
        window = (Stage) move.getScene().getWindow();
        //gameplayParent.getChildren().addAll();
        //platform.setStyle("-fx-background-image: url('https://image.winudf.com/v2/image1/Y29tLnpwbGF5LndpbGxoZXJvX3NjcmVlbl8wXzE1NTQxOTU3OThfMDY2/screen-0.jpg?fakeurl=1&type=.jpg')");
        gameplayParent.setStyle("-fx-background-color: #79cde4;");
        Scene gameview = new Scene(gameplayParent, 900, 600);

        //gameview.setFill(Color.SKYBLUE);
        window.setScene(gameview);
        window.setTitle("Game Time");


        window.show();


    }
    public void chungexit(){
        Stage closer = (Stage) chung.getScene().getWindow();
        closer.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // trial.setStyle("-fx-background-image: url('https://image.winudf.com/v2/image1/Y29tLnpwbGF5LndpbGxoZXJvX3NjcmVlbl8wXzE1NTQxOTU3OThfMDY2/screen-0.jpg?fakeurl=1&type=.jpg')");

        Image image= null;
        try {
            image = new Image(new FileInputStream("toPutInProject\\titlescreen.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image img= null;
        try {
            img = new Image(new FileInputStream("toPutInProject\\settings.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        trial.setBackground(new Background(
                new BackgroundImage(
                        image,
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
                )));
        //move.setStyle("-fx-background-image: url('https://image.winudf.com/v2/image1/Y29tLnpwbGF5LndpbGxoZXJvX3NjcmVlbl8wXzE1NTQxOTU3OThfMDY2/screen-0.jpg?fakeurl=1&type=.jpg')");
        Image exi = null;
        try {
             exi = new Image(new FileInputStream("toPutInProject\\4-49788_png-file-svg-exit-button-icon-png-transparent.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        chung.setBackground(new Background(
                new BackgroundImage(
                        exi,
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
                )));

    }
}
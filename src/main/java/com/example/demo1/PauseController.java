package com.example.demo1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
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

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
public class PauseController implements Initializable {

    @FXML private Button newGame;
    @FXML private Button continueGame;
    @FXML private Button mainMenu;
    @FXML private Button exit;
    Hero mega;
    public  void exit() throws IOException{

            Stage closer = (Stage) exit.getScene().getWindow();
            closer.close();

    }
    public static void end() throws IOException{}

    public void newGame() throws IOException{

        AnchorPane gameplayParent = FXMLLoader.load(getClass().getResource("test.fxml"));
        //Parent gameplayParent = (Parent) loader.load();

        Stage window;
        window = (Stage) continueGame.getScene().getWindow();
        //gameplayParent.getChildren().addAll();
        //platform.setStyle("-fx-background-image: url('https://image.winudf.com/v2/image1/Y29tLnpwbGF5LndpbGxoZXJvX3NjcmVlbl8wXzE1NTQxOTU3OThfMDY2/screen-0.jpg?fakeurl=1&type=.jpg')");
        gameplayParent.setStyle("-fx-background-color: #79cde4;");
        Scene gameview = new Scene(gameplayParent, 900, 600);

        //gameview.setFill(Color.SKYBLUE);
        window.setScene(gameview);
        window.setTitle("Game Tome");


        window.show();
    }
    public void continueGame() throws IOException{

        AnchorPane gameplayParen = FXMLLoader.load(getClass().getResource("test.fxml"));
        //Parent gameplayParent = (Parent) loader.load();

        Stage window;
        Hero boop = null;
        window = (Stage) continueGame.getScene().getWindow();
        for(Node obj:gameplayParen.getChildren()){
            if(obj instanceof Hero){
                obj = placehero((Hero) obj);
                boop = (Hero) obj;

                System.out.println(((Hero) obj).getScore());

            }


        }

        //gameplayParent.getChildren().addAll();
        //platform.setStyle("-fx-background-image: url('https://image.winudf.com/v2/image1/Y29tLnpwbGF5LndpbGxoZXJvX3NjcmVlbl8wXzE1NTQxOTU3OThfMDY2/screen-0.jpg?fakeurl=1&type=.jpg')");
        gameplayParen.setStyle("-fx-background-color: #79cde4;");
        Scene gameview = new Scene(gameplayParen, 900, 600);

        //gameview.setFill(Color.SKYBLUE);
        window.setScene(gameview);


        window.setTitle("Game Tome");


        window.show();
        for(Node obj:gameplayParen.getChildren()){
            if(obj instanceof Hero){
                ((Hero) obj).setScore(boop.getScore());
                ((Hero) obj).reward(boop.getCurr_coins());
                ((Hero) obj).curr_weapon=boop.curr_weapon;
                ((Hero) obj).knife_level = boop.knife_level;
                ((Hero) obj).bomb_level= boop.bomb_level;
                ((Hero) obj).platformx = boop.platformx;
                System.out.println(((Hero) obj).platformx);
            }
        }
        for(Node obj:gameplayParen.getChildren()){
            if(obj instanceof Orc && ((Orc) obj).platformx == boop.platformx){
                gameplayParen.getChildren().remove(obj);
            }
            else if(obj instanceof Game_Object && !(obj instanceof Hero)){
                System.out.println(boop.platformx);
                ((Game_Object) obj).set_x(-(boop.platformx));
                ((Game_Object) obj).x -= (boop.platformx);
            }
        }

        //mega.set_y(10);
    }

    public void mainMenu() throws IOException{
        AnchorPane gameplayParent = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        //Parent gameplayParent = (Parent) loader.load();

        Stage window;
        window = (Stage) continueGame.getScene().getWindow();
        //gameplayParent.getChildren().addAll();
        //platform.setStyle("-fx-background-image: url('https://image.winudf.com/v2/image1/Y29tLnpwbGF5LndpbGxoZXJvX3NjcmVlbl8wXzE1NTQxOTU3OThfMDY2/screen-0.jpg?fakeurl=1&type=.jpg')");
        //gameplayParent.setStyle("-fx-background-color: #79cde4;");
        Scene gameview = new Scene(gameplayParent, 900, 600);

        //gameview.setFill(Color.SKYBLUE);
        window.setScene(gameview);
        window.setTitle("Game Time");


        window.show();

    }
    public Hero placehero(Hero mag){
        File savefiles=new File("savefiles");
        File[] savelist=savefiles.listFiles();
        ObjectInputStream in=null;

        try
        {
            String filename="savefiles\\temp.txt";
            System.out.println(filename);
            in=new ObjectInputStream(new FileInputStream(filename));
            if(in==null)
            {
                System.out.println("in was null");
            }
            mag= (Hero) in.readObject();
            System.out.println(mag.getScore());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return mag;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

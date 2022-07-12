package com.example.demo1;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameTimeController implements Initializable {
    @FXML private Label score;
    //@FXML button hmm;
    @FXML private Label position;
    @FXML private Button pause;
    @FXML private AnchorPane scene2;

    /*
    @FXML private Hero og;
    @FXML private Platform platform;
    @FXML Red_Orc max = new Red_Orc();
     */
    

    public GameTimeController() throws FileNotFoundException {
    }

    public void jump(){
        System.out.println("Jumped");
    }
    int x = 0;


    public void pause() throws IOException {
        AnchorPane gameplayParent = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        //Parent gameplayParent = (Parent) loader.load();
        Hero megamind = null;
        for(Node obj: scene2.getChildren()){
            if(obj instanceof Hero){

                megamind = (Hero) obj;
                megamind.falling.pause();
                System.out.println(megamind.x);
            }
        }
        saveonpause(megamind);
        PauseController p1 = new PauseController();
        p1.mega = megamind;
        gameplayParent.getChildren().addAll(megamind);
        Stage window;
        window = (Stage) pause.getScene().getWindow();
        //gameplayParent.getChildren().addAll();
        //platform.setStyle("-fx-background-image: url('https://image.winudf.com/v2/image1/Y29tLnpwbGF5LndpbGxoZXJvX3NjcmVlbl8wXzE1NTQxOTU3OThfMDY2/screen-0.jpg?fakeurl=1&type=.jpg')");
        gameplayParent.setStyle("-fx-background-color: #79cde4;");
        Scene gameview = new Scene(gameplayParent, 900, 600);

        //gameview.setFill(Color.SKYBLUE);
        window.setScene(gameview);
        window.setTitle("Paused!");


        window.show();


    }


    public void saveonpause(Hero mega) throws IOException{
            for(Node obj: scene2.getChildren()){
                if(obj instanceof Hero){
                    ((Hero) obj).falling.stop();
                    ((Hero) obj).pullback.stop();
                    ((Hero) obj).dash.stop();
                }
                if(obj instanceof Orc){
                    ((Orc) obj).falling.stop();
                    ((Orc) obj).pushed.stop();
                    ((Orc) obj).blownup.stop();

                }
                if(obj instanceof Throwing_Knife){
                    ((Throwing_Knife) obj).swish.stop();
                }
            }
            File savefolder =  new File("saveiles");
            File[] savelist = savefolder.listFiles();
            ObjectInputStream in=null;
            String filename="savefiles\\temp.txt";
            try{
            in=new ObjectInputStream(new FileInputStream(filename));}
            catch (FileNotFoundException e)
            {
                File newfile=new File(filename);
                System.out.println(newfile.createNewFile());
            }
            ObjectOutputStream out = null;
            try
            {
                out=new ObjectOutputStream(new FileOutputStream(filename));
                out.writeObject(mega);
                System.out.println(mega.x);
    //            System.out.println("File saved");

            } catch (IOException e) {
                e.printStackTrace();
            }finally
            {
                if(out!=null) out.close();
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            ObservableList<Node> here = scene2.getChildren();
            Throwing_Knife knife1 = new Throwing_Knife(450, 320 , 40, 20, 2, "Knife", 2, 1);
            Bomb bomb1 = new Bomb(450, 320, 40, 20, 2, "Bomb", 1, scene2);

            scene2.getChildren().addAll(new Platform(100.0, 350.0, 200.0, 100));
            scene2.getChildren().addAll(new Platform(450.0, 350.0, 200, 100));
            //scene2.getChildren().addAll(new Coin_Chest(500, 310, 50, 40, 1, 30));
            scene2.getChildren().addAll(new Platform(700, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(1000, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(1300, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(1700, 370, 200, 100));
            scene2.getChildren().addAll(new Platform(2000, 340, 200, 100));
            scene2.getChildren().addAll(new Platform(2500, 380, 200, 100));
            scene2.getChildren().addAll(new Platform(2600, 350, 100, 50));
            scene2.getChildren().addAll(new Platform(2800, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(3300, 370, 200, 100));
            scene2.getChildren().addAll(new Platform(3700, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(4200, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(4550, 360, 200, 100));
            scene2.getChildren().addAll(new Platform(4800, 360, 100, 50));
            scene2.getChildren().addAll(new Platform(5200, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(6000, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(6500, 370, 200, 100));
            scene2.getChildren().addAll(new Platform(6800, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(7200, 340, 200, 100));
            scene2.getChildren().addAll(new Platform(7500, 350, 200, 100));
            scene2.getChildren().addAll(new Platform(8100, 350, 400, 200));
            scene2.getChildren().addAll(new Platform(8800, 360, 200, 100));
            scene2.getChildren().addAll(new Platform(9400, 350, 300, 150));
            scene2.getChildren().addAll(new Platform(10000, 350, 800, 400));

            scene2.getChildren().addAll(new Coin_Chest(500, 310, 50, 40, 1, 30));
            scene2.getChildren().addAll(new Weapon_Chest(1750, 330, 50, 40, bomb1));
            scene2.getChildren().addAll(new Coin_Chest(2900, 310, 50, 40, 1, 50));
            scene2.getChildren().addAll(new Weapon_Chest(4250, 310, 50, 40, bomb1));
            scene2.getChildren().addAll(new Weapon_Chest(4850, 320, 50, 40, knife1));

            scene2.getChildren().addAll(new Coin(2000, 310, 30, 30, 15));
            scene2.getChildren().addAll(new Coin(2050, 310, 30, 30, 15));
            scene2.getChildren().addAll(new Coin(2150, 310, 30, 30, 15));

            scene2.getChildren().addAll(new Coin(2400, 280, 30, 30, 15));
            scene2.getChildren().addAll(new Coin(2460, 280, 30, 30, 15));



            scene2.getChildren().addAll(new Green_Orc(1100, 200, 75, 75, 12, "Red", 2, 4, 1, 5, here));
            scene2.getChildren().addAll(new Green_Orc(3350, 200, 75, 75, 12, "Red", 2, 4, 1, 5, here));
            scene2.getChildren().addAll(new Green_Orc(3800, 200, 75, 75, 12, "Red", 2, 4, 1, 5, here));
            scene2.getChildren().addAll(new Red_Orc(4600.0, 200.0, 75.0, 75.0, 20.0, "Green", 3, 10, 100, 20, here));
            scene2.getChildren().addAll(new Red_Orc(5230.0, 200.0, 75.0, 75.0, 20.0, "Green", 3, 10, 100, 20, here));
            scene2.getChildren().addAll(new Red_Orc(1000.0, 200.0, 75.0, 75.0, 20.0, "Green", 3, 10, 100, 20, here));
            scene2.getChildren().addAll(new Red_Orc(6050.0, 200.0, 75.0, 75.0, 20.0, "Green", 3, 10, 100, 20, here));
            scene2.getChildren().addAll(new Green_Orc(7220, 200, 75, 75, 12, "Red", 2, 4, 1, 5, here));
            scene2.getChildren().addAll(new Green_Orc(8150, 200, 75, 75, 12, "Red", 2, 4, 1, 5, here));
            scene2.getChildren().addAll(new Red_Orc(8300.0, 200.0, 75.0, 75.0, 20.0, "Green", 3, 10, 100, 20, here));
            scene2.getChildren().addAll(new Coin(300, 310, 30, 30, 15));
            scene2.getChildren().addAll(new Coin(710, 310, 30, 30, 15));

            scene2.getChildren().addAll(new Boss_Orc(10100, 200, 125, 125, 1, "boss", 3, 2, 3, 4, here));


            scene2.getChildren().addAll(new Coin(760, 310, 30, 30, 15));




            //scene2.getChildren().addAll(new Weapon_Chest(1050, 300, 50, 70));

            //scene2.getChildren().addAll(new Orc(1050, 50), max);


            //scene2.getChildren().addAll(new Orc(500.0, 200.0, 75.0, 75.0, 20.0, "Green", 3, 10, 100, 20,30, here));
            Hero og = new Hero(100, 200, 50, 50, 20, 10, 100, here, scene2);
            scene2.getChildren().addAll(og);




            EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    og.dash.playFromStart();
                    og.setScore(og.getScore()+1);
                    if(og.curr_weapon instanceof Throwing_Knife){
                        System.out.println("throwing da knife");
                        try {
                            System.out.println("throwing da knife");
                            Throwing_Knife kz = new Throwing_Knife(og.x, og.y, 40, 20, 2, "Knife", og.knife_level, 1, scene2);
                            scene2.getChildren().addAll(kz);
                            kz.swish.play();

                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            };
            scene2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

            Image img= null;
            try {
                img = new Image(new FileInputStream("toPutInProject\\settings.png"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            pause.setBackground(new Background(
                    new BackgroundImage(
                            img,
                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                            new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
                    )));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }
}

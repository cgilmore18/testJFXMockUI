package sample;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML JFXHamburger ham1;
    @FXML JFXDrawer drawer;


   public void initialize(URL url, ResourceBundle rb) {
       VBox box = null;
       try {
           box = FXMLLoader.load(getClass().getResource("drawerContent.fxml"));
       } catch (IOException e) {
           e.printStackTrace();
       }
       drawer.setSidePane(box);

       HamburgerSlideCloseTransition hamburgerTransition= new HamburgerSlideCloseTransition(ham1);
       hamburgerTransition.setRate(-1);
       ham1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
           hamburgerTransition.setRate(hamburgerTransition.getRate()*-1);
           hamburgerTransition.play();

           if(drawer.isOpened()) {
               drawer.close();
           }else{
               drawer.open();
           }
       });
   }
}

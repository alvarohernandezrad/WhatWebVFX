/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ehu.isad;

import ehu.isad.controllers.ui.CMSKudeatzaile;
import ehu.isad.controllers.ui.MainKudeatzaile;
import ehu.isad.controllers.ui.ServerKudeatzaile;
import ehu.isad.controllers.ui.WhatWebKudeatzaile;
import ehu.isad.utils.Utils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.FXML;
import javafx.util.Callback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WhatWebFX extends Application {

    private Parent mainUI;

    private Stage stage;

    private Scene sceneM;

    private MainKudeatzaile mainKud;
    private CMSKudeatzaile cmsKud;
    private ServerKudeatzaile serverKud;
    private WhatWebKudeatzaile whatWebKud;

    //Pantaila mugitzeko kalkulurako
    private double xOffset = 0;
    private double yOffset =0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("WhatWebFX");
        this.ikonoaJarri("");
        stage.initStyle(StageStyle.UNDECORATED);

        pantailaMugitu();

        stage.setScene(sceneM);
        stage.show();


    }


    private void pantailakKargatu() throws IOException {
        //Pantaila nagusia kargatu
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Main.fxml"));
        mainKud = new MainKudeatzaile(this); //  setMain() metodoa ekidituz
        cmsKud = new CMSKudeatzaile();
        serverKud = new ServerKudeatzaile();
        whatWebKud = new WhatWebKudeatzaile();

        Callback<Class<?>, Object> controllerFactory = type -> {
            if (type == MainKudeatzaile.class) {
                return mainKud ;
            } else if (type == CMSKudeatzaile.class) {
                return cmsKud;
            } else if (type == ServerKudeatzaile.class) {
                return serverKud;
            } else if(type == WhatWebKudeatzaile.class){
                return whatWebKud;
            } else {
                // default behavior for controllerFactory:
                try {
                    return type.newInstance();
                } catch (Exception exc) {
                    exc.printStackTrace();
                    throw new RuntimeException(exc); // fatal, just bail...
                }
            }
        };
        loader.setControllerFactory(controllerFactory);
        mainUI = (Parent) loader.load();
        mainKud.hasieratu();
        sceneM = new Scene(mainUI);
    }


    private void pantailaMugitu(){
        //Pantaila nagusia
        mainUI.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        mainUI.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

    }

    public Stage getStage() {
        return stage;
    }

    private void ikonoaJarri(String izena){
        String path = Utils.lortuEzarpenak().getProperty("pathToImages")+izena+"icon.png";
        try {
            if(stage.getIcons().size()>0){
                stage.getIcons().remove(0);
            }
            stage.getIcons().add(new Image(new FileInputStream(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

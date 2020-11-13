/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ehu.isad;

import ehu.isad.controllers.ui.MainKudeatzaile;
import ehu.isad.controllers.ui.WhatWebKudeatzaile;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class WhatWebFX extends Application {
    private Parent mainUI;
    private Parent WhatWebUI;

    private Stage stage;

    private Scene sceneM;
    private Scene sceneWW;

    private MainKudeatzaile mainKud;
    private WhatWebKudeatzaile whatWebKudeatzaile;

    //Pantaila mugitzeko kalkulurako
    private double xOffset = 0;
    private double yOffset =0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("WhatWebFX");
        stage.initStyle(StageStyle.UNDECORATED);

        pantailaMugitu();

        stage.setScene(sceneM);
        stage.show();
    }


    private void pantailakKargatu() throws IOException {
        //Pantaila nagusia kargatu
        FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/FXML/Main.fxml"));
        mainUI = (Parent) loaderMain.load();
        mainKud= loaderMain.getController();
        mainKud.setMainApp(this);
        sceneM = new Scene(mainUI);

        //WhatWeb pantaila kargatu
        FXMLLoader loaderWhatWebo = new FXMLLoader(getClass().getResource("/FXML/WhatWeb.fxml"));
        WhatWebUI = (Parent) loaderWhatWebo.load();
        whatWebKudeatzaile= loaderWhatWebo.getController();
        whatWebKudeatzaile.setMainApp(this);
        sceneWW = new Scene(WhatWebUI);
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

        //WhatWeb pantaila
        WhatWebUI.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        WhatWebUI.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    public void WhatWeb(){
        stage.setTitle("WhatWebFX");
        stage.setScene(sceneWW);
        stage.show();
    }

    public void cms(){
        stage.setTitle("WhatWebFX");
        stage.setScene(sceneM);
        stage.show();
    }

    public Parent getMainUI() {
        return mainUI;
    }

    public Parent getWhatWebUI() {
        return WhatWebUI;
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getSceneM() {
        return sceneM;
    }

    public Scene getSceneWW() {
        return sceneWW;
    }
}

package ehu.isad.controllers.ui;

import ehu.isad.WhatWebFX;
import ehu.isad.controllers.db.WhatWebKud;
import javafx.application.Platform;
import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainKudeatzaile {

    private WhatWebFX mainApp;

    public MainKudeatzaile() {
        System.out.println("Main kud instantzia");
    }

    public void setMainApp(WhatWebFX main){
        this.mainApp = main;
    }

    @FXML
    private Button btnCMS;

    @FXML
    private Button btnServer;

    @FXML
    private Button btnWhatWeb;

    @FXML
    private AnchorPane anchorCMS;

    @FXML
    private AnchorPane anchorWhatWebo;

    @FXML
    private AnchorPane anchorServer;

    @FXML
    void onClick(ActionEvent event) {
        if(event.getSource()==btnCMS){
            anchorCMS.toFront();
        }
        else if (event.getSource()==btnWhatWeb){
            anchorWhatWebo.toFront();
        }
        else {
            anchorServer.toFront();
        }
    }

    @FXML
    void onClickClose(ActionEvent event) {
        mainApp.getStage().close();
    }


    public void hasieratu(){
        anchorCMS.toFront();
    }

    public void botoiaFocus(){
        Platform.runLater(() -> btnCMS.requestFocus());
    }

}

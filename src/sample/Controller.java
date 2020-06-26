package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.effect.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    Button sendButton;

    @FXML
    Button clearButton;

    @FXML
    TextField msgArea;

    @FXML
    TextArea chatArea;

    @Override
    public void initialize(URL location, ResourceBundle Recources) {
        System.out.println("Init succeed");
    }

    public void sendMessage() {
        chatArea.setText(chatArea.getText()+"Ваше сообщение:"+ "\n"+ msgArea.getText()+"\n");
        msgArea.clear();
    }

    public void clearHistory() {
        chatArea.clear();
    }
}

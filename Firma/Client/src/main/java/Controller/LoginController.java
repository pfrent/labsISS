package Controller;

import Domain.Person;
import Service.Observer;
import Service.iService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class LoginController implements Observer, Serializable {
    private iService server;
    public void setServer( iService s){
        this.server=s;
    }

    @FXML
    private TextField username;
    @FXML
    private TextField password;



    public void login() throws IOException {

        int code = server.login(new Person(0,username.getText(),password.getText(),"",""));
        if(code==1){

            FXMLLoader loader = new FXMLLoader(
                    getClass().getClassLoader().getResource("EmployeeWindow.fxml"));
            Parent root=loader.load();
            EmployeeController cont = loader.getController();
            cont.setServer(server,username.getText());
            server.addObserver("employee",cont);

            Stage stage = new Stage();
            stage.setTitle("WORK!");
            stage.setScene(new Scene(root));
            stage.show();

        }

        else if(code==2) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getClassLoader().getResource("SupervisorWindow.fxml"));
            Parent root=loader.load();
            SupervisorController cont = loader.getController();
            cont.setServer(server,username.getText());
            server.addObserver("supervisor",cont);

            Stage stage = new Stage();
            stage.setTitle("they WORK!");
            stage.setScene(new Scene(root));
            stage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Invalid credentials!");
            alert.showAndWait();
        }



        }

    @Override
    public void refresh() throws Exception {

    }
}

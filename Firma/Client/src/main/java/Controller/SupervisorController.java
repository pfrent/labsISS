package Controller;

import Domain.Person;
import Domain.Task;
import Service.Observer;
import Service.iService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.annotation.ComponentScan;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SupervisorController extends UnicastRemoteObject implements Observer, Serializable {
    private iService server;
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @FXML
    TextArea descrText;
    @FXML
    TextField durataText,dificultateText;
    @FXML
    Button trimiteButton;
    @FXML
    TableView<Person> employeeTable;
    @FXML
    TableColumn<Person,Integer> idColumn;
    @FXML
    TableColumn<Person,String> numeColumn;

    public SupervisorController() throws RemoteException {
    }

    @FXML
    public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        numeColumn.setCellValueFactory(new PropertyValueFactory<>("realName"));

        employeeTable.setItems(personList);
    }


    public void setServer( iService s,String username){
        this.server=s;
        server.findAllEmployees().forEach(x->personList.add(x));
    }

    @Override
    public void refresh() throws Exception {

    }

    public void trimiteTask(){
        System.out.println("ok");
        Integer id = employeeTable.getSelectionModel().getSelectedItems().get(0).getId();
        server.saveTask(new Task(0,id,descrText.getText(),
                Integer.parseInt( dificultateText.getText()),Integer.parseInt(durataText.getText())));
    }
}

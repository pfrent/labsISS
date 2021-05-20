package Controller;

import Domain.Person;
import Domain.Task;
import Service.Observer;
import Service.iService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EmployeeController extends UnicastRemoteObject implements Observer, Serializable {

    private iService server;

    private ObservableList<Task> taskList = FXCollections.observableArrayList();

    @FXML
    TextField timeText;

    @FXML
    TableView<Task> taskTable;
    @FXML
    TableColumn<Task,Integer> idColumn;
    @FXML
    TableColumn<Task,String> descriptionColumn;


    public EmployeeController() throws RemoteException {
    }

    @FXML
    public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        taskTable.setItems(taskList);
    }

    public void setServer( iService s, String username){

        this.server=s;

        server.visualizeTasks(server.findByUsername(username).getId()).forEach(x->taskList.add(x));

    }

    @Override
    public void refresh() throws Exception {

    }
}

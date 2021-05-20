import Controller.LoginController;
import Service.iService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class StartClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring-client.xml");
        iService server=(iService)factory.getBean("AppService");

        FXMLLoader loader = new FXMLLoader(
                    getClass().getClassLoader().getResource("login.fxml"));
        Parent root=loader.load();
        LoginController cont = loader.getController();
        cont.setServer(server);

        primaryStage.setTitle("Business");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

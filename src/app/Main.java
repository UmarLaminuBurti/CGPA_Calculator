package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application
{
    private static Controller controller;
    String AppPath = AppRootPath();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(Main::handle);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
        primaryStage.setTitle("CGPA Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new resources().icon);
        primaryStage.show();
        AppRootPath();
    }

    private static void handle(KeyEvent event) {
        // Shortcut Handling
        Object keyCode = event.getCode();

        // Calculate Button Shortcut
        if (keyCode == KeyCode.C) {
            System.out.println("Shortcut key C is pressed");
            controller.calculateButton.fire();
            event.consume();
        }

        // Edit Sheet Button Shortcut
        else if (keyCode == KeyCode.G) {
            System.out.println("Shortcut key G is pressed");
            controller.editSheetBtn.fire();
            event.consume();
        }

        // Quit Button Shortcut
        else if (keyCode == KeyCode.Q) {
            System.out.println("Shortcut key Q is pressed");
            controller.quitMenuBtn.fire();
            event.consume();
        }

        // License Button Shortcut
        else if (keyCode == KeyCode.L) {
            System.out.println("Shortcut key L is pressed");
            controller.licenseMenuBtn.fire();
            event.consume();
        }

        // About Button Shortcut
        else if (keyCode == KeyCode.A) {
            System.out.println("Shortcut key A is pressed");
            controller.aboutMenuBtn.fire();
            event.consume();
        }
    }

    private String AppRootPath()
    {
        String AppPath = System.getProperty("java.class.path");
        StringBuilder x = new StringBuilder();
        boolean IsWindows = System.getProperty("os.name").contains("Windows");

        if (AppPath.contains(".jar;")) {
            AppPath = "";
        }
        else if (AppPath.contains(".jar")) {
            if (IsWindows) {
                String[] tmp = AppPath.split("\\s*\\\\s*");
                for (int i = 0; i < tmp.length-1; i++)
                    x.append(tmp[i]).append("\\");
            } else {
                String[] tmp = AppPath.split("\\s*/\\s*");
                for (int i = 0; i < tmp.length-1; i++)
                    x.append(tmp[i]).append("/");
            }
            AppPath = x.toString();
        } else {
            AppPath = "";
        }
        return AppPath;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

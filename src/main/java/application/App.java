package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private Tab utentiTab;
    private Tab giudiciTab;

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Multi-Tab Program");

        // Create login page
        StackPane loginPage = new StackPane();
        GridPane loginGridPane = new GridPane();
        loginGridPane.setPadding(new Insets(10));
        loginGridPane.setHgap(10);
        loginGridPane.setVgap(10);

        Text loginTitle = new Text("Login");
        loginTitle.setFont(Font.font(20));
        loginGridPane.add(loginTitle, 0, 0, 2, 1);

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        loginGridPane.add(usernameLabel, 0, 1);
        loginGridPane.add(usernameField, 1, 1);

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        loginGridPane.add(passwordLabel, 0, 2);
        loginGridPane.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        loginGridPane.add(loginButton, 0, 3, 2, 1);
        loginGridPane.setHalignment(loginButton, javafx.geometry.HPos.CENTER);

        loginPage.getChildren().add(loginGridPane);

        // Create the "Utenti" tab
        utentiTab = new Tab("Utenti");
        utentiTab.setClosable(false);

        // Create content for "Utenti" tab
        TabPane utentiTabPane = new TabPane();

        // Create the "Città" tab
        Tab cittaTab = new Tab("Città");
        cittaTab.setClosable(false);

        // Create content for "Città" tab
        StackPane cittaContent = new StackPane();

        Text cittaTitle = new Text("Città");
        cittaTitle.setFont(Font.font(20));

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        GridPane cittaGridPane = new GridPane();
        cittaGridPane.setPadding(new Insets(10));
        cittaGridPane.setHgap(10);
        cittaGridPane.setVgap(10);
        cittaGridPane.add(cittaTitle, 0, 0);
        cittaGridPane.add(button1, 0, 1);
        cittaGridPane.add(button2, 0, 2);
        cittaGridPane.add(button3, 0, 3);

        cittaContent.getChildren().add(cittaGridPane);
        cittaTab.setContent(cittaContent);

        // Create the "Annunci" tab
        Tab annunciTab = new Tab("Annunci");
        annunciTab.setClosable(false);

        // Create content for "Annunci" tab
        StackPane annunciContent = new StackPane();

        Text annunciTitle = new Text("Annunci");
        annunciTitle.setFont(Font.font(20));

        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");

        GridPane annunciGridPane = new GridPane();
        annunciGridPane.setPadding(new Insets(10));
        annunciGridPane.setHgap(10);
        annunciGridPane.setVgap(10);
        annunciGridPane.add(annunciTitle, 0, 0);
        annunciGridPane.add(button4, 0, 1);
        annunciGridPane.add(button5, 0, 2);
        annunciGridPane.add(button6, 0, 3);

        annunciContent.getChildren().add(annunciGridPane);
        annunciTab.setContent(annunciContent);

        // Create the "Messaggi" tab
        Tab messaggiTab = new Tab("Messaggi");
        messaggiTab.setClosable(false);

        // Create content for "Messaggi" tab
        StackPane messaggiContent = new StackPane();

        Text messaggiTitle = new Text("Messaggi");
        messaggiTitle.setFont(Font.font(20));

        Button button7 = new Button("Button 7");
        Button button8 = new Button("Button 8");
        Button button9 = new Button("Button 9");

        GridPane messaggiGridPane = new GridPane();
        messaggiGridPane.setPadding(new Insets(10));
        messaggiGridPane.setHgap(10);
        messaggiGridPane.setVgap(10);
        messaggiGridPane.add(messaggiTitle, 0, 0);
        messaggiGridPane.add(button7, 0, 1);
        messaggiGridPane.add(button8, 0, 2);
        messaggiGridPane.add(button9, 0, 3);

        messaggiContent.getChildren().add(messaggiGridPane);
        messaggiTab.setContent(messaggiContent);

        // Add nested tabs to the "Utenti" tab pane
        utentiTabPane.getTabs().addAll(cittaTab, annunciTab, messaggiTab);
        utentiTab.setContent(utentiTabPane);

        // Create the "Giudici d'esecuzione" tab
        giudiciTab = new Tab("Giudici d'esecuzione");
        giudiciTab.setClosable(false);

        // Create content for "Giudici d'esecuzione" tab
        StackPane giudiciContent = new StackPane();

        Text giudiciTitle = new Text("Giudici d'esecuzione");
        giudiciTitle.setFont(Font.font(20));

        Button button10 = new Button("Button 10");
        Button button11 = new Button("Button 11");
        Button button12 = new Button("Button 12");

        GridPane giudiciGridPane = new GridPane();
        giudiciGridPane.setPadding(new Insets(10));
        giudiciGridPane.setHgap(10);
        giudiciGridPane.setVgap(10);
        giudiciGridPane.add(giudiciTitle, 0, 0);
        giudiciGridPane.add(button10, 0, 1);
        giudiciGridPane.add(button11, 0, 2);
        giudiciGridPane.add(button12, 0, 3);

        giudiciContent.getChildren().add(giudiciGridPane);
        giudiciTab.setContent(giudiciContent);

        // Create the tab pane and add tabs
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(utentiTab, giudiciTab);

        // Set initial visibility
        tabPane.setVisible(false);

        // Set login button action
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (isValidCredentials(username, password)) {
                loginPage.setVisible(false);
                tabPane.setVisible(true);
                disableTabs(username);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Credenziali errate");
                alert.setHeaderText(null);
                alert.setContentText("Username o password non validi. Riprova");
                alert.showAndWait();
            }
        });

        // Create the main scene
        Scene mainScene = new Scene(new StackPane(loginPage, tabPane), 400, 300);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private boolean isValidCredentials(String username, String password) {
        // Perform your validation logic here
        // This is just a dummy implementation
        return (username.equals("utente") || username.equals("giudice")) && password.equals("psw");
    }

    private void disableTabs(String username) {
        if (username.equals("utente")) {
            giudiciTab.setDisable(true);
        } else if (username.equals("giudice")) {
            utentiTab.setDisable(true);
        }
    }

    public static void main(String[] args) {
    	
    	try {
			Connection connection;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/elab01", "root", "root");
		
	        Statement statement = connection.createStatement();
	
	        // Execute the query to get all the rows of the table
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + "utenti");
	
	        // Loop through the result set and print the rows
	        while (resultSet.next()) {
	            // Print the values of each row
	            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
	                System.out.print(resultSet.getString(i) + " ");
	            }
	            System.out.println();
        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        launch(args);
    }
}

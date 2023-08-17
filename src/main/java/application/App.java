package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import application.operations.OpFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import lab.db.ConnectionProvider;

public class App extends Application {

    ConnectionProvider connProv = new ConnectionProvider("root", "root", "elab01");
	Connection connection = connProv.getMySQLConnection();

    private Stage primaryStage;
    private Scene loginScene;
    private Scene utenteScene;
    private Scene giudiceScene;

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("Elaborato DB");
        this.primaryStage = primaryStage;

        createLoginScene();

        // Create "utente" scene
        TabPane tabPane = createUtenteTabPane();
        utenteScene = new Scene(tabPane, 800, 600);

        // Create "giudice" scene
        StackPane giudiceLayout = new StackPane(new Label("Giudice Scene"));
        giudiceScene = new Scene(giudiceLayout, 300, 200);

        // Set initial scene
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.show();
       
    }

    private void createLoginScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        loginScene = new Scene(grid, 400, 300);

        Label sceneTitle = new Label("Log In");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("Username:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button loginBtn = new Button("Log in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginBtn);
        grid.add(hbBtn, 1, 4);

        loginBtn.setOnAction(event -> {
            String username = userTextField.getText();
            String password = pwBox.getText();

            if (username.equals("utente") && password.equals("psw")) {
                primaryStage.setScene(utenteScene);
                primaryStage.setTitle("Utente");
            } else if (username.equals("giudice") && password.equals("psw")) {
                primaryStage.setScene(giudiceScene);
                primaryStage.setTitle("Giudice");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();
            }
        });
    }

    private TabPane createUtenteTabPane() {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Città");
        tab1.setClosable(false);
        String query1 = new OpFactory().createOp7().getQuery(Optional.of(List.of(1)));
        tab1.setContent(createTabContent("Città", query1));

        Tab tab2 = new Tab("Zone");
        tab2.setClosable(false);
        String query2 = "SELECT * FROM zone";
        tab2.setContent(createTabContent("Zone", query2));

        Tab tab3 = new Tab("Immobili");
        tab3.setClosable(false);
        String query3 = "SELECT * FROM immobili";
        tab3.setContent(createTabContent("Immobili", query3));

        tabPane.getTabs().addAll(tab1, tab2, tab3);
        return tabPane;
    }

     private VBox createTabContent(String queryName, String query) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label label = new Label(queryName);
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        TableView<DataItem> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numColumns = metaData.getColumnCount();

            for (int i = 1; i <= numColumns; i++) {
                TableColumn<DataItem, String> column = new TableColumn<>(metaData.getColumnName(i));
                int j = i;
                column.setCellValueFactory(cellData -> cellData.getValue().valueProperty(j - 1));
                tableView.getColumns().add(column);
            }
            
            Button updateButton = new Button("Update Table");
            updateButton.setOnAction(event -> updateTableDataFromDatabase(tableView, numColumns, query));

            layout.getChildren().addAll(label, tableView, updateButton);
            return layout;

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return layout;
            
    }

    private void updateTableDataFromDatabase(TableView<DataItem> tableView, int numColumns, String query) {
        ObservableList<DataItem> data = FXCollections.observableArrayList();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String[] values = new String[numColumns];
                for (int i = 0; i < numColumns; i++) {
                    values[i] = resultSet.getString(i + 1);  // Column indexes start from 1
                }
                data.add(new DataItem(values));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        

        tableView.setItems(data);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

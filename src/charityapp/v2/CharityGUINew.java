package charityapp.v2;



import com.sun.istack.internal.Nullable;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.logging.Logger;

public class CharityGUINew extends Application {

    private int clientID = -1;
    private static final Logger LOG = Logger.getGlobal();
    private Stage primaryStage;
    private Scene firstScene;
    private Scene mainScene;
    private int userID;

    private final int WINDOW_WIDTH = 1024;
    private final int WINDOW_HEIGHT = 768;

    @Override
    public void start(Stage primaryStage) throws Exception {
        setFirstSceneElements();
        setFirstStage(primaryStage, firstScene);
    }

    /**
     * Creates the first page the user will see when opening the app
     * @param firstStage Initial stage the user will see
     */
    private void setFirstStage(Stage firstStage, Scene scene) {
        this.primaryStage = firstStage;
        // Sets the window dimensions to 1024x768 (2:1)
        firstStage.setWidth(1024);
        firstStage.setHeight(768);

        // Prevent resizing of the window. (Until we can properly align the elements
        firstStage.setResizable(false);

        // Sets the title of the window to "Charity App".
        firstStage.setTitle("Charity App");

        firstStage.setScene(scene);
        firstStage.show();
    }

    /**
     * Creates the initial screen that the user will see upon launching the GUI.
     * @return the GridPane used in the first scene.
     */
    private void setFirstSceneElements() {
        LOG.fine("Creating first stage's elements.");
        // Construct elements for the first stage.
        GridPane grid = new GridPane();
        VBox instructVbox = new VBox();
        VBox inputVbox = new VBox();
        Label welcome = new Label();
        Label instruct = new Label();
        TextField idField = new TextField();
        Button login = new Button();
        Button newUser = new Button();
        Label errmsg = new Label();

        // Adjust containers
        // Grid
        grid.setGridLinesVisible(false);
        RowConstraints bigRowCon = new RowConstraints(256);
        RowConstraints paddingRowCon = new RowConstraints(128);
        ColumnConstraints bigColCon = new ColumnConstraints(768);
        ColumnConstraints paddingColCon = new ColumnConstraints(128);
        grid.getRowConstraints().setAll(bigRowCon, bigRowCon, paddingRowCon);
        grid.getColumnConstraints().setAll(paddingColCon, bigColCon, paddingColCon);
        // VBoxes
        instructVbox.setAlignment(Pos.CENTER);
        inputVbox.setAlignment(Pos.CENTER);

        // Set the texts and constraints of each element
        welcome.setText("Welcome to the Charity App!");
        welcome.setTextAlignment(TextAlignment.CENTER);
        instruct.setText("Please enter your ID below, or sign up for a new one.");
        instruct.setTextAlignment(TextAlignment.CENTER);
        idField.setMaxWidth(50);
        login.setText("Login");
        newUser.setText("Register");
        errmsg.setTextAlignment(TextAlignment.CENTER);

        // Set the action of applicable elements. TODO: combine the check with the button check to keep it DRY
//        idField.setOnKeyPressed(key -> {
//            if(key.getCode().equals(KeyCode.ENTER)) {
//                try {
//                    clientID = Objects.requireNonNull(findUser(idField.getText(), errmsg)).getId();
//                } catch (NullPointerException e) {
//                    LOG.severe("Null ID was found while trying to assign client ID.");
//                }
//            }
//        });

        login.setOnAction(action -> {
            Person foundUser = findUser(idField.getText(), errmsg); // Use later
            if(foundUser != null) {
                this.userID = foundUser.getId();
                setUpMainScene();
                switchScene(mainScene);
            }

        });

        newUser.setOnAction(action -> {
            Person newPerson = new Person();
            this.userID = newPerson.getId();
            setUpMainScene();
            switchScene(mainScene);
        });

        // Add everything to grid.
        instructVbox.getChildren().setAll(welcome, instruct);
        inputVbox.getChildren().setAll(idField, login, newUser);
        grid.add(instructVbox, 1, 0);
        grid.add(inputVbox, 1, 1);
        grid.add(errmsg, 1, 2);
        grid.setVisible(true);
        this.firstScene = new Scene(grid);
    }

    private void switchScene(Scene newScene) {
        primaryStage.hide();
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    private void setUpMainScene() {
        GridPane mainPage = new GridPane();
        VBox locationVbox = new VBox();
        VBox otherOptionsVbox = new VBox();
        HBox profileControlHbox = new HBox();
        Label userDisplay = new Label();
        Button logOut = new Button();
        Button viewProfile = new Button();
        Label location = new Label();
        Label international = new Label();
        Label national = new Label();
        Label local = new Label();
        Label otherOptions = new Label();
        CheckBox isGovAff = new CheckBox();
        CheckBox donates = new CheckBox();
        Button submit = new Button();

        // Grid
        // Set Constraints
        RowConstraints bigRowCon = new RowConstraints(256);
        RowConstraints paddingRowCon = new RowConstraints(128);
        ColumnConstraints bigColCon = new ColumnConstraints(768);
        ColumnConstraints paddingColCon = new ColumnConstraints(128);
        mainPage.getRowConstraints().setAll(bigRowCon, bigRowCon, paddingRowCon);
        mainPage.getColumnConstraints().setAll(paddingColCon, bigColCon, paddingColCon);

        // Initialize controls
        userDisplay.setText("Welcome back, " + String.valueOf(userID));
        logOut.setText("LOG OUT");
        viewProfile.setText("VIEW PROFILE");
        location.setText("Location: ");
        international.setText("International");
        national.setText("National");
        local.setText("Local");
        otherOptions.setText("Other Options:");
        isGovAff.setText("Is Government Affiliated?");
        donates.setText("Donates More than 75% to charity?");
        submit.setText("SUBMIT");

        // Assign actions to buttons.
        logOut.setOnAction(action -> {
           switchScene(firstScene);
        });

        // Put controls into appropriate boxes.
        profileControlHbox.getChildren().addAll(logOut, userDisplay, viewProfile);
        locationVbox.getChildren().addAll(location, international, national, local);
        otherOptionsVbox.getChildren().addAll(otherOptions, isGovAff, donates, submit);
        mainPage.add(profileControlHbox, 1, 0);
        mainPage.add(locationVbox, 0, 1);
        mainPage.add(otherOptionsVbox, 2, 1);

        this.mainScene = new Scene(mainPage);
    }

    private Person findUser(String id, @Nullable Label errmsg) { // Placeholder return type.
        if(!InputChecker.isValidID(id)) {
            LOG.info("Invalid ID was inputted.");
            errmsg.setText("Not a valid ID.");
        }
        else {
            int corrected = Integer.parseInt(id); // Corrected the String to an int
            errmsg.setText("");
            for (Person toTest : Person.getUsers()) {
                if (toTest.getId() == corrected) {
                    LOG.info("Person was found.");
                    return toTest;
                }
            }
            LOG.info("Person was not found.");
            errmsg.setText("No user was found with this ID: " + id);
        }
        return null;
    }

    @Override
    public void stop() {
        LOG.info("Saving users...");
        File directory = new File(".//savestates//users.ser");
        if(!directory.isDirectory()) {
            LOG.info("Directory does not exist; creating...");
            directory.mkdir();
        }
        try (FileOutputStream fileOutput = new FileOutputStream(".//savestates//users.ser");
             ObjectOutputStream writeOut = new ObjectOutputStream(fileOutput);
        ) {
            File file = new File(".//savestates//users.ser");
            if(file.createNewFile()) {
                LOG.info("File already exists. Overwriting.");
            }
            writeOut.writeObject(Person.getUsers());
        } catch (IOException e) {
            LOG.severe("There was a problem writing to ./savestates/users.ser");
            e.printStackTrace();
        }
        LOG.info("Exiting application.");

    }
    
    public static void main(String[] args) {
        launch(args);
    }

}

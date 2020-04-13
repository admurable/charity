package charityapp.v2;

import javafx.geometry.Insets;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.Region.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.Control;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CharityGUI extends Application {
	
	private int clientID = -1;
	final FileChooser fileChooser = new FileChooser();
	private Desktop desktop = Desktop.getDesktop();
	
	// Controls
		Button btn0 = new Button();
		Button btn1 = new Button();
		Button btn2 = new Button();
		Button btn3 = new Button();
		Button btn4 = new Button();
		Button btn5 = new Button();
		Button btn6 = new Button();
		Button btn7 = new Button();
		Button btn8 = new Button();
		Button btn9 = new Button();
		Label lbl0 = new Label();
		Label lbl1 = new Label();
		Label lbl2 = new Label();
		Label lbl3 = new Label();
		Label lbl4 = new Label();
		Label lbl5 = new Label();
		Label lbl6 = new Label();
		Label lbl7 = new Label();
		Label lbl8 = new Label();
		Label lbl9 = new Label();
		Label lbl10 = new Label();
		Label lbl11 = new Label();
		TextField txt1 = new TextField();
		TextField txt2 = new TextField();
		TextField txt3 = new TextField();
		CheckBox cb1 = new CheckBox();
		CheckBox cb2 = new CheckBox();
		CheckBox cb3 = new CheckBox();
		CheckBox cb4 = new CheckBox();
		CheckBox cb5 = new CheckBox();
		VBox menuBox = new VBox(14);
		VBox locationBox = new VBox(8);
		VBox questionBox = new VBox(8);
		VBox textSearchBox = new VBox(8);
		VBox resultsBox = new VBox(8);
		VBox loginBox = new VBox(14);
		VBox profileControlBox = new VBox(8);
		VBox profileContentBox = new VBox(8);
        HBox searchSubmitBox = new HBox(8);
        ComboBox<String> comboBox1 = new ComboBox();
        ComboBox comboBox2 = new ComboBox();
        
	@Override
	public void start(Stage mainStage) throws Exception {
		BorderPane mainPane= new BorderPane();
		setUpControls(mainPane, mainStage);
		Scene scene= new Scene(mainPane);
		setStage(mainStage, scene);
	}
	
	private void setStage(Stage mainStage, Scene scene) {
		mainStage.setWidth(700);
		mainStage.setHeight(350);
		mainStage.setTitle("Charity App");
		mainStage.setScene(scene);
		mainStage.show();
	}
	
	public void setUpControls(BorderPane mainPane, Stage mainStage) {
		lbl0.setText("Login in to CharityApp with your UserID or select 'REGISTER'");
		btn1.setText("LOGIN");   
		btn2.setText("REGISTER");
		btn8.setText("LOAD PROFILES");
        loginBox.getChildren().addAll(lbl0, txt1, btn1, btn2, btn8);
        txt1.setMaxWidth(60);
        
        lbl2.setText("Search for Charities ...");
    	btn4.setText("LOG OUT");
    	btn0.setText("VIEW PROFILE");
        menuBox.getChildren().addAll(lbl1, btn0, btn4, lbl2);
    	lbl3.setText("Location:");
    	cb1.setText("International");
    	cb2.setText("National");
    	cb3.setText("Local");
        locationBox.getChildren().addAll(lbl3, cb1, cb2, cb3);
        lbl9.setText("Other Options:");
        cb4.setText("Government Affiliated?");
        cb5.setText("More than 75% to Charity?");
        questionBox.getChildren().addAll(lbl9, cb4, cb5);
        btn3.setText("SUBMIT");
        searchSubmitBox.getChildren().addAll(btn3);
        
        lbl4.setText("Charities Matching Your Criteria:");
        txt3.setMaxWidth(50);
        txt3.setText("Hours");
		btn5.setText("EDIT SEARCH");
		btn6.setText("VOLUNTEER FOR SELECTED");
		lbl5.setText("");
		resultsBox.getChildren().addAll(lbl4,comboBox1,txt3,btn5,btn6,lbl5);
		
		btn7.setText("BACK");
		btn9.setText("SAVE PROFILE");
		profileControlBox.getChildren().addAll(lbl7, btn7, btn9, btn4);
		
		lbl10.setText("OR Search by charity name:");
		lbl11.setText("Will ignore other search options.");
		txt2.setMaxWidth(200);
		textSearchBox.getChildren().addAll(lbl10, txt2, lbl11);
		
		lbl8.setText("Charities you volunteered for:");
		profileContentBox.getChildren().addAll(lbl8, comboBox2);
        
        loginPage(mainPane, mainStage);
	}

	public void loginPage(BorderPane mainPane, Stage mainStage) {
		lbl0.setText("Login in to CharityApp with your UserID or select 'REGISTER'");
		mainPane.getChildren().clear();
		mainPane.setCenter(loginBox);
		loginBox.setAlignment(Pos.CENTER);
		loginBox.setVisible(true);
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	ArrayList<Person> users = Person.getUsers();
            	if(users.size() != 0) {
            		boolean found = false;
	            	for(Person p: Person.getUsers()) {
	            		if(txt1.getText().equals(p.getId())) {
	            			found = true;
	            			clientID = (p.getId());
	                    	mainPage(mainPane, mainStage);
	            		}
	            	}
	            	if (!found) {
	            		lbl0.setText("Incorrect ID Entered.");
	            	}
            	}
            	else{
            		lbl0.setText("No Users Exist. Select 'REGISTER'");
            	}
            }
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mainPage(mainPane, mainStage);
            }
		});
		
		btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	File file = fileChooser.showOpenDialog(mainStage);
                if (file != null) {
                    openFile(file);
                }
            }
		});
	}
	
	public void mainPage(BorderPane mainPane, Stage mainStage) {
		if (clientID!=-1) {
			lbl1.setText("Welcome back to Charity App. Your ID is: " + clientID);
		}
		else{
			clientID = (new Person()).getId();
			lbl1.setText("Welcome to Charity App. Your ID is: " + clientID);
		}
		mainPane.getChildren().clear();
    	menuBox.setVisible(true);
		locationBox.setVisible(true);
		questionBox.setVisible(true);
		searchSubmitBox.setVisible(true);
		textSearchBox.setVisible(true);
        mainPane.setTop(menuBox);
        menuBox.setAlignment(Pos.CENTER);
        locationBox.setAlignment(Pos.CENTER_LEFT);
        locationBox.setPadding(new Insets(20));
        mainPane.setLeft(locationBox);
        questionBox.setAlignment(Pos.CENTER_LEFT);
        mainPane.setCenter(questionBox);
        questionBox.setPadding(new Insets(20));
        mainPane.setBottom(searchSubmitBox);
        textSearchBox.setPadding(new Insets(20));
        mainPane.setRight(textSearchBox);
        textSearchBox.setAlignment(Pos.CENTER_LEFT);
        searchSubmitBox.setAlignment(Pos.TOP_CENTER);
        searchSubmitBox.setPadding(new Insets(30));
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	selectPage(mainPane, mainStage);
            }
        });
        
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	loginPage(mainPane, mainStage);
            }
        });	
        
        btn0.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	profilePage(mainPane, mainStage);
            }
        });	
	}
	
	public void selectPage(BorderPane mainPane, Stage mainStage) {
		mainPane.getChildren().clear();
		comboBox1.getItems().clear();
		
		comboBox1.getItems().addAll(
			"Charity 1",
			"Charity 2",
			"Charity 3",
			"Charity 4"		
		);
		
		mainPane.setTop(resultsBox);
		resultsBox.setAlignment(Pos.TOP_CENTER);
		resultsBox.setPadding(new Insets(20));
		resultsBox.setVisible(true);
		
		btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mainPage(mainPane, mainStage);
            }
        });
		
		btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	lbl5.setText("Successfully volunteered for: " + comboBox1.getValue());
            }
        });
	}
	
	public void profilePage(BorderPane mainPane, Stage mainStage) {
		mainPane.getChildren().clear();
		lbl7.setText("Your ID: " + clientID );
		profileControlBox.setVisible(true);
		profileContentBox.setVisible(true);
		mainPane.setTop(profileControlBox);
		profileControlBox.setAlignment(Pos.CENTER);
		mainPane.setCenter(profileContentBox);
		profileContentBox.setAlignment(Pos.CENTER);
		
		btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mainPage(mainPane, mainStage);
            }
        });
		
		btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	loginPage(mainPane, mainStage);
            }
        });	
		
		btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	//save profile
            }
        });	
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}

	private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                CharityGUI.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
	
}

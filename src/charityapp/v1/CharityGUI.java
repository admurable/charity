package charityapp.v1;

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


public class CharityGUI extends Application {
	
	private int id = -1;
	private boolean initial = true;
	
	// Controls
		Button btn0 = new Button();
		Button btn1 = new Button();
		Button btn2 = new Button();
		Button btn3 = new Button();
		Button btn4 = new Button();
		Button btn5 = new Button();
		Button btn6 = new Button();
		Label lbl0 = new Label();
		Label lbl1 = new Label();
		Label lbl2 = new Label();
		Label lbl3 = new Label();
		Label lbl4 = new Label();
		Label lbl5 = new Label();
		Label lbl6 = new Label();
		TextField txt1 = new TextField();
		CheckBox cb1 = new CheckBox();
		CheckBox cb2 = new CheckBox();
		CheckBox cb3 = new CheckBox();
		CheckBox cb4 = new CheckBox();
		CheckBox cb5 = new CheckBox();
		VBox vbox1 = new VBox(20);
		VBox vbox2 = new VBox(8);
		VBox vbox3 = new VBox(8);
		VBox vbox4 = new VBox(8);
		VBox vbox5 = new VBox(16);
        HBox hbox2 = new HBox(8);
        ComboBox comboBox1 = new ComboBox();


	@Override
	public void start(Stage mainStage) throws Exception {
		BorderPane mainPane= new BorderPane();
		BorderPane midPane= new BorderPane();
		setUpLoginPage(mainPane, midPane);
		Scene scene= new Scene(mainPane);
		setStage(mainStage, scene);
	}
	private void setStage(Stage mainStage, Scene scene) {
		mainStage.setWidth(700);
		mainStage.setHeight(350);
		mainStage.setTitle("CharityMain");

		mainStage.setScene(scene);
		mainStage.show();
	}

	public void setUpLoginPage(BorderPane mainPane, BorderPane midPane) {
		lbl0.setText("Login in to CharityApp with your UserID or select 'REGISTER'");
		btn1.setText("LOGIN");   
		btn2.setText("REGISTER");
        vbox5.getChildren().addAll(lbl0, txt1, btn1, btn2);
		loginPage(mainPane, midPane);
	}
	
	public void loginPage(BorderPane mainPane, BorderPane midPane) {
		txt1.setMaxWidth(50);
		mainPane.setCenter(midPane);
		mainPane.setBottom(new Label(" "));
		mainPane.setTop(vbox5);
		vbox5.setAlignment(Pos.TOP_CENTER);
		lbl0.setText("Login in to CharityApp with your UserID or select 'REGISTER'");
		vbox1.setVisible(false);
		vbox2.setVisible(false);
		vbox3.setVisible(false);
		hbox2.setVisible(false);
		vbox5.setVisible(true);
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	ArrayList<Person> users = Person.getUsers();
            	if(users.size() != 0) {
            		boolean found = false;
	            	for(Person p: Person.getUsers()) {
	            		if(txt1.getText().equals(p.getId())) {
	            			found = true;
	            			id = (p.getId());
	                    	setUpMainPage(mainPane, midPane);
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
            	setUpMainPage(mainPane, midPane);
            }
		});
	}
	
	public void mainPage(BorderPane mainPane, BorderPane midPane) {
		vbox4.setVisible(false);
		vbox5.setVisible(false);
    	vbox1.setVisible(true);
		vbox2.setVisible(true);
		vbox3.setVisible(true);
		hbox2.setVisible(true);
        mainPane.setTop(vbox1);
        vbox1.setAlignment(Pos.CENTER);
        vbox2.setAlignment(Pos.CENTER);
        mainPane.setLeft(vbox2);
        vbox3.setAlignment(Pos.CENTER);
        mainPane.setRight(vbox3);
        mainPane.setBottom(hbox2);
        hbox2.setAlignment(Pos.CENTER);
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	vbox4.setVisible(true);
            	selectPage(mainPane, midPane);
            }
        });
        
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	loginPage(mainPane, midPane);
            }
        });
    	
	}
	
	public void setUpMainPage(BorderPane mainPane, BorderPane midPane) {
		if (id!=-1) {
			lbl1.setText("Welcome back to Charity App. Your ID is: " + id);
		}
		else lbl1.setText("Welcome to Charity App. Your ID is: " + (new Person()).getId());
    	lbl2.setText("Search for Charities ...");
    	btn4.setText("LOG OUT");
    	btn0.setText("VIEW PROFILE");
        vbox1.getChildren().addAll(lbl1, btn0, btn4, lbl2);
    	lbl3.setText("Location:");
    	cb1.setText("International");
    	cb2.setText("National");
    	cb3.setText("Local");
        vbox2.getChildren().addAll(lbl3, cb1, cb2, cb3);
        cb4.setText("Government Affiliated?");
        cb5.setText("More than 75% to Charity?");
        vbox3.getChildren().addAll(cb4, cb5);
        btn3.setText("Submit");
        hbox2.getChildren().addAll(btn3);
        mainPage(mainPane, midPane);
	}
	
	public void setUpSelectPage(BorderPane mainPane, BorderPane midPane) {
		initial = false;
		lbl4.setText("Charities Matching Your Criteria:");
		btn5.setText("EDIT SEARCH");
		btn6.setText("VOLUNTEER FOR SELECTED");
		lbl5.setText("");
        vbox4.getChildren().addAll(lbl4,comboBox1,btn5,btn6,lbl5);
        mainPane.setTop(vbox4);
		vbox4.setAlignment(Pos.TOP_CENTER);
		selectPage(mainPane, midPane);
	}
	
	public void selectPage(BorderPane mainPane, BorderPane midPane) {
		if(initial) {
			setUpSelectPage(mainPane, midPane);
		}
		vbox1.setVisible(false);
		vbox2.setVisible(false);
		vbox3.setVisible(false);
		hbox2.setVisible(false);
		comboBox1.getItems().clear();
		comboBox1.getItems().addAll(
			"Charity 1",
			"Charity 2",
			"Charity 3",
			"Charity 4"		
		);
		vbox4.setVisible(true);
		
		btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mainPage(mainPane, midPane);
            }
        });
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
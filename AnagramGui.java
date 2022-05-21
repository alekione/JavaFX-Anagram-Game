import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AnagramGui extends Application {
	BorderPane borderPane;
	VBox vBox, rBox;
	HBox buttonBox, hbox;
	int width, height;
	Label label, label1, label2;
	ChoiceBox choiceBox;
	Button newGame, restart, nextGame, exit;
	TextField text;
	Tooltip tip, tip1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		gameIntro();
		
		
		Scene scene = new Scene(borderPane,400,400);
		arg0.setScene(scene);
		arg0.setTitle("ANAGRAM GAME");
		arg0.show();
	}
	
	protected void gameIntro() {
		Button play = new Button("PLAY");
		play.setOnAction(e -> {playGame();});
		Button exit = new Button("EXIT");
		exit.setOnAction(e -> {Platform.exit();});
		buttonBox = new HBox(20, play, exit);
		buttonBox.setAlignment(Pos.CENTER);
		
		Label text = new Label();
		text.setText("Welcome To Anagram Game.\n Please Choose one of the options given.");
		text.setFont(new Font(25));
		
		VBox box = new VBox(20, text, buttonBox);
		box.setAlignment(Pos.CENTER);
		borderPane = new BorderPane();
		BorderPane.setMargin(box, new Insets(12,12,12,12));
		borderPane.setCenter(box);
		
	}

	String choice;
	void playGame() {
		String selections[] = {"Choose a level", "Hard", "Medium", "Simple"};
		choiceBox = new ChoiceBox(FXCollections.observableArrayList(selections));
		label = new Label();
		rBox = new VBox(20, choiceBox, label);
		
		label1 = new Label("Please fill in the gaps:\n");
		label1.setFont(new Font(20));
		
		label2 = new Label("Your word:");
		text = new TextField();
		text.setEditable(false);
		
		vBox = new VBox(20, label1, label2, text); 
		vBox.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
		
		tip = new Tooltip();
		tip.setText("You must set game level first");
		tip.setStyle("-fx-font: normal bold 10 Cursive; " + "-fx-base: #AE3522; ");
		
		newGame = new Button("New");
		newGame.setTooltip(tip);
		nextGame = new Button("Next");
		nextGame.setTooltip(tip);
		exit = new Button("Exit");
		exit.setOnAction(e -> {Platform.exit();});
		hbox = new HBox(20, newGame, nextGame, exit);
		hbox.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,null, null)));
		
		borderPane.setCenter(vBox);
		BorderPane.setMargin(vBox, new Insets(12,12,12,12));
		borderPane.setBottom(hbox);
		BorderPane.setMargin(hbox, new Insets(12,12,12,12));
		borderPane.setRight(rBox);
		BorderPane.setMargin(rBox, new Insets(12,12,12,12));
		
		choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue ov, Number value, Number new_value) {
				// TODO Auto-generated method stub
				choice = selections[new_value.intValue()];
				update(choice);
			}
		});
	}
	
	String spacedWord, word; 
	int count = 5;
	void update(String choice) {
		
		String[] answer = {""};
		choiceBox.setDisable(true);
		
		String word = CreateLevel.word();
		
		if (choice.equals("Hard")) {
			spacedWord = CreateLevel.createHardLevel(word);
		}
		else if (choice.equals("Medium")) {
			spacedWord = CreateLevel.createModerateLevel(word);
		}else if (choice.equals("Simple")) {
			spacedWord = CreateLevel.createSimpleLevel(word);
		}else {
			playGame();
			return;
		}
		
		tip.setText("Select to play a new game.");
		newGame.setOnAction(e -> playGame());
		newGame.setTooltip(tip);
		tip1 = new Tooltip();
		tip1.setText("select to go yo the next word.");
		tip1.setStyle("-fx-font: normal bold 10 Cursive; " + "-fx-base: #AE3522; ");
		nextGame.setOnAction(e -> update(choice));
		nextGame.setTooltip(tip1);
		label1.setText("Please fill in the gaps:\n" + spacedWord);
		text.setEditable(true);
		text.setOnKeyPressed(e -> {
			KeyCode code = e.getCode();
			if (code == KeyCode.ENTER) {
				answer[0] = text.getText();
				checkAnswer(word, answer[0]);
			}
		});
		
		
	}
		
		
	void checkAnswer(String word, String answer) {
		label.setText("Attempts remaining\n" + count);

			if (word.equals(answer)) {
				Label newLabel = new Label("Cogratulation your answer is correct.");
				newLabel.setFont(new Font(25));
				borderPane.setCenter(newLabel);
			}
			else if (count == 0) {
				label1.setText("You have been HANGED!!\n" + 
						"Maximum number of attemps reached..\n" + "The correct answer is" +
						word);
			}
			else {
				count--;
				label1.setText("Incorrect answer. Please try Again\n" + spacedWord);
				label.setText("Attempts remaining\n" + count);
			}	
	}	
}

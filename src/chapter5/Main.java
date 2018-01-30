package chapter5;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    private int rock = 0, paper = 1, scissors = 2;
    private int result;

    private static int WinningScorePlayer = 0;
    private static int WinningScoreComputer = 0;
    private int playerOne = result;

    public void start(Stage stage) {

        do {

            List<String> choices = new ArrayList<>();
            choices.add("Rock");
            choices.add("Paper");
            choices.add("Scissors");

            ChoiceDialog<String> dialog = new ChoiceDialog<>("Rock", choices);
            dialog.setTitle("Choice Dialog");
            dialog.setHeaderText("Look, a Choice Dialog");
            dialog.setContentText("Choose your letter:");
            dialog.showAndWait();
            String x = dialog.getResult();

            //picks
            if (x == "Rock") {
                result = 0;
            } else if (x == "Paper") {
                result = 1;
            } else {
                result = 2;
            }


            //Draws
            if ((playerOne == rock) && (playerComputer() == rock)) {
                drawMessage();

            } else if ((playerOne == paper) && playerComputer() == paper) {
                drawMessage();

            } else if ((playerOne == scissors) && playerComputer() == scissors) {
                drawMessage();

                //rock Wining - loosing
            } else if ((playerOne == rock) && playerComputer() == scissors) {
                WinningScorePlayer++;
                rockWins();
            } else if ((playerOne == rock) && playerComputer() == paper) {
                WinningScoreComputer++;
                rockLosses();


                //paper wining - loosing
            } else if ((playerOne == paper) && playerComputer() == rock) {
                WinningScorePlayer++;
                paperWins();
            } else if ((playerOne == paper) && playerComputer() == scissors) {
                WinningScoreComputer++;
                paperLosses();

                //scissors wining - loosing
            } else if ((playerOne == scissors) && playerComputer() == paper) {
                WinningScorePlayer++;
                scissorsWins();
            } else if ((playerOne == scissors) && playerComputer() == rock) {
                WinningScoreComputer++;
                scissorsLosses();

            }


        } while (Score());

    }

    private static boolean Score() {

        if (WinningScoreComputer == 2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Computer Won!");
            alert.showAndWait();
            System.exit(0);
        } else if (WinningScorePlayer == 2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Player One Won!");
            alert.showAndWait();
            System.exit(0);
        }
        return true;
    }

    private static double playerComputer() {
        double pickNUmber = Math.random();

        if (pickNUmber < 0.34) {
            pickNUmber = 0;

        } else if (pickNUmber <= 0.67) {
            pickNUmber = 1;
        } else {
            pickNUmber = 2;
        }
        return pickNUmber;
    }

    private void drawMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText( "Draw!");
        alert.showAndWait();
    }
    private void rockWins(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Rock Wins!");
        alert.showAndWait();
    }
    private void rockLosses(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Rock Looses!");
        alert.showAndWait();
    }
    private void paperWins(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Paper Wins!");
        alert.showAndWait();
    }
    private void paperLosses(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Paper Losses!");
        alert.showAndWait();
    }
    private void scissorsWins(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Scissors win!");
        alert.showAndWait();
    }
    private void scissorsLosses(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Scissors losses!");
        alert.showAndWait();
    }
}



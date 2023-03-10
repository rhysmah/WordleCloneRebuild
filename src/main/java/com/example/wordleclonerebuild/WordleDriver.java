package com.example.wordleclonerebuild;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WordleDriver extends Application {

    private static final int ANIMATION_DELAY_TIME_IN_MS = 500;

    private static final String WINDOW_TITLE = "Wordle Clone";
    private static final int    WINDOW_WIDTH_IN_PIXELS = 500;
    private static final int    WINDOW_HEIGHT_IN_PIXELS = 650;

    private long animationDelay;

    /**
     * Runs the program.
     * @param stage to be shown.
     * @throws IOException if "gameboard.fxml" is not found.
     */
    @Override
    public void start(final Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(WordleDriver.class.getResource("gameboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WINDOW_WIDTH_IN_PIXELS, WINDOW_HEIGHT_IN_PIXELS);

        WordleController wordleController = fxmlLoader.getController();

        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().isLetterKey()) {
                wordleController.letterKeyPushed(keyEvent.getText().toUpperCase());
            }
            if (keyEvent.getCode() == KeyCode.ENTER && System.currentTimeMillis() - animationDelay > ANIMATION_DELAY_TIME_IN_MS) {
                wordleController.enterKeyPushed();
                animationDelay = System.currentTimeMillis();
            }
            if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
                wordleController.backspaceKeyPushed();
            }
        });

        wordleController.initializeGameScreenControls();

        stage.setTitle(WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Drives the program.
     *
     * @param args to be read.
     */
    public static void main(final String[] args) {
        launch();
    }
}

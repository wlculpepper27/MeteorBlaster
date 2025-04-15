/**
 * The Code can be used to play around with some of the game objects once you have
 * completed all the levels.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    public void start( Stage stage ) {

        GamePane pane = new GamePane();
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main( String [] args) {
        launch(args);
    }
}

/**
 * This code can be used along with MainApplication to play around with some of the
 * game objects.  Please ignore until you have finished all of the levels.
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;


public class GamePane extends Pane {
    Button button = new Button( "Photon Torpedo");

    public GamePane() {
        MeteorBlasterConfigData mbData = MeteorIO.readConfigFile("config/meteorBlasterConfig.txt");
        Craft craft = new Craft( mbData.getCraftData());
        craft.setX(40);
        craft.setY(40);
        this.getChildren().add(craft);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                craft.fireTorpedo();
               // craft.toggleCraft();
            }
        });
        this.getChildren().add(button);

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String key = event.getCharacter().toLowerCase(); // Get and normalize key

                if (key.equals("w")) {
                    craft.move();;
                } else if (key.equals("a")) {
                    craft.rotate(-5);
                } else if (key.equals("d")) {
                    craft.rotate(5);
                } else if (key.equals("s")) {
                    craft.fireTorpedo();
                }
            }
        });
        this.setFocusTraversable(true);
        this.requestFocus();
    }
}

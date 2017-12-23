import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXProperty extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        AnchorPane center = new AnchorPane();
        Text fxText = new Text("CMU or Brown");
        VBox stack = new VBox();
        Slider xPos = new Slider(0, 1920, 800);
        Slider yPos = new Slider(0,1080,500);
        Slider fill = new Slider(0,360,180);
        Slider fontSize = new Slider(0.5,10,1);
        Slider rotation = new Slider(0, 360, 0);
        stack.getChildren().addAll(xPos, yPos, fill, fontSize, rotation);
        center.getChildren().add(fxText);
        root.setCenter(center);
        root.setLeft(stack);
        Scene mainScene = new Scene(root, 1920,1080);
        primaryStage.setTitle("FXProperty");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        fxText.xProperty().bindBidirectional(xPos.valueProperty());
        fxText.yProperty().bindBidirectional(yPos.valueProperty());
        fill.valueProperty().addListener((o, ov, nv) -> {
            fxText.setFill(Color.hsb(nv.doubleValue(),1,1));
        });
        fxText.rotateProperty().bindBidirectional(rotation.valueProperty());
        fxText.scaleXProperty().bindBidirectional(fontSize.valueProperty());
        fxText.scaleYProperty().bindBidirectional((fontSize.valueProperty()));
    }
}

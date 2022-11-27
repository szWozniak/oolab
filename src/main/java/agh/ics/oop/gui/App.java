package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw());
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.print(map.toString());

        int extraX = -map.getBoundary().getLeftBottom().x();
        int extraY = -map.getBoundary().getLeftBottom().y();

        int diffX = map.getBoundary().getTopRight().x() + extraX + 1;
        int diffY = map.getBoundary().getTopRight().y() + extraY + 1;

        GridPane grid = new GridPane();

        System.out.println("CHUJ x " + extraX + " y " + extraY);
        System.out.println("CHUJ2 x " + diffX + " y " + diffY);


        for(int x = 0; x < diffX; x++) {
            Label titleLabel = new Label(Integer.toString(x-extraX));
            titleLabel.setFont(new Font("Arial", 30));
            GridPane.setHalignment(titleLabel, HPos.CENTER);
            grid.add(titleLabel, x+1, 0, 1, 1);
            grid.getColumnConstraints().add(new ColumnConstraints(35));
        }

        for(int y = 0; y < diffY; y++) {
            Label titleLabel = new Label(Integer.toString(y-extraY));
            titleLabel.setFont(new Font("Arial", 30));
            GridPane.setHalignment(titleLabel, HPos.CENTER);
            grid.add(titleLabel, 0, (diffY-y), 1, 1);
            grid.getRowConstraints().add(new RowConstraints(35));
        }

        grid.getColumnConstraints().add(new ColumnConstraints(35));
        grid.getRowConstraints().add(new RowConstraints(35));

        for(int y = 0; y < diffY; y++) {
            for(int x = 0; x < diffX; x++) {
                Label label = new Label("");
                label.setFont(new Font("Arial", 30));

                Object object = map.objectAt(new Vector2d(x-extraX, y-extraY));
                if (object != null) {
                    label.setText(object.toString());
                }

                GridPane.setHalignment(label, HPos.CENTER);
                grid.add(label, 1+x, (diffY-y), 1, 1);
            };
        }



        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 35*diffX+35, 35*diffY+35);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

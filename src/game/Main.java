package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private static Stage stage;
    private static Timeline timeline;
    private static Simulation simulation;
    static String[] args = new String[3];
    @Override
    public void start(Stage primaryStage) throws Exception{
        int ants = Integer.parseInt(args[0]);
        if(ants == 0) ants = 1;
        simulation = new Simulation(ants);
        stage = primaryStage;
        stage.setTitle("Ant game");
        stage.setFullScreen(true);
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            simulation.runStep();
            GridPane grid = drawBoard();
            stage.setScene(new Scene(grid, 1200,  700));
        }));
        timeline.setCycleCount(-1);
        timeline.play();
        stage.show();
    }

    private GridPane drawBoard() {
        GridPane root = new GridPane();
        for (int x = 0; x < Simulation.gridSize; x++){
            for (int y = 0; y < Simulation.gridSize; y++){
                if (simulation.grid[x][y].state == Square.SquareState.WHITE ) {
                    simulation.grid[x][y].setFill(Color.WHITE);
                    simulation.grid[x][y].setStroke(Color.BLACK);
                    root.add(simulation.grid[x][y], x, y);
                } else if (simulation.grid[x][y].state == Square.SquareState.BLACK) {
                    simulation.grid[x][y].setFill(Color.BLACK);
                    simulation.grid[x][y].setStroke(Color.BLACK);
                    root.add(simulation.grid[x][y], x, y);
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Main.args = args;
        launch(args);
    }
}

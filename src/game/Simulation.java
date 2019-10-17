package sample;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    static int gridSize = 20;

    Square[][] grid = new Square[gridSize][gridSize];
    Ant ant;

    List<Ant> ants = new ArrayList<Ant>();

    public Simulation(int howManyAnts) {
        for (int i = 0; i < howManyAnts; i++) ants.add(new Ant());
        for (int x = 0; x < gridSize; x++){
        for (int y = 0; y < gridSize; y++){
            grid[x][y] = new Square(50, 50, Square.SquareState.WHITE);
        }

    }
}

    public void runStep(){
        for (Ant ant: ants) {
            if(grid[ant.x][ant.y].state == Square.SquareState.WHITE){
                ant.Rotate(90);
                grid[ant.x][ant.y].state = Square.SquareState.BLACK;
            }else{
                ant.Rotate(-90);
                grid[ant.x][ant.y].state = Square.SquareState.WHITE;
            }
            ant.Move(1);
        }
    }
}

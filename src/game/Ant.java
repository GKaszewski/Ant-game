package sample;

import java.util.Random;

public class Ant {
    int x, y;
    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    };

    public Direction direction;

    public Ant(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Ant() {
        x = new Random().nextInt(Simulation.gridSize) + 1;
        y = new Random().nextInt(Simulation.gridSize) + 1;
        direction = Direction.UP;
    }

    public void Rotate(int angle){
        if (angle == 90){
            switch (direction){
                case UP:
                    direction = Direction.RIGHT;
                    break;
                case DOWN:
                    direction = Direction.LEFT;
                    break;
                case LEFT:
                    direction = Direction.UP;
                    break;
                case RIGHT:
                    direction = Direction.DOWN;
                    break;
            }
        }
        else if (angle  == -90){
            switch (direction){
                case UP:
                    direction = Direction.LEFT;
                    break;
                case DOWN:
                    direction = Direction.RIGHT;
                    break;
                case LEFT:
                    direction = Direction.DOWN;
                    break;
                case RIGHT:
                    direction = Direction.UP;
                    break;
            }
        }
    }

    public void Move(int units){
        int moveValue = (units + Simulation.gridSize) % Simulation.gridSize;
        switch (direction){
            case UP:
                y = (y - units + Simulation.gridSize) % Simulation.gridSize;
                break;
            case DOWN:
                y = (y + units + Simulation.gridSize) % Simulation.gridSize;
                break;
            case LEFT:
                x = (x - units + Simulation.gridSize) % Simulation.gridSize;
                break;
            case RIGHT:
                x = (x + units + Simulation.gridSize) % Simulation.gridSize;
                break;
        }
    }
}

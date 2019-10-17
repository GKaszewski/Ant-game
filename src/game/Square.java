package sample;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle{
    enum SquareState {
        BLACK,
        WHITE
    };
    public SquareState state;
    public int x,y;

    public Square(double width, double height, SquareState state) {
        super(width, height);
        this.state = state;
        x = 0;
        y = 0;
    }

    public Square() {
        super(5, 5);
        state = SquareState.WHITE;
        x = 0;
        y = 0;
    }
}

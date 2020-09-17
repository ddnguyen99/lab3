package ca.ubc.cpsc210.paddleball.model;

import java.awt.Color;
import java.awt.Rectangle;

/*
 * Represents a ball.
 */
public class BALL
{
    public static final int SIZE = 20;  // must be even integer
    public static final Color COLOR = new Color(10, 50, 188);

        private double x;
        private double y;
        private double Delta_x;
        private double delta_Y;

    // Constructs an ball
    // EFFECTS: ball is positioned at coordinates (x, y) with velocity (2.0, 2.0)
    public BALL(int x, int y) {
        this.x = x;
        this.y = y;
        Delta_x = 2.0;
        delta_Y = 2.0;
    }

public int getX() {
    return (int) x;
}

        public int getY() {
            return (int) y;
        }

        public double getDx() {
            return Delta_x;
        }

public double getDy() {
    return delta_Y;
}

        // Bounce ball off paddle
        // MODIFIES: this
        // EFFECTS: vertical component of ball's velocity is reversed
    public void BounceOffPaddle() {
        delta_Y *= -1;
    }

    // Updates ball on clock tick
    // MODIFIES: this
    // EFFECTS:  ball is moved (dx, dy) units
public void Move() {
    x = x + Delta_x; y = y + delta_Y;

    deal_with_it();
}

    // Determines if this ball has collided with the paddle
    // EFFECTS:  returns true if this ball has collided with paddle p,
    //           false otherwise
    public boolean doSomething(Puddle p) {
        Rectangle ballBoundingRectangle = new Rectangle(getX() - SIZE / 2, getY() - SIZE / 2, SIZE, SIZE);
            Rectangle paddleBoundingRectangle = new Rectangle(p.getX() - Puddle.DIMENSION1 / 2,Puddle.Y_POS - Puddle.DIMENSION2 / 2, Puddle.DIMENSION1, Puddle.DIMENSION2);
    return ballBoundingRectangle.intersects(paddleBoundingRectangle);
    }

        // Constrains ball so that it bounces off top and vertical walls
        // MODIFIES: this
        // EFFECTS: ball is constrained to bounce off top and vertical walls
        private void deal_with_it() {
            if (getX() - SIZE / 2 < 0) {
                x = SIZE / 2;
                Delta_x *= -1;
            }
                else if (getX() + SIZE / 2 > PBG.DIMENSION1) {
                    x = PBG.DIMENSION1 - SIZE / 2;
                    Delta_x *= -1;
                }
                    else if (getY() - SIZE / 2 < 0) {
                        y = SIZE / 2;
                        delta_Y *= -1;
                    }
        }
}

package ca.ubc.cpsc210.paddleball.model;

import java.awt.Color;
import java.awt.Rectangle;

/*
 * Represents a ball.
 */

public class Ball {
    public static final int SIZE = 20;  // must be even integer

    public static final Color Color = new Color(10, 50, 188);

    private double getCordX;
    private double getCordY;
    private double getVelocityX;
    private double getVelocityY;

    // Constructs an ball
    // EFFECTS: ball is positioned at coordinates (x, y) with velocity (2.0, 2.0)

    public Ball(int x, int y) {
        this.getCordX = x;
        this.getCordY = y;
        getVelocityX = 2.0;
        getVelocityY = 2.0;
    }

    public int getX() {
        return (int) getCordX;
    }

    public int getY() {
        return (int) getCordY;
    }

    public double getDx() {
        return (double) getVelocityX;
    }

    public double getDy() {
        return (double) getVelocityY;
    }

    // Bounce ball off paddle
    // MODIFIES: this
    // EFFECTS: vertical component of ball's velocity is reversed

    public void bounceOffPaddle() {
        getVelocityY *= -1;
    }

    // Updates ball on clock tick
    // MODIFIES: this
    // EFFECTS:  ball is moved (dx, dy) units

    public void move() {
        getCordX = getCordX + getVelocityX;
        getCordY = getCordY + getVelocityY;

        dealWithIt();
    }

    // Determines if this ball has collided with the paddle
    // EFFECTS:  returns true if this ball has collided with paddle p,
    //           false otherwise
    public boolean doSomething(Puddle p) {
        Rectangle ballBoundingRectangle = new Rectangle(getX() - SIZE / 2, getY() - SIZE / 2, SIZE, SIZE);
        Rectangle paddleBoundingRectangle = new Rectangle(
                p.getX() - Puddle.DIMENSION1 / 2,
                Puddle.Y_POS - Puddle.DIMENSION2 / 2,
                Puddle.DIMENSION1,
                Puddle.DIMENSION2);
        return ballBoundingRectangle.intersects(paddleBoundingRectangle);
    }

    // Constrains ball so that it bounces off top and vertical walls
    // MODIFIES: this
    // EFFECTS: ball is constrained to bounce off top and vertical walls

    private void dealWithIt() {
        if (getX() - SIZE / 2 < 0) {
            getCordX = (double) SIZE / 2;
            getVelocityX *= -1;
        } else if (getX() + SIZE / 2 > PBG.DIMENSION1) {
            getCordX = PBG.DIMENSION1 - (double)SIZE / 2;
            getVelocityX *= -1;
        } else if (getY() - SIZE / 2 < 0) {
            getCordY = (double) SIZE / 2;
            getVelocityY *= -1;
        }
    }
}

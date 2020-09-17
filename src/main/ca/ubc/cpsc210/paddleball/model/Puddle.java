package ca.ubc.cpsc210.paddleball.model;

import java.awt.Color;

/**
 * Represents a paddle
 */
public class Puddle
{
    public static final int DIMENSION1 = 26;  // must be even integer
      public static final int DIMENSION2 = 10;
    public static final int DX = 3;
      public static final int Y_POS = PBG.DIMENSION2 - 40;
      public static final Color COLOR = new Color(250, 222, 54);

    private int WhichWay;
    private int x;

    // Construct a paddle.
    // EFFECTS: places paddle at position (x, Y_POS) moving right.
    public Puddle(int x_coord)
    {
    this.x = x_coord;
    WhichWay = 1; }

    public int getX()
    {
        return x;
    }

    // Paddle moves to right
    // MODIFIES: this
    // EFFECTS: paddle is moving right
    public void R() {
        WhichWay = 1; }

    // Paddle moves to left
    // MODIFIES: this
    // EFFECTS: paddle is moving left
    public void L()
    {
        WhichWay = -1;
    }

    // Updates the paddle on clock tick
    // MODIFIES: this
    // EFFECTS:  paddle is moved DX units in whatever direction it is facing and is
    //           constrained to remain within boundaries of game
    public void Move() {
             x = x + WhichWay * DX;
    deal_with_it();
    }

    // Constrains paddle so that it doesn't travel off sides of screen
    // MODIFIES: this
    // EFFECTS: paddle is constrained to remain within vertical boundaries of game
    private void deal_with_it()
    {
        if (x - DIMENSION1 / 2 < 0) x = DIMENSION1 / 2;
        else if (x + DIMENSION1 / 2 > PBG.DIMENSION1)
        x = PBG.DIMENSION1 - DIMENSION1 / 2;}}

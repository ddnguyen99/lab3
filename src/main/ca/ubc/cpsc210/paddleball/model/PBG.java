package ca.ubc.cpsc210.paddleball.model;

import java.awt.event.KeyEvent;
import java.util.Random;

/*
 * Represents a paddle ball game.
 */
public class PBG
{
    public static final int DIMENSION1 = 800;
    public static final int DIMENSION2 = 600;
    private static final Random RND = new Random();

        private BALL bObject;
        private Puddle pObject;
        private boolean stop;

    // Constructs a Paddle Ball Game
    // EFFECTS:  creates ball at random location at top of screen
    public PBG() {
        setUp();
    }

public Puddle getPaddle() {
    return pObject;
}

public BALL getBall() {
    return bObject;
}

    // Is game over?
    // EFFECTS: returns true if game is over, false otherwise
    public boolean isOver() {
        return stop;
    }

    // Updates the game on clock tick
    // MODIFIES: this
    // EFFECTS:  updates ball, paddle and game over status
    public void update() {
        bObject.Move();
        pObject.Move();

        checkHitSomething();
        checkstyle();
    }

    // Responds to key press codes
    // MODIFIES: this
    // EFFECTS:  turns paddle and resets game (if game over) in response to
    //           given key pressed code
    public void keyPressed(int kCode) {
        if (kCode == KeyEvent.VK_R && stop)
            setUp();
        else if (kCode == KeyEvent.VK_X)
            System.exit(0);
        else
            paddleControl(kCode);
    }

        // Sets / resets the game
        // MODIFIES: this
        // EFFECTS:  clears list of missiles and invaders, initializes tank
        private void setUp() {
            bObject = new BALL(RND.nextInt(PBG.DIMENSION1), BALL.SIZE / 2);
            pObject = new Puddle(DIMENSION1 / 2);
            stop = false;
        }

        // Controls the paddle
        // MODIFIES: this
        // EFFECTS: changes direction of paddle in response to key code
        private void paddleControl(int kCode) {
            if (kCode == KeyEvent.VK_KP_LEFT || kCode == KeyEvent.VK_LEFT)
                pObject.L();
            else if (kCode == KeyEvent.VK_KP_RIGHT || kCode == KeyEvent.VK_RIGHT)
                pObject.R();
        }

        // Checks for collision between ball and paddle
        // MODIFIES: this
        // EFFECTS:  bounces ball if it collides with paddle
        private void checkHitSomething() {
            if (bObject.doSomething(pObject))
                bObject.BounceOffPaddle();
        }

        // Is game over? (Has ball hit ground?)
        // MODIFIES: this
        // EFFECTS:  if ball has hit ground, game is marked as over
        private void checkstyle() {
            if (bObject.getY() > DIMENSION2)
            stop = true;
        }
}

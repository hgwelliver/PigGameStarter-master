package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {
    PigGameState pGS;
    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        int id = 0;
        if (info instanceof PigGameState) {
            id = 1;
        }
        if (id != 1) {
            return;
        } else {
            Random rand = new Random();
            int move = rand.nextInt((2));

            if (move == 0) {
                PigRollAction p = new PigRollAction(this);
                game.sendAction(p);
                PigHoldAction h = new PigHoldAction(this);
                game.sendAction(h);
            }
            if (move == 1) {
                PigHoldAction h = new PigHoldAction(this);
                game.sendAction(h);

            }
        }//receiveInfo

    }}

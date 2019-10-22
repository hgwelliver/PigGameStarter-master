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
        int id = -1;
        if (info instanceof PigGameState) {
            id = ((PigGameState) info).getPlayerid();
        }
        if (id != playerNum) {
            return;
        } else {
            Random rand = new Random();
            rand.nextInt((2));

            if (rand.equals(0)) {
                PigRollAction p = new PigRollAction(this);
                game.sendAction(p);
            }
            if (rand.equals(1)) {
                PigHoldAction h = new PigHoldAction(this);
                game.sendAction(h);

            }
        }//receiveInfo

    }}

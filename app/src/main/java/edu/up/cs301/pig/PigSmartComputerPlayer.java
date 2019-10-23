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
public class PigSmartComputerPlayer extends GameComputerPlayer {
    PigGameState pGS;
    /**
     * ctor does nothing extra
     */
    public PigSmartComputerPlayer(String name) {
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
            id = ((PigGameState)info).getPlayerid();
        }
        if (id == 1) {

            int score1 = ((PigGameState) info).getPlayer1Score();
            int score0 = ((PigGameState) info).getPlayer0Score();
            int winning = score1 - score0;
            PigRollAction p = new PigRollAction(this);
            game.sendAction(p);
            if(winning > 0) {

                game.sendAction(p);
                while(((PigGameState) info).getCurrentTotal() <4){

                    game.sendAction(p);

                }
                PigHoldAction h = new PigHoldAction(this);
                game.sendAction(h);


            }
            if(winning<=0){
                game.sendAction(p);
                game.sendAction(p);

                }
                PigHoldAction h = new PigHoldAction(this);
                game.sendAction(h);

            }

        }
        }//receiveInfo



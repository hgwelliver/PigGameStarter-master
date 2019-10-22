package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState pGS;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
         pGS = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(playerIdx == pGS.getPlayerid()){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method

        int ID = pGS.getPlayerid();
        if(action instanceof PigHoldAction){
            if(ID == 0) {
                pGS.setPlayer0Score(pGS.player0Score += pGS.getCurrentTotal());
            }
            if(ID == 1) {
                pGS.setPlayer1Score(pGS.player1Score += pGS.getCurrentTotal());
            }

            pGS.setCurrentTotal(0);

            if( ID == 0){pGS.setPlayerid(1);}
            else if( ID == 1){pGS.setPlayerid(0);}

            return true;
        }
        if(action instanceof PigRollAction){
            Random rand = new Random();
            int val = rand.nextInt(5+1)+1;
            pGS.setCurrentDiceVal(val);
            if(pGS.getCurrentDiceVal() != 1){
                pGS.setCurrentTotal(pGS.currentTotal + pGS.currentDiceVal);
            }
            else{
                pGS.setCurrentTotal(0);
                /*if(ID == 0) {
                    pGS.setPlayer0Score(pGS.player0Score += pGS.getCurrentTotal());
                }
                if(ID == 1) {
                    pGS.setPlayer1Score(pGS.player1Score += pGS.getCurrentTotal());
                }*/


                if( ID == 0){pGS.setPlayerid(1);}
                else if( ID == 1){pGS.setPlayerid(0);}


            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState pGS2 = new PigGameState(pGS);
        p.sendInfo(pGS2);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(pGS.player0Score >= 50){
            return "Player 0 won with a score of " + pGS.getPlayer0Score();
        }
        if(pGS.player1Score >= 50){
            return "Player 1 won with a score of " + pGS.getPlayer1Score();
        }
        return null;
    }

}// class PigLocalGame

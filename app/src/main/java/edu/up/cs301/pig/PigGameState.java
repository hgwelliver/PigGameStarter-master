package edu.up.cs301.pig;

import edu.up.cs301.game.Game;
import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    protected int playerid = 0;
    protected int player0Score = 0;
    protected int player1Score = 0;
    protected int currentTotal = 0;
    protected int currentDiceVal = 1;

    public PigGameState(){

    }

    public PigGameState(PigGameState gS){
        this.playerid = gS.playerid;
        this.player0Score = gS.player0Score;
        this.player1Score = gS.player1Score;
        this.currentTotal = gS.currentTotal;
        this.currentDiceVal = gS.currentDiceVal;
    }

    //getters
    public int getPlayerid(){
        return playerid;
    }

    public int getPlayer0Score(){
        return player0Score;
    }

    public int getPlayer1Score(){
        return player1Score;
    }

    public int getCurrentTotal() {
        return currentTotal;
    }

    public int getCurrentDiceVal() {
        return currentDiceVal;
    }

    //setters
    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public void setCurrentTotal(int currentTotal) {
        this.currentTotal = currentTotal;
    }

    public void setCurrentDiceVal(int currentDiceVal) {
        this.currentDiceVal = currentDiceVal;
    }
}

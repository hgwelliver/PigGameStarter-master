package edu.up.cs301.pig;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.GameMainActivity;
import edu.up.cs301.game.R;
import edu.up.cs301.game.infoMsg.GameInfo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.Random;

/**
 * A GUI for a human to play Pig. This default version displays the GUI but is incomplete
 *
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigHumanPlayer extends GameHumanPlayer implements OnClickListener {

	/* instance variables */

    // These variables will reference widgets that will be modified during play
    private TextView    playerScoreTextView = null;
    private TextView    oppScoreTextView    = null;
    private TextView    turnTotalTextView   = null;
    private TextView    messageTextView     = null;
    private ImageButton dieImageButton      = null;
    private Button      holdButton          = null;
    private int diceValue=1;
    private int isClicked;
    // the android activity that we are running
    private GameMainActivity myActivity;

    /**
     * constructor does nothing extra
     */
    public PigHumanPlayer(String name) {
        super(name);
    }

    /**
     * Returns the GUI's top view object
     *
     * @return
     * 		the top object in the GUI's view heirarchy
     */
    public View getTopView() {
        return myActivity.findViewById(R.id.top_gui_layout);
    }

    /**
     * callback method when we get a message (e.g., from the game)
     *
     * @param info
     * 		the message
     */
    @Override
    public void receiveInfo(GameInfo info) {
        //TODO You will implement this method to receive state objects from the game
        if(info instanceof PigGameState){
            //display proper score
            String foo = "" + ((PigGameState) info).getPlayer0Score();
            playerScoreTextView.setText(foo);
            playerScoreTextView.invalidate();
            oppScoreTextView.setText(   "" + ((PigGameState) info).getPlayer1Score());
            oppScoreTextView.invalidate();
            int total =((PigGameState) info).getCurrentTotal();
            turnTotalTextView.setText(" " + total);
            turnTotalTextView.invalidate();
            //die images
            diceValue = ((PigGameState)info).getCurrentDiceVal();
            //if(isClicked==1) {
                if (diceValue == 1) {
                    dieImageButton.setImageResource(R.drawable.face1);
                } else if (diceValue == 2) {
                    dieImageButton.setImageResource(R.drawable.face2);
                } else if (diceValue == 3) {
                    dieImageButton.setImageResource(R.drawable.face3);
                } else if (diceValue == 4) {
                    dieImageButton.setImageResource(R.drawable.face4);
                } else if (diceValue == 5) {
                    dieImageButton.setImageResource(R.drawable.face5);
                } else if (diceValue == 6) {
                    dieImageButton.setImageResource(R.drawable.face6);
                }
                dieImageButton.invalidate();
           // }
            return;
        }
        else{
            this.flash(Color.BLUE, 3);
            return;

        }




    }//receiveInfo

    /**
     * this method gets called when the user clicks the die or hold button. It
     * creates a new PigRollAction or PigHoldAction and sends it to the game.
     *
     * @param button
     * 		the button that was clicked
     */
    public void onClick(View button) {
        //TODO  You will implement this method to send appropriate action objects to the game

        //if hold
        if(button.equals(holdButton)){
            PigHoldAction h = new PigHoldAction(this);
            game.sendAction(h);
        }
        if(button.equals(dieImageButton)){

            //isClicked = 1;
            PigRollAction p = new PigRollAction(this);
            game.sendAction(p);
            dieImageButton.invalidate();

        }


    }// onClick

    /**
     * callback method--our game has been chosen/rechosen to be the GUI,
     * called from the GUI thread
     *
     * @param activity
     * 		the activity under which we are running
     */
    public void setAsGui(GameMainActivity activity) {

        // remember the activity
        myActivity = activity;

        // Load the layout resource for our GUI
        activity.setContentView(R.layout.pig_layout);

        //Initialize the widget reference member variables
        this.playerScoreTextView = (TextView)activity.findViewById(R.id.yourScoreValue);
        this.oppScoreTextView    = (TextView)activity.findViewById(R.id.oppScoreValue);
        this.turnTotalTextView   = (TextView)activity.findViewById(R.id.turnTotalValue);
        this.messageTextView     = (TextView)activity.findViewById(R.id.messageTextView);
        this.dieImageButton      = (ImageButton)activity.findViewById(R.id.dieButton);
        this.holdButton          = (Button)activity.findViewById(R.id.holdButton);

        //Listen for button presses
        dieImageButton.setOnClickListener(this);
        holdButton.setOnClickListener(this);

    }//setAsGui

}// class PigHumanPlayer

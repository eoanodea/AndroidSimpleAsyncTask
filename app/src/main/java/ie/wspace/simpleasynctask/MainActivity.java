package ie.wspace.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * The SimpleAsyncTask app contains a button that launches a
 * AsyncTask, which sleeps in the asynchronous thread for a random
 * amount of time
 */
public class MainActivity extends AppCompatActivity {

    //Key for saving the state of the Textview
    private static final String TEXT_STATE = "currentText";

    //The TextView where we show the result
    private TextView mTextView = null;

    /**
     * Initializes the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the TextView
        mTextView = findViewById(R.id.textView);

        //Restore the TextView if there is a savedInstanceState
        if(savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    /**
     * Handles the onClick for the "Start Task" Button.
     * Launches the Async task which performs work off of the
     * UI Thread
     *
     * @param view
     */
    public void startTask(View view) {
        //Put a message on the text view
        mTextView.setText(R.string.sleeping);

        //Start the Async task
        new SimpleAsyncTask(mTextView).execute();
    }


    /**
     * Saves the contents of the TextView to restore on configuration change
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}

package msd.com.SmartStreet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.praj.smartstreet_praj.R;

/**
 * Created by praj on 9/19/17.
 */

public class ActivitySplashScreen extends AppCompatActivity {

    /**
     * Executes on creation of a page.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_splash_screen);

        /**
         * set the spalsh screen for 2 seconds
         */
        Thread startTimer = new Thread() {
            public void run(){
                try {
                    sleep(1000);
                    Intent intent = new Intent(ActivitySplashScreen.this,HomePageActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        startTimer.start();
    }

}

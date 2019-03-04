package msd.com.SmartStreet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.praj.smartstreet_praj.R;

/**
 * Created by praj on 9/19/17.
 */

public class HomePageActivity extends AppCompatActivity {

    private String mUserId;

    Button maboutButton = null;
    Button mnearbyButton = null;
    Button cameraButton = null;
    Button shareButton = null;
    Button commnetButton = null;
    Button interacttButton = null;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Referring to Home Page Activity
        setContentView(R.layout.context_home_page);


        final Intent intent = getIntent();
        final String userName = intent.getStringExtra("userName");


        maboutButton = (Button) findViewById(R.id.aboutButton);
        //Setting Listner for About button
        maboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), BarcodeActivity.class);
                startActivity(i);
            }
        });

        mnearbyButton = (Button) findViewById(R.id.nearbyButton);
        //Setting Listner for Nearby button
        mnearbyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.nearbyButton) {
                    Intent i = new Intent(v.getContext(), MapsActivity.class);
                    startActivity(i);
                }
            }
        });

        interacttButton = (Button) findViewById(R.id.interact);
        interacttButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mUserId == null) {
                    Intent i = new Intent(v.getContext(), LoginActivity.class);
                    i.putExtra("val","fromInteract");
                    startActivity(i);
                } else {
                    Intent i = new Intent(v.getContext(), InteractActivity.class);
                    i.putExtra("userName",userName);
                    startActivity(i);
                }
            }
        });

        cameraButton = (Button) findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.cameraButton){
                    Intent i = new Intent(v.getContext(), CameraActivity.class);
                    startActivity(i);
                }
            }
        });

        shareButton = (Button) findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mUserId == null) {
                    Intent i = new Intent(v.getContext(), LoginActivity.class);
                    i.putExtra("val","fromShare");
                    startActivity(i);
                }else{

                    Intent i = new Intent(v.getContext(), ShareActivity.class);
                    i.putExtra("userName",userName);
                    startActivity(i);
                }

            }
        });

        commnetButton = (Button) findViewById(R.id.commentButton);
        commnetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mUserId == null) {
                    Intent i = new Intent(v.getContext(), LoginActivity.class);
                    i.putExtra("val","fromComment");
                    startActivity(i);
                } else {
                    Intent i = new Intent(v.getContext(), CommentsActivity.class);
                    i.putExtra("userName",userName);
                    startActivity(i);
                }

            }
        });

    }

    }

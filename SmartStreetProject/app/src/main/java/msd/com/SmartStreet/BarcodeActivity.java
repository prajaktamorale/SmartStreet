package msd.com.SmartStreet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.praj.smartstreet_praj.IntentIntegrator;
import com.example.praj.smartstreet_praj.IntentResult;
import com.example.praj.smartstreet_praj.R;

/**
 * Created by praj on 9/19/17.
 */

public class BarcodeActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton scanBtn;
    private Button back;
    // private  ImageButton homeButton;
    private TextView contentTxt;


    /**
     * Called on creation of the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //referring to the activity_barcode.xml file
        setContentView(R.layout.activity_barcode);
        // Taking the values for Scan button, Home button and content text from xml activity
        scanBtn = (ImageButton)findViewById(R.id.scanbutton);
        //contentTxt = (TextView)findViewById(R.id.content);
        // homeButton = (ImageButton) findViewById(R.id.homeButton);

        scanBtn.setOnClickListener((View.OnClickListener) this);
        //  homeButton.setOnClickListener(this);


    }

    /**
     * Onclick method for buttons
     * @param v
     */
    @Override
    public void onClick(View v) {
        //respond to clicks
        if(v.getId()==R.id.scanbutton){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
        //if(v.getId()==R.id.back){
            //Intent i = new Intent(v.getContext(), HomePageActivity.class);
          //  startActivity(i);
        //}
    }


    /**
     * Activity for the obtained result
     * @param requestCode
     * @param resultCode
     * @param intent
     */
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            //we have a scanning result
            String scanContent = scanningResult.getContents();
            contentTxt.setText("Found URL: " + scanContent);

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

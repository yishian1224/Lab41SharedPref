package com.example.taruc.lab41sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private SharedPreferences sharedPreferences;
    private TextView textViewName;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewName = findViewById(R.id.textViewName);
        imageView = findViewById(R.id.imageView);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //TODO read shared preference file
        sharedPreferences = getSharedPreferences(getString(R.string.pref_file), MODE_PRIVATE);

        String name;
        int gender; //-1=default 1=male 0=female
        name = sharedPreferences.getString("name","");
        gender = sharedPreferences.getInt("gender",-1);

        textViewName.setText(name);
        if(gender == 1){
           imageView.setImageResource(R.drawable.male);
        }
        else if(gender == 0){
            imageView.setImageResource(R.drawable.female);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,activity_settings.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

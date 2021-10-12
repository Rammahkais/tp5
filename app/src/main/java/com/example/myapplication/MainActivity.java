package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.login);
        e2 = (EditText)findViewById(R.id.passwd);
        b1 = (Button)findViewById(R.id.bvalider);
        b2 = (Button)findViewById(R.id.beffacer);
        b1.setOnClickListener(this);
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String l = sharedPreferences.getString("login", "");
        String pwd = sharedPreferences.getString("passwd", "");
        if (l.length()>0 )
            Toast.makeText(getApplicationContext(),"les valeurs sont initilisé ", Toast.LENGTH_LONG).show();
        else
            {
                Toast.makeText(getApplicationContext(),"la premiere fois que lapplication s'installe ", Toast.LENGTH_LONG).show();

                // Creating an Editor object to edit(write to the file)
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
// Storing the key and its value as the data fetched from edittext
                myEdit.putString("login","sem31");
                myEdit.putString("passwd","0000");
                //myEdit.putInt("age", Integer.parseInt(age.getText().toString()));

// Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
                myEdit.commit();
        }


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.beffacer){
            e1.setText("");
            e2.setText("");
        }
        if (view.getId() == R.id.bvalider){
            // Retrieving the value using its keys the file name
// must be same in both saving and retrieving the data
            SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

// The value will be default as empty string because for
// the very first time when the app is opened, there is nothing to show
            String l = sh.getString("login", "");
            String pwd = sh.getString("passwd", "");

// We can then use the data
            if ((e1.getText().toString().equals(l)) && (e2.getText().toString().equals(pwd))){
            Toast.makeText(getApplicationContext(),"Login et mp sont correct", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(getApplicationContext(),"Login et mp sont incorrect", Toast.LENGTH_LONG).show();


        }

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,100,0,"Change password");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

// Storing the key and its value as the data fetched from edittext
        myEdit.putString("login","sem31");
        myEdit.putString("passwd","3131");
        //myEdit.putInt("age", Integer.parseInt(age.getText().toString()));

// Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
        myEdit.commit();


        return super.onOptionsItemSelected(item);
    }
}
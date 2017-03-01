package com.oteltechnologies.maptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText etusername,etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=(Button) findViewById(R.id.buttonLogin);
        etusername=(EditText)findViewById(R.id.etusername);
        etpassword=(EditText)findViewById(R.id.etpassword);



        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(etusername.getText().toString().equals("") || etpassword.getText().toString().equals("")){
                            Toast.makeText(getApplicationContext(), "Please fill the specified fields", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Intent intent = new Intent(Login.this, SplashScreen.class);
                            intent.putExtra("name", etusername.getText().toString());
                            startActivity(intent);
                        }
                    }
                }
        );
    }
}

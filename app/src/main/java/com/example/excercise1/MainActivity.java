package com.example.excercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnSignup;
    EditText edtEmail, edtPass;
    String email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        edtEmail = findViewById(R.id.regEmail);
        edtPass = findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValidation();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(i);
            }
        });
    }

    /*public boolean validatePass(){
        String passInput = edtPass.getEditableText().toString().trim();
        if (passInput.isEmpty()) {
            edtPass.setError("Field can not be empty");
            return false;
        }
        else {
            edtPass.setError(null);
            return true;
        }
    }*/

    public void setValidation(){
        email = edtEmail.getText().toString();
        pass = edtPass.getText().toString();

        String mail = "dna@mail.com";
        String pw = "123456";

        if (email.isEmpty() || pass.isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(), "Email and/or password cannot be empty!", Toast.LENGTH_LONG);
            toast.show();
        }
        else if (email.equals(mail) && pass.equals(pw)) {
            Toast toast = Toast.makeText(getApplicationContext(), "Login Success.", Toast.LENGTH_LONG);
            toast.show();

            Bundle bundle = new Bundle();

            bundle.putString("a", email.trim());
            bundle.putString("b", pass.trim());

            Intent i = new Intent(getApplicationContext(), HomePage.class);
            i.putExtras(bundle);

            startActivity(i);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Wrong Email and/or Password.", Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
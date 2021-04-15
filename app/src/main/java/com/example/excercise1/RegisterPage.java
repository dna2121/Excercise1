package com.example.excercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class RegisterPage extends AppCompatActivity {
    EditText regName, regEmail, regUname, regPass, regRepass, regPhone;
    Button tbSgu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        regEmail = findViewById(R.id.regEmail);
        regName = findViewById(R.id.edtName);
        regUname = findViewById(R.id.regUname);
        regPhone = findViewById(R.id.regPhone);
        regPass = findViewById(R.id.regPass);
        regRepass = findViewById(R.id.regRepass);
        tbSgu = findViewById(R.id.regBtnSgu);

        tbSgu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(regEmail.getText().toString().isEmpty() ||
                        regName.getText().toString().isEmpty() ||
                        regUname.getText().toString().isEmpty() ||
                        regPhone.getText().toString().isEmpty() ||
                        regPass.getText().toString().isEmpty() ||
                        regRepass.getText().toString().isEmpty())
                {
                    Snackbar.make(v, "All data must be filled in.", Snackbar.LENGTH_LONG).show();
                }
                else {
                    if (regPass.getText().toString().equals(regRepass.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Register Success.", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else {
                        Snackbar.make(v,"Password incorect.", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText etEmail, etPass;
    Button btnLogin;
    TextView tvReg;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);

        btnLogin = findViewById(R.id.btnLogin);
        tvReg = findViewById(R.id.tvReg);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }

            private void logIn() {
                String email, pass;
                email = etEmail.getText().toString();
                pass = etPass.getText().toString();
                if (email.equals("")) {
                    Toast.makeText(MainActivity.this, "Email is Required", Toast.LENGTH_SHORT).show();
                } else if (pass.equals("")) {
                    Toast.makeText(MainActivity.this, "Password is Required", Toast.LENGTH_SHORT).show();
                } else if (pass.length() < 6) {
                    Toast.makeText(MainActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //new activity
                                Intent i = new Intent(MainActivity.this, HomeScreen.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


            }
        });


        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Registration.class);
                startActivity(i);
                finish();


            }
        });

    }
}

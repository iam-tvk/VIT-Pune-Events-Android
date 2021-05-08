package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    EditText etEmail, etPass, etName, etConPass;
    Button btnReg;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        etName = findViewById(R.id.etName);

        etEmail = findViewById(R.id.etEmail);


        etPass = findViewById(R.id.etPass);

        etConPass = findViewById(R.id.etConPass);

        btnReg = findViewById(R.id.btnReg);


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

    }

    private void signUp() {


        String name, email, pass, ConPass;

        name = etName.getText().toString();
        email = etEmail.getText().toString();
        pass = etPass.getText().toString();
        ConPass = etConPass.getText().toString();


        if (name.equals("")) {
            Toast.makeText(Registration.this, "Name Required", Toast.LENGTH_SHORT).show();
        } else if (email.equals("")) {
            Toast.makeText(Registration.this, "Email Required", Toast.LENGTH_SHORT).show();
        } else if (pass.equals("")) {
            Toast.makeText(Registration.this, "Password Required", Toast.LENGTH_SHORT).show();
        } else if (ConPass.equals("")) {
            Toast.makeText(Registration.this, "Password Required", Toast.LENGTH_SHORT).show();
        } else if (!ConPass.equals(pass)) {
            Toast.makeText(Registration.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Registration.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Registration.this, "User Already Exists!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }

}

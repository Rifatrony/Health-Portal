package com.binaryit.healthportal.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.binaryit.healthportal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import soup.neumorphism.NeumorphButton;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText, numberEditText, emailEditText, passwordEditText;
    TextView haveAccountTextView;
    NeumorphButton signUpButton;
    ProgressBar progressBar;

    String email, password, name, number;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialization();
        setListener();
    }

    private void initialization() {

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");

        nameEditText = findViewById(R.id.nameEditText);
        numberEditText = findViewById(R.id.numberEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        haveAccountTextView = findViewById(R.id.haveAccountTextView);
        signUpButton = findViewById(R.id.signUpButton);
        progressBar = findViewById(R.id.progressBar);
    }

    private void setListener() {
        signUpButton.setOnClickListener(this);
        haveAccountTextView.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.haveAccountTextView:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
            case R.id.signUpButton:
                CheckValidation();
                break;
        }
    }

    private void CheckValidation() {

        name = nameEditText.getText().toString().trim();
        number = numberEditText.getText().toString().trim();
        email = emailEditText.getText().toString().trim();
        password = passwordEditText.getText().toString().trim();

        if (name.isEmpty()){
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (number.isEmpty()){
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.isEmpty()){
            Toast.makeText(this, "Enter Email Address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length()<6){
            Toast.makeText(this, "Minimum Password is 6", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            SignUpUser();
        }

    }

    private void SignUpUser() {

        progressBar.setVisibility(View.VISIBLE);
        signUpButton.setVisibility(View.GONE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                    finish();

                    progressBar.setVisibility(View.GONE);
                    signUpButton.setVisibility(View.VISIBLE);

                    nameEditText.setText("");
                    numberEditText.setText("");
                    emailEditText.setText("");
                    passwordEditText.setText("");

                    HashMap hashMap = new HashMap();
                    hashMap.put("name", name);
                    hashMap.put("number", number);
                    hashMap.put("email", email);
                    hashMap.put("password", password);

                    databaseReference.child(mAuth.getCurrentUser().getUid()).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (task.isSuccessful()){

                            }
                            else {
                                Toast.makeText(SignUpActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
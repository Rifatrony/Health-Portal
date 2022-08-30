package com.binaryit.healthportal.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.binaryit.healthportal.R;

import soup.neumorphism.NeumorphCardView;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    NeumorphCardView doctorCardView, diseaseCardView, hospitalCardView, diagnosticCardView, ambulanceCardView, pharmacyCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initialization();
        setListener();

    }

    private void initialization() {
        doctorCardView = findViewById(R.id.doctorCardView);
        diseaseCardView = findViewById(R.id.diseaseCardView);
        hospitalCardView = findViewById(R.id.hospitalCardView);
        diagnosticCardView = findViewById(R.id.diagnosticCardView);
        ambulanceCardView = findViewById(R.id.ambulanceCardView);
        pharmacyCardView = findViewById(R.id.pharmacyCardView);
    }

    private void setListener(){
        doctorCardView.setOnClickListener(this);
        diseaseCardView.setOnClickListener(this);
        hospitalCardView.setOnClickListener(this);
        diagnosticCardView.setOnClickListener(this);
        ambulanceCardView.setOnClickListener(this);
        pharmacyCardView.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.doctorCardView:
                Intent intent1 = new Intent(getApplicationContext(), CategoryDetailsActivity.class);
                intent1.putExtra("title", "Doctor");
                startActivity(intent1);
                break;

            case R.id.diseaseCardView:
                Intent intent2 = new Intent(getApplicationContext(), CategoryDetailsActivity.class);
                intent2.putExtra("title", "Disease");
                startActivity(intent2);
                break;

            case R.id.hospitalCardView:
                Intent intent3 = new Intent(getApplicationContext(), CategoryDetailsActivity.class);
                intent3.putExtra("title", "Hospital");
                startActivity(intent3);
                break;

            case R.id.diagnosticCardView:
                Intent intent4 = new Intent(getApplicationContext(), CategoryDetailsActivity.class);
                intent4.putExtra("title", "Diagnostic Center");
                startActivity(intent4);
                break;

            case R.id.ambulanceCardView:
                Intent intent5 = new Intent(getApplicationContext(), CategoryDetailsActivity.class);
                intent5.putExtra("title", "Ambulance");
                startActivity(intent5);
                break;

            case R.id.pharmacyCardView:
                Intent intent6 = new Intent(getApplicationContext(), CategoryDetailsActivity.class);
                intent6.putExtra("title", "Pharmacy");
                startActivity(intent6);
                break;
        }
    }
}
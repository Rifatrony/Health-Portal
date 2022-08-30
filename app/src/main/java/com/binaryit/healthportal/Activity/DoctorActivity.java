package com.binaryit.healthportal.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.binaryit.healthportal.Adapter.DoctorAdapter;
import com.binaryit.healthportal.Model.DoctorModel;
import com.binaryit.healthportal.R;

import java.util.ArrayList;
import java.util.List;

public class DoctorActivity extends AppCompatActivity {

    TextView titleTextView;
    ImageView imageBack;
    String specialist;
    RecyclerView doctorListRecyclerView;
    DoctorAdapter doctorAdapter;
    List<DoctorModel> doctorModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        specialist = getIntent().getStringExtra("specialist");

        titleTextView = findViewById(R.id.titleTextView);
        imageBack = findViewById(R.id.imageBack);
        doctorListRecyclerView = findViewById(R.id.doctorListRecyclerView);

        titleTextView.setText(specialist);

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        doctorListRecyclerView.setHasFixedSize(true);
        doctorListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        doctorModelList = new ArrayList<>();
        doctorAdapter = new DoctorAdapter(this, doctorModelList);

        System.out.println("Size is " + doctorModelList.size());

        if (specialist.equals("Anesthesiology & Pain Specialist")){
            doctorModelList.add(new DoctorModel("Doctor A", "M.B.B.S", "Anesthesiology & Pain Specialist", "DMC", "01477", R.drawable.dd));
            doctorModelList.add(new DoctorModel("Doctor B", "M.B.B.S", "Anesthesiology & Pain Specialist", "DMC", "01477", R.drawable.dd));

            doctorListRecyclerView.setAdapter(doctorAdapter);
        }

        if (specialist.equals("Burn & Plastic Specialist")){
            doctorModelList.add(new DoctorModel("Doctor D", "M.B.B.S", "Burn & Plastic Specialist", "DMC", "01477", R.drawable.dd));

            doctorListRecyclerView.setAdapter(doctorAdapter);
        }

        if (specialist.equals("Cardiology Specialist")){
            doctorModelList.add(new DoctorModel("Doctor C", "M.B.B.S", "Cardiology Specialist", "DMC", "01477", R.drawable.dd));

            doctorListRecyclerView.setAdapter(doctorAdapter);
        }

        else {
        }
    }
}
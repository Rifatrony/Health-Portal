package com.binaryit.healthportal.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.binaryit.healthportal.Adapter.DiseaseAdapter;
import com.binaryit.healthportal.Adapter.SpecialistAdapter;
import com.binaryit.healthportal.Adapter.HospitalAdapter;
import com.binaryit.healthportal.Adapter.PharmacyAdapter;
import com.binaryit.healthportal.Model.DiseaseModel;
import com.binaryit.healthportal.Model.SpecialistModel;
import com.binaryit.healthportal.Model.HospitalModel;
import com.binaryit.healthportal.Model.PharmacyModel;
import com.binaryit.healthportal.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetailsActivity extends AppCompatActivity {

    TextView titleTextView;
    String title;
    ImageView imageBack;
    RecyclerView categoryRecyclerView;

    SpecialistAdapter doctorCategoryAdapter;
    List<SpecialistModel> doctorCategoryModelList;


    PharmacyAdapter pharmacyAdapter;
    List<PharmacyModel> pharmacyModelList;

    DiseaseAdapter diseaseAdapter;
    List<DiseaseModel> diseaseModelList;

    HospitalAdapter hospitalAdapter;
    List<HospitalModel> hospitalModelList;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorydetails);

        initialization();
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        title = getIntent().getStringExtra("title");

        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerView.setHasFixedSize(true);
        doctorCategoryModelList = new ArrayList<>();
        pharmacyModelList = new ArrayList<>();
        diseaseModelList = new ArrayList<>();
        hospitalModelList = new ArrayList<>();

        if (title.equals("Doctor")){

            titleTextView.setText("Specialist On");

            doctorCategoryModelList.add(new SpecialistModel("Anesthesiology & Pain Specialist", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Burn & Plastic Specialist", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Cardiology Specialist", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Cancer Specialist", R.drawable.dd));


            /*doctorCategoryModelList.add(new SpecialistModel("Anesthesiology & Pain Specialist", getString(R.string.text1), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Burn & Plastic Specialist", getString(R.string.text1), R.drawable.hospital2));
            doctorCategoryModelList.add(new SpecialistModel("Cardiology Specialist", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Cancer specialist", getString(R.string.text3), R.drawable.p1));
            doctorCategoryModelList.add(new SpecialistModel("Cardiovascular and Thoracic", getString(R.string.text4), R.drawable.dd));

            doctorCategoryModelList.add(new SpecialistModel("Colorectal Surgery", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Dental", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Dermatology", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Diabetes", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("EYE", getString(R.string.text2), R.drawable.dd));

            doctorCategoryModelList.add(new SpecialistModel("ENT, Head, Neck", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("General Surgery", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Gynecology & Obs", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Gastroenterology", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Hair transplant", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Hepatology (Liver, Gallbladder)", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Infertility", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Medicine", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Nephrology", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Neuromedicine", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Neuro Surgery", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Nutritionist and Diet", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Orthopedics", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Pediatric", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Physiotherapy", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Pediatric Cardiology", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Pediatric Surgery", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Psychology", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Rheumatology", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Respiratory", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Sports Medicine", getString(R.string.text2), R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Urology", getString(R.string.text2), R.drawable.dd));*/
            doctorCategoryAdapter = new SpecialistAdapter(this, doctorCategoryModelList);

            categoryRecyclerView.setAdapter(doctorCategoryAdapter);
        }

        if (title.equals("Pharmacy")){

            titleTextView.setText(title + " List");

            pharmacyModelList.add(new PharmacyModel(getString(R.string.p1), getString(R.string.pt1),getString(R.string.pa1),getString(R.string.pn1), R.drawable.p1));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p2), getString(R.string.pt1),getString(R.string.pa2),getString(R.string.pn2), R.drawable.p1));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p3), getString(R.string.pt1),getString(R.string.pa3),getString(R.string.pn3), R.drawable.p1));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p4), getString(R.string.pt1),getString(R.string.pa4),getString(R.string.pn4), R.drawable.p1));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p5), getString(R.string.pt1),getString(R.string.pa5),getString(R.string.pn5), R.drawable.p1));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p6), getString(R.string.pt1),getString(R.string.pa6),getString(R.string.pn6), R.drawable.p1));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p7), getString(R.string.pt1),getString(R.string.pa7),getString(R.string.pn7), R.drawable.p1));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p8), getString(R.string.pt1),getString(R.string.pa8),getString(R.string.pn8), R.drawable.p1));


            pharmacyAdapter = new PharmacyAdapter(this, pharmacyModelList);
            categoryRecyclerView.setAdapter(pharmacyAdapter);
        }

        if (title.equals("Disease")){

            titleTextView.setText(title + " Category");

            diseaseModelList.add(new DiseaseModel("Disease", R.drawable.dd));
            diseaseModelList.add(new DiseaseModel("Disease", R.drawable.disease));
            diseaseModelList.add(new DiseaseModel("Disease", R.drawable.hospital2));
            diseaseModelList.add(new DiseaseModel("Disease", R.drawable.disease));
            diseaseModelList.add(new DiseaseModel("Disease", R.drawable.disease));

            diseaseAdapter = new DiseaseAdapter(this, diseaseModelList);
            categoryRecyclerView.setAdapter(diseaseAdapter);
        }

        if (title.equals("Hospital")){

            titleTextView.setText(title + " List");

            hospitalModelList.add(new HospitalModel(getString(R.string.h1), getString(R.string.h1details), getString(R.string.h1location), R.drawable.hospital2));
            hospitalModelList.add(new HospitalModel(getString(R.string.h2), getString(R.string.h2details), getString(R.string.h2location), R.drawable.hospital2));
            hospitalModelList.add(new HospitalModel(getString(R.string.h3), getString(R.string.h3details), getString(R.string.h3location), R.drawable.hospital2));
            hospitalModelList.add(new HospitalModel(getString(R.string.h4), getString(R.string.h4details), getString(R.string.h4location), R.drawable.hospital2));
            hospitalModelList.add(new HospitalModel(getString(R.string.h5), getString(R.string.h5details), getString(R.string.h5location), R.drawable.hospital2));
            hospitalModelList.add(new HospitalModel(getString(R.string.h6), getString(R.string.h6details), getString(R.string.h6location), R.drawable.hospital2));
            hospitalModelList.add(new HospitalModel(getString(R.string.h7), getString(R.string.h7details), getString(R.string.h7location), R.drawable.hospital2));
            hospitalModelList.add(new HospitalModel(getString(R.string.h8), getString(R.string.h8details), getString(R.string.h8location), R.drawable.hospital2));
            hospitalModelList.add(new HospitalModel(getString(R.string.h9), getString(R.string.h9details), getString(R.string.h9location), R.drawable.hospital2));
            hospitalModelList.add(new HospitalModel(getString(R.string.h10), getString(R.string.h10details), getString(R.string.h10location), R.drawable.hospital2));


            hospitalAdapter = new HospitalAdapter(this, hospitalModelList);
            categoryRecyclerView.setAdapter(hospitalAdapter);
        }
    }

    private void initialization() {
        titleTextView = findViewById(R.id.titleTextView);
        imageBack = findViewById(R.id.imageBack);
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);

    }
}
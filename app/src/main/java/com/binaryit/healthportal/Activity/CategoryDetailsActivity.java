package com.binaryit.healthportal.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.binaryit.healthportal.Adapter.AmbulanceAdapter;
import com.binaryit.healthportal.Adapter.DiagnosticAdapter;
import com.binaryit.healthportal.Adapter.DiseaseAdapter;
import com.binaryit.healthportal.Adapter.SpecialistAdapter;
import com.binaryit.healthportal.Adapter.HospitalAdapter;
import com.binaryit.healthportal.Adapter.PharmacyAdapter;
import com.binaryit.healthportal.Model.AmbulanceModel;
import com.binaryit.healthportal.Model.DiagnosticModel;
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

    DiagnosticAdapter diagnosticAdapter;
    List<DiagnosticModel> diagnosticModelList;

    AmbulanceAdapter ambulanceAdapter;
    List<AmbulanceModel> ambulanceModelList;



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
        diagnosticModelList = new ArrayList<>();
        ambulanceModelList = new ArrayList<>();

        if (title.equals("Doctor")){

            titleTextView.setText("Specialist On");

            doctorCategoryModelList.add(new SpecialistModel("Anesthesiology & Pain Specialist", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Burn & Plastic Specialist",  R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Cardiology Specialist",  R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Cancer specialist", R.drawable.dd));

            doctorCategoryModelList.add(new SpecialistModel("Cardiovascular and Thoracic", R.drawable.dd));

            doctorCategoryModelList.add(new SpecialistModel("Colorectal Surgery", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Dental",  R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Dermatology", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Diabetes",  R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("EYE", R.drawable.dd));

            doctorCategoryModelList.add(new SpecialistModel("ENT, Head, Neck", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("General Surgery", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Gynecology & Obs", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Gastroenterology", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Hair transplant",  R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Hepatology (Liver, Gallbladder)", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Infertility", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Medicine", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Nephrology", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Neuromedicine", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Neuro Surgery", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Nutritionist and Diet", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Orthopedics", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Pediatric", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Physiotherapy", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Pediatric Cardiology", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Pediatric Surgery", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Psychology", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Rheumatology", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Respiratory", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Sports Medicine", R.drawable.dd));
            doctorCategoryModelList.add(new SpecialistModel("Urology", R.drawable.dd));
            doctorCategoryAdapter = new SpecialistAdapter(this, doctorCategoryModelList);

            categoryRecyclerView.setAdapter(doctorCategoryAdapter);
        }

        if (title.equals("Pharmacy")){

            titleTextView.setText(title + " List");

            pharmacyModelList.add(new PharmacyModel(getString(R.string.p1), getString(R.string.pt1),getString(R.string.pa1),getString(R.string.pn1), R.drawable.drugs));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p2), getString(R.string.pt1),getString(R.string.pa2),getString(R.string.pn2), R.drawable.drugs));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p3), getString(R.string.pt1),getString(R.string.pa3),getString(R.string.pn3), R.drawable.drugs));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p4), getString(R.string.pt1),getString(R.string.pa4),getString(R.string.pn4), R.drawable.drugs));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p5), getString(R.string.pt1),getString(R.string.pa5),getString(R.string.pn5), R.drawable.drugs));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p6), getString(R.string.pt1),getString(R.string.pa6),getString(R.string.pn6), R.drawable.drugs));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p7), getString(R.string.pt1),getString(R.string.pa7),getString(R.string.pn7), R.drawable.drugs));
            pharmacyModelList.add(new PharmacyModel(getString(R.string.p8), getString(R.string.pt1),getString(R.string.pa8),getString(R.string.pn8), R.drawable.drugs));


            pharmacyAdapter = new PharmacyAdapter(this, pharmacyModelList);
            categoryRecyclerView.setAdapter(pharmacyAdapter);
        }

        if (title.equals("Disease")){

            titleTextView.setText(title + " Category");

            diseaseModelList.add(new DiseaseModel(getString(R.string.d1), getString(R.string.dc1), getString(R.string.ds1), getString(R.string.dt1), R.drawable.disease));
            diseaseModelList.add(new DiseaseModel(getString(R.string.d2), getString(R.string.dc2), getString(R.string.ds2), getString(R.string.dt2), R.drawable.disease));
           /* diseaseModelList.add(new DiseaseModel("Cold and Flu", R.drawable.disease));
            diseaseModelList.add(new DiseaseModel("Conjunctivitis (“pink eye“)", R.drawable.disease));
            diseaseModelList.add(new DiseaseModel("Diarrhea", R.drawable.disease));
            diseaseModelList.add(new DiseaseModel("Headaches", R.drawable.disease));*/

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

        if (title.equals("Diagnostic Center")){
            titleTextView.setText(title + " List");
            diagnosticModelList.add(new DiagnosticModel("Saleha Diagnostic Centre","Saleha Diagnostic Centre is very well known pathology centre in Dhaka. X-Ray, ECG, Ultrasound and all kind of Hormonal test is available here. The owner of Saleha Diagnostic Centre is 'Mohammad Moniruzzaman Milton' . He is also the 'Admin Director' here. Saleha Diagnostic Centre is most reliable pathological lab as Google and Facebook review.Our Honorable Founder is 'Mohammad Moniruzzaman Milton'. Infertility treatment is one of the best service here.","Sanarpar, Demra, Dhaka. Sarulia.. P.C. 1361, Demra, Dhaka.","8801913774554", R.drawable.diagnostic));
            diagnosticModelList.add(new DiagnosticModel("Anwara Medical Services","Our main activities are treatment and health. This center is a highly specialized center for cancer diagnosis and most advanced investigations in the feild of cancer diagnosis and treatment.Refer to our website to know more about us.","House No 22A, Road No 2. New Market.. P.C. 1205, Dhanmondi, Dhaka.","01971-534318", R.drawable.diagnostic));

            diagnosticAdapter = new DiagnosticAdapter(this, diagnosticModelList);
            categoryRecyclerView.setAdapter(diagnosticAdapter);

        }

        if (title.equals("Ambulance")){
            titleTextView.setText(title + " List");

            ambulanceModelList.add(new AmbulanceModel("Ambulance Service Bangladesh", "24 Hours open", "ICU Ambulance, CCU Ambulance, AC Ambulance, Freezing Ambulance", "Full Bangladesh", "01234567894", R.drawable.ambulance));
            ambulanceModelList.add(new AmbulanceModel("24 Ambulance Service in Dhaka", "24 Hours open", "এসি এ্যাম্বুলেন্স সার্ভিস, নন-এসি এ্যাম্বুলেন্স সার্ভিস, লাশবাহী ফ্রিজার এ্যাম্বুলেন্স, লাইফ সাপোর্ট এ্যাম্বুলেন্স, হাই এইচ এ্যাম্বুলেন্স সার্ভিস", "Full Bangladesh", " 01911125156", R.drawable.ambulance));

            ambulanceAdapter = new AmbulanceAdapter(this, ambulanceModelList);
            categoryRecyclerView.setAdapter(ambulanceAdapter);

        }
    }

    private void initialization() {
        titleTextView = findViewById(R.id.titleTextView);
        imageBack = findViewById(R.id.imageBack);
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);

    }
}
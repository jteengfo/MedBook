package com.example.medbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicineActivity extends AppCompatActivity {

    private ImageButton backButton;
    private ImageButton editButton;

    private TextView txtMedicineName;
    private TextView txtDoseAmount;
    private TextView txtDoseUnit;
    private TextView txtDailyFrequency;
    private TextView txtDateStarted;

    private CardView cardView;

    private Medicine medicine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        Intent i = getIntent();
        medicine = (Medicine) i.getSerializableExtra("medicineObject");


        backButton = findViewById(R.id.imgBtn_backBtn);
        editButton = findViewById(R.id.imgBtn_editBtn);

        txtMedicineName = findViewById(R.id.txtView_medicineName_cardView);
        txtDoseAmount = findViewById(R.id.txtView_doseAmt_cardView);
        txtDoseUnit = findViewById(R.id.txtView_doseUnit_cardView);
        txtDailyFrequency = findViewById(R.id.txtView_dailyFreq_cardView);
        txtDateStarted = findViewById(R.id.txtView_dateStarted_cardView);

        cardView = findViewById(R.id.medicineCardView);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 1/5/2022 finish this logic by directing to the AddMedicine.class
                System.out.println("THIS NEXT TIME");
            }
        });

        txtMedicineName.setText(medicine.getName());
        txtDoseAmount.setText(String.valueOf(medicine.getDoseAmt()));
        txtDoseUnit.setText(medicine.getDoseUnit());
        txtDailyFrequency.setText(String.valueOf(medicine.getDailyFreq()));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(medicine.getDate());
        txtDateStarted.setText(dateString);

    }
}
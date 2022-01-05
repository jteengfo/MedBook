package com.example.medbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

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




    }
}
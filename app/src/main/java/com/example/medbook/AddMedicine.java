package com.example.medbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddMedicine extends AppCompatActivity {

    private DatePickerDialog datePicker;
    private EditText editTxtMedicineName;
    private EditText editTxtDoseAmount;
    private EditText editTxtDailyFreq;
    private EditText editTxtDatePicker;
    private EditText editTxtDoseUnit;

    private Button submitButton;
    private Button cancelButton;

    private Medicine medicine;

    final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        editTxtDatePicker = findViewById(R.id.editTxtDatePicker);
        editTxtMedicineName = findViewById(R.id.editTxtMedicineName);
        editTxtDailyFreq = findViewById(R.id.editTxtDailyFrequency);
        editTxtDoseAmount = findViewById(R.id.editTxtDoseAmt);
        editTxtDoseUnit = findViewById(R.id.editTxtDoseUnit);

        submitButton = findViewById(R.id.submitBtn);
        cancelButton = findViewById(R.id.cancelBtn);

        editTxtDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                // date picker dialog
                datePicker = new DatePickerDialog(AddMedicine.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                editTxtDatePicker.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePicker.show();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get input from editTexts
                String medicineName = editTxtMedicineName.getText().toString();
//              String sDoseAmt = editTxtDoseAmount.getText().toString();
                int DoseAmt = Integer.parseInt(editTxtDoseAmount.getText().toString());
//              String sDailyFrequency = editTxtDailyFreq.getText().toString();
                int DailyFrequency = Integer.parseInt(editTxtDailyFreq.getText().toString());
                String doseUnit = editTxtDoseUnit.getText().toString();
                Date dateStarted = calendar.getTime();

                medicine = new Medicine(medicineName, DoseAmt, doseUnit, DailyFrequency, dateStarted);
                Intent intent = new Intent();
                intent.putExtra("medicineObject", (Serializable) medicine);
                setResult(1, intent);
                AddMedicine.this.finish();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMedicine.this.finish();
            }
        });

    }
}
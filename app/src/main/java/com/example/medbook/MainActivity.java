package com.example.medbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onTextBtnClicked(View view) {
        TextView mainText = findViewById(R.id.medicineList_textView);
        mainText.setText("Hi This is James");
    } 
}
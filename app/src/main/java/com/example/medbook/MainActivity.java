package com.example.medbook;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements medicineRecViewAdapter.OnMedicineListener{

    private static final String TAG = "MainActivity";
    private RecyclerView medicineRecView;
    private medicineRecViewAdapter adapter;
    private FloatingActionButton addButton;

    private ArrayList<Medicine> medicineArrayList;

    // onActivityResult() deprecated new alternative
    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d(TAG, "onActivityResult: ");
                    if (result.getResultCode() == 1) {
                        Intent intent = result.getData();
                        System.out.println("REACHED HERE");
                        if (intent != null) {
                            // Then extract data
                            Medicine tempMedicine = (Medicine) intent.getSerializableExtra("medicineObject");
                            medicineArrayList.add(tempMedicine);
                            medicineRecView.setAdapter(adapter);
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medicineRecView = findViewById(R.id.medicineRecyclerView);
        addButton = findViewById(R.id.addButton);

        adapter = new medicineRecViewAdapter(this);
        medicineRecView.setAdapter(adapter);
        medicineRecView.setLayoutManager(new LinearLayoutManager(this));

        medicineArrayList = new ArrayList<>();

        adapter.setMedicineArrayList(medicineArrayList);

        medicineRecView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMedicine.class);
                activityLauncher.launch(intent);
            }
        });

        medicineRecView.setAdapter(adapter);
    }


    @Override
    public void onMedicineClick(int position) {
        Intent intent = new Intent(this, MedicineActivity.class);
        Medicine medicine = medicineArrayList.get(position);
        System.out.println(medicine.getName());
        intent.putExtra("medicineObject", medicine);

        startActivity(intent);
    }
}
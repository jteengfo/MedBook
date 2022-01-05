package com.example.medbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class medicineRecViewAdapter extends RecyclerView.Adapter<medicineRecViewAdapter.ViewHolder> {

    // initialize an arrayList to contain different medicine
    private ArrayList<Medicine> medicineArrayList = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
    String dateString;


    // setter for the medicineArrayList to initialize initial data in the list
    public void setMedicineArrayList(ArrayList<Medicine> medicineArrayList) {
        this.medicineArrayList = medicineArrayList;
        notifyDataSetChanged();
    }

    public medicineRecViewAdapter() {
    }

    // purpose is to create an instance of the viewHolder class for every item in the recycler view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // first is to create a view to create a viewHolder class
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        dateString = sdf.format(medicineArrayList.get(position).getDate());

        holder.txtMedicineName.setText(medicineArrayList.get(position).getName());
        holder.txtDateStarted.setText(dateString);
        holder.txtDoseAmt.setText(String.valueOf(medicineArrayList.get(position).getDoseAmt()));
        holder.txtFrequency.setText(String.valueOf(medicineArrayList.get(position).getDailyFreq()));

    }

    @Override
    public int getItemCount() {
        return medicineArrayList.size();
    }

    // inner class responsible for generating view object
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // insert all content in the medicine item list layout file
        private TextView txtMedicineName;
        private TextView txtDoseAmt;
        private TextView txtFrequency;
        private TextView txtDateStarted;
        private ConstraintLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // can't use findViewById because not inside an activity. Instead we are inside
            // a view itemView so we use that instead.
            txtMedicineName = itemView.findViewById(R.id.txtViewMedicineName);
            txtDoseAmt = itemView.findViewById(R.id.txtViewDoseAmt);
            txtFrequency = itemView.findViewById(R.id.txtViewFrequency);
            txtDateStarted = itemView.findViewById(R.id.txtViewDateStarted);
            parent = itemView.findViewById(R.id.parent);
        }

    }
    // create interface
    public interface OnMedicineListener {
        void onMedicineClick(int position);
    }
}

package com.binaryit.healthportal.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binaryit.healthportal.Model.DiagnosticModel;
import com.binaryit.healthportal.Model.HospitalModel;
import com.binaryit.healthportal.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class DiagnosticAdapter extends RecyclerView.Adapter<DiagnosticAdapter.DiagnosticViewHolder> {

    Context context;
    List<DiagnosticModel> diagnosticModelList;

    public DiagnosticAdapter() {
    }

    public DiagnosticAdapter(Context context, List<DiagnosticModel> diagnosticModelList) {
        this.context = context;
        this.diagnosticModelList = diagnosticModelList;
    }

    @NonNull
    @Override
    public DiagnosticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.diagnostic_layout, parent, false);
        return new DiagnosticViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DiagnosticViewHolder holder, int position) {
        DiagnosticModel diagnosticModel = diagnosticModelList.get(position);
        holder.nameTextView.setText(diagnosticModel.getName());
        holder.detailsTextView.setText("About us: \n"+diagnosticModel.getDetails());
        holder.locationTextView.setText("Address:\n"+diagnosticModel.getLocation());
        holder.numberTextView.setText("Contact:\n"+diagnosticModel.getNumber());
        Glide.with(context).load(diagnosticModel.getImage()).into(holder.imageView);

        boolean isVisible = diagnosticModel.isVisibility();
        holder.expandedLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return diagnosticModelList.size();
    }

    public class DiagnosticViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, detailsTextView, locationTextView, numberTextView;
        ImageView imageView;
        LinearLayout expandedLayout;

        public DiagnosticViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            detailsTextView = itemView.findViewById(R.id.detailsTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
            imageView = itemView.findViewById(R.id.imageView);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DiagnosticModel diagnosticModel = diagnosticModelList.get(getAdapterPosition());
                    diagnosticModel.setVisibility(!diagnosticModel.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }

}

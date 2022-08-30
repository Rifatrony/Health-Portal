package com.binaryit.healthportal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binaryit.healthportal.Model.DiseaseModel;
import com.binaryit.healthportal.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.DiseaseViewHolder> {

    Context context;
    List<DiseaseModel> diseaseModelList;

    public DiseaseAdapter(Context context, List<DiseaseModel> diseaseModelList) {
        this.context = context;
        this.diseaseModelList = diseaseModelList;
    }

    @NonNull
    @Override
    public DiseaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.disease_layout, parent, false);
        return new DiseaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiseaseViewHolder holder, int position) {
        DiseaseModel data = diseaseModelList.get(position);
        holder.nameTextView.setText(data.getDiseaseName());
        holder.causeTextView.setText(data.getCauses());
        holder.symptomsTextView.setText(data.getSymptoms());
        holder.treatmentTextView.setText(data.getTreatment());
        Glide.with(context).load(data.getImage()).into(holder.imageView);
        boolean isVisible = data.isVisibility();
        holder.expandedLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return diseaseModelList.size();
    }

    public class DiseaseViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, causeTextView, symptomsTextView, treatmentTextView;
        ImageView imageView;
        LinearLayout expandedLayout;

        public DiseaseViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            causeTextView = itemView.findViewById(R.id.causeTextView);
            symptomsTextView = itemView.findViewById(R.id.symptomsTextView);
            treatmentTextView = itemView.findViewById(R.id.treatmentTextView);
            imageView = itemView.findViewById(R.id.imageView);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DiseaseModel diseaseModel = diseaseModelList.get(getAdapterPosition());
                    diseaseModel.setVisibility(!diseaseModel.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }

}

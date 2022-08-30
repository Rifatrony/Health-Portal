package com.binaryit.healthportal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        View view = LayoutInflater.from(context).inflate(R.layout.category_layout, parent, false);
        return new DiseaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiseaseViewHolder holder, int position) {
        DiseaseModel data = diseaseModelList.get(position);
        holder.categoryNameTextView.setText(data.getDiseaseName());
        Glide.with(context).load(data.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return diseaseModelList.size();
    }

    public class DiseaseViewHolder extends RecyclerView.ViewHolder {

        TextView categoryNameTextView;
        ImageView imageView;

        public DiseaseViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryNameTextView = itemView.findViewById(R.id.categoryNameTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}

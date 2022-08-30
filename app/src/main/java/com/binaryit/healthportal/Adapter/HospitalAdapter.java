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
import com.binaryit.healthportal.Model.DoctorModel;
import com.binaryit.healthportal.Model.HospitalModel;
import com.binaryit.healthportal.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder> {

    Context context;
    List<HospitalModel> hospitalModelList;

    public HospitalAdapter(Context context, List<HospitalModel> hospitalModelList) {
        this.context = context;
        this.hospitalModelList = hospitalModelList;
    }

    @NonNull
    @Override
    public HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hospital_layout, parent, false);
        return new HospitalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalViewHolder holder, int position) {
        HospitalModel data = hospitalModelList.get(position);
        holder.hospitalNameTextView.setText(data.getHospitalName());
        holder.detailsTextView.setText(data.getDetails());
        holder.locationTextView.setText(data.getLocation());
        Glide.with(context).load(data.getImage()).into(holder.imageView);

        boolean isVisible = data.isVisibility();
        holder.expandedLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return hospitalModelList.size();
    }

    public class HospitalViewHolder extends RecyclerView.ViewHolder {

        TextView hospitalNameTextView, detailsTextView, locationTextView;
        ImageView imageView;
        LinearLayout expandedLayout;

        public HospitalViewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalNameTextView = itemView.findViewById(R.id.hospitalNameTextView);
            detailsTextView = itemView.findViewById(R.id.detailsTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            imageView = itemView.findViewById(R.id.imageView);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HospitalModel hospitalModel = hospitalModelList.get(getAdapterPosition());
                    hospitalModel.setVisibility(!hospitalModel.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}

package com.binaryit.healthportal.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binaryit.healthportal.Model.AmbulanceModel;
import com.binaryit.healthportal.Model.DiagnosticModel;
import com.binaryit.healthportal.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class AmbulanceAdapter extends RecyclerView.Adapter<AmbulanceAdapter.AmbulanceViewHolder> {

    Context context;
    List<AmbulanceModel> ambulanceModelList;

    public AmbulanceAdapter(Context context, List<AmbulanceModel> ambulanceModelList) {
        this.context = context;
        this.ambulanceModelList = ambulanceModelList;
    }

    @NonNull
    @Override
    public AmbulanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ambulance_layout, parent, false);
        return new AmbulanceViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AmbulanceViewHolder holder, int position) {
        AmbulanceModel ambulanceModel = ambulanceModelList.get(position);
        holder.nameTextView.setText(ambulanceModel.getName());
        holder.timeTextView.setText(ambulanceModel.getTime());
        holder.servicesTextView.setText("Services: "+ambulanceModel.getServices());
        holder.areaTextView.setText(ambulanceModel.getArea());
        holder.numberTextView.setText(ambulanceModel.getNumber());
        Glide.with(context).load(ambulanceModel.getImage()).into(holder.imageView);

        boolean isVisible = ambulanceModel.isVisibility();
        holder.expandedLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return ambulanceModelList.size();
    }

    public class AmbulanceViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nameTextView, timeTextView, servicesTextView, areaTextView, numberTextView;
        LinearLayout expandedLayout;

        public AmbulanceViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            servicesTextView = itemView.findViewById(R.id.servicesTextView);
            areaTextView = itemView.findViewById(R.id.areaTextView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AmbulanceModel ambulanceModel = ambulanceModelList.get(getAdapterPosition());
                    ambulanceModel.setVisibility(!ambulanceModel.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }

}

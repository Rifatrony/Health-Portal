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

import com.binaryit.healthportal.Model.DoctorModel;
import com.binaryit.healthportal.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    Context context;
    List<DoctorModel> doctorModelList;

    public DoctorAdapter(Context context, List<DoctorModel> doctorModelList) {
        this.context = context;
        this.doctorModelList = doctorModelList;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doctor_category_layout, parent, false);
        return new DoctorViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        DoctorModel doctorModel = doctorModelList.get(position);
        holder.nameTextView.setText(doctorModel.getName());
        holder.specialistTextView.setText(doctorModel.getSpecialist());
        holder.qualificationTextView.setText("Qualification:  "+doctorModel.getQualification());
        holder.chamberTextView.setText("Chamber: "+doctorModel.getChamber());
        holder.appointmentTextView.setText("Appointment: "+doctorModel.getAppointment());
        Glide.with(context).load(doctorModel.getImage()).into(holder.imageView);

        boolean isVisible = doctorModel.isVisibility();
        holder.expandedLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return doctorModelList.size();
    }

    public class DoctorViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, specialistTextView, qualificationTextView, chamberTextView, appointmentTextView;
        ImageView imageView;
        LinearLayout expandedLayout;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            specialistTextView = itemView.findViewById(R.id.specialistTextView);
            qualificationTextView = itemView.findViewById(R.id.qualificationTextView);
            chamberTextView = itemView.findViewById(R.id.chamberTextView);
            appointmentTextView = itemView.findViewById(R.id.appointmentTextView);
            imageView = itemView.findViewById(R.id.imageView);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DoctorModel doctorModel = doctorModelList.get(getAdapterPosition());
                    doctorModel.setVisibility(!doctorModel.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}

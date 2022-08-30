package com.binaryit.healthportal.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binaryit.healthportal.Activity.DoctorActivity;
import com.binaryit.healthportal.Model.SpecialistModel;
import com.binaryit.healthportal.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class SpecialistAdapter extends RecyclerView.Adapter<SpecialistAdapter.DoctorCategoryViewHolder> {

    Context context;
    List<SpecialistModel> doctorCategoryModelList;

    public SpecialistAdapter() {
    }

    public SpecialistAdapter(Context context, List<SpecialistModel> doctorCategoryModelList) {
        this.context = context;
        this.doctorCategoryModelList = doctorCategoryModelList;
    }

    @NonNull
    @Override
    public DoctorCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_layout, parent, false);
        return new DoctorCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorCategoryViewHolder holder, int position) {
        SpecialistModel data = doctorCategoryModelList.get(position);
        holder.categoryNameTextView.setText(data.getCategoryName());
        Glide.with(context).load(data.getImage()).into(holder.imageView);
        /*holder.briefTextView.setText(data.getBriefText());
        boolean isVisible = data.isVisibility();
        holder.expandedLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DoctorActivity.class);
                intent.putExtra("specialist", data.getCategoryName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doctorCategoryModelList.size();
    }

    public class DoctorCategoryViewHolder extends RecyclerView.ViewHolder {

        TextView categoryNameTextView;
        ImageView imageView;
        LinearLayout expandedLayout;
        //TextView briefTextView;

        public DoctorCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryNameTextView = itemView.findViewById(R.id.categoryNameTextView);
            imageView = itemView.findViewById(R.id.imageView);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);
            /*briefTextView = itemView.findViewById(R.id.briefTextView);*/

           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SpecialistModel model = doctorCategoryModelList.get(getAdapterPosition());
                    model.setVisibility(!model.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });*/

        }
    }

}

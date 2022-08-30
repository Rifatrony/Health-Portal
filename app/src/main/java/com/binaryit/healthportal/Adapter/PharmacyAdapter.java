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

import com.binaryit.healthportal.Model.PharmacyModel;
import com.binaryit.healthportal.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.PharmacyViewHolder> {

    Context context;
    List<PharmacyModel> pharmacyModelList;

    public PharmacyAdapter(Context context, List<PharmacyModel> pharmacyModelList) {
        this.context = context;
        this.pharmacyModelList = pharmacyModelList;
    }

    @NonNull
    @Override
    public PharmacyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pharmacy_category_layout, parent, false);
        return new PharmacyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PharmacyViewHolder holder, int position) {
        PharmacyModel data = pharmacyModelList.get(position);
        holder.nameTextView.setText(data.getPharmacyName());
        holder.timeTextView.setText("Open : "+data.getTime());
        holder.addressTextView.setText("Address: "+data.getAddress());
        holder.numberTextView.setText("Contact: "+data.getNumber());
        Glide.with(context).load(data.getImage()).into(holder.imageView);

        boolean isVisible = data.isVisibility();
        holder.expandedLayout.setVisibility(isVisible ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return pharmacyModelList.size();
    }

    public class PharmacyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, timeTextView, addressTextView, numberTextView;
        ImageView imageView;
        LinearLayout expandedLayout;

        public PharmacyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PharmacyModel pharmacyModel = pharmacyModelList.get(getAdapterPosition());
                    pharmacyModel.setVisibility(!pharmacyModel.isVisibility());
                    notifyItemChanged(getAdapterPosition());

                }
            });

        }
    }

}

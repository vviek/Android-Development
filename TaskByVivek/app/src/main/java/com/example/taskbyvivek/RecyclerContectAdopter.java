package com.example.taskbyvivek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContectAdopter extends RecyclerView.Adapter<RecyclerContectAdopter.ViewHolder> {

    Context context;
    ArrayList<ModelClassForRecyclerview> arruserDetalis;

    public RecyclerContectAdopter(Context context, ArrayList<ModelClassForRecyclerview> arruserDetalis) {
        this.context = context;
        this.arruserDetalis = arruserDetalis;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.recyclerview_one, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelClassForRecyclerview model = arruserDetalis.get(position);

        holder.imgProfile.setImageResource(model.image);
        holder.tvName.setText(model.name);
        holder.tvEmail.setText(model.gmail);
        holder.tvPhone.setText(model.phone);
        holder.tvAddress.setText(model.address);
    }

    @Override
    public int getItemCount() {
        return arruserDetalis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;
        TextView tvName, tvEmail, tvPhone, tvAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvAddress = itemView.findViewById(R.id.tvAddress);
        }
    }
}
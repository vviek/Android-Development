package com.sourabh.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContectAdopter extends RecyclerView.Adapter<RecyclerContectAdopter.viewholde> {

    Context context;
    ArrayList<ContectModel> arrcontect;
    RecyclerContectAdopter(Context context, ArrayList<ContectModel> arrcontect ){
        this.context=context;
        this.arrcontect=arrcontect;
    }

    @NonNull
    @Override
    public viewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_contect_row,parent,false);
        viewholde viewholde =new viewholde(view);
        return viewholde;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholde holder, int position) {

        //accessing holder class varav]ble and connecting view with index positio of array list
        holder.imgcontect.setImageResource(arrcontect.get(position).img);
        holder.txtcontect.setText(arrcontect.get(position).contect);
        holder.entercotect.setText(arrcontect.get(position).entercontect);


    }

    @Override
    public int getItemCount() {

        //to set arry size
        return arrcontect.size() ;
    }

    public class viewholde extends RecyclerView.ViewHolder{

        ImageView imgcontect;
        TextView txtcontect,entercotect;
            public viewholde(View itemview){
                super(itemview);

               imgcontect = itemview.findViewById(R.id.imgcontect);
                txtcontect=itemview.findViewById(R.id.txtcontect);
                entercotect=itemview.findViewById(R.id.entercotect);
            }

     }
}

package com.example.geocardioband.ui.historical;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.geocardioband.R;

import java.util.ArrayList;

public class PredictionAdapter extends RecyclerView.Adapter<PredictionAdapter.PredictionViewHolder>{

    ArrayList<Prediction> predictionList;

    public PredictionAdapter(ArrayList<Prediction> _predictionList) {
        this.predictionList=_predictionList;
    }

    @Override
    public PredictionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historical,null,false);
        return new PredictionViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(PredictionViewHolder holder, int position) {
        holder.txtDate.setText("Fecha: "+ predictionList.get(position).getDate());
        holder.txtPrediction.setText("Prediccion: "+String.valueOf(predictionList.get(position).getProbability())+ "%");
        holder.image.setImageResource(R.drawable.heart);
    }

    @Override
    public int getItemCount() {
        return predictionList.size();
    }

    public class PredictionViewHolder extends RecyclerView.ViewHolder {
        TextView txtDate,txtPrediction;
        ImageView image;

        public PredictionViewHolder(View itemView) {
            super(itemView);
            txtDate= (TextView) itemView.findViewById(R.id.idDate);
            txtPrediction= (TextView) itemView.findViewById(R.id.idPrediction);
            image= (ImageView) itemView.findViewById(R.id.idHeartImage);
        }
    }
}
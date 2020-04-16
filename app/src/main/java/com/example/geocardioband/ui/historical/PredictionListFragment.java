package com.example.geocardioband.ui.historical;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geocardioband.R;
import com.example.geocardioband.ui.room.AppDatabase;

import java.util.ArrayList;


public class PredictionListFragment extends Fragment {

    private AppDatabase db;

    RecyclerView recyclerPredictions;
    ArrayList<Prediction> predictionList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //muestra de la vista del historico de preddicciones
        View root = inflater.inflate(R.layout.fragment_historical, container, false);
        predictionList = new ArrayList<>();//lista de predicciones
        recyclerPredictions = root.findViewById(R.id.idReciclerView);//reciclerView de predicciones
        recyclerPredictions.setLayoutManager(new LinearLayoutManager(getContext()));
        setData();
        PredictionAdapter adapter = new PredictionAdapter(predictionList);
        recyclerPredictions.setAdapter(adapter);
        return root;
    }

    public void setData(){
        // Instanciar DB
        db = Room.databaseBuilder(this.getContext(), AppDatabase.class, "geocardioband").allowMainThreadQueries().build();
        // Recuperar las predicciones de la DB
        predictionList.addAll(db.PredictionDao().getAll());
    }
}

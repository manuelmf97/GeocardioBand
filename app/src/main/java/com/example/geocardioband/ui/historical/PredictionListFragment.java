package com.example.geocardioband.ui.historical;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geocardioband.R;

import java.util.ArrayList;


public class PredictionListFragment extends Fragment {

    RecyclerView recyclerPredictions;
    ArrayList<Prediction> predictionList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_historical, container, false);
        predictionList = new ArrayList<>();
        recyclerPredictions = root.findViewById(R.id.idReciclerView);
        recyclerPredictions.setLayoutManager(new LinearLayoutManager(getContext()));
        setData();
        PredictionAdapter adapter = new PredictionAdapter(predictionList);
        recyclerPredictions.setAdapter(adapter);
        return root;
    }

    public void setData(){
        predictionList.add(new Prediction(88,"03/03/1997 18:04"));
        predictionList.add(new Prediction(18,"04/04/1998 18:24"));
        predictionList.add(new Prediction(28,"05/04/1998 18:24"));
        predictionList.add(new Prediction(45,"06/04/1998 18:24"));
        predictionList.add(new Prediction(67,"08/04/1998 18:24"));
        predictionList.add(new Prediction(87,"09/04/1998 18:24"));
        predictionList.add(new Prediction(89,"14/04/1998 18:24"));
        predictionList.add(new Prediction(38,"24/04/1998 18:24"));
        predictionList.add(new Prediction(88,"03/03/1997 18:04"));
        predictionList.add(new Prediction(18,"04/04/1998 18:24"));
        predictionList.add(new Prediction(28,"05/04/1998 18:24"));
        predictionList.add(new Prediction(45,"06/04/1998 18:24"));
        predictionList.add(new Prediction(67,"08/04/1998 18:24"));
        predictionList.add(new Prediction(87,"09/04/1998 18:24"));
        predictionList.add(new Prediction(89,"14/04/1998 18:24"));
        predictionList.add(new Prediction(38,"24/04/1998 18:24"));
    }
}

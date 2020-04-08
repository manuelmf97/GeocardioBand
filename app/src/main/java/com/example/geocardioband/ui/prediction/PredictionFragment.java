package com.example.geocardioband.ui.prediction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.geocardioband.R;

public class PredictionFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_prediction, container, false);
        final Button predictionButton = (Button)root.findViewById(R.id.prediction_button);
        final TextView predictionTextView = (TextView) root.findViewById(R.id.predictionText);

       predictionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                predictionTextView.setText(String.valueOf("Tiene una probabilidad del " + System.currentTimeMillis() +
                        "% de sufrir un infarto"));
            }
        });
        return root;
    }
}

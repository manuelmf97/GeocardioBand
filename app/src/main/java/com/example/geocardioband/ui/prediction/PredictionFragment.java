package com.example.geocardioband.ui.prediction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.geocardioband.R;
import com.example.geocardioband.ui.configuration.UserConfig;
import com.example.geocardioband.ui.historical.Prediction;
import com.example.geocardioband.ui.io.PredictionApiAdapter;
import com.example.geocardioband.ui.io.response.PredictRequest;
import com.example.geocardioband.ui.io.response.PredictResponse;
import com.example.geocardioband.ui.room.AppDatabase;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PredictionFragment extends Fragment implements Callback<PredictResponse> {

    private AppDatabase db;
    private TextView predictionTextView;    // Declarada aquí para que la actualice el onResponse tras la peticion

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_prediction, container, false);
        final Button predictionButton = (Button)root.findViewById(R.id.prediction_button);
        predictionTextView = (TextView) root.findViewById(R.id.predictionText);
        final Context context = this.getContext();

        // Instanciar DB
        db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "geocardioband").allowMainThreadQueries().build();

        // TODO Mocked HeartRate
        final Double heartRate = 70.0;

       predictionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Llamada al builder de peticion
                makeRequest(context, heartRate);
            }
        });
        return root;
    }

    /**
     * Crea el body (json) y realiza la petición a la API
     */
    public void makeRequest(Context context, Double heartRate){
        // Recuperar configuracion
        UserConfig userConfig = db.UserConfigDao().getUserConfig(0);
        if (userConfig!=null && userConfig.getMid()==0){
            // Crear el body de la peticion
            PredictRequest predictRequestBody = new PredictRequest(
                    userConfig.getSex().equals("Masculino") ? 1 : 0,
                    Integer.parseInt(userConfig.getAge()),
                    userConfig.getSmoker() ? 1 : 0,
                    userConfig.getHypertension() ? 1 : 0,
                    Double.valueOf(userConfig.getCholesterol()),
                    Double.valueOf(userConfig.getBmi()),
                    heartRate);

            // Realizar peticion a la API
            Call<PredictResponse> call = PredictionApiAdapter.getApiService().postPredict(predictRequestBody);
            call.enqueue(this); // Si tiene exito, ejecuta onResponse, si no, onFailure.

        } else {
            Toast.makeText(context, "Configura tus parámetros primero", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(Call<PredictResponse> call, Response<PredictResponse> response) {
        if (response.isSuccessful()) {
            PredictResponse predictResponse = response.body();

            // Crear objeto Prediction con marca de tiempo
            Date currentTime = Calendar.getInstance().getTime();
            Prediction prediction = new Prediction(predictResponse.getProbInfarto()*100, currentTime.toString());

            // Actualizar el layout
            predictionTextView.setText(String.valueOf("Tiene una probabilidad del " + prediction.getProbability() +
                    "% de sufrir un infarto"));

            // Guardar
            db.PredictionDao().insertPrediction(prediction);
        }
    }

    @Override
    public void onFailure(Call<PredictResponse> call, Throwable t) {
        Log.i("onFailure Prediction", "Ha habido un error en la peticion");
        Toast.makeText(this.getContext(), "Ha habido un error, inténtelo de nuevo.", Toast.LENGTH_SHORT).show();
    }
}

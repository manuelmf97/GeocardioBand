package com.example.geocardioband.ui.configuration;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.geocardioband.R;
import com.example.geocardioband.ui.room.AppDatabase;
import com.example.geocardioband.ui.room.UserConfigDao;


public class ConfigurationFragment extends Fragment {

    AppDatabase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Vista del fragment
        final View root = inflater.inflate(R.layout.fragment_configuration, container, false);

        final Context context = this.getContext();
        final CharSequence text = "Por favor, introduzca todos los campos";
        final int duration = Toast.LENGTH_SHORT;

        //Obtencion de los manejadores de la informacion del usuario
        final Button saveButton = (Button)root.findViewById(R.id.save_button);
        final EditText age = (EditText) root.findViewById(R.id.age_editText);
        final EditText cholesterol = (EditText) root.findViewById(R.id.cholesterol_editText);
        final EditText bmi = (EditText) root.findViewById(R.id.bmi_editText);
        final RadioGroup sexRG = (RadioGroup) root.findViewById(R.id.sex_options);
        final RadioGroup smokerRG = (RadioGroup) root.findViewById(R.id.smoker_options);
        final RadioGroup hypertensionRG = (RadioGroup) root.findViewById(R.id.hypertension_options);

        // Instanciar DB
        db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "geocardioband").allowMainThreadQueries().build();

        // Si existen datos en la BD, leerlos y fijarlos. Siempre se guarda y obtiene con ID=0, sólo hay una configuración.
        UserConfig userConfig = db.UserConfigDao().getUserConfig(0);
        if (userConfig!=null && userConfig.getMid()==0){
            // Fijar en el layout la configuración ya existente.
            age.setText(userConfig.getAge());
            cholesterol.setText(userConfig.getCholesterol());
            bmi.setText(userConfig.getBmi());
            sexRG.check(userConfig.getAge().equals("Masculino") ? R.id.radio_male : R.id.radio_female);
            smokerRG.check(userConfig.getSmoker() ? R.id.radio_yes_smoker : R.id.radio_no_smoker);
            hypertensionRG.check(userConfig.getHypertension() ? R.id.radio_yes_hypertension : R.id.radio_no_hypertension);
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //comprobar si los campos estan blancos e indicarselo al usuario
                if(isEmpty(age) || isEmpty(cholesterol) || isEmpty(bmi)){

                    Toast.makeText(context, text, duration).show();

                }else{
                    //Obtencion de la informacion de configuracion del usuario
                    String ageText = age.getText().toString();
                    String cholesterolText = cholesterol.getText().toString();
                    String bmiText = bmi.getText().toString();
                    int radioIdSex = sexRG.getCheckedRadioButtonId();
                    int radioIdSmoker = smokerRG.getCheckedRadioButtonId();
                    int radioIdHypertension = hypertensionRG.getCheckedRadioButtonId();

                    RadioButton sexRadioButton = (RadioButton) root.findViewById(radioIdSex);
                    RadioButton smokerRadioButton = (RadioButton) root.findViewById(radioIdSmoker);
                    RadioButton hypertensionRadioButton = (RadioButton) root.findViewById(radioIdHypertension);

                    //Pasar a String la configuracion botones de radio de la vista
                    String sexText = sexRadioButton.getText().toString();
                    String smokerText = smokerRadioButton.getText().toString();
                    Boolean smoker = (smokerText.equals("Si")) ? true : false;
                    String hypertensionText = hypertensionRadioButton.getText().toString();
                    Boolean hypertension = (hypertensionText.equals("Si")) ? true : false;

                    // Guardar datos en la BD
                    UserConfig NewUserConfig = new UserConfig(0,ageText,cholesterolText,bmiText,sexText,smoker,hypertension);
                    db.UserConfigDao().addUserConfig(NewUserConfig);

                    Toast.makeText(context, "Configuracion guardada con éxito", duration).show();
                }
            }
        });

        return root;
    }

    //True si el editText esta vacio, false en caso contrario
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
}

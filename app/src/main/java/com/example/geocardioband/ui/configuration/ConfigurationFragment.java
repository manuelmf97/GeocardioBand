package com.example.geocardioband.ui.configuration;

import android.content.Context;
import android.os.Bundle;
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
import com.example.geocardioband.R;


public class ConfigurationFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_configuration, container, false);

        final Context context = this.getContext();
        final CharSequence text = "Por favor, introduzca todos los campos";
        final int duration = Toast.LENGTH_SHORT;
        final Button saveButton = (Button)root.findViewById(R.id.save_button);
        final EditText age = (EditText) root.findViewById(R.id.age_editText);
        final EditText cholesterol = (EditText) root.findViewById(R.id.cholesterol_editText);
        final EditText bmi = (EditText) root.findViewById(R.id.bmi_editText);
        final RadioGroup sexRG = (RadioGroup) root.findViewById(R.id.sex_options);
        final RadioGroup smokerRG = (RadioGroup) root.findViewById(R.id.smoker_options);
        final RadioGroup hypertensionRG = (RadioGroup) root.findViewById(R.id.hypertension_options);
        final RadioGroup chdRG = (RadioGroup) root.findViewById(R.id.chd_options);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(isEmpty(age) || isEmpty(cholesterol) || isEmpty(bmi)){

                    Toast.makeText(context, text, duration).show();

                }else{

                    String ageText = age.getText().toString();
                    String cholesterolText = cholesterol.getText().toString();
                    String bmiText = bmi.getText().toString();
                    int radioIdSex = sexRG.getCheckedRadioButtonId();
                    int radioIdSmoker = smokerRG.getCheckedRadioButtonId();
                    int radioIdHypertension = hypertensionRG.getCheckedRadioButtonId();
                    int radioIdChd = chdRG.getCheckedRadioButtonId();

                    RadioButton sexRadioButton = (RadioButton) root.findViewById(radioIdSex);
                    RadioButton smokerRadioButton = (RadioButton) root.findViewById(radioIdSmoker);
                    RadioButton hypertensionRadioButton = (RadioButton) root.findViewById(radioIdHypertension);
                    RadioButton chdRadioButton = (RadioButton) root.findViewById(radioIdChd);

                    String sexText = sexRadioButton.getText().toString();
                    String smokerText = smokerRadioButton.getText().toString();
                    Boolean smoker = (smokerText.equals("Si")) ? true : false;
                    String hypertensionText = hypertensionRadioButton.getText().toString();
                    Boolean hypertension = (hypertensionText.equals("Si")) ? true : false;
                    String chdText = chdRadioButton.getText().toString();
                    Boolean chd = (chdText.equals("Si")) ? true : false;

                    Toast.makeText(context, "Configuracion guardada con éxito", duration).show();
                }
            }
        });

        return root;
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
}

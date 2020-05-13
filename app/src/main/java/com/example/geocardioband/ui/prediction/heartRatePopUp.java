package com.example.geocardioband.ui.prediction;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import com.example.geocardioband.R;

public class heartRatePopUp {
    private heartRateListener listener;

    public void showPopupWindow(final View view, Fragment fragment) {

        final Context context = view.getContext();

        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.layout_heart_rate_pop_up, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        boolean focusable = true;

        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        listener = (heartRateListener) fragment;
        final EditText heartRateText = popupView.findViewById(R.id.heartRateText);

        Button aceptButton = popupView.findViewById(R.id.acept);
        aceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String heartRate =  heartRateText.getText().toString();
                if(heartRate.trim().length() == 0){
                    Toast.makeText(context, "Por favor, Introduzca el ritmo cardiaco", Toast.LENGTH_SHORT).show();
                }else{
                    listener.sendHeartRate(heartRate);
                    popupWindow.dismiss();
                }
            }
        });

        Button cancelButton = popupView.findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }


    public interface heartRateListener {
        void sendHeartRate(String heartRate);
    }

}

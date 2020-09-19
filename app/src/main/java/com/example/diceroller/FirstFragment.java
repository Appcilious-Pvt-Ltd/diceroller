package com.example.diceroller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    RadioGroup rG;
    RadioButton r1, r2;
    Spinner colors;
    SeekBar r, g, b;
    String[] col = {"Red", "Green", "Blue", "Cyan", "Yellow", "Magenta"};
    String temp;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        rG = view.findViewById(R.id.radioGroup);
        r1 = view.findViewById(R.id.radio1);
        r2 = view.findViewById(R.id.radio2);

        colors = view.findViewById(R.id.spinner);
        r = view.findViewById(R.id.red_seekbar);
        g = view.findViewById(R.id.green_seekbar);
        b = view.findViewById(R.id.blue_seekbar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireActivity(), R.layout.support_simple_spinner_dropdown_item, col);
        colors.setAdapter(adapter);
        colors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                temp = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(this, "Done ", Toast.LENGTH_SHORT).show();
            }
        });

        if(r2.isChecked()) {
            // Hide the Spinner and set the visibility of Seek bars
        }

        return view;
    }


}
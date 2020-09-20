package com.example.diceroller;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.diceroller.dicecount.ThreeDiceFragment;

public class FirstFragment extends Fragment {

    RadioGroup rG;
    RadioButton r1, r2;
    Spinner colors;
    SeekBar r, g, b;
    String[] colorList;
    View colorShow;
    String temp;
    LinearLayout customColors;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        rG = view.findViewById(R.id.radioGroup);
        r1 = view.findViewById(R.id.radio1);
        r2 = view.findViewById(R.id.radio2);
        customColors = view.findViewById(R.id.custom_colors);
        colorShow = view.findViewById(R.id.colorShow);
        colors = view.findViewById(R.id.spinner);
        r = view.findViewById(R.id.red_seekbar);
        g = view.findViewById(R.id.green_seekbar);
        b = view.findViewById(R.id.blue_seekbar);

        rG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if(r1.isChecked()) {
                    colors.setVisibility(View.VISIBLE);
                    customColors.setVisibility(View.GONE);

                    colorList = getResources().getStringArray(R.array.colorsList);
                    final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, colorList);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    colors.setAdapter(adapter);

                    colors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            switch (i) {
                                case 0:
                                    colorShow.setBackgroundColor(Color.RED);
                                    changeColor(Color.RED);
                                    break;
                                case 1:
                                    colorShow.setBackgroundColor(Color.GREEN);
                                    changeColor(Color.GREEN);
                                    break;
                                case 2:
                                    colorShow.setBackgroundColor(Color.BLUE);
                                    changeColor(Color.BLUE);
                                    break;
                                case 3:
                                    colorShow.setBackgroundColor(Color.CYAN);
                                    changeColor(Color.CYAN);
                                    break;
                                case 4:
                                    colorShow.setBackgroundColor(Color.YELLOW);
                                    changeColor(Color.YELLOW);
                                    break;
                                case 5:
                                    colorShow.setBackgroundColor(Color.MAGENTA);
                                    changeColor(Color.MAGENTA);
                                    break;
                                default:
                                    colorShow.setBackgroundColor(Color.RED);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }

                else if(r2.isChecked()){
                    colors.setVisibility(View.GONE);
                    customColors.setVisibility(View.VISIBLE);

                    r.setOnSeekBarChangeListener(ChangeColor);
                    g.setOnSeekBarChangeListener(ChangeColor);
                    b.setOnSeekBarChangeListener(ChangeColor);

                }
            }
        });




        return view;
    }

    private SeekBar.OnSeekBarChangeListener ChangeColor=new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {


        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {


            int R,G,B;

            R = r.getProgress();
            G = g.getProgress();
            B = b.getProgress();
            int col = (0xff000000 + R * 0x10000 + G * 0x100 + B);
            changeColor(col);
            colorShow.setBackgroundColor(col);
        }
    };

    public void changeColor(int color){
        Drawable dice1 = ContextCompat.getDrawable(getActivity(), R.drawable.dice_1);
        dice1 = DrawableCompat.wrap(dice1);
        DrawableCompat.setTint(dice1,color);
        Drawable dice2 = ContextCompat.getDrawable(getActivity(), R.drawable.dice_2);
        dice2 = DrawableCompat.wrap(dice2);
        DrawableCompat.setTint(dice2,color);
        Drawable dice3 = ContextCompat.getDrawable(getActivity(), R.drawable.dice_3);
        dice3 = DrawableCompat.wrap(dice3);
        DrawableCompat.setTint(dice3,color);
        Drawable dice4 = ContextCompat.getDrawable(getActivity(), R.drawable.dice_4);
        dice4 = DrawableCompat.wrap(dice4);
        DrawableCompat.setTint(dice4,color);
        Drawable dice5 = ContextCompat.getDrawable(getActivity(), R.drawable.dice_5);
        dice5 = DrawableCompat.wrap(dice5);
        DrawableCompat.setTint(dice5,color);
        Drawable dice6 = ContextCompat.getDrawable(getActivity(), R.drawable.dice_6);
        dice6 = DrawableCompat.wrap(dice6);
        DrawableCompat.setTint(dice6,color);
    }
}
package com.example.diceroller.dicecount;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.diceroller.R;

public class ThreeDiceFragment extends Fragment {

    ImageView diceImage1, diceImage2, diceImage3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three_dice, container, false);
        setHasOptionsMenu(true);

        diceImage1 = view.findViewById(R.id.three_dice1);
        diceImage2 = view.findViewById(R.id.three_dice2);
        diceImage3 = view.findViewById(R.id.three_dice3);

        return view;
    }

}
package com.example.diceroller.dicecount;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.diceroller.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class FiveDiceFragment extends Fragment {


    ImageView diceImage1, diceImage2, diceImage3, diceImage4, diceImage5, diceImage6;
    Random random = new Random();
    int time = 1;
    Timer timer;
    Integer[] images = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_five_dice, container, false);
        setHasOptionsMenu(true);

        diceImage1 = view.findViewById(R.id.first_dice);
        diceImage2 = view.findViewById(R.id.second_dice);
        diceImage3 = view.findViewById(R.id.third_dice);
        diceImage4 = view.findViewById(R.id.fourth_dice);
        diceImage5 = view.findViewById(R.id.fifth_dice);

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_roll) {
//            ActionMenuItemView roll = getActivity().findViewById(R.id.action_roll);
//            roll.setVisibility(View.GONE);
//            ActionMenuItemView t = getActivity().findViewById(R.id.action_timer);
//            t.setVisibility(View.GONE);
//            ActionMenuItemView stop = getActivity().findViewById(R.id.action_stop);
//            stop.setVisibility(View.VISIBLE);

            timer = new Timer();
            timer.schedule(new FiveDiceFragment.RollDice(),0, 100);

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            timer.cancel();
                        }
                    },
                    (time*1000)
            );
            Log.d("Timer", "onOptionsItemSelected: Dice Rolled for secs" + time);
        }
        if(id == R.id.action_stop){
//            ActionMenuItemView roll = getActivity().findViewById(R.id.action_roll);
//            roll.setVisibility(View.VISIBLE);
//            ActionMenuItemView t = getActivity().findViewById(R.id.action_timer);
//            t.setVisibility(View.VISIBLE);
//            ActionMenuItemView stop = getActivity().findViewById(R.id.action_stop);
//            stop.setVisibility(View.GONE);
            timer.cancel();
        }


        if(id == R.id.action_1sec){
            time=1;
            Log.d("Timer", "onOptionsItemSelected: timer" + time);
        }
        if(id == R.id.action_2sec){
            time=2;
            Log.d("Timer", "onOptionsItemSelected: timer" + time);

        }
        if(id == R.id.action_3sec){
            time=3;
            Log.d("Timer", "onOptionsItemSelected: timer" + time);
        }

        return super.onOptionsItemSelected(item);
    }

    class RollDice extends TimerTask {
        private void rollDice() {
            int randomNumber1 = random.nextInt(6);
            int randomNumber2 = random.nextInt(6);
            int randomNumber3 = random.nextInt(6);
            int randomNumber4 = random.nextInt(6);
            int randomNumber5 = random.nextInt(6);
            diceImage1.setImageResource(images[randomNumber1]);
            diceImage2.setImageResource(images[randomNumber2]);
            diceImage3.setImageResource(images[randomNumber3]);
            diceImage4.setImageResource(images[randomNumber4]);
            diceImage5.setImageResource(images[randomNumber5]);
        }
        @Override
        public void run() {
            rollDice();
        }

    }
}
package com.example.diceroller.dicecount;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.diceroller.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OneDiceFragment extends Fragment {

    ImageView diceImage;
    Random random = new Random();
    int time = 1;
    Timer timer;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_dice, container, false);
        setHasOptionsMenu(true);

        diceImage = view.findViewById(R.id.one_dice);

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
            timer.schedule(new RollDice(),0, 100);

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
        if(id == R.id.action_stop) {
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


    class RollDice extends TimerTask{
        private void rollDice() {
            int randomNumber = random.nextInt(6) + 1;

            switch (randomNumber) {
                case 1:
                    diceImage.setImageResource(R.drawable.dice_1);
                    break;
                case 2:
                    diceImage.setImageResource(R.drawable.dice_2);
                    break;
                case 3:
                    diceImage.setImageResource(R.drawable.dice_3);
                    break;
                case 4:
                    diceImage.setImageResource(R.drawable.dice_4);
                    break;
                case 5:
                    diceImage.setImageResource(R.drawable.dice_5);
                    break;
                case 6:
                    diceImage.setImageResource(R.drawable.dice_6);
                    break;
            }
        }
        @Override
        public void run() {
            rollDice();
        }

    }


}
package com.example.diceroller.dicecount;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
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

public class TwoDiceFragment extends Fragment {

    ImageView diceImage1, diceImage2;
    Toolbar toolbar;
    Random random = new Random();
    int time = 1;
    Timer timer;
    Integer[] images = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two_dice, container, false);
        setHasOptionsMenu(true);
        toolbar = getActivity().findViewById(R.id.toolbar);
        diceImage1 = view.findViewById(R.id.first_dice);
        diceImage2 = view.findViewById(R.id.second_dice);

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_roll) {
            toolbar.getMenu().findItem(R.id.action_roll).setVisible(false);
            toolbar.getMenu().findItem(R.id.action_timer).setVisible(false);
            toolbar.getMenu().findItem(R.id.action_stop).setVisible(true);
            timer = new Timer();
            timer.schedule(new TwoDiceFragment.RollDice(),0, 100);

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            changeUI();
                            timer.cancel();
                        }
                    },
                    (time*1000)
            );
            Log.d("Timer", "onOptionsItemSelected: Dice Rolled for secs" + time);
        }
        if(id == R.id.action_stop){
            toolbar.getMenu().findItem(R.id.action_roll).setVisible(true);
            toolbar.getMenu().findItem(R.id.action_timer).setVisible(true);
            toolbar.getMenu().findItem(R.id.action_stop).setVisible(false);
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
            diceImage1.setImageResource(images[randomNumber1]);
            diceImage2.setImageResource(images[randomNumber2]);
        }
        @Override
        public void run() {
            rollDice();
        }

    }
    public void changeUI(){
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                toolbar.getMenu().findItem(R.id.action_roll).setVisible(true);
                toolbar.getMenu().findItem(R.id.action_timer).setVisible(true);
                toolbar.getMenu().findItem(R.id.action_stop).setVisible(false);
            }
        });
    }
}
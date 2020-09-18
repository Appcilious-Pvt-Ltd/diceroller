package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.action_one:
                diceOne();
                break;
            case R.id.action_two:
                diceTwo();
                break;
            case R.id.action_three:
                diceThree();
                break;
            case R.id.action_four:
                diceFour();
                break;
            case R.id.action_five:
                diceFive();
                break;
            case R.id.action_1sec:
                Toast.makeText(this, "Roll Time: 1 Second", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_2sec:
                Toast.makeText(this, "Roll Time: 2 Second", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_3sec:
                Toast.makeText(this, "Roll Time: 3 Second", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void diceOne() {
        Toast.makeText(this, "One Dice", Toast.LENGTH_SHORT).show();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, firstFragment);
        fragmentTransaction.commit();
    }

    private void diceTwo() {
        Toast.makeText(this, "Two Dice", Toast.LENGTH_SHORT).show();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, secondFragment);
        fragmentTransaction.commit();
    }

    private void diceThree() {
        Toast.makeText(this, "Three Dice", Toast.LENGTH_SHORT).show();

    }

    private void diceFour() {
        Toast.makeText(this, "Four Dice", Toast.LENGTH_SHORT).show();

    }

    private void diceFive() {
        Toast.makeText(this, "Five Dice", Toast.LENGTH_SHORT).show();

    }
}
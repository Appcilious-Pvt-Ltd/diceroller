package com.example.diceroller;

import android.os.Bundle;

import com.example.diceroller.dicecount.FiveDiceFragment;
import com.example.diceroller.dicecount.FourDiceFragment;
import com.example.diceroller.dicecount.OneDiceFragment;
import com.example.diceroller.dicecount.ThreeDiceFragment;
import com.example.diceroller.dicecount.TwoDiceFragment;
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

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null){
            ThreeDiceFragment threeDiceFragment = new ThreeDiceFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.nav_host_fragment, threeDiceFragment).commit();
        }
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_one) {
            Toast.makeText(this, "One Dice", Toast.LENGTH_SHORT).show();
            showFragment(new OneDiceFragment());
        }
        else if(id == R.id.action_two){
            Toast.makeText(this, "Two Dice", Toast.LENGTH_SHORT).show();
            showFragment(new TwoDiceFragment());
        }
        else if(id == R.id.action_three){
            Toast.makeText(this, "Three Dice", Toast.LENGTH_SHORT).show();
            showFragment(new ThreeDiceFragment());
        }
        else if(id == R.id.action_four){
            Toast.makeText(this, "Four Dice", Toast.LENGTH_SHORT).show();
            showFragment(new FourDiceFragment());
        }
        else if(id == R.id.action_five){
            Toast.makeText(this, "Five Dice", Toast.LENGTH_SHORT).show();
            showFragment(new FiveDiceFragment());
        }

        else if(id == R.id.action_1sec){
            Toast.makeText(this, "Roll Time  : 1 Sec", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.action_2sec){
            Toast.makeText(this, "Roll Time  : 2 Sec", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.action_3sec){
            Toast.makeText(this, "Roll Time  : 3 Sec", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
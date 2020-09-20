package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.diceroller.dicecount.FiveDiceFragment;
import com.example.diceroller.dicecount.FourDiceFragment;
import com.example.diceroller.dicecount.OneDiceFragment;
import com.example.diceroller.dicecount.ThreeDiceFragment;
import com.example.diceroller.dicecount.TwoDiceFragment;

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
        switch(item.getItemId()) {

            case R.id.action_one:
//                Toast.makeText(this, "One Dice", Toast.LENGTH_SHORT).show();
                showFragment(new OneDiceFragment());
                break;

            case R.id.action_two:
//                Toast.makeText(this, "Two Dice", Toast.LENGTH_SHORT).show();
                showFragment(new TwoDiceFragment());
                break;

            case R.id.action_three:
//                Toast.makeText(this, "Three Dice", Toast.LENGTH_SHORT).show();
                showFragment(new ThreeDiceFragment());
                break;

            case R.id.action_four :
//                Toast.makeText(this, "Four Dice", Toast.LENGTH_SHORT).show();
                showFragment(new FourDiceFragment());
                break;

            case R.id.action_five :
//                Toast.makeText(this, "Five Dice", Toast.LENGTH_SHORT).show();
                showFragment(new FiveDiceFragment());
                break;

            case R.id.action_dice_color :
//                Toast.makeText(this, "Five Dice", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, colorsActivity.class);
                startActivity(intent);
                break;

            case R.id.action_about_us :
//                Toast.makeText(this, "Five Dice", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, aboutActivity.class);
                startActivity(intent1);
                break;

            case R.id.action_1sec :
                Toast.makeText(this, "Roll Time  : 1 Sec", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_2sec :
                Toast.makeText(this, "Roll Time  : 2 Sec", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_3sec :
                Toast.makeText(this, "Roll Time  : 3 Sec", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
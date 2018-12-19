package com.example.arafat.fragmenttofragmentandalsobetweenacitivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOne.FragmentOneListener,
        FragmentTwo.FragmentTowListener {

     private FragmentOne fragmentOne;
     private FragmentTwo fragmentTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_one, fragmentOne)
                .replace(R.id.container_two, fragmentTwo)
                .commit();

    }

    @Override
    public void onInputOneSent(CharSequence input) {
        fragmentTwo.updateEditText(input);
    }

    @Override
    public void onInputTwoSent(CharSequence input) {
        fragmentOne.updateEditText(input);
    }
}

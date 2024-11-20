package com.example.hehe;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ListFragment listFragment = new ListFragment();
            listFragment.setOnItemSelectedListener(this);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_list_container, listFragment);
            transaction.commit();
        }
    }

    @Override
    public void onItemSelected(String item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (item) {
            case "Hamlet":
                transaction.replace(R.id.fragment_detail_container, new HamletFragment());
                break;
            case "King Lear":
                transaction.replace(R.id.fragment_detail_container, new KingLearFragment());
                break;
            case "Julius Caesar":
                transaction.replace(R.id.fragment_detail_container, new JuliusCaesarFragment());
                break;
        }
        transaction.commit();
    }
}


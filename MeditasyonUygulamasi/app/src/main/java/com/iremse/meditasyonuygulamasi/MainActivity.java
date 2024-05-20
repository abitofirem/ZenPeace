package com.iremse.meditasyonuygulamasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    HomeFragment homefrag;
    ArticlesFragment articlesfrag;
    TimeFragment timefrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnv=findViewById(R.id.bnb);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId(); //menüdeki idleri çekecek

                if(id==R.id.home_nb)  {
                    Fragment fragment1= new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fla,fragment1).commit();

                }
                else if(id==R.id.articles_nb) {
                    Fragment fragment2= new ArticlesFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fla,fragment2).commit();

                }
                else{
                    Fragment fragment3 = new TimeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fla, fragment3).commit();

                }




                return false;
            }
        });


    }
}
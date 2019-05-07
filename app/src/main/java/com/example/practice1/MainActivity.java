package com.example.practice1;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Fragment currentFragment;
   /* ViewPager viewPager;
    CustomSwipeAdapter customSwipeAdapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView=findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        loadFragment(null);
       /* viewPager=findViewById(R.id.viewPager);
        customSwipeAdapter=new CustomSwipeAdapter(this);
        viewPager.setAdapter(customSwipeAdapter);*/
        ImageAdapter imageAdapter;


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch(menuItem.getItemId())
            {
                case R.id.shop:
                    currentFragment=new ShopFragment();
                    loadFragment(currentFragment);
                    return true;
                    /*currentFragment=new TPFragment();
                    loadFragment(currentFragment);
                    return true;*/
                case R.id.home:
                    currentFragment=new HomeFragment();
                    loadFragment(currentFragment);
                    return true;
                case R.id.account:
                    currentFragment=new AccountBoxFragment();
                    loadFragment(currentFragment);
                    return true;
                case R.id.apps:
                    currentFragment=new AppsFragment();
                    loadFragment(currentFragment);
                    return true;
                case R.id.more:
                    currentFragment=new MoreFragment();
                    loadFragment(currentFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment f)
    {
        if(f!=null)
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,f).commit();
        else
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeFragment()).commit();
        /*fragmentTransaction.addToBackStack(null);*/
     /*   fragmentTransaction.commit();*/
    }

   /* @Override
    public void onFragmentInteraction(Uri uri) {

    }*/
}

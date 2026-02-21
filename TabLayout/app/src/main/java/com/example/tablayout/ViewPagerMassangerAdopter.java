package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMassangerAdopter extends FragmentPagerAdapter {
    public ViewPagerMassangerAdopter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //imp
        // step 7 connecting fragment according to position
       if(position==0){
           //fragment age connectin by there object
             return new AFragment();
       } else if (position==1) {
           return new BFragment();
       }else {
           return new CFragment();
       }

    }
     
    @Override
    public int getCount() {
       // step6   = 3 is  number of tab or number of fragment
        return 3;
        
    }
    //imp
    //step 8 giving titem in tablayout by using getpageTitle method
    
    @Override
    public CharSequence getPageTitle(int position) {
      if(position==0){
          return "CHATS";
      } else if (position==1) {
          return "STATUS";
      }else {
          return "CALL";
      }
    }
}

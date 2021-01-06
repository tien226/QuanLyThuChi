package com.example.assignment_mob202.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.assignment_mob202.Fragment.Fragment_Khoanthu;
import com.example.assignment_mob202.Fragment.Fragment_Loaithu;


public class PagerAdapter1 extends FragmentStatePagerAdapter {
    public PagerAdapter1(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0){
            return new Fragment_Khoanthu();
        }
        else if(i == 1){
            return new Fragment_Loaithu();
        }
        else{
            return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch(position){
            case 0:
                return "Khoản thu";
            case 1:
                return "Loại thu";
        }
        return null;
    }
}

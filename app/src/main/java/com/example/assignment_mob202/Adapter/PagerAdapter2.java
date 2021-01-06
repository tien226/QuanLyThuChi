package com.example.assignment_mob202.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import androidx.annotation.Nullable;

import com.example.assignment_mob202.Fragment.Fragment_Khoanchi;
import com.example.assignment_mob202.Fragment.Fragment_Loaichi;


public class PagerAdapter2 extends FragmentStatePagerAdapter {
    public PagerAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0){
            return new Fragment_Khoanchi();
        }
        else if(i == 1){
            return new Fragment_Loaichi();
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

        switch (position){
            case 0:
                return "Khoản chi";
            case 1:
                return "Loại chi";
        }

        return null;
    }
}

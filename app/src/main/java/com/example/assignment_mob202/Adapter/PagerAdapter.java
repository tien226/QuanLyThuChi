package com.example.assignment_mob202.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.assignment_mob202.Fragment.Fragment_Chi;
import com.example.assignment_mob202.Fragment.Fragment_Thongke;
import com.example.assignment_mob202.Fragment.Fragment_Thu;
import com.example.assignment_mob202.GioiThieuActivity;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        Fragment frag = null;
        switch (i) {
            case 0:
                frag = new Fragment_Thongke();
                break;
            case 1:
                frag = new Fragment_Thu();
                break;
            case 2:
                frag = new Fragment_Chi();
                break;
            case 3:
                frag = new GioiThieuActivity();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

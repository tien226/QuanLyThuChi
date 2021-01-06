package com.example.assignment_mob202.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.assignment_mob202.Adapter.PagerAdapter2;
import com.example.assignment_mob202.R;
import com.google.android.material.tabs.TabLayout;

public class Fragment_Chi extends Fragment {
    ViewPager pager;
    TabLayout tabLayout;
    PagerAdapter2 adapter;

    public Fragment_Chi(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chi,container,false);

        pager = view.findViewById(R.id.view_paper2);
        tabLayout = view.findViewById(R.id.tab_layout2);

        adapter = new PagerAdapter2(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);
        return view;
    }
}

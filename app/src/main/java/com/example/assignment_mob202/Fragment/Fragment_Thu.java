package com.example.assignment_mob202.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.assignment_mob202.Adapter.PagerAdapter1;
import com.example.assignment_mob202.R;
import com.google.android.material.tabs.TabLayout;

public class Fragment_Thu extends Fragment {
    TabLayout tabLayout;
    PagerAdapter1 paperadapter;
    ViewPager paper;

    public Fragment_Thu(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_thu,container,false);

        paperadapter = new PagerAdapter1(getActivity().getSupportFragmentManager());
        tabLayout = view.findViewById(R.id.tab_layout1);

        paper = view.findViewById(R.id.view_paper1);
        paper.setAdapter(paperadapter);

        tabLayout.setupWithViewPager(paper);
        return view;
    }
}

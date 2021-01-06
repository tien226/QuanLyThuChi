package com.example.assignment_mob202.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignment_mob202.Adapter.LoaiChiAdapter;
import com.example.assignment_mob202.Dulieu.LoaiChi;
import com.example.assignment_mob202.R;
import com.example.assignment_mob202.SQLite.Database;

import java.util.ArrayList;

public class Fragment_Loaichi extends Fragment {
    ListView lv_loaichi;
    ArrayList<LoaiChi> list;
    LoaiChiAdapter adapter;
    Database database;

    public Fragment_Loaichi(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_loaichi,container,false);

        lv_loaichi = view.findViewById(R.id.lv_loaichi);
        list = new ArrayList<>();
        database = new Database(getActivity());
        adapter = new LoaiChiAdapter(getActivity(), R.layout.loaichi_adapter,list);
        Cursor cursor = database.GetData("SELECT * FROM CHI");
        list.clear();
        while (cursor.moveToNext()){
            String a = cursor.getString(2);
            int b = cursor.getInt(3);
            list.add(new LoaiChi(a,b));
        }
        adapter.notifyDataSetChanged();
        lv_loaichi.setAdapter(adapter);

        return view;
    }
}

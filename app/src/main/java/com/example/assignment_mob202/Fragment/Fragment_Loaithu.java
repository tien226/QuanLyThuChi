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

import com.example.assignment_mob202.Adapter.LoaiThuAdapter;
import com.example.assignment_mob202.Dulieu.LoaiThu;
import com.example.assignment_mob202.R;
import com.example.assignment_mob202.SQLite.Database;

import java.util.ArrayList;

public class Fragment_Loaithu extends Fragment {
    Database database;
    ArrayList<LoaiThu> list;
    LoaiThuAdapter adapter;
    ListView lv_loaithu;

    public Fragment_Loaithu(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_loaithu,container,false);

        lv_loaithu = view.findViewById(R.id.lv_loaithu);
        list = new ArrayList<>();
        database = new Database(getActivity());
        adapter = new LoaiThuAdapter(getActivity(), R.layout.loaithu_adapter,list);
        Cursor cursor = database.GetData("SELECT * FROM THU");
        list.clear();
        while (cursor.moveToNext()){
            String a = cursor.getString(2);
            int b = cursor.getInt(3);
            list.add(new LoaiThu(a,b));
        }
        adapter.notifyDataSetChanged();
        lv_loaithu.setAdapter(adapter);

        return view;
    }
}

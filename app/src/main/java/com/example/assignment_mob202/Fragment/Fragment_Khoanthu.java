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

import com.example.assignment_mob202.Adapter.KhoanThuAdapter;
import com.example.assignment_mob202.Dulieu.KhoanThu;
import com.example.assignment_mob202.R;
import com.example.assignment_mob202.SQLite.Database;

import java.util.ArrayList;

public class Fragment_Khoanthu extends Fragment {
    ListView lv_khoanthu;
    ArrayList<KhoanThu> list;
    Database database;
    KhoanThuAdapter adapter;
    View view;

   public Fragment_Khoanthu(){

   }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_khoanthu,container,false);

        lv_khoanthu = view.findViewById(R.id.lv_khoanthu);
        list = new ArrayList<>();
        database = new Database(getActivity());
        adapter = new KhoanThuAdapter(getActivity(),list);
        getdata();
        lv_khoanthu.setAdapter(adapter);

        return view;
    }

    public void getdata(){
        Cursor cursor = database.GetData("SELECT * FROM THU");
        list.clear();
        while (cursor.moveToNext()){
            String a = cursor.getString(1);
            int b = cursor.getInt(3);
            list.add(new KhoanThu(a,b));
        }
        adapter.notifyDataSetChanged();
    }
}

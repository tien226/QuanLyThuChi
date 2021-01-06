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

import com.example.assignment_mob202.Adapter.ThongKeChiAdapter;
import com.example.assignment_mob202.Adapter.ThongKeThuAdapter;
import com.example.assignment_mob202.Dulieu.ThongKeChi;
import com.example.assignment_mob202.Dulieu.ThongKeThu;
import com.example.assignment_mob202.R;
import com.example.assignment_mob202.SQLite.Database;

import java.util.ArrayList;

public class Fragment_Thongke extends Fragment {
    ArrayList<ThongKeThu> list;
    ArrayList<ThongKeChi> list1;
    ThongKeThuAdapter adapter;
    ThongKeChiAdapter adapter1;
    ListView lv_thongkethu;
    ListView lv_thongkechi;
    Database database;

    public Fragment_Thongke(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_thongke,container,false);

        list = new ArrayList<>();

        lv_thongkethu = view.findViewById(R.id.lv_thongkethu);
        database = new Database(getActivity());
        adapter = new ThongKeThuAdapter(getActivity(), R.layout.thongkethu_adapter,list);
        Cursor datathongkethu = database.GetData("SELECT * FROM THU");
        list.clear();
        while (datathongkethu.moveToNext()){
            String a = datathongkethu.getString(0);
            String b = datathongkethu.getString(1);
            String c = datathongkethu.getString(2);
            list.add(new ThongKeThu(a,b,c));
        }
        adapter.notifyDataSetChanged();
        lv_thongkethu.setAdapter(adapter);

        list1 = new ArrayList<>();
        lv_thongkechi = view.findViewById(R.id.lv_thongkechi);
        adapter1 = new ThongKeChiAdapter(getActivity(), R.layout.thongkechi_adapter,list1);
        Cursor datathongkechi = database.GetData("SELECT * FROM CHI");
        list1.clear();
        while (datathongkechi.moveToNext()){
            String a = datathongkechi.getString(0);
            String b = datathongkechi.getString(1);
            String c = datathongkechi.getString(2);
            list1.add(new ThongKeChi(a,b,c));
        }
        adapter1.notifyDataSetChanged();
        lv_thongkechi.setAdapter(adapter1);
        return view;
    }
}

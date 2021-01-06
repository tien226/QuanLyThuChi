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

import com.example.assignment_mob202.Adapter.KhoanChiAdapter;
import com.example.assignment_mob202.Dulieu.KhoanChi;
import com.example.assignment_mob202.R;
import com.example.assignment_mob202.SQLite.Database;

import java.util.ArrayList;

public class Fragment_Khoanchi extends Fragment {
    KhoanChiAdapter adapter;
    ArrayList<KhoanChi> list;
    ListView lv_khoanchi;
    Database database;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_khoanchi,container,false);

        database = new Database(getActivity());
        lv_khoanchi = view.findViewById(R.id.lv_khoanchi);
        list = new ArrayList<>();
        adapter = new KhoanChiAdapter(getActivity(), R.layout.khoanchi_adapter,list);
        Cursor cursor = database.GetData("SELECT * FROM CHI");
        list.clear();
        while (cursor.moveToNext()){
            String a = cursor.getString(1);
            int b = cursor.getInt(3);
            list.add(new KhoanChi(a,b));
        }
        adapter.notifyDataSetChanged();
        lv_khoanchi.setAdapter(adapter);
        return view;
    }
}

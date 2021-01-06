package com.example.assignment_mob202.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_mob202.Dulieu.LoaiChi;
import com.example.assignment_mob202.MainActivity;
import com.example.assignment_mob202.R;
import com.example.assignment_mob202.SQLite.Database;

import java.util.List;

public class LoaiChiAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<LoaiChi> loaiChiList;

    public LoaiChiAdapter(Context context, int layout, List<LoaiChi> loaiChiList) {
        this.context = context;
        this.layout = layout;
        this.loaiChiList = loaiChiList;
    }

    @Override
    public int getCount() {
        return loaiChiList.size();
    }

    @Override
    public LoaiChi getItem(int position) {
        return loaiChiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtloaichi;
        ImageView loaichisua;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtloaichi = view.findViewById(R.id.txtloaichi);
            holder.loaichisua =view.findViewById(R.id.loaichisua);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        final LoaiChi lc = loaiChiList.get(i);
        holder.txtloaichi.setText(lc.getLoaichi());

        holder.loaichisua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua = dialog.findViewById(R.id.edt_sua);
                edtsua.setText(lc.getLoaichi());
                Button btnsua = dialog.findViewById(R.id.btn_sua);
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = edtsua.getText().toString();
                        int b = lc.getIdchi();
                        if(a.isEmpty()){
                            Toast.makeText(context, "Không để trống loại chi!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Database database = new Database(context);
                            database.SendData("UPDATE CHI SET LOAICHI = '"+a+"' WHERE IDCHI = "+b+" ");
                            Toast.makeText(context, "Cập nhật loại chi thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                        }
                    }
                });

                dialog.show();
            }
        });

        return view;
    }
}

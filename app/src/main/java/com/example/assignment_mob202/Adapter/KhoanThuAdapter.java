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

import com.example.assignment_mob202.MainActivity;
import com.example.assignment_mob202.R;
import com.example.assignment_mob202.Dulieu.KhoanThu;
import com.example.assignment_mob202.SQLite.Database;


import java.util.List;

public class KhoanThuAdapter extends BaseAdapter {
    Context context;
    List<KhoanThu> khoanThuList;

    public KhoanThuAdapter(Context context, List<KhoanThu> khoanThuList) {
        this.context = context;
        this.khoanThuList = khoanThuList;
    }

    @Override
    public int getCount() {
        return khoanThuList.size();
    }

    @Override
    public KhoanThu getItem(int position) {
        return khoanThuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        TextView txtkhoanthu;
        ImageView khoanthusua,khoanthuxoa;
    }

    @Override
    public View getView(final int i, View view, ViewGroup parent) {
        final ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.khoanthu_adapter,null);
            holder.txtkhoanthu = view.findViewById(R.id.txtkhoanthu);
            holder.khoanthusua = view.findViewById(R.id.khoanthusua);
            holder.khoanthuxoa = view.findViewById(R.id.khoanthuxoa);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        final KhoanThu kt = khoanThuList.get(i);
        holder.txtkhoanthu.setText(kt.getKhoanthu());

        holder.khoanthusua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_sua);

                final EditText edtsua = dialog.findViewById(R.id.edt_sua);
                Button btnsua = dialog.findViewById(R.id.btn_sua);
                edtsua.setText(kt.getKhoanthu());
                btnsua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int b = kt.getId();
                        String a = edtsua.getText().toString();
                        if(a.isEmpty()){
                            Toast.makeText(context, "Không để trống khoản thu!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Database database = new Database(context);
                            database.SendData("UPDATE THU SET KHOANTHU = '"+a+"' WHERE IDTHU = '"+b+"' ");
                            Toast.makeText(context, "Cập nhật khoản thu thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            ((MainActivity)context).recreate();
                        }
                    }
                });

                dialog.show();
            }
        });
        holder.khoanthuxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog1 = new Dialog(context);
                dialog1.setContentView(R.layout.dialog_xoa);
                Button btn_chapnhanxoa = dialog1.findViewById(R.id.btn_chapnhanxoa);
                Button btn_huyboxoa = dialog1.findViewById(R.id.btn_huyboxoa);

                btn_huyboxoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
                btn_chapnhanxoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Database database = new Database(context);
                        int a = kt.getId();
                        database.SendData("DELETE FROM THU WHERE IDTHU = "+a+" ");
                        dialog1.dismiss();
                        Toast.makeText(context, "Xóa thông tin thu thành công", Toast.LENGTH_SHORT).show();
                        ((MainActivity)context).recreate();
                    }
                });
                dialog1.show();
            }
        });

        return view;
    }
}

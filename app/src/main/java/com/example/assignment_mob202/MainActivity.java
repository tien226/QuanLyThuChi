package com.example.assignment_mob202;

import android.app.Dialog;
import android.os.Bundle;


import com.example.assignment_mob202.Adapter.PagerAdapter;
import com.example.assignment_mob202.SQLite.Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager pager;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        pager = findViewById(R.id.view_paper);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = new Database(MainActivity.this);
                if(pager.getCurrentItem() == 1){
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.dialog_thu);

                    final EditText edt_khoanthu = dialog.findViewById(R.id.edtkhoanthu);
                    final EditText edt_loaithu = dialog.findViewById(R.id.edtloaithu);
                    Button btnvaothu = dialog.findViewById(R.id.btnvaothu);
                    btnvaothu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a = edt_khoanthu.getText().toString();
                            String b = edt_loaithu.getText().toString();
                            String c = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                            if(a.isEmpty() || b.isEmpty()){
                                Toast.makeText(MainActivity.this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                database.SendData("INSERT INTO THU VALUES ('" + c + "','" + a + "','" + b + "', NULL)");
                                PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
                                pager.setAdapter(adapter);
                                pager.setCurrentItem(0);
                                Toast.makeText(MainActivity.this, "Thêm thông tin thu thành công", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }
                    });

                    dialog.show();
                }
                else if(pager.getCurrentItem() == 2){
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.dialog_chi);

                    final EditText edt_khoanchi = dialog.findViewById(R.id.edtkhoanchi);
                    final EditText edt_loaichi =dialog.findViewById(R.id.edtloaichi);
                    Button btnvaochi = dialog.findViewById(R.id.btnvaochi);
                    btnvaochi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String a = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                            String b = edt_khoanchi.getText().toString();
                            String c = edt_loaichi.getText().toString();
                            if(a.isEmpty() || b.isEmpty()){
                                Toast.makeText(MainActivity.this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                database.SendData("INSERT INTO CHI VALUES ('"+a+"','"+b+"','"+c+"',NULL) ");
                                PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
                                pager.setAdapter(adapter);
                                pager.setCurrentItem(0);
                                Toast.makeText(MainActivity.this, "Thêm thông tin chi thành công", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }
                    });

                    dialog.show();
                }
            }
        });
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_thongke) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(0);
        }if (id == R.id.nav_khoanthu) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(1);
        } if (id == R.id.nav_khoanchi) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(2);
        }if (id == R.id.nav_gioithieu) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(3);
        } if (id == R.id.nav_thoat) {
            finish();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

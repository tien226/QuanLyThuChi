package com.example.assignment_mob202;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class GioiThieuActivity extends Fragment {

    private TextView mTextMessage;

    private View view;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_gioithieu,container,false);
        navitionbtn();
        return view;
    }

    private void navitionbtn() {
        mTextMessage = view.findViewById(R.id.message);
        BottomNavigationView navigation = view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Trần Minh Tiến_Ph09690");
                    return true;
                case R.id.navigation_dashboard:
                    Calendar calendardate = Calendar.getInstance();
                    DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            Toast.makeText(getActivity(), dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_SHORT).show();
                        }
                    },calendardate.get(Calendar.YEAR),calendardate.get(Calendar.MONTH),calendardate.get(Calendar.DAY_OF_MONTH));
                    datePickerDialog.show();
                    return true;
                case R.id.navigation_notifications:
                    Calendar calendartime = Calendar.getInstance();
                    TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            Toast.makeText(getActivity(), hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
                        }
                    },calendartime.getTime().getHours(),calendartime.getTime().getMinutes(),false);
                    timePickerDialog.show();
                    return true;
            }
            return false;
        }
    };
}

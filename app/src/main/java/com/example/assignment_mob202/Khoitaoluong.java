package com.example.assignment_mob202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Khoitaoluong extends AppCompatActivity {
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoitaoluong);

        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                int waited = 0;
                while (waited < 2000) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waited += 100;
                }
                Intent intent = new Intent(Khoitaoluong.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        };
        thread.start();
    }
}

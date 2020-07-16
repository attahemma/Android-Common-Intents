package com.pyropy.commonintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mSetReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSetReminder = (Button) findViewById(R.id.buttonReminder);


    }

    public void visitProfile(View view){
        Intent intent = new Intent(view.getContext(),ProfileActivity.class);
        startActivity(intent);
    }

    public void onButtonReminderClick(View view){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "wake up mo'fucker")
                .putExtra(AlarmClock.EXTRA_HOUR, 12)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30)
                .putExtra(AlarmClock.EXTRA_DAYS, 1);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
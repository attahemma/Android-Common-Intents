package com.pyropy.commonintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private EditText mShareMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShareMessage = (EditText) findViewById(R.id.share_message);
    }

    public void visitProfile(View view){
        Intent intent = new Intent(view.getContext(),ProfileActivity.class);
        startActivity(intent);
    }

    public void onButtonReminderClick(View view){
        ArrayList<Integer> alarmDays = new ArrayList<>();
        alarmDays.add(Calendar.MONDAY);
        alarmDays.add(Calendar.TUESDAY);
        alarmDays.add(Calendar.WEDNESDAY);
        alarmDays.add(Calendar.THURSDAY);
        alarmDays.add(Calendar.FRIDAY);
        String message = mShareMessage.getText().toString();
        if (!(message==null || message.isEmpty()))
            InUtil.setAlarm(this,message, 05, 50, alarmDays);
        else{
            toDo("Can't create empty reminder");
        }
    }

    public void onClickSaveNote(View view){
        InUtil.createNote(this, "New Note", "The note body goes here");
    }

    private void toDo(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
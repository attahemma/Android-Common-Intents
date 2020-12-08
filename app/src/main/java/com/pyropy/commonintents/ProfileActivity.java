package com.pyropy.commonintents;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.VersionInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    }

    public void onClickCalendar(View view){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        Long dateLong = calendar.getTimeInMillis();
        InUtil.addCalendarEvent(this,"My Birthday","Kano",dateLong,dateLong);
    }

    public void onClickAddress(View view){
        String address = "008 City Gate, Anyigba, UT 84025";
        InUtil.showMap(this, Uri.parse("geo:0,0?q="+address));
    }

    public void visitSite(View view) {
        String siteUrl = "itechinstituteng.com";
        InUtil.openWebPage(this, siteUrl);
    }
}
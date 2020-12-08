package com.pyropy.commonintents;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.CalendarContract;

import com.google.android.gms.actions.NoteIntents;

import java.util.ArrayList;
import java.util.Calendar;

public class InUtil {
    private InUtil(){}

    //this method is supposed to use the implicit intent to set an alarm
    public static void setAlarm(Context context, String message, int hour, int minutes){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(context.getPackageManager()) != null){
            context.startActivity(intent);
        }
    }

    //this method is supposed to use the implicit intent to set an alarm with a title for multiple days
    public static void setAlarm(Context context, String message, int hour, int minutes, ArrayList<Integer> alarmDays){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                .putExtra(AlarmClock.EXTRA_DAYS, alarmDays);
        if (intent.resolveActivity(context.getPackageManager()) != null){
            context.startActivity(intent);
        }
    }

    //this method is supposed to use the implicit intent to set a calendar event
    public static void addCalendarEvent(Context context, String title, String location, long begin, long end){
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
                .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
                .putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public static void createNote(Context context, String subject, String text) {
        Intent intent = new Intent(NoteIntents.ACTION_CREATE_NOTE)
                .setType("text/plain")
                .putExtra(NoteIntents.EXTRA_NAME, subject)
                .putExtra(NoteIntents.EXTRA_TEXT, text);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public static void showMap(Context context, Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public static void openWebPage(Context context, String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

}

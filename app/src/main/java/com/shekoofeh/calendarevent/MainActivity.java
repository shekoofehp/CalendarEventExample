package com.shekoofeh.calendarevent;

import android.app.Activity;
import android.content.Intent;
import android.provider.CalendarContract;

import android.os.Bundle;

import java.util.Calendar;

//import static java.util.Calendar.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*{
            Intent calIntent = new Intent(Intent.ACTION_INSERT);
            calIntent.setData(CalendarContract.Events.CONTENT_URI);
            startActivity(calIntent);
        }*/
        {
            Intent calIntent = new Intent(Intent.ACTION_INSERT);
            calIntent.setType("vnd.android.cursor.item/event");
            calIntent.putExtra(CalendarContract.Events.TITLE, "My House Party");
            calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My Beach House");
            calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "A Pig Roast on the Beach");
            startActivity(calIntent);
        }
        {
            Calendar cal = java.util.Calendar.getInstance();
            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("beginTime", cal.getTimeInMillis());
            intent.putExtra("allDay", true);
            intent.putExtra("rrule", "FREQ=YEARLY");
            intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
            intent.putExtra("title", "A Test Event from android app");
            startActivity(intent);
           // <uses-permission android:name="android.permission.READ_CALENDAR" />
           // <uses-permission android:name="android.permission.WRITE_CALENDAR" />
        }

    }
}

package com.example.jason.drinkwater;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Random;

public class DrinkWater extends AppCompatActivity
{
    public String[] facts = new String[10];

    private AlarmManager alarmMgr;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // sample code for changing background
        //View view = this.getWindow().getDecorView();
        //view.setBackgroundColor(Color.LTGRAY);

        // sample code for removing action bar at top
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();
        //tools:checked="true"
        facts[0] = "A person can live about a mnth without food, but only about aweek without water.";
        facts[1] = "75% of the human brain is water and 75% of a living tree is water.";
        facts[2] = "The average human body is made of 50 to 65 percent water.";
        facts[3] = "The average total home water us for each person in the U.S. is about 50 gallons a day.";
        facts[4] = "Somewhere between 70 and 75 percent of the earth’s surface is covered with water.";
        facts[5] = "The United States uses nearly 80 percent of its water for irrigation nd thermoelectric power.";
        facts[6] = "In 2011, China reported 43 percent of state-monitored rivers were too polluted for human contact.";
        facts[7] = "In 2013, apx. 783 million people did not have access to clean water.";
        facts[8] = "Less than 1% of the water supply on earth can be used as drinking water.";
        facts[9] = "Groundwater can take a human lifetime just to traverse ONE me.";
        //facts[10] = "";
        //fact[11] = "";

        setContentView(R.layout.activity_drink_water);

        // select switch id from activity_drink_water.xml
        Switch notificationSwitch = (Switch) findViewById(R.id.notificationSwitch);

        // set switch listener
        // switch on:: set alarm manager on, set intent and notification every hour,
        // switch off:: set alarm manager off,

        Intent myIntent = new Intent(this, NoteService.class);

        boolean alarmUp = (PendingIntent.getBroadcast(DrinkWater.this, 0,
                new Intent("com.example.jason.drinkwater.NoteService"),
                PendingIntent.FLAG_NO_CREATE) != null);

        if (alarmUp)
        {
            notificationSwitch.setChecked(true);
        }
        else
        {
            notificationSwitch.setChecked(false);
        }


        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(!isChecked)
                {
                    cancelAlarm();
                    //TextView tv = (TextView)findViewById(R.id.factLabel);
                    //tv.setText("switch" + isChecked);
                }
                else
                {
                    setAlarm();
                    //TextView tv = (TextView)findViewById(R.id.factLabel);
                    //tv.setText("alarm" + isChecked);
                }
            }
        });
    }

    public void setAlarm()
    {
        Intent intent = new Intent(this, NoteService.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmMgr = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 60000, 60000, pendingIntent);
    }

    public void cancelAlarm()
    {
        alarmMgr.cancel(pendingIntent);
    }


    public void nextFactButtonClick(View p_v)
    {
        TextView tv = (TextView)findViewById(R.id.factLabel);
        Random r = new Random();
        int i = r.nextInt(10);
        while(facts[i] == tv.getText())
        {
            i = r.nextInt(10);
        }
        tv.setText(facts[i]);
    }

}

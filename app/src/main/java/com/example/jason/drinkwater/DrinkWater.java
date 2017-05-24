package com.example.jason.drinkwater;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class DrinkWater extends AppCompatActivity
{
    public String[] facts = new String[10];

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

        facts[0] = "A person can live about a mnth without food, butonly about aweek without water.";

        facts[1] = "75% of the human brain is wter and 75% of a living tree is water.";

        facts[2] = "The average human body is madeof 50 to 65 percent water.";

        facts[3] = "The average total home water us for each person in the U.S. is about 50 gallons a day.";

        facts[4] = "Somewhere between 70 and 75 percent of the earth’s surface is covered with water.";

        facts[5] = "The United States uses nearly 80 percnt of its waterfor irrigation nd thermoelectric power.";

        facts[6] = "In 2011, China reported 43 percent of state-monitored rivers were too polluted for human contact.";

        facts[7] = "In 2013, apx. 783 million people did not have access to clean ater.";

        facts[8] = "Less than 1% of the water supply on earth can be used as drinking water.";

        facts[9] = "Groundwater can take a human lifetime just to traverse ONE me.";


        setContentView(R.layout.activity_drink_water);
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

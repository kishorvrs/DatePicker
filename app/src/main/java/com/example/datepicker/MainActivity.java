package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{


    TextView datePickerText;
    AppCompatButton datePickerButton;
    Calendar calender;
    DatePickerDialog datePickerDialog;
    DatePickerDialog finalPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePickerText=(TextView)findViewById(R.id.dateTextView_id);
        datePickerButton=(AppCompatButton) findViewById(R.id.dateButton_id);

        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calender=Calendar.getInstance();
                int currentDay=calender.get(Calendar.DAY_OF_MONTH);
                int currentMonth=calender.get(Calendar.MONTH);
                int currentYear=calender.get(Calendar.YEAR);

                datePickerDialog= DatePickerDialog.newInstance(MainActivity.this,currentYear,currentMonth,currentDay);
                datePickerDialog.show(getSupportFragmentManager(),"DatePickerId");
            }
        });

        finalPicker=(DatePickerDialog)getSupportFragmentManager().findFragmentByTag("datePickerID");
        if (finalPicker!=null)finalPicker.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String date="you picked the following date: "+dayOfMonth+"/"+(++monthOfYear)+"/"+year;
        datePickerText.setText(date);

    }
}

package com.example.digiwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.BreakIterator;
import java.util.Calendar;

public class AddPlaceDetails extends AppCompatActivity {
    private Button date;
    public DatePickerDialog datepick=null;
    public TextView editdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place_details);
        date = (Button)findViewById(R.id.daypickbut);
        editdate = (TextView) findViewById(R.id.daye);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datepick = new DatePickerDialog(v.getContext(), (DatePickerDialog.OnDateSetListener) new DatePickHandler(), Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

                datepick.show();
            }
        });

        }

    }
 class DatePickHandler implements DatePickerDialog.OnDateSetListener {
    public DatePickerDialog datepick;
    public TextView editdate;

    public void onDateSet(DatePicker view, int year, int month, int day) {
        int months = month + 1;
        if ((months < 10) && (day < 10))
            editdate.setText(year + "-0" + (months) + "-0" + day);
        else if ((months < 10) && (day > 10))
            editdate.setText(year + "-0" + (months) + "-" + day);
        else if ((months > 10) && (day < 10))
            editdate.setText(year + "-" + (months) + "-0" + day);
        else
            editdate.setText(year + "-" + (months) + "-" + day);
        datepick.hide();
    }
}
package com.ap.materialdatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private Button btnShowDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDatePicker = findViewById(R.id.btnShowDatePicker);


        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("IST"));
        calendar.clear();

        Long today = MaterialDatePicker.todayInUtcMilliseconds();

//        MaterialDatePicker
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Select a Date");
        builder.setSelection(today);


        final MaterialDatePicker materialDatePicker = builder.build();

        btnShowDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });


        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

                Toast.makeText(MainActivity.this, "Date: "+materialDatePicker.getHeaderText(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
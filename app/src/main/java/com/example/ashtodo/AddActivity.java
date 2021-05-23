package com.example.ashtodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {

    ImageView imgAddSubItems;
    EditText etAddItems;
    RadioButton rbHigh,rbMedium,rbLow;
    Button btnSave;
    TextView tvCdate,tvCTime;
    EditText etTaskTitle;
    String priority,dateee,timeee,titleeee;
    int hour,minutes;


    private DatePickerDialog.OnDateSetListener datePickerDialog;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter;
    ArrayList<SubItems> todoSubItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        recyclerView = findViewById(R.id.rvSubItems);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        todoSubItems = new ArrayList<SubItems>();

        init();

        tvCTime.setText(getCurrentTime());
        tvCdate.setText(getCurrentDate());


        imgAddSubItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etAddItems.getText().toString().equals(" ") || etAddItems.getText().toString().isEmpty())
                {
                  etAddItems.setError("Enter Items");
                }
                else
                {
                    SubItems subItems = new SubItems(etAddItems.getText().toString());
                    todoSubItems.add(subItems);
                    etAddItems.setText("");

                }

            }
        });
        myAdapter = new TodoItemAdapter(AddActivity.this,todoSubItems);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        tvCdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(AddActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,datePickerDialog,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        datePickerDialog = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                 month = month +1;
                String date = getMonth(month) + dayOfMonth + "," + year;
                tvCdate.setText(date);
                dateee = date;
            }
        };

        tvCTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 //Initiazlize Time Picker
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        AddActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                //Initialize hour and minute
                                hour = hourOfDay;
                                minutes = minute;

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,hour,minutes);
                                tvCTime.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );


                timePickerDialog.updateTime(hour,minutes);
                timePickerDialog.show();


            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( isValidate())
                {
                    titleeee = etTaskTitle.getText().toString();
                    timeee = tvCTime.getText().toString();
                    dateee = tvCdate.getText().toString();

                }
                else {
                    rbHigh.setError("");
                }
            }
        });

    }//On create End

    private String getMonth(int month) {
        if(month == 1)
        {
            return "JAN";
        }
        else if(month == 2)
        {
            return "FEB";
        }
        else if(month == 3)
        {
            return "MAR";
        }
        else if(month == 4)
        {
            return "APR";
        }
        else if(month == 5)
        {
            return "MAY";
        }
        else if(month == 6)
        {
            return "JUN";
        }
        else if(month == 7)
        {
            return "JUL";
        }
     else if(month == 8)
        {
            return "AUG";
        }
     else if(month == 9)
        {
            return "SEP";
        }
     else if(month == 10)
        {
            return "OCT";
        }
     else if(month == 11)
        {
            return "NOV";
        }

      return "DEC";

    }


    void init()
    {
        imgAddSubItems = findViewById(R.id.imgAddSubItems);
        etAddItems = findViewById(R.id.etAddItems);
        rbHigh = findViewById(R.id.rbHigh);
        rbMedium = findViewById(R.id.rbMedium);
        rbLow = findViewById(R.id.rbLow);
        btnSave = findViewById(R.id.btnSave);
        tvCdate = findViewById(R.id.tvCdate);
        tvCTime = findViewById(R.id.tvCTime);
        etTaskTitle = findViewById(R.id.etTaskTitle);
    }

    boolean isValidate()
    {
        boolean flag = true;
        if(rbMedium.isChecked() == false  && rbHigh.isChecked() == false  && rbLow.isChecked() == false )
        {
            rbHigh.setError("Not checked ");
            flag = false;

        }
        else
        {
            if(rbMedium.isChecked())
            {
                priority = rbMedium.getText().toString();
                Toast.makeText(this, ""+ priority, Toast.LENGTH_SHORT).show();
            }
            if(rbHigh.isChecked())
            {
                priority = rbHigh.getText().toString();
                Toast.makeText(this, ""+ priority, Toast.LENGTH_SHORT).show();
            }
            if(rbLow.isChecked())
            {
                priority = rbLow.getText().toString();
                Toast.makeText(this, ""+ priority, Toast.LENGTH_SHORT).show();
            }

        }
        if(etTaskTitle.equals("")  || etTaskTitle.equals(" ") || etTaskTitle.equals(null) )
        {
            etTaskTitle.setError("Enter Title");
        }

        return flag;
    }


    public String getCurrentTime()
    {
        return new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
    }

    public String getCurrentDate()
    {
        return new SimpleDateFormat("LLL dd,yyyy",Locale.getDefault()).format(new Date());
    }

}
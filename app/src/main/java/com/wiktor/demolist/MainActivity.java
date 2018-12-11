package com.wiktor.demolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextNumber;
    Button add, remove, print, reset;
    TextView myList;

    ArrayList <Integer> numberList = new ArrayList <>();
    StringBuffer textFromList = new StringBuffer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.et_number);
        add = findViewById(R.id.b_add);
        remove = findViewById(R.id.b_remove);
        print = findViewById(R.id.b_print);
        myList = findViewById(R.id.tv_res);
        reset = findViewById(R.id.b_reset);

        add.setOnClickListener(this);
        remove.setOnClickListener(this);
        print.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.b_add:
                if (!editTextNumber.getText().toString().equals("")) {
                    int x = Integer.parseInt(editTextNumber.getText().toString());
                    numberList.add(x);
                } else if ((editTextNumber.getText().toString().equals(""))) {
                    myList.setText("null");
                }

                break;
            case R.id.b_remove:
                if (numberList.size() != 0) {
                    numberList.remove(0);
                }

                break;
            case R.id.b_print:
                myList.setText("");
                if (myList.getText().toString().equals("")) {
                    for (int elements : numberList) {
                        textFromList.append(elements).append(", ").append("\n");
                    }
                    myList.setText(textFromList);
                    textFromList.delete(0, textFromList.length());
                }

                //myList.setText(Integer.toString(numberList.size()) + "  " + numberList.toString());
                //myList.setText(Integer.toString(numberList.size())+"  "+Integer.toString(numberList.size()));

                break;
            case R.id.b_reset:
                myList.setText(null);
                break;
        }

    }
}

package com.slumberjer.mydialogwindowexample;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Dialog mydialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOpen = findViewById(R.id.button);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDialog();
            }
        });
    }

    private void loadDialog(){
       mydialog = new Dialog(this);
       mydialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
       mydialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
       mydialog.setContentView(R.layout.dialog_layout);
       final EditText ed1 = mydialog.findViewById(R.id.editText);
       Button btnOk = mydialog.findViewById(R.id.button2);
       btnOk.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String input = ed1.getText().toString();
               Toast.makeText(MainActivity.this, "Hello "+input, Toast.LENGTH_SHORT).show();
           }
       });
       mydialog.show();
    }
}

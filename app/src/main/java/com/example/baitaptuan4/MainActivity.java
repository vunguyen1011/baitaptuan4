package com.example.baitaptuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn1);
        tv=findViewById(R.id.tv1);
        Volleyfn vF=new Volleyfn();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vF.getJsonArrayOfObject(MainActivity.this,tv);


            }
        });
    }
}
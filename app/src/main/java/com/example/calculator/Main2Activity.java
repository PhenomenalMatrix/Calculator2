package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    static final String SHARE_KEY = "share_key";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.res);

        Intent intent = getIntent();
        if (intent !=null){
           final String s = intent.getStringExtra(SHARE_KEY);
            textView.setText(s);
            Button button = findViewById(R.id.share);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(intent.EXTRA_TEXT,s);
                    if(intent.resolveActivity(getPackageManager())!= null){
                        startActivity(intent);

                    }

                }
            });

        }


    }
}

package com.adams.topnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //member variable
    @BindView(R.id.continueButton)
    Button mContinueButton;
    @BindView(R.id.textView)
    TextView mTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Binding views
        ButterKnife.bind(this);

        //setting clickListener
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome To Top News",Toast.LENGTH_LONG).show();

                //starting another activity
            }
        });
    }
}
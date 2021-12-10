package com.adams.topnews.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adams.topnews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationActivity extends AppCompatActivity implements View.OnClickListener{


    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.locationEditText)
    EditText mLocationEditText;
    @BindView(R.id.findHomesButton)
    Button mFindHomesButton;
    @BindView(R.id.savedNewsButton) Button mSavedNewsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        //binding Views
        ButterKnife.bind(this);

        //setting clickListener
        mFindHomesButton.setOnClickListener(this);
        mSavedNewsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view == mFindHomesButton){
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
            startActivity(intent);
        }
    }
}
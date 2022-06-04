package com.tutorial2.where_here;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Rating_Bar extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView textView;
    private Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                textView.setText(String.valueOf(rating));
            }
        });
    }
}
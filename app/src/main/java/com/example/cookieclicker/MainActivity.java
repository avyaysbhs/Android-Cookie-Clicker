package com.example.cookieclicker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.mainLayout);

        TextView view = new TextView(this);
        view.setId(View.generateViewId());
        view.setText("Hello everyone!");

        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
            new ViewGroup.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT
        ));

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(view.getId(), ConstraintSet.TOP, constraintLayout.getId(), ConstraintSet.RIGHT);
        constraintSet.setHorizontalBias(view.getId(), .8f);

        constraintSet.applyTo(constraintLayout);

        view.setLayoutParams(params);
        constraintLayout.addView(view);
    }
}

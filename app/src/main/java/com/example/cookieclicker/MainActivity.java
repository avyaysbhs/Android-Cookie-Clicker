package com.example.cookieclicker;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String incrementString = "+%.1f gold!";

    private float clickPower = 1;
    private float gold = 0;

    List<ProductionAsset> assets = new ArrayList<>();

    private TextView goldView;
    private ImageButton coinButton;
    private ConstraintLayout constraintLayout;

    @SuppressLint("DefaultLocale")
    public void addIncrementParticle()
    {
        incrementGold(clickPower);
        final TextView view = new TextView(this);
        view.setId(View.generateViewId());
        view.setTextSize(24);
        view.setTextColor(Color.YELLOW);
        view.setText(String.format(incrementString, clickPower));

        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
            new ViewGroup.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT
        ));

        constraintLayout.addView(view, 1, params);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.centerVertically(
            view.getId(),
            constraintLayout.getId(),
            ConstraintSet.TOP,
            0,
            constraintLayout.getId(),
            ConstraintSet.BOTTOM,
            0,
            (float) Math.random() * .3f + .35f
        );
        constraintSet.centerHorizontally(view.getId(),
            constraintLayout.getId(),
            ConstraintSet.LEFT,
            0,
            constraintLayout.getId(),
            ConstraintSet.RIGHT,
            0,
            (float) Math.random() * .3f + .35f
        );

        constraintSet.applyTo(constraintLayout);
        view.animate().setDuration(500).alpha(1f).setStartDelay(100).translationY(-250).setListener(new FadeOutAnimation(view)).start();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.mainLayout);
        goldView = findViewById(R.id.counter);
        coinButton = findViewById(R.id.imageButton5);
        coinButton.setOnClickListener(this::onClick);

        new Thread(() ->
        {
            while (true)
            {
                try {
                    Thread.sleep(250L);
                    updateAssets(.25f);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        addIncrementParticle();
    }

    public void updateAssets(float deltaTime)
    {
        assets.forEach(e -> incrementGold(deltaTime * e.rate));
    }

    public void onClick(View v)
    {
        addIncrementParticle();
        coinButton.animate().scaleX(1.2f).scaleY(1.2f).rotation(180).setDuration(75).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                coinButton.animate().scaleX(.8f).scaleY(.8f).rotation(360).setDuration(90).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        coinButton.setRotation(0);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

    public void buyAsset(ProductionAsset asset)
    {
        if (!assets.contains(asset))
            assets.add(asset);

        float cp = 1;
        for (ProductionAsset ast: assets)
            cp += ast.clickPower;

        clickPower = cp;
    }

    public void incrementGold(float amount)
    {
        gold += amount;
        goldView.setText(gold + " gold");
    }

    class FadeOutAnimation implements Animator.AnimatorListener
    {
        private View view;

        public FadeOutAnimation(View view)
        {
            this.view = view;
        }

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            AlphaAnimation animation2 = new AlphaAnimation(1.0f, 0.0f);
            animation2.setDuration(200);
            view.startAnimation(animation2);
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}

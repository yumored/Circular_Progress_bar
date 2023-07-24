package com.example.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final newView newView=findViewById(R.id.view);
        ValueAnimator valueAnimator= ObjectAnimator.ofFloat(0,90);
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float size= (float) valueAnimator.getAnimatedValue();
                newView.set_new((int) size);
            }
        });
        valueAnimator.start();
    }
}
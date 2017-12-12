package com.example.cassandragoodby.lab8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private GestureDetector GestureDetector1;
    private ImageView img1;
    private ScaleGestureDetector ScaleDetector1;

    private int mActivePointerId = MotionEvent.INVALID_POINTER_ID;
    private float lastTouchX;
    private float lastTouchY;
    private float dblclick = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GestureDetector1 = new GestureDetector(this, new CustomGesture());

        img1 = (ImageView) findViewById(R.id.img1);

        ScaleDetector1 = new ScaleGestureDetector(this, new CustomClass());

        final View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View e, MotionEvent event) {

                GestureDetector1.onTouchEvent(event);
                ScaleDetector1.onTouchEvent(event);

                final int action = event.getActionMasked();



                switch (action) {
                    case MotionEvent.ACTION_POINTER_UP: {
                        Log.d("Gesture", "pointerup ");

                        final int pointerIndex = event.getActionIndex();
                        final int pointerId = event.getPointerId(pointerIndex);

                        if (pointerId == mActivePointerId) {
                            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                            lastTouchX = event.getX(newPointerIndex);
                            lastTouchY = event.getY(newPointerIndex);
                            mActivePointerId = event.getPointerId(newPointerIndex);
                        }
                        break;
                    }
                }
                return true;
            }
        };
        img1.setOnTouchListener(onTouchListener);
    }


    class CustomGesture extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("Gesture", "Double touch ");
            if(dblclick==0 || dblclick==1) {
                img1.setImageResource(R.drawable.img2);
                dblclick++;
            }
            else if(dblclick==2||dblclick==3){
                img1.setImageResource(R.drawable.img3);
                dblclick++;
            }
            else if(dblclick==4){
                img1.setImageResource(R.drawable.img1);
                dblclick++;
            }
            else if(dblclick==5){
                img1.setImageResource(R.drawable.img1);
                dblclick=0;
            }
            return true;
        }
    }

    class CustomClass extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private float scale = 1f;


        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale = scale * detector.getScaleFactor();
            img1.setScaleX(scale);
            img1.setScaleY(scale);
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Log.d("Gesture", "on scale begin");
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            Log.d("Gesture", "on scale end");
            img1.setScaleX(1);
            img1.setScaleY(1);
            super.onScaleEnd(detector);
        }
    }
}
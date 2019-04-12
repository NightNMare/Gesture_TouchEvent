package com.example.sunrin.chap6_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    ScrollView scrollView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        scrollView = findViewById(R.id.scrollView);
        detector = new GestureDetector(new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("onDown");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("onShowPress");

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("onSingleTapUp");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                println("onScroll");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("onLongPress");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling");
                return true;
            }
        });
        detector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                println("onSingleTapConfirmed");
                return true;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                println("onDoubleTap");
                return true;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                println("onDoubleTapEvent");
                return true;
            }
        });

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
            }
        });
    }

    float curX;
    float curY;
    String mode = "none";
    float oldDist, newDist;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        detector.onTouchEvent(event);
        //int action = event.getAction();
        /*switch (action) {
            case MotionEvent.ACTION_DOWN:
                curX = event.getX();
                curY = event.getY();
                println("손가락 누름 : " + curX + "  " + curY);
                break;
//            case MotionEvent.ACTION_MOVE:
//                println("손가락 움직임");
//                break;
            case MotionEvent.ACTION_UP:
                if (mode == "none") {
                    float diffx = curX - event.getX();
                    if (diffx > 30) {
                        println("왼쪽으로 화면을 밀었습니다.");
                    } else if (diffx < -30) {
                        println("오른쪽으로 화면을 밀었습니다.");
                    }

                    curX = event.getX();
                    curY = event.getY();
                    println("손가락 뗌 : " + curX + "  " + curY);
                }
                mode = "none";
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                mode = "zoom";
                oldDist = spacing(event);
                println("pointer_down");
                break;
            case MotionEvent.ACTION_POINTER_UP:
                newDist = spacing(event);
                if (oldDist - newDist > 30) {
                    println("축소");
                } else if (oldDist - newDist < -30) {
                    println("확대");
                }
                println("pointer_up");
                break;
        }*/
        scrollView.fullScroll(View.FOCUS_DOWN);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "pressed Back", Toast.LENGTH_SHORT).show();
            finish();
        }
        return true;
    }

    public void println(String s) {
        text1.append(s + "\n");
    }

    public float spacing(MotionEvent e) {
        float x = e.getX(0) - e.getX(1);
        float y = e.getY(0) - e.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }
}











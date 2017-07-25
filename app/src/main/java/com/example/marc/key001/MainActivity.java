package com.example.marc.key001;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView textView01;
    String TAG = "marclog";
    int counter1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView01 = (TextView) findViewById(R.id.textView01);
        String newText = textView01.getText().toString() + "\nabc";
        textView01.setText(newText);
        turnScreenOn();
        newText = textView01.getText().toString() + "\nxyz";
        textView01.setText(newText);
        textView01.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "captureButton.post is here_____");
                counter1++;
                if (counter1 == 10) {
                    Log.d(TAG, "firstTime is true");
                    finish();
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
                textView01.postDelayed(this, 200);
            }
        });
    }
    private void turnScreenOn() {
        int flags = WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON;
        try {
            getWindow().addFlags(flags);
            Log.d(TAG, "getWindow() call");
        } catch (Exception e) {
            Log.d(TAG, "Error on getWindow() call: " + e.getMessage());
        }
    }
}
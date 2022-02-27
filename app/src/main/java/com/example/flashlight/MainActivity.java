package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonFlash;
    private Flash flashClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        buttonFlash = findViewById(R.id.buttonFlash);
        flashClass = new Flash(this);
    }

    @SuppressLint("ResourceAsColor")
    public void onClickFlashButton(View view) {
        if (!flashClass.isFlash_status()) {
            flashClass.flashOn();
            buttonFlash.setText(R.string.off);
            buttonFlash.setTextColor(Color.RED);
            buttonFlash.setBackgroundResource(R.drawable.circle_red);
        } else {
            flashClass.flashOff();
            buttonFlash.setText(R.string.on);
            buttonFlash.setTextColor(Color.GREEN);
            buttonFlash.setBackgroundResource(R.drawable.circle_green);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flashClass.flashOff();
    }
}
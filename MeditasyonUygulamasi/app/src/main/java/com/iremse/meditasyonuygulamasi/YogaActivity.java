package com.iremse.meditasyonuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class YogaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        // Hareket 1
        Button hareket1Button = findViewById(R.id.hareket1);
        hareket1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YogaActivity.this, LateralWalkActivity.class);
                startActivity(intent);
            }
        });

        // Hareket 2
        Button hareket2Button = findViewById(R.id.hareket2);
        hareket2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YogaActivity.this, SquatActivity.class);
                startActivity(intent);
            }
        });

        // Hareket 3
        Button hareket3Button = findViewById(R.id.hareket3);
        hareket3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YogaActivity.this, AbsStretchActivity.class);
                startActivity(intent);
            }
        });

        // Hareket 4
        Button hareket4Button = findViewById(R.id.hareket4);
        hareket4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YogaActivity.this, BackStretchActivity.class);
                startActivity(intent);
            }
        });

        // Hareket 5
        Button hareket5Button = findViewById(R.id.hareket5);
        hareket5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YogaActivity.this, GluteBridgeActivity.class);
                startActivity(intent);
            }
        });

        // Hareket 6
        Button hareket6Button = findViewById(R.id.hareket6);
        hareket6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YogaActivity.this, PlankActivity.class);
                startActivity(intent);
            }
        });
    }
}

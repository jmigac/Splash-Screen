package com.fitapp.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.hamza.slidingsquaresloaderview.SlidingSquareLoaderView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    SlidingSquareLoaderView squareLoaderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        squareLoaderView = (SlidingSquareLoaderView) findViewById(R.id.loader);
        squareLoaderView.start();

        Thread novaDretva = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            squareLoaderView.stop();
                            startActivity(new Intent(MainActivity.this,PocetniZaslon.class));
                        }
                    });
                }
            }
        });
        novaDretva.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

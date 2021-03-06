package com.hj.hd.hhdd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by hwangil on 2018-03-13.
 */

public class IntroActivity extends AppCompatActivity{


    TextView introText;

    int flow = 0;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intro_view);

        introText = (TextView)findViewById(R.id.intro_text);

        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(2000);
        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(2000);

        Log.d("first","1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        introText.startAnimation(in);
        introText.setText("안녕하세요.");

        Log.d("second","2");

        in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                introText.startAnimation(out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                switch (flow)
                {
                    case 0:
                        introText.setText("아령하세여~?~");
                        introText.startAnimation(in);
                        flow ++;
                        break;
                    case 1:
                        introText.setText("지오니.\n\n안드로이드 언제해?");
                        introText.startAnimation(in);
                        flow ++;
                        break;
                    case 2:
                        introText.setText("스겜 부탁\n\n찡긋>_-");
                        introText.startAnimation(in);
                        flow ++;
                        break;
                    case 3:
                        introText.setText("");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        try
                        {
                            BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "/userdata/introFlag.dat", true));
                            bw.write("hihi");
                            bw.close();
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }

                        moveToMain();
                    default:
                        break;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void moveToMain ()
    {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);

        finish();
    }


}

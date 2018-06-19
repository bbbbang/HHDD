package com.hj.hd.hhdd;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.romainpiel.titanic.library.Titanic;
import com.romainpiel.titanic.library.TitanicTextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by hwangil on 2018-03-12.
 */

public class SplashActivity extends AppCompatActivity {

    TitanicTextView titanicText;

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    String flagPath;
    File files;

    String pwPath;
    File pwFiles;
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_view);

        titanicText = (TitanicTextView)findViewById(R.id.titanic_tv);
        Titanic titanic = new Titanic();

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "Satisfy-Regular.ttf"); // 폰트 설정 후
        titanicText.setTypeface(typeFace);

        String folderPath = getFilesDir() + "/userdata/";
        Log.d("loadCheck", folderPath);
        File file = new File(folderPath);

        if (!file.exists())
        {
            file.mkdirs();
        }

        titanic.start(titanicText);
        flagPath = getFilesDir() + "/userdata/introFlag.dat";
        files = new File (flagPath);

        pwPath = getFilesDir() + "/userdata/pwFlag.dat";
        pwFiles = new File (pwPath);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 2000); // 1초 후에 hd handler 실행  3000ms = 3초


    }
    private class splashhandler implements Runnable{
        public void run(){
            if (files.exists() == true)
            {// 인트로 파일이 존재할 경우
                if (pwFiles.exists() == true)
                {// 패스워드 파일이 존재할 경우
                    // 패스워드 액티비티 시작
                    try
                    {
                        BufferedReader br = new BufferedReader(new FileReader(pwPath));
                        String sendText[] = {"",""};

                        sendText[1] = br.readLine();
                        sendText[0] = "CHECK";
                        br.close();

                        Intent lockIntent = new Intent (SplashActivity.this, lockActivity.class);
                        lockIntent.putExtra("password", sendText);
                        startActivity(lockIntent);
                        finish();

                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                else
                {// 인트로 파일은 존재하지만 패스워드 파일이 존재하지 않을 경우
                    // 인트로 액티비티를 생략하고 메인 액티비티 시작
                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
            else
            {// 인트로 파일이 존재하지 않을 경우
                // 인트로 액티비티 시작
                Intent introIntent = new Intent(SplashActivity.this, IntroActivity.class);
                startActivity(introIntent);
                finish();
            }
        }
    }
    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함
    }
}
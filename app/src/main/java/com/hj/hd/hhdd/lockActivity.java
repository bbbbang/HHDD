package com.hj.hd.hhdd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by hwangil on 2018-06-19.
 */

public class lockActivity extends AppCompatActivity{

    TextView pad1;
    TextView pad2;
    TextView pad3;
    TextView pad4;
    TextView pad5;
    TextView pad6;
    TextView pad7;
    TextView pad8;
    TextView pad9;
    TextView pad0;
    TextView padDelete;

    TextView showPw1;
    TextView showPw2;
    TextView showPw3;
    TextView showPw4;

    String inputPassWord;
    int passLength;

    String correctPassWord;
    String receiveText[];
    String typeFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lock_view);

        Intent intent = getIntent();
        receiveText = intent.getStringArrayExtra("password");

        Log.d ("receiveText0", receiveText[0]);
        Log.d ("receiveText1", receiveText[1]);
        typeFlag = receiveText[0];
        correctPassWord = receiveText[1];

        inputPassWord = "";
        passLength = 0;

        pad1 = findViewById(R.id.lock_pad1);
        pad2 = findViewById(R.id.lock_pad2);
        pad3 = findViewById(R.id.lock_pad3);
        pad4 = findViewById(R.id.lock_pad4);
        pad5 = findViewById(R.id.lock_pad5);
        pad6 = findViewById(R.id.lock_pad6);
        pad7 = findViewById(R.id.lock_pad7);
        pad8 = findViewById(R.id.lock_pad8);
        pad9 = findViewById(R.id.lock_pad9);
        pad0 = findViewById(R.id.lock_pad0);
        padDelete = findViewById(R.id.lock_pad_delete);

        showPw1 = findViewById(R.id.show_password1);
        showPw2 = findViewById(R.id.show_password2);
        showPw3 = findViewById(R.id.show_password3);
        showPw4 = findViewById(R.id.show_password4);

        pad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "1";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });
        pad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "2";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });
        pad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "3";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });
        pad4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "4";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });
        pad5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "5";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });
        pad6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "6";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });
        pad7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "7";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });
        pad8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputPassWord.length() != 4)
                    passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "8";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });
        pad9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "9";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });
        pad0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                inputPassWord = inputPassWord + "0";
                switch (passLength) {
                    case 0:
                        showPw1.setText("*");
                        break;
                    case 1:
                        showPw2.setText("*");
                        break;
                    case 2:
                        showPw3.setText("*");
                        break;
                    case 3:
                        showPw4.setText("_");
                        break;
                }
            }
        });

        padDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passLength = inputPassWord.length();

                switch (passLength) {
                    case 0:
                        break;
                    case 1:
                        showPw1.setText("_");
                        inputPassWord = "";
                        break;
                    case 2:
                        showPw2.setText("_");
                        inputPassWord = inputPassWord.substring(0,1);
                        break;
                    case 3:
                        showPw3.setText("_");
                        inputPassWord = inputPassWord.substring(0,2);
                        break;
                }
            }
        });

        showPw4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("full","ffuullll");
                Log.d("typeFlag",typeFlag);
                if (typeFlag.equals("SET"))
                {
                    Log.d("SET",inputPassWord);
                    String pwPath = getFilesDir() + "/userdata/pwFlag.dat";
                    File pwFiles = new File(pwPath);

                    try
                    {
                        pwFiles.createNewFile();
                        BufferedWriter bw = new BufferedWriter(new FileWriter(pwPath));
                        bw.write(inputPassWord);

                        bw.close();

                        Intent mainIntent = new Intent(lockActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                        finish();

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }
                else if (typeFlag.equals("CHECK"))
                {
                    if (inputPassWord.equals(correctPassWord))
                    {
                        Intent mainIntent = new Intent(lockActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    }
                    else
                    {
                        Log.d("wrong~!!!!!", "WRONG~!~!~!~!~!");
                        inputPassWord = "";
                        showPw1.setText("_");
                        showPw2.setText("_");
                        showPw3.setText("_");

                        //showPw4.setText("_");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}

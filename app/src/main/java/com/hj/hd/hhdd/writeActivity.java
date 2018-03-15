package com.hj.hd.hhdd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by hwangil on 2018-03-12.
 */

public class writeActivity extends AppCompatActivity {

    TextView dateText;

    TextView backText;
    TextView confirmText;

    String context;

    EditText editContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_view);

        Intent intent = getIntent();
        final String data = intent.getStringExtra("date");

        dateText = findViewById(R.id.write_view_date);

        dateText.setText(data);

        backText = findViewById(R.id.write_view_back);
        confirmText = findViewById(R.id.write_view_confirm);

        editContext = findViewById(R.id.write_view_edit);

        backText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v)
            {
                Intent mainIntent = new Intent(v.getContext(), MainActivity.class);
                finish();
                startActivity(mainIntent);
            }
        });

        confirmText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v)
            {
                context = editContext.getText().toString();
                Intent confirmIntent = new Intent(v.getContext(), MainActivity.class);
                confirmIntent.putExtra("data", context);

                Log.d("date",data);

                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "/userdata.txt", true));
                    bw.write(data + "+" + context + "\n");
                    bw.close();
                    //FileOutputStream fos = openFileOutput("userdata.txt", Context.MODE_APPEND);
                    Log.d("파일","생성");
                    //PrintWriter out  = new PrintWriter(fos);
                    //out.println(data + "+" + context + "\n");
                    //out.close();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }


                finish();
                startActivity(confirmIntent);
            }
        });

    }
}
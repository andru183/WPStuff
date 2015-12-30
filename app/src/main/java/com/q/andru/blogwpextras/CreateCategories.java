package com.q.andru.blogwpextras;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;


/**
 * Created by Andru on 29/12/2015.
 */
public class CreateCategories extends Activity {

    static String[] items;
    Spinner dropdown;
    static TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catcreationpane);

        textView = (TextView) findViewById(R.id.textView);

        textView.setText("w");

        final HTTPGetStuff httpGetStuff = new HTTPGetStuff();

        Button button = (Button) findViewById(R.id.button);
        items = new String[]{""};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);


dropdown = (Spinner) findViewById(R.id.countryspinner);
        dropdown.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSpinner();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {


                String[] temp = httpGetStuff.getCats().split(",");

                items = new String[temp.length];
                items[0] = "New";

                for(int i = 1; i < temp.length; i++)
                {
                    items[i] = temp[i-1];
                }



                runOnUiThread(new Runnable() {
                    public void run()
                    {
                        refreshSpinner();
                    }
                });

            }
        }).start();


    }

    private void refreshSpinner()
    {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);



        dropdown.setAdapter(adapter);
    }


}

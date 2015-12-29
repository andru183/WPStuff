package com.q.andru.blogwpextras;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * Created by Andru on 29/12/2015.
 */
public class CreateCategories extends Activity {

    String[] items;
    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catcreationpane);

        dropdown = (Spinner)findViewById(R.id.countryspinner);

        HTTPGetStuff getter = new HTTPGetStuff();
        items = getter.getCats();
        //items = new String[]{"New", "2", "three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);



        //dropdown.setAdapter(adapter);





    }


}

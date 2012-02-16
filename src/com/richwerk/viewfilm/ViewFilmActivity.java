package com.richwerk.viewfilm;

import android.app.Activity;
import android.os.Bundle;

import com.richwerk.viewfilm.APIWrapper;

public class ViewFilmActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = "http://www.vam.ac.uk/api/json/museumobject/search";
        APIWrapper api = new APIWrapper();
        api.call(url);
        setContentView(R.layout.main);
    }
}

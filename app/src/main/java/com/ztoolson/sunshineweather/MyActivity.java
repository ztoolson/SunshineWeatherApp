package com.ztoolson.sunshineweather;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> mForecastAdapter;


        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

            // list to populate list view
            List<String> forecastArray = new ArrayList<String>();

            // Fill list with dummy data to display
            forecastArray.add("Today - Sunny - 88/63");
            forecastArray.add("Tomorrow - Sunny - 84/59");
            forecastArray.add("Weds - Cloudy - 73/52");
            forecastArray.add("Thurs - Rainy - 73/54");
            forecastArray.add("Fri - Partly Cloudy - 80/60");
            forecastArray.add("Sat - Sunny - 95/81");

            // initialize adapter to connect to listview to display dummy data.
            mForecastAdapter =
                    new ArrayAdapter<String>(
                    // The current context (this fragment's parent context)
                    getActivity(),
                    // ID of list item layout
                    R.layout.list_item_forecast, // refers to file where list_item_forecast is
                    // ID of the textview to populate
                    R.id.list_item_forecast_textview, // refers to specific XML element with matching attribute
                    // Forecast Data
                    forecastArray);

            // get a reference to the ListView, and attach this adapter to the ListView
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}

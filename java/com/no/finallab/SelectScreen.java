package com.no.finallab;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectScreen extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[ ] menu={"Breakfast", "Lunch", "Dinner", "Desserts", "My order"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_select_screen, R.id.foodList, menu));

    }
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        switch(position)
        {
            case 0:
                startActivity(new Intent(SelectScreen.this, Breakfast.class));
                break;

            case 1:
                startActivity(new Intent(SelectScreen.this, Lunch.class));
                break;

            case 2:
                startActivity(new Intent(SelectScreen.this, Dinner.class));
                break;

            case 3:
                startActivity(new Intent(SelectScreen.this, Dessert.class));
                break;

            case 4:
                startActivity(new Intent(SelectScreen.this, Order.class));
                break;
        }
    }

}


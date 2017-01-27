package com.no.finallab;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Breakfast extends AppCompatActivity {

    Integer[] Snacks = {R.drawable.breakfast_eggs, R.drawable.breakfast_french_toast, R.drawable.breakfast_pancakes, R.drawable.breakfast_waffles};
    String[] snackNames= {"Eggs", "French Toast", "Pancakes", "Waffles"};
    Double[] prices = {1.99, 2.99, 4.99, 3.99};
    ImageView pic;
    String chosen = null;
    double choicePrice = 0.00;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        getSupportActionBar().setTitle("Breakfast");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        Button btnBack = (Button) findViewById(R.id.back);
        Button addOrder = (Button) findViewById(R.id.buttonord);


        GridView grid = (GridView) findViewById(R.id.gridView);
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);
        //final EditText choiceBox = (EditText) findViewById(R.id.choiceBox);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // choiceBox.setText("You chose " + snackNames[position] + " for $" + prices[position]);
                Toast.makeText(getBaseContext(), "You chose " + (snackNames[position]), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Snacks[position]);
                chosen = snackNames[position];
                choicePrice = prices[position];
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle attributes = new Bundle();
                attributes.putString("breakfast", chosen);
                attributes.putDouble("breakfastPrice",choicePrice);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter
    {
        private Context context;
        public ImageAdapter(Context c)
        {
            context = c;
        }

        @Override
        public int getCount()
        {
            return Snacks.length;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View contentView, ViewGroup parent)
        {
            pic = new ImageView(context);
            pic.setImageResource(Snacks[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }

}

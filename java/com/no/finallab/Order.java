package com.no.finallab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Button getprice = (Button) findViewById(R.id.buttonprice);

        getprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView breakfastC=(TextView)findViewById(R.id.btext);
                TextView breakfastCPrice=(TextView)findViewById(R.id.bptext);

                TextView lunchC=(TextView)findViewById(R.id.ltext);
                TextView lunchCPrice=(TextView)findViewById(R.id.lptext);

                TextView dinnerC=(TextView)findViewById(R.id.dtext);
                TextView dinnerCPrice=(TextView)findViewById(R.id.dptext);

                TextView dessertC=(TextView)findViewById(R.id.dstext);
                TextView dessertCPrice=(TextView)findViewById(R.id.dsptext);
                TextView pricetextview = (TextView)findViewById(R.id.pricetext);

                Bundle attributes = getIntent().getExtras();

                String breakfastChoice = attributes.getString("Breakfast");
                Double breakfastPrice = attributes.getDouble("breakfastPrice");

                String lunchChoice = attributes.getString("Breakfast");
                Double lunchPrice = attributes.getDouble("breakfastPrice");

                String dinnerChoice = attributes.getString("Breakfast");
                Double dinnerPrice = attributes.getDouble("breakfastPrice");

                String dessertChoice = attributes.getString("Breakfast");
                Double dessertPrice = attributes.getDouble("breakfastPrice");

                breakfastC.setText(breakfastChoice);
                breakfastCPrice.setText(breakfastPrice.toString());

                lunchC.setText(lunchChoice);
                lunchCPrice.setText(lunchPrice.toString());
                dinnerC.setText(dinnerChoice);
                dinnerCPrice.setText(dinnerPrice.toString());

                dessertC.setText(dessertChoice);
                dessertCPrice.setText(dessertPrice.toString());

                RadioButton sm = (RadioButton) findViewById(R.id.small);
                RadioButton med = (RadioButton) findViewById(R.id.medium);
                RadioButton lrg = (RadioButton) findViewById(R.id.large);
                double drinkPrice=0.00;
                if(sm.isSelected() == true)
                {
                    drinkPrice = .99;
                }
                else if(med.isSelected()==true)
                {
                    drinkPrice = 1.99;
                }
                else
                {
                    drinkPrice = 2.99;
                }
                double price;
                price = breakfastPrice+lunchPrice+dinnerPrice+dessertPrice+drinkPrice;

                pricetextview.setText("Total: " + price);
            }
        });



    }
}

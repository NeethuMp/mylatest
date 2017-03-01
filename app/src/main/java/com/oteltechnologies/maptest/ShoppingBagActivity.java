package com.oteltechnologies.maptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Qvertz on 2/14/2017.
 */

public class ShoppingBagActivity extends AppCompatActivity {
    Button buyNow;
   ArrayList<ShowCementData> cement=new ArrayList<>();
    ImageView cementImage;
    TextView cementName;
    int img_id;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_bag);
        cementName=(TextView)findViewById(R.id.cement_name);
        cementImage=(ImageView)findViewById(R.id.cement_image);
       Intent intent=getIntent();
       img_id=intent.getExtras().getInt("IMAGE");
        name=intent.getStringExtra("name");
           // name=bundle.getString("name");
            cementName.setText(name);
            cementImage.setImageResource(img_id);


        buyNow= (Button) findViewById(R.id.buy_now);
        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SuccessDialogueActivity.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(getApplicationContext(),ShowCementActivity.class);
                startActivity(i);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

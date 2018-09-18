package com.example.mingi.sewoon.Shop;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mingi.sewoon.R;

import java.io.InputStream;

public class ShopDetailActivity extends AppCompatActivity {


    String name, item , location, category, phone,location2,photo;
    TextView shop_name, shop_location, shop_item, shop_category, shop_phone;
    Button callBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        shop_name = (TextView) findViewById(R.id.shop_name);
        shop_location = (TextView) findViewById(R.id.shop_location);
        shop_item = (TextView) findViewById(R.id.shop_item);
        shop_category = (TextView) findViewById(R.id.shop_category);
        shop_phone = (TextView) findViewById(R.id.shop_phone);
        callBtn = (Button) findViewById(R.id.callBtn);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        location = intent.getStringExtra("location");
        item = intent.getStringExtra("item");
        category = intent.getStringExtra("category");
        location2 = intent.getStringExtra("location2");
        phone = intent.getStringExtra("phone");
        photo = intent.getStringExtra("photo");
        Log.d("김민기", "name: "+ name);


        new ShopDetailActivity.DownloadImageTask((ImageView) findViewById(R.id.imgView))
                .execute("http://scvalsrl.cafe24.com/uploads/" + photo);

        shop_name.setText(name);
        shop_location.setText(location2);
        shop_item.setText(item);
        shop_category.setText(category);
        shop_phone.setText(phone);



        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel = "tel:" + phone;
                Intent goCall = new Intent(Intent.ACTION_CALL, Uri.parse(tel));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ShopDetailActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }
                startActivity(goCall);
            }
        });

    }

    static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

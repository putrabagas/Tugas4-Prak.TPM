package com.example.tugas4dota2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.tugas4dota2.R;

public class DetailHeroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ImageView img       = findViewById(R.id.hero_image);
        TextView nameTxt    = findViewById(R.id.hero_name);
        TextView roleTxt    = findViewById(R.id.hero_role);
        TextView loreTxt = findViewById(R.id.hero_lore);

        Bundle extras = getIntent().getExtras();

        String images  = extras.getString("IMAGE_KEY");
        String name    = extras.getString("NAME_KEY");
        String role    = extras.getString("ROLE_KEY");
        String lore = extras.getString("LORE_KEY");

        setTitle("Detail "+ name);

        img.setImageURI(Uri.parse(images));
        Glide.with(this)
                .load(images)
                .into(img);

        nameTxt.setText(name);
        roleTxt.setText(role);
        loreTxt.setText(lore);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

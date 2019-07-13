package com.steelkiwi.cropiwa.sample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.salvo.cino.PhotoApp;
import com.salvo.cino.R;
import com.steelkiwi.cropiwa.CropIwaView;
import com.steelkiwi.cropiwa.config.CropIwaSaveConfig;
import com.steelkiwi.cropiwa.shape.CropIwaOvalShape;

import java.io.File;

public class CropActivity extends AppCompatActivity {

    private static final String EXTRA_URI = "https://pp.vk.me/c637119/v637119751/248d1/6dd4IPXWwzI.jpg";

    public static Intent callingIntent(Context context, Uri imageUri) {
        Intent intent = new Intent(context, CropActivity.class);
        intent.putExtra(EXTRA_URI, imageUri);
        return intent;
    }

    private CropIwaView cropView;

    @Override
    @SuppressWarnings("ConstantConditions")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Uri imageUri = getIntent().getParcelableExtra(EXTRA_URI);
        cropView = (CropIwaView) findViewById(R.id.crop_view);
        cropView.setImageUri(imageUri);

        cropView.configureOverlay()
                .setCropShape(new CropIwaOvalShape(cropView.configureOverlay()))
                .setShouldDrawGrid(false)
//                .setMinWidth(500)
//                .setMinHeight(500)
                .apply();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_crop, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.done) {
            File file=new File(PhotoApp.getPhotoApp().getFilesDir(),
                    System.currentTimeMillis() + ".png");
            Log.d("file",file.getAbsolutePath());
            Uri destinationUri = Uri.fromFile(file);
            cropView.crop(new CropIwaSaveConfig.Builder(destinationUri)
                    .setCompressFormat(Bitmap.CompressFormat.PNG)
                    .setSize(450, 450) //Optional. If not specified, SRC dimensions will be used
                    .setQuality(100) //Hint for lossy compression formats
                    .build());
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

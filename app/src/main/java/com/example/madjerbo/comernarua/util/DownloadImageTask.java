package com.example.madjerbo.comernarua.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by felipeaquino on 22/11/15.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    String truckId;
    Storage storage;

    public DownloadImageTask(ImageView bmImage, String truckId, Storage storage) {
        this.bmImage = bmImage;
        this.truckId = truckId;
        this.storage = storage;
    }

    protected Bitmap doInBackground(String... urls) {
        URL url = null;
        Bitmap bmp = null;

        try {
            url = new URL(Helper.host + urls[0]);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bmp;
    }

    protected void onPostExecute(Bitmap result) {
        storage.saveImageLogo(this.truckId, result);
        bmImage.setImageBitmap(result);
    }
}
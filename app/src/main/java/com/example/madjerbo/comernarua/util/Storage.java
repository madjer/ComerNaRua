package com.example.madjerbo.comernarua.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ImageView;

import com.example.madjerbo.comernarua.R;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;

public class Storage {

    private static final String PREFS_NAME = "FOODTRUCK_PREFS";
    Context mContext;
    private SharedPreferences settings;

    protected static final String LOGO_KEY = "logo";

    public Storage(Context context) {
        mContext = context;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void saveImageLogo(String truckId, Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();

        String encoded = Base64.encodeToString(b, Base64.DEFAULT);

        SharedPreferences.Editor editor = settings.edit();
        editor.putString(LOGO_KEY + truckId, encoded);
        editor.commit();
    }

    public Bitmap getImageLogo(String truckId) {
        Bitmap bitmap = null;

        String encoded = settings.getString(LOGO_KEY + truckId, "");

        if (!encoded.equalsIgnoreCase("")) {
            byte[] imageAsBytes = Base64.decode(encoded, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
        }

        return bitmap;
    }

}

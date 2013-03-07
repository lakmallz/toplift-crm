package org.nobel.highriseandroid.util;

import org.nobel.highriseapi.entities.base.EntityWithImage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

public class LoadImageTask extends AsyncTask<Object, Void, Drawable> {

    private final Activity activity;
    private EntityWithImage entityWithImage;
    private ImageView imageView;

    public LoadImageTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected Drawable doInBackground(Object... parameters) {
        this.imageView = (ImageView) parameters[0];

        if (parameters.length == 3 && parameters[2] != null) {
            this.entityWithImage = (EntityWithImage) parameters[2];
        }

        return ImageUtil.createImageFromUrl((String) parameters[1]);
    }

    @Override
    protected void onPostExecute(final Drawable image) {

        if (entityWithImage != null) {
            entityWithImage.setImage(new AndroidEntityImage(image));
        }

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imageView.setImageDrawable(image);
            }
        });
    }

}
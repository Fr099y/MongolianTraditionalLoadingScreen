package fr099y.library.traditionalstyleloading.utils;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.VectorDrawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import fr099y.library.traditionalstyleloading.R;

/**
 * Created by usukhuu on 8/18/17.
 */

public class Utils {

    public static void changeColor(Drawable drawable, int color) {
        if (drawable instanceof ShapeDrawable) {
            // cast to 'ShapeDrawable'
            ShapeDrawable shapeDrawable = (ShapeDrawable) drawable;
            shapeDrawable.getPaint().setColor(color);
        } else if (drawable instanceof GradientDrawable) {
            // cast to 'GradientDrawable'
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            gradientDrawable.setColor(color);
        } else if (drawable instanceof ColorDrawable) {
            // alpha value may need to be set again after this call
            ColorDrawable colorDrawable = (ColorDrawable) drawable;
            colorDrawable.setColor(color);
        } else if (drawable instanceof VectorDrawableCompat) {
            VectorDrawableCompat vectorDrawable = (VectorDrawableCompat) drawable;
            vectorDrawable.setTint(color);
        } else if (drawable instanceof AnimatedVectorDrawableCompat) {
            AnimatedVectorDrawableCompat aVetorDrawable = (AnimatedVectorDrawableCompat) drawable;
            aVetorDrawable.setTint(color);
        }
    }
}

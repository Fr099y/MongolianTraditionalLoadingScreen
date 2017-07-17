package fr099y.library.traditionalstyleloading;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;

/**
 * Created by usukhuu on 7/4/17.
 */

public class TraditionalLoadingView extends android.support.v7.widget.AppCompatImageView {

    public TraditionalLoadingView(Context context) {
        super(context);
        init(context, null);
    }

    public TraditionalLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);


    }

    public TraditionalLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @SuppressLint("ResourceType")
    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            setAttributes(context, attrs);
        }
    }

    private void setAttributes(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TraditionalLoadingView);
        float trimStart = ta.getFloat(R.styleable.TraditionalLoadingView_trimStart, 1f);
        float trimEnd = ta.getFloat(R.styleable.TraditionalLoadingView_trimEnd, 1f);
        int pattern = ta.getInt(R.styleable.TraditionalLoadingView_pattern, -1);
        ta.recycle();
        final AnimatedVectorDrawableCompat animatedVectorDrawableCompat;

        int drawableResource = 0;
        switch (pattern) {
            case 0:
                drawableResource = R.drawable.pattern_rect_ulzii_animated;
                break;
            case 1:
                drawableResource = R.drawable.pattern_rect_ulzii_animated;
                break;
            default: break;
        }
        animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(context, drawableResource);
        animatedVectorDrawableCompat.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
            @Override
            public void onAnimationEnd(Drawable drawable) {
                super.onAnimationEnd(drawable);
                animatedVectorDrawableCompat.start();

            }
        });
        this.setImageDrawable(animatedVectorDrawableCompat);
        animatedVectorDrawableCompat.start();
//        animatedVectorDrawableCompat.start();
//        Property<AnimatedVectorDrawableCompat, Float> property = Property.of(AnimatedVectorDrawableCompat.class, Float.class, "pattern");
//        property.set(animatedVectorDrawableCompat, trimStart);
    }
}

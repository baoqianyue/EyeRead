package com.barackbao.eyeread.ui.customviews;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;



/**
 * Created by 22876 on 2018/3/17.
 */

public class ThreeDImageView extends AppCompatImageView {
    private Paint bitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private String url;
    private Camera camera = new Camera();
    private int degree1 = 45;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getDegree1() {
        return degree1;
    }

    public void setDegree1(int degree1) {
        this.degree1 = degree1;
    }

    public ThreeDImageView(Context context) {
        super(context);
    }

    public ThreeDImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ThreeDImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree1", 0, 45).setDuration(2000);
        animator.setInterpolator(new DecelerateInterpolator());
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmap.getWidth() / 2;
        int y = centerY - bitmap.getHeight() / 2;

        canvas.save();
        camera.save();
        canvas.translate(centerX, centerY);
        camera.rotateY(-degree1);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        canvas.drawBitmap(bitmap, x, y, bitmapPaint);
        camera.restore();
        canvas.restore();
        invalidate();
        animator.start();
    }
}

package me.mattak.clipview;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * ClippingHelper
 * Created by mattak on 2015/11/25.
 */
public class ClipHelper {
    public Paint paint;
    public Paint maskPaint;
    public float cornerRadius;
    public Bitmap maskBitmap;
    public float paddingRadius;

    public ClipHelper(View view, AttributeSet attrs) {
        init(view, attrs);
    }

    public void init(View view, AttributeSet attrs) {
        final TypedArray array = view.getContext().obtainStyledAttributes(attrs, R.styleable.ClipView);
        cornerRadius = array.getDimension(R.styleable.ClipView_clipRound, 0);
        paddingRadius = array.getDimension(R.styleable.ClipView_clipPadding, 0);
        array.recycle();

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        maskPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));

        view.setWillNotDraw(false);
    }

    public Bitmap createMask(int width, int height, float cornerRadius) {
        Bitmap mask = Bitmap.createBitmap(width, height, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(mask);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

        canvas.drawRect(0, 0, width, height, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawRoundRect(new RectF(paddingRadius, paddingRadius, width - paddingRadius, height - paddingRadius), cornerRadius, cornerRadius, paint);

        return mask;
    }
}
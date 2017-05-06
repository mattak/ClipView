package me.mattak.clipview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * ClipRelativeLayout
 * Created by mattak on 2015/11/25.
 */
public class ClipRelativeLayout extends RelativeLayout {
    private ClipHelper mHelper;

    public ClipRelativeLayout(Context context) {
        super(context);
        mHelper = new ClipHelper(this, null);
    }

    public ClipRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHelper = new ClipHelper(this, attrs);
    }

    public ClipRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHelper = new ClipHelper(this, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ClipRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mHelper = new ClipHelper(this, attrs);
    }

    public void draw(Canvas canvas) {
        Bitmap offscreenBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas offscreenCanvas = new Canvas(offscreenBitmap);

        super.draw(offscreenCanvas);

        if (mHelper.maskBitmap == null) {
            mHelper.maskBitmap = mHelper.createMask(canvas.getWidth(), canvas.getHeight(), mHelper.cornerRadius);
        }

        offscreenCanvas.drawBitmap(mHelper.maskBitmap, 0f, 0f, mHelper.maskPaint);
        canvas.drawBitmap(offscreenBitmap, 0f, 0f, mHelper.paint);
    }
}
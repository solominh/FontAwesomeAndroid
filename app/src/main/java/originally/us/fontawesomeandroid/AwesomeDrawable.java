package originally.us.fontawesomeandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

/**
 * Created by hoangminh on 3/8/16.
 */
public class AwesomeDrawable extends Drawable {

    private static final float PADDING_RATIO = 0.88f;

    private final Context mContext;
    private final int mIcon;
    private final Paint mPaint;
    private final int mWidth;
    private final int mHeight;
    private final float mSize;
    private final int mColor;
    private final boolean mAntiAliased;
    private final boolean mFakeBold;
    private final float mShadowRadius;
    private final float mShadowDx;
    private final float mShadowDy;
    private final int mShadowColor;

    public AwesomeDrawable(int icon, int sizeDpi, int color,
                           boolean antiAliased, boolean fakeBold, float shadowRadius,
                           float shadowDx, float shadowDy, int shadowColor, Context context) {
        super();
        this.mContext = context;
        this.mIcon = icon;
        this.mSize = dp2px(sizeDpi) * PADDING_RATIO;
        this.mHeight = dp2px(sizeDpi);
        this.mWidth = dp2px(sizeDpi);
        this.mColor = color;
        this.mAntiAliased = antiAliased;
        this.mFakeBold = fakeBold;
        this.mShadowRadius = shadowRadius;
        this.mShadowDx = shadowDx;
        this.mShadowDy = shadowDy;
        this.mShadowColor = shadowColor;

        // Paint
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setTextSize(this.mSize);
        this.mPaint.setTypeface(AwesomeFontManager.getTypeFace(context, AwesomeFontManager.FONT_AWESOME));
        this.mPaint.setAntiAlias(this.mAntiAliased);
        this.mPaint.setFakeBoldText(this.mFakeBold);
        this.mPaint.setShadowLayer(this.mShadowRadius, this.mShadowDx, this.mShadowDy, this.mShadowColor);
    }

    @Override
    public int getIntrinsicHeight() {
        return mHeight;
    }

    @Override
    public int getIntrinsicWidth() {
        return mWidth;
    }

    @Override
    public void draw(Canvas canvas) {
        float xDiff = (mWidth / 2.0f);
        String stringIcon = this.mContext.getResources().getString(mIcon);
        canvas.drawText(stringIcon, xDiff, mSize, mPaint);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

    public int dp2px(float dp) {
        return (int) (dp * mContext.getResources().getDisplayMetrics().density + 0.5f);
    }

    public static class Builder {
        private Context context;
        private int icon;
        private int sizeDpi = 32;
        private int color = Color.GRAY;
        private boolean antiAliased = true;
        private boolean fakeBold = true;
        private float shadowRadius = 0;
        private float shadowDx = 0;
        private float shadowDy = 0;
        private int shadowColor = Color.WHITE;

        public Builder(Context context, int icon) {
            this.context = context;
            this.icon = icon;
        }

        public void setSize(int size) {
            this.sizeDpi = size;
        }

        public void setColor(@ColorInt int color) {
            this.color = color;
        }

        public void setAntiAliased(boolean antiAliased) {
            this.antiAliased = antiAliased;
        }

        public void setFakeBold(boolean fakeBold) {
            this.fakeBold = fakeBold;
        }

        public void setShadow(float radius, float dx, float dy, int color) {
            this.shadowRadius = radius;
            this.shadowDx = dx;
            this.shadowDy = dy;
            this.shadowColor = color;
        }

        public AwesomeDrawable build() {
            return new AwesomeDrawable(icon, sizeDpi, color, antiAliased, fakeBold, shadowRadius, shadowDx, shadowDy, shadowColor, context);
        }
    }
}

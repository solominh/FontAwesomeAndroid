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

    private final Context context;
    private final int icon;
    private final Paint paint;
    private final int width;
    private final int height;
    private final float size;
    private final int color;
    private final boolean antiAliased;
    private final boolean fakeBold;
    private final float shadowRadius;
    private final float shadowDx;
    private final float shadowDy;
    private final int shadowColor;

    public AwesomeDrawable(int icon, int sizeDpi, int color,
                           boolean antiAliased, boolean fakeBold, float shadowRadius,
                           float shadowDx, float shadowDy, int shadowColor, Context context) {
        super();
        this.context = context;
        this.icon = icon;
        this.size = dp2px(sizeDpi) * PADDING_RATIO;
        this.height = dp2px(sizeDpi);
        this.width = dp2px(sizeDpi);
        this.color = color;
        this.antiAliased = antiAliased;
        this.fakeBold = fakeBold;
        this.shadowRadius = shadowRadius;
        this.shadowDx = shadowDx;
        this.shadowDy = shadowDy;
        this.shadowColor = shadowColor;
        this.paint = new Paint();

        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        this.paint.setColor(this.color);
        this.paint.setTextSize(this.size);

        this.paint.setTypeface(FontManager.getCachedTypeface(context, FontManager.FONT_AWESOME));
        this.paint.setAntiAlias(this.antiAliased);
        this.paint.setFakeBoldText(this.fakeBold);
        this.paint.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
    }

    @Override
    public int getIntrinsicHeight() {
        return height;
    }

    @Override
    public int getIntrinsicWidth() {
        return width;
    }

    @Override
    public void draw(Canvas canvas) {
        float xDiff = (width / 2.0f);
        String stringIcon = this.context.getResources().getString(icon);
        canvas.drawText(stringIcon, xDiff, size, paint);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    public int dp2px(float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density + 0.5f);
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

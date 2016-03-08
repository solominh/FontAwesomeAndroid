package originally.us.fontawesomeandroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by hoangminh on 3/8/16.
 */
public class AwesomeImage extends ImageView {

    private int mIcon, mColor;

    public AwesomeImage(Context context) {
        super(context);
    }

    public AwesomeImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AwesomeImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AwesomeImage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // Configurable parameters
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.fa_image, 0, 0);
        try {
            mIcon = a.getResourceId(R.styleable.fa_image_fa_icon, 0);
            mColor = a.getColor(R.styleable.fa_image_fa_color, Color.GRAY);
        } finally {
            a.recycle();
        }

        // Awesome drawable
        AwesomeDrawable.Builder builder = new AwesomeDrawable.Builder(getContext(), mIcon);
        builder.setColor(mColor);
        builder.setSize(300);
        setImageDrawable(builder.build());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
    }
}

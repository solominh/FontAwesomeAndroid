package originally.us.fontawesomeandroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.LruCache;
import android.widget.TextView;

/**
 * Created by hoangminh on 3/8/16.
 */
public class AwesomeText extends TextView{

    private static LruCache<String, Typeface> sTypefaceCache = new LruCache<>(12);

    public AwesomeText(Context context) {
        super(context);
        init();
    }

    public AwesomeText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AwesomeText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AwesomeText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        Typeface typeface = sTypefaceCache.get(FontManager.FONT_AWESOME);
        if (typeface == null) {
            typeface = FontManager.getTypeface(getContext(), FontManager.FONT_AWESOME);
            sTypefaceCache.put(FontManager.FONT_AWESOME, typeface);
        }
        setTypeface(typeface);
    }
}

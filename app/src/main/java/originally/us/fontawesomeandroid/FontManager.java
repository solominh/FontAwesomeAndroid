package originally.us.fontawesomeandroid;

import android.content.Context;
import android.graphics.Typeface;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hoangminh on 3/8/16.
 */
public class FontManager {

    public static final String ROOT = "fonts/";
    public static final String FONT_AWESOME = ROOT + "fontawesome-webfont.ttf";

    private static LruCache<String, Typeface> sTypefaceCache = new LruCache<>(12);

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }

    public static Typeface getCachedTypeface(Context context, String font) {
        Typeface typeface = sTypefaceCache.get(font);
        if (typeface == null) {
            typeface = FontManager.getTypeface(context, font);
            sTypefaceCache.put(font, typeface);
        }
        return typeface;
    }

    public static void markAsIconContainer(View v, Typeface typeface) {
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                markAsIconContainer(child, typeface);
            }
        } else if (v instanceof TextView) {
            ((TextView) v).setTypeface(typeface);
        }
    }

}
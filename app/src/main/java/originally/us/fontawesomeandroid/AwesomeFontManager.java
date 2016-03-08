package originally.us.fontawesomeandroid;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Hashtable;

/**
 * Created by hoangminh on 3/8/16.
 */
public class AwesomeFontManager {

    public static final String ROOT = "fonts/";
    public static final String FONT_AWESOME = ROOT + "fontawesome-webfont.ttf";

    private static final Hashtable<String, Typeface> sTypefaceCache = new Hashtable<>();

    public static Typeface getTypeFace(Context context, String font) {
        synchronized (sTypefaceCache) {
            Typeface typeface = sTypefaceCache.get(font);
            if (typeface == null) {
                typeface = Typeface.createFromAsset(context.getAssets(), font);
                sTypefaceCache.put(font, typeface);
            }
            return typeface;
        }
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
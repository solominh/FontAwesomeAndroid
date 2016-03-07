package originally.us.fontawesomeandroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by hoangminh on 3/8/16.
 */
public class AwesomeButton extends Button {

    public AwesomeButton(Context context) {
        super(context);
        init();
    }

    public AwesomeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AwesomeButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AwesomeButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        setTypeface(FontManager.getCachedTypeface(getContext(), FontManager.FONT_AWESOME));
    }
}
package originally.us.fontawesomeandroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by hoangminh on 3/8/16.
 */
public class AwesomeText extends TextView{

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
        setTypeface(AwesomeFontManager.getTypeFace(getContext(), AwesomeFontManager.FONT_AWESOME));
    }
}

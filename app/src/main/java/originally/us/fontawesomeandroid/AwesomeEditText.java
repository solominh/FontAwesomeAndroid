package originally.us.fontawesomeandroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by hoangminh on 3/11/16.
 */
public class AwesomeEditText extends EditText {

    public AwesomeEditText(Context context) {
        this(context, null);
    }

    public AwesomeEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AwesomeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AwesomeEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setTypeface(AwesomeFontManager.getTypeFace(context, AwesomeFontManager.FONT_AWESOME));
    }
}

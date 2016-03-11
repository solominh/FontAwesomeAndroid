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
        this(context,null);
    }

    public AwesomeButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AwesomeButton(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle,0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AwesomeButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setTypeface(AwesomeFontManager.getTypeFace(context, AwesomeFontManager.FONT_AWESOME));
    }

}
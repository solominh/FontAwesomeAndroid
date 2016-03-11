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
        this(context,null);
    }

    public AwesomeText(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AwesomeText(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AwesomeText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        setTypeface(AwesomeFontManager.getTypeFace(getContext(), AwesomeFontManager.FONT_AWESOME));
    }

}

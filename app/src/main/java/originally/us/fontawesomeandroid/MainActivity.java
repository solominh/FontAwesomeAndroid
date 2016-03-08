package originally.us.fontawesomeandroid;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface awesomeFont = AwesomeFontManager.getTypeFace(getApplicationContext(), AwesomeFontManager.FONT_AWESOME);
        AwesomeFontManager.markAsIconContainer(findViewById(R.id.icons_container), awesomeFont);

        // Awesome drawable
        AwesomeDrawable.Builder builder = new AwesomeDrawable.Builder(this, R.string.fa_facebook);
        builder.setAntiAliased(true);
        builder.setColor(Color.YELLOW);
        builder.setSize(45);

        ImageView imgTest = (ImageView) findViewById(R.id.img_test);
        imgTest.setImageDrawable(builder.build());

        TextView txtTest = (TextView) findViewById(R.id.txt_test);
        txtTest.setText(getString(R.string.fa_line_chart) +" Chart");
    }
}

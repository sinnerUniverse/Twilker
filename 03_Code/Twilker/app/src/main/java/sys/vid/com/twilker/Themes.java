package sys.vid.com.twilker;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import sys.vid.com.twilker.utils.ThemeUtils;

public class Themes extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_themes);

        findViewById(R.id.naturalbutton).setOnClickListener(this);
        findViewById(R.id.blackbutton).setOnClickListener(this);
        findViewById(R.id.bluebutton).setOnClickListener(this);
        findViewById(R.id.pinkbutton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            default:
            case R.id.naturalbutton:
                ThemeUtils.changeToTheme(this, ThemeUtils.NATURAL);
                break;
            case R.id.blackbutton:
                ThemeUtils.changeToTheme(this, ThemeUtils.BLACK);
                break;
            case R.id.bluebutton:
                ThemeUtils.changeToTheme(this, ThemeUtils.BLUE);
                break;
            case R.id.pinkbutton:
                ThemeUtils.changeToTheme(this, ThemeUtils.PINK);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

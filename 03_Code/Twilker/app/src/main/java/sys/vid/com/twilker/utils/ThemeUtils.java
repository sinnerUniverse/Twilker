package sys.vid.com.twilker.utils;

import android.app.Activity;
import android.content.Intent;

import sys.vid.com.twilker.R;

/**
 * Created by sinner_universe on 30/09/2015.
 */
public class ThemeUtils {
    private static int cTheme;
    public final static int NATURAL = 0;
    public final static int BLACK = 1;
    public final static int BLUE = 2;
    public final static int PINK = 3;

    public static void changeToTheme(Activity activity, int theme) {
        cTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (cTheme) {
            default:
            case NATURAL:
                activity.setTheme(R.style.Natural);
                break;
            case BLACK:
                activity.setTheme(R.style.Black);
                break;
            case BLUE:
                activity.setTheme(R.style.Blue);
                break;
            case PINK:
                activity.setTheme(R.style.Pink);
                break;
        }
    }
}

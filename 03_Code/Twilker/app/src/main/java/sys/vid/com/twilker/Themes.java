package sys.vid.com.twilker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import sys.vid.com.twilker.utils.ThemeUtils;

public class Themes extends Activity {
    private int originalTheme = 0;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PackageInfo packageInfo;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_META_DATA);
            originalTheme = packageInfo.applicationInfo.theme;
        } catch (Exception e) {
            originalTheme = 0;
        }
        ThemeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_themes);

        spinner = (Spinner) findViewById(R.id.static_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.themes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String selState = (String) spinner.getSelectedItem();
                if(selState.equalsIgnoreCase("Seleccione un tema"))
                    return;
                if(selState.equalsIgnoreCase("Natural"))
                    ThemeUtils.changeToTheme(Themes.this, ThemeUtils.NATURAL);
                else if(selState.equalsIgnoreCase("Dark"))
                    ThemeUtils.changeToTheme(Themes.this, ThemeUtils.BLACK);
                else if(selState.equalsIgnoreCase("Blue"))
                    ThemeUtils.changeToTheme(Themes.this, ThemeUtils.BLUE);
                else if(selState.equalsIgnoreCase("Pink"))
                    ThemeUtils.changeToTheme(Themes.this, ThemeUtils.PINK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                applyTheme();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        applyTheme();
    }

    private void applyTheme() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.leave_title);
        alertDialog.setMessage(R.string.apply_theme);

        alertDialog.setPositiveButton(R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent intent = new Intent(getBaseContext(), Splash.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton(R.string.no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        clearTheme();
                        finish();
                    }
                });
        alertDialog.show();
    }

    private void clearTheme() {
        ThemeUtils.changeToTheme(originalTheme);
    }
}

package sys.vid.com.twilker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by extsistmovilidad31 on 22/09/2015.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    try {
                        Intent intent = new Intent(Splash.this, MainTwilker.class);
                        startActivity(intent);
                        Splash.this.finish();
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}

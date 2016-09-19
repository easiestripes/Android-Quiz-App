package cloyster.android_mini_app_cloyster;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

/**
 * Sources used:
 * http://www.viralandroid.com/2015/09/simple-android-tabhost-and-tabwidget-example.html
 * http://stackoverflow.com/questions/3328757/how-to-click-or-tap-on-a-textview-text
 */

public class MainActivity extends AppCompatActivity {
    public String quiz1Result;
    public QuizProvider qp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        // Unfinished Tab
        TabHost.TabSpec spec = host.newTabSpec("Unfinished");
        spec.setContent(R.id.unfinished);
        spec.setIndicator("Unfinished");
        host.addTab(spec);

        // Finished Tab
        spec = host.newTabSpec("Finished");
        spec.setContent(R.id.finished);
        spec.setIndicator("Finished");
        host.addTab(spec);
    }

    public void startQuiz1(View v) {
        Intent intent = new Intent(MainActivity.this, Quiz_1.class);
        startActivity(intent);
    }

    public void startQuiz2(View v) {
        Intent intent = new Intent(MainActivity.this, Quiz_2.class);
        startActivity(intent);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2){
           quiz1Result = data.getStringExtra("RESULT");
            Toast.makeText(this, quiz1Result, Toast.LENGTH_SHORT).show();
        }

    }
    public void onResume(View v){
        Toast.makeText(this, quiz1Result, Toast.LENGTH_SHORT).show();

    }
}

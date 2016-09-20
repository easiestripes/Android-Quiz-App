package cloyster.android_mini_app_cloyster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Sources used:
 * http://www.viralandroid.com/2015/09/simple-android-tabhost-and-tabwidget-example.html
 * http://stackoverflow.com/questions/3328757/how-to-click-or-tap-on-a-textview-text
 */

public class MainActivity extends AppCompatActivity {
    public String quiz1Result, quiz2Result;
    public ArrayList<String> unfinishedStringList, finishedStringList;
    public ArrayAdapter unfin_adapter, fin_adapter;
    public int currPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        // UNFINISHED TAB
        LinearLayout unfinished = (LinearLayout)findViewById(R.id.unfinished);
        unfinishedStringList = new ArrayList<String>();
        unfinishedStringList.add("Myers Briggs Quiz");
        unfinishedStringList.add("Music Quiz");
        unfin_adapter = new ArrayAdapter<String>(this, R.layout.unfinished_text_layout, unfinishedStringList);

        ListView unfinishedListView = (ListView) findViewById(R.id.unfinishedListView);
        unfinishedListView.setAdapter(unfin_adapter);

        TabHost.TabSpec spec = host.newTabSpec("Unfinished");
        spec.setContent(unfinished.getId());
        spec.setIndicator("Unfinished");
        host.addTab(spec);

        // FINISHED TAB
        LinearLayout finished = (LinearLayout)findViewById(R.id.finished);
        finishedStringList = new ArrayList<String>();
        fin_adapter = new ArrayAdapter<String>(this, R.layout.finished_text_layout, finishedStringList);

        ListView finishedListView = (ListView) findViewById(R.id.finishedListView);
        finishedListView.setAdapter(fin_adapter);

        spec = host.newTabSpec("Finished");
        spec.setContent(finished.getId());
        spec.setIndicator("Finished");
        host.addTab(spec);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        finishedStringList.add(unfinishedStringList.get(currPos));
        fin_adapter.notifyDataSetChanged();

        unfinishedStringList.remove(currPos);
        unfin_adapter.notifyDataSetChanged();

        if(requestCode == 0)
            quiz1Result = data.getStringExtra("RESULT");
        else if(requestCode == 1)
            quiz2Result = data.getStringExtra("RESULT");
    }

    public void displayToast(View v) {
        int pos = ((ListView) findViewById(R.id.finishedListView)).getPositionForView(v);
        String title = finishedStringList.get(pos);

        if(title.equals("Myers Briggs Quiz"))
            Toast.makeText(this, "Myers Briggs Results: " + quiz1Result, Toast.LENGTH_LONG).show();
        else if(title.equals("Music Quiz"))
            Toast.makeText(this, "Music Trivia Results: " + quiz2Result, Toast.LENGTH_LONG).show();
    }

    public void startQuiz(View v) {
        Intent intent = null;
        int resultCode = -1;
        int pos = ((ListView) findViewById(R.id.unfinishedListView)).getPositionForView(v);
        String title = unfinishedStringList.get(pos);

        if(title.equals("Myers Briggs Quiz")) {
            intent = new Intent(MainActivity.this, Quiz_1.class);
            resultCode = 0;
        } else if(title.equals("Music Quiz")) {
            intent = new Intent(MainActivity.this, Quiz_2.class);
            resultCode = 1;
        }

        currPos = pos;
        startActivityForResult(intent, resultCode);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}

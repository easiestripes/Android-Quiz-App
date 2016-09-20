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
    public String quiz1Result;
    public QuizProvider qp;
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
        unfinishedStringList.add("Quiz 1");
        unfinishedStringList.add("Quiz 2");

        ListArrayAdapter test = new ListArrayAdapter(this, unfinishedStringList);

        unfin_adapter = new ArrayAdapter<String>(this, R.layout.unfinished_text_layout, unfinishedStringList);

        ListView unfinishedListView = (ListView) findViewById(R.id.unfinishedListView);
        unfinishedListView.setAdapter(unfin_adapter);

        TabHost.TabSpec spec = host.newTabSpec("Unfinished");
        spec.setContent(unfinished.getId());
        spec.setIndicator("Unfinished");
        host.addTab(spec);

        unfinishedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                int pos1 = ((ListView) findViewById(R.id.unfinishedListView)).getPositionForView(v);
                Log.i("TEST", "Position: " + pos1);
            }
        });

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

    public void displayToast(View v) {
        int pos = ((ListView) findViewById(R.id.finishedListView)).getPositionForView(v);
        Log.i("TEST", "Position: " + pos);
    }

    public void startQuiz(View v) {
        Intent intent = null;
        int pos = ((ListView) findViewById(R.id.unfinishedListView)).getPositionForView(v);

        if(pos == 0)
            intent = new Intent(MainActivity.this, Quiz_1.class);
        else if(pos == 1)
            intent = new Intent(MainActivity.this, Quiz_2.class);

        currPos = pos;
        startActivityForResult(intent, currPos);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        finishedStringList.add(unfinishedStringList.get(currPos));
        fin_adapter.notifyDataSetChanged();

        unfinishedStringList.remove(currPos);
        unfin_adapter.notifyDataSetChanged();

        if(requestCode == 0) {
            quiz1Result = data.getStringExtra("RESULT");
            Toast.makeText(this, quiz1Result, Toast.LENGTH_SHORT).show();
        }
    }
}

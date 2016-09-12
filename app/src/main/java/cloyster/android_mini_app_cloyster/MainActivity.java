package cloyster.android_mini_app_cloyster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, ArrayList<String>> quizMap;
    String finished, unfinished;
    ArrayList<String> quizProgress;
    ExpandableListView expandList;
    QuizzesAdapter adapter;
// test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandList = (ExpandableListView) findViewById(R.id.expandableListView);
        quizMap = QuizProvider.getInfo();
        quizProgress = new ArrayList<String>(quizMap.keySet());

        /*finished = "Finished";
        unfinished = "Unfinished";
        //quizProgress = new ArrayList<Quiz>(QuizProvider.getQuizzes());

        // using Strings for quick testing purposes
        quizProgress = new ArrayList<String>();
        quizProgress.add("Quiz 1");
        quizProgress.add("Quiz 2");
        quizProgress.add("Quiz 3");*/

        adapter = new QuizzesAdapter(this, quizMap, quizProgress);
        expandList.setAdapter(adapter);

        expandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Toast.makeText(getApplicationContext(), "id" + id, Toast.LENGTH_SHORT).show();
                startQuiz(v, id);
                return true;
            }
        });
    }

    public void startQuiz(View view, long id) {
        Intent intent = null;
        if(id == 0)
            intent = new Intent(MainActivity.this, Quiz_1.class);
        else if(id == 1)
            intent = new Intent(MainActivity.this, Quiz_2.class);
        startActivity(intent);
    }
}

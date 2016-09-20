package cloyster.android_mini_app_cloyster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.content.Intent;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.app.ProgressDialog;

import java.net.URI;
import java.util.List;

public class Quiz_1 extends AppCompatActivity {
    private MyersBriggsQuiz mb;
    private List<QuizQuestion> qq;
    private int i;
    private Button b1;
    private Button b2;
    private TextView q;
    private ProgressBar prog;
    private ProgressDialog progress;
    private int progessStatus = 0;
    private static final int PROGRESS = 0x1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_1);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mb = new MyersBriggsQuiz();
        mb.resetResults();
        qq = mb.getQuestions();
        View view = this.findViewById(android.R.id.content).getRootView();
        q = (TextView)view.findViewById(R.id.textView2);
        b1=(Button)view.findViewById(R.id.button);
        b2=(Button)view.findViewById(R.id.button2);
        prog =(ProgressBar)view.findViewById(R.id.progressBar);
        prog.setMax(qq.size());
        final int totalProgressTime = qq.size();

        nextQuestion(i, b1, b2, q);
        i = 0;
        b1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                mb.recordResponse(qq.get(i), qq.get(i).getAnswers()[0]);
                i++;
                prog.setProgress(i);
                nextQuestion(i, b1, b2, q);
            }
        });
        b2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                mb.recordResponse(qq.get(i), qq.get(i).getAnswers()[1]);
                i++;
                prog.setProgress(i);
                nextQuestion(i, b1, b2, q);
            }
        });
    }

    public void nextQuestion(int i, Button b1, Button b2, TextView q){
        if(i == qq.size()) {
            q.setText("Your score is: " + mb.getResult());
            b2.setVisibility(View.GONE);
            b1.setText("Tap here to go back to the home screen!");
            b1.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent data = new Intent();
                    String text = mb.getResult();
                    data.putExtra("RESULT", text);
                    setResult(0, data);
                    finish();
                }
            });
        } else {
            String quest = qq.get(i).getText();
            String C1 = qq.get(i).getAnswers()[0].getText();
            String C2 = qq.get(i).getAnswers()[1].getText();
            q.setText(quest);
            b1.setText(C1);
            b2.setText(C2);
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}

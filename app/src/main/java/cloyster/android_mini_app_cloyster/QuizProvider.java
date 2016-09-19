package cloyster.android_mini_app_cloyster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by main-mini on 9/6/16.
 */
public class QuizProvider {

    public static HashMap<String, ArrayList<String>> getInfo() {
        HashMap<String, ArrayList<String>> quizMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> finished_quizzes = new ArrayList<String>();
        ArrayList<String> unfinished_quizzes = new ArrayList<String>();

        unfinished_quizzes.add("Quiz 1");
        unfinished_quizzes.add("Quiz 2");
        quizMap.put("Unfinished", unfinished_quizzes);
        quizMap.put("Finished", finished_quizzes);

        return quizMap;
    }

    public static ArrayList<Quiz> getQuizzes() {
        ArrayList<Quiz> quizzes = new ArrayList<Quiz>();

        // Fill in with Quiz objects once they are made

        return quizzes;
    }

}

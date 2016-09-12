package cloyster.android_mini_app_cloyster;

/**
 * Created by matthewleon on 9/6/16.
 */
import java.util.List;

public interface Quiz {
    String getName();
    String getResult();

    //void recordResponse(QuizQuestion q, QuizEntity a);
    void resetResults();
    //List<QuizQuestion> getQuestions();
}

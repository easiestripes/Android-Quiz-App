package cloyster.android_mini_app_cloyster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicQuiz implements Quiz{
    // Types for each question
    private static final int TYPE_A = 1;
    private static final int TYPE_B = 1;
    private static final int TYPE_C = 1;
    private static final int TYPE_D = 1;
    private static final int TYPE_E = 1;
    private static final int TYPE_F = 1;
    private static final int TYPE_G = 1;
    private static final int TYPE_H = 1;

    // Categories for each answer
    private static final int CATEGORY_A = 1;
    private static final int CATEGORY_B = 0;

    // List containing 70 Musics questions
    private List<QuizQuestion> questionList;
    public List<QuizQuestion> getQuestions() {
        return this.questionList;
    }

    private class Question implements QuizQuestion{
        String questionText;
        Answer answers[];
        int type;

        public Question(String questionText, Answer answers[], int type) {
            this.questionText = questionText;
            this.answers = answers;
            this.type = type;
        }


        public QuizEntity[] getAnswers()
        {
            return answers;
        }

        public String getText()
        {
            return questionText;
        }
    }

    private class Answer implements QuizEntity{
        String answerText;
        int category;

        public Answer(String answerText, int category) {
            this.answerText = answerText;
            this.category = category;
        }

        public String getText()
        {
            return answerText;
        }
    }

    // Array for tracking quiz results
    private int results;

    public MusicQuiz() {
        resetResults();

        // Init list of questions in the C constructor
        questionList = new ArrayList<QuizQuestion>(Arrays.asList(
                new Question(
                        "What year was Revolver by The Beatles released?",
                        new Answer[]{
                                new Answer("1964", CATEGORY_B),
                                new Answer("1966", CATEGORY_A)
                        },
                        TYPE_A
                ),
                new Question(
                        "Who was the drummer for The Who?",
                        new Answer[]{
                                new Answer("John Bonham", CATEGORY_B),
                                new Answer("Keith Moon", CATEGORY_A)
                        },
                        TYPE_B
                ),
                new Question(
                        "Who played bass for Led Zeppelin?",
                        new Answer[]{
                                new Answer("John Paul Jones", CATEGORY_A),
                                new Answer("Jimmy Page", CATEGORY_B)
                        },
                        TYPE_C
                ),
                new Question(
                        "Who was The Beatles' Producer?",
                        new Answer[]{
                                new Answer("Brian Epstein", CATEGORY_B),
                                new Answer("George Martin", CATEGORY_A)
                        },
                        TYPE_D
                ),
                new Question(
                        "Who killed Marvin Gaye?",
                        new Answer[]{
                                new Answer("His Father", CATEGORY_A),
                                new Answer("His Brother", CATEGORY_B)
                        },
                        TYPE_E
                ),
                new Question(
                        "Which of these is one of Frank Zappa's children?",
                        new Answer[]{
                                new Answer("Dweezil Zappa", CATEGORY_A),
                                new Answer("Dzimble Zappa", CATEGORY_B)
                        },
                        TYPE_F
                ),
                new Question(
                        "Who was Ziggy Stardust?",
                        new Answer[]{
                                new Answer("Mark Bolan", CATEGORY_B),
                                new Answer("David Bowie", CATEGORY_A)
                        },
                        TYPE_G
                ),
                new Question(
                        "Who produced The Velvet Underground's first album?",
                        new Answer[]{
                                new Answer("Lou Reed", CATEGORY_B),
                                new Answer("Andy Warhol", CATEGORY_A)
                        },
                        TYPE_H
                ),
                new Question(
                        "Who was the bassist for The Jimi Hendrix Experience?",
                        new Answer[]{
                                new Answer("Noel Redding", CATEGORY_A),
                                new Answer("Mitch Mitchell", CATEGORY_B)
                        },
                        TYPE_G
                ),
                new Question(
                        "At what rate does a standard LP spin?",
                        new Answer[]{
                                new Answer("45 RPM", CATEGORY_B),
                                new Answer("33 1/3 RPM", CATEGORY_A)
                        },
                        TYPE_G
                )
        ));
    }

    public String getName()
    {
        return "Music Quiz";
    }

    public String getResult()
    {
        if (results == questionList.size()){
            return "You're a music whiz!";
        }
        else if (results >= questionList.size()*.8){
            return "You really know your stuff!";
        }
        else if (results >= questionList.size()*.6){
            return "You should brush up on a few classic albums";
        }
        else if (results >= questionList.size()*.4){
            return "Better study up!";
        }
        else {
            return "You've got some serious work to do...";
        }
    }

    public void recordResponse(QuizQuestion q, QuizEntity a)
    {
        Question question = (Question)q;
        Answer answer = (Answer)a;
        results += (answer.category * question.type);
    }

    public void resetResults()
    {
        // Reset the results to 0
        results = 0;

    }
}

package cloyster.android_mini_app_cloyster;

/**
 * Created by matthewleon on 9/6/16.
 */import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class musicQuiz implements Quiz{

    // Categories for each answer
    private static final int WRONG = 0;
    private static final int RIGHT = 1;

    // List containing questions
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
    private int[] results;

    public musicQuiz() {
        resetResults();

        // Init list of questions in the C constructor
        questionList = new ArrayList<QuizQuestion>(Arrays.asList(
                new Question(
                        "At a party do you:",
                        new Answer[]{
                                new Answer("Interact with many, including strangers", WRONG),
                                new Answer("Interact with a few, known to you", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Are you more:",
                        new Answer[]{
                                new Answer("Realistic than speculative", WRONG),
                                new Answer("Speculative than realistic", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Is it worse to:",
                        new Answer[]{
                                new Answer("Have your \"head in the clouds\"", WRONG),
                                new Answer("Be \"in a rut\"", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more impressed by:",
                        new Answer[]{
                                new Answer("Principles", WRONG),
                                new Answer("Emotions", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are more drawn toward the:",
                        new Answer[]{
                                new Answer("Convincing", WRONG),
                                new Answer("Touching", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you prefer to work:",
                        new Answer[]{
                                new Answer("To deadlines", WRONG),
                                new Answer("Just \"whenever\"", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you tend to choose:",
                        new Answer[]{
                                new Answer("Rather carefully", WRONG),
                                new Answer("Somewhat impulsively", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "At parties do you:",
                        new Answer[]{
                                new Answer("Stay late, with increasing energy", WRONG),
                                new Answer("Leave early with decreased energy", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Are you more attracted to:",
                        new Answer[]{
                                new Answer("Sensible people", WRONG),
                                new Answer("Imaginative people", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more interested in:",
                        new Answer[]{
                                new Answer("What is actual", WRONG),
                                new Answer("What is possible", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "In judging others are you more swayed by:",
                        new Answer[]{
                                new Answer("Laws than circumstances", WRONG),
                                new Answer("Circumstances than laws", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "In approaching others is your inclination to be somewhat:",
                        new Answer[]{
                                new Answer("Objective", WRONG),
                                new Answer("Personal", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you more:",
                        new Answer[]{
                                new Answer("Punctual", WRONG),
                                new Answer("Leisurely", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Does it bother you more having things:",
                        new Answer[]{
                                new Answer("Incomplete", WRONG),
                                new Answer("Completed", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "In your social groups do you:",
                        new Answer[]{
                                new Answer("Keep abreast of other’s happenings", WRONG),
                                new Answer("Get behind on the news", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "In doing ordinary things are you more likely to:",
                        new Answer[]{
                                new Answer("Do it the usual way", WRONG),
                                new Answer("Do it your own way", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Writers should:",
                        new Answer[]{
                                new Answer("\"Say what they mean and mean what they say\"", WRONG),
                                new Answer("Express things more by use of analogy", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which appeals to you more:",
                        new Answer[]{
                                new Answer("Consistency of thought", WRONG),
                                new Answer("Harmonious human relationships", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you more comfortable in making:",
                        new Answer[]{
                                new Answer("Logical judgments", WRONG),
                                new Answer("Value judgments", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you want things:",
                        new Answer[]{
                                new Answer("Settled and decided", WRONG),
                                new Answer("Unsettled and undecided", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Would you say you are more:",
                        new Answer[]{
                                new Answer("Serious and determined", WRONG),
                                new Answer("Easy-going", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "In phoning do you:",
                        new Answer[]{
                                new Answer("Rarely question that it will all be said", WRONG),
                                new Answer("Rehearse what you’ll say", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Facts:",
                        new Answer[]{
                                new Answer("\"Speak for themselves\"", WRONG),
                                new Answer("Illustrate principles", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are visionaries:",
                        new Answer[]{
                                new Answer("somewhat annoying", WRONG),
                                new Answer("rather fascinating", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more often:",
                        new Answer[]{
                                new Answer("a cool-headed person", WRONG),
                                new Answer("a warm-hearted person", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Is it worse to be:",
                        new Answer[]{
                                new Answer("unjust", WRONG),
                                new Answer("merciless ", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Should one usually let events occur:",
                        new Answer[]{
                                new Answer("by careful selection and choice", WRONG),
                                new Answer("randomly and by chance", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you feel better about:",
                        new Answer[]{
                                new Answer("having purchased", WRONG),
                                new Answer("having the option to buy", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "In company do you:",
                        new Answer[]{
                                new Answer("initiate conversation", WRONG),
                                new Answer("wait to be approached", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Common sense is:",
                        new Answer[]{
                                new Answer("rarely questionable", WRONG),
                                new Answer("frequently questionable", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Children often do not:",
                        new Answer[]{
                                new Answer("make themselves useful enough", WRONG),
                                new Answer("exercise their fantasy enough", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "In making decisions do you feel more comfortable with:",
                        new Answer[]{
                                new Answer("standards", WRONG),
                                new Answer("feelings", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you more:",
                        new Answer[]{
                                new Answer("firm than gentle", WRONG),
                                new Answer("gentle than firm", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Which is more admirable:",
                        new Answer[]{
                                new Answer("the ability to organize and be methodical", WRONG),
                                new Answer("the ability to adapt and make do", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you put more value on:",
                        new Answer[]{
                                new Answer("infinite", WRONG),
                                new Answer("open-minded", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Does new and non-routine interaction with others:",
                        new Answer[]{
                                new Answer("stimulate and energize you", WRONG),
                                new Answer("tax your reserves", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Are you more frequently:",
                        new Answer[]{
                                new Answer("a practical sort of person", WRONG),
                                new Answer("a fanciful sort of person", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more likely to:",
                        new Answer[]{
                                new Answer("see how others are useful", WRONG),
                                new Answer("see how others see", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which is more satisfying:",
                        new Answer[]{
                                new Answer("to discuss an issue thoroughly", WRONG),
                                new Answer("to arrive at agreement on an issue", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Which rules you more:",
                        new Answer[]{
                                new Answer("your head", WRONG),
                                new Answer("your heart", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you more comfortable with work that is:",
                        new Answer[]{
                                new Answer("contracted", WRONG),
                                new Answer("done on a casual basis", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you tend to look for:",
                        new Answer[]{
                                new Answer("the orderly", WRONG),
                                new Answer("whatever turns up", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you prefer:",
                        new Answer[]{
                                new Answer("many friends with brief contact", WRONG),
                                new Answer("a few friends with more lengthy contact", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Do you go more by:",
                        new Answer[]{
                                new Answer("facts", WRONG),
                                new Answer("principles", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you more interested in:",
                        new Answer[]{
                                new Answer("production and distribution", WRONG),
                                new Answer("design and research", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which is more of a compliment:",
                        new Answer[]{
                                new Answer("\"There is a very logical person.\"", WRONG),
                                new Answer("\"There is a very sentimental person.\"", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you value in yourself more that you are:",
                        new Answer[]{
                                new Answer("unwavering", WRONG),
                                new Answer("devoted", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you more often prefer the",
                        new Answer[]{
                                new Answer("final and unalterable statement", WRONG),
                                new Answer("tentative and preliminary statement", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Are you more comfortable:",
                        new Answer[]{
                                new Answer("after a decision", WRONG),
                                new Answer("before a decision", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you:",
                        new Answer[]{
                                new Answer("speak easily and at length with strangers", WRONG),
                                new Answer("find little to say to strangers", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Are you more likely to trust your:",
                        new Answer[]{
                                new Answer("experience", WRONG),
                                new Answer("hunch", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Do you feel:",
                        new Answer[]{
                                new Answer("more practical than ingenious", WRONG),
                                new Answer("more ingenious than practical", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which person is more to be complimented – one of:",
                        new Answer[]{
                                new Answer("clear reason", WRONG),
                                new Answer("strong feeling ", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Are you inclined more to be:",
                        new Answer[]{
                                new Answer("fair-minded", WRONG),
                                new Answer("sympathetic", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Is it preferable mostly to:",
                        new Answer[]{
                                new Answer("make sure things are arranged", WRONG),
                                new Answer("just let things happen", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "In relationships should most things be:",
                        new Answer[]{
                                new Answer("re-negotiable", WRONG),
                                new Answer("random and circumstantial", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "When the phone rings do you:",
                        new Answer[]{
                                new Answer("hasten to get to it first", WRONG),
                                new Answer("hope someone else will answer", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Do you prize more in yourself:",
                        new Answer[]{
                                new Answer("a strong sense of reality", WRONG),
                                new Answer("a vivid imagination", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Are you drawn more to:",
                        new Answer[]{
                                new Answer("fundamentals", WRONG),
                                new Answer("overtones", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which seems the greater error:",
                        new Answer[]{
                                new Answer("to be too passionate", WRONG),
                                new Answer("to be too objective", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you see yourself as basically:",
                        new Answer[]{
                                new Answer("hard-headed", WRONG),
                                new Answer("soft-hearted", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Which situation appeals to you more:",
                        new Answer[]{
                                new Answer("the structured and scheduled", WRONG),
                                new Answer("the unstructured and unscheduled", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Are you a person that is more:",
                        new Answer[]{
                                new Answer("routinized than whimsical", WRONG),
                                new Answer("whimsical than routinized", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Are you more inclined to be:",
                        new Answer[]{
                                new Answer("easy to approach", WRONG),
                                new Answer("somewhat reserved", RIGHT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "In writings do you prefer:",
                        new Answer[]{
                                new Answer("the more literal", WRONG),
                                new Answer("the more figurative", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Is it harder for you to:",
                        new Answer[]{
                                new Answer("identify with others", WRONG),
                                new Answer("utilize others", RIGHT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Which do you wish more for yourself:",
                        new Answer[]{
                                new Answer("clarity of reason", WRONG),
                                new Answer("strength of compassion", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Which is the greater fault:",
                        new Answer[]{
                                new Answer("being indiscriminate", WRONG),
                                new Answer("being critical", RIGHT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "Do you prefer the:",
                        new Answer[]{
                                new Answer("planned event", WRONG),
                                new Answer("unplanned event", RIGHT)
                        },
                        TYPE_JP
                ),
                new Question(
                        "Do you tend to be more:",
                        new Answer[]{
                                new Answer("deliberate than spontaneous", WRONG),
                                new Answer("spontaneous than deliberate ", RIGHT)
                        },
                        TYPE_JP
                )
        ));
    }

    public String getName()
    {
        return "MyersBriggsQuiz";
    }

    public String getResult()
    {
        int idxE = musicQuiz.WRONG * 4 + musicQuiz.TYPE_EI;
        int idxI = musicQuiz.RIGHT * 4 + musicQuiz.TYPE_EI;
        int idxS = musicQuiz.WRONG * 4 + musicQuiz.TYPE_SN;
        int idxN = musicQuiz.RIGHT * 4 + musicQuiz.TYPE_SN;
        int idxT = musicQuiz.WRONG * 4 + musicQuiz.TYPE_TF;
        int idxF = musicQuiz.RIGHT * 4 + musicQuiz.TYPE_TF;
        int idxJ = musicQuiz.WRONG * 4 + musicQuiz.TYPE_JP;
        int idxP = musicQuiz.RIGHT * 4 + musicQuiz.TYPE_JP;

        StringBuilder sb = new StringBuilder()
                .append(results[idxE] > results[idxI] ? "E" : "I")
                .append(results[idxS] > results[idxN] ? "S" : "N")
                .append(results[idxT] > results[idxF] ? "T" : "F")
                .append(results[idxJ] > results[idxP] ? "J" : "P");

        return sb.toString();
    }

    public void recordResponse(QuizQuestion q, QuizEntity a)
    {
        Question question = (Question)q;
        Answer answer = (Answer)a;
        results[answer.category * 4 + question.type] += 1;
    }

    public void resetResults()
    {
        // Reset the results to 0
        results = new int[2 * 4];
        for (int i = 0; i < results.length; i++) {
            results[i] = 0;
        }
    }
}


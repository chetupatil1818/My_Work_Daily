import java.util.*;
// Quiz App With Timer
class Question {
    String question;
    String[] options;
    int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;
    private int totalQuestions;
    private Scanner sc;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
        this.totalQuestions = questions.size();
        this.sc = new Scanner(System.in);
    }

    public void start() {
        for (int i = 0; i < totalQuestions; i++) {
            presentQuestion(i + 1, questions.get(i));
        }
        displayResult();
    }

    private void presentQuestion(int questionNumber, Question question) {
        System.out.println("Question " + questionNumber + ": " + question.question);
        for (int i = 0; i < question.options.length; i++) {
            System.out.println((i + 1) + ": " + question.options[i]);
        }

        int userAnswer = getUserAnswerWithTimer();
        if (userAnswer == question.correctAnswer) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer was: " + question.options[question.correctAnswer - 1]);
        }
        System.out.println();
    }

    private int getUserAnswerWithTimer() {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\nTime's up!");
                System.exit(0); 
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 10000); 

        int answer = sc.nextInt();
        timer.cancel();
        return answer;
    }

    private void displayResult() {
        System.out.println("Quiz Over!");
        System.out.println("You scored " + score + " out of " + totalQuestions + "!");
    }
}

public class Task_4 {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Lisbon"}, 3));
        questions.add(new Question("What is the largest planet in the Solar System?", new String[]{"Earth", "Jupiter", "Saturn", "Mars"}, 2));
        questions.add(new Question("Who wrote 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "Jane Austen", "Mark Twain", "Charles Dickens"}, 1));
        
        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}

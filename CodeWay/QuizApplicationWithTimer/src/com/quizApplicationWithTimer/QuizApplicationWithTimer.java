package com.quizApplicationWithTimer;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplicationWithTimer {
    private static final int QUESTION_COUNT = 3;  // Adjust the number of questions as needed
    private static final int TIME_LIMIT_SECONDS = 10;  // Set the time limit for each question

    private static String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "What is the largest mammal in the world?"
    };

    private static String[][] options = {
            {"A) Berlin", "B) Paris", "C) Madrid", "D) Rome"},
            {"A) Venus", "B) Mars", "C) Jupiter", "D) Saturn"},
            {"A) Elephant", "B) Blue Whale", "C) Giraffe", "D) Dolphin"}
    };

    private static int[] correctAnswers = {1, 2, 1};  // Index of the correct option for each question

    private static int userScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz!");
        System.out.println("You have " + TIME_LIMIT_SECONDS + " seconds to answer each question.");

        for (int i = 0; i < QUESTION_COUNT; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            displayOptions(options[i]);

            Timer timer = new Timer();
            AnswerTask answerTask = new AnswerTask(scanner, i);
            timer.schedule(answerTask, TIME_LIMIT_SECONDS * 1000);

            int userAnswer = getUserAnswer(scanner);

            timer.cancel();  // Cancel the timer once the user has answered

            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!\n");
                userScore++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + options[i][correctAnswers[i] - 1] + "\n");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your final score is: " + userScore + "/" + QUESTION_COUNT);
    }

    private static void displayOptions(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    private static int getUserAnswer(Scanner scanner) {
        System.out.print("Enter your choice (A, B, C, or D): ");
        String userChoice = scanner.nextLine().toUpperCase();
        return userChoice.charAt(0) - 'A' + 1;
    }

    static class AnswerTask extends TimerTask {
        private Scanner scanner;
        private int questionIndex;

        public AnswerTask(Scanner scanner, int questionIndex) {
            this.scanner = scanner;
            this.questionIndex = questionIndex;
        }

        @Override
        public void run() {
            System.out.println("Time's up! You didn't answer question " + (questionIndex + 1) + ".");
            System.exit(0);
        }
    }
}

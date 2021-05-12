/*-------------------------------------------------------------------------
// AUTHOR: Dawson Black
// FILENAME: QuizData.java
// SPECIFICATION: a class that computes the high and low scores on each quiz and the average of each quiz. Also it calculates the student's average quiz grade with the lowest quiz grade dropped. In addition, it prints the file "quiz.txt" and averages all the scores of all quizzes.
// FOR: CSE 110- homework #8 MWF 2:00pm-2:50pm
// TIME SPENT: 2 hours
//----------------------------------------------------------------------*/

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class QuizData
{
	// declaring the variables
	private double [][] quizGrades;
	private int numStudents;
	private int numQuizzes;

	// finds the file "quiz.txt" and reads it. Then it puts the numbers into the array, quizGrades
	public QuizData( String filename )
	{
		try
		{
			FileReader fr = new FileReader(filename);
			Scanner scan = new Scanner (fr);
			BufferedReader inFile = new BufferedReader(fr);

	        numStudents = scan.nextInt();
	        numQuizzes = scan.nextInt();

	        quizGrades = new double [numStudents][numQuizzes];


			for ( int i = 0; i < numStudents; i++ )
			{
				for ( int j = 0; j < numQuizzes; j++ )
				{
					double input = scan.nextDouble();
					quizGrades[i][j] = input;
				}
			}


			inFile.close();
		}

		catch (IOException exception)
		{
			System.out.println(exception);
		}
	}

	// computes the averages of all the scores of all the quizzes
	public double quizAverage()
	{
		double total = numStudents*numQuizzes;
		double allQuizzes = 0;

		for ( int i = 0; i < numStudents; i++ )
		{
			for ( int j = 0; j < numQuizzes; j++ )
			{
				allQuizzes += quizGrades[i][j];
			}
		}

		return ( allQuizzes / total );
	}

	// computes each student's average quiz grade with the lowest quiz grade dropped
	public String studentStatistics()
	{
		DecimalFormat fmt = new DecimalFormat("0.0");

		String answer = "Student  Average\n======   ========\n";

		int h = 0;

		for ( int row = 0; row < numStudents; row++ )
		{
			double average = 0.0;
			double lowest = quizGrades[row][h];

			for ( int column = 0; column < numQuizzes; column++ )
			{
				if ( quizGrades[row][column] < lowest )
				{
					lowest = quizGrades[row][column];
				}

				average += quizGrades[row][column];
			}

			average -= lowest;
			average = average / (numQuizzes - 1);

			answer += (row + 1) + "        " + fmt.format(average) + "\n";
		}

		return answer;
	}

	// computes the highest and lowest grade on each quiz and the students' average on each quiz.
	public String quizStatistics()
	{
		DecimalFormat fmt = new DecimalFormat("0.0");

		String answer = "Quiz  High   Low    Average\n====  ====   ====   =======\n";

		int i = 0;

		for ( int column = 0; column < numQuizzes; column++ )
		{
			double high = quizGrades[i][column];
			double low = quizGrades[i][column];
			double average = 0.0;

			for ( int row = 0; row < numStudents; row++ )
			{
				if ( quizGrades[row][column] > high )
				{
					high = quizGrades[row][column];
				}

				if ( quizGrades[row][column] < low )
				{
					low = quizGrades[row][column];
				}

				average += quizGrades[row][column];
			}

			i++;

			average = average / numStudents;

			answer += (column + 1) + "     " + high + "   " + low + "   " + fmt.format(average) + "\n";
		}

		return (answer);
	}

	// prints the all the quiz scores of all the students
	public String toString()
	{
		String answer = "";

		for ( int i = 0; i < numStudents; i++ )
		{
			answer += i + "  ";

			for ( int j = 0; j < numQuizzes; j++ )
			{
				answer += quizGrades[i][j] + "  ";
			}

			answer += "\n";
		}

		return (answer);
	}
}
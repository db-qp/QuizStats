/*-------------------------------------------------------------------------
// AUTHOR: Dawson Black
// FILENAME: Assignment8.java
// SPECIFICATION: This is the test driver for QuizData class. It provides the student and quiz statistics for a class. It reads the data from a file that includes the studens' quiz scores
// FOR: CSE 110- homework #8 MWF 2:00pm-2:50pm
// TIME SPENT: 2 hours
//----------------------------------------------------------------------*/

import java.text.DecimalFormat;
import java.io.*;

public class Assignment8
{
	public static void main( String [] args )
	{
		// create a new QuizData object by passing the file name
		QuizData studentData = new QuizData("quiz.txt");

		DecimalFormat average = new DecimalFormat("0.00");

		// prints the scores for all the students
		System.out.println(studentData.toString());

		// prints the average of the quiz scores, no quiz is dropped
		System.out.println("\nAverage of all quizzes (no quiz dropped) = " + average.format( studentData.quizAverage() ));

		// prints the high and low grade on the quiz and the average of the quiz
		System.out.println("\nStatistics for each quiz\n");
		System.out.println( studentData.quizStatistics());

		// prints the student number and his/her average on the quizzes with the lowest one dropped
		System.out.println("\nA Statistics for each student\n");
		System.out.println( studentData.studentStatistics());
	}
}
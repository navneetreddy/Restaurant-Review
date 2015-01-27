///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RestaurantReview.java
// File:             ReviewIO.java
// Semester:         CS302 Spring 2013
//
// Author:           Navneet Reddy
// CS Login:         navneet
// Lecturer's Name:  Deb Deppeler
// Lab Section:      326
//
//                   PAIR PROGRAMMERS COMPLETE THIS SECTION
// Pair Partner:     Evan Hofmeister
// CS Login:         hofmeister
// Lecturer's Name:  Deb Deppeler
// Lab Section:      322
//
//                   STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
// Credits:          N/A
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;
import java.io.*;

/**
 * Handles importing and exporting reviews.
 * 
 * @author NavneetReddy
 * @author EvanHofmeister
 * 
 */
public class ReviewIO 
{
	//Declare a counter to keep track of unique id numbers.
	private static int Id;
	//Declare an array list for reviews read in from a file.
	private ArrayList<String> reviewStringList;
	//Declare a 2D array to parse data from imported reviews into.
	private String [][] reviewParse;
	
	/**
	 * Constructs a new input output object for reviews.
	 */
	public ReviewIO()
	{
		//Initiates the unique id to zero.
		Id = 0;
		reviewStringList = new ArrayList<String>();
	}

	/**
	 * Writes all the reviews in the data base to a file.
	 * 
	 * @param filename
	 *            Filename of the file to write the reviews into.
	 * @param reviewStore
	 *            Instance to be able to refer to the ReviewStorage class.
	 */
	public void writeToFile(String filename, ReviewStorage reviewStore) 
	{
		try 
		{
			// Declare and create a new PrintWriter.
			PrintWriter printWriter = new PrintWriter(filename);

			// Loop to run through all the reviews in the data base.
			for (int i = 0; i < reviewStore.getReviewList().size(); i++) 
			{
				// Write the elements of the reviews
				// into the file separated by commas.
				printWriter.println(reviewStore.getReview(i).getReviewer()
						+ "," + reviewStore.getReview(i).getRestaurant()
						+ "," + reviewStore.getReview(i).getRating() + ","
						+ reviewStore.getReview(i).getComment() + ","
						+ reviewStore.getReview(i).getRecommendedLetter());
			}

			// Close the PrintWriter.
			printWriter.close();
		}
		// Catch the file not found exception.
		catch (FileNotFoundException e) 
		{
			System.out.println("Error writing to file.");
		}
	}
	
	/**
	 * Read data from a file and store as reviews.
	 * 
	 * @param filename
	 *            Filename of the file to read data from.
	 * @param reviewStore
	 *            Instance to be able to refer to the ReviewStorage class.
	 */
	public void readFromFile(String filename, ReviewStorage reviewStore)
	{
		//Declare variables to store review elements from the file.
		Review review;
		String restaurant;
		String reviewer;
		int rating;
		String comment;
		String recommendation;
		char recommended;
		Boolean recommendedBoolean;
		
		try
		{
			//Declare and initialize a new file.
			File fileImport = new File(filename);
			
			//Declare and connect a scanner to a file to read from.
			Scanner fileScnr = new Scanner(fileImport);
			
			//Check if the file has another line of data.
			while (fileScnr.hasNextLine())
				//Add the line of data to array list of the review data
				//as strings.
				reviewStringList.add(fileScnr.nextLine());
			
			//Initialize the columns of the 2D array to the 
			//number of reviews in the file.
			reviewParse = new String[reviewStringList.size()][];
			
			//Loop to go through each of the reviews in the file.
			for (int i = 0; i < reviewStringList.size(); i++)
				//Split the string of review elements into separate elements.
				reviewParse[i] = reviewStringList.get(i).split(",");
			
			//Loop to go through each of the reviews in the file.
			for (int i = 0; i < reviewParse.length; i++)
			{
				//Store each of the elements of the review in their 
				//corresponding variables, in the correct type.
				reviewer = reviewParse[i][0];
				restaurant = reviewParse[i][1];
				rating = Integer.parseInt(reviewParse[i][2]);
				comment = reviewParse[i][3];
				recommendation = reviewParse[i][4];
				recommended = recommendation.charAt(0);
				
				//Check if the recommended letter is a 'y'.
				if (Character.toUpperCase(recommended) == 'Y')
					recommendedBoolean = true;
				else
					recommendedBoolean = false;
				
				//Create a new review with the review elements in the file.
				review = new Review(restaurant, reviewer, rating, comment,
						recommendedBoolean, Id);
				//Add the review to the data base of reviews.
				reviewStore.addReview(review);
				
				//Increment the unique id.
				Id++;
			}
			
			//Close the scanner connected to the file.
			fileScnr.close();
		}
		//Catch the file not found exception.
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to find file.");
		}
	}
}

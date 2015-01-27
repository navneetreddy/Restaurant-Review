///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RestaurantReview.java
// File:             ReviewStorage.java
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

import java.util.ArrayList;

/**
 * Data base where reviews are stored.
 * 
 * @author NavneetReddy
 * @author EvanHofmeister
 * 
 */
public class ReviewStorage 
{
	//Declare an array list for reviews.
	private ArrayList<Review> review;
	
	/**
	 * Constructs a new array list to store reviews.
	 */
	public ReviewStorage()
	{
		review = new ArrayList<Review>();
	}
	
	/**
	 * Adds a new review to the array list of reviews.
	 * 
	 * @param r Review to be added to the array list of reviews.
	 */
	public void addReview(Review r)
	{
		//Add the given review to the data base.
		review.add(r);
	}
	
	/**
	 * Get a certain review from the array list of reviews.
	 * 
	 * @param i Index of the review in the array list of reviews.
	 */
	public Review getReview(int i)
	{
		return review.get(i);
	}
	
	/**
	 * Search for a review in the data base.
	 * 
	 * @return The index of the review in the array list of reviews.
	 */
	public int searchForReview()
	{
		//Declare and create an array list to keep track of restaurants.
		ArrayList<String> reviewedRest = new ArrayList<String>();
		//Declare and create an array list to keep track of restaurants.
		ArrayList<String> reviewedReviewer = new ArrayList<String>();
		
		//Declare and initialize a variable to store 
		//user input for the restaurant.
		int choiceRestaurant = 0;
		//Declare and initialize a variable to store 
		//user input for the reviewer.
		int choiceReviewer = 0;
		
		System.out.println("Select a restaurant:");

		//Loop to run through all the reviews in the data base.
		for (int i = 0; i < getReviewList().size(); i++)
		{
			//Check if the restaurant has not been printed already.
			if (!reviewedRest.contains(getReview(i).getRestaurant()))
			{
				//Add the restaurant to the array list of restaurants 
				//that have been printed.
				reviewedRest.add(getReview(i).getRestaurant());
				
				//Print the restaurant name in a numbered format.
				System.out.println(reviewedRest.size() + 
						". " + getReview(i).getRestaurant());
			}
		}
		
		//Get user input for the choice of restaurant
		//and check if the input is valid and within the range of the choices.
		choiceRestaurant = RestaurantReview.errorCheck(1,reviewedRest.size());

		System.out.println("Select a Review");
		
		// Loop to run through all the reviews in the data base.
		for (int i = 0; i < getReviewList().size(); i++) 
		{
			String restaurantX = getReview(i).getRestaurant();

			// Check if the user choice of restaurant is the restaurant at
			// i-1 in the array list of reviews.
			if (restaurantX.equals(reviewedRest.get(choiceRestaurant - 1))) 
			{
				// Add the reviewer to the array list of reviewers
				// that have been printed.
				reviewedReviewer.add(getReview(i).getReviewer());
				
				// Print the reviewer name in a numbered format.
				System.out.println(reviewedReviewer.size() + ". "
						+ getReview(i).getReviewer() + ", "
						+ getReview(i).getUniqueID());
			}
		}
		
		// Get user input for the choice of reviewer
		// and check if the input is valid and within the range of the choices.
		choiceReviewer = RestaurantReview.errorCheck(1,reviewedReviewer.size());

		// Loop to run through all the reviews in the data base.
		for (int i = 0; i < getReviewList().size(); i++) 
		{
			String restaurantX = getReview(i).getRestaurant();
			String reviewerX = getReview(i).getReviewer();

			// Check if the chosen restaurant and the chosen reviewer
			// match the review at the i index of the array list of reviews.
			if (restaurantX.equals(reviewedRest.get(choiceRestaurant - 1))
				&& reviewerX.equals(reviewedReviewer.get(choiceReviewer - 1)))
				return i;
		}
			
		return 0;
	}
	
	/**
	 * Removes a single review from the data base.
	 * 
	 * @param index
	 *            Index of the review in the array list of reviews to be
	 *            removed.
	 */
	public void removeReview(int index)
	{
		//Remove the review at the given index from the data base.
		review.remove(index);
	}
	
	/**
	 * Get the array list of reviews.
	 */
	public ArrayList<Review> getReviewList()
	{
		return review;
	}
}

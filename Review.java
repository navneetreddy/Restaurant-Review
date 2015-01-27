///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RestaurantReview.java
// File:             Review.java
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

/**
 * Represents reviews.
 * 
 * @author NavneetReddy
 * @author EvanHofmeister
 * 
 */
public class Review 
{
	//Declare an instance variable for the restaurant name.
	private String restaurant;
	//Declare an instance variable for the review name.
	private String reviewer;
	//Declare an instance variable for the rating.
	private int rating;
	//Declare an instance variable for the comment.
	private String comment;
	//Declare an instance variable for the recommendation.
	private boolean recommended;
	//Declare an instance variable for the unique id.
	private int uniqueID;
	
	/**
	 * Constructs a new review.
	 * 
	 * @param restaurant Name of the restaurant being reviewed.
	 * @param reviewer Name of the reviewer that is reviewing the restaurant.
	 * @param rating Rating the reviewer gave the restaurant.
	 * @param comment Comment from the reviewer.
	 * @param recommended Whether the the reviewer recommended the restaurant.
	 * @param uniqueID Unique Id assigned to the review.
	 */
	public Review(String restaurant, String reviewer, int rating, 
			String comment, boolean recommended, int uniqueID)
	{
		//Initiate restaurant to the given restaurant name.
		this.restaurant = restaurant;
		//Initiate reviewer to the given reviewer name.
		this.reviewer = reviewer;
		//Initiate rating to the given rating.
		this.rating = rating;
		//Initiate comment to the given comment.
		this.comment = comment;
		//Initiate recommended to the given recommended.
		this.recommended = recommended;
		//Initiate uniqueID to the given unique id.
		this.uniqueID = uniqueID;
	}
	
	/**
	 * Gets the restaurant name for this review.
	 */
	public String getRestaurant()
	{
		return restaurant;
	}
	
	/**
	 * Gets the reviewer name for this review.
	 */
	public String getReviewer()
	{
		return reviewer;
	}
	
	/**
	 * Gets the rating for this review.
	 */
	public int getRating()
	{
		return rating;
	}
	
	/**
	 * Gets the comment for this review.
	 */
	public String getComment()
	{
		return comment;
	}
	
	/**
	 * Gets the recommendation for this review as a string.
	 */
	public String getRecommended()
	{
		//Check if the review is recommended.
		if (recommended == true)
			return "Yes";
		else 
			return "No";
	}
	
	/**
	 * Gets the recommendation for this review as a letter.
	 */
	public String getRecommendedLetter()
	{
		//Check if the review is recommended.
		if (recommended == true)
			return "y";
		else 
			return "n";
	}
	
	/**
	 * Gets the unique id for this review.
	 */
	public int getUniqueID()
	{
		return uniqueID;
	}
	
}

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RestaurantReview.java
// File:             RestaurantReview.java
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

/**
 * Write reviews and search reviews for restaurants.
 * 
 * @author NavneetReddy
 * @author EvanHofmeister
 * 
 */
public class RestaurantReview 
{
	//Create a scanner connected to the System.in/keyboard.
	private static Scanner scnr = new Scanner(System.in);
	//Declare and create a ReviewStorage object.
	private static ReviewStorage reviewStorage = new ReviewStorage();
	//Declare a Review object.
	private static Review review;
	//Declare and create a ReviewIO object.
	private static ReviewIO reviewIO = new ReviewIO();
	//Declare an instance variable to keep track of unique id numbers.
	private static int id;
	//Declare an instance variable for the filename to import/export from.
	private static String filename;

	/**
	 * Main method. Starts the Restaurant Review program.
	 * 
	 * @param args Command Line arguments.
	 */
	public static void main(String[] args) 
	{
		//Declare variable to store the user input.
		int choice = 0;
		//Declare and set condition for the main program loop.
		boolean run = true;
		
		//Initialize the unique id to zero.
		id = 0;

		//Create an array to store command line arguments.
		int[] N = new int[2];

		//Check if the command line arguments are valid and store in a array.
		N[0] = commandErrorCheck(args[0]);
		N[1] = commandErrorCheck(args[1]);

		//Print startup message.
		System.out.println("Welcome to the CS302 Restaurant Reviewer!" +
			  "\nCheck out reviews for local restaurants, and add your own.\n");

		//Main program loop.
		while (run)
		{
			//Print main menu.
			System.out.println("What would you like to do?" +
					"\n1. Review a restaurant" +
					"\n2. View recently reviewed" +
					"\n3. Search for a restaurant" +
					"\n4. Get a recommendation" +
					"\n5. Get the top reviews for one restaurant" +
					"\n6. Import reviews from a file" +
					"\n7. Export reviews to a file" +
					"\n8. Remove reviews" +
					"\n9. Exit");

			//Get user input for the main menu choice
			//and check if the input is valid 
			//and within the range of the choices.
			choice = errorCheck(1,9);

			//Check which choice the user chose and 
			//call method corresponding to the user choice.
			if (choice == 1)
				reviewRestaurant();
			else if (choice == 2)
				recentlyReviewed(N[0]);
			else if (choice == 3)
				searchRestaurant();
			else if (choice == 4)
				getRecommendation();
			else if (choice == 5)
				topReviews(N[1]);
			else if (choice == 6 || choice == 7)
				fileHandle(choice);
			else if (choice == 8)
				removeReviews();
			else if (choice == 9)
				//Break the main program loop.
				run = false;
		}
	}

	/**
	 * Get the user input and check if it is valid 
	 * and within the range of the choices.
	 * 
	 * @param low Floor value for the range of the choices.
	 * @param high Ceiling value for the range of the choices.
	 * @return Valid input from the user that is within the range of choices.
	 */
	public static int errorCheck(int low, int high)
	{
		int choice = 0;

		boolean valid = false;
		while(!valid)
		{
			//Check if user input is valid.
			if (scnr.hasNextInt())
			{
				choice = scnr.nextInt();
				//Check if user input is within range of choices.
				if (choice < low || choice > high)
				{
					System.out.println("Input must be between " + low + 
							" and " + high + ".");
					continue;
				}
				else valid = true;
			}
			else
			{
				System.out.println("Input must be an integer.");
				scnr.next();
				continue;
			}
		}

		//return the user input.
		return choice;
	}
	
	/**
	 * Check if the command line arguments are valid and store in a array.
	 * 
	 * @param arg Argument passed through the command line arguments.
	 * @return Valid command line argument as an integer.
	 */
	public static int commandErrorCheck(String arg)
	{
		int commandArg = 0;
		
		try
		{
			//Parse the command line argument from a string to an int.
			commandArg = Integer.parseInt(arg);
		} 
		//Catch all exceptions and exit the program.
		catch (Exception e)
		{
			System.exit(-1);
		}
		
		//Check if the command line argument is positive.
		if (commandArg <= 0)
			System.exit(-1);
		
		return commandArg;
	}
	
	/**
	 * Check if the given string contains any commas.
	 * 
	 * @param line String to check for commas
	 * @return True if the given string contains commas.
	 * 		   False if the given string doesn't contain commas.
	 */
	public static boolean commaCheck(String line)
	{
		boolean comma = false;
		
		//Check if the given string has commas in it.
		if (line.contains(","))
		{
			System.out.println("Cannot contain commas.");
			comma = true;
			return comma;
		}
		else
			return comma;
	}

	/**
	 * Review a restaurant.
	 */
	public static void reviewRestaurant()
	{
		//Declare variables to store elements of a review.
		String restaurant = "";
		String reviewer = "";
		int rating;
		String comment = "";
		String recommend = "";
		char recommended;
		boolean recommendedBoolean;
		
		//Declare and set condition for the method loop.
		boolean run1 = true;

		//Method loop.
		while (run1)
		{
			//Get user input for the restaurant name.
			System.out.println("Restaurant name:");
			scnr.nextLine();
			restaurant = scnr.nextLine();

			//Check if the restaurant name has commas in it.
			if (commaCheck(restaurant) == true)
				break;

			//Get user input for the reviewer name.
			System.out.println("Reviewer name:");
			reviewer = scnr.nextLine();

			//Check if the reviewer name has commas in it.
			if (commaCheck(reviewer) == true)
				break;

			//Get user input for the rating
			//and check if the rating is valid and within the range.
			System.out.println("Rating [0-10]:");
			rating = errorCheck(0,10);

			//Get user input for the comment.
			System.out.println("Comment:");
			scnr.nextLine();
			comment = scnr.nextLine();

			//Check if the comment has commas in it.
			if (commaCheck(comment) == true)
				break;

			//Get user input for the recommendation.
			System.out.println("Recommended [y/n]:");
			recommend = scnr.next();
			recommended = recommend.charAt(0);

			//Check if the recommended letter is a 'y'.
			if (Character.toUpperCase(recommended) == 'Y')
				recommendedBoolean = true;
			else
				recommendedBoolean = false;

			//Create a new review with the review elements in the file.
			review = new Review(restaurant, reviewer, rating, comment,
					recommendedBoolean, id);
			//Add the review to the data base of reviews.
			reviewStorage.addReview(review);

			//Increment the unique id.
			id++;

			//Exit the method loop.
			run1 = false;
		}
	}

	/**
	 * Display list of recently reviewed reviews.
	 * 
	 * @param n Number of recently reviewed reviews to display.
	 */
	public static void recentlyReviewed(int n)
	{
		//Check if there are reviews in the data base.
		if (!reviewStorage.getReviewList().isEmpty())
			//Loop to keep track of number of reviews printed.
			for (int i = 1; i <= n; i++)
				//Check if there are more reviews in the data base
				//and print the next review if there are more reviews.
				if (reviewStorage.getReviewList().size() >= i)
					printReview(reviewStorage.getReviewList().size() - i);
	}

	/**
	 * Search for a restaurant.
	 */
	public static void searchRestaurant()
	{
		//Check if there are reviews in the data base.
		if (reviewStorage.getReviewList().isEmpty())
			System.out.println("No Reviews.");
		else
			printReview(reviewStorage.searchForReview());
	}

	/**
	 * Get a recommendation.
	 */
	public static void getRecommendation()
	{
		//Declare and create an array list to keep track of restaurants.
		ArrayList<String> reviewedReviewer = new ArrayList<String>();
		//Declare and create an array list to keep track of restaurants.
		ArrayList<String> recommendedRestaurants = new ArrayList<String>();

		//Declare and create a new random object.
		Random rand = new Random();

		//Declare and initialize a variable 
		//to store user input for the reviewer.
		int choiceReviewer = 0;
		int listNumCounter = 1;

		//Check if there are reviews in the data base.
		if (reviewStorage.getReviewList().isEmpty())
			System.out.println("No Reviews.");
		else
		{
			System.out.println("Get a recommendation from:");

			// Loop to run through all the reviews in the data base.
			for (int i = 0; i < reviewStorage.getReviewList().size(); i++) 
			{
				String reviewerX = 
					   reviewStorage.getReview(i).getReviewer();

				// Check if the reviewer has not been printed already.
				if (!reviewedReviewer.contains(reviewerX)) 
				{
					// Print the reviewer name in a numbered format.
					System.out.println(listNumCounter + ". " + reviewerX);
					
					// Add the reviewer to the array list of reviewers
					// that have been printed.
					reviewedReviewer.add(reviewerX);

					listNumCounter++;
				}
			}
			
			//Get user input for the choice of reviewer and
			//check if the input is valid and within the range of the choices.
			choiceReviewer = errorCheck(1,reviewedReviewer.size());

			// Loop to run through all the reviews in the data base.
			for (int i = 0; i < reviewStorage.getReviewList().size(); i++) 
			{
				String reviewerX = reviewStorage.getReview(i)
						.getReviewer();
				String restaurantX = reviewStorage.getReview(i)
						.getRestaurant();
				String recommendX = reviewStorage.getReview(i)
						.getRecommended();

				// Check if the user choice of reviewer is the reviewer at
				// i in the array list of reviews.
				if (reviewerX.equals(reviewedReviewer.get(choiceReviewer - 1)))
					// Check if reviewer recommended the restaurant.
					if (recommendX.equals("Yes"))
						// Add the restaurant to the array list of
						// recommended restaurants for the reviewer.
						recommendedRestaurants.add(restaurantX);
			}

			// Check if the reviewer recommended any restaurants.
			if (recommendedRestaurants.size() > 0) 
			{
				// Randomly print out one of the restaurants
				// the reviewer recommended.
				int randomRecommend = 
						rand.nextInt(recommendedRestaurants.size());
				System.out.println(recommendedRestaurants.get(randomRecommend));
			}
		}
	}

	/**
	 * Get the top reviews of a restaurant.
	 * 
	 * @param n Number of top reviews to display.
	 */
	public static void topReviews(int n)
	{
		//Declare and create an array list to keep track of restaurants.
		ArrayList<String> reviewedRest = new ArrayList<String>();

		//Declare and initialize a variable to 
		//store user input for the restaurant.
		int choiceRestaurant = 0;
		int ncounter = n;

		//Check if there are reviews in the data base.
		if (reviewStorage.getReviewList().isEmpty())
			System.out.println("No Reviews.");
		else
		{
			System.out.println("Get top reviews for:");

			// Loop to run through all the reviews in the data base.
			for (int i = 0; i < reviewStorage.getReviewList().size(); i++) 
			{
				String restaurantX = 
						reviewStorage.getReview(i).getRestaurant();

				// Check if the restaurant has not been printed already.
				if (!reviewedRest.contains(restaurantX)) 
				{
					// Add the restaurant to the array list of restaurants
					// that have been printed.
					reviewedRest.add(restaurantX);
					
					// Print the restaurant name in a numbered format.
					System.out.println(reviewedRest.size() + 
							". " + restaurantX);
				}
			}
			
			//Get user input for the choice of restaurant and
			//check if the input is valid and within the range of the choices.
			choiceRestaurant = errorCheck(1,reviewedRest.size());

			// Check if there are more reviews in the data base than
			// the maximum number of reviews to display.
			if (n < reviewStorage.getReviewList().size()) 
			{
				// Loop to run through all the possible ratings beginning with
				// the top rating.
				for (int j = 10; j >= 0; j--) 
				{
					// Loop to run through the array list of reviews backwards.
					for (int i = reviewStorage.getReviewList().size() - 1;
							i >= 0; i--) 
					{
						String restaurantX = 
								reviewStorage.getReview(i).getRestaurant();
						int ratingX = 
								reviewStorage.getReview(i).getRating();

						// Check if the maximum number of reviews to display
						// has been reached.
						if (ncounter > 0) 
						{
							// Check if the review is one of the reviews for
							// the selected restaurant.
							if (restaurantX.equals(reviewedRest
									.get(choiceRestaurant - 1))) 
							{
								// Check if the rating in the review is the
								// next top review.
								if (ratingX == j) 
								{
									printReview(i);
									System.out.println();

									// Decrement the maximum number of reviews
									// to be printed.
									ncounter--;
								}
							}
						}
					}
				}
			}
			else
			{
				// Loop to run through all the possible ratings beginning with
				// the top rating.
				for (int j = 10; j >= 0; j--) 
				{
					// Loop to run through the array list of reviews backwards.
					for (int i = reviewStorage.getReviewList().size() - 1;
							i >= 0; i--) 
					{
						String restaurantX = reviewStorage.getReview(i)
								.getRestaurant();
						int ratingX = reviewStorage.getReview(i)
								.getRating();

						// Check if the review is one of the reviews for the
						// selected restaurant.
						if (restaurantX.equals(reviewedRest
								.get(choiceRestaurant - 1))) 
						{
							// Check if the rating in the review is the
							// next top review.
							if (ratingX == j) 
							{
								printReview(i);
								System.out.println();
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Handle importing to a file and exporting to a file.
	 * 
	 * @param choice User choice to import from file or export to file.
	 */
	public static void fileHandle(int choice)
	{
		//Get user input for the filename.
		System.out.println("Enter file name:");
		scnr.nextLine();
		filename = scnr.nextLine();
		
		//Check if the user wants to import to a file.
		if (choice == 6)
			reviewIO.readFromFile(filename, reviewStorage);
		//Check if the user wants to export to a file.
		else if (choice == 7)
			reviewIO.writeToFile(filename, reviewStorage);
	}
	
	/**
	 * Remove reviews from the data base.
	 */
	public static void removeReviews()
	{
		System.out.println("What would you like to do?" + 
				"\n1. Delete review" +
				"\n2. Clear database" +
				"\n3. Cancel");

		//Get user input for the user choice
		//and check if the input is valid and within the range of the choices.
		int choice = errorCheck(1,3);

		//Check if there are reviews in the data base.
		if (!reviewStorage.getReviewList().isEmpty())
			//Check if the user wants to delete one review or 
			//clear the data base.
			if (choice == 1)
				//Remove the selected review.
				reviewStorage.removeReview(reviewStorage.searchForReview());
			else if (choice == 2)
				//Clear the data base of reviews.
				reviewStorage.getReviewList().clear();
	}

	/**
	 * Print a review.
	 * 
	 * @param index
	 *            Index of the review to be printed in the array list of
	 *            reviews.
	 */
	public static void printReview(int index)
	{
		//Print all the elements of a review in the correct format.
		System.out.println("Unique ID: " + 
				reviewStorage.getReview(index).getUniqueID() +
				"\nRestaurant: " + 
				reviewStorage.getReview(index).getRestaurant() +
				"\nReviewer: " + 
				reviewStorage.getReview(index).getReviewer() +
				"\nRating: " + 
				reviewStorage.getReview(index).getRating() +
				"\nComment: " + 
				reviewStorage.getReview(index).getComment() +
				"\nRecommended: " + 
				reviewStorage.getReview(index).getRecommended());
	}
}

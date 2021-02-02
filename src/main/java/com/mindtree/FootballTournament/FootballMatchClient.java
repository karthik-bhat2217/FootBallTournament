package com.mindtree.FootballTournament;

import java.util.Scanner;
import com.mindtree.exception.FootballTournamentException;
import com.mindtree.service.serviceimplementation.FootballMatchManagerImplementation;
import com.mindtree.utility.InputReader;

public class FootballMatchClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FootballMatchClient client = new FootballMatchClient();
		Scanner input = new Scanner(System.in);
		InputReader reader = new InputReader(input);
		FootballMatchManagerImplementation manager = new FootballMatchManagerImplementation();
		boolean exit = false;
		do {
			client.displayDetails();
			byte choice = reader.readChoice();
			switch (choice) {
			case 1:
				try {

					manager.addMatch(input);

				} catch (FootballTournamentException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					manager.displayTeamMatches(reader.readTeamName());
				} catch (FootballTournamentException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Thank You!!!");
				exit = true;
				break;
			default:
				System.out.println("Wrong Input");
			}

		} while (!exit);

	}

	private void displayDetails() {
		// TODO Auto-generated method stub
		System.out.println("1.Add Match Details\n2.Display Match Details played by the given team\n3.Exit");

	}

}

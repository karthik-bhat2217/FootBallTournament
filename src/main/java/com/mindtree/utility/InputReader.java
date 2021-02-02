package com.mindtree.utility;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mindtree.entity.Match;
import com.mindtree.exception.InputMisMatchException;

public class InputReader {
	Scanner s;

	public InputReader(Scanner s) {
		this.s = s;
	}

	public Byte readChoice() {
		byte input = -1;
		do {
			try {
				input = s.nextByte();
			} catch (InputMismatchException e) {
				System.out.println("Wrong input");
			}
		} while (input == -1);

		return input;

	}

	public Match readMatchDetails() throws InputMisMatchException {

		Match match = new Match();
		try {
			System.out.println("Enter the match id");
			match.setMatchID(s.nextInt());
			System.out.println("Enter the match date ");

			Timestamp ts = dateToTimeStamp();
			match.setDate(ts);
			System.out.println("Enter the first team name");
			s.nextLine();
			match.setFirstTeamName(s.nextLine());
			System.out.println("Enter the second team name");
			match.setSecondTeamName(s.nextLine());
			System.out.println("Enter goals scored by first team ");
			match.setFirstTeamGoals(s.nextInt());
			System.out.println("Enter the second team goal");
			match.setSecondTeamGoals(s.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(e);
		}
		return match;
	}

	public int readId() {
		int input = -1;
		do {
			try {
				System.out.println("Enter the id of train");
				input = s.nextByte();
			} catch (InputMismatchException e) {
				System.out.println("Wrong input");
			}
		} while (input == -1);
		return input;
	}

	public Timestamp dateToTimeStamp() throws InputMisMatchException {

		Timestamp ts = null;

		String date1 = s.next();
		String regex = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";
		// Creating a pattern object
		Pattern pattern = Pattern.compile(regex);
		// Matching the compiled pattern in the String
		Matcher matcher = pattern.matcher(date1);
		if (matcher.matches()) {

			int day = (date1.charAt(0) - 48) * 10 + (date1.charAt(1) - 48);

			int month = (date1.charAt(3) - 48) * 10 + (date1.charAt(4) - 48);

			int year = (date1.charAt(6) - 48) * 1000 + (date1.charAt(7) - 48) * 100 + (date1.charAt(8) - 48) * 10
					+ (date1.charAt(9) - 48);

			LocalDate date = LocalDate.of(year, month, day);

			String time1 = s.next();
			String regex2 = "^(2[0-4]|1[0-9]|0[0-9]):(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])";
			pattern = Pattern.compile(regex2);
			matcher = pattern.matcher(time1);

			if (matcher.matches()) {

				int hour = (time1.charAt(0) - 48) * 10 + (time1.charAt(1) - 48);
				int min = (time1.charAt(3) - 48) * 10 + (time1.charAt(4) - 48);
				System.out.println(hour + "          " + min);
				LocalTime time = LocalTime.of(hour, min);
				LocalDateTime ld = LocalDateTime.of(date, time);

				ts = Timestamp.valueOf(ld);
			} else {
				throw new InputMisMatchException("Input incorrect");
			}
		} else {
			throw new InputMisMatchException("Input incorrect");
		}

		return ts;

	}

	public String readTeamName() {
		// TODO Auto-generated method stub

		s.nextLine();
		return s.nextLine();

	}

}

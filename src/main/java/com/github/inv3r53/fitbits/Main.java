package com.github.inv3r53.fitbits;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Bootstrap the application -  parse input file , execute the app and print formatted output.
 */
public class Main {

	private static final String OUTPUT = "%d %d %c";

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Requires a parameter that specifies full path to the input file.");
			return;
		}
		FitbitsApplication app = new FitbitsApplication();

		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			int lineNum = -1;
			int[] pitchDimension = null;
			Location location = null;

			for (String line; (line = br.readLine()) != null; lineNum++) {
				lineNum = lineNum % 2;
				switch (lineNum) {
				case -1:
					pitchDimension = getCoordinates(line);
					break;
				case 0:
					location = getLocation(line);
					break;
				case 1:// execute main logic;
					Location result = app.train(pitchDimension, location, line);
					if (result != null) {
						System.out.println(String.format(OUTPUT, result.getX(), result.getY(),
								result.getDirection().getDirectionCode()));
					} else {
						System.out.println("");
					}
					break;
				default:
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int[] getCoordinates(String inputLine) {
		String[] coordinates = inputLine.split("\\s+");
		return new int[] { getAsInteger(coordinates[0]), getAsInteger(coordinates[1]) };

	}

	private static Location getLocation(String inputLine) {
		String[] coordinates = inputLine.split("\\s+");
		Location location = new Location(getAsInteger(coordinates[0]), getAsInteger(coordinates[1]),
				Direction.getDirection(coordinates[2].charAt(0)));
		return location;

	}

	private static int getAsInteger(String num) {
		return Integer.parseInt(num);
	}

}

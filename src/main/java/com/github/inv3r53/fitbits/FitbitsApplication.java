package com.github.inv3r53.fitbits;

import java.util.Arrays;

/**
 * Instructs a trainee based on input commands.
 */
public class FitbitsApplication {

	public Location train(int[] pitchDimensions, Location location, String commands) {
		validate(pitchDimensions);
		
		Trainee trainee = getTrainee(pitchDimensions[0], pitchDimensions[1], location);

		if (trainee == null) {
			return null;
		}

		char commandType = ' ';
		for (int i = 0; i < commands.length(); i++) {
			commandType = commands.charAt(i);
			switch (commandType) {
			case 'M':
				trainee.move();
				break;
			case 'L':
				trainee.turnLeft();
				break;
			case 'R':
				trainee.turnRight();
				break;
			default:
				// Unknown command proceeding to next command.
				break;
			}
		}
		return trainee.getCurrentLocation();
	}

	private Trainee getTrainee(int x, int y, Location location) {
		Trainee trainee = new Trainee(x, y);
		boolean validPlacement = trainee.place(location);
		return validPlacement ? trainee : null;
	}

	private void validate(int[] pitchDimensions) {
		if (pitchDimensions[0] <= 0 || pitchDimensions[1] <= 0) {
			throw new IllegalArgumentException("Invalid Pitch dimension specified " + Arrays.asList(pitchDimensions));
		}
	}

}

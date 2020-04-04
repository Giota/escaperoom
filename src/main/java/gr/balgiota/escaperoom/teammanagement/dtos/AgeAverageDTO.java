package gr.balgiota.escaperoom.teammanagement.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AgeAverageDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int numOfUsersWithValidAge;

	private double ageAverage;

	private int numOfUsersWithNullAge;

	private int numOfUsersWithNonNumericAge;

	@JsonIgnore
	private double sumAge;

	public int getNumOfUsersWithValidAge() {
		return numOfUsersWithValidAge;
	}

	public void setNumOfUsersWithValidAge(int numOfUsersWithValidAge) {
		this.numOfUsersWithValidAge = numOfUsersWithValidAge;
	}

	public double getAgeAverage() {
		return ageAverage;
	}

	public void setAgeAverage(double ageAverage) {
		this.ageAverage = ageAverage;
	}

	public int getNumOfUsersWithNullAge() {
		return numOfUsersWithNullAge;
	}

	public void setNumOfUsersWithNullAge(int numOfUsersWithNullAge) {
		this.numOfUsersWithNullAge = numOfUsersWithNullAge;
	}

	public int getNumOfUsersWithNonNumericAge() {
		return numOfUsersWithNonNumericAge;
	}

	public void setNumOfUsersWithNonNumericAge(int numOfUsersWithNonNumericAge) {
		this.numOfUsersWithNonNumericAge = numOfUsersWithNonNumericAge;
	}

	public void incrementNumOfUsersWithValidAge() {
		numOfUsersWithValidAge++;
	}

	public void incrementNumOfUsersWithNullAge() {
		numOfUsersWithNullAge++;
	}

	public void incrementNumOfUsersWithNonNumericAge() {
		numOfUsersWithNonNumericAge++;
	}

	public void addAgeToSum(double userAge) {

		sumAge += userAge;

	}

	public void calculateAgeAverage() {

		if (numOfUsersWithValidAge > 0) {
			ageAverage = sumAge / numOfUsersWithValidAge;
		}

	}

}

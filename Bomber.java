package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends AbstractArmedSpaceShip{
	int numberOfTechnicians;
	public static int BASIS_BOMBER_COST = 5000;


	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed,crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;

	}

	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}

	public int getAnnualMaintenanceCost() {
		double annualWeaponCostDiscountInPrecentage = this.numberOfTechnicians*0.1;
		int annualCost = super.getWeaponsAnnualWeaponCost();
		int newWeaponsPrice = (int)(annualCost*(1-annualWeaponCostDiscountInPrecentage));
		return (BASIS_BOMBER_COST + newWeaponsPrice);
	}

	public String toString() {
		String result = super.toString();
		result = result + System.lineSeparator() + "\tNumberOfTechnicians=" + this.getNumberOfTechnicians();
		return result;
	}



}

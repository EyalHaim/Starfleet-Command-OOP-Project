package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter  {
	public static int NumStealth = 0;
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers,weapons);
		NumStealth++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		super(name, commissionYear,maximalSpeed, crewMembers, Arrays.asList(new Weapon ("Laser Cannons",10,100)));
		NumStealth++;
	}
	

	
	public int getAnnualMaintenanceCost() {
		int annualCostAsFighter = super.getAnnualMaintenanceCost();
		return (NumStealth*50) + annualCostAsFighter;
	}
	
	public String toString() {
		return super.toString();
	}
}

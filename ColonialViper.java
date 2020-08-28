package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter  {
	public static int BASIS_COLONIAL_COST = 4000;
	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed,crewMembers, weapons);
	}

	
	public int getAnnualMaintenanceCost() {
		int annualWeaponsCost = super.getWeaponsAnnualWeaponCost();
		int teamMembersCost = this.crewMembers.size()*500;
		
		return (int)(BASIS_COLONIAL_COST +annualWeaponsCost + teamMembersCost + 500*this.maximalSpeed);
	}
	
	public String toString() {
		return super.toString();
	}
}

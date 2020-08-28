package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {
	public static int BASIS_CYLON_COST = 3500;
	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed,crewMembers, weapons);
	}
	

	@Override
	public int getAnnualMaintenanceCost() {
		int annualWeaponsCost = this.getWeaponsAnnualWeaponCost();
		int teamMembersCost = this.crewMembers.size()*500;
		
		return (int) (BASIS_CYLON_COST + annualWeaponsCost + teamMembersCost + 1200*this.maximalSpeed);
	}
	
	public String toString() {
		return super.toString();
	}

	

}

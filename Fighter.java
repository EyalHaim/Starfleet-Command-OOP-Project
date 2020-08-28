package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends AbstractArmedSpaceShip{

	public static int BASIS_FIGHTER_COST = 2500;
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}



	public int getAnnualMaintenanceCost() {
		return (int)(BASIS_FIGHTER_COST + super.getWeaponsAnnualWeaponCost() + 1000*this.maximalSpeed);
	}
	
	public String toString() {
		return super.toString();
	}
	
}

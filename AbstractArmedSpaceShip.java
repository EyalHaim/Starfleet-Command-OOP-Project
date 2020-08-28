package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public abstract class AbstractArmedSpaceShip extends AbstractSpaceShip {
	
	List<Weapon> weapons;
	
	public AbstractArmedSpaceShip (String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed,crewMembers);
		this.weapons = weapons;
	}
	
	public AbstractArmedSpaceShip (String name, int commissionYear, float maximalSpeed, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed);
		this.weapons = weapons;
	}
	
	public List<Weapon> getWeapon() {
		return this.weapons;
	}
	
	public int getFirePower() {
		int sum = 0;
		for (Weapon wep : this.weapons) {
			sum+= wep.getFirePower();
		}
		return super.getFirePower() + sum;
	}
	
	public int getWeaponsAnnualWeaponCost() {
		int sum = 0;
		for (Weapon wep : this.weapons) {
			sum+= wep.getAnnualMaintenanceCost();
		}
		return sum;
	}
	
	public String toString() {
		String result = super.toString() + System.lineSeparator() + "\tWeaponArray=" + this.getWeapon();
		return result;
	}
	
	

}

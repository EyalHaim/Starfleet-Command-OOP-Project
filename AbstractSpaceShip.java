package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public abstract class AbstractSpaceShip implements Spaceship {
	String name;
	int commissionYear;
	float maximalSpeed;
	Set<? extends CrewMember> crewMembers;
	

	
	public AbstractSpaceShip (String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers){
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crewMembers;
		
	}
	
	public AbstractSpaceShip (String name, int commissionYear, float maximalSpeed){
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		
	}
	
	
	public String getName() {
		return this.name;
	}
	public int getCommissionYear() {
		return this.commissionYear;
	}
	public float getMaximalSpeed() {
		return this.maximalSpeed;
	}
	
	public Set<? extends CrewMember> getCrewMembers(){
		return this.crewMembers;
	}
	
	public int getFirePower() {
		return 10;
	}
	
	public abstract int getAnnualMaintenanceCost();
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.getClass().getSimpleName()); 
		str.append(System.lineSeparator() + "\tName=").append(name);
		str.append(System.lineSeparator() + "\tCommissionYear=").append(commissionYear);
		str.append(System.lineSeparator() + "\tMaximalSpeed=").append(maximalSpeed);
		str.append(System.lineSeparator() + "\tFirePower=").append(this.getFirePower());
		str.append(System.lineSeparator() +"\tCrewMembers=").append(this.getCrewMembers().size());
		str.append(System.lineSeparator() + "\tAnnualMaintenanceCost=").append(this.getAnnualMaintenanceCost());
		return str.toString();
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSpaceShip other = (AbstractSpaceShip) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}

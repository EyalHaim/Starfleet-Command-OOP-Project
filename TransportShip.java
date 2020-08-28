package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends AbstractSpaceShip{
	int passengerCapacity;
	int cargoCapacity;
	public static int BASIS_TRANSPORT_COST = 3000;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}
	
	public int getPassengerCapacity(){
		return this.passengerCapacity;
	}
	
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}

	public int getAnnualMaintenanceCost() {
		return (BASIS_TRANSPORT_COST + 5*this.cargoCapacity + 3*this.passengerCapacity);
	}
	
	
	public String toString() {
		String result = super.toString();
		result = result  + System.lineSeparator()+  "\tCargoCapacity=" + this.getCargoCapacity()  + System.lineSeparator() +"\tPassengerCapacity=" + this.getPassengerCapacity();
		return result;
	}

}

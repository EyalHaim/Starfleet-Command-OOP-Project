package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends AbstractCrewMember {

	int modelNumber;
	
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age, yearsInService, name);
		this.modelNumber = modelNumber;
		
	}

	public int getModelNumber() {
		return this.modelNumber;
	}
	
	public String toString() {
		String result = super.toString();
		result = result + System.lineSeparator() + "\tModelNumber=" + this.getModelNumber();
		return result;
	}
	
	

}

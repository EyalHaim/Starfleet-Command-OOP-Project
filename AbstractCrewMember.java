package il.ac.tau.cs.sw1.ex9.starfleet;

public abstract class AbstractCrewMember implements CrewMember {
	int age;
	int yearsInService;
	String name;
	
	public AbstractCrewMember(int age, int yearsInService, String name) {
		this.age = age;
		this.yearsInService = yearsInService;
		this.name = name;	
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getYearsInService() {
		return this.yearsInService;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.getClass().getSimpleName()); 
		str.append(System.lineSeparator() + "\tName=").append(this.getName());
		str.append(System.lineSeparator() + "\tAge=").append(this.getAge());
		str.append(System.lineSeparator() + "\tYearsInService=").append(this.getYearsInService());
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
		AbstractCrewMember other = (AbstractCrewMember) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

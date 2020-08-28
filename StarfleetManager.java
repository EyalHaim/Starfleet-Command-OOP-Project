package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> l1 = new ArrayList<>(fleet);
		Collections.sort(l1, new ShipDescriptionsComparator());

		List<String> result = new ArrayList<>();
		for (Spaceship ss : l1) {
			result.add(ss.toString());
		}
		return result;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		String ship_name;
		for (Spaceship ss : fleet) {
			ship_name = ss.getClass().getSimpleName();
			if (resultMap.containsKey(ship_name))
				resultMap.put(ship_name, resultMap.get(ship_name) + 1);
			else
				resultMap.put(ship_name, 1);
		}
		return resultMap;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum = 0 ;
		for (Spaceship ss: fleet) {
			sum += ss.getAnnualMaintenanceCost();
		}
		return sum;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> resultSet = new HashSet<String>();
		List<Weapon> weapons;
		String wepName;
		for (Spaceship ss: fleet) {
			if (ss instanceof AbstractArmedSpaceShip) {
				weapons = ((AbstractArmedSpaceShip) ss).getWeapon();
				for (Weapon wep: weapons) {
					wepName = wep.getName();
					if(!resultSet.contains(wepName))
						resultSet.add(wepName);
				}
			}
		}

		return resultSet;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int sum = 0;
		for (Spaceship ss: fleet) {
			sum += ss.getCrewMembers().size();
		}
		return sum;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int officerCounter = 0;
		float ageSum = 0;
		Set<? extends CrewMember> crewMembers;
		for (Spaceship ss: fleet) {
			crewMembers = ss.getCrewMembers();
			for (CrewMember cm : crewMembers) {
				if (cm instanceof Officer) {
					ageSum += cm.getAge();
					officerCounter++;
				}

			}
		}
		return (ageSum/officerCounter);
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		OfficerRank highestRank;
		Officer highestOfficer;
		OfficerRank tmpRank;
		Map<Officer, Spaceship> resultMap = new HashMap<Officer, Spaceship>();
		Set<? extends CrewMember> crewMembers;
		for (Spaceship ss: fleet) {
			highestRank = OfficerRank.Ensign;
			highestOfficer = null;
			crewMembers = ss.getCrewMembers();
			for (CrewMember cm : crewMembers) {
				if (cm instanceof Officer) {
					tmpRank = ((Officer) cm).getRank();
					if (tmpRank.compareTo(highestRank) > 0) {
						highestRank = tmpRank;
						highestOfficer = (Officer) cm;
					}
				}
			}
			if (highestOfficer != null)
				resultMap.put(highestOfficer,ss);
		}
		return resultMap;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		List<Map.Entry<OfficerRank, Integer>> resultList;
		Map<OfficerRank,Integer> rankAppear = new HashMap<OfficerRank, Integer>();
		Set<? extends CrewMember> crewMembers;
		OfficerRank tmpRank;
		for (Spaceship ss: fleet) {
			crewMembers = ss.getCrewMembers();
			for (CrewMember cm : crewMembers) {
				if (cm instanceof Officer) {
					tmpRank = ((Officer) cm).getRank();
					if (rankAppear.containsKey(tmpRank))
						rankAppear.put(tmpRank, rankAppear.get(tmpRank) + 1);
					else
						rankAppear.put(tmpRank,1);	
				}
		}
		}
		resultList = new ArrayList<>(rankAppear.entrySet());
		Collections.sort(resultList, new OfficerRankComparator());
		return resultList;
	}

	public static class ShipDescriptionsComparator implements Comparator <Spaceship>{

		@Override
		public int compare(Spaceship o1, Spaceship o2) {
			if (o1.getFirePower() > o2.getFirePower()) 
				return -1;
			if (o1.getFirePower() < o2.getFirePower()) 
				return 1;
			if (o1.getCommissionYear() > o2.getCommissionYear())
				return -1;
			if (o1.getCommissionYear() < o2.getCommissionYear())
				return 1;

			return o1.getName().compareTo(o2.getName());
		}

	}
	public static class OfficerRankComparator implements Comparator <Map.Entry<OfficerRank, Integer>>{

		@Override
		public int compare(Entry<OfficerRank, Integer> o1, Entry<OfficerRank, Integer> o2) {
			if (o1.getValue() > o2.getValue())
				return 1;
			if (o1.getValue() < o2.getValue())
				return -1;
			return o1.getKey().compareTo(o2.getKey());
		}

	

	}
}

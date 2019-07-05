package examples;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicate {
	
	/*
	 *  1. They move your conditions (sometimes business logic) to a central place.
	 *  2. This helps in unit-testing them separately.
	 *  3. Any change need not be duplicated into multiple places. Java predicate improves code maintenance.
	 *  The code e.g. “filterEmployees(employees, isAdultFemale())” is very much readable than writing a if-else block.
	 */
	
	//A predicate to filter all Male employees
	public static Predicate<Employee> isGender(String gender){
		return e -> e.getGender().equalsIgnoreCase(gender);
	}
	
	public static Predicate<Employee> isAgeMoreThan(int age){
		return e -> e.getAge() > age;
	}
	
	public static List<String> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream().filter(predicate).map(Employee::getFirstName)
									.collect(Collectors.toList());
	}

}

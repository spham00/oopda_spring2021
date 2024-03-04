package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class StreamDemo {

	private static Set<Person> persons = new HashSet<Person>();
	private static List<Integer> numbers = new ArrayList<Integer>();
	private static List<Integer> luckyNumbers = Arrays.asList(7, 10, 11, 19, 30, 41);
	private static List<Integer> unluckyNumbers = 
			new LinkedList<Integer>(Arrays.asList(6, 2, 1920, 13, 55, 2011));
	
	public static void main(String[] args) {
		makeNumbers();
		makePersons();
		
		/* Different examples using Streams */
		filterAndCalculateTest();	// Example 1
		makeNewCollectionTest();	// Example 2
		matchTest();				// Example 3
		
		/* Example 4: Passing a predicate and collection for searching */
		Predicate<Person> katy = person -> person.getFirstName().equalsIgnoreCase("katy");
		System.out.println("\nAny Katy's? ==> " + any(persons, katy));
		Predicate<Person> hugo = person -> person.getFirstName().equalsIgnoreCase("hugo");
		System.out.println("Any Hugo's? ==> " + any(persons, hugo));
		
		// Use the Predicate's functional method directly
		Person mixon = new Person("Katy", "Mixon");
		System.out.println("Is Ms. Mixon a Katy? " + katy.test(mixon));
		
		/* Example 5: findAny and findFirst
		 * 				findAny is more flexible when processing a collection
		 * 			 	in parallel processes */
		System.out.println("Any .com address ==> " + findAnyTest());
		System.out.println("First .com address ==> " + findFirstTest());
		
		/* Example 6: Sorting with Comparators */
		sortTest();
	}
	
	private static int sumDoubleDigits(List<Integer> numbers) {
		Iterator<Integer> it = numbers.iterator();
		int sum = 0;
		while (it.hasNext()) {
			int num = it.next();
			if (num >= 10) sum += num;
		}
		return sum;
	}
	
	private static int sumDoubleDigits2(List<Integer> numbers) {
		return numbers.stream()
			      .filter(i -> i >= 10)
			      .mapToInt(i -> i)
			      .sum();
	}
	
	private static double averageSalaryByGender(
							Set<Person> persons, Person.Gender gender) {
		return persons.stream()
			      .filter(p -> p.getGender() == gender)
			      .mapToDouble(Person::getSalary)
			      .average()
			      .getAsDouble();
	}
	
	private static double averageSalaryByGenderAndAge(
							Set<Person> persons, Person.Gender gender, int age) {
		return persons.stream()
			      .filter(p -> p.getGender() == gender)
			      .filter(p -> p.getAge() >= age)
			      .mapToDouble(Person::getSalary)
			      .average()
			      .getAsDouble();
	}
	
	private static void filterAndCalculateTest() {
		System.out.println("Summing numbers greater than or equal to 10");
		System.out.println(sumDoubleDigits(numbers));
		System.out.println(sumDoubleDigits2(numbers));
		
		System.out.println("\nUsing streams and lambdas to filter a collection");
		System.out.println("\tAverage salary of females: $" +
				(int) averageSalaryByGender(persons, Person.Gender.FEMALE));
		System.out.println("\tAverage salary of females 21 and older: $" +
				(int) averageSalaryByGenderAndAge(persons, Person.Gender.FEMALE, 21));		
	}
	
	private static void makeNewCollectionTest() {
		// Let's use .stream() to make lists of odd numbers
		System.out.println("\n\nDo we have new lista of odd numbers?");
		List<Integer> oddLuckyNums = luckyNumbers.stream()
			                                 .filter(i -> i % 2 != 0)
			                                 .collect(Collectors.toList());
		oddLuckyNums.forEach(value -> System.out.print(value + " "));
		System.out.println("  ==> " + oddLuckyNums.getClass().getName());
		
		List<Integer> oddUnluckyNums = 
				unluckyNumbers.stream()
                                              .filter(i -> i % 2 != 0)
                                              .collect(Collectors.toCollection(LinkedList::new));
		oddUnluckyNums.forEach(value -> System.out.print(value + " "));
		System.out.println("  ==> " + oddUnluckyNums.getClass().getName());

	}
	
	private static void matchTest() {
		List<Integer> numsToTest = Arrays.asList( 7, 13 );
		numsToTest.forEach(num ->
			System.out.println(("Is " + num + " lucky?  " + 
					luckyNumbers.stream()
 		 	                            .anyMatch(i -> i == num)))
			);
		
		numsToTest = Arrays.asList( 20, 100 );
		numsToTest.forEach(num -> 
			System.out.println(("Are all lucky numbers < " + num + "?  " + 
					luckyNumbers.stream()
	        		                    .allMatch(i -> i < num)))
			);
	}
	
	private static boolean any (Collection<Person> coll, Predicate<Person> pred) {
		return coll.stream().anyMatch(pred);
	}
	
	private static Person findAnyTest() {
		return persons.parallelStream()
					  .filter(p -> p.getEmail().contains(".com"))
	 			          .findAny()
				          .get();
	}
	
	private static Person findFirstTest() {
		return persons.parallelStream()
					  .filter(p -> p.getEmail().contains(".com"))
				          .findFirst()
				          .get();
	}
	
	private static void sortTest() {
		System.out.println("\nThe original order of the Set");
		persons.forEach(p -> System.out.println("\t" + p));

		// Create comparators using a lambda expression
		Comparator<Person> byAgeDescending =
				(person1, person2) -> person2.getAge() - person1.getAge();
		Comparator<Person> byAgeAscending =
				(person1, person2) -> person1.getAge() - person2.getAge();

		/* For these comparators, rely on the natural orders of 
		 * String comparisons (i.e., alphabetically) and
		 * enum comparisons (i.e., order values from 1st to last) 
		 */
		Comparator<Person> byLastName =
				(person1, person2) -> 
						person1.getLastName().compareTo(person2.getLastName());
		Comparator<Person> byGender =
				(person1, person2) -> 
						person1.getGender().compareTo(person2.getGender());
						
		// Now use the Comparators in the collection's stream
		System.out.println("\nOldest to Youngest");
		persons.stream()
	               .sorted(byAgeDescending)
        	       .forEach(p -> System.out.println("\t" + p));
	
		System.out.println("\nYoungest to Oldest");
		persons.stream()
        	       .sorted(byAgeAscending)
               	       .forEach(p -> System.out.println("\t" + p));
		
		System.out.println("\nAlphabetically by last name");
		persons.stream()
              	       .sorted(byLastName)
                       .forEach(p -> System.out.println("\t" + p));
		
		System.out.println("\nBy Gender, then Alphabetically by last name");
		persons.stream()
                       .sorted(byGender.thenComparing(byLastName))
                       .forEach(p -> System.out.println("\t" + p));		
	}

	private static Collector toList() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void makeNumbers() {
		numbers = Arrays.asList( 2, 16, 9, 80, 34, 12, 17, 3 );
	}

	private static void makePersons() {
		persons.add(new Person(1, "Jane", "Marie", "Doe",
				"doeS@students.rowan.edu", "222-33-4444", 19, Person.Gender.FEMALE, 11000));
		persons.add(new Person(2, "William", "S.", "Frawley",
				"bill@manhattanplace.com", "129-33-4546", 71, Person.Gender.MALE, 78000));
		persons.add(new Person(3, "Betty", "", "Rubble",
				"betty@slaggle.com", "309-13-4227", 32, Person.Gender.FEMALE, 0));
		persons.add(new Person(3, "Anthony", "John", "Nelson",
				"tony@nasa.gov", "198-81-6622", 29, Person.Gender.MALE, 250000));
		persons.add(new Person(3, "Katy", "", "Perry",
				"firework@.katyperry.com", "319-80-2072", 31, Person.Gender.FEMALE, 1300000));
	}
}
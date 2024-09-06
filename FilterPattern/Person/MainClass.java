package FilterPattern.Person;

import java.util.*;;

public class MainClass {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Male", "Single"));
        persons.add(new Person("Jane", "Female", "Married"));
        persons.add(new Person("Mike", "Male", "Married"));
        persons.add(new Person("Sara", "Female", "Single"));
        persons.add(new Person("Paul", "Male", "Single"));

        Criteria male = new MaleCritera();
        Criteria female = new FemaleCriteria();
        Criteria single = new SingleCriteria();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);
        Criteria notSingle = new NotCriteria(single);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));

        System.out.println("\nNot Single: ");
        printPersons(notSingle.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}

package FilterPattern.Person;

import java.util.*;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}

class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otheCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otheCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> fristCriteriaPersons = criteria.meetCriteria(people);
        return otherCriteria.meetCriteria(fristCriteriaPersons);
    }
}

class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otheCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otheCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> fristCriteriaPersons = criteria.meetCriteria(people);
        List<Person> secondCriteriaPersons = otherCriteria.meetCriteria(people);
        for (Person person : secondCriteriaPersons) {
            if (!fristCriteriaPersons.contains(person)) {
                fristCriteriaPersons.add(person);
            }
        }
        return fristCriteriaPersons;
    }
}

class NotCriteria implements Criteria {
    private Criteria criteria;

    public NotCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> people) {
        List<Person> criteriaPersons = criteria.meetCriteria(people);
        List<Person> notCriteriaPersons = new ArrayList<>();
        for (Person person : people) {
            if (!criteriaPersons.contains(person)) {
                notCriteriaPersons.add(person);
            }
        }
        return notCriteriaPersons;
    }
}

class MaleCritera implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> males = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("Male")) {
                males.add(person);
            }
        }
        return males;
    }
}

class FemaleCriteria implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> females = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("Female")) {
                females.add(person);
            }
        }
        return females;
    }
}

class SingleCriteria implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singles = new ArrayList<>();
        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("Single")) {
                singles.add(person);
            }
        }
        return singles;
    }
}

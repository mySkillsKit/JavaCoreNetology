package Task2_2_PopulationCensusStream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        //System.out.println(persons);

        //Найти количество несовершеннолетних (т.е. людей младше 18 лет).
        long minorsPersons = persons.stream()
                .filter(value -> value.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних (т.е. людей младше 18 лет): " + minorsPersons);


        //Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        List<String> listOfConscripts = persons.stream()
                .filter(man -> man.getSex().equals(Sex.MAN))
                .filter(man -> man.getAge() >= 18 && man.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Список призывников (т.е. мужчин от 18 и до 27 лет): " + listOfConscripts);


        //Получить отсортированный по фамилии список потенциально работоспособных людей
        // с высшим образованием в выборке
        // (т.е. людей с высшим образованием от 18 до 60 лет
        // для женщин и до 65 лет для мужчин).

        Collection<Person> workingPeopleWithHigherEducation = persons.stream()
                .filter(person -> person.getAge() >= 18)
                .filter(diploma -> diploma.getEducation().equals(Education.HIGHER))
                .filter(person -> {
                    if (person.getSex().equals(Sex.MAN)) {
                        // мужчины до 65 лет
                        return person.getAge() <= 65;
                    }
                    // женщины до 60 лет
                    return person.getAge() <= 60;
                })
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("Работоспособные люди с высшим образованием: " + workingPeopleWithHigherEducation);

    }
}

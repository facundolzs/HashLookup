package main;

import classes.Employee;
import classes.HashLookup;
import enums.Sex;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        ArrayList<Employee> roster = new ArrayList<>();
        roster = loadEmployees();
        Employee[] employeeArray = listToArray(roster);

        HashLookup hash = new HashLookup(employeeArray.length);
        hash.hashFunction(employeeArray);
        hash.displayTable();

        String key = "203469729";
        Employee result = hash.findKey(key);

    }

    /**
     * Fills a list with objects of type Employee
     *
     * @return Employee list
     */
    public ArrayList<Employee> loadEmployees() {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee("Kenneth", "Kennedy", "996602004", Sex.M));
        list.add(new Employee("Andrew", "Gable", "163234534", Sex.M));
        list.add(new Employee("Janet", "Rantz", "203469729", Sex.F));
        list.add(new Employee("Lucy", "Caruso", "239659387", Sex.F));
        list.add(new Employee("Susan", "Anders", "316249532", Sex.F));
        list.add(new Employee("Keith", "Edison", "326498765", Sex.M));
        list.add(new Employee("Anna", "Hill", "261269016", Sex.F));
        list.add(new Employee("Bob", "Blue", "196044855", Sex.M));
        list.add(new Employee("Edward", "Johnson", "396942219", Sex.M));
        list.add(new Employee("Sharon", "Swanson", "491236125", Sex.F));
        list.add(new Employee("William", "Alexander", "419623491", Sex.M));
        list.add(new Employee("Grace", "Everett", "479809381", Sex.F));
        list.add(new Employee("Alice", "Smith", "385312117", Sex.F));
        list.add(new Employee("Gregory", "Mettleson", "632912365", Sex.M));

        return list;
    }

    /**
     * Converts an ArrayList of type Employee to an Array of type Employee
     *
     * @param list
     * @return Employee array
     */
    public Employee[] listToArray(ArrayList<Employee> list) {
        Employee[] array = list.stream()
                .toArray(t -> new Employee[t]);

        return array;
    }

}

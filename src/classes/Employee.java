package classes;

import enums.Sex;

public class Employee {

    private String firstName;
    private String lastName;
    private String SSN; // social Security number
    private Sex sex;

    public Employee(String firstName, String lastName, String SSN, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        setSSN(SSN);
        this.sex = sex;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSSN(String SSN) {
        this.SSN = (SSN.length() < 9 || SSN.length() > 9) ? "000000000" : SSN;
    }

    @Override
    public String toString() {
        return "Full name: " + getFullName() + "\nSex: " + getSex() + "\nSNN: " + getSSN();
    }

}

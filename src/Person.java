/**
 * it handles a person who wants to vote
 * @author Mobina Hadavifar
 * @version 1.0
 */
public class Person {

    private String firstName;
    private String lastName;

    /**
     * makes a person
     * @param firstName person's first name
     * @param lastName person's last name
     */
    public Person (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the frst name
     */
    public String getFirstName (){
        return firstName;
    }

    /**
     * @return the last name
     */
    public String getLastName (){
        return lastName;
    }

    @Override
    public String toString (){
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals (Object o){
        Person person = (Person) o;
        if (this.getFirstName().equals(person.getFirstName()) && this.getLastName().equals(person.getLastName()))
            return true;
        return false;
    }



}

/**
 * it keeps the information of each vote
 * @author Mobina Hadavifar
 * @version 1.0
 */
public class Vote {

    private Person person;
    private String date;

    /**
     * makes a vote
     * @param person who has voted
     * @param date the person voted in
     */
    public Vote (Person person, String date){
        this.person = person;
        this.date = date;
    }

    /**
     * @return the person who has voted
     */
    public Person getPerson (){
        return person;
    }

    /**
     * @return the date the person has voted
     */
    public String getDate (){
        return date;
    }

    @Override
    public boolean equals (Object o){
        Vote vote = (Vote) o;
        if (person.equals(((Vote) o).person))
            return true;
        return false;
    }


}

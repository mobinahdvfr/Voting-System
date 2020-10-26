import ir.huri.jcal.JalaliCalendar;

import java.util.*;

/**
 * it works with voting and its information
 * @author Mobina Hadavifar
 * @version 1.0
 */
public class Voting {

    //voting type. 0 if people can only vote for 1 person, 1 if more than 1
    private int type;
    private String question;
    private ArrayList<Person> voters;
    private HashMap<String, HashSet<Vote>> choices;

    /**
     * makes a voting
     * @param type it's type. 0 if user can only vote for one choice and 1 if more than one choice
     * @param question voting's question
     */
    public Voting (int type, String question){
        this.type = type;
        this.question = question;
        choices = new HashMap<>();
        voters = new ArrayList<>();
    }

    /**
     * @return the voting's question
     */
    public String getQuestion (){
        return question;
    }

    /**
     * adds a new choice
     * @param name of choice
     */
    public void createChoice (String name){
        for (String choice : choices.keySet()){
            if (choice.equals(name)){
                System.out.println("The choice already exists!");
                return;
            }
        }
        choices.put(name, new HashSet<>());
    }

    /**
     * user can vote with it
     * @param person who wants to vote
     * @param names the choices the person wants to vote for
     */
    public void vote (Person person, ArrayList<String> names){
        if (type == 0 && names.size() > 1) {
            System.out.println("You can only vote for 1 choice!");
            return;
        }
        int i =0;
        for (Person p : voters){
            if (person.equals(p)) {
                person = p;
                i = 1;
                break;
            }
        }
        if (i == 0)
            voters.add(person);

        JalaliCalendar j = new JalaliCalendar();
        String date = String.valueOf(j.getYear());
        if (j.getMonth() < 10){
            date = date + "0" + j.getMonth();
        } else
            date = date + j.getMonth();

        if (j.getDay() < 10){
            date = date + "0" + j.getDay();
        } else
            date = date + j.getDay();

        for (String name : names){
            if (choices.containsKey(name)) {
                Iterator<Vote> it = choices.get(name).iterator();
                while (it.hasNext()){
                    if (it.next().getPerson().equals(person)){
                        System.out.println("You've voted for this choice before!");
                        return;
                    }
                }
                choices.get(name).add(new Vote(person, date));
                System.out.println("You successfully voted for " + name);
            }
            else
                System.out.println("Couldn't vote for " + name + "! It doesn't exist!");
        }

    }

    /**
     * prints the choices with their votes
     */
    public void printVotes (){
        int i = 1;
        for (Map.Entry<String, HashSet<Vote>> entry : choices.entrySet()){
            System.out.println("Choice " + i + ": " + entry.getKey() + " -> " + entry.getValue().size() + " votes");
            i++;
        }
    }

    /**
     * shows the result of voting
     */
    public void getResult (){
        int max = 0 ;
        String maxVoteChoice = "";
        for (Map.Entry<String, HashSet<Vote>> entry : choices.entrySet()){
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                maxVoteChoice = entry.getKey();
            }
        }
        System.out.println("Choice " + maxVoteChoice + " has the most number of votes :" + max);
    }

    public HashMap<String, HashSet<Vote>> getChoices (){
        return choices;
    }




}

import java.util.ArrayList;

/**
 * it handles a voting system
 * @author Mobina Hadavifar
 * @version 1.0
 */
public class VotingSystem {

    private ArrayList<Voting> votingList;

    /**
     * makes a voting system
     */
    public VotingSystem (){
        votingList = new ArrayList<>();
    }

    /**
     * it will add a speciall voting to the system
     * @param votingQuestion the voting's question
     * @param votingType voting's type
     * @param choices voting's choices
     */
    public void createVoting (String votingQuestion , int votingType , ArrayList<String> choices){
        Voting voting = new Voting(votingType, votingQuestion);
        for (String choice : choices){
            voting.createChoice(choice);
        }
        votingList.add(voting);
    }

    public ArrayList<Voting> getVotingList (){
        return votingList;
    }

    public Voting getVoting (int index){
        return votingList.get(index-1);
    }

    /**
     * user can vote with it
     * @param number number of voting
     * @param person the person who wants to vote
     * @param choices the choices person wants to vote for
     */
    public void vote (int number, Person person, ArrayList<String> choices){
        votingList.get(number-1).vote(person, choices);
    }

    public void printResult (int number){
        votingList.get(number-1).getResult();
    }

    /**
     * prints all the votings
     */
    public void printListOfVotings (){
        int i = 1;
        for (Voting voting : votingList){
            System.out.println(i + ". " + voting.getQuestion());
            i++;
        }
    }

    /**
     * prints a special voting's information
     * @param number of the voting we want
     */
    public void printVoting (int number){
        System.out.println(votingList.get(number-1).getQuestion() + " :");
        votingList.get(number-1).printVotes();
//        for (String choice : votingList.get(number-1).getChoices().keySet()){
//            System.out.println(choice);
//        }
    }


}

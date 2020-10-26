import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        VotingSystem votingSystem = new VotingSystem();
        Person person = new Person("Mobina", "Hadavifar");
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Pink");


        //checking the methods
        votingSystem.createVoting("Favorite color", 0, colors);
        votingSystem.printListOfVotings();
        votingSystem.printVoting(1);
        System.out.println("*********************************");


        //showing that if the voting type is 0, user can't vote for more than 1 choice
        votingSystem.vote(1, person, colors);
        System.out.println("*********************************");


        //checking vote method
        ArrayList<String> voteColor = new ArrayList<>();
        voteColor.add("Pink");
        votingSystem.vote(1,person, voteColor);
        votingSystem.printVoting(1);
        System.out.println("*********************************");


        //showing that user can't vote for the same choice twice
        votingSystem.vote(1,person, voteColor);
        votingSystem.printVoting(1);
        System.out.println("**********************************");

        //showing the result
        votingSystem.getVoting(1).getResult();

    }


}

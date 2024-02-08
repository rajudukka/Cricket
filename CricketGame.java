package com.test.cricketgame;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Player
{
	public  String playerName;
	public  String speciality;
	public int runs;
	public  int wickets;
	
	public Player(String playerName, String speciality)
	{
		this.playerName=playerName;
		this.speciality=speciality;
		this.wickets=0;
	}
	public void setWickets()
	{
		this.wickets=1;
	}
}


 class Team
{
	public String teamCountry;
	  List<Player> players = new ArrayList();
	
	public Team(String teamCountry)
	{
		this.teamCountry=teamCountry;	
	}
}
class Match
{
	public void startMatch( Team team1, Team team2)
	{
		int team1TotalScore = batting(team1, team2);
		int team2TotalScore = batting(team2, team1);
		
		System.out.println(team1.teamCountry+" score "+team1TotalScore);
		System.out.println(team2.teamCountry+" score "+team2TotalScore);

		if(team1TotalScore > team2TotalScore)
			System.out.println(team1.teamCountry+" is won the match ");
		else if(team1TotalScore < team2TotalScore)
			System.out.println(team2.teamCountry+" is won the match ");
		else
			System.out.println("The result of a match is a 'tie'");
	}
	public int batting(Team batting, Team bowling)
	{
		
		for(Player player : batting.players)
		{
			int w=1;
			for(int i=1; i<=120 && w<=10 ; i++)
			{
				int score = generateRandomScore();
				if(score <= 6)
					player.runs=player.runs+score;
				else
				{
					player.setWickets();
					w++;
					break;			// break means out;
				}
					        
			}
			 
		}
		
		
		
		int totalScore=0;
		
		for(Player player : batting.players)
		{
			 totalScore = totalScore+player.runs;
			 
		}
		return totalScore;
	
	}
	
	public int generateRandomScore()
	{
		Random random=new Random();
		return random.nextInt(10);
	}
}
public class CricketGame {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two countries");
		String firstCountry=sc.next();
		String secondCountry=sc.next();

		Match match=new Match();
		
		Player i1 = new Player("i1","batter");
		Player i2 = new Player("i2","batter");
		Player i3 = new Player("i3","batter");
		Player i4 = new Player("i4","batter");
		Player i5 = new Player("i5","batter");
		Player i6 = new Player("i6","batter");
		Player i7 = new Player("i7","batter");
		Player i8 = new Player("i8","bowler");
		Player i9 = new Player("i9","bowler");
		Player i10= new Player("i10","bowler");
		Player i11= new Player("i11","bowler");

		Player e1 = new Player("e1","batter");
		Player e2 = new Player("e2","batter");
		Player e3 = new Player("e3","batter");
		Player e4 = new Player("e4","batter");
		Player e5 = new Player("e5","batter");
		Player e6 = new Player("e6","batter");
		Player e7 = new Player("e7","batter");
		Player e8 = new Player("e8","bowler");
		Player e9 = new Player("e9","bowler");
		Player e10= new Player("e10","bowler");
		Player e11= new Player("e11","bowler");
		
		Team t1 = new Team(firstCountry);
		Team t2 = new Team(secondCountry);
		t1.players.addAll(Arrays.asList(i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11));
		t2.players.addAll(Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11));
		
		
		match.startMatch(t1, t2);
		
		for(Player player : t1.players)
		{
			System.out.println(player.playerName+" : "+player.runs);
		}

		CricketGame obj = new CricketGame();
		obj.newTeam(t1);
	}
	static int totalScore= 0;
	public  static void  newTeam(Team t1)
	{
		
		for(Player player : t1.players)
		{
			 totalScore = totalScore + player.runs;
		}
		float avrgScore= totalScore/11;
		//return avrgScore;
		System.out.println("the avarage score of the first team "+avrgScore);

		System.out.println("total Score"+totalScore);
	}
	

	

}


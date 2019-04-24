package Yahtzee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		
		YahtzeeSpel ys = new YahtzeeSpel();
		System.out.println("[1  2  3  4  5]");
		System.out.println(YahtzeeSpel.Dobbelstenen);
		ys.spelen();
	}
}

class YahtzeeSpel{
	
	static List<Integer> Dobbelstenen = new ArrayList<>();
	static int[] blokkeren = new int[5];
	
	YahtzeeSpel(){
		int dobbelsteenEen = 0;
		int dobbelsteenTwee = 0;
		int dobbelsteenDrie = 0;
		int dobbelsteenVier = 0;
		int dobbelsteenVijf = 0;
		
		Dobbelstenen.add(dobbelsteenEen);
		Dobbelstenen.add(dobbelsteenTwee);
		Dobbelstenen.add(dobbelsteenDrie);
		Dobbelstenen.add(dobbelsteenVier);
		Dobbelstenen.add(dobbelsteenVijf);
		
	}
	
	Scanner sc = new Scanner(System.in);
	boolean running = true;
	
	void spelen() {
		while (running) {
			String invoer = sc.nextLine();
			
			switch (invoer) {
				case "q":{
					System.out.println("Je bent gestopt.");
					running = false;
					break;
				}
				case "d":{
					int index = 0;
					for (int element : YahtzeeSpel.Dobbelstenen) {
						element = Dobbelsteen.werpen();
						YahtzeeSpel.Dobbelstenen.set(index, element);
						index++;
						
					}
					System.out.println("[1  2  3  4  5]");
					System.out.println(YahtzeeSpel.Dobbelstenen);
					break;
				}
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":{
					vasthouden();
					break;
				}
				default:{
					System.out.println("Er gaat iets fout. Voer een 'd' in om een dobbelsteen te gooien of 'q' om te stoppen.");
				}
			}
		}
	}
	
	void vasthouden() {
		String invoer = sc.nextLine();
		System.out.println("Type de nummers van de getallen die je vast wilt houden. 1 t/m 5.");
		switch (invoer) {
			case "1":{
				//Boel vasthouden op index 0.
				System.out.println("Je wil cijfer 1 vasthouden.");
				break;
			}
			case "2":{
				//Boel vasthouden op index 1.
				System.out.println("Je wil cijfer 2 vasthouden.");
				break;
			}
			case "3":{
				//Boel vasthouden op index 2.
				System.out.println("Je wil cijfer 3 vasthouden.");
				break;
			}
			case "4":{
				//Boel vasthouden op index 3.
				System.out.println("Je wil cijfer 4 vasthouden.");
				break;
			}
			case "5":{
				//Boel vasthouden op index 4.
				System.out.println("Je wil cijfer 5 vasthouden.");
				break;
			}
			default:{
				System.out.println("Er gaat iets fout. Voer een andere waarde in.");
			}
		}
	}
}

class Dobbelsteen {
	
	static int werpen() {
		Random dobbelen = new Random();
		int dobbelNummer = dobbelen.nextInt(6) +1;
//		System.out.println(dobbelNummer);
		return dobbelNummer;
	}
}


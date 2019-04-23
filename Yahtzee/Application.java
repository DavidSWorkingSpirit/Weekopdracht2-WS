package Yahtzee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		
		YahtzeeSpel ys = new YahtzeeSpel();
		System.out.println(YahtzeeSpel.Dobbelstenen);
		ys.spelen();
	}
}

class YahtzeeSpel{
	
	static List<Integer> Dobbelstenen = new ArrayList<>();
	
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
//					werpen(); // hier moet de waarde aan 5 willekeurige dobbelstenen worden toegevoegd na 'enter'(??)
					for (int element : YahtzeeSpel.Dobbelstenen) {
						int index = 0;
						element = Dobbelsteen.werpen();
						index++;
						YahtzeeSpel.Dobbelstenen.set(index, element);
//						index++;
						System.out.println(YahtzeeSpel.Dobbelstenen);
						break;
					}
					break;
				}
				default:{
					System.out.println("Er gaat iets fout. Voer een 'd' in om een dobbelsteen te gooien of 'q' om te stoppen.");
				}
			}
		}
	}
}

class Dobbelsteen {
	
	static int werpen() {
		Random dobbelen = new Random();
		int dobbelNummer = dobbelen.nextInt(6) +1;
		System.out.println(dobbelNummer);
		return dobbelNummer;
	}
}

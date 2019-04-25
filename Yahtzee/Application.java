package Yahtzee;

import java.util.ArrayList;
import java.util.Arrays;
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
	static int[] blokkeren = new int[] {0, 0, 0, 0, 0};
	
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
						if (blokkeren[index] == 0) {
						element = Dobbelsteen.werpen();
						YahtzeeSpel.Dobbelstenen.set(index, element);
						}
						index++;
						
					}
					System.out.println("[1  2  3  4  5]");
					System.out.println(YahtzeeSpel.Dobbelstenen);
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
		System.out.println("Type de nummers van de getallen die je vast wilt houden. 1 t/m 5.");
		String invoer = sc.nextLine();
		
		for (int i = 0; i < invoer.length(); i++) {
			String index = invoer.substring(i, i + 1);
			Integer positie = Integer.parseInt(index) -1;
			blokkeren[positie] = 1;
			
		}
		System.out.println(Arrays.toString(blokkeren));

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


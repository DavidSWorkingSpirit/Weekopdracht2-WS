package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		YahtzeeSpel ys = new YahtzeeSpel();
		Speler speler1 = new Speler();
		Speler speler2 = new Speler();
//		System.out.println("[1  2  3  4  5]");
//		System.out.println(YahtzeeSpel.Dobbelstenen);
		
		System.out.println("Speler 1 is aan de beurt om te gooien.");
		System.out.println("Druk op ENTER om te gooien.");
		ys.spelen(speler1);

		System.out.println("Speler 2 is aan de beurt om te gooien.");
		System.out.println("Druk op ENTER om te gooien.");
		ys.spelen(speler2);
		
		System.out.println("Einde van het spel. Bedankt voor het spelen!");
	}
}

class YahtzeeSpel{
	
	static List<Integer> Dobbelstenen = new ArrayList<>();
	static int[] blokkeren = new int[] {0, 0, 0, 0, 0};
	static int eindeSpeelbeurt = 3;
	
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
	
	void spelen(Speler speler) {
		for(int speelbeurt = 0; speelbeurt < eindeSpeelbeurt;) {
			running = true;
			Reset.resetten();	//			RESET METHOD HERE
			Speler.worpGeschiedenis.clear();
			
			while (running) {
				String invoer = sc.nextLine();
				
				if(speelbeurt == 3) {
					running = false;
					break;
				}
				
				switch (invoer) {
					case "q":{
						System.out.println("Je bent gestopt.");
						running = false;
						break;
					}
					case "":{
						int index = 0;
	
						for (int element : YahtzeeSpel.Dobbelstenen) {
							if (blokkeren[index] == 0) {
							element = Dobbelsteen.werpen();
							YahtzeeSpel.Dobbelstenen.set(index, element);
							}
							index++;
							
						}
						
						System.out.println("Worp " + (speelbeurt + 1));
						System.out.println("[1  2  3  4  5]");
						System.out.println(YahtzeeSpel.Dobbelstenen);
						vasthouden();
						Speler.worpGeschiedenis.addAll(Dobbelstenen);
						int a = 0;
						
						System.out.println("Je worpgeschiedenis is:");
						for (int b = 5; b <= Speler.worpGeschiedenis.size(); b += 5) {
							System.out.println(Speler.worpGeschiedenis.subList(a, b));
							a += 5;
						}
						
						if (CheckYahtzee.yahtzeeCheck() == true) {
							System.out.println("YAHTZEE!");
							speelbeurt = 999;
							running = false;
							break;
						}
						
						speelbeurt++;
						break;
						
					}
					default:{
						System.out.println("Er gaat iets fout. Voer een 'd' in om een dobbelsteen te gooien of 'q' om te stoppen.");
					}
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

class Speler {
	
	public static List<Integer> worpGeschiedenis = new ArrayList<>();

}

class Reset {
	
	static void resetten() {
		int r = 0;
		
		for (r = 0; r < YahtzeeSpel.blokkeren.length; r++) {
			if(YahtzeeSpel.blokkeren[r] != 0) {
				YahtzeeSpel.blokkeren[r] = 0;
			}
		}
	}
}

class CheckYahtzee {
	
	public static boolean yahtzeeCheck() {

	     int eersteGetal = YahtzeeSpel.Dobbelstenen.get(0);
	     for (int i = 0; i < YahtzeeSpel.Dobbelstenen.size(); i++) {
	         if (YahtzeeSpel.Dobbelstenen.get(i) != eersteGetal) {
	             return false;
	         }
	      }
	      return true;	
	}
}


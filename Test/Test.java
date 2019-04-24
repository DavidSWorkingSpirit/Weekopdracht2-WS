package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		YahtzeeSpel ys = new YahtzeeSpel();
		System.out.println(YahtzeeSpel.Dobbelstenen);
		ys.spelen();
	}
}

class YahtzeeSpel{
	
	static List<Integer> Dobbelstenen = new ArrayList<>();
	
	YahtzeeSpel(){
		Integer dobbelsteenEen = 0;
		Integer dobbelsteenTwee = 0;
		Integer dobbelsteenDrie = 0;
		Integer dobbelsteenVier = 0;
		Integer dobbelsteenVijf = 0;
		
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
					for (Integer index : YahtzeeSpel.Dobbelstenen) {
						System.out.println(index);
						YahtzeeSpel.Dobbelstenen.set(index, Dobbelsteen.werpen());
						System.out.println(index);
						break;
					}
					System.out.println(YahtzeeSpel.Dobbelstenen);
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



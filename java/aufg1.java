import de.medieninf.ads.ADSTool;

public class aufg1 {
	
	public static void main(String[] args) {
		int a = 17;
		int b = 42;
		System.out.println(multi(a,b));
	}
	
	public static int multi(int a, int b){
		int ergebnis = 0;
		while(a>0){
			if(a % 2 != 0)
			ergebnis += b;
			a/=2;
			b *= 2;
		}
		return  ergebnis;
	}

}

/*
 *  Wieviele Iterationen benötigt die oben beschriebene Methode?
 * Log(Zahl1) zur Basis 2
 *  
 *  Ist die oben beschriebene Methode “besser” als die in der Schule gelernte
	Methode zur schriftlichen Multiplikation zweier Zahlen?
	
	+ simplere Operationen.
	- mehr Iterationen
	 
 *  
 */
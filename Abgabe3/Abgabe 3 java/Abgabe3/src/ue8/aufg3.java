package ue8;



import java.util.Scanner;

import de.medieninf.ads.ADSTool;

public class aufg3 {
	public final static int WEISS = 0x00FFFFFF;// SCHWARZ = 0x00000000;
	public final static int  GRUEN = 0x0000FF00;
	public final static int HELLGRAU = 0x00AAAAAA;
	public final static int HELLGRUEN = 0x00AAFFAA;
	public final static int ROT = 0x00FF0000;
	

    
    public static int [][]  drawlab(int [] laby,int color){
    	// Größe des Laby bestimmen
    	int size = 0;
    	for (int i = 0; i < laby.length; i++) {
			if(laby[i] == 0)break;
			size++;
		}
    	
    	
		int [] [] lab = new int[size] [size];
		int j = 0;
			for (int k = 0; k < lab.length; k++) {
				for (int l = 0; l < lab.length; l++) {
					if(laby[j] == 0) j++;
					lab[k] [l] = laby[j];
					
					
					//Einfärben
					if(lab[k][0] == 1){
						lab[k] [0] = ROT;
					} else if(lab[k][size-1] == 1){
						lab[k] [size-1] = ROT;
					}
					if(lab[k] [l] == 1) lab[k] [l] = color;
					
					j++;
				}
			}
			return lab;
    }
    
    public static int[] ini(String inputString){
    	int []  bsp = null;
	    switch (inputString) {
		case "laby0":
			 return bsp  = ADSTool.readIntArray("labs/laby0.dat");
		case "laby1":
			return bsp  = ADSTool.readIntArray("labs/laby1.dat");
		case "laby2":
			return bsp  = ADSTool.readIntArray("labs/laby2.dat");
		case "laby3":
			return bsp  = ADSTool.readIntArray("labs/laby3.dat");
		case "laby4":
			return bsp  = ADSTool.readIntArray("labs/laby4.dat");
		case "laby5":
			return bsp  = ADSTool.readIntArray("labs/laby5.dat");
		default:
			return null;
		}
    }
    
    public static void raster(int [][] laby){
	    ADSTool.raster(laby);
	    ADSTool.showGraph();
    }
    public static void rasterMultiple(){
    	while(true){
    		
    	}
    }
    
	
	public static void main(String[] args) {
		int color = 0;
		int [][] laby = null;
	    Scanner scanner = new Scanner(System.in);
	    String inputString = scanner.nextLine();
	    String[] split = inputString.split(" ");
	    int length = split.length;
	    
	   if(length == 1){		//1 Lab wird aufgerufen
			laby = drawlab(ini(split[0]), WEISS);
			raster(laby);
	   } else if(length == 2){	// 1 Lab mit Farbe Hellgrau wird aufgerufen
			laby = drawlab(ini(split[1]), HELLGRAU);
			raster(laby);	
	   } else {	//Mehrere Labs werden aufgerufen
			if(split[0].equalsIgnoreCase("-v")){	//Falls noch Farbenaufruf
				if(split[2].contains("lab")){
					//2 sekunden schalten
					for (int i = 2; i <= split.length; i++) {
						laby = drawlab(ini(split[i]), HELLGRAU);
						raster(laby);
						ADSTool.schlafe(2000);
					}
				} else {	
					int time =Integer.parseInt(split[2]) * 1000;
					System.out.println(split.length);
					for (int i = 3; i < split.length; i++) {
						laby = drawlab(ini(split[i]), HELLGRAU);
						raster(laby);
						ADSTool.schlafe(time);
					}
				}
			} else{ //Labs ohne Farbenaufruf
				if(split[1].contains("lab")){
					//2 sekunden schalten
					for (int i = 1; i < split.length; i++) {
						laby = drawlab(ini(split[i]), WEISS);
						raster(laby);
						ADSTool.schlafe(2000);
					}
				} else {
					int time = Integer.parseInt(split[2])*1000;
					for (int i = 2; i < split.length; i++) {
						laby = drawlab(ini(split[i]), WEISS);
						raster(laby);
						ADSTool.schlafe(time);
					}
				}
			}
	   }
	}
}
				


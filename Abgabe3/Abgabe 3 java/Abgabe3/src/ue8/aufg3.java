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
    	int breite = 0;
    	for (int i = 0; i < laby.length; i++) {
			if(laby[i] == 0)break;
			breite++;
		}
    	
    	int höhe = (laby.length/breite-1);
		int [] [] lab = new int[höhe] [breite];
		

		System.out.println("Höhe: "+höhe);
		System.out.println("Breite: "+breite);
		int j = 0;
			for (int k = 0; k < höhe; k++) {
				for (int l = 0; l < breite; l++) {
					if(laby[j] == 0) j++;
					lab[k] [l] = laby[j];
					
					//Einfärben
					if(lab[k][0] == 1){
						lab[k] [0] = ROT;
					} else if(lab[k][breite-1] == 1){
						lab[k] [breite-1] = ROT;
					}
					if(lab[k] [l] == 1) lab[k] [l] = color;
					
					j++;
				}
			}
			return lab;
    }
    
    public static int[] ini(String inputString){
    	int []  bsp = null;
    	String path= "labs/"+inputString+".dat";
		return bsp  = ADSTool.readIntArray(path);
    }
    
    public static void raster(int [][] laby){
    	ADSTool.clearGraph();
	    ADSTool.raster(laby);
	    ADSTool.showGraph();
    }
    public static void rasterMultiple(String split[], int [][] laby,int time,int i,int color){
		for (i = i;i < split.length; i++) {
			laby = drawlab(ini(split[i]), color);
			raster(laby);
			ADSTool.schlafe(time);
		}
    }
    
	
	public static void main(String[] args) {

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
					rasterMultiple(split, laby, 2000, 2,HELLGRAU);
				} else {	
					int time =Integer.parseInt(split[2]) * 1000;
					System.out.println(split.length);
					rasterMultiple(split, laby, time, 3,HELLGRAU);

				}
			} else{ //Labs ohne Farbenaufruf
				if(split[1].contains("lab")){
					//2 sekunden schalten
					rasterMultiple(split, laby, 2000, 1,WEISS);
				} else {
					int time = Integer.parseInt(split[1])*1000;
					rasterMultiple(split, laby, time, 2,WEISS);
				}
			}
	   }
	}
}
				


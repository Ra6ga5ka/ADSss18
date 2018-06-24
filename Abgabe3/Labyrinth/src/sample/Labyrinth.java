package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Labyrinth {
    public int[][] field;
    public int[] Startpos = {0,0};

    public Labyrinth(String filePath) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader(filePath));
        //StringBuilder sb = new StringBuilder();
        LinkedList<String> sb = new LinkedList<String>();
        while(in.hasNext()) {
            sb.add(in.next());
        }
        in.close();
        int size = (int)(Math.sqrt(sb.size()))+1;
        System.out.println(size);
        field = new int[size][size];
        System.out.println(sb.size());

        for(int i =0;i<sb.size();i++){
            int x=i%(size);
            int y=i/(size);
            field[x][y]=Integer.parseInt(sb.get(i));
            if((x==0||x==size-2)&&field[x][y]==1){
                field[x][y]=0;
            }
            //System.out.println(field[x][y]+","+x+","+y);
        }

        for (int i = 0; i < this.field.length; i++) {
            if (this.field[0][i] == 0) {
                this.Startpos[1] = i;
                this.Startpos[0] = 1;
                //System.out.println("startPos: " + this.Startpos[0] + " " + this.Startpos[1]);
                break;
            }
        }
    }
    public void generateStartPos(){
        for (int i = 0; i < this.field.length; i++) {
            if (this.field[0][i] == 0) {
                this.Startpos[1] = i;
                this.Startpos[0] = 1;
                //System.out.println("startPos: " + this.Startpos[0] + " " + this.Startpos[1]);
                break;
            }
        }
    }
}

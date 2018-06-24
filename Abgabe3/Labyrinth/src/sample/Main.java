package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Main extends Application {

    static LinkedList<String> Labs = new LinkedList<String>();
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int SizeX = 400;
    static int SizeY = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Labyrinth Lab = new Labyrinth("bin/laby0.dat");
        //root.getChildren().add(buildLab(Lab));
        LinkedList<Integer> path = findPath(Lab.field, Lab.Startpos, 1);
        if (path != null)
            Lab.generateStartPos();
            drawSollution(Lab.field, path, Lab.Startpos);
        root.getChildren().add(buildLab(Lab));
        primaryStage.setTitle("Labyrinth");
        primaryStage.setScene(new Scene(root, SizeX, SizeY));
        primaryStage.show();
    }

    public GridPane buildLab(Labyrinth lab) {
        GridPane grid = new GridPane();
        int size = lab.field.length - 1;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Rectangle field = new Rectangle(0, 0, SizeX / size, SizeY / size);
                switch (lab.field[x][y]) {
                    case 0:
                        field.setFill(Color.RED);
                        break;
                    case 1:
                        field.setFill(Color.WHITE);
                        break;
                    case 2:
                        field.setFill(Color.BLACK);
                        break;
                    case 3:
                        field.setFill(Color.GREEN);
                        break;
                }
                //field.setFill(Color.BLACK);
                grid.add(field, x, y);
            }
        }
        return grid;
    }

    private void drawSollution(int[][] lab, LinkedList<Integer> sollution, int[] startPos) {
        int[] currentPos = startPos;
        currentPos[0] = 0;
        System.out.println(startPos[0]+" "+startPos[1]);
        for (int i : sollution) {
            //System.out.println(i);
            //currentPos[0] += directions[i][0];
            //currentPos[1] += directions[i][1];
            if(currentPos[0]==-1||currentPos[1]==-1)
                return;
            lab[currentPos[0]][currentPos[1]] = 3;
            currentPos[0] += directions[i][0];
            currentPos[1] += directions[i][1];
        }
    }

    private LinkedList<Integer> findPath(int[][] lab, int[] StartPos, int direction) {
        System.out.println(StartPos[0]+" "+StartPos[1]);
        //Direction is 0=Up 1=Right 2=Down 3=Left
        LinkedList<Integer> Path = new LinkedList<Integer>();
        Path.add(direction);
        //System.out.println(lab[(StartPos[0]+0)][(StartPos[1]+1)]);
        int current = lab[StartPos[0]][StartPos[1]];
        if (lab[StartPos[0]][StartPos[1]] == 0) {
            return Path;
        } else if (current == 2) {
            return null;
        } else {
            LinkedList<Integer> posDirections;
            int d=0;
            while (100-d!=0) {
                d++;
                posDirections = new LinkedList<Integer>();
                for (int i = 0; i < 4; i++) {
                    //int destination =lab[(StartPos[0]+directions[i][0])][(StartPos[1]+directions[i][1])];
                    //System.out.println("destination: "+destination+" come from direction:"+(2+direction)+" "+((i+2)%4));
                    if ((i + 2) % 4 != direction) {
                        int destination =  lab[(StartPos[0] + directions[i][0])][(StartPos[1] + directions[i][1])];
                        if (destination== 1||destination==0) {
                            posDirections.add(i);
                        }
                    }
                }
                if (posDirections.size() == 0)
                    return null;
                else if (posDirections.size() == 1) {
                    direction =posDirections.get(0);
                    StartPos[0] = StartPos[0] + directions[direction][0];
                    StartPos[1] = StartPos[1] + directions[direction][1];
                    Path.add(posDirections.get(0));
                    if(lab[StartPos[0]][StartPos[1]] == 0)
                        return Path;
                } else {
                    for (int i : posDirections) {
                        LinkedList<Integer> subPath = findPath(lab, new int[]{(StartPos[0] + directions[i][0]), (StartPos[1] + directions[i][1])}, i);
                        if (subPath != null) {
                            for (int dir : subPath) {
                                Path.add(dir);
                            }
                            return Path;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Labs.add(args[i]);
        }
        launch(args);
    }
}

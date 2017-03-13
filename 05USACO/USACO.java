import java.util.*;
import java.io.*;
//Worked with Naotaka Kinoshita
public class USACO {
    
    public USACO() {
    }

    public int bronze(String filename) {
        int[][] pasture;
        int[][] instructions;
        int rows = 0;
        int cols = 0;
        int instruct = 0;
        int elevation = 0;
        int[] firstLine = new int[4];
        try {
            Scanner scan = new Scanner(new File(filename));
            for (int i = 0; i < 4; i ++) {
                firstLine[i] = scan.nextInt();
            }
            rows = firstLine[0];
            cols = firstLine[1];
            elevation = firstLine[2];
            instruct = firstLine[3];
            pasture = new int[rows][cols];
            for (int i = 0; i < rows; i ++) {
                for (int c = 0; c < cols; c ++) {
                    pasture[i][c] = scan.nextInt();
                }
            }
            instructions = new int[instruct][3];
            for (int i = 0; i < instruct; i ++) {
                for (int c = 0; c < 3; c ++) {
                    instructions[i][c] = scan.nextInt();
                }
            }
        
        for (int i = 0; i < instructions.length; i ++) {
            for(int d = 0; d < instructions[i][2]; d++){
                stomp(instructions[i][0], instructions[i][1], pasture);
            }
            printArray(pasture);
            System.out.println();
        }
        
        int depth = 0;
        for(int r = 0; r < pasture.length; r++){
            for(int c=0; c < pasture[0].length; c++){
                if(pasture[r][c] < elevation){
                    depth += elevation - pasture[r][c];
                }
            }

        }
        return depth * 72 * 72;
        }catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(0);
        }
        return -1;
    }

    private void printArray(int[][] ary){
        for(int r = 0; r < ary.length; r++){
            for(int c=0; c < ary[0].length; c++){
                System.out.print(ary[r][c] + " " );
            }
            System.out.println();
        }
    }

    public boolean stomp(int r, int c, int[][] pasture) {
        int highR = r - 1;
        int highC = c - 1;
        for (int row = r - 1; row < r+2; row ++) {
            for (int col = c - 1; col < c+2; col ++) {
                if (pasture[row][col] > pasture[highR][highC]) {
                    highR = row;
                    highC = col;
                }
            }
        }
        int highest = pasture[highR][highC];
        for (int row = r - 1; row < r+2; row ++) {
            for (int col = c - 1; col < c+2; col ++) {
                if (pasture[row][col] == highest) {
                    pasture[row][col] -= 1;
                }
            }
        }
        return true;
    }


    
    public static void main(String[]args) {
        USACO x = new USACO();
        System.out.println(x.bronze("makelake.1.in"));
        System.out.println(x.bronze("makelake.2.in"));
        System.out.println(x.bronze("makelake.3.in"));
    }
}

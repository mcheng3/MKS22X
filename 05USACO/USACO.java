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
            //printArray(pasture);
            //System.out.println();
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
    private void printArray(int[][][] ary){
        for(int d = 0; d < ary.length; d++){
            for(int r = 0; r < ary[0].length; r++){
                for(int c=0; c < ary[0][0].length; c++){
                    System.out.print(ary[d][r][c] + " " );
                }
                System.out.println();
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

    public int silver(String filename){
        int[][][] pasture;
        int[][] instructions;
        int r1, c1, r2, c2;
        int[] firstLine = new int[4];
        try {

            Scanner scan = new Scanner(new File(filename));
            for (int i = 0; i < 3; i ++) {
                firstLine[i] = scan.nextInt();
                //System.out.println(firstLine[i]);
            }
            int rows = firstLine[0];
            int cols = firstLine[1];
            int seconds = firstLine[2];
            pasture = new int[seconds + 1][rows][cols];
            String line = "";

            String file = "";
            for(int i = 0; i < rows + 1; i++){
                line = scan.nextLine();
                file += line;

                
            }
            //System.out.println(file);
            
            for(int d = 0; d<pasture.length; d++){
                int charCount = 0;
                for(int r = 0; r<pasture[0].length; r++){
                    for(int c = 0; c<pasture[0][0].length; c++){
                        if(file.charAt(charCount) == '\n') charCount++;

                        if(file.charAt(charCount) == '.'){
                            pasture[d][r][c] = 0;
                        }
                        if(file.charAt(charCount) == '*'){
                            pasture[d][r][c] = -1;
                        }
                        charCount++;


                    }


                }
            }
           // printArray(pasture);

           // System.out.println(Arrays.deepToString(pasture));
            r1 = scan.nextInt();
            c1 = scan.nextInt();
            r2 = scan.nextInt();
            c2 = scan.nextInt();
            scan.close();
            pasture[0][r1 -1][c1 - 1] = 1;
            for(int s = 1; s < seconds + 1; s++){
                for(int r = 0; r<pasture[0].length; r++){
                    for(int c = 0; c<pasture[0][0].length; c++){
                        if(pasture[s][r][c] == -1);
                        else{
                        try{
                            if(pasture[s-1][r+1][c] == -1);
                            else pasture[s][r][c] += pasture[s-1][r + 1][c];
                        }
                        catch(IndexOutOfBoundsException e){}
                        try{
                            if(pasture[s-1][r-1][c] == -1);
                            else pasture[s][r][c] += pasture[s-1][r - 1][c];
                        }
                        catch(IndexOutOfBoundsException e){}
                        try{
                            if(pasture[s-1][r][c+1] == -1);
                            else pasture[s][r][c] += pasture[s-1][r ][c + 1];
                        }
                        catch(IndexOutOfBoundsException e){}
                        try{
                            if(pasture[s-1][r][c - 1] == -1);
                            else pasture[s][r][c] += pasture[s-1][r][c - 1];
                        }
                        catch(IndexOutOfBoundsException e){}

                    }
                }
            }

        }
       // printArray(pasture);
        return pasture[seconds][r2 - 1][c2 - 1];
    }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(0);
        }

        return -1;

    }


    public static void main(String[]args) {
        USACO x = new USACO();
        System.out.println(x.bronze("makelake.1.in"));
        System.out.println(x.bronze("makelake.2.in"));
        System.out.println(x.bronze("makelake.3.in"));
        System.out.println(x.silver("ctravel.1.in"));
        System.out.println(x.silver("ctravel.2.in"));
        System.out.println(x.silver("ctravel.3.in"));
        System.out.println(x.silver("ctravel.4.in"));
    }
}

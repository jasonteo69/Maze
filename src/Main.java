import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] maze = getMaze("src/inputData");
        ArrayList<String> coords = new ArrayList<String>();
        int row = 0;
        int col = 0;
        int move = 0;
        //coords.add("(" + row + ", " + col + ")");
        //not at bottom right
        while (row != maze.length - 1 && col != maze[0].length - 1) {
            System.out.println(row + ", " + col);
            if (maze[row][col].equals(".") && maze[row][col + 1].equals(".")) {
                move++;
            } else if (maze[row][col].equals(".") && maze[row + 1][col].equals(".")) {
                move++;
            } else if (maze[row][col].equals(".") && maze[row][col - 1].equals(".")) {
                move++;
            } else if (maze[row][col].equals(".") && maze[row - 1][col].equals(".")) {
                move++;
            }
            if (maze[row][col].equals(".") && maze[row][col + 1].equals(".") && move == 1) {
                col++;
            }
            if (maze[row][col].equals(".") && maze[row + 1][col].equals(".") && move == 1) {
                row++;
            }
            else if (maze[row][col].equals(".") && maze[row][col - 1].equals(".") && move == 1) {
                col--;
            }
            else if (maze[row][col].equals(".") && maze[row - 1][col].equals(".") && move == 1) {
                row--;
            }

        }


        for (String path : coords) {
            System.out.print(path + "--->");
        }

    }
    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }

}
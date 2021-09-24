import java.util.*;
import java.io.*;

public class Maze {
    
    static Scanner keyb = new Scanner(System.in);
    static Random rand = new Random();
    
    public static void main(String[] args) {
//         int [][] Rooms = {{1,4,5},
//                           {0,6,2},
//                           {1,7,3},
//                           {2,8,4},
//                           {3,9,0},
//                           {0,10,11},
//                           {1,11,12},
//                           {2,12,13},
//                           {3,13,14},
//                           {4,10,14},
//                           {5,9,15},
//                           {5,6,16},
//                           {6,7,17},
//                           {7,8,18},
//                           {8,9,19},
//                           {10,16,19},
//                           {11,15,17},
//                           {12,16,18},
//                           {13,17,19},
//                           {14,15,18}
//                          };
        
        // B-level --> add statements to read the array values from a file
        String filename = args[0];
        int[][] Rooms = getRoomNumbers(filename);
        //
        
        System.out.println("Welcome to the Maze");
        
        int room_num = 0;
        while (room_num >= 0) {
            //Prompt an input 
            System.out.print("\nEnter a room number (0 to 19), or negative to stop: ");
            room_num = keyb.nextInt();
             if (room_num > 19){
                System.out.printf("There is no room %d\n", room_num);
            }else if (room_num >= 0){
                 System.out.printf("Room %d connects to rooms %d, %d, and %d.\n",
                                  room_num, Rooms[room_num][0], Rooms[room_num][1],
                                  Rooms[room_num][2]);
             }
        }
        
        // A-level --> add statements to implement a random walk through the maze
        int exitRoom = 12;
        int walk = 0;
        System.out.printf("\nThe exit room is %d\n\n" , exitRoom);
        
        while(walk != exitRoom){
            System.out.printf("The walker is in %d\n", walk);
            System.out.printf("Roomn %d connects to %d, %d, and %d.\n", walk, 
                             Rooms[walk][0], Rooms[walk][1], Rooms[walk][2]);
           // TODO change the walk variable to one of the connecting rooms at random
            int nextRoom = rand.nextInt(3);
            switch (nextRoom) {
                case 0:
                    walk = Rooms[walk][0];
                    break;
                case 1:
                    walk = Rooms[walk][1];
                    break;
                case 2:
                    walk = Rooms[walk][2];
                    break;
            }
            System.out.printf("Wanderer chooses Room %d\n\n", walk);
        }
                    
       System.out.println("\nBye.");    
    }
    
    // int[][] Rooms2 = getRoomNumbers();
    static int[][] getRoomNumbers(String filename) {
        
        int numRows = 20;
        int numCols = 3;
        int[][] fileRooms = new int[numRows][numCols];
        
        try (Scanner fileScan = new Scanner(new File(filename))) {
            for(int row = 0; row < fileRooms.length; row++) {
                //
                for(int col = 0; col < fileRooms[row].length; col++) {
                    // add nums to array
                    fileRooms[row][col] = fileScan.nextInt();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return fileRooms;
    }

    
}
import java.util.Scanner;

public class Problem4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pos = sc.next();
        String x = pos.substring(0,1);
        int xPos = getXpos(x);
        int y = Integer.parseInt(pos.substring(1,2));

        int answer = 0;
        //Move left
        if (xPos>2) {
            //Move up
            if (y>1) {
                answer++;
            }
            //Move down
            if (y<8) {
                answer++;
            }
        }
        //Move right
        if (xPos<7) {
            if (y>1) {
                answer++;
            }
            if (y<8) {
                answer++;
            }
        }
        //Move up
        if (y>2) {
            //Move left
            if (xPos>1) {
                answer++;
            }
            if (xPos<8) {
                answer++;
            }
        }
        if (y<7) {
            if (xPos>1) {
                answer++;
            }
            if (xPos<8) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static int getXpos(String x) {
        String[] x_positions = {"a", "b", "c", "d", "e", "f", "g", "h"};
        int xPos = 0;
        for (int i=0; i<x_positions.length; i++) {
            if (x_positions[i].equals(x)) {
                xPos = i+1;
                break;
            }
        }
        return xPos;
    }
}

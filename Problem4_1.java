import java.util.Scanner;

public class Problem4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String error = sc.nextLine();
        String commands = sc.nextLine();
        String[] command = commands.split(" ");

        int ROW = 1, COLUMN = 1;

        for (int i=0; i<command.length; i++) {
            if (command[i].equals("R") && COLUMN<N) {
                COLUMN += 1;
            }
            else if (command[i].equals("L") && COLUMN>1) {
                COLUMN -= 1;
            }
            else if (command[i].equals("U") && ROW>1) {
                ROW -= 1;
            }
            else if (command[i].equals("D") && ROW<N) {
                ROW += 1;
            }
        }
        System.out.println(ROW + " " + COLUMN);
    }
}

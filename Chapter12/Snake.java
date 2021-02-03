package Chapter12;

import java.util.*;

public class Snake {
    static int[] DIRECTION_ROW = {0, 1, 0, -1};
    static int[] DIRECTION_COLUMN = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); int K = sc.nextInt();

        List<Grid_RowCol> apples = new ArrayList<>();
        for (int i=0; i<K; i++) {
            apples.add(new Grid_RowCol(sc.nextInt(), sc.nextInt()));
        }

        int L = sc.nextInt();
        int[] Xs = new int[L]; String[] Cs = new String[L];
        for (int i=0; i<L; i++) {
            Xs[i] = sc.nextInt(); Cs[i] = sc.next();
        }

        List<Grid_RowCol> snake = new ArrayList<>();
        snake.add(new Grid_RowCol(1, 1));

        int time = 0; int direction = 0; boolean end = false;
        while (true) {
            time++;
            Grid_RowCol head = snake.get(snake.size()-1);
            Grid_RowCol newHead = new Grid_RowCol(head.row+DIRECTION_ROW[direction], head.column+DIRECTION_COLUMN[direction]);
            snake.add(newHead);

            if (collide(snake, newHead, N)) break;
            else {
                if (!eatApple(apples, newHead)) {
                    snake.remove(0);
                }
            }
            for (int i=0; i<L; i++) {
                if (time==Xs[i]) {
                    direction = rotate(Cs[i], direction);
                    break;
                }
            }
        }

        System.out.println(time);
    }

    static boolean eatApple(List<Grid_RowCol> apples, Grid_RowCol head) {
        int index = -1;
        for (int i=0; i<apples.size(); i++) {
            if (head.row==apples.get(i).row && head.column==apples.get(i).column) {
                index = i;
            }
        }
        if (index==-1) return false;
        apples.remove(index);
        return true;
    }

    static boolean collide(List<Grid_RowCol> snake, Grid_RowCol head, int N) {
        if (head.row<=0 || head.column<=0) return true;
        else if (head.row>=N+1 || head.column>=N+1) return true;

        for (int i=0; i<snake.size()-1; i++) {
            if (snake.get(i).row==head.row && snake.get(i).column==head.column) {
                return true;
            }
        }

        return false;
    }

    public static int rotate(String rotate_direction, int direction) {
        if (rotate_direction.equals("L")) {
            direction -= 1;
        }
        else {
            direction += 1;
        }
        if (direction==4) direction = 0;
        else if (direction==-1) direction = 3;
        return direction;
    }
}

class Grid_RowCol {
    int row;
    int column;
    Grid_RowCol(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Grid_RowCol{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}

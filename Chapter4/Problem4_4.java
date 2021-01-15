package Chapter4;

import java.util.Scanner;

public class Problem4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputInts_String = sc.nextLine();
        String[] inputInts_StringSplited = inputInts_String.split(" ");
        int N, M;
        N = Integer.parseInt(inputInts_StringSplited[0]);
        M = Integer.parseInt(inputInts_StringSplited[1]);

        inputInts_String = sc.nextLine();
        inputInts_StringSplited = inputInts_String.split(" ");
        int column, row, head;
        column = Integer.parseInt(inputInts_StringSplited[0])+1;
        row = Integer.parseInt(inputInts_StringSplited[1])+1;
        head = Integer.parseInt(inputInts_StringSplited[2]);

        int[][] moves = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int[][] backwards = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

        int[][] board = new int[N+2][M+2];

        for (int i=0; i<board[0].length; i++) {
            board[0][i] = 1;
        }
        for (int i=0; i<board[N+1].length; i++) {
            board[N+1][i] = 1;
        }

        for (int i=0; i<N; i++) {
            inputInts_String = sc.nextLine();
            inputInts_StringSplited = inputInts_String.split(" ");
            for (int j=0; j<M+2; j++) {
                if (j==0 || j==M+1) {
                    board[i+1][j] = 1;
                    continue;
                }
                board[i+1][j] = Integer.parseInt(inputInts_StringSplited[j-1]);
            }
        }

        int only_turn = 0;
        int answer = 0;

        while (true) {
            int newRow = row + moves[head][0];
            int newCol = column + moves[head][1];

            if (board[newRow][newCol]==1 || board[newRow][newCol]==2) {
                only_turn++;
                head = setHead(head);
            }
            else {
                only_turn = 0;
                board[row][column] = 2;
                row = newRow;
                column = newCol;
                head = setHead(head);
                answer++;
            }
            if (only_turn==4) {
                board[row][column] = 2;
                row += backwards[head][0];
                column += backwards[head][1];
                only_turn = 0;
                if (board[row][column]==1) {
                    break;
                }
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static int setHead(int head) {
        int newhead = head-1;
        if (newhead<0) {
            newhead = 3;
        }
        return newhead;
    }
}

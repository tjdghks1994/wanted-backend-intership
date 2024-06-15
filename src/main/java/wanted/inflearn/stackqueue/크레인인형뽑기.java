package main.java.wanted.inflearn.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기 {
    /**
     * 문제 : 게임 개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
     *       죠르디는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.
     *       게임 화면은 1x1 크기의 칸들로 이루어진 NxN 크기의 정사각 격자이며, 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.
     *       각 격자 칸에는 다양한 인형들이 들어 있으며 인형이 없는 칸은 빈칸입니다.
     *       게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다.
     *       집어 올린 인형은 바구니에 쌓이게 되는데
     *       이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
     *       만약 같은 모향의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.
     *
     *       크레인 작동 시 인형이 집어지지 않는 경우는 없으나, 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
     *       또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다.
     *       게임 화면의 격자의 상태가 담긴 2차원 배열 board 와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves 가 매개변수로 주어질 때,
     *       크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
     *
     * 입력 : 첫 줄에 자연수 N(5<=N<=30)이 주어집니다.
     *       두 번째 줄부터 N*N board 배열이 주어집니다.
     *       board 의 각 칸에는 0 이상 100 이하인 정수가 담겨져 있습니다.
     *       0은 빈 칸을 나타냅니다.
     *       1~100 의 각 숫자는 각기 다른 인형의 모양을 의미하며, 같은 숫자는 같은 모양의 인형을 나타냅니다.
     *       board 배열이 끝난 다음줄에 moves 배열의 길이 M이 주어집니다.
     *       마지막 줄에는 moves 배열의 원소들이 주어집니다.
     *       moves 배열의 크기는 1 이상 1,000 이하입니다.
     *       moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
     *
     *  출력 : 첫 줄에 터트려져 사라진 인형의 개수를 출력합니다.
     *
     *  예시 : 입력 - 5                    출력 - 4
     *             0 0 0 0 0
     *             0 0 1 0 3
     *             0 2 5 0 1
     *             4 2 4 4 2
     *             3 5 1 3 1
     *             8
     *             1 5 3 5 1 2 1 4
     */

    public static void solution(int[][] board, int[] moves) {
        int cnt = 0;
        Stack<Integer> basket = new Stack<>();  // 바구니

        for (int i = 0; i < moves.length; i++) {
            int rowIdx = 0;
            int colIdx = moves[i] - 1;  // 선택된 줄
            // 선택된 줄의 빈칸이 아닌 곳을 찾기
            while (rowIdx < board.length && board[rowIdx][colIdx] == 0 ) {
                rowIdx++;
            }
            // 선택된 줄이 모두 빈칸인 경우 아무런 동작을 하지 않음
            if(rowIdx == board.length) { continue; }

            // 인형을 바구니로 이동
            cnt += moveBasket(board[rowIdx][colIdx], basket);
            board[rowIdx][colIdx] = 0;  // 바구니에 이동했으므로 원래 배열에서 인형 제거
        }

        System.out.println(cnt);
    }

    public static int moveBasket(int doll, Stack<Integer> basket) {
        // 바구니가 비어있지 않은 경우
        if (!basket.isEmpty()) {
            // 이전에 담겨있는 인형 조회
            int prevDoll = basket.peek();
            // 이전에 담겨있는 인형과 같은 종류의 인형이라면
            if (prevDoll == doll) {
                // 인형을 터트려야하므로 이전에 담겨있는 인형을 스택에서 제거
                basket.pop();
                return 2;   // 인형이 터졌으므로 터진 개수인 2를 반환
            } else {
                // 이전에 담겨있는 인형과 다른 종류의 인형이라면 현재 인형을 스택에 추가
                basket.push(doll);
                return 0;
            }
        } else {
            basket.push(doll);
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }
        int m = in.nextInt();
        int[] moves = new int[m];
        for (int k = 0; k < m; k++) {
            moves[k] = in.nextInt();
        }

        solution(board, moves);
    }
}

package main.java.wanted.inflearn.tpsw;

import java.util.Scanner;

public class 두배열합치기 {
    /**
     * 문제 : 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력 : 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
     *       두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
     *       세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
     *       네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
     *       각 리스트의 원소는 int 형 변수의 크기를 넘지 않습니다.
     * <p>
     * 출력 : 오름차순으로 정렬된 배열을 출력합니다.
     * <p>
     * 예시 : 입력 - 3              출력 - 1 2 3 3 5 6 7 9
     *            1 3 5
     *            5
     *            2 3 6 7 9
     */

    public static void solution(int[] arr1, int[] arr2) {
        int lp = 0, rp = 0;

        while (lp<arr1.length && rp<arr2.length) {
            if (arr1[lp] < arr2[rp]) {
                System.out.print(arr1[lp] + " ");
                lp++;
            } else {
                System.out.print(arr2[rp] + " ");
                rp++;
            }
        }

        for (int i = rp; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        for (int j = lp; j < arr1.length; j++) {
            System.out.print(arr1[1] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt1 = in.nextInt();
        int[] arr1 = new int[cnt1];
        for (int i = 0; i < cnt1; i++) {
            arr1[i] = in.nextInt();
        }
        int cnt2 = in.nextInt();
        int[] arr2 = new int[cnt2];
        for (int i = 0; i < cnt2; i++) {
            arr2[i] = in.nextInt();
        }

        solution(arr1, arr2);
    }
}

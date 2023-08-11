/**
 * @project DoIt_CodingTest_Java
 * @author ARA
 * @since 2023-08-12 AM 3:20
 */

package ch11.sec01;

import java.util.Scanner;

public class Pb_084_Bj1463_1463 {
    static int N;
    static int D[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N + 1];
        D[1] = 0;
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }
            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }

        System.out.println(D[N]);
    }
}

/**
 * @project DoIt_CodingTest_Java
 * @author ARA
 * @since 2023-08-12 AM 3:08
 */

package ch11.sec01;

import java.util.Scanner;

public class P2747_피보나치수_BottomUp {
    static int[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        D = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            D[i] = -1;
        }
        D[0] = 0;
        D[1] = 1;
        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 2] + D[i - 1];
        }

        System.out.println(D[n]);
    }
}

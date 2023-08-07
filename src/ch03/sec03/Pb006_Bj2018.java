/**
 * @project DoIt_CodingTest_Java
 * @author ARA
 * @since 2023-08-06 PM 8:36
 */

package ch03.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//  수들의 합 5
//  https://www.acmicpc.net/problem/2018
public class Pb006_Bj2018 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Pb006_Bj2018().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ary = new int[N+1];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = i;
        }

        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;
        int count = 0;

        while (endIdx <= N) {
            if (sum == N) {
                count++;
                endIdx++;
                sum += endIdx;
            } else if (sum < N) {
                endIdx++;
                sum += endIdx;
            } else {
                sum -= startIdx;
                startIdx++;
            }
        }

        return count;
    }
}

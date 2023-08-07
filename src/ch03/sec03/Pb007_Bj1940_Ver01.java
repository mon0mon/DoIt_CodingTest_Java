/**
 * @project DoIt_CodingTest_Java
 * @author ARA
 * @since 2023-08-06 PM 9:53
 */

package ch03.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//  주몽
//  https://www.acmicpc.net/problem/1940
public class Pb007_Bj1940_Ver01 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Pb007_Bj1940_Ver01().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] ary = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(ary);

        int startIdx = 0;
        int endIdx = 0;
        int count = 0;

        while (startIdx < N - 1) {
            if (ary[startIdx] + ary[endIdx] == M) {
                startIdx++;
                endIdx = startIdx + 1;
                count++;
            } else if (ary[startIdx] + ary[endIdx] < M) {
                endIdx++;
            } else {
                startIdx++;
                endIdx = startIdx + 1;
            }

            if (endIdx == N) {
                startIdx++;
                endIdx = startIdx + 1;
            }
        }

        return count;
    }
}

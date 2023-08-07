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
public class Pb007_Bj1940_Ver02 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Pb007_Bj1940_Ver02().solution());
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
        int endIdx = N-1;
        int count = 0;

        while (startIdx < endIdx) {
            if (ary[startIdx] + ary[endIdx] == M) {
                startIdx++;
                endIdx--;
                count++;
            } else if (ary[startIdx] + ary[endIdx] < M) {
                startIdx++;
            } else {
                endIdx--;
            }
        }

        return count;
    }
}

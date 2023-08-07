/**
 * @project DoIt_CodingTest_Java
 * @author ARA
 * @since 2023-08-06 PM 10:35
 */

package ch03.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  좋다
//  https://www.acmicpc.net/problem/1253
public class Pb008_Bj1253_Ver01 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Pb008_Bj1253_Ver01().solution());
    }

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] ary = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        Arrays.sort(ary);

        int startIdx = 0;
        int endIdx = 1;
        Set<Long> set = new HashSet<>();

        while (startIdx < N - 1) {
            set.add(ary[startIdx] + ary[endIdx]);
            endIdx++;

            if (endIdx >= N) {
                startIdx++;
                endIdx = startIdx + 1;
            }
        }

        int count = 0;
        for (int i = 0; i < ary.length; i++) {
            if (set.contains(ary[i])) {
                set.remove(i);
                count++;
            }
        }

        return count;
    }
}

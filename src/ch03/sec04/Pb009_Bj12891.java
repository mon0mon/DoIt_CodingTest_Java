/**
 * @project DoIt_CodingTest_Java
 * @author ARA
 * @since 2023-08-12 AM 1:33
 */

package ch03.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  DNA 비밀번호
//  https://www.acmicpc.net/problem/12891
public class Pb009_Bj12891 {
    final static int DNA_TRAITS_COUNT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine());

        int dnaLength = Integer.parseInt(inputToken.nextToken());
        int targetStrLength = Integer.parseInt(inputToken.nextToken());

        char[] dnaAry = br.readLine().toCharArray();

        int[] requiredDnaTraits = new int[DNA_TRAITS_COUNT];
        inputToken = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < requiredDnaTraits.length; i++) {
            requiredDnaTraits[i] = Integer.parseInt(inputToken.nextToken());
        }

        int[] currentDnaTraits = new int[DNA_TRAITS_COUNT];
        int matchCount = 0;

        for (int i = 0; i < targetStrLength - 1; i++) {
            currentDnaTraits[traitsToIndex(dnaAry[i])] += 1;
        }

        for (int i = targetStrLength - 1; i < dnaLength; i++) {
            currentDnaTraits[traitsToIndex(dnaAry[i])] += 1;

            boolean isMatch = true;
            for (int j = 0; j < DNA_TRAITS_COUNT; j++) {
                if (currentDnaTraits[j] < requiredDnaTraits[j]) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                matchCount++;
            }

            //  슬라이딩 윈도우 범위 밖의 오래된 DNA는 제외
            currentDnaTraits[traitsToIndex(dnaAry[i-(targetStrLength-1)])] -= 1;
        }

        System.out.println(matchCount);
    }

    public static int traitsToIndex(char ch) {
        switch (ch) {
            case 'A' :
                return 0;
            case 'C' :
                return 1;
            case 'G' :
                return 2;
            case 'T':
            default:
                return 3;
        }
    }
}

package sort.topological_sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TopologicalSort_queue {

    static Scanner sc;
    static StringBuilder sb;

    static int V, E;
    static int[][] adjArr;
    static int[] degree;
    static Deque<Integer> myQueue;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        sb = new StringBuilder();

        V = sc.nextInt(); // 정점의 수
        E = sc.nextInt(); // 간선의 수

        adjArr = new int[V + 1][V + 1]; // 정점의 번호가 1부터 시작하므로 V+1
        degree = new int[V + 1];        // 진입 차수

        for (int i = 0; i < E; i++) {

            int start = sc.nextInt();
            int end = sc.nextInt();

            adjArr[start][end] = 1; // 유향 그래프이므로 반대의 경우를 동일하게 저장하지 않음, 가중치가 있다면 가중치를 저장
            degree[end]++;
        }

        myQueue = new ArrayDeque<>();

        for (int i = 1; i < V + 1; i++) {
            if (degree[i] == 0) {
                myQueue.addLast(i);
            }
        }

        while (!myQueue.isEmpty()) {

            int current = myQueue.pollFirst();

            sb.append(current + " ");

            for (int i = 0; i < V + 1; i++) {
                if (adjArr[current][i] == 1) {
                    degree[i]--;
                    adjArr[current][i] = 0;

                    if (degree[i] == 0) {
                        myQueue.addLast(i);
                    }
                }
            }

            System.out.println(sb);

        }


    }
}

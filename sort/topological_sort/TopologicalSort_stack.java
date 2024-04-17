package sort.topological_sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TopologicalSort_stack {

    static Scanner sc;

    static int V, E;
    static int[][] adjArr;
    static int[] degree;
    static boolean[] visited;
    static Deque<Integer> myStack;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        V = sc.nextInt(); // 정점의 수
        E = sc.nextInt(); // 간선의 수

        adjArr = new int[V + 1][V + 1]; // 정점의 번호가 1부터 시작하므로 V+1
        degree = new int[V + 1];        // 진입 차수
        visited = new boolean[V + 1];

        myStack = new ArrayDeque<>();

        for (int i = 0; i < E; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            adjArr[start][end] = 1; // 유향 그래프이므로 반대의 경우를 동일하게 저장하지 않음, 가중치가 있다면 가중치를 저장
            degree[end]++;
        }

        for (int i = 1; i < V + 1; i++) {
            if (degree[i] == 0) {
                dfs(i);
            }
        }

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pollFirst());
        }

    }

    static void dfs(int v) {

        visited[v] = true;

        for (int i = 1; i < V + 1; i++) {
            // 인접하면서 방문하지 않은 정점이 있다면 방문
            if (adjArr[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

        myStack.addFirst(v);
    }

}

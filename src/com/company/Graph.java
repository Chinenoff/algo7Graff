package com.company;

import java.util.ArrayList;

public class Graph {
    private final int vertexCount;
    private final ArrayList<ArrayList<Integer>> verticesInfo;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        ArrayList<ArrayList<Integer>> tempList = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            tempList.add(new ArrayList<>());
        }
        this.verticesInfo = tempList;
    }

    public void addEdge(int a, int b) {
        verticesInfo.get(a).add(b);
        verticesInfo.get(b).add(a);
    }

    public ArrayList<Integer> adjacent(int v) {
        return verticesInfo.get(v);
    }

    public void vertices() {
        System.out.print("Вершины графа ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(" >" + i + "< ");
        }
        System.out.println();
    }

    public int size() {
        return vertexCount;
    }

    public int dfs(int vertex, int mark, ArrayList<Integer> marks) {
        marks.set(vertex, mark);
        int sizeConnectedness = 1;
        for (Integer x : verticesInfo.get(vertex)
        ) {
            if (marks.get(x) == 0) {
                sizeConnectedness = sizeConnectedness + dfs(x, mark, marks);
            }
        }
        return sizeConnectedness;
    }

    public void calcPaths(Graph graph) {
        //заполнение marks нулями
        ArrayList<Integer> marks = new ArrayList<>();
        for (int i = 0; i < size(); i++) marks.add(0);

        ArrayList<Integer> markSizes = new ArrayList<>();
        int sizeCon = 0;
        for (int v = 0; v < size(); v++) {

            if (marks.get(v) == 0) {
                int nextMark = markSizes.size() + 1; //markSizes.length + 1;
                sizeCon = dfs(v, nextMark, marks);
            }
            markSizes.add(sizeCon);
        }
        ArrayList<Integer> answer = new ArrayList<>(size());
        for (int i = 0; i < size(); i++) {
            answer.add(0);
        }
        for (int i = 0; i < size(); i++) {
            answer.set(i, markSizes.get(i) - 1);
        }
        System.out.println("Сколько достижимо городов для каждого города:");
        for (int i = 0; i < vertexCount; i++) {
            System.out.println("из города " + i + " доступно " + answer.get(i) + " города");
        }
    }
}

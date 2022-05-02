package com.company;

public class Main {

    public static void main(String[] args) {
        Graph testgraph = new Graph(6);
        testgraph.vertices();
        System.out.println("Количество вершин:" + testgraph.size());
        testgraph.addEdge(0,1);
        testgraph.addEdge(1,2);
        testgraph.addEdge(3,4);
        testgraph.calcPaths(testgraph);
    }
}

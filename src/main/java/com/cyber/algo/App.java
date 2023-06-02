package com.cyber.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        // Алгоритм Тарьяна
        // обойти все вершины, используя поиск в глубину, и выводить вершину в момент выхода из неё.
        TopologicalSort topologicalSort = new TopologicalSort();

        // Источник графов:
        // https://ru.wikipedia.org/wiki/Топологическая_сортировка

        // Пример 1:
        System.out.println(topologicalSort.sort(initGraph()));

        // Пример 2:
        System.out.println(topologicalSort.sort(initGraph2()));

    }

    private static Map<String, Set<String>> initGraph() {
        Map<String, Set<String>> graphMap = new HashMap<>();
        graphMap.put("a", Set.of("b", "c", "d", "e"));
        graphMap.put("b", Set.of("d"));
        graphMap.put("c", Set.of("d", "e"));
        graphMap.put("d", Set.of("e"));
        return graphMap;
    }

    private static Map<String, Set<String>> initGraph2() {
        Map<String, Set<String>> graphMap = new HashMap<>();
        graphMap.put("7", Set.of("11", "8"));
        graphMap.put("5", Set.of("11"));
        graphMap.put("3", Set.of("8", "10"));
        graphMap.put("11", Set.of("2", "9", "10"));
        graphMap.put("8", Set.of("9"));

        return graphMap;
    }

}

package com.cyber.algo;

import java.util.*;

import static java.util.Collections.emptySet;

public class TopologicalSort {
    private enum NodeState {
        WHITE, GREY, BLACK
    }

    private final Map<String, NodeState> stateMap = new HashMap<>();
    private final Deque<String> result = new LinkedList<>();

    private void dfs(Map<String, Set<String>> graphMap, String node) {
        switch (stateMap.getOrDefault(node, NodeState.WHITE)) {
            case BLACK:
                return;
            case GREY:
                throw new IllegalStateException("Найден цикл, сортировка невозможна");
        }
        stateMap.put(node, NodeState.GREY);
        for (String childNode : graphMap.getOrDefault(node, emptySet())) {
            dfs(graphMap, childNode);
        }
        stateMap.put(node, NodeState.BLACK);
        result.addFirst(node);
    }

    public Collection<String> sort(Map<String, Set<String>> graphMap) {
        reset();
        for (String node : graphMap.keySet()) {
            dfs(graphMap, node);
        }
        return result;
    }

    private void reset() {
        stateMap.clear();
        result.clear();
    }

}

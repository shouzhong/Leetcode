package com.shouzhong.leetcode.code;

import com.bumptech.glide.request.SingleRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> visited = new HashMap <> ();
        return cloneGraph(visited, node);
    }

    public Node cloneGraph(HashMap<Node, Node> visited, Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) return visited.get(node);
        Node clone = new Node(node.val, new ArrayList<Node>());
        visited.put(node, clone);
        for (Node temp : node.neighbors) {
            clone.neighbors.add(cloneGraph(visited, temp));
        }
        return clone;
    }
}

package com.practice.dsa;

import java.util.*;

public class LinkedListInterception {
    public static void main(String[] args) {
        String[] lines = {
                "a->b",
                "r->s",
                "b->c",
                "x->c",
                "q->r",
                "y->x",
                "w->z",
//                "a, q, w",
                "a, c, r",
//                "y, z, a, r",
//                "a, w"
        };
        try {
            List<String> results = evaluate(lines);
            for (String result : results) {
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> evaluate(String[] lines) throws InvalidOperationException {
        Map<String, Node> graph = new HashMap<>();
        List<String> results = new ArrayList<>();

        for (String line : lines) {
            if (line.contains(",")) {
                String returnValue;

                try {
                    String[] strings = line.split(",");
                    for (int i = 0; i < strings.length; i++) {
                        String string = strings[i];
                        strings[i] = string.trim();
                    }
                    boolean b = checkLinkedListIntersection(strings, graph);
                    returnValue = Boolean.toString(b);
                } catch (InvalidOperationException ex) {
                    if (ex.getMessage().equals("Cycle detected.")) {
                        returnValue = "Error Thrown!";
                    } else {
                        throw ex;
                    }
                }
                results.add(returnValue);
            } else if (line.contains("->")) {
                String[] splitStr = line.split("->");
                String current = splitStr[0].trim();
                String next = splitStr[1].trim();

                // Check to see if the parent node already exists
                Node nextNode = graph.get(next);
                if (nextNode == null) {
                    // If it doesn't, add it in so we can reference the object
                    nextNode = new Node(next, null);
                    graph.put(next, nextNode);
                }

                // Check to see if the child node already exists
                Node currentNode = graph.get(current);
                if (currentNode != null) {
                    // If it does, update the existing object
                    currentNode.next = nextNode;
                } else {
                    graph.put(current, new Node(current, nextNode));
                }
            }
        }
        return results;
    }

    private static boolean checkLinkedListIntersection(String[] nodeGroup, Map<String, Node> graph) throws InvalidOperationException {
        Set<String> allTraversedNodes = new HashSet<>();

        for (String value : nodeGroup) {
            Set<String> currentTraversedNodes = new HashSet<>();

            Node node = graph.get(value);
            if (node == null) {
                continue;
            }

            do {
                if (allTraversedNodes.contains(node.value)) {
                    return true;
                }

                // Don't follow cycles
                if (node.next != null && currentTraversedNodes.contains(node.next.value)) {
                    throw new InvalidOperationException("Cycle detected.");
                }

                allTraversedNodes.add(node.value);
                currentTraversedNodes.add(node.value);

                node = node.next;
            } while (node != null);
        }

        return false;
    }

    static class Node {
        String value;
        Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static class InvalidOperationException extends Exception {
        public InvalidOperationException(String message) {
            super(message);
        }
    }
}

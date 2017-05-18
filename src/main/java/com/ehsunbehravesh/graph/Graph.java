package com.ehsunbehravesh.graph;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    
    public static Set allConnectedNodes(Node node) {
        Set result = new HashSet<>();
        Set visited = new HashSet<>();
        
        for (Node n : node.getNodes()) {
            if (n.getNodes().size() > 0 && !visited.contains(n)) {
                return allConnectedNodes(n);
            } 
                
            result.add(n);
            visited.add(n);
        }
        
        return result;
    }
}

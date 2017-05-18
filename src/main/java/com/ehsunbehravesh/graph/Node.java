package com.ehsunbehravesh.graph;

import java.util.Set;

/**
 *
 * @author Ehsun 
 */
public interface Node {
    
    Set<Node> getNodes();
    void addNode(Node... nodes);
}

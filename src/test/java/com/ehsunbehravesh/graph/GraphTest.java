package com.ehsunbehravesh.graph;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ehsun
 */
public class GraphTest {
    
    public GraphTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of allConnectedNodes method, of class Graph.
     */
    @Test
    public void testAllConnectedNodes() {
        System.out.println("allConnectedNodes");
        //Node node = ;
        
        NodeClass n1 = new NodeClass(1);
        NodeClass n2 = new NodeClass(2);
        NodeClass n3 = new NodeClass(3);
        NodeClass n4 = new NodeClass(4);
        
        n1.addNode(n2, n3, n4);
        n2.addNode(n1);
        n3.addNode(n1);
        n4.addNode(n1);
        
        Set nodes = Graph.allConnectedNodes(n1);
        
        for (Object node : nodes) {
            NodeClass n = (NodeClass) node;
            
            System.out.println(n.getId());
        }
    }
    
    
}

class NodeClass implements Node {

    private final int id;
    private Set<NodeClass> nodeObjects;

    public NodeClass(int id) {
        this.id = id;
        nodeObjects = new HashSet<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodeClass other = (NodeClass) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    @Override
    public Set<Node> getNodes() {
        Set<Node> result = new HashSet<>();
        
        nodeObjects.forEach((n) -> {
            result.add(n);
        });
        
        return result;
    }

    public Set<NodeClass> getNodeObjects() {
        return nodeObjects;
    }

    public void setNodeObjects(Set<NodeClass> nodeObjects) {
        this.nodeObjects = nodeObjects;
    }
    
    @Override
    public void addNode(Node... nodes) {        
        for (Node node : nodes) {
            nodeObjects.add((NodeClass)node);
        }
    }

    public int getId() {
        return id;
    }
    
    
}
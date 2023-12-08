package net.lsmith946.adventofcode.problems2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MapNetworkNode {

    private String nodeName;
    MapNetworkNode leftNode;
    MapNetworkNode rightNode;

    public MapNetworkNode(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public MapNetworkNode getLeftNode() {
        return leftNode;
    }

    public MapNetworkNode getRightNode() {
        return rightNode;
    }

    public void addConnectedNodes(MapNetworkNode leftNode, MapNetworkNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

}

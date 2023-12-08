package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.problems2023.MapNetworkNode;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public final class Day8 implements Puzzle<Long> {

    List<String> values;
    char[] directions;
    List<MapNetworkNode> nodes;

    public Day8() throws IOException, URISyntaxException, InterruptedException {
        this.values = InputLoader.loadToStringList(2023, 8);
        this.nodes = new ArrayList<>();
        directions = values.remove(0).toCharArray();
        values.remove(0); // delete the empty string between the directions and the node list
        for(String s : values) {
            String[] nodeStr = StringUtils.split(s);
            MapNetworkNode newNode = new MapNetworkNode(nodeStr[0]);
            nodes.add(newNode);
        }
    }

    private MapNetworkNode findNode(String nodeName) {
        for(MapNetworkNode node : nodes) {
            if (node.getNodeName().equals(nodeName)) {
                return node;
            }
        }
        throw new IllegalStateException("Tried to find a node that did not exist");
    }

    @Override
    public Long solvePartOne() {
        MapNetworkNode currentNode;

        for(String s : values) {
            String[] nodeStr = StringUtils.split(s);
            String leftConnectedNode = nodeStr[2].substring(1, 4);
            String rightConnectedNode = nodeStr[3].substring(0, 3);

            currentNode= findNode(nodeStr[0]);
            MapNetworkNode leftNode = findNode(leftConnectedNode);
            MapNetworkNode rightNode = findNode(rightConnectedNode);

            currentNode.addConnectedNodes(leftNode, rightNode);
        }

        // get the starting node
        currentNode = findNode("AAA");
        long stepsTaken = 0;
        int nextInstruction = 0;

        while(!currentNode.getNodeName().equals("ZZZ")) {
            if (directions[nextInstruction] == 'L') {
                currentNode = currentNode.getLeftNode();
            }
            else {
                currentNode = currentNode.getRightNode();
            }
            stepsTaken++;
            nextInstruction = (int) stepsTaken % directions.length;
        }
        System.out.println("The number of steps taken to reach ZZZ is " + stepsTaken);
        return stepsTaken;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}

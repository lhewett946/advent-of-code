package net.lsmith946.adventofcode.problems2023.days;

import net.lsmith946.adventofcode.problems2023.MapNetworkNode;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.util.ArithmeticUtils;

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
        // generate all of the nodes
        for(String s : values) {
            String[] nodeStr = StringUtils.split(s);
            MapNetworkNode newNode = new MapNetworkNode(nodeStr[0]);
            nodes.add(newNode);
        }

        MapNetworkNode currentNode;

        for(String s : values) {
            String[] nodeStr = StringUtils.split(s);
            String leftConnectedNode = nodeStr[2].substring(1, 4);
            String rightConnectedNode = nodeStr[3].substring(0, 3);

            currentNode= findNodes(nodeStr[0]).get(0);
            MapNetworkNode leftNode = findNodes(leftConnectedNode).get(0);
            MapNetworkNode rightNode = findNodes(rightConnectedNode).get(0);

            currentNode.addConnectedNodes(leftNode, rightNode);
        }
    }

    private List<MapNetworkNode> findNodes(String nodeNameEnding) {
        List<MapNetworkNode> matchingNodes = new ArrayList<>();
        for(MapNetworkNode node : nodes) {
            if (node.getNodeName().endsWith(nodeNameEnding)) {
                matchingNodes.add(node);
            }
        }

        if (matchingNodes.isEmpty()) {
            throw new IllegalStateException("Did not find any matching nodes!");
        }
        else {
            return matchingNodes;
        }
    }

    @Override
    public Long solvePartOne() {
        List<MapNetworkNode> currentNodes;

        // get the starting node
        currentNodes = findNodes("AAA");
        long stepsTaken = 0;
        int nextInstruction = 0;

        for(MapNetworkNode currentNode : currentNodes) {
            while (!currentNode.getNodeName().equals("ZZZ")) {
                if (directions[nextInstruction] == 'L') {
                    currentNode = currentNode.getLeftNode();
                } else {
                    currentNode = currentNode.getRightNode();
                }
                stepsTaken++;
                nextInstruction = (int) stepsTaken % directions.length;
            }
        }
        System.out.println("The number of steps taken to reach ZZZ is " + stepsTaken);
        return stepsTaken;
    }

    @Override
    public Long solvePartTwo() {
        List<MapNetworkNode> currentNodes;
        long allNodesStepsTaken = 1;

        // get the starting node
        currentNodes = findNodes("A");

        for(MapNetworkNode currentNode : currentNodes) {
            long stepsTaken = 0;
            int nextInstruction = 0;
            while (!currentNode.getNodeName().endsWith("Z")) {
                if (directions[nextInstruction] == 'L') {
                    currentNode = currentNode.getLeftNode();
                } else {
                    currentNode = currentNode.getRightNode();
                }
                stepsTaken++;
                nextInstruction = (int) stepsTaken % directions.length;
            }
            allNodesStepsTaken = ArithmeticUtils.lcm(allNodesStepsTaken, stepsTaken);
        }

        System.out.println("The number of steps taken to reach ZZZ is " + allNodesStepsTaken);
        return allNodesStepsTaken;
    }
}

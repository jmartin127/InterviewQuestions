package com.blinkdroid.interview;

public class DirectedGraphTraversal {
  
  public static void main(String[] args) {
    // leaves
    Node node1 = new Node(1, null, null);
    Node node3 = new Node(3, null, null);
    Node node5 = new Node(5, null, null);
    Node node9 = new Node(9, null, null);
    Node node14 = new Node(14, null, null);
    Node node17 = new Node(17, null, null);
    
    // parents of leaves
    Node node2 = new Node(2, node1, node3);
    Node node7 = new Node(7, node5, node9);
    Node node15 = new Node(15, node14, node17);
    Node node4 = new Node(4, node2, node7);
    Node rootNode = new Node(10, node4, node15);
    
    printPathToValue(rootNode, 5); // exists, leaf
    printPathToValue(rootNode, 2); // exists, middle of tree
    printPathToValue(rootNode, 6); // does not exist
    printPathToValue(rootNode, 10); // root value
  }
  
  private static Node printPathToValue(Node startingNode, int targetValue) {
    if (startingNode == null) {
      System.out.println("Unable to find the target value.");
      return null;
    }
    
    System.out.print(startingNode.getValue() + " ");
    
    if (targetValue > startingNode.getValue()) {
      return printPathToValue(startingNode.getRight(), targetValue);
    }
    else if (targetValue < startingNode.getValue()) {
      return printPathToValue(startingNode.getLeft(), targetValue);
    }
    else {
      System.out.println("The target value was found: " + targetValue);
      return startingNode;
    }
  }
  
  private static class Node  {

    private final int value;
    
    private final Node left;
    
    private final Node right;
    
    public Node(int value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
    
    public int getValue() {
      return value;
    }

    public Node getLeft() {
      return left;
    }

    public Node getRight() {
      return right;
    }
    
  }
  
}

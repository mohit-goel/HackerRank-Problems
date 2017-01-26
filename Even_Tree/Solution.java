import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

     public static void main(String[] args) {

    Scanner scanner = new Scanner((System.in));

    int nodes = scanner.nextInt();
    int edges = scanner.nextInt();

    int[][] tree = new int[101][101];

    for (int i = 0; i < edges; i++) {
      int vertex1 = scanner.nextInt();
      int vertex2 = scanner.nextInt();

      tree[vertex1][vertex2] = 1;
      tree[vertex2][vertex1] = 1;

    }

    int root = 1;
    int visited[] = new int[101];
    Node result  = dfs(root, tree, nodes, visited);
    System.out.println(result.getMax());

  }

  static class Node {
    int max;
    int numberOfNodes;

    public Node(int max, int numberOfNodes) {
      this.max = max;
      this.numberOfNodes = numberOfNodes;
    }

    public int getMax() {
      return max;
    }

    public void setMax(int max) {
      this.max = max;
    }

    public int getNumberOfNodes() {
      return numberOfNodes;
    }

    public void setNumberOfNodes(int numberOfNodes) {
      this.numberOfNodes = numberOfNodes;
    }
  }

  private static Node dfs(int root, int[][] tree, int nodes, int[] visited) {

    visited[root] = 1;
    int sumNodes = 0;
    int max = 0;
    Node n = new Node(0, 0);
    for (int i = 1; i < 101; i++) {
      //System.out.println(root + "," + i+ "=" + tree[root][i]);
      if (tree[root][i] == 1 && visited[i] == 0) {
        Node numNodes = dfs(i, tree, nodes, visited);
        sumNodes+=numNodes.getNumberOfNodes();
        max+=numNodes.getMax();
      }
    }
    if(root != 1 ) {
      sumNodes = sumNodes + 1;
      if (sumNodes % 2 == 0) {
        n.setNumberOfNodes(0);
        max++;
      } else {
        n.setNumberOfNodes(sumNodes);
      }
    }
      n.setMax(max);
    return n;
  }
}

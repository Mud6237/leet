package com.leet;

import java.util.ArrayList;
/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */
public class TreeBuilder {

  static boolean isOperator(String c) {
    return (c.equalsIgnoreCase("*") || c.equalsIgnoreCase("/") ||
            c.equalsIgnoreCase("+") || c.equalsIgnoreCase("-"));
  }

  public Node buildTree(String[] postfix) {
    ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
    for (String tok : postfix) {
      if (isOperator(tok)) {
        TreeNode right = stack.remove(stack.size() - 1);
        TreeNode left = stack.remove(stack.size() - 1);
        stack.add(new TreeNode(tok, left, right));
      } else {
        stack.add(new TreeNode(tok));
      }
    }
    return stack.get(stack.size() - 1);
  }
}
package com.leet;

class TreeNode extends Node {
  private String mOperator;
  private String mValue;
  private TreeNode mLeft;
  private TreeNode mRight;

  public TreeNode(String value) { mValue = value; }

  public TreeNode(String op, TreeNode left, TreeNode right) {
    mOperator = op;
    mLeft = left;
    mRight = right;
  }

  final public int evaluate() {
    if (mOperator == null) {
      return Integer.parseInt(mValue);
    }
    switch (mOperator) {
    case "+":
      return mLeft.evaluate() + mRight.evaluate();
    case "-":
      return mLeft.evaluate() - mRight.evaluate();
    case "*":
      return mLeft.evaluate() * mRight.evaluate();
    case "/":
      return mLeft.evaluate() / mRight.evaluate();
    default:
      return Integer.parseInt(mValue);
    }
  }
}
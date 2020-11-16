package bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BST implementations with 3 different traversing order.
 */
public class BSTImpl<T> implements BST<T> {
  private TreeNode  root;
  private Map<Integer, T> nodeDic;

  /**
   * BST's constructor.
   * Create am empty tree.
   */
  public BSTImpl() {
    this.root = new NullNode();
    this.nodeDic = new HashMap<>();
  }

  @Override
  public Map<Integer, T> getDic() {
    return nodeDic;
  }

  @Override
  public String preOrder() {
    List<TreeNode> preList = new ArrayList<TreeNode>();
    preList = this.root.preOrder(this.root, preList);
    return this.orderToString(preList);
  }

  @Override
  public String inOrder() {
    List<TreeNode> inList = new ArrayList<TreeNode>();

    return this.orderToString(this.root.inOrder(this.root, inList));
  }

  @Override
  public String postOrder() {
    List<TreeNode> postList = new ArrayList<TreeNode>();

    return this.orderToString(this.root.postOrder(this.root, postList));
  }

  @Override
  public int height() {
    return this.root.height(this.root);
  }

  @Override
  public void add(T obj) {
    this.root = this.root.addChild(1, obj);
    this.nodeDic.put(this.root.getLocation(obj), obj);
  }

  @Override
  public int size() {
    return this.nodeDic.size();
  }

  @Override
  public boolean present(T obj) {
    return this.nodeDic.containsValue(obj);
  }

  @Override
  public T minimum() {
    if (this.nodeDic.size() == 0) {
      return null;
    }

    int index = this.root.minimum(1);

    return this.getDic().get(index);
  }

  @Override
  public T maximum() {
    if (this.nodeDic.size() == 0) {
      return null;
    }

    int index = this.root.maximum(1);

    return this.getDic().get(index);
  }

  /**
   * Return string description of various traversal.
   */
  public String orderToString(List<TreeNode> obj) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (TreeNode n : obj) {
      sb.append(n.getData());
      sb.append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.append("]");

    return sb.toString();
  }

  @Override
  public String toString() {
    List<Integer> tmp = new ArrayList<>();
    for (Map.Entry<Integer, T> entry : this.nodeDic.entrySet()) {
      tmp.add(Integer.parseInt(entry.getValue().toString()));
    }
    Collections.sort(tmp);

    return tmp.toString().replaceAll(",", "");
  }
}

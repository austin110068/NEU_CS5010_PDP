package bst;

import java.util.Map;

/**
 * Created by Chien-Yu.
 */
public interface BST<T> {
  /**
   * Insert an object in the tree.
   */
  public void add(T obj);

  /**
   * Return the size of this tree.
   * i.e. the number of elements in this tree.
   */
  public int size();

  /**
   * Returns true if this object is present in the tree, false otherwise.
   */
  public boolean present(T obj);

  /**
   * Returns the smallest object (defined by the ordering) in the tree,
   * and null if the tree is empty.
   */
  public T minimum();

  /**
   * Returns the smallest object (defined by the ordering) in the tree,
   * and null if the tree is empty.
   */
  public T maximum();

  /**
   * Let the tree do preorder traversal.
   * Calling it recursively.
   */
  String preOrder();

  /**
   * Let the tree do inorder traversal.
   * Calling it recursively.
   */
  String inOrder();

  /**
   * Let the tree do postorder traversal.
   * Calling it recursively.
   */
  String postOrder();

  /**
   * Compute and return the height of the the subtree.
   */
  public int height();

  /**
   * Get map for BST.
   */
  Map<Integer, T> getDic();
}

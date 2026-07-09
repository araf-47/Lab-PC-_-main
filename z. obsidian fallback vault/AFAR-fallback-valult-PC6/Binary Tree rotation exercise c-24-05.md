# C1
Sure — here’s the same rotation idea using actual numbers in the diagrams so it’s easier to understand.

```java
class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}

public class BinaryTree {

    // RIGHT ROTATION
    //
    //         30
    //        /
    //      20
    //     /
    //   10
    //
    // After rotation:
    //
    //       20
    //      /  \
    //    10    30
    //

    public Node rightRotate(Node root) {

        Node newRoot = root.left;
        Node movedSubtree = newRoot.right;

        // rotation
        newRoot.right = root;
        root.left = movedSubtree;

        return newRoot;
    }

    // LEFT ROTATION
    //
    //      10
    //        \
    //         20
    //           \
    //            30
    //
    // After rotation:
    //
    //        20
    //       /  \
    //     10    30
    //

    public Node leftRotate(Node root) {

        Node newRoot = root.right;
        Node movedSubtree = newRoot.left;

        // rotation
        newRoot.left = root;
        root.right = movedSubtree;

        return newRoot;
    }

    // inorder traversal
    public void print(Node node) {

        if (node == null) {
            return;
        }

        print(node.left);
        System.out.print(node.value + " ");
        print(node.right);
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        // -------------------------
        // RIGHT ROTATION EXAMPLE
        // -------------------------

        Node root = new Node(30);
        root.left = new Node(20);
        root.left.left = new Node(10);

        System.out.println("Before Right Rotation:");
        tree.print(root);

        root = tree.rightRotate(root);

        System.out.println("\nAfter Right Rotation:");
        tree.print(root);

        // -------------------------
        // LEFT ROTATION EXAMPLE
        // -------------------------

        root = new Node(10);
        root.right = new Node(20);
        root.right.right = new Node(30);

        System.out.println("\n\nBefore Left Rotation:");
        tree.print(root);

        root = tree.leftRotate(root);

        System.out.println("\nAfter Left Rotation:");
        tree.print(root);
    }
}
```

Visual memory trick:

### Right Rotate

```text
    30              20
   /       -->     /  \
 20               10  30
/
10
```

### Left Rotate

```text
10                  20
  \       -->      /  \
   20             10  30
     \
      30
```

These rotations are the core idea behind:

- AVL Trees
    
- Red-Black Trees
    
- Self-balancing BSTs

# 🌠 C2 (explanation)
Awesome — this is one of the most important concepts in trees.

I’ll explain it slowly like you’re seeing rotations for the first time.

---

# 1. What is a Binary Tree?

A binary tree is a structure where each node can have:

* a `left` child
* a `right` child

Example:

```text id="0l4v5n"
       20
      /  \
    10    30
```

Here:

* `20` is the root
* `10` is left child
* `30` is right child

---

# 2. The Node Class

```java id="7hnmx3"
class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}
```

This is the blueprint for every tree node.

---

## What each line means

### `int value;`

Stores the number inside the node.

```text id="efznq0"
Node(20)
```

means:

```text id="f5jcxw"
value = 20
```

---

### `Node left;`

Points to the left child.

Example:

```text id="n9h2oc"
    20
   /
 10
```

`20.left` points to `10`

---

### `Node right;`

Points to the right child.

Example:

```text id="g5hgt5"
20
  \
   30
```

`20.right` points to `30`

---

# 3. Creating Nodes

```java id="06cbbv"
Node root = new Node(30);
root.left = new Node(20);
root.left.left = new Node(10);
```

This creates:

```text id="2gz4d0"
      30
     /
   20
   /
 10
```

---

# 4. Why Rotations Exist

Trees can become unbalanced.

Bad tree:

```text id="8ndd3r"
30
/
20
/
10
```

This behaves almost like a linked list.

Searching becomes slower.

Rotations help rebalance the tree.

---

# 5. Right Rotation

Starting tree:

```text id="5iq51k"
      30
     /
   20
   /
 10
```

We rotate RIGHT around `30`.

After rotation:

```text id="qk2h80"
      20
     /  \
   10    30
```

Balanced now.

---

# 6. Understanding the Code

## Right Rotate Method

```java id="cgp67r"
public Node rightRotate(Node root)
```

This function rotates the tree and returns the new root.

---

## Step 1

```java id="x4x0q0"
Node newRoot = root.left;
```

If:

```text id="6q1d9m"
    30
   /
 20
```

Then:

```text id="lixjnv"
newRoot = 20
```

---

## Step 2

```java id="ot5fe5"
Node movedSubtree = newRoot.right;
```

This stores the middle subtree temporarily.

Why?

Because rotation changes connections, and we don’t want to lose nodes.

---

## Step 3 — Actual Rotation

```java id="1fw39s"
newRoot.right = root;
```

Before:

```text id="l9n0tx"
20
```

After:

```text id="n9p4g3"
20
  \
   30
```

---

## Step 4

```java id="0t9wbd"
root.left = movedSubtree;
```

Reconnects the middle subtree properly.

---

## Final Step

```java id="3czv52"
return newRoot;
```

Because after rotation:

```text id="3x8kj7"
20
```

is now the root.

---

# 7. Left Rotation

Starting tree:

```text id="5u71n7"
10
  \
   20
     \
      30
```

After LEFT rotation:

```text id="4r9f1r"
      20
     /  \
   10    30
```

---

# 8. Left Rotation Code

```java id="9j6i6h"
Node newRoot = root.right;
```

If root is `10`:

```text id="jz5g6x"
10
  \
   20
```

Then:

```text id="m0gm20"
newRoot = 20
```

---

## Then

```java id="e7krrf"
newRoot.left = root;
```

Makes:

```text id="sl0p4z"
    20
   /
 10
```

---

# 9. Why We Return the New Root

After rotation:

OLD root is no longer root.

Example:

Before:

```text id="e2c9zc"
30
```

After right rotation:

```text id="h0f2h0"
20
```

becomes the new root.

So we must return it.

---

# 10. Inorder Traversal

```java id="k31x9f"
public void print(Node node)
```

This prints:

1. left subtree
2. current node
3. right subtree

For:

```text id="d6w2u0"
    20
   /  \
 10   30
```

Output:

```text id="nkm63l"
10 20 30
```

---

# 11. Big Picture

Rotations are used in:

* AVL Trees
* Red Black Trees
* Self-balancing Binary Search Trees

Their purpose is:

✅ keep tree balanced
✅ make search fast
✅ prevent linked-list-shaped trees

---

# 12. Most Important Thing to Remember

## RIGHT ROTATION

Left child moves UP.

```text id="4o7mxt"
      30              20
     /       -->     /  \
   20               10  30
  /
10
```

---

## LEFT ROTATION

Right child moves UP.

```text id="9oh5p6"
10                  20
  \       -->      /  \
   20             10  30
     \
      30
```

---

# 13. Practice Tasks

Try these yourself:

### Beginner

* Add more nodes
* Print preorder traversal
* Print postorder traversal

### Medium

* Write `insert()`
* Rotate non-root nodes

### Advanced

* Build an AVL tree
* Auto-balance after insertion

You’re learning a real data structure used in databases, compilers, and search systems.

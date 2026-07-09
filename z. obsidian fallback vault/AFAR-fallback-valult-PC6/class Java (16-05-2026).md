# Chapter 25: Binary Search Tree
max node count is 2.
- **length**, max lengthy line of inter-connected nodes.
- **level**: 
- **depth**: 
- **Sibling** : same parents.
- **leaf**: the bottom most level (node).
- **Height**: top level to bottom. (total number or level - 1 = depth.)

- How to we do search in the tree.
	- Compare the search element with the root node.
		- If it's bigger search in right.
		- if smaller search in the left.

Tree traversal: running loop on the the tree; recursive function is batter for this type of operation.

- In order traversal. with recursive method. (binary tree traversal is not possible with loop, only with recursive method.) 

#### 25.2.2 Searching for an Element
only searching is possible while loop. But recursive is still and option. 
match করলে node এর reference টা পাঠাই দিবে । 
#### 25.2.3 Inserting an Element into a BST
insert where is null using the same traversal style (left - right.)
#### 25.2.4 Tree Traversal
inorder traversal
postorder traversal
pre-traversal.

breadth first (it is complex. book doesn't has any example for this.)

none of them are sorted. 

### 25.3 Deleting Elements from a BST
1. Must fine the target node and it's parents.
2. replace the target node with it's left or right child.

**right most**
find max

### ~~25.4 Tree Visualization and MVC~~ (<Ignore. But HW given.)

### 25.5 Iterators
`BST` is no longer available in Java.




# HW
- **LISTING 25.9** BSTAnimation.java || <- condition: ==do it in console==. && .Print exectly this `FIGURE 25.4 Two new elements are inserted into the tree`. `(b) Inserting 59`. input array (with Scanner), make the same tree.
- + previous HW from [[class Java (12-05-2026)]].
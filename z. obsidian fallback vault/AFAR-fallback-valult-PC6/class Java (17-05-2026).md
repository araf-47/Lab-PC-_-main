# Chapter 26: AVL tree.
**well balance** : left or right height difference [+1] or [-1] or [0].
**perfect balance** : [[Perfect balanced binary tree (example).canvas]].

আপাতত ignore. পরে আবার ফেরত আসা হবে । 

# Chapter 27: HASHING
**imp Rule** : same input always should give same output.

index = comes from array.
this array lives in hash table.

- Map = is a `key : value` pair data structure. 
	- key must be unique. 
	- value (actual data) can be duplicate.
A map is also called a dictionary, a hash table, or an associative array.
- calculated hash number will be the array index. hash=12 means, index 12 will be it's allocation.
map's key and value lives in the container called `Entry`.

prefect hashing logic. 
polusion.

hash function's output in called hash code. (String)
map index must be a number.

### 27.3 Hash Functions and Hash Codes
#### 27.3.2 Hash Codes for Strings
- hash code is a built in method in java.
	- `.hash()` <- for String.
Horner’s rule: polynomial evaluation.
 31, 33, 37, 39, and 41 <- they have lowest pollution.
#### 27.3.1 Hash Codes for Primitive Types
hash with wrapper class.
#### 27.3.3 Compressing Hash Codes
h(hashCode) = hashCode % N
bitwise operator <- দরকার নাই। 

### 27.4 Handling Collisions Using Open Addressing
in case of collision the technique of finding an empty space is called open addressing.
#### Linear Probing
complex. 
not so efficient. 
- probing until it finds an empty index. [logic: `key + 1` until it find the next unoccupied space.] [it can also be jumping/not sequential.]
- circular hash table: occurs when probing goes at the end and find no empty index. it's goes to the first index of the table. 
- to Get : key must match.
- to delete : same way search Entry, match ? delete.
 cluster : A collision zone.
#### 27.4.2 Quadratic Probing
#### Double hashing 
hash function inside hash function.

### 27.4 Handling Collisions Using Open Addressing
### 27.6 Load Factor and Rehashing




# Other 
Shift operation <- কোন দরকার নাই। 
signed and unsigned shift.
# HW 
put আর get
- closing loop with user input is called sentinel value.

### 5.2.5 Input and Output Redirections
```java
Scanner scanner = new Scanner(System.in);
int count = 0;
while (scanner.hasNext()){
	String fruit = scanner.next();
	count++;
	System.out.println(fruit);
}
System.out.println("total number of fruits:- " + count);
scanner.close();
```


### 5.3 The do-while Loop
It will execute 1st time without any condition. And the while will determine that is it going to execute for second time.
```java
int count = 1;
do {
	System.out.println(count);
} while(++count < 11);
```

### 5.4 The for Loop
- for loop condition must have 3 parts.
	- even if you don't put `i` variable you must maintain its `;`. E.g. ` for (; i < 10; i++)`
```java
for (int i = 2; i <= 100; i+=2) { // postfix, prefix doesn't matter here.
	System.out.println(i);
}
```

```java
for (int i = 0, j = 0; i + j < 10; i++, j++) {
// Do something
}
```

- use `while` loop when there is not . . . 
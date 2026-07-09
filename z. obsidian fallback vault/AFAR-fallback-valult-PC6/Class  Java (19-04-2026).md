### 4.4.7 Comparing Strings
- TABLE 4.8 Comparison Methods for String Objects
	- compareTo(s1) <- **Ignore** (numeric value only).
	- compareToIgnoreCase(s1) <- **ignore**.
	- ==Learn all the others==.
	- startwith, endwith, contains.

### 4.4.8 Obtaining Substrings
- `substring(beginIndex, endIndex)`. {It works like finding index we did in JavaScript.}
	- FIGURE 4.2 The substring method obtains a substring from a string. <- it shows the index calculation for the substring obtainment.
### 4.4.9 Finding a Character or a Substring in a String
- TABLE 4.10 The String class contains the methods for finding substrings. 
	- index(ch) <- doesn't work on current Java version.
	- indexOf(s)
	- indexOf(ch, fromIndex)
	- lastIndexOf(ch) <- it is not going to count index in reverse like `3, 2, 1, 0`; It will count as normal like `0 1 2 3 4`
	- lastIndexOf(ch, fromIndex) <- here `fromIndex` act opposite of normal `fromIndex` from `indexOf`.
```java
        String justString = "Welcome to Java";
        // System.out.println(justString.substring(8, 10));
        System.out.println(justString.indexOf("J"));
        System.out.println(justString.indexOf("com", 1));
```

```java
        String justString = "Welcome to Java";
        // System.out.println(justString.substring(8, 10));
        System.out.println(justString.indexOf("J"));
        System.out.println(justString.indexOf("com", 1));

        double amount = 12618.98;
        double interestRate = 0.0013;
        double interest = amount * interestRate;
        System.out.printf("Interest is $%4.2f", interest);

        double justIt = 1234.4321;
        System.out.printf(" $%4.1f", justIt);
```
### 4.6 Formatting Console Output
- `printf`
- TABLE 4.12 Examples of Specifying Width and Precision

## Ch: 5 - Loop
### while loop
```java
        String name = "John";
        int i = -1;
        while (++i < name.length()) {
            System.out.println(name.charAt(i));
        }
```

```java
String name = "John";
int i = -1;
while (++i < name.length()) {
	System.out.println(name.charAt(i));
	if (i == 2) {
		break;
	}
}
```
- `break` => breaks it's parent loop, not it's grandparent. only it's parent look

```java
Scanner comScan = new Scanner(System.in);
String command = "";
while (!command.equals("exit")) {
	System.out.println("enter a command: ");
	command = comScan.nextLine();
	System.out.println("you entered: " + command);
}
```
### 5.2.2 Loop Design Strategies


# IMP information 
### LISTING 5.5 SentinelValue.java
```java
Scanner comScan = new Scanner(System.in);
String command = "";
while (!command.equals("exit")) {
	System.out.println("enter a command: ");
	command = comScan.nextLine();
	System.out.println("you entered: " + command);
}
```
# exam
110 to 189
# HW
- 4.16, 4.17

# garbage bump
```java
        String input = "This is nuclear-code-x9E.";
        boolean inVerify = input.endsWith("x9E.");
        // System.out.println(inVerify);
        String resposeGov = (inVerify == true) ? "launch the nuclear warhead" : "stay put";
        System.out.println(resposeGov);

        Scanner collectorX = new Scanner(System.in);
        String input2 = collectorX.nextLine();
        // String input2 = "02mnX-nriert-tre4-x9E";
        boolean inVerify2 = input2.contains("araf47");
        // System.out.println(inVerify2);
        String resposeGov2 = (inVerify2 == true) ? "launch the 2nd nuclear warhead to America" : "wrong nuclear code, stay put";
        System.out.println(resposeGov2);
```
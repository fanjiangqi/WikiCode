## IO

### 控制台输入 

```java
Scanner in = new Scanner(System.in);
String name = in.nextLine();//下一行,到回车结束
int age = in.nextInt();//到空格或回车结束
in.close();
```

### 文件读写

```java
//输入
Scanner in = new Scanner(Paths.get("fan.txt"));
String s = in.nextLine();
int num = in.nextInt();
in.close();
//输出
PrintWriter out = new PrintWriter("fan.txt");
out.println("lulu");
out.print("haha");
out.close();
```


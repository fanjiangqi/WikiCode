## Java中 Iterable接口和 Iterator接口完全理解

*2016.12.28 晚 fanjiangqi*

首先，Iterable 是java.lang中的一个接口，实现这个接口，需要实现如下方法并返回一个 Iterator 接口的迭代器

```java
public interface Iterable<T>{
  Iterator<T> iterator(); 
}
```

Iterator 是 java.util中的一个接口，实现改接口需要实现如下3个方法

```java
public interface Iterator<T>{
  boolean hasNext();
  T next();
  void remove();
}
```

通常可以实现了 Iterable接口的类可以使用如下方式实现 iterator()方法：

```java
public Iterator<T> iterator(){
  return new NewIterator();
}
private class NewIterator implements Iterator<T>{
  private int i = N;
  public boolean hasNext() {return i>0;}
  public T next() {return a[--N];}
  void remove();
}
```

在Java类库中，ArrayList 之类集合实现了Iterable接口，支持foreach，以及如何迭代

```java
ArrayList<T> list;
Iterator<T> it = list.iterator();
it.hasNest();
it.next();
```


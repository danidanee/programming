# Overloading vs Overriding 

> 오버로딩 : 여러 메서드가 같은 이름을 갖고 있으나 인자의 수나 자료형이 다른 경우
>
> 오버라이딩 : 상속받은 메소드를 재정의 하는 것

<br/>

### 오버로딩

* 자바의 한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메소드가 있더라도 `매개변수의 개수 또는 타입`이 다르면, 같은 이름을 사용해서 메소드를 정의할 수 있다.
* **메소드의 이름이 같고, 매개변수의 개수나 타입이 달라야 한다.**
* 주의할 점은 <span style="color:red">**리턴 값**</span>만 다른 것은 오버로딩을 할 수 없다는 것이다.
* **접근 제어자도 자유롭게 지정**해 줄 수 있다 (public, default, protected, private)
* 접근 제어자만 다르게한다고 오버로딩이 가능하지 않다

<br/>

**사용하는 이유**

* `같은 기능`을 하는 메소드를 하나의 이름으로 사용할 수 있다.
  * println → int, double, boolean, String 등의 아주 다양한 타입의 매개변수들을 집어넣어도 우리는 그 함수들이 어떻게 실행되지는 모르지만 콘솔창에 아주 잘 출력해주는 것을 볼 수 있다
* 메소드 이름을 `절약`할 수 있다
  * printlnInt, printlnDouble, printlnBoolean 등 수많은 메소드들의 이름을 정해줘야 할 것이다. 이는 프로그래머의 입장에서는 메소드의 네이밍에 고민을 가중시킨다. 그리고 이런 이름들은 다른 곳에 사용할 가능성도 생기게 된다.

<br/>

```java
class OverloadingTest {

	public static void main(String[] args) {
		OverloadingMethods om = new OverloadingMethods();

		om.print();
		System.out.println(om.print(3));
		om.print("Hello!");
		System.out.println(om.print(4, 5));
	}
}

class OverloadingMethods {
	public void print() {
		System.out.println("오버로딩1");
	}

	String print(Integer a) {
		System.out.println("오버로딩2");
		return a.toString();
	}

	void print(String a) {
		System.out.println("오버로딩3");
		System.out.println(a);
	}

	String print(Integer a, Integer b) {
		System.out.println("오버로딩4");
		return a.toString() + b.toString();
	}

}
```

```java
오버로딩1
오버로딩1
오버로딩2
3
오버로딩3
Hello!
오버로딩4
45
```

<br/>

### 오버라이딩

* 부모 클래스로부터 상속받은 메소드를 자식 클래스에서 재정의
* 상속받은 메소드를 그대로 사용할 수도 있지만, 자식 클래스에서 상황에 맞게 변경해야하는 경우 오버라이딩할 필요가 생긴다.
* 자식 클래스에서는 **오버라이딩하고자 하는 메소드의 이름, 매개변수, 리턴 값이 모두 같아야 한다.**
* 부모 클래스의 메소드를 오버라이딩하는 것은 `내용만을 새로 정의`하는 것이므로 **선언부는 부모의 것과 완벽히 동일**해야 하는 것을 볼 수 있다.

<br/>

**주의점**

* **자식 클래스에서 오버라이딩하는 메소드의 접근 제어자는 부모 클래스보다 더 좁게 설정할 수 없다.**
  * 부모클래스의 접근제어자는 default로 설정되어 있다. 여기서 자식 클래스들은 default보다 같거나 더 넓은 범위의 접근제어자만 설정할 수 있으므로 default, protected, public 이 세 개의 접근 제어자는 사용이 가능하다.
* **예외(Exception)는 부모 클래스의 메소드 보다 많이 선언할 수 없다.**
  * 부모 클래스에서 어떤 예외를 throws 한다고 하면, 자식 클래스에서는 그 예외보다 더 큰 범위의 예외를 throws할 수 없다는 것이다.
* **static메소드를 인스턴스의 메소드로 또는 그 반대로 바꿀 수 없다.**
  * 부모 클래스의 static메소드를 자식에서 같은 이름으로 정의할 수 있지만 이것은 다시 정의하는 것이 아니라 같은 이름의 static메소드를 새로 정의하는 것이다.

<br/>

```java
public class OverridingTest {

	public static void main(String[] args) {
		Person person = new Person();
		Child child = new Child();
		Senior senior = new Senior();
		
		person.cry();
		child.cry();
		senior.cry();
	}
}

class Person {
	void cry() {
		System.out.println("흑흑");
	}
}

class Child extends Person {
	@Override
	protected void cry() {
		System.out.println("잉잉");
	}
}

class Senior extends Person {
	@Override
	public void cry() {
		System.out.println("훌쩍훌쩍");
	}
}
```

```java
흑흑
잉잉
훌쩍훌쩍
```

<br/>

### @Override는 용도

* **어노테이션(Annotation)**이라는 것으로 직역하면 주석이라는 뜻
* 이는 일반적인 주석과 다르게, 검증하는 기능을 한다. 여기서 사용된 @Override라는 어노테이션은 오버라이딩을 검증하는 기능
* 코드상으로 검사했을 때 오버라이딩이 실제로 시행되지 않았다면 컴파일시 오류를 출력

<br/>

| 구분              | Overloading                            | Overriding                                                   |
| ----------------- | -------------------------------------- | ------------------------------------------------------------ |
| **접근 제어자**   | **모든 접근 제어자**를 사용할 수 있다. | 부모 클래스의 메소드의 접근 제어자보다 <br />**더 넓은 범위의 접근 제어자**를 <br />자식 클래스의 메소드에서 설정할 수 있다. |
| **메소트명**      | 동일                                   | 동일                                                         |
| **리턴명**        | 동일 X                                 | 동일                                                         |
| **매개변수**      | 동일 X                                 | 동일                                                         |
| **적용** **범위** | **같은 클래스** 내에서 적용된다.       | **상속관계**에서 적용된다.                                   |

<br/>

------

[참고 자료]

https://gmlwjd9405.github.io/2018/08/09/java-overloading-vs-overriding.html

https://hyoje420.tistory.com/14
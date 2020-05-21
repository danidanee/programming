# Java 특징

> 객체 지향 프로그래밍 언어

<br/>

* 자바가상머신(JVM)만 설치하면 컴퓨터의 운영체제에 상관없이 작동한다 → 이식성이 높다
* 기본 자료형을 제외한 모든 요소들이 객체로 표현
* 객체 지향 개념의 특징인 캡슐화, 상속, 다형성이 잘 적용된 언어
* Garbage Collector를 통한 자동적인 메모리 관리
* 멀티쓰레드(Multi-thread)를 지원 → 병렬처리

<br/>

### 객체 지향 프로그래밍 (OOP)

* 프로그래밍에서 필요한 데이터를 `추상화`시켜 상태와 행위를 가진 `객체`를 만들고 그 객체들 간의 유기적인 `상호작용`을 통해 로직을 구성하는 프로그래밍 방법
* 순차적으로 프로그램이 동작하는 기존의 것들과는 다르게 객체와 객체의 상호작용을 통해 프로그램이 동작

<br/>

### 객체 지향 프로그래밍 장, 단점

**장점**

* 코드 재사용이 용이
  * 만들어둔 클래스를 가져와 이용할 수 있고, 상속을 통해 확장해서 사용할 수 있음
* 유지보수가 쉬움
  * 절차 지향 프로그래밍에서는 코드를 수정해야할 때 일일이 찾아 수정
  * 객체 지향 프로그래밍에서는 수정해야 할 부분이 클래스 내부에 멤버 변수혹은 메서드로 있기 때문에 해당 부분만 수정하면 됨. 
* 대형 프로젝트에 적합
  * 클래스단위로 모듈화시켜서 개발할 수 있으므로 대형 프로젝트처럼 여러명, 여러회사에서 개발이 필요할 시 업무 분담하기 쉽다.

<br/>

**단점**

* 처리속도가 느림
* 객체가 많으면 용량이 커질 수 있음
* 설계시 많은 시간과 노력이 필요

<br/>

### 클래스와 객체

* **클래스** : 어떤 문제를 해결하기 위한 데이터를 만들기기 위해 추상화를 거쳐 집단에 속하는 **속성**(attribute)과 **행위**(behavior)를 **변수**와 **메서드**로 정의한 것
* **인스턴스(객체)** : 클래스에서 정의한 것을 토대로 실제 메모리상에 할당된 것으로 실제 프로그램에서 사용되는 데이터
  * 객체는 속성과 동작으로 구성되어 있다고 보면 되는데 자바에서는 이 속성과 동작을 각각 `필드(field)` 와 `메소드(method)` 라 부릅니다
  * `필드` : 객체의 정보 (상태)
  * `메소드` : 객체의 동작 (기능)
  * 데이터(변수)와 그 데이터에 관련되는 동작(함수) → 즉 절차, 방법, 기능을 모두 포함한 개념
  * 기차역에서 승차권을 발매하는 경우, 실체인 '손님'과 동작인 '승차권 주문'은 하나의 객체이며, 실체인 '역무원'과 동작인 '승차권 발매'도 하나의 객체이다.

```java
class SmartPhone {
  /* fields */
  String name; // 이름
  String color; // 색상
  int price; // 가격
  /* methods */
  void call(String phoneNum) {
    // 전화 걸기
  }
  void messege(String phoneNum) {
    // 메세지 보내기
  }
}
```

<br/>

### 객체 지향 개념 특징

* 추상화

  * 불필요한 정보는 숨기고 중요한 정보만을 표현함으로써 공통의 속성이나 기능을 묶어 이름을 붙이는 것
  * 사물들의 공통된 특징, 즉 추상적 특징을 파악해 인식의 대상으로 삼는 행위
  * 체적인 사물들의 공통적인 특징을 파악해서 이를 하나의 개념(집합)으로 다루는 수단

  ```java
  // 구체적인 개념에 의존하는 경우
  switch(자동차 종류)
  case 아우디: // 아우디 엔진 오일을 교환하는 과정을 기술
  case 벤츠: // 벤츠 엔진 오일을 교환하는 과정을 기술
  case BMW: // BMW 엔진 오일을 교환하는 과정을 기술
  ... 새로운 종류의 자동차가 나오면 계속해서 추가해야 한다.
  end switch
  ```

  ```java
  // 추상적인 개념에 의존하는 경우
  // 이 코드는 어떤 새로운 종류의 자동차가 나와도 변경할 필요가 없다.
  void changeEngineOil(Car c) {
    c.changeEngineOil(); // 추상 메서드
  }
  ```

  

<img alt="abstract" src="https://gmlwjd9405.github.io/images/oop-features/abstract.png">

<br/>

* 캡슐화
  * **비슷한 역할을 하는 속성과 메소드들을 하나의 클래스로 모은것**
  * 객체의 내용 중 숨기고 싶은 부분은 외부에서 접근 할 수 없다.
  * 해당 객체내의 함수에 의해서만 접근 가능 하도록 하는 것이다. 이를 통해서 정보 은닉이 가능해진다. 
    * 정보은닉 : 캡슐 내부의 로직이나 변수들을 감추고 외부에는 기능(api)만을 제공하는것
  * 낮은 결합도 를 유지할 수 있도록 해주는 객체지향 설계 원리
  * 객체내부의 구조를 알지 못하며 객체가 노출해서 제공하는 필드와 메소드만 이용할 수 있습니다
  * 자바언어는 캡슐화된 멤버를 노출시킬지, 숨길 것인지를 결정하기 위해 **접근제한자**를 사용

<br/>

* 상속
  * Class의 멤버[데이터]와 함수를 다른 Class에 물려주거나, 물려 받는 것을 말한다.
  * 코드의 재사용을 증대할 수 있고 같은 기능을 또 구현 할 필요가 없다.
  * 상속받은 함수를 추가적으로 데이터와 함수 내용을 변경 가능
  * 같은 기능을 가진 함수는 그대로 사용 할수있고, 같은 기능의 함수를 다른 이름으로 만들 필요도 없어진다.
  * 상속 키워드는 `extends`

<img alt="inherit" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FZvnWN%2FbtqxTLYsCHd%2FLLlllKZ4wkcfC8Hmcd1Kl0%2Fimg.png"/>

<br/>

* 다형성

  * 서로 다른 클래스의 객체가 같은 메시지를 받았을 때 각자의 방식으로 동작하는 능력
  * 같은 이름의 메서드 호출에 대하여 객체에 따라 다른 동작을 할 수 있도록 구현되는 것을 의미
  * 상속과 연계되어 동작하면 매우 강력하게 동작한다
  * 코드를 간결하게 하고 변화에도 유연하게 대처할 수 있다.
  * 오버로딩, 오버라이딩

  ```java
  // 다형성을 사용하지 않는 경우
  public class Cat {
    public void meow(){ System.out.println("야옹"); }
  }
  public class Dog {
    public void bark(){ System.out.println("멍멍"); }
  }
  public class Parrot {
    public void sing(){ System.out.println("안녕"); }
  }
  
  public class Main {
    public static void main(String[] args) {
      Cat cat = new Cat();
      Dog dog = new Dog();
      Parrot parrot = new Parrot();
      // 애완동물 세 마리의 울음소리 호출
      cat.meow(); dog.bark(); parrot.sing();
    }
  }
  ```

  ```java
  // 다형성을 사용한 경우
  // 부모 클래스
  public abstract class Pet {
    public abstract void talk();
  }
  // 자식 클래스
  public class Cat extends Pet {
    public void talk(){ System.out.println("야옹"); }
  }
  public class Dog extends Pet {
    public void talk(){ System.out.println("멍멍"); }
  }
  public class Parrot extends Pet {
    public void talk(){ System.out.println("안녕"); }
  }
  
  public class Main {
    public static void main(String[] args) {
      Pet[] pets = { new Cat(), new Dog(), new Parrot() };
      // 애완동물 세 마리의 울음소리 호출
      for (int i = 0; i < 3; i++){
        // 실제 참조하는 객체에 따라 talk 메서드가 실행된다.
        pets.talk();
      }
    }
  }
  ```

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FI7rhG%2FbtqxVzCNjsm%2FlnUwxkofn8pZfGiXjQBE90%2Fimg.png"/>

<br/>

------

[참고 자료]

https://jeong-pro.tistory.com/95

https://easy-h.tistory.com/2

https://gmlwjd9405.github.io/2018/07/05/oop-features.html

https://richong.tistory.com/122

https://lbmmbl.tistory.com/20

https://cloudstudying.kr/questions/283
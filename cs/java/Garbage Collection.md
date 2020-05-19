# Garbage Collection

> 더 이상 필요로 하지 않는 객체를 찾아서 지우는 역할

<br/>

* 가비지는 '정리되지 않은 메모리', '유효하지 않은 메모리 주소'
* 자바에서는 프로그램 코드에서 메모리를 명시적으로 지정해 해제하지 않습니다
* 시스템에서 더이상 사용하지 않는 동적 할당된 메모리 블럭을 찾아 자동으로 다시 사용 가능한 자원으로 회수하는 것
* 힙 메모리만 다룬다
* 시스템에서 가비지컬렉션을 수행하는 부분을 가비지 컬렉터라 부른다.
* `사용 이유` : 가비지는 메모리가 부족할 때 이런 가비지들을 메모리에서 해제 시켜 다른 용도로 사용 할 수 있게 해준다
* `주의점` : 모든 메모리 누수를 잡아주는 것은 아님으로 메모리 누수에 대한 경계를 늦추어서는 안된다.

<br/>

**Garbage 대상이 되는 케이스**

* 객체가 null인 경우
* 블럭 안에서 생성된 객체는 종료 후 대상이 된다
* 부모 객체가 null이 되면, 참조된 자식 객체들도 대상이 된다
* **주소를 잃어버려서 사용할 수 없는 메모리**
* 앞으로 사용하지 않고 메모리를 가지고 있는 객체

<br/>

### Stop-The-World

* GC을 실행하기 위해 JVM이 어플리케이션 실행을 멈추는 것
* `Stop-The-World`가 발생하면 `GC`를 실행하는 스레드를 제외한 나머지 스레드는 모두 작업을 멈춥니다.
* GC 작업을 완료한 이후에야 중단했던 작업이 다시 시작됩니다.
* 어떤 GC 알고리즘을 사용해도 `Stop-The-World`는 발생하기 때문에 보통 GC 튜닝이란 이 `Stop-The-World` 시간을 줄이는 작업을 말합니다.

<br/>

### Mark and Sweep (GC 과정)

* **Mark** : GC가 스택의 모든 변수 또는 Reachable 객체를 스캔하면서 각각 어떤 객체를 참조하고 있는지 찾는 과정
* 이 과정에서 Stop-The-World 발생
* **Sweep** : Mark 되어있지 않은 객체들을 힙에서 제거하는 과정

<br/>

### Minor GC 와 Major GC

* JVM의 Heap은 Young, Old, Perm 세 영역으로 나뉜다. Young 영역에서 발생한 GC를 Minor GC, 나머지 두 영역에서 발생한 GC를 Major GC(Full GC)라고 한다.
* `Young 영역` : 새롭게 생성한 객체가 위치, 대부분의 객체가 금방 unreachable 상태가 되기 때문에 많은 객체가 Young 영역에 생성되었다가 사라진다.
* `Old 영역` : Young 영역에서 reachable 상태를 유지해 살아남은 객체가 여기로 복사된다. 대부분 Young 영역보다 크게 할당하며, 크기가 큰 만큼 Young 영역보다 GC는 적게 발생한다.
* `Perm 영역` : Method Area라고도 한다. 클래스와 메소드 정보와 같이 자바 언어 레벨에서는 거의 사용되지 않는 영역이다.

<br/>

### Reachability

* 어떤 객체에 유효한 참조가 있으면 'reachable'
* 없으면 'unreachable'로 구별하고 'unreachable'객체를 가비지로 간주

<br/>

------

[참고 사이트]

[https://jungwoon.github.io/java,%20gc/2019/07/27/Garbage-Collection/](https://jungwoon.github.io/java, gc/2019/07/27/Garbage-Collection/)

https://dsnight.tistory.com/50

[https://velog.io/@litien/%EA%B0%80%EB%B9%84%EC%A7%80-%EC%BB%AC%EB%A0%89%ED%84%B0GC](https://velog.io/@litien/가비지-컬렉터GC)
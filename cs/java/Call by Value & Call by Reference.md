# Call by Value & Call by Reference

> Call by Reference : 매개 변수의 원래 주소에 값을 저장하는 방식
>
> Call by Value : 주어진 값을 복사하여 처리하는 방식

<br/>

* 값을 복사를 하여 처리를 하느냐, 아니면 직접 참조를 하느냐 차이

<br/>

### Call by Value

* **메소드 호출 시에 사용되는 인자의 메모리에 저장되어 있는 값(value)을 복사하여 보낸다.**
* 복사된 인자는 함수 안에서 지역적으로 사용되는 local value의 특성을 가진다
* 따라서 함수 안에서 인자의 값이 변경되어도, 외부의 변수의 값은 변경되지 않는다.
* Java, C
* **장점**
  - 복사해 처리하기 때문에 안전하다.
  - 원래의 값이 보존이 된다.
* **단점**
  - 많은 계산이 들어간다면 과부하의 원인이 된다.
  - 메모리 사용량이 늘어난다.

<img src="https://t1.daumcdn.net/cfile/tistory/99438C4D5B3C36FA16"/>

```
비포
안녕잘가
에프터
안녕잘가
```

<br/>

* 참조형 타입은 값의 래퍼런스(주소)가 저장되는 것이므로 그 값의  래퍼런스가 복사 되어진다
  * 즉 값의 래퍼런스가 call by value 방식으로 넘어간다.
  * 하지만 참조 되어지는 값을 바꾸어 주어 마치 **call by reference** 가 이루어진 것 처럼 보인다

<img src="https://t1.daumcdn.net/cfile/tistory/99414F465B3C592104"/>

```
swap() 호출 전 : a = 10, b = 20
swap() 호출 전 : a = 20, b = 10
```

<br/>

### Call by Reference

* **메소드 호출 시 사용되는 인자 값의 메모리에 저장되어있는 주소(Address)를 복사하여 보낸다.**
* 따라서 함수 안에서 인자의 값이 변경되면, 아규먼트로 전달된 객체의 값도 함께 변경된다.
* 메모리 절감
* C++
* 장점
  - 복사하지 않고 직접 참조를 하기에 빠르다.
* 단점
  - 직접 참조를 하기에 원래 값이 영향을 받는다.(리스크)

```c++
void adder(int& x) { // 2) c++에선 int&로 선언된 변수가 레퍼런스 변수이다.
    x = x + 1;
    cout << "value of &x:" << &x << endl;
    cout << "(referenced) value of x :" << x << endl;
    return;
}

int main() {
    int a = 3;
    cout << "Address of a :" << &a << endl;
    cout << "value of a before adder :" << a << endl;
    adder(a); // 1) 나는 a(= 3)을 넘기는 것 같은데
    cout << "value of a after adder:" << a << endl;
}
```

```
4
```

<br/>

------

[참고 자료]

https://wayhome25.github.io/cs/2017/04/11/cs-13/

https://imasoftwareengineer.tistory.com/104
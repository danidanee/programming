# List, Set, Map

> List : 순서가 있는 데이터의 집합으로 데이터의 중복을 허용하며 인덱스로 조회
>
> Set : 순서를 유지하지 않는 데이터의 집합으로 데이터의 중복을 허용하지 않는다.
>
> Map : 키와 벨류값의 쌍으로 이루어진 데이터 집합으로 순서는 유지되지 않으며 키는 중복은 허용하지 않지만 벨류값은 중복을 허용

<br/>

### Collection

* 여러개의 객체를 하나의 유닛으로 다루기 위한 최상위 인터페이스
* 객체 집합을 하나의 객체로 다루는 방법에 따라서 두가지로 나뉜다
  * List 는 객체들이 들어온 순서대로 참조를 유지하기 위한 목적
  * Set 은 중복된 참조를 허용하지 않는 목적
* Collection 인터페이스를 상속받아 List와 Set 인터페이스가 된다. 
* **Collection**은 객체들을 넣고 빼는데 있어서 어떻게 이 객체들을 관리할 것인가를 다루고 있고 **Map**은 키를 통해서 실제 객체에 접근한다.
  * 구조적으로 볼 때 Map 인터페이스는 Collection 인터페이스와 연관이 없다

<br/>

| 인터페이스 | 구현 클래스                                      | 특징                                                         |
| ---------- | ------------------------------------------------ | ------------------------------------------------------------ |
| List       | LinkedList<br/>Stack<br/>Vector<br/>ArrayList    | 순서가 있는 데이터의 집합, 데이터의 중복을 허용함            |
| Set        | HashSet<br/>TreeSet                              | 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않음 |
| Map        | HashMap<br/>TreeMap<br/>HashTable<br/>Properties | 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합순서는 유지되지 않고, 키는 중복을 허용하지 않으며 값의 중복을 허용 |

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FcHhmbr%2FbtqwUDHGMOV%2FusCxTFLWrG0iSkJzqdK8WK%2Fimg.png"/>

<br/>

### List

* 인덱스를 사용해 요소들의 순서를 저장하고, 특정 위치에 요소를 삽입하거나 접근할 수 있다
* 중복을 허용한다.

| 구분           | 특징                                                         |
| -------------- | ------------------------------------------------------------ |
| **ArrayList**  | - 상당히 빠르고 크기를 마음대로 조절할 수 있는 배열<br/>- 단방향 포인터 구조로 자료에 대한 순차적인 접근에 강점이 있음 |
| **Vector**     | - 모든 메소드가 동기화 되어있음                              |
| **LinkedList** | - 양방향 포인터 구조로 데이터의 삽입, 삭제가 빈번할 경우 빠른 성능 보장<br />스택, 큐, 양방향 큐 등을 만들기 위한 용도 |

<br/>

###  Set

* 집합을 정의하며 요소의 중복을 허용하지 않는다.
* 순서를 유지하지 않는 데이터의 집합이다.
* 교집합(And), 합집합(Or), 차집합(Xor) 등을 지원

| 구분              | 특징                                                         |
| ----------------- | ------------------------------------------------------------ |
| **HashSet**       | - 가장 빠른 임의 접근 속도<br />- 순서를 전혀 예측할 수 없음 |
| **LinkedHashSet** | - 추가된 순서, 또는 가장 최근에 접근한 순서대로 접근 가능    |
| **TreeSet**       | - 정렬된 순서대로 보관하며 정렬 방법을 지정할 수 있음        |

<br/>

### Map

* 키와 값의 쌍으로 이루어진 데이터의 집합이다.
* 순서는 유지하지 않고, 키의 중복은 허용하지 않으며 값의 중복은 허용한다.
* 키와 키 값을 대응시키기 위해 사용

  * 키 : Map 에 담기는 객체들을 유일하게 식별할 수 있는 객체를 의미

    * 이는 하나의 Map 내에서 같은 값을 가지는 key 는 존재할 수 없음을 뜻


| 구분              | 특징                                                         |
| ----------------- | ------------------------------------------------------------ |
| **HashMap**       | - Map 인터페이스를 구현하기 위해 해시테이블을 사용한 클래스<br />- 중복을 허용하지 않고 순서를 보장하지 않음<br />- 키와 값으로 null이 허용 |
| **Hashtable**     | - HashMap 보다는 느리지만 동기화가 지원<br />- 키와 값으로 null이 허용되지 않음 |
| **TreeMap**       | - 이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장<br/>- 정렬된 순서로 키/값 쌍을 저장하므로 빠른 검색이 가능<br />- 저장시 정렬(오름 차순)을 하기때문에 저장시간이 다소 오래 걸림 |
| **LinkedHashMap** | - 기본적으로 HashMap을 상속받아 HashMap과 매우 흡사<br />- Map에 있는 엔트리들의 연결 리스트를 유지되므로 입력한 순서대로 반복 가능 |

<br/>

---

[참고 자료]

http://blog.naver.com/PostView.nhn?blogId=dceye&logNo=50037083182

https://hwan1001.tistory.com/10

https://waspro.tistory.com/117

https://hackersstudy.tistory.com/26
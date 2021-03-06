<h1>재귀 (Recursion)</h1>

> 어떤 문제의 해가 크기만 좀 더 작아진 동일한 문제의 해를 필요로 하는 경우에 적용할 수 있는 기법

<br/>

* 관계 중심의 사고를 통해 좀 더 간결하게 문제를 다룰 수 있도록 해주며, 많은 문제를 해결하는 데 적용 가능

<br/>

|                |                  재귀                   |          반복          |
| :------------: | :-------------------------------------: | :--------------------: |
|      종료      | 재귀 함수 호출이 종료되는 베이스 케이스 |   반복문의 종료 조건   |
|   수행 시간    |              (상대적) 느림              |          빠름          |
|  메모리 공간   |           (상대적) 많이 사용            |       적게 사용        |
| 소스 코드 길이 |                짧고 간결                |          길다          |
| 소스 코드 형태 |          선택 구조 (if...else)          | 반복 구조 (for, while) |
|  무한 반복시   |             스택 오버플로우             |  CPU를 반복해서 점유   |

<br/>

재귀 호출 : 함수가 자기 자신을 호출하는 것

재귀 함수 : 위와 같은 일을 하는 함수

<br/><br/>

**재귀 함수의 설계 프로세스**

* 문제를 분석해 재귀적 성질을 찾는다.
* 일반적인 경우와 바닥조건일 때를 정의
* 문제에 따라 다양한 정의가 나올 수 있다.
* 프로그램을 작성하고 테스트

<br/><br/>

------

정올 1161 하노이의 탑
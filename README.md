# TIL

### 문제별 참고할 내용

##### section1


- '+' vs StringBuilder사용 <b>(문자열 결합의 성능 차이)</b>
  - 일단 String 자체가 immutable하기 때문에 문자열 변경이 불가하다.<br>
  +연산자를 사용하면 jdk1.5 이전에는 문자열을 추가할 때마다 새로운 인스턴스를 생성하는 방식이었다.
  <br>이후에는 문자열을 먼저 StringBuilder로 변환시킨 뒤, append로 문자열을 더하고 다시 toString()으로 문자열로 반환해주는 방식으로 변경 되었다.<br>
  간단한 문자열 결합 시에 사용하면 좋을 듯 하다.

  - StringBuilder는 mutable하기 때문에 문자열 결합(append())시에 별도의 메모리 할당없이 수정이 가능하다.
  때문에, 반복문 안에서와 같이 문자열을 계속적으로 추가해야할 때 사용하면 좋을 듯하다.
  
  - 그래서 section1(문자열)과 같은 내용에서 대부분 String보다는 StringBuilder로 문자열을 다룬 경우가 많다.
  
  
- Wrapper클래스의 사용
  - Integer나 Character 클래스를 자주 사용하였다.
  - 특히 최대, 최소 등을 다루기 위해 변수를 선언할 때 Integer 클래스의 상수 중에 Integer.MIN_VALUE을 사용함으로써 편리하였다.
  
- 정규표현식
  - String.replaceAll(regex, replacement)를 사용할 때 있어 regex="[^A-Z]"인 경우에는 ^는 not의 의미를 뜻한다.
  
- 문자열 reverse
  - String을 StringBuilder()로 변경 후에, StringBuilder(String s).reverse()하는 방법이 있다.

- 문자열의 특정 문자 변경
  - StringBuilder.setCharAt() 사용. <b>Ex2 참고</b>
  
- if - else문의 올바른 사용
  - if - else문에서 중복되는 부분은 밖으로 올리고, if 문 하나만 걸어서 추가되는 부분을 적어주면 가독성이 훨씬 올라간다.(<b>Ex11참고</b>)

- 십진수 -> 이진수 변환 <b>(Ex12참고)</b>
  - Integer.toBinaryString(int i)를 사용한다. 반환타입은 String이다.
  
- 이진수 -> 십진수 변환<b>(Ex12참고)</b>
  - Integer.parseInt(String s, int radix)를 사용. radix값에 2를 주면 이진수를 십진수 int로 변환시켜준다.


##### section2


- ArrayList는 객체배열이므로, 데이터로는 객체의 주소가 저장된다.<br>
  즉, ArrayList a = new ArrayList(1);에서 1이라는 int형 값이 저장된 것 같지만 사실은 오토박싱에 의해 new Integer(1)이 들어가게 되는 것이다.

- 소수 구하기
  - 에라토스테네스 체 알고리즘을 사용하는 것이 가장 효과적.
  - 구현하는데 있어 제곱근을 사용하여 반복의 횟수를 줄일 수도 있음.

- ArrayList vs Array
  - ArrayList를 사용하면 mutable하기에 변경에 유리하지만, 속도가 빠른 Array가 적합할 수 있음.
  - 자세한 내용은 블로그 참고하기.

- 정수 자리 변환방법.
  - /와 %을 활용해서 정수 자릿수 관련한 것은 해결해보는 쪽으로 참고하기.(Ex6_2참고)
  - 처음에는 문자열로 변환 후에 reverse()를 사용하기 위해서, StringBuilder로 변환(Ex6) 하였지만 메모리 관리 차원에서는 Ex6_2가 훨씬 나을 것 같음.

##### section3

- 두 배열 합친 후 정렬(Ex1참고)
  - 두 배열을 말 그대로 합치고 난 뒤, 정렬을 하는 알고리즘은 어찌되었든 시간복잡도에서 O(N)이상일 수밖에 없다.
  - 그래서 이러한 경우에는 두 배열에 각각의 포인터변수를 주고, 비교해 나아감으로써 시간복잡도를 O(N)으로 맞춰줄 수 있다.
  - if와 for문을 합친 구문을 하나의 while문으로 고칠 수 있으니, 항상 염두해두고 작성하기.


- 슬라이싱 윈도우 알고리즘(Ex3 참고)
  - for문으로 처리시에 시간복잡도가 제곱이 되는 것을 방지할 수 있다.
  - O(n)으로 처리 가능하게끔 하는 알고리즘. O(n^2)-->O(n)



##### section7
- Ex5: 이진트리순회(DFS구현)
- Ex6: DFS 이용한 부분집합 구하기.
- Ex7: 이진트리순회(BFS 구현)
- Ex8: 송아지 구하기(직접 BFS 구현한 버전)
- Ex8_2: 이 형식으로 풀이하는 것이 효과적.
  - 굳이 Node를 선언하지 않아도 됨.
  - 격자판처럼 인덱스 접근하는 방식 복기.



##### baekjoon
- Ex1654: 더 큰 값을 answer에 저장하는 방식이 아닌,<br> upper bound 처럼 min-1을 출력하는 것이 메모리 면에서나 모든 면에서 훨씬 안정적임.<br> 구체적인 이유 정리 필요.
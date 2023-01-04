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
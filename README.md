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

- if - else문의 올바른 사용
  - if - else문에서 중복되는 부분은 밖으로 올리고, if 문 하나만 걸어서 추가되는 부분을 적어주면 가독성이 훨씬 올라간다.(<b>Ex11참고</b>)

- 십진수 -> 이진수 변환 <b>(Ex12참고)</b>
  - Integer.toBinaryString(int i)를 사용한다. 반환타입은 String이다.
  
- 이진수 -> 십진수 변환<b>(Ex12참고)</b>
  - Integer.parseInt(String s, int radix)를 사용. radix값에 2를 주면 이진수를 십진수 int로 변환시켜준다.

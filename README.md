# Baseball Game (TDD 실습)

## [TDD소개](https://github.com/cleancodeclass/prime-factors/wiki/TDD-%EC%86%8C%EA%B0%9C)

## Baseball Game 실습 소개

### Baseball Game 규칙
* 0~9까지의 숫자 중 임의의 다른 세 자리의 숫자를 불러서, 상대방이 맞추는 게임이다.
  * 사용되는 숫자는 0~9까지의 서로 다른 숫자이다.
  * 숫자는 맞지만 위치가 틀렸을 경우에는 Ball
  * 숫자와 위치가 모두 맞으면 Strike
* Example : question이 "123"일 경우
  * guess(“123”) -> solved=true, strikes=3, balls=0
  * guess(“456”) -> solved=false, strikes=0, balls=0
  * guess(“129”) -> solved=false, strikes=2, balls=0
  * guess(“240”) -> solved=false, strikes=0, balls=1
  * guess(“321”) -> solved=false, strikes=1, balls=2  

## Baseball Game 구현
* 답에 대한 return은 아래 속성을 가진는 객체로 한다. 
  * boolean solved
  * int strikes
  * int balls
* 아래의 경우 예외처리 후 게임을 종료한다.
  * 입력값이 없을 경우
  * 자리수가 세 자리가 아닐 경우
  * 숫자 외의 문자가 입력될 경우
  * 중복된 숫자가 입력될 경우
* 테스트 케이스 예시
  * 입력값이 없을 경우
  * 입력값 자리수가 세자리가 아닐 경우 ("12", "1234")
  * 입력값에 숫자 외의 문자가 입력될 경우 ("A12")
  * 입력값에 중복된 숫자가 입력될 경우 ("112")
  * 숫자 세개가 전부_일치 할 경우 (question : "123", guess : "123")
  * 숫자 세개가 전부 일치 _하지 않을 경우 (question : "123", guess : "456")
  * 스트뭼거만 있을 경우 (question : "123", guess : "178")
  * 보만 있을 경우 (question : "123", guess : "561")
  * 볼과 스트라이큡가 함께 있을 경우 (question : "123", guess : "136")


## 실습방법
1. 가장 쉽게 구현할 수 있는 테스트부터 시작한다.
2. 실패하는 테스트 케이스를 만든다. (Red)
3. 실패하는 테스트 케이스를 성공하도록 최소한의 소스를 수정한다. (Green)
필요하다면 하드코딩 한다.
4. 리팩토링이 필요하다면 수행한다. (Refactoring)
  * 중복을 제거한다. 비슷한 중복을 완전한 중복으로 바꾼다.
  * Extract method, Extract to local variable, Inline local variable….
5. 새로운 실패하는 테스트 케이스를 만든다
6. 1~5 반복을 통해 구체화되는 테스트케이스를 이용하여 일반화되는 소스코드를 작성한다.


## 참고 API
#### String class
* https://docs.oracle.com/javase/8/docs/api/java/lang/String.html

###### public int length()
* https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#length--

###### public char charAt(int index)
* https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#charAt-int-

###### public int indexOf(int ch)
* https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#indexOf-int-


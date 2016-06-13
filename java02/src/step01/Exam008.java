// 주제: 리터럴(값) 표현 - 음수가 메모리에 저장되는 원리
package step01;

public class Exam008 {
  public static void main(String[] args) {
    // 정수 10은 메모리에 전기적 신호로 저장된다.
    // => 즉 2진수로 저장된다고 생각하면 된다.
    // 10 => 00000000_00000000_00000000_00001010
    System.out.println(Integer.toBinaryString(10));

    // +3       => 00000000_00000000_00000000_00000011
    // 1의 보수 => 11111111_11111111_11111111_11111100
    // 2의 보수 => 11111111_11111111_11111111_11111101 (-3)
    System.out.println(Integer.toBinaryString(-3));
    // 결론: 음수를 2의 보수로 표현한다.
    // 이점: 음수를 계산할 때 단지 더하기를 하면 계산을 수행할 수 있다.

  }
}

/*
# 음수를 표현하는 다양한 방법
1) Sign-Magnitude(부호-절대값) 방식
- 부동소수점을 저장할 때 가수부의 수를 저장하는 방식이다.
- 맨 왼쪽 비트가 부호를 나타내는 비트이다.
  0이면 양수, 1이면 음수.
- 예) +24, -24
  +24 ==> (8비트) 00011000
  -24 ==> (8비트) 10011000
- 수의 범위(8비트 기준): -127 ~ +127
0111 1111 (+127)
0111 1110 (+126)
0111 1101 (+125)
...
0000 0010 (+2)
0000 0001 (+1)
0000 0000 (+0)
1000 0000 (-0)
1000 0001 (-1)
1000 0010 (-2)
...
1111 1101 (-125)
1111 1110 (-126)
1111 1111 (-127)
- 특징
  => +0과 -0이 존재한다.
  => 양수와 음수를 더했을 때 옳지 않은 값이 나온다.
     예) 00000011(+3)
      +  10000010(-2)
      ----------------
         10000101(-5)
  => CPU를 설계할 때 양수와 음수를 더하는 회로를 별도로 설계해야 한다.
     즉 하드웨어가 복잡해진다.

2) One's complement(1의 보수) 방식
- 모든 비트를 반대 값으로 바꾼다.
- 예) +24, -24
  +24 => 00011000
  -24 => 11100111
- 수의 범위(8비트 기준): -127 ~ +127
0111 1111 (+127)
0111 1110 (+126)
0111 1101 (+125)
...
0000 0010 (+2)
0000 0001 (+1)
0000 0000 (+0)
1111 1111 (-0)
1111 1110 (-1)
1111 1101 (-2)
...
1000 0010 (-125)
1000 0001 (-126)
1000 0000 (-127)
- 특징
  => 두 개의 0(+0, -0)이 존재한다.
  => 두 수를 더할 때 1 초과한 값이 발생하면 맨 뒤 비트에 초과 값을 더해야만 한다.
  예) 0000 0011(+3)
   +  1111 1101(-2)
   ----------------
    1|0000 0000
              1 (<== 뒤에 초과한 값을 더한다.)
   ----------------
      0000 0001(1)
3) Two's complement(2의 보수) 방식
- 정수에서 음수를 표현할 때 사용하는 방식이다.
- 1의 보수로 음수를 표현하는 방법의 문제점(초과한 비트를 다시 더하는 것)
  을 보강하기 위해 등장함.
- 음수를 표현할 때 1의 보수에 +1을 한다.
- 예) +24, -24
  +24 => 00011000
  -24 => 11100111 + 1 = 11101000
- 수의 범위(8비트 기준): -128 ~ +127
0111 1111 (+127)
0111 1110 (+126)
0111 1101 (+125)
...
0000 0010 (+2)
0000 0001 (+1)
0000 0000 (0)
(음의 0은 없다)
1111 1111 (-1)
1111 1110 (-2)
...
1000 0011 (-125)
1000 0010 (-126)
1000 0001 (-127)
1000 0000 (-128)
- 특징
  => 0은 오직 한 개 뿐이다.
  => 음수 양수 상관없이 더하기를 하면 된다.
  예) 0000 0011(+3)
   +  1111 1110(-2)
   ----------------
    1|0000 0001 (<== 메모리의 크기를 초과하면 초과한 값은 버린다.)


4) Excesss-K(K 초과) 방식
- 부동소수점을 저장할 때 지수부의 수를 저장하는 방식이다.

*/

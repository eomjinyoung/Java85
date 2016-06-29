package step08.ex02;

public class B extends A {
  static int var3;
  
  static void m() {
    // 클래스 변수를 사용하려면 클래스명을 붙여야 한다.
    A.var1 = 100; // OK!

    // 서브 클래스에서는 수퍼 클래스의 스태틱 변수에 접근할 수 있다.
    var1 = 500; // OK! 현재 클래스에서 찾는다 => 수퍼 클래스에서 찾는다. => 계속.. 상위로 간다.
    
    // 메서드가 소속된 클래스의 스태틱 변수는 클래스 이름을 생략할 수 있다.
    B.var3 = 200; //OK
    var3 = 300; // OK
    
    // 스태틱 메서드는 인스턴스 주소 없이 호출하기 때문에
    // this라는 내장 변수가 없다.
    //this.var2 = 20; // 오류!
  }

}












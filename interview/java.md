# Java
## 객체지향(Object Oriented)
실세계의 사물을 추상화하여 멤버 변수와 메서드를 정의하는데서 출발

캡슐화를 통해 이 같은 멤버변수와 메서드의 이용가능 범위를 적절히 제한할 수 있고, 상속을 이용하여 부모 클래스의 기능을 자식클래스에서 물려받거나 재정의를 통해 다른 기능을 구현하는 다형성도 포함

### 객체지향 프로그래밍(Object-Oriented Programming, OOP)
데이터를 객체로 취급하여 프로그램에 반영한 것

- 특징
    1. 다형성
        - 하나의 메서드나 클래스가 다양한 방법으로 동작하는 것
        - 상속을 통해 기능을 확장하거나 변경하는 것이 가능
        - 한 행동을 여러 방법으로 구현하고 상황에 따라 적당한 구현을 선택해서 쓸 수 있도록 하는 기능을 제공
        - 오버로딩(Overloading), 오버라이딩(Overriding)을 통해서 한 개념에 여러 개념을 넣어놓은 것
    1. 상속
        - 어떤 클래스에서 더 특화된 버전의 클래스를 위한 행동을 제공
        - 공통적으로 필요한 것을 부모 클래스로 두고 새로운 클래스가 자식 클래스가 됨으로써 공통을 물려 받고 더 나아가 거기에서 확장하는 것
    1. 캡슐화
        - 객체가 맡은 역할을 수행하기 위한 하나의 목적을 위해 데이터와 기능을 묶은 것
        - 중요한 데이터나 기능을 외부에서 접근하지 못하도록 함
    1. 추상화
        - 객체들의 공통 데이터와 기능을 도출하는 것을 말함
- SOLID Principal
    1. SRP(Single Responsibility Principal): 단일 책임 원칙
        - 작성된 클래스는 하나의 기능만 가지며 클래스가 제공하는 모든 서비스는 그 하나의 책임을 수행하는데 집중되어야 함
    1. OCP(Open Closed Principal): 개방 폐쇄 원칙
        - 확장에는 열려있고, 변경에는 닫혀 있어야 함
        - 요구사항의 추가/변경 사항이 있더라도 기존 구성요소의 수정이 일어나서는 안되고, 기존 구성요소의 쉽게 확장해서 재사용 가능해야 함
    1. LSP(Liskov Substitution Principal): 리스코프 치환 법칙
        - 서브 타입은 상위 타입으로 교체가 될 수 있어야 한다
        - 쉽게 생각해서 상속관계에서 부모 A와 자식 B가 있을 때, 자식 B는 언제라도 부모 A이 될 수 있어야 한다는 것
    1. ISP(Interface Segregation Principal): 인터페이스 분리 법칙
        - 자신이 사용하지 않는 인터페이스는 구현하지 말아야 함
        - SRP의 인터페이스 관점
    1. DIP(Dependency Inversion Principal): 의존성 역전 원칙
        - 구현체보다는 추상체에 의존
        - 즉 인터페이스 A가 있고 그것을 상속받아 구현한 B, C가 있을 때 사용하는 쪽은 인터페이스 A를 사용해야지 B, C 를 사용하면 안된다는 것

## 특징
1. 운영체제에 독립적(JVM으로 인해)
1. 1개 이상의 클래스로 구성
1. `public static void main(String[] args)`이 엔트리 포인트
1. GC를 통한 메모리 관리

## 실행과정(Hotspot 기준)
1. `.java`를 `.class`로 `javac`를 이용해 컴파일
1. ClassLoader를 통해 JVM에 Class 로드(`.class`)
1. Execution Engine을 통해서 로드한 Class 해석
    - Interpreter 모드로 실행하면서 Application을 모니터링하다가 가장 자주 사용되는 코드를 발견하면 JIT 실행 
1. 해석한 바이트코드를 Runtime Data Area에 배치
1. 실질적인 수행

## Pass-by-value
Primitive type일 경우 값을 그대로 복사해서 전달하며 Reference type일 경우 객체 주소값을 복사해서 전달

## JVM(Java Virtual Machine)
Java를 OS 독립적으로 실행시켜주는 머신으로, 실제 Java뿐만 아니라 Scala, Kotlin을 비롯하여 다양한 언어들이 JVM 위에서 실행될 수 있다.

JVM은 메모리 관리부터 시작하여 GC도 수행하며, 스택 기반의 가상머신이다.

1. ClassLoader
1. Execution Engine
1. Runtime Data Area

로 구성되어 있다.

### ClassLoader
JVM으로  클래스(`.class` 파일)를 로드하고 링크를 통해 작업을 수행하는 모듈로 Runtime에 동적으로 클래스를 로드한다.

클래스 로더는

1. Bootstrap ClassLoader
    - Runtime Core Class 로드(`rt.jar` 같은. Java 9 이후로는 다름)
    - 최소한의 필수 클래스를 로드(`java.lang.Object`, `Class`, `ClassLoader` 등)
1. Extension ClassLoader
    - Bootstrap ClassLoader를 부모로 설정하고 필요할 때 ClassLoading을 Bootstrap ClassLoader에게 넘김(주로 ClassLoading에 실패했을 때)
    - 특정 OS나 플랫폼에 Native Code를 제공하고 기본환경을 overriding 할 수 있음
    - Security Extension Function 같은 다양한 확장 클래스들을 로드함(`$JAVA_HOME/jre/lib/ext`)
1. Application ClassLoader
    - Extension ClassLoader을 부모로 설정하고 필요할 때 ClassLoading을 Extension ClassLoader에게 넘김
    - 지정된 class path에 위치한 User Class를 로드함

가 있다.

**Bootstrap ClassLoader** -> **Extension ClassLoader** -> **Application ClassLoader** 순으로 실행된다.

만약 **Application ClassLoader**가 로드에 실패했을 때는 역순으로 실행하며 그래도 실패할 경우 `ClassNotFoundException`이 발생함

Class는 FQCN(Fully Qualified Class Name)과 자신을 로드한 ClassLoader 두 가지 정보로 식별됨

### Excution Engine
- Interpreter
- JIT(Just-In-Time) Compiler
    - Interpreter 단계에서 수집한 추적 정보를 근거로 최적화를 결정
    - 코드를 최적화 한 것을 캐시하여 다시 최적화를 하지 않고 빠르게 사용할 수 있게 캐시를 사용함
- GC(Garbage Collection)
    - Daemon Thread로 실행되며 백그라운드에서 항상 실행되는 메모리 관리 프로그램

### Runtime Data Area
- Stack
    - Method 내에서 사용되는 값들이 저장되며, method가 호출될 때 LIFO로 하나씩 생성되고 실행이 완료되면 LIFO로 하나씩 지워짐
    - Thread마다 생성
- PC Register
    - Thread가 어떤 부분을 어떤 명령어로 실행해야 할 지 기록 하는 부분으로 JVM 명령 주소를 가짐
    - Thread마다 생성
- Native Method Stack
    - 다른 언어(C, C++ 등)의 method 호출을 위해 할당되는 구역
    - Thread마다 생성
- Method
    - Class, Variable, Method, Static variable, constant variable 등이 저장되는 영역
- Heap
    - `new` 명령을 통해 생성된 Instance와 object가 저장(배열로 저장됨, `new`를 통해 생성시키기 때문)
    - GC가 동작하는 영역

#### Heap Area
Heap 영역은 GC가 동작하는 부분이며 동적으로 여러 객체들이 할당되는 영역

Heap은 크게
- Young Generation: 새로 생성되거나 생성되지 얼마 되지 않은 객체들이 저장되는 곳
    - Young Generation은 또 크게 2가지 영역으로 나누어진다
        - Eden: 새로 생성된 객체들이 있는 공간
        - Survivor(0, 1): 어느정도 살아남은 객체들이 존재하는 공간
            - Survivor 0이 꽉차게 되면 Survivor 1으로 이동시킴
- Old Generation: 일정 기준 이상으로 참조되고 있어 살아있다고 판단된 객체들이 저장되는 곳

으로 나누어진다

### GC(Garbage Collection)
- Runtime Data Area의 Heap 영역에서 더 이상 사용되지 않는 객체들을 정리함
- Daemon Thread로 실행되어 background에서 실행됨
- 분류
    1. Minor GC: Young Generation에서 발생하는 GC
    1. Major GC: Old Generation에서 발생하는 GC
    1. Full GC: Young, Old 모두에서 발생하는 GC
- STW(Stop The World)
    - GC가 발생할 때 모든 Thread들이 동작이 멈추는 것을 말함
- Card Table
    - Old Generation에 있는 객체가 New Generation을 참조하는 정보를 기록하는 자료구조

#### Mark and Sweep
할당됐지만 아직 회수되지 않은 객체들을 가르키는 포인터를 가지고 있는 할당 리스트를 사용
1. 할당 리스트를 순회하면서 mark bit를 지움(DFS)
1. GC Root로부터 살아있는 객체를 찾음
1. 할당리스트를 순회하면서 mark bit가 셋팅되지 않은 객체를 찾아서 메모리 해체

#### GC Root
메모리의 고정점(Anchor point)으로, 메모리 풀 외부에서 내부를 가리키는 포인터로 외부포인터

메모리 풀 내부에서 같은 메모리 풀 내부의 다른 메모리 위치를 가르키는 내부포인터와는 반대

#### Minor GC
Young Generation에서 발생하는 GC를 Minor GC라고 함

Young Generation은 Eden, Survivor으로 나뉘어져 있다고 했는데 아래와 같이 동작한다.

1. Eden 영역에서 Mark And Sweep을 해서 더 이상 참조되지 않는 객체를 삭제함
1. 1을 반복하여 일정 기준치 이상 사용되어 살아남은 객체를 Survivor로 보냄
1. 살아남은 객체들에게 generation이 지나고 살아남았음을 표시한다.(Age bit)

#### Major GC
Old Generation에서 발생하는 GC를 Major GC라고 함

이전의 Major GC에서 살아남아 Age bit가 일정 기준치를 넘어 살아남은 객체나 Young Generation이 감당할 수 없을 정도 크기의 객체의 경우

Old Generation으로 옮긴다.

#### Full GC
만약 Old Generation도 객체로 꽉 찼다면 Full GC를 실행해 양 generation을 모두 GC를 실행한다.

### Type of References
1. Strong Reference
    - 기존 참조 유형으로 GC의 대상이 되지 않음(물론 살아있는 객체가 아니면 대상이 되어 제거가 됨. 할당 당시를 말하는 것)
    - `AClass a = new AClass();`
1. Weak Reference
    - GC의 대상이 되어 힙에서 제거됨
    - `WeakReference<AClass> weakA = new WeakReference(a);`
1. Soft Reference
    - GC의 대상이 되나 메모리가 부족하지 않으면 제거되지 않음
    - `SoftReference<AClass> softA = new SoftReference(a);`
1. Phantom Reference

## Sort
- `java.util.Arrays.sort`
    - primitive type: two pivot quick sort
    - reference type: Time sort(merge sort + insertion sort)

## Collection
- HashMap
    - java 7 ~ : bucket이 6개 이하면 LinkedIn, 8개 이상이면 RedBlackTree
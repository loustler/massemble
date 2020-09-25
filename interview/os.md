# OS

## Process
- 현재 실행중인 Computer Program의 Instance
- OS에 의해서 관리가 되고 OS가 Processor에 할당해주면 Processor가 Computer Program을 실행
- 1개 이상의 Thread를 가짐
- 각 process는 고유한 system resource를 OS로부터 할당받고 서로의 resource에 접근할 수 없음
- 다른 프로세스의 자원에 접근하려면 IPC를 이용해야 함
   - 파이프(Pipe): producer-consumer 형태. FIFS 형태의 큐. 지명파이프(named pipe)와 익명 파이프(anonymous pipe)가 있음
   - 파일(File)
   - 소켓(Socket)
   - 메시지 큐(Message Queue)

## Thread
- Process의 구성요소로 OS Scheduler에 의해 독립적으로 관리될 수 있는 가장 작은 단위의 프로그래밍 명령 시퀀스
- Process와 달리 같은 Process에 있는 Thread들은 서로 같은 리소스를 공유하며 접근할 수 있음(Stack 제외)

### User Thread, Kernel Thread
- User Thread
   - 사용자 영역의 Thread로 Kernel이 이 Thread의 존재를 알지 못함
   - Kernel 위에서 지원
   - N개의 User Thread가 1개의 Kernel Thread에 매핑되어 다대일 Thread Mapping이라고 함
   - Pros
       1. 이식성이 높음: Kernel에 독립적으로 스케줄링하므로 모든 운영체제에 적용가능
       1. 오버헤드가 적음: Scheduling이나 Sync를 위해 Kernel을 호출하지 않으므로 Kernel 으로 전환하는 오버헤드가 줄어듦
       1. 유연한 스케줄링: Kernel이 아닌 Library에서 Thread Scheduling을 제어하므로 응용 프로그램에 맞게 Scheduling
   - Cons
       1. Kernel Thread와 M : 1 mapping으로 병렬, 동시성 X
       1. 확장의 제약
       1. Thread 간 보호 불가능
- Kernel Thread
   - OS(Kernel)가 직접 지원되고 관리
   - User Thread의 한계를 극복
   - User Thread와 Kernel Thread가 1:1로 mapping되어 User Thread를 생성하면 Kernel Thread를 생성
   - Pros
       1. 동시성, 병렬성 O
       1. 프로세스의 Thread를 몇몇 프로세서에 한꺼번에 디스패치 할 수 있어 멀티프로세서 환경에서 매우 빠르게 동작
       1. Kernel이 Thread를 관리하고 제공해주므로 안전성과 다양한 기능이 제공됨
   - Cons
       1. Kernel로 전환하는 오버헤드 발생

## MultiThread
- Pros
   1. Multi Process에 비해 적은 Context Switching 비용
   1. Process는 서로 IPC 등을 통해 통신해야 하므로 같은 리소스를 공유하는 Thread에 비해 커뮤니케이션 비용이 더 큼
- Cons
   1. 공유 자원(Heap)에 접근할 때 동기화가 필요
   1. DeadLock이 발생할 수 있음

## Context Switching
- Process 상태를 변경하는 것
   - 프로세스 A가 CPU를 사용중일 때 프로세스 B가 CPU를 사용하게 하기 위해 프로세스 A의 상태를 보관하고 프로세스 B의 상태를 적재하는 작업
- Scheduling에 의해 실행 중인 코드, 자원 등을 저장하고 현재 상태를 대기 상태로 만든 다음 다른 프로세스를 실행시키는 과정

## Synchronous, Asynchronous, Blocking, Non-Blocking
1. Synchronous
1. Asynchronous
1. Blocking
1. Non-Blocking

Blocking <-> Non-Blocking은 말 그대로 함수를 호출하고 난 다음에 block이 되느냐 되지 않느냐 즉 함수가 바로 리턴되느냐의 차이다.

Synchronous <-> Asynchronous 쉽게 Callback의 유/무에 나뉜다고 생각하면 됨

Callback을 이용하면 callback이 불려졌을 때 실행될 코드만 주고 나면 신경쓰지 않고 다른 작업을 이어서 할 수 있음

보통 Non-Blocking - Asynchronous 를 같이 사용하는게 익숙하고 Blocking - Synchronous 를 같이 사용하는게 익숙하다.

## 자원 동기화 문제 해결
1. 뮤텍스(Mutex)
   - 프로세스가 공유자원을 사용하고 있을 때 다른 공유자원이 접근하지 못하게 함
   - 1개의 Key를 가지고 한 번에 1개의 프로세스만 접근할 수 있게 함
   - Key를 가지고 있지 않은 프로세스는 키를 얻을 때 까지 대기해야 됨
   - 조건
        1. 두 프로세스는 동시에 공유 자원에 진입할 수 없음
        1. 프로세스의 속도나 수에 영향 X
        1. 공유자원을 사용하는 프로세스만 다른 프로세스를 차단 가능
        1. 프로세스가 공유 자원을 사용하려고 하면 너무 오래기다려선 안됨
1. 세마포어(Semaphore)
    - Atomic 연산인 `wait()`와 `signal()`로 접근이 가능
    - 세마포어 정수값 `S`를 이용
    - 카운팅 세마포어
        - 사용가능한 자원의 개수의 값으로 `S`가 초기화 됨
        - `wait()`는 세마포어값을 감소, `signal()`은 세마포어값을 증가시킴
        - `wait()`은 자원에 접근하려고 할 때, `signal()`은 자원을 방출할 때
    - 이진 세마포어
        - 0 과 1의 값만 가능
        - `S`가 1로 초기화됨
    - 바쁜 대기(busy wating)을 요구(계속 대기하면서 자원 접근 요청)
    - 대기큐를 가진 세마포어를 구현할 때 deadlock이 발생할 수 있음
1. 모니터(Monitor)
   - Semaphore에서 발생할 수 있는 타이밍 문제를 해결하고자 함(재현이 쉽지 않음)
   - 프로세스들이 모니터의 프로시저를 호출하여 모니터안에 진입하여 데이터에 접근함
   - 다른 프로세스가 이미 모니터안에 진입했다면 외부 준비 큐에서 대기해야 됨
   - `condition`을 제공
        - 조건이 맞지 않는다면 `wait()`를 호출하여 실행 중이던 프로세스 A가 내부 준비큐로 들어가게 되고, 새로운 프로세스 B가 모니터 안으로 들어옴
        - 프로세스 B가 `signal()`을 호출하면 준비 큐애서 중단되어 대기 중이던 프로세스 A가 들어와 작업을 재개
   - Java가 사용함
        - `Object#wait()`: 모니터 내부의 WaitSet에 들어가 중단된 상태로 대기
        - `Object#notify()`, `Object#notifyAll()`: 모니터 내부에 있는 WaitSet에 있는 프로세스 중 하나를 실행상태로 만듦
        - 외부 준비큐: Entry Set
        - 모니터 내부 대기큐: Wait Set

### 뮤텍스(Mutex) vs 세마포(Semaphore)
||Mutex|Semaphore|
|---|---|---|
|매커니즘|잠금 매커니즘|시그널링 매커니즘|
|값|Object|정수 변수|
|접근|여러 프로세스가 단일 리소스에 액세스할 수 있지만 동시에 수행 불가|여러 프로세스가 여러 유한한 자원에 액세스 가능|
|값의 변경|Lock은 획득한 프로세스에 의해서만 해제|자원을 얻거나 해제하는 프로세스에 의해 변경|
|분류|X|카운팅, 이진|
|자원이 모두 사용중일 때 접근|Lock이 걸려있으면 Lock의 소유 프로세스가 해제할 때까지 다른 프로세스들은 대기(busy wating)|모든 리소스가 사용중이면 리소스를 요청하는 프로세스는 `wait()` 작업 수행. 유한한 자원이 발생했을 때 접근|

## 메모리
### 내부 단편화, 외부 단편화
1. 내부 단편화
   - 교체된 페이지의 크기가 할당된 공간의 크기보다 작은 경우 발생
   - 저장 공간의 낭비
1. 외부 단편화
   - 메모리가 할당되고 해체될 때 발생하는 작은 공간이 생기게 되는데, 총 공간은 충분하지만 교체된 페이지의 크기가 할당된 공간의 크기보다 클 때 발생
   - 공간 중 일부가 사용 못하게 되는 상황
   - 중간 중간에 비는 공간으로 인해 공간을 할당할 수 있음에도 할당하지 못하는 현상

### 단편화 해결기법
1. 페이징(Paging)
   - 페이지가 연속적인 물리 메모리 공간에 들어가야하는 제약을 해결하기 위한 방법
   - 가상 메모리는 Page, 물리 메모리는 Frame라는 고정형태의 블록으로 나눠서 Page Table과 매핑을 통해 바인딩함
   - 외부 단편화를 해결할 수 있으며, 사이즈를 작게하면 내부 단편화도 해결할 수 있으나 page mapping 과정이 증가함(trade-off)
   - Frame과 Page 모두를 관리하기 위해 Frame Table, Paging Table이 존재하며 OS가 각 프로세스마다 할당함
1. 세그먼테이션(Segmentation)
   - 서로 다른 크기의 블록으로 나누는 방법(동적)
   - 내부 단편화 해결 가능, 외부 단편화는 존재(기존에 사용하던 메모리를 해제하면 생길 수 있음)

### 가상 메모리
1. 가상 메모리(Virtual Memory)
   - 프로그램 실행에 필요한 메모리 전체를 RAM에서 할당받는 것이 아니라 최소한의 메모리만 RAM에서 할당받고 나머지는 디스크에 공간을 만들어 저장
   - 프로세스 전체가 메모리 내에 올라오지 않더라도 실행이 가능하도록 하는 기법 - 메모리 관리 기법
1. 페이지 폴트(Page Fault)
   - 가상 메모리를 사용할 때 물리 메모리인 RAM과 가상 메모리인 DISK에 나누어서 저장하는데, 이 때 필요로 하는 페이지가 물리 메모리에 없을 때를 일컫음
   - 즉 가상 메모리 공간에는 존재하지만 실제 메모리인 RAM에는 해당 데이터나 코드 등이 없는데 접근할 때 발생하는 현상으로 가상 메모리에는 데이터가 있지만 실제 메모리에는 없는 현상을 말함
1. 요구 페이징(Demand Paging)
   - 페이지 폴트가 발생하면 OS가 가상 메모리에서 해당 페이지를 찾아서 물리 메모리의 불필요 페이지와 교체를 요구함
   - Step
      1. OS가 CPU의 동작을 잠시 멈춤
      1. OS가 Page Table을 확인하여 가상 메모리에 페이지가 존재하는지 확인하고 없으면 프로세스 중단
      1. 물리 메모리가 비어 있는 Frame이 있는지 확인하여 있다면 해당 Page를 로드하고 Page Table을 업데이트
      1. 만약 비어 있는 Frame이 없다면 페이지 교체 알고리즘을 이용하여 Page를 로드하고 Page Table 업데이트
      1. 중단되었던 CPU를 다시 시작


### 페이지 교체 알고리즘(Page Replacement Alogirhtm)
1. FIFO(First In First Out)
   - 가장 오래된 페이지를 교체
1. LRU(Least Recently Used)
   - 가장 오랫동안 사용하지 않은 것을 교체
1. LFU(Least Frequently Used)
   - 가장 사용 빈도가 적은 것을 교체
   - 교체 대상이 여러 개일경우 LRU를 사용
1. MFU(Most Frequently Used)
   - 가장 사용 빈도가 많은 것을 교체

## 기아(Starvation)
프로세스의 우선순위가 낮아서 자원을 계속 할당받지 못하는 상태

자원 관리의 문제로 이 상태에서 대기 중인 프로세스는 리소스가 다른 프로세스에 할당되어 있기 때문에 오랫동안 리소스를 할당 받지 못함

## Aging
자원 스케줄링 시스템에서 기아를 방지 하기 위해 사용되는 기술

특정 프로세스의 우선순위가 낮아 무한정 기다리게 될 때, 한 번 양보하거나 기다린 시간에 비례하여 일정 시간이 지나면 우선순위를 한 단계씩 높여서 가까운 시간에 자원을 할당받도록 하는 기법

## Process Scheduling
한정된 자원에서 여러개의 프로세스가 있을 때, 자원을 어떻게 할당할건지 정책

### CPU Scheduling
CPU 1개는 N개의 프로세스를 처리할 수 없으므로, 어떤 순간에 어떤 프로세스가 CPU를 사용할 수 있게 할 건지 결정하는 정책

발생조건은
1. 실행상태에서 대기상태로 전환될 때 - Non preemptive(비선점)
1. 실행상태에서 준비상태로 전환할 때 - Preemptive(선점)
1. 대기상태에서 준비상태로 전환할 때
1. 종료될 때 Terminated

#### Non-preemptive, Preemptive
- Non-preemptive
   - 이미 할당된 CPU를 다른 프로세스가 강제로 빼앗아 사용할 수 없는 스케줄링 기법
   - 프로세스가 CPU를 할당받으면 완료할 때까지 CPU를 계속 사용함
   - 일괄 처리 방식의 스케줄링
   - 종류
      1. **FCFS(First Come First Served)**: FIFO
         - Pros
            - 도착 순서에 따라 공평
         - Cons
            - 평균 응답시간이 길다
      1. **SJF(Shortest Job First)**: 실행시간이 가장 짧은 프로세스에 먼저 할당
         - Pros
            - 평균 응답시간을 최소화
         - Cons
            -  실행시간이 긴 프로세스는 CPU를 할당받지 못하는 문제가 생길 수 있음(Starvation, 기아)
      1. **HRN(Highest Response ratio)**: 우선순위를 계산하여 높은 순서로 CPU 할당. 우선순위 = `대기시간 + 서비스시간 / 서비스시간`
      1. Deadline: 프로세스에게 실행할 수 있는 시간을 주고 그 시간 안에 완료하게끔 하는 기법
      1. Priority: 준비상태 큐에서 기다리는 프로세스에게 우선순위를 부여하여 우선순위가 높은 순서로 CPU를 할당
- Preemptive
   - 하나의 프로세스가 CPU를 할당받아 사용하고 있을 때 우선순위가 높은 프로세스가 CPU를 강제로 빼앗아 사용할 수 있는 스케줄링 기법
   - 선점으로 인한 많은 오버헤드 발생
   - 시분할 시스템에서 사용
   - 선점을 위해 시간 배당을 위한 인터럽트(Interrupt)용 타이밍 클락(timing clock)이 필요
   - 종류
      1. SRT(Shortest Remaining Time): 현재 실행 중인 프로세스의 남은 시간과 대기 큐에 있는 프로세스의 실행시간 중 가장 짧은 프로세스에게 CPU 할당
         - Cons
            1. 잦은 선점으로 인한 Context Switching 부담
            1. Starvation
      1. 선점 우선순위: 준비상태 큐의 프로세스 중 우선순위가 가장 높은 프로세스에게 할당
      1. **RR(Round Robin)**: FCFS 알고리즘을 선점 형태로 변형한 기법. 먼저 대기한 작업이 먼저 CPU를 할당받음
         - Cons
            1. CPU를 사용할 수 있는 동안 사용하고 나서 다시 대기 큐의 끝으로 배치되고 할당되는 시간이 크면 FCFS와 같아지고, 작으면 Context Switching 과 오버헤드가 자주 발생
      1. **MLQ(Multi Level Queue)**: 프로세스를 특정 그룹으로 분류할 수 있는 경우 그룹에 따라 다른 준비 큐를 사용하며 큐마다 독자적인 scheduling을 가짐. 큐 사이에 우선순위가 매겨지며 우선순위가 높은 큐에 할당된 프로세스가 먼저 처리 됨. 단 프로세스는 다른 큐로 이동할 수 없음.
      1. **MLFQ(Multi Level Feed-back Queue)**
         - MLQ에서 서로 다른 큐로 이동할 수 있게끔 개선한 기법. 새로운 프로세스는 높은 우선순위의 큐로 할당되며 실행시간이 길어질수록 하위순위의 우선순위 큐로 이동함.
         - 제일 마지막 단게에서는 RR/FCFS를 이용하여 처리
         - 우선순위가 높은 큐일수록 시간 할당량을 적게 설정함
         - Aging 방법 중 하나로 Starvation을 예방.
         - RR과 함께 가장 많이 사용되는 기법
      1. RM(Rate Monotonic): 수행 주기가 가장 짧은 프로세스에 가장 높은 우선순위를 부여하는 실시간 Scheduling 알고리즘.
         - Pros
            - 간단하며 사용률이 0.69 이하일 때 항상 Scheduling 가능
         - Cons
            - 주기가 긴 Task들의 우선순위가 낮아져서 장시간 대기
      1. EDF(Earliest Deadline First): 프로세스의 마감시한이 가까울수록 우선순위를 높게 부여하는 기법
         - Pros
            - 이론적으로 총 이용률이 1 이하면 Scheduling 가능
         - Cons
            - Task들의 수행시간, 마감시간, 주기 등을 정확히 예측하는 것이 어려움
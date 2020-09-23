# OS

## Process
- 현재 실행중인 Computer Program의 Instance
- OS에 의해서 관리가 되고 OS가 Processor에 할당해주면 Processor가 Computer Program을 실행
- 1개 이상의 Thread를 가짐
- 각 process는 고유한 system resource를 OS로부터 할당받고 서로의 resource에 접근할 수 없음

## Thread
- Process의 구성요소로 OS Scheduler에 의해 도긻적으로 관리될 수 있는 가장 작은 단위의 프로그래밍 명령 시퀀스
- Process와 달리 같은 Process에 있는 Thread들은 서로 같은 리소스를 공유하며 접근할 수 있음(Stack 제외)

## MultiThread의 장점
1. Multi Process에 비해 적은 Context Switching 비용
1. Process는 서로 IPC 등을 통해 통신해야 하므로 같은 리소스를 공유하는 Thread에 비해 커뮤니케이션 비용이 더 큼

## Synchronous, Asynchronous, Blocking, Non-Blocking
1. Synchronous
1. Asynchronous
1. Blocking
1. Non-Blocking

Blocking <-> Non-Blocking은 말 그대로 함수를 호출하고 난 다음에 block이 되느냐 되지 않느냐 즉 함수가 바로 리턴되느냐의 차이다.

Synchronous <-> Asynchronous 쉽게 Callback의 유/무에 나뉜다고 생각하면 됨

Callback을 이용하면 callback이 불려졌을 때 실행될 코드만 주고 나면 신경쓰지 않고 다른 작업을 이어서 할 수 있음

보통 Non-Blocking - Asynchronous 를 같이 사용하는게 익숙하고 Blocking - Synchronous 를 같이 사용하는게 익숙하다.
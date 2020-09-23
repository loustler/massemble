# 인터뷰 준비 정리
1. [DataStructure]
1. [Algorithm]
1. [Network]
1. [OS]
1. [Java]

# Data structure

# Algorithm

# Network
## OSI 7 layer
1. 물리(Physical)
   - 전기적, 기계적 특성을 이용하여 통신 케이블로 전기적 신호 전송
   - 전선, 전파, 광섬유 등이 있음
   - 전송단위: bit
   - 리피터, 허브, 케이블
   - 신호로 변환하여 전송하는 계층
1. 데이터 링크(Data Link)
   - 물리적인 연결을 통해 인접한 두 장치간의 신뢰성 있는 정보 전송
   - Ethernet 등 프로토콜이 속함
   - 전송단위: Frame
   - 물리적 매체에 패킷 데이터를 실어보내는 계층 - 환경에 맞는 다양한 통신 프로토콜 지원
1. 네트워크(network)
   - 호스트에서 호스트로 Datagram을 라우팅하는 책임
   - IP 등 프로토콜이 속함
   - 데이터를 목적지까지 가장 안전하고 빠르게 전달
   - 전송단위: Packet
   - 라우터, L3 스위치
   - 네트워크를 논리적으로 구분하고 연결하는 계층 - 논리적 주소를 사용
1. 트랜스포트(Transport)
   - 클라이언트와 서버간에 애플리케이션 계층 메시지를 전송하는 서비스 제공
   - TCP, UDP 등 프로토콜이 속함
   - 종단 간의 에러 복구와 흐름 제어 담당
   - 전송단위: Segment
   - L4 스위치
   - 서비스를 구분하고 데이터의 전송방식을 담당하는 계층
1. 세션(Session)
   - 세션과 관련된 계층
   - TLS, SSL 등 프로토콜이 속함
   - 연결 세션에서 데이터 교환, 에러 발생시 복구관리를 함(논리적 연결 담당)
   - NetBIOS, SSH 등
   - 전송단위: Message
   - 응용 프로그램 간의 연결을 지원하는 계층
1. 프레젠테이션(Presentation)
   - Application 계층의 데이터 표현에서 독립적인 부분
   - XDR, ANS.1, SMB 등 프로토콜이 속함
   - 전송단위: Message
   - 데이터의 변환작업을 하는 계층(암/복호화 등)
1. 애플리케이션(Application)
   - 네트워크 애플리케이션과 애플리케이션 계층 프로토콜이 있는 곳
   - HTTP, SMTP, FTP, SSH, telnet 등 프로토콜이 속함
   - 전송단위: Message
   - User Interface를 제공하는 계층
   - Network Software UI, User I/O가 속함

### 전송단위
1. Frame
1. Datagram
1. Segment
1. Message

데이터를 전송할 때, 레이어를 내려가면서 각 레이어에서 데이터를 캡슐화하며 헤더를 붙여서 내려간다.

데이터를 수신할 때, 레이어를 올라가면서 역으로 한다.

## Socket
호스트의 OSI Application Layer와 Transport Layer간의 interface

## 웹 브라우저에 URL을 입력했을 때
1. URL 해석 및 요청(Puhnycode encoding을 url host에 적용)
1. HSTS(Http Strict Transport Security) 목록을 로드해서 HTTPS만 사용해야 되는지 확인
1. DNS(Domain Name Server) 조회
   - 브라우저의 경우 브라우저 캐시 확인
   - hosts 파일 확인
   - 위가 모두 실패시 Network stack의 DNS로 요청(보통 ISP의 DNS, 설정된 DNS server)
1. ARP(Address Resolution Protocol)로 대상의 IP와 Mac Address 확인
1. 대상에게 TCP 통신을 통해 Socket open
1. HTTPS일 경우 TLS handshake 추가
1. HTTP 프로토콜로 요청
1. HTTP 응답

## HSTS
브라우저가 웹사이트로 접속할 때, HTTP 대신 HTTPS로 접근해야 된다는 것을 알리는 보안 기능

## ARP
해당 IP를 이용하여 알맞는 MAC Address로 매칭시켜주는 프로토콜

LAN에서 단말과 단말간 통신을 위해서 MAC Address를 이용하는데, 그 때 목적지에 제대로 찾아가기 위함

## MAC Address
OSI 7 layer 중 2번째 Data link layer에서 통신을 위한 network interface에 할당된 고유 식별자

NIC(Network Interface Card)를 가진 단말이라면 공장에서 출고될 때부터 부여되어 평생 사용하게 되는 unique address

## TCP(Transmission Control Protocol), UDP(User Datagram Protocol)
### TCP
1. 연결지향형(전이중)
   - 연결할 때는 3-handshake(SYNC -> SYNC/ACK -> ACK), 연결을 끊을 때는 4-handshake(FIN -> ACK -> FIN -> ACK)
1. 신뢰성 보장
1. 혼합제어
   - 데이터를 송신하는 쪽과 수신하는 쪽의 데이터 처리속도를 조절하여 수신자의 버퍼 오버플로우를 방지

### UDP

1. 비연결형 서비스
1. 메시지가 수신 소켓에 도착하는 걸 보장하지 않음
1. 혼잡제어 방식 X

## DNS(Domain Name System)
HOST의 도메인 이름을 HOST nemtwork address와 매칭시키기 위한 것.

전화번호부를 떠올리면 됨

## HTTPS
소켓 통신에서 일반 텍스트 대신 SSL이나 TLS 프로토콜을 이용해 세션 데이터를 암호화

HTTP + TLS/SSL 을 이용

SSL Handshake

### SSL 인증서를 이용하여 데이터 암/복호화
1. 서버가 공개키/비밀키 생성 후 인증기관에 공개키를 전달
1. 인증기관이 전달받은 공개키를 암호화할 인증기관의 공개키/비밀키를 만들어 암호화해서 인증서를 만들어 서버에 전달
1. 브라우저를 통해 접속을 하려고 하면 인증기관의 공개키를 이용해 인증서를 복호화해서 확인 및 서버 공개키 확보
1. 브라우저가 대칭키를 생성하여 서버 공개키로 암호화한 후 서버에 전달
1. 서버와 브라우저는 수신한 대칭키를 이용해서 데이터를 암/복호화하여 통신

### SSL Handshake
1. TCP 3-handshake
1. ClientHello
   - Client가 SSL 연결 시도를 위해 전송하는 패킷
   - Client가 사용가능한 Cipher Suite, Session ID, SSL version 등 전달
1. ServerHello
   - ClientHello를 처리하고 나서 Cipher Suite를 선택하여 알리는 패킷
1. Certificate
   - 서버가 SSL 인증서를 Client에게 전달
   - 이 때 클라이언트가 SSL 인증서를 전달받고 인증서를 확인함
1. Server Key Exchange / ServerHello Done
   - 서버 공개키가 SSL 인증서에 없다면 서버가 공개키 전달하는 과정 - Server Key Exchange
   - 서버 공개키가 SSL 인증서에 있다면 Server Key Exchange 생략
1. Client Key Exchange
   - Client가 생성한 대칭키를 교환하는 과정(키 자체 교환이 아니라 키를 만드는데 필요한 것들을 교환)
1. ChangeCipherSpec / Finished
   - 정보 교환 후 마치는 패킷

### Cipher Suite
SSL/TLS 프로토콜과 키 교환방식, 인증서 검증 방법, 대칭키를 이용한 블록 암호화 방식, 블록 암호 운용방식, 메시지 인증 으로 이루어져 있음

즉 암호화 협상(SSL handshake)을 위한 알고리즘으로 무엇을 쓸지 모아둔 것


# OS

# Java
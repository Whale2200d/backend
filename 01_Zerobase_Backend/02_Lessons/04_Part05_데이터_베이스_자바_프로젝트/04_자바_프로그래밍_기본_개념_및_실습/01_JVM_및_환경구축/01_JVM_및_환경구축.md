## 1.1. JVM

- JVM이란 자바 가상 머신(Java Virtual Machine)의 줄임말 (직역하면 ‘**자바를 실행하기 위한 가상 기계(컴퓨터)**’)
  - 가상머신이란 프로그램을 실행하기 위해 물리적인 머신과 유사한 소프트웨어 머신을 구현한 것
  - JVM의 역할은 자바 애플리케이션을 클래스 로더를 통해 읽어들여 자바 API와 함께 실행
  - JVM은 Java와 OS 사이에서 중개자 역할을 수행
- Java가 OS에 구애받지 않고 종속적이지 않다는 특징을 가짐. OS에 종속받지 않고 실행되기 위해선 OS 위에서 Java를 실행시킬 JVM가 필요. 즉, OS에 종속받지 않고 CPU가 Java를 인식, 실행할 수 있게 하는 가상 컴퓨터가 JVM.
- 메모리 관리, Garbage collection을 수행.
- Java의 핵심 슬로건 (Write Once, Run Anywhere(WORA))

- Java 소스코드(원시코드)는 CPU가 인식하지 못하므로 기계어로 컴파일을 해줘야 함.
- Java는 이 JVM이라는 가상머신을 거쳐 OS에 도달하기 떄문에 OS가 인식할 수 있는 기계어로 바로 컴파일되는게 아니라 JVM이 인식할 수 있는 Java bytecode(\*.class)로 변환

## 1.2. 자바 개발 환경 구축

- VSCode로 개발 환경 구축
- 설치 실습 진행

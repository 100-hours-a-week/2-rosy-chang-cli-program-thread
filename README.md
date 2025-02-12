# 📖 CLI 기반 도서 관리 비동기 프로그램 (스레드 추가)

## 📝 프로젝트 개요
- 이 프로그램에서는 지난번에 구현한 CLI 기반 도서 관리 동기 프로그램에 
간단한 스레드를 추가하고 동기 프로그램으로 구현하였다.
---
## 🎯 **프로그램 동작 방식**
**데이터 자동저장 스레드** <br>
→ 도서관 관리자가 책을 추가, 삭제, 수정할 때마다 자동으로 책 목록을 파일(.txt)로 저장한다.<br>
→ 백 그라운드에서 실행되며, 일정 간격(10초)에 1번씩 자동으로 저장된다.
---

## ⏯️ **프로그램 출력 화면**
#### 스레드 작동 영상
![Image](https://github.com/user-attachments/assets/e91c1c44-ca05-4a1b-9be5-7fccfa19814d)

#### 자동 저장된 텍스트 파일 캡처 화면
<img width="663" alt="Image" src="https://github.com/user-attachments/assets/7d3c8bf3-13a6-48ae-b6b6-772de15fc47d" />

---

## 📌 **클래스 패키지 구조**
```
src
│── Main.java
│── thread
│   │── AutoSaveThread.java   // txt 파일 자동 저장 스레드
│── library
│   │── Library.java          // 도서 목록 관리
│   │── LibraryManager.java   // 사용자 인터페이스 (CLI)
│── books
│   │── Book.java             // 최상위 부모 클래스 (일반 책)
│── books.textbooks
│   │── TextBook.java         // 교과서 (1차 상속)
│   │── KoreanTextBook.java   // 국어 교과서
│   │── MathTextBook.java     // 수학 교과서
│   │── EnglishTextBook.java  // 영어 교과서
│   │── SocialTextBook.java   // 사회 교과서
│   │── ScienceTextBook.java  // 과학 교과서
│── books.nonfiction
│   │── NonFiction.java       // 비문학 (1차 상속)
│   │── HistoryBook.java      // 역사
│   │── ArtBook.java          // 예술
│   │── PhilosophyBook.java   // 철학
│   │── EconomicsBook.java    // 경제
│── books.fiction
│   │── Fiction.java          // 문학 (1차 상속)
│   │── ClassicBook.java      // 고전 문학
│   │── DramaBook.java        // 희곡
│   │── NovelBook.java        // 소설
│   │── PoetryBook.java       // 시
│   │── AutobiographyBook.java // 자서전
```
---
## 🛠️ **향후 개선 또는 확장하고 싶은 기능**
- [ ]  도서관 대출과 반납 기능을 추가해서 무인 대출반납기에서 시간 내에 대출이나 반납을 해야하는 스레드 또는 로그인하고 시간이 만료되는 스레드 구현
    - [ ]  사용자가 책 빌리는 기능 추가하고 → 책 반납 마감기한 지나면 연체되었다고 알리기 → 연체된 책 목록과 총 권 수 출력하기 → 연체된 책 반납하면 → 연체 반납되었다고 알리고 며칠간 재대출 금지되는지 알리기

---
## ⚙️️ **기술 스택**
#### 🔹 언어: Java 21
#### 🔹 개발 환경: IntelliJ IDEA


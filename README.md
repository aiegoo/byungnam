# [AIBE5] 이병남 - Java Programming Assignments

## 📊 Progress Tracker
[googleDrive](https://drive.google.com/file/d/1xE7trQ5FvXaiv0EKTMw9rxzyKC9YWpu8/view?usp=sharing)

| Date | Page | Assignment | Status |
|------|------|------------|--------|
| 2026-02-03 | 86 | MultiplicationTable (전체 구구단) | ✅ |
| 2026-02-03 | 86 | EvenDanOnly (짝수 단만) | ✅ |
| 2026-02-03 | 86 | LimitedMultiplier (삼각형 패턴) | ✅ |
| 2026-02-03 | 57 | CelToFah (온도 변환) | ✅ |
| 2026-02-03 | 57 | AverageCalculator (4과목 평균) | ✅ |
| 2026-02-03 | 66 | GradeCalculator (학점 계산) | ✅ |
| 2026-02-03 | 69 | AmusementParkFee (놀이공원 입장료) | ✅ |
| 2026-02-03 | 69 | BuildingFloor (건물 층수 계산) | ✅ |
| 2026-02-03 | 69 | Calculator (계산기) | ✅ |

---

## Page No.70 - 성적 계산기 (Grade Calculator)

### 📋 Assignment: Average Calculator Grade

**파일**: [src/GradeCalculator.java](src/GradeCalculator.java)

성적 점수에 따라 학점을 계산하는 프로그램

**요구사항**:
- 95점 이상: A+
- 90점 이상: A
- 85점 이상: B+
- 80점 이상: B
- 70점 이상: C
- 60점 이상: D
- 60점 미만: F

**실행 방법**:
```bash
cd src
javac GradeCalculator.java
java GradeCalculator
```

---

## Page No.69 - 조건문 실습

### 📋 과제 목록

#### Assignment 1: 놀이공원 입장료 계산 (if-else if-else)
**파일**: [src/AmusementParkFee.java](src/AmusementParkFee.java)

놀이공원 입장료를 나이별로 계산하는 프로그램

**요구사항**:
- 취학 전 아동 (8살 미만): 1,000원
- 초등학생 (14살 미만): 2,000원
- 중고등학생 (20살 미만): 2,500원
- 성인 (60살 미만): 3,000원
- 경로 우대 (60세 이상): 0원

**실행 방법**:
```bash
cd src
javac AmusementParkFee.java
java AmusementParkFee
```

---

#### Assignment 2: 건물 층별 시설 안내 (switch-case)
**파일**: [src/BuildingFloor.java](src/BuildingFloor.java)

Switch case 문을 이용한 건물 층별 시설 안내 프로그램

**요구사항**:
- 1층: 약국
- 2층: 정형외과
- 3층: 피부과
- 4층: 치과
- 5층: 헬스 클럽
- 5층인 경우 "5층 헬스 클럽입니다." 출력

**실행 방법**:
```bash
cd src
javac BuildingFloor.java
java BuildingFloor
```

---

#### Assignment 3: 사칙연산 계산기 (if문 & switch문)
**파일**: [src/Calculator.java](src/Calculator.java)

if문과 switch문을 모두 사용하여 사칙연산을 수행하는 프로그램

**요구사항**:
```java
int num1 = 10;
int num2 = 2;
char operator = '+';
```
- Operator 값이 +, -, *, / 인 경우 사칙 연산 수행
- if문과 switch문 두 가지 방식으로 구현
- 0으로 나누기 에러 처리

**실행 방법**:
```bash
cd src
javac Calculator.java
java Calculator
```

---

## 🧪 테스트 스위트

각 과제마다 comprehensive test suite가 제공됩니다.

### Test 0: GradeCalculatorTest (Page 70)
**파일**: [src/GradeCalculatorTest.java](src/GradeCalculatorTest.java)

- 35개 테스트 케이스
- 모든 학점 범주 테스트 (A+, A, B+, B, C, D, F)
- 경계값 테스트 (95, 94, 90, 89, 85, 84, 80, 79, 70, 69, 60, 59)
- 유효하지 않은 입력 테스트
- 100% 테스트 통과

**실행**:
```bash
cd src
javac GradeCalculatorTest.java
java GradeCalculatorTest
```

### Test 1: AmusementParkFeeTest
**파일**: [src/AmusementParkFeeTest.java](src/AmusementParkFeeTest.java)

- 23개 테스트 케이스
- 모든 나이 범주 테스트
- 경계값 테스트 (7세, 8세, 13세, 14세, 19세, 20세, 59세, 60세)
- 100% 테스트 통과

**실행**:
```bash
cd src
javac AmusementParkFeeTest.java
java AmusementParkFeeTest
```

### Test 2: BuildingFloorTest
**파일**: [src/BuildingFloorTest.java](src/BuildingFloorTest.java)

- 10개 테스트 케이스
- 모든 층(1-5층) 테스트
- 잘못된 층 입력 테스트
- 요구사항 특정 테스트 (5층 헬스 클럽)
- 100% 테스트 통과

**실행**:
```bash
cd src
javac BuildingFloorTest.java
java BuildingFloorTest
```

### Test 3: CalculatorTest
**파일**: [src/CalculatorTest.java](src/CalculatorTest.java)

- 40개 테스트 케이스
- if문 구현 테스트 (10개)
- Page | Assignment | Test File | Total Tests | Passed | Success Rate |
|------|-----------|-----------|-------------|--------|--------------|
| 70 | Grade Calculator | GradeCalculatorTest | 35 | 35 | 100% |
| 69 | Assignment 1 | AmusementParkFeeTest | 23 | 23 | 100% |
| 69 | Assignment 2 | BuildingFloorTest | 10 | 10 | 100% |
| 69 | Assignment 3 | CalculatorTest | 40 | 40 | 100% |
| | **Total** | | **108** | **108
```bash
cd src
javac CalculatorTest.java
java CalculatorTest
```

---

## 📊 테스트 결과 요약

| Assignment | Test File | Total Tests | Passed | Success Rate |
|-----------|-----------|-------------|--------|--------------|
| Assignment 1 | AmusementParkFeeTest | 23 | 23 | 100% |
| Assignment 2 | BuildingFloorTest | 10 | 10 | 100% |
| Assignment 3 | CalculatorTest | 40 | 40 | 100% |
| **Total** | | **73** | **73** | **100%** |

---

## 🔧 프로젝트 구조

```
choco/
├── README.md
└── src/
    ├── AmusementParkFee.java         # 과제 1: 놀이공원 입장료
    ├── AmusementParkFeeTest.java     # 과제 1 테스트
    ├── BuildingFloor.java            # 과제 2: 건물 층별 안내
    ├── BuildingFloorTest.java        # 과제 2 테스트
    ├── Calculator.java               # 과제 3: 사칙연산 계산기
    └── CalculatorTest.java           # 과제 3 테스트
```

---

## 📝 구현 특징

### 1. **JavaDoc 주석**
- 모든 클래스와 메서드에 JavaDoc 주석 작성
- Page No.69 명시
- 요구사항 문서화

### 2. **테스트 가능한 구조**
- 핵심 로직을 별도 메서드로 분리
- public static 메서드로 구현하여 테스트 용이
- 반환값 기반 설계

### 3. **에러 처리**
- 0으로 나누기 검증
- 잘못된 입력 처리
- NaN 반환으로 에러 상태 전달

### 4. **Comprehensive Testing**
- 정상 케이스 테스트
- 경계값 테스트
- 에러 케이스 테스트
- 일관성 검증

---

## 👨‍💻 Author

**이병남 (byungnam)**
- GitHub: [@aiegoo](https://github.com/aiegoo)
- Repository: [byungnam](https://github.com/aiegoo/byungnam)

---

## 📚 학습 내용

- ✅ if-else if-else 조건문
- ✅ switch-case 문
- ✅ 연산자 처리
- ✅ 에러 처리
- ✅ 테스트 주도 개발
- ✅ JavaDoc 문서화
- ✅ 코드 구조화

---

## 🚀 Quick Start

모든 프로그램 컴파일 및 실행:
```bash
cd src

# 과제 실행
javac AmusementParkFee.java && java AmusementParkFee
javac BuildingFloor.java && java BuildingFloor
javac Calculator.java && java Calculator

# 테스트 실행
javac AmusementParkFeeTest.java && java AmusementParkFeeTest
javac BuildingFloorTest.java && java BuildingFloorTest
javac CalculatorTest.java && java CalculatorTest
```

---

**Last Updated**: 2026년 2월 3일

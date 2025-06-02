/*
- 데이터베이스 : 데이터(data) + 베이스(base)
- DBMS : Database Management System의 약자, 데이터베이스 관리 시스템
- 관계형(Relational) 데이터베이스
  1. 가장 대표적인 데이터베이스 시스템
  2. 데이터를 테이블 형태(행과 열)로 저장하고, 여러 테이블 간 관계를 설정하고, 데이터의 관계를 표현 및 분석
  3. 데이터의 중복을 최소화하고 무결성, 트랜잭션 관리 등 뛰어난 데이터 관리 성능을 제공
- SQL(Structured Query Language)
  : 관계형 데이터베이스에서 데이터를 조회하거나 조작하기 위해 사용하는 표준 언어
- SQL 종류
  1. DML(Data Manipulation Language) : 데이터 조작어
     - 데이터를 조작하기 위한 언어 (INSERT : 추가, SELECT : 조회, UPDATE : 수정, DELETE : 삭제)
     C : CREATE - 추가
     R : READ - 조회
     U : UPDATE - 수정
     D : DELETE - 삭제
     - SELECT는 데이터 조회를 의미하여 일부에서는 DQL(Data Query Language)로 분류하기도 함(SELECT만)
  2. DDL(Data Definition Language) : 데이터 정의어
     - DB의 구조를 정의하거나 변경, 삭제하기 위한 언어(CREATE : 생성, ALTER : 수정, DROP :삭제)
     - 테이블 변경과 관련
  3. DCL(Data Control Language) : 데이터 제어어
     - DB의 보안, 권한 관리, 무결성 제어를 위한 언어(GRANT : 권한 부여, REVOKE : 권한 회수)
  4. TCL(Transaction Control Language) : 트랜잭션 제어어
     - 트랜잭션 처리 및 제어를 위한 언어(COMMIT : 실행, ROLLBACK : 취소, SAVEPOINT : 임시저장)
*/

/*
  SELECT 컬럼1, 컬럼2, ...
  FROM 테이블명;
  - 테이블에서 데이터를 조회할 때 사용하는 SQL문
  - SELECT 실행 결과를 Result Set이라고 한다.
  - 조회하고자 하는 컬럼은 반드시 FROM 절에 지정한 테이블에 존재해야 한다
  - 테이블의 모든 컬럼을 조회하려면 * 기호를 사용한다
*/

-- USER_INFO 테이블 전체 조회
SELECT *
FROM USER_INFO;

-- USER_INFO 이름(NAME), 나이(AGE), 취미(HOBBY) 조회
SELECT NAME, AGE, HOBBY
FROM USER_INFO; -- 오라클에서 쓰는 방식(전부 대문자)

-- EMPLOYEE 테이블의 직원명(EMP_NAME), 이메일(EMAIL) 조회
SELECT EMP_NAME, EMAIL
FROM EMPLOYEE;

/*
  컬럼 산술 연산
  - SELECT 절에 컬럼명 입력 부분에 산술연산자를 사용하여 결과 조회
  
  컬럼 별칭 : 컬럼에 별명을 부여한다
  - 산술연산을 하게 되면 컬럼명이 지저분해진다.
    이때 컬럼명에 별칭을 부여하면 깔끔하게 보일 수 있다.
  - 컬럼 AS 별칭 / 컬럼 AS "별칭 / 컬럼 별칭 / 컬럼 "별칭"
*/
-- USER_INFO에서 나이(AGE)에 10년 후를 계산
SELECT NAME, AGE, AGE + 10 AS "10년 후" 
FROM USER_INFO;

-- EMPLOYEE에서 직원명(EMP_NAME), 월급(SALARY), 연봉 조회
SELECT EMP_NAME, SALARY, SALARY * 12
FROM EMPLOYEE;

select * from emp;

-- 테이블 목록
show tables;

-- 테이블 생성 
create table member(
	mem_id integer primary key,
    username varchar(30) not null,
    depart varchar(30), 
    position varchar(2),
    tel varchar(15) not null,
    writedate datetime default now() not null
    );
    
select * from member;

-- 테이블 구조
desc member;

select * from emp;

-- emp 테이블과 같은 테이블 만들기
 create table emp2
 as 
 select * from emp;
 
 
 show tables;
 create table emp3
 as 
 select empno, ename, sal from emp;
 select * from emp3;
 
 -- manager 업무를 하는 사원을 이용하여 테이블 이용하기 
 
create table emp4
 as
 select * from emp where job ='manager';
 select * from emp4;
 
 -- 테이블 구조만으로 테이블 생성
 create table emp5 
 as 
 select * from emp where 1=2;
 
 select * from emp5;
 
 show tables;
 
 select * from emp2;
 desc emp2;
 
 insert into emp2(empno, ename, deptno, job, sal, comm, mgr, hiredate)
 values(7777, '홍길동', 40, '사무직', 5500, 100, 7788, now()); 
 
 insert into emp2(empno, ename, sal) values(8888, '이순신', 7000);
 select * from emp2;
 
 -- 레코드 수정
 -- 사원번호 7777인 사원의 급여를 4000으로 변경
 
 set sql_safe_updates = 0;
update emp2 set sal=4000 where empno=7777;
 
 
 update emp2 set sal = sal*1.1;
 
 -- 레코드 삭제
 delete from emp2 where ename ='이순신';
 delete from emp2 where deptno = 10;
 
 select * from emp2; 
 
desc member;
select * from member;
insert into member(mem_id, username, depart, position, tel)
values(1111,'고구마','기획부', '사원','01-234-5678');
 
insert into member(mem_id, username, tel)
values(2222,'이순신','02-234-5678');
select * from member;
 
drop table emp5;
drop table emp2;
drop table emp3;
drop table emp4;

show tables;

select * from member;


-- 이메일 필드 추가
alter table member add email varchar(50);

desc member; 
insert into member(mem_id, username, depart, tel) 
values(9988, '세종대왕', '기획총괄부', '010-1212-2323');


-- 필드 수정
alter table member modify depart varchar(20);


-- 필드명 수정
alter table member change tel phone varchar(20);

-- 필드 삭제
alter table member drop column position;




select * from member;


show tables;
show databases;

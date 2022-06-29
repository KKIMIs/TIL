show tables;

select * from emp;
select * from dept;
select * from salgrade;

desc emp;
desc dept;
desc salgrade;

show databases;
use information_schema;
show tables;
select * from table_constraints where contraint_schema = 'multi';
-- 제약조건 확인하기
select * from table_constraints where table_name = 'book_tbl';

use multi;
insert into emp(empno) values(7788);
select * from emp;

-- emp 테이블에 empno를 primary key 설정 

alter table emp add primary key(empno);
delete from emp where empno = 7788 and ename is null;


insert into emp(empno, ename) values(7788,'홍길동');

-- dept -> deptno
-- salgrade --> grade 

alter table dept add primary key(deptno);
alter table salgrade add primary key(grade);


select * from dept;
-- unique						제약조건이름
alter table dept add constraint uk_dept_dname unique(dname); 

insert into dept(deptno, dname, loc) values (50, '기획부', '서울 서초구');
insert into dept(deptno, dname, loc) values (60, 'SALES', '서울 강남구');


select * from dept;
update emp set sal = 5000 where ename = 'king';
-- check :800 ~ 8000

alter table emp add constraint ch_emp_sal check (sal>=800 and sal<=8000); 
insert into emp(empno, ename, sal) values(8888,'홍길동', 7500);
insert into emp(empno, ename, sal) values(9999, '홍길동2', '8500');



select * from information_schema.table_constraints where table_schema = 'mulit';








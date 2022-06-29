-- 서브쿼리: 쿼리문 내에 뭐리문이 존재한다

use multi;
select * from emp;

select job from emp where empno = 7369;
select empno, ename from emp where  job='clerk';

select empno, ename, sal from emp
where job = (select job from emp where empno = 7369);

select * from emp
where job = (select job from emp where ename = 'adams') 
or
deptno = (select deptno from emp where ename= 'scott');

-- 평균급여보다 많이 받는 사원은? 
select * from emp
where sal> (select avg(sal) from emp);

select avg(sal) from emp;
-- ford 와 같은 부서의 사원 중 평균 급여보다 작게 받는 사원은?
select * from emp 
where sal < (select avg(sal) from emp) 
&& deptno = (select deptno from emp where ename = 'ford');

-- 담당 업무별 급여의 합계와 급여의 평균을 구하는데 
-- 전체 사원의 평균보다 많이 받는 담당업무를 선택하라

select job, sum(sal), avg(sal) from emp
group by job  having avg(sal) > (select avg(sal) from emp); 

select job, sum(sal), avg(sal) from emp
group by job;

-- 다중행 서브쿼리
--   									3000, 2850, 5000
select * from emp where sal in (select max(sal) from emp group by deptno);


select ename, job, sal from emp 
where sal in (select max(sal) from emp group by job); 


-- any: 한개의 조건에 만족하면 선택
select * from emp
where deptno !=20 
and 
sal < any(select sal from emp where job ='salesman');

-- all: 모든 값이 만족
select * from emp
where sal > all(select sal from emp where job ='salesman');

-- exist
select empno, ename, sal from emp e 
where exists (select empno from emp where e.empno=mgr);


-- 다중 열 서브쿼리 
select empno, ename, sal, deptno, comm from emp
where (sal, deptno) in (select sal, deptno from emp where deptno = 30 and comm is not null); 

-- 업무 별로 최소 급여를 받는 사원의 사번, 이름, 업무, 부서번호를 출력 
-- 단, 업무별로 정렬 

select empno, ename, job, deptno from emp
where (job,sal) in (select job, min(sal) sal from emp group by job) order by job;

select empno, ename, job, deptno, sal from emp
where sal in (select min(sal) from emp group by job);

-- from 절에 서브쿼리 사용
select empno, ename, job, sal from
(select empno, ename, job, sal, comm, hiredate from emp where deptno =10 or deptno =20) a; 

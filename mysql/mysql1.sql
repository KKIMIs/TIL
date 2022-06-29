use multi;

select * from emp;
-- 사원명, 담당업무, 급려를 선택하라
select ename, job, sal*0.1 as bonus from emp;
select ename as 사원명, job 담당업무, sal 급여 from emp;

-- where 절: 조건절 -> 레코드에 대한 조건식 
-- 금여가 3000불 이상인 사원을 선택 
select * from emp where sal>=3000;

-- empno: 사원번호, ename: 사원명, job: 담당업무, mgr: 상급자 사원번호 
-- hiredat: 입사일, sal:급여, comm:보너스, deptno: 부서코드alter

-- 담당업무가 manager이거나 급여가 3000불 이상인 사원
select * from emp where sal>=3000 or job ='manager' ;


-- 급여가 2000에서 3000불 사이인 사원 

select * from emp where sal>=2000 && sal<=3000;

-- between : 범위를 지정할 때
select * from emp where empno between 7500 and 7800;
select * from emp where empno not between 7500 and 7800;
select * from emp where empno >=7500 && empno <7800;

-- in 연산자 : or 을 뜻한다.
-- 사원번호 7369, 7654, 7788인 사원을 선택
select * from emp where empno = 7369 or empno = 7654 or empno = 7788;
select * from emp where empno in (7369, 7654, 7788);
select * from emp where empno not in (7369, 7654, 7788);


-- like 연산자 : 문자열 내에 특정 데이터 포함된 정보를 선택할 때 
-- %: 여러문자,  _: 한개 문자 

-- 사원명이 A로 시잘하는 사원 선택 
select * from emp where ename like 'A%';
select * from emp where ename like '%N';
select * from emp where ename like '%A%';

select * from emp where ename like '__A%';

-- 이름에 D가 포함된 사원 제외 선택
select * from emp where ename not like '%d%';

-- 5월에 입사한 사원은?
select * from emp where hiredate like '_____12%';

-- is null
select * from emp where comm>0;
-- comm null 인 사원을 선택
select * from emp where comm = null;
select * from emp where comm is null;

select comm, ifnull(comm,1)*100 comm2 from emp;

-- mgr가 null 이 아닌 사원을 선택하라 
select * from emp where mgr is not null;


-- order by: 레코드를 오름차순 또는 내림차순으로 정렬

-- 사원명 오름차순
select * from emp order by ename asc;
-- 내림차순
select * from emp order by ename desc;


-- 부서별 급여순(내림차순)으로 정렬

select deptno, sal, ename from emp order by deptno desc, sal asc;

select * from emp;


-- 1. emp 테이블의 레코드 중 담당업무가 manager 이거나 salesman 인 사원의 
--  사원명, 입사일, 급여 선택 
select ename, hiredate, sal from emp where job in ('manager','salesman');

-- 2. emp 테이블의 레코드 중 사원번호가 7500번 이상인 사원 중 
-- 급여가 200~3000 사이인 사원을 선택
-- 단) 사원명을 오름차순으로 정렬
select * from emp where empno >= 7500 and sal between 2000 and 3000 order by ename; 

-- 3. 부서코드가 20, 30 인 사원의 사원번호, 사원명, 입사일, 급여를 선택
-- 입사일을 내림차순 정렬 
select empno, ename, hiredate, sal from emp where deptno in (20,30) order by hiredate desc;

-- 4.  사원명에 'm'이 포함되었거나 'o'가 포함된 사원 중 보너스를 받는 사원
select * from emp where (ename like '%m%' or ename like '%o%') and comm is not null;
select * from emp where (ename like '%m%' or ename like '%o%') and comm>0;

-- 5. 12월에 입사한 사원 중 10부서의 사원
select * from emp where hiredate like '_____12%' and deptno = 10;

-- 6.  1982년에 입사한 사원을 이름 오름차순 급여 내림차순으로 정렬
select * from emp where hiredate like '1982%' order by ename asc, sal desc ;

-- 7. 사원번호, 사원명, 급여, 보너스, 지급액을 선택하라 
-- 보너스는 null 은 0으로 지급액은 급여 + 보너스
select empno 사원번호, ename 사원명, sal 급여, 
ifnull(comm,0) 보너스, ifnull(comm,0)+sal 지급 from emp;

-- 8. 보너스를 받지않는 사원을 사원명 순 선택
select * from emp where comm is null or comm <= 0 order by ename;

-- 9. 담당업무가 manager가 아닌 사원을 급여 순으로 선택 
select * from emp where job != 'manager' order by sal;

-- 10. 사원명, 담당업무, 급여, 부서코드를 선택하되 salesmam 을 제외하고 선택
select ename, job, sal, deptno from emp where job not in ('salesman'); 
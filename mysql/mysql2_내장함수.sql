select abs(-63); 
select ceil(78.1), floor(19.9);

select mod(10,3), 10%3 ;
select floor(rand()*6)+5; -- 5~10

select pow(5,3), sqrt(16);
select round(253.26543, 2), round(253.845, -2);

select format(25364.5895, 2);

select ascii('A'), char(66);
select ascii('ㅎ');

select BIT_LENGTH('abc'), char_length('abc'), length('abc');
select BIT_LENGTH('가나다'), char_length('가나다'), length('가나다');

select concat(2022,6,27);

select elt(3, 'a', 'b', 'c', 'd') as elt,
field('b','x','y','b','z') as field,
find_in_set('text','text,sample') find_in_set,
instr('abcd','c') instr,
locate('x','xyz');

use multi;
select ename, insert(ename, 2,2,'***') enames2 from emp order by ename;
select ename, reverse(ename) from emp;
select ename, left(ename, 2), right(ename, 2) from emp;
select ename, lcase(ename), ucase('abcd') from emp;
select ename, lpad(ename, char_length(ename)+1, '$'), rpad(ename, 10, '*') from emp;
select substring(job,3,2), job from emp;
select substring_index('www.nate.com','.',2),
substring_index('www.naver.com','n',-1);

-- 문제: 이름을 글자길이의 50%만큼 출력하고 나머지 문자는 '*'로 표시하여라
select ename , rpad(substring(ename, 1, floor(char_length(ename)/2)), char_length(ename) , '*') as ename from emp;

select ename, floor(char_length(ename)/2) from emp;
select ename, repeat(ename,3) from emp;
select ename, replace(ename, 'A', '에이') from emp;

select concat('y',trim('          abc           '),'y'), 
concat('y',ltrim('        xyz      ')),
concat(rtrim('        test        ') ,'y' )from emp;

-- 이메일을 이용하여 아이디와 도메인을 분리
select substring_index('abc123@gmail.com','@',1) as id, 
substring_index('abd123@gmail.com','@',-1) as domain;

select substring('goguma@nate.com',1,locate('@','goguma@nate.com')-1),
substring('goguma@nate.com',locate('@','goguma@nate.com')+1);

-- 날짜 함수
select curdate(), curtime(), now(), sysdate();
select date(now()), year(now()), month(now());

select adddate(now(), interval 99 day), subdate(now(), interval 30 day);
select datediff(now(), '2021-10-05');


select dayofweek(now()), monthname(now()), dayofyear('2022-10-10');

select last_day('2022-02-10'), time_to_sec('2022-06-28 00:10');
select date_format(now(), '%w %m %y');

-- 그룹함수
select count(ifnull(comm,0)) 사원수, max(sal) 최대값, min(sal) 최소값, 
avg(sal), sum(sal) from emp;

select count(empno) from emp;

-- 담당 업무별 사원수
select job, count(empno), sum(sal), avg(sal) from emp group by job;

-- 담당 업무 별, 사원 수가 3명 이상인 경우 선택
select job, count(empno),  max(sal), min(sal) from emp group by job 
having count(empno)>=3;

-- 급여가 2500불 이상인 사원을 부서별 급여의 합계, 평균을 구하되
-- 부서별 급여의 평균이 2800불 이상인 부서만 선택

select deptno, sum(sal), avg(sal) from emp 
where sal >= 2500 group by deptno having avg(sal)>=2800 order by deptno;


-- 1981년도에 입사한 사원의 담당업무별 사원 수, 급여의 평균, 최고급여, 최저 급여
-- 단 급여의 평균이 2000불 이상인 업무만 선택하라 

select job, count(empno), avg(sal), max(sal), min(sal) from emp 
where hiredate like '1981%' group by job having avg(sal)>=2000;




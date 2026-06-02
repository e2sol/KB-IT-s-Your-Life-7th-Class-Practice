# employees 데이터베이스 이용

# 문제 03
-- 현재 재직중인 직원의 정보를 출력
-- 출력 항목 : emp_no, first_name, last_name, title
select e.emp_no, e.first_name, e.last_name, titles.title
from employees e
join titles
on e.emp_no = titles.emp_no
join dept_emp
on e.emp_no = dept_emp.emp_no
where dept_emp.to_date = '9999-01-01';

# 문제 03-1
-- 현재 재직중인 직원의 정보를 출력
-- 출력 항목 : 직원의 기본정보 모두, title, salary
select e.*, titles.title, salaries.salary
from employees e
join titles
on e.emp_no = titles.emp_no
join salaries
on e.emp_no = salaries.emp_no
join dept_emp
on e.emp_no = dept_emp.emp_no
where dept_emp.to_date = '9999-01-01';

# 문제 03-2
-- 현재 재직중인 직원의 정보를 출력
-- 출력 항목 : emp_no, first_name, last_name, dept_name
-- 정렬 : emp_no 오름차순
select employees.emp_no, employees.first_name, employees.last_name, departments.dept_name
from employees
join dept_emp
on employees.emp_no = dept_emp.emp_no
join departments
on dept_emp.dept_no = departments.dept_no
where to_date = '9999-01-01'
order by employees.emp_no;

# 문제 04
-- 부서별 재직중인 직원의 수를 출력
-- 출력 항목 : 부서 번호, 부서명, 인원수
-- 정렬 : 부서 번호 오름차순
select departments.dept_no, departments.dept_name, count(dept_emp.emp_no)
from departments
join dept_emp
on departments.dept_no = dept_emp.dept_no
where to_date = '9999-01-01'
group by departments.dept_no
order by departments.dept_no;

# 문제 05
-- 직원 번호가 10209인 직원의 부서 이동 히스토리 출력
-- 출력 항목 : emp_no, first_name, last_name, dept_name, from_date, to_date
select employees.emp_no, employees.first_name, employees.last_name,
       departments.dept_name, dept_emp.from_date, dept_emp.to_date
from employees
join dept_emp
on employees.emp_no = dept_emp.emp_no
join departments
on dept_emp.dept_no = departments.dept_no
where dept_emp.emp_no = 10209;
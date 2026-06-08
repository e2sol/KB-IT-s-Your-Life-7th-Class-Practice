package edu.employee.service;

import edu.employee.dao.EmployeeDao;
import edu.employee.dao.EmployeeDaoImpl;
import edu.employee.vo.EmployeeVO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeService {

    private Scanner sc = new Scanner(System.in);

    private EmployeeDao dao = new EmployeeDaoImpl();

    public void displayMenu() {


        int menu = 0; // 메뉴 선택용 변수

        do {
            try {
                System.out.println("[직원 관리 시스템]");
                System.out.println("1. 부서 직원 정보 조회");
                System.out.println("2. 부서·직급별 평균 급여 조회");
                System.out.println("3. 재직 중인 직원 목록 조회");
                System.out.println("4. 부서 급여 10% 인상");
                System.out.println("5. 휴대폰 번호 없는 직원 조회");

                // 조 별 추가 문제
                System.out.println("6. 새로운 직원 정보 입력");
                System.out.println("7. 직원 정보 삭제");

                System.out.println("0. 종료");
                System.out.print("메뉴 선택 >> ");

                menu = sc.nextInt();
                sc.nextLine(); // 입력 버퍼 개행문자 제거
                System.out.println(); // 줄바꿈

                switch (menu) {
                    case 1:
                        getDepartmentEmployees();
                        break;

                    case 2:
                        getDepartmentAvgSalary();
                        break;

                    case 3:
                        getWorkingEmployees();
                        break;

                    case 4:
                        increaseSalary();
                        break;

                    case 5:
                        getEmployeesWithoutPhone();
                        break;

                    case 6:
                        insertEmployeeMenu();
                        break;

                    case 7:
                        deleteEmployee();
                        break;

                    case 0:
                        System.out.println("[프로그램 종료]");
                        break;

                    default:
                        System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
                }

            } catch (Exception e) {
                sc.nextLine(); // 잘못된 입력 제거
                e.printStackTrace();
            }
        } while (menu != 0);
    }

    /**
     * 부서명을 입력받아 해당 부서에 근무하는 직원 정보를 조회
     *
     * 조회 컬럼 : 사원명(EMP_NAME), 부서명(DEPT_TITLE), 직급명(JOB_NAME), 보너스율(BONUS), 퇴직여부(ENT_YN)
     *
     * 요구사항
     * - 보너스율이 NULL인 경우 '보너스 없음'으로 표시
     * - 퇴직여부가 'N'이면 '재직', 'Y'이면 '퇴사'로 표시
     * - 보너스율 내림차순 정렬
     *
     */
    private void getDepartmentEmployees() throws SQLException {
        System.out.println("======= 부서 근무 직원 정보 조회 =======");

        System.out.print("조회할 부서 이름 : ");
        String deptName = sc.nextLine();

        List<EmployeeVO> list = dao.getDeptEmpl(deptName);

        System.out.println("\n======= 조회 결과 =======");
        for (EmployeeVO empl : list) {
            System.out.printf("이름 : %s, 부서명 : %s, 직급명 : %s, 보너스율 : %s, 퇴직여부 : %s\n", empl.getEmpName(), empl.getDeptTitle(), empl.getJobName(), empl.getBonus(), empl.getEntYn());
        }

        System.out.println();
    }

    /**
     * 부서별, 직급별 평균 급여 정보를 조회
     *
     * 조회 컬럼 : 부서명, 직급명, 사원수, 평균급여
     *
     * 요구사항:
     * - 재직 중인 직원만 조회
     * - 부서+직급 별 평균 급여가 300만원 이상인 경우만 조회
     * - 평균급여 반올림, 내림차순 정렬
     *
     */
    private void getDepartmentAvgSalary() throws SQLException {
        System.out.println("========= 부서•직급별 평균 급여 조회 =========");
        System.out.println(" ** 평균 급여가 300만원 이상인 경우만 조회됩니다 ** ");
        List<EmployeeVO> list = dao.getDeptAvgSal();

        System.out.println("\n ======= 조회 결과 =======");

        for (EmployeeVO empl : list) {
            System.out.printf("부서명 : %s, 직급명 : %s, 사원수 : %d, 평균급여 : %.1f\n", empl.getDeptTitle(), empl.getJobName(), empl.getEmployeeCount(), empl.getAvgSalary());
        }

        System.out.println();
    }

    /**
     * 현재 재직 중인 직원 목록을 조회
     *
     * 조회 컬럼 : 부서명, 직급명, 사원명, 급여
     *
     * 요구사항:
     * - 재직 중인 직원만 조회
     * - 부서가 없는 직원도 조회
     * - 직급명 오름차순 정렬
     * - 상위 10명만 조회
     *
     */
    private void getWorkingEmployees() throws SQLException {
        System.out.println("======= 재직중인 직원 조회 =======");

        List<EmployeeVO> list = dao.getWorkingEmpl();

        Iterator<EmployeeVO> iterator = list.iterator();

        while (iterator.hasNext()) {
            EmployeeVO empl = iterator.next();

            System.out.printf("부서명 : %s, 직급명 : %s, 사원명 : %s, 급여 : %d\n", empl.getDeptTitle(), empl.getJobName(), empl.getEmpName(), empl.getSalary());
        }

        System.out.println();
    }

    /**
     * 특정 부서 직원의 급여를 인상한다.
     *
     * 요구사항:
     * - 부서코드를 입력받는다.
     * - 해당 부서 직원들의 급여를 10% 인상한다.
     *
     * 출력 예시:
     * 부서코드 입력 >> D5
     * 5명의 급여가 10% 인상되었습니다.
     */
    private void increaseSalary() throws SQLException {
        System.out.println("======= 특정 부서 급여 인상 =======");
        System.out.println(" ** 급여를 10% 인상합니다 **");

        System.out.print("급여를 인상할 부서코드 : ");
        String deptCode = sc.nextLine();

        int count = dao.increaseSalary(deptCode);
        System.out.printf("%d명의 급여가 10%% 인상되었습니다.\n\n", count);
    }

    /**
     * 휴대폰 번호가 없는 직원 정보를 조회한다.
     *
     * 조회 컬럼 : 사원명, 휴대폰번호, 부서명
     *
     * 요구사항:
     * - 휴대폰 번호가 NULL인 직원만 조회
     * - 휴대폰 번호가 NULL인 경우 '없음'으로 표시
     * - 사원명 내림차순 정렬
     *
     */
    private void getEmployeesWithoutPhone() throws SQLException {
        System.out.println("======= 휴대폰 번호가 없는 직원 조회 =======");

        List<EmployeeVO> list = dao.getEmplWithoutPhone();

        for (EmployeeVO e : list) {
            System.out.printf("사원명 : %s, 휴대폰번호 : %s, 부서명 : %s\n", e.getEmpName(), e.getPhone(), e.getDeptTitle());
        }
        System.out.println();
    }

    // 신규 직원 정보 추가 방법 선택 메뉴
    private void insertEmployeeMenu() {
        System.out.println("======= 신규 직원 추가 방법 선택 =======");
        int menu = 0;
        do {
            try {
                System.out.println("** 직원 추가 방법을 선택하세요 **");
                System.out.println("1. 자세한 직원 정보 추가");
                System.out.println("2. 간단한 직원 정보 추가");
                System.out.println("3. 메인메뉴로 돌아가기");
                System.out.print("방법 선택 >> ");
                menu = sc.nextInt();
                sc.nextLine(); // 개행문자 제거

                switch (menu) {
                    case 1:
                        insertEmployee();
                        break;

                    case 2:
                        insertEmployeeSimple();
                        break;

                    case 3:
                        System.out.println("메인 메뉴로 돌아갑니다.\n");
                        return;

                    default:
                        System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
                }

            } catch (Exception e) {
                sc.nextLine(); // 잘못된 입력 제거
                e.printStackTrace();
            }
        } while (menu != 3);
    }

    // 사번 중복 확인 메서드
    private boolean isRepeatedId(String id) throws SQLException {
        List<String> empIds = dao.getEmployeeIds();

        return empIds.contains(id);
    }

    // 유효한 직급명 확인 메서드
    private boolean isExistJobName(String job) throws SQLException {
        Map<String, String> jobMap = dao.getJobNames();

        return jobMap.containsValue(job);
    }

    /**
     * 새로운 직원의 정보를 저장한다.
     *
     * 필수 입력 정보 : 사원번호, 직원명, 주민등록번호, 직급명, 급여
     * 추가 입력 정보 : 이메일, 전화번호, 부서명, 관리자사번, 입사일
     *
     * 입력 순서 : 사원 번호 > 직원명 > 주민등록번호 > 이메일 > 전화번호 > 부서명 > 직급명 > 급여 > 관리자사번 > 입사일
     *
     * 필수 입력 정보 미 입력 시 다음 단계로 이동불가.
     * 사원번호 중복 확인 진행. 중복 시 다시 입력 받기
     * 부서명이 존재하지 않는 경우 유효하지 않은 부서명입니다. 반환 및 다시 입력받기
     * 직급명이 존재하지 않는 경우 유효하지 않은 직급명입니다. 반환 및 다시 입력받기
     * 관리자사번이 존재하지 않는 경우 유효하지 않은 관리자 사번입니다. 반환 및 다시 입력받기
     * 부서명에 따라 부서코드 자동으로 부여
     * 직급명에 따라 직급코드 자동으로 부여
     * 급여에 따라 급여등급이 자동으로 부여
     * 입사일 미 입력 시 정보 입력일로 지정, 형식 검사 후 잘못된 경우 다시 입력 받기
     */
    private void insertEmployee() throws SQLException {
        System.out.println("======= 새로운 직원 정보 등록 (자세한ver.) =======");
        System.out.println(" ** (*) 표시 사항은 필수 입력 사항입니다. **");

        EmployeeVO empl = new EmployeeVO();

        while (true) {
            System.out.print("사원 번호(*) : ");
            String id = sc.nextLine();

            if (id.trim().isEmpty()) {
                System.out.println("필수 입력 항목입니다.");
                continue;
            }

            boolean check = isRepeatedId(id);
            // true > 중복된 id 존재 / false > 중복된 id 존재 안 함

            if (!check) {
                empl.setEmpId(id);
                break;
            } else {
                System.out.println("이미 존재하는 사번입니다.");
            }
        }

        do {
            System.out.print("사원 이름(*) : ");
            empl.setEmpName(sc.nextLine());

            if (empl.getEmpName().trim().isEmpty()) System.out.println("필수 입력 문항입니다.");
        } while (empl.getEmpName().trim().isEmpty());

        while (true) {
            System.out.print("주민등록번호(*) : ");
            String empNo = sc.nextLine();

            if (empNo.trim().isEmpty()) {
                System.out.println("필수 입력 문항입니다.");
                continue;
            }

            if (empNo.matches("\\d{6}-\\d{7}")) {
                empl.setEmpNo(empNo);
                break;
            } else {
                System.out.println("유효하지 않은 형식입니다. 다시 입력해주세요.");
            }
        }

        System.out.print("이메일 : ");
        empl.setEmpEmail(sc.nextLine().trim());

        System.out.print("핸드폰 번호(숫자만 입력) : ");
        empl.setPhone(sc.nextLine().trim());

        Map<String, String> deptTitle = dao.getDeptTitles();

        while (true) {
            System.out.print("부서명 : ");
            String dept = sc.nextLine().trim();

            if (dept.isEmpty()) break;

            if (deptTitle.containsValue(dept)) {
                empl.setDeptTitle(dept);
                break;
            } else System.out.println("유효하지 않은 부서명입니다.");
        }

        while (true) {
            System.out.print("직급명(*) : ");
            String job = sc.nextLine();

            if (job.trim().isEmpty()) System.out.println("필수 입력 문항입니다.");
            else if (isExistJobName(job)) {
                empl.setJobName(job);
                break;
            } else System.out.println("유효하지 않은 직급명입니다.");
        }

        do {
            System.out.print("급여(*) : ");
            String salary = sc.nextLine();

            if (!salary.trim().isEmpty()) {
                int temp = Integer.parseInt(salary);
                if (temp < 1000000 || temp > 10000000) System.out.println("유효한 급여값이 아닙니다.");
                else empl.setSalary(temp);
            }
            else System.out.println("필수 입력 문항입니다.");
        } while (empl.getSalary() == 0);

        List<String> managerId = dao.getManagerIds();

        while (true) {
            System.out.print("관리자사번 : ");
            String no = sc.nextLine();

            if (no.trim().isEmpty()) break;

            if (managerId.contains(no)) {
                empl.setManagerId(no);
                break;
            } else System.out.println("유효하지 않은 관리자 사번입니다.");
        }

        while (true) {
            System.out.print("입사일(yyyy-MM-dd) : ");
            String date = sc.nextLine();

            if (date.trim().isEmpty()) break;

            if (isValidDate(date)) {
                empl.setHireDate(date);
                break;
            } else System.out.println("유효하지 않은 날짜형식입니다.");
        }

        int count = dao.insertEmployee(empl);

        if (count == 1) System.out.println("\n ** 직원 정보 추가가 완료되었습니다 **\n");
    }

    // 날짜 입력 형식이 맞는지 확인
    private boolean isValidDate(String str) {
        try {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("uuuu-MM-dd")
                            .withResolverStyle(ResolverStyle.STRICT);

            LocalDate.parse(str, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * 직원 정보 입력받아 추가하기 간단한 ver.
     * 필수 입력 정보 : 사원번호, 직원명, 주민등록번호, 직급명, 급여
     *
     * 필수 입력 정보만 입력받아 employee에 추가
     * 사원번호 중복확인
     * 입력받지 않으면 단계 넘어가지 말 것.
     */
    private void insertEmployeeSimple() throws SQLException {
        System.out.println("======= 새로운 직원 정보 등록 (간단한ver.) =======");
        System.out.println("** 모든 항목들을 필수적으로 입력해야 합니다 **");

        EmployeeVO employee = new EmployeeVO();

        while (true) {
            System.out.print("사원 번호 : ");
            String id = sc.nextLine();

            if (id.trim().isEmpty()) {
                System.out.println("필수 입력 문항입니다.");
                continue;
            }

            if (isRepeatedId(id)) System.out.println("이미 존재하는 사번입니다.");
            else {
                employee.setEmpId(id);
                break;
            }
        }

        while (true) {
            System.out.print("사원 이름 : ");
            String name = sc.nextLine();

            if (name.trim().isEmpty()) {
                System.out.println("필수 입력 문항입니다.");
                continue;
            }

            employee.setEmpName(name);
            break;
        }

        while (true) {
            System.out.print("주민등록번호 : ");
            String empNo = sc.nextLine();

            if (empNo.trim().isEmpty()) {
                System.out.println("필수 입력 문항입니다.");
                continue;
            }

            if (empNo.matches("\\d{6}-\\d{7}")) {
                employee.setEmpNo(empNo);
                break;
            } else {
                System.out.println("유효하지 않은 형식입니다. 다시 입력해주세요.");
            }
        }

        while (true) {
            System.out.print("직급명 : ");
            String job = sc.nextLine();

            if (job.trim().isEmpty()) System.out.println("필수 입력 문항입니다.");
            else if (isExistJobName(job)) {
                employee.setJobName(job);
                break;
            } else System.out.println("유효하지 않은 직급명입니다.");
        }

        do {
            System.out.print("급여 : ");
            String salary = sc.nextLine();

            if (!salary.trim().isEmpty()) {
                int temp = Integer.parseInt(salary);
                if (temp < 1000000 || temp > 10000000) System.out.println("유효한 급여값이 아닙니다.");
                else employee.setSalary(temp);
            }
            else System.out.println("필수 입력 문항입니다.");
        } while (employee.getSalary() == 0);

        int count = dao.insertEmployeeSimple(employee);

        if (count == 1) System.out.println("\n ** 직원 정보 추가가 완료되었습니다 **\n");
    }

    /**
     * id를 입력받아, 해당 사원 정보 삭제
     * 삭제 전 id값에 해당하는 사원명, 부서명, 직급명 출력 후 삭제 진행여부 확인
     */
    // 직원 정보 삭제
    private void deleteEmployee() throws SQLException {
        System.out.println("======= 직원 정보 삭제 =======");
        String id = null;
        while (id == null) {
            System.out.print("삭제할 직원 사번 : ");
            id = sc.nextLine();

            boolean check = isRepeatedId(id);

            if (check) break;
            else {
                System.out.println("일치하는 사번이 존재하지 않습니다.");
                id = null;
            }
        }

        EmployeeVO empl = dao.getEmployeeInfo(id);

        if (empl == null) {
            System.out.println("정보 조회 시 오류 발생");
            return;
        }

        System.out.printf("%s %s %s의 정보를 삭제하시겠습니까? (Y/N) : ", empl.getDeptTitle(), empl.getJobName(), empl.getEmpName());
        String check = sc.nextLine();
        int count = 0;

        switch (check.toUpperCase().charAt(0)) {
            case 'Y':
                count = dao.deleteEmployee(id);
                break;
            case 'N':
                System.out.println("삭제를 취소합니다. 메인메뉴로 돌아갑니다.\n");
                return;
            default:
                System.out.println("입력 값이 올바르지 않습니다.");
                System.out.println("삭제를 취소하고 메인메뉴로 돌아갑니다.\n");
                return;
        }

        if (count == 1) System.out.println("삭제가 완료되었습니다.\n");
    }
}

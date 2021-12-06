create or replace PACKAGE BODY EMPLOYEES_PKG
AS
    --     Insert Employee
    PROCEDURE add_employees(
        fn_id IN TBL_EMPLOYEE.ID%TYPE,
        fn_name IN TBL_EMPLOYEE.NAME%TYPE,
        fn_age IN TBL_EMPLOYEE.AGE%TYPE,
        fn_id_dept IN TBL_EMPLOYEE.ID_DEPT%TYPE
    )
    AS
    BEGIN
        INSERT INTO TBL_EMPLOYEE(id, name, age, id_dept)
        VALUES (fn_id, fn_name, fn_age, fn_id_dept);
        COMMIT;
    END add_employees;
--     Get By ID
    PROCEDURE cari_employees(fn_id IN TBL_EMPLOYEE.ID%TYPE, fn_tblemployee OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN fn_tblemployee FOR
            SELECT e.name, e.age, d.id_dept, d.name_dept
            FROM TBL_EMPLOYEE E
                     INNER JOIN TBL_DEPARTMENT D on D.ID_DEPT = E.ID_DEPT
            WHERE ID = fn_id;
    END cari_employees;

--      Get All
    PROCEDURE list_employees(fn_tblemployee OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN fn_tblemployee FOR
            SELECT e.id, e.name, e.age, d.id_dept, d.name_dept
            FROM TBL_EMPLOYEE E
                     INNER JOIN TBL_DEPARTMENT D on D.ID_DEPT = E.ID_DEPT
            ORDER BY ID ASC;
    END list_employees;

--     Delete
    PROCEDURE delete_employee(fn_id IN TBL_EMPLOYEE.id%TYPE)
    AS
    BEGIN
        DELETE FROM TBL_EMPLOYEE WHERE Id = fn_id;
    END delete_employee;

--     Update
    PROCEDURE update_employee(
        fn_name IN TBL_EMPLOYEE.NAME%TYPE,
        fn_age IN TBL_EMPLOYEE.AGE%TYPE,
        fn_id_dept IN TBL_EMPLOYEE.AGE%TYPE,
        fn_id IN TBL_EMPLOYEE.ID%TYPE
    ) IS

    BEGIN
        UPDATE TBL_EMPLOYEE SET name = fn_name, age = fn_age, ID_DEPT = fn_id_dept where  id = fn_id;
        COMMIT;
    END update_employee;

end EMPLOYEES_PKG;
/


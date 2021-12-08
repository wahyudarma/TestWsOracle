create or replace PACKAGE employees_pkg
AS
    --     Insert
    PROCEDURE add_employees(
        fn_id IN TBL_EMPLOYEE.ID%TYPE,
        fn_name IN TBL_EMPLOYEE.NAME%TYPE,
        fn_age IN TBL_EMPLOYEE.AGE%TYPE,
        fn_id_dept IN TBL_EMPLOYEE.ID_DEPT%TYPE
    );
--     Get By ID
    PROCEDURE search_employee_by_id (fn_id IN TBL_EMPLOYEE.ID%TYPE, fn_tblemployee OUT SYS_REFCURSOR);
--     Get All
    PROCEDURE list_employees (fn_tblemployee OUT SYS_REFCURSOR);
--     Update
    PROCEDURE update_employee (
        fn_name IN TBL_EMPLOYEE.NAME%TYPE,
        fn_age IN TBL_EMPLOYEE.AGE%TYPE,
        fn_id_dept IN TBL_EMPLOYEE.AGE%TYPE,
        fn_id IN TBL_EMPLOYEE.ID%TYPE
    );
--     Delete
    PROCEDURE delete_employee(fn_id IN TBL_EMPLOYEE.id%TYPE);

END employees_pkg;
/


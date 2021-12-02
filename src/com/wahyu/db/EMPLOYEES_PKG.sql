create PACKAGE employees_pkg
AS
--     Insert
        PROCEDURE add_employees(
        fn_id TBL_EMPLOYEE.ID%TYPE,
        fn_name TBL_EMPLOYEE.NAME%TYPE,
        fn_age TBL_EMPLOYEE.AGE%TYPE,
        fn_id_dept TBL_EMPLOYEE.ID_DEPT%TYPE
    );
--     Get By ID
   PROCEDURE cari_employees (fn_id TBL_EMPLOYEE.ID%TYPE);
--     Get All
   PROCEDURE list_employees;
--     Update
    PROCEDURE update_employee (
    fn_name TBL_EMPLOYEE.NAME%TYPE,
    fn_age TBL_EMPLOYEE.AGE%TYPE,
    fn_id_dept TBL_EMPLOYEE.AGE%TYPE,
    fn_id TBL_EMPLOYEE.ID%TYPE
    );
--     Delete
    PROCEDURE delete_employee(fn_id TBL_EMPLOYEE.id%TYPE);
END employees_pkg;
/


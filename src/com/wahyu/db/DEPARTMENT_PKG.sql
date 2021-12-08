create or replace PACKAGE department_pkg
AS
    --     Insert
    PROCEDURE add_department(
        fn_name_dept IN TBL_DEPARTMENT.NAME_DEPT%TYPE
    );
--     Get By ID
    PROCEDURE search_department_by_id(
        fn_id_dept IN TBL_DEPARTMENT.ID_DEPT%TYPE,
        fn_tbldepartment OUT SYS_REFCURSOR
    );
--     Get All
    PROCEDURE list_department (fn_tbldepartment OUT SYS_REFCURSOR);
--     Update
    PROCEDURE update_department (
        fn_name_dept IN TBL_DEPARTMENT.NAME_DEPT%TYPE,
        fn_id_dept IN TBL_DEPARTMENT.ID_DEPT%TYPE
    );
--     Delete
    PROCEDURE delete_department(fn_id_dept IN TBL_DEPARTMENT.ID_DEPT%TYPE);
END department_pkg;
/


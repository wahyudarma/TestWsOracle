create PACKAGE department_pkg
AS
--     Insert
        PROCEDURE add_department(
        fn_name_dept TBL_DEPARTMENT.NAME_DEPT%TYPE
    );
--     Get By ID
   PROCEDURE cari_department (fn_id_dept TBL_DEPARTMENT.ID_DEPT%TYPE);
--     Get All
   PROCEDURE list_department;
--     Update
    PROCEDURE update_department (
    fn_name_dept TBL_DEPARTMENT.NAME_DEPT%TYPE,
    fn_id_dept TBL_DEPARTMENT.ID_DEPT%TYPE
    );
--     Delete
    PROCEDURE delete_department(fn_id_dept TBL_DEPARTMENT.ID_DEPT%TYPE);
END department_pkg;
/


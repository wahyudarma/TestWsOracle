create or replace PACKAGE BODY department_pkg
AS
    --     Insert Department
    PROCEDURE add_department(
        fn_name_dept IN TBL_DEPARTMENT.NAME_DEPT%TYPE
    )
    AS
    BEGIN
        INSERT INTO TBL_DEPARTMENT("NAME_DEPT") VALUES (fn_name_dept);
        COMMIT;
    END add_department;
--     Get By ID
    PROCEDURE cari_department(
        fn_id_dept IN TBL_DEPARTMENT.ID_DEPT%TYPE,
        fn_tbldepartment OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN fn_tbldepartment FOR
            SELECT ID_DEPT, NAME_DEPT
            FROM TBL_DEPARTMENT
            WHERE ID_DEPT = fn_id_dept;
    END cari_department;

--      Get All
    PROCEDURE list_department(
        fn_tbldepartment OUT SYS_REFCURSOR
    )
    AS
    BEGIN
        OPEN fn_tbldepartment FOR
            SELECT ID_DEPT, NAME_DEPT
            FROM TBL_DEPARTMENT
            ORDER BY ID_DEPT ASC;
    END list_department;

--     Delete
    PROCEDURE delete_department(fn_id_dept IN TBL_DEPARTMENT.ID_DEPT%TYPE)
    AS
    BEGIN
        DELETE FROM TBL_DEPARTMENT WHERE ID_DEPT = fn_id_dept;
    END delete_department;

--     Update
    PROCEDURE update_department(
        fn_name_dept IN TBL_DEPARTMENT.NAME_DEPT%TYPE,
        fn_id_dept IN TBL_DEPARTMENT.ID_DEPT%TYPE
    )
    AS
    BEGIN
        UPDATE TBL_DEPARTMENT
        SET NAME_DEPT = fn_name_dept
        WHERE ID_DEPT = fn_id_dept;
        COMMIT;
    END update_department;

end department_pkg;
/


create PACKAGE BODY department_pkg
AS
--     Insert Department
    PROCEDURE add_department(
        fn_name_dept TBL_DEPARTMENT.NAME_DEPT%TYPE
    )
    IS
        BEGIN
            INSERT INTO TBL_DEPARTMENT(name_dept)
            VALUES (fn_name_dept);
        END add_department;
--     Get By ID
    PROCEDURE cari_department(fn_id_dept TBL_DEPARTMENT.ID_DEPT%TYPE)
    IS
        fn_name_dept TBL_DEPARTMENT.name_dept%TYPE;

        BEGIN
            SELECT NAME_DEPT
                INTO fn_name_dept
            FROM TBL_DEPARTMENT
                WHERE ID_DEPT = fn_id_dept;
                dbms_output.put_line('---------------Get Department By Id--------------------');
                DBMS_OUTPUT.PUT_LINE('id_dept       : ' || fn_id_dept);
                DBMS_OUTPUT.PUT_LINE('name_dept     : ' || fn_name_dept);
                dbms_output.put_line('-----------------------------------');

        END cari_department;

--      Get All
    PROCEDURE list_department IS
        e_id_dept TBL_DEPARTMENT.id_dept%type;
        e_name_dept TBL_DEPARTMENT.name_dept%TYPE;

   CURSOR e_department is
      SELECT id_dept, name_dept
      FROM TBL_DEPARTMENT
      ORDER BY ID_DEPT ASC ;
BEGIN
   OPEN e_department;
   dbms_output.put_line('---------------List Department--------------------');
   LOOP
   FETCH e_department into e_id_dept, e_name_dept;
      EXIT WHEN e_department%notfound;
      dbms_output.put_line('id_dept         : ' ||e_id_dept);
      dbms_output.put_line('nama_dept       : '  ||e_name_dept);
      dbms_output.put_line('-----------------------------------');
   END LOOP;
   CLOSE e_department;
END list_department;

--     Delete
    PROCEDURE delete_department(fn_id_dept TBL_DEPARTMENT.ID_DEPT%TYPE) IS
    BEGIN
        DELETE FROM TBL_DEPARTMENT WHERE ID_DEPT = fn_id_dept;
    END delete_department;

--     Update
    PROCEDURE update_department(
        fn_name_dept TBL_DEPARTMENT.NAME_DEPT%TYPE,
        fn_id_dept TBL_DEPARTMENT.ID_DEPT%TYPE
    ) IS

    BEGIN
        UPDATE TBL_DEPARTMENT SET NAME_DEPT = fn_name_dept where  ID_DEPT = fn_id_dept;
    END update_department;

end department_pkg;
/


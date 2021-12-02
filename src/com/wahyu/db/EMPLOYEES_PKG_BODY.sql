create PACKAGE BODY       EMPLOYEES_PKG
AS
--     Insert Employee
    PROCEDURE add_employees(
        fn_id TBL_EMPLOYEE.ID%TYPE,
        fn_name TBL_EMPLOYEE.NAME%TYPE,
        fn_age TBL_EMPLOYEE.AGE%TYPE,
        fn_id_dept TBL_EMPLOYEE.ID_DEPT%TYPE
    )
    IS
        BEGIN
            INSERT INTO TBL_EMPLOYEE(id, name, age, id_dept)
            VALUES (fn_id, fn_name, fn_age, fn_id_dept);
        END add_employees;
--     Get By ID
    PROCEDURE cari_employees(fn_id TBL_EMPLOYEE.ID%TYPE)
    IS
        fn_name   TBL_EMPLOYEE.name%TYPE;
        fn_age   TBL_EMPLOYEE.AGE%TYPE;
        fn_id_dept TBL_DEPARTMENT.id_dept%TYPE;
        fn_name_dept TBL_DEPARTMENT.name_dept%TYPE;

        BEGIN
            SELECT e.name, e.age, d.id_dept, d.name_dept
                INTO fn_name, fn_age, fn_id_dept, fn_name_dept
            FROM TBL_EMPLOYEE E
            INNER JOIN TBL_DEPARTMENT D on D.ID_DEPT = E.ID_DEPT
                WHERE ID = fn_id;
                dbms_output.put_line('---------------Get Employee By Id--------------------');
                DBMS_OUTPUT.PUT_LINE('id            : ' || fn_id);
                DBMS_OUTPUT.PUT_LINE('name          : ' || fn_name);
                DBMS_OUTPUT.PUT_LINE('age           : ' || fn_age);
--                 DBMS_OUTPUT.PUT_LINE('id_dept       : ' || fn_id_dept);
                DBMS_OUTPUT.PUT_LINE('name_dept     : ' || fn_name_dept);
                dbms_output.put_line('-----------------------------------');

            END cari_employees;

--      Get All
    PROCEDURE list_employees IS
        e_id TBL_EMPLOYEE.id%type;
        e_name TBL_EMPLOYEE.name%type;
        e_age TBL_EMPLOYEE.age%type;
        e_id_dept TBL_DEPARTMENT.id_dept%type;
        e_name_dept TBL_DEPARTMENT.name_dept%TYPE;

   CURSOR e_employees is
      SELECT e.id, e.name, e.age, d.id_dept, d.name_dept
      FROM TBL_EMPLOYEE E
      INNER JOIN TBL_DEPARTMENT D on D.ID_DEPT = E.ID_DEPT ORDER BY ID ASC ;
BEGIN
   OPEN e_employees;
   dbms_output.put_line('---------------List Employee--------------------');
   LOOP
   FETCH e_employees into e_id, e_name, e_age, e_id_dept, e_name_dept;
      EXIT WHEN e_employees%notfound;
      dbms_output.put_line('id              : ' ||e_id);
      dbms_output.put_line('name            : ' || e_name);
      dbms_output.put_line('age             : ' || e_age);
--       dbms_output.put_line('id_dept         : ' ||e_id_dept);
      dbms_output.put_line('nama_dept       : '  ||e_name_dept);
      dbms_output.put_line('-----------------------------------');
   END LOOP;
   CLOSE e_employees;
        END list_employees;

--     Delete
    PROCEDURE delete_employee(fn_id TBL_EMPLOYEE.id%TYPE) IS
    BEGIN
        DELETE FROM TBL_EMPLOYEE WHERE Id = fn_id;
    END delete_employee;

--     Update
    PROCEDURE update_employee(
        fn_name TBL_EMPLOYEE.NAME%TYPE,
        fn_age TBL_EMPLOYEE.AGE%TYPE,
        fn_id_dept TBL_EMPLOYEE.ID_DEPT%TYPE,
        fn_id TBL_EMPLOYEE.ID%TYPE
    ) IS

    BEGIN
        UPDATE TBL_EMPLOYEE SET name = fn_name, age = fn_age, ID_DEPT = fn_id_dept where  id = fn_id;
    END update_employee;

        end EMPLOYEES_PKG;
/


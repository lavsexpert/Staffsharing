package club.plus1.staffsharing.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert
    void create(Employee employee);

    @Query("SELECT * FROM employee")
    List<Employee> readAll();

    @Query("SELECT * FROM employee WHERE surname = :surname AND name = :name AND patronymic = :patronymic LIMIT 1")
    Employee readByFIO(String surname, String name, String patronymic);

    @Query("SELECT * FROM employee WHERE login = :login LIMIT 1")
    Employee readByLogin(String login);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);

    @Query("DELETE FROM employee")
    void deleteAll();
}

package club.plus1.staffsharing.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CompanyDao {

    @Insert
    void create(Company company);

    @Query("SELECT * FROM company")
    List<Company> readAll();

    @Query("SELECT * FROM company WHERE name = :name LIMIT 1")
    Company readByName(String name);

    @Query("SELECT * FROM company WHERE login = :login LIMIT 1")
    Company readByLogin(String login);

    @Update
    void update(Company company);

    @Delete
    void delete(Company company);

    @Query("DELETE FROM company")
    void deleteAll();
}

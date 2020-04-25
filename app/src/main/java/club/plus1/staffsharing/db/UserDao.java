package club.plus1.staffsharing.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void create(User user);

    @Query("SELECT * FROM user")
    List<User> readAll();

    @Query("SELECT * FROM user WHERE login = :login AND password = :password LIMIT 1")
    User readUser(String login, String password);

    @Query("SELECT * FROM user WHERE login = :login LIMIT 1")
    User readUser(String login);

    @Query("SELECT * FROM user LIMIT 1")
    User readLast();

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user")
    void deleteAll();
}

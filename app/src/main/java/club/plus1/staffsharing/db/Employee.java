package club.plus1.staffsharing.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Employee {

    @NonNull
    @PrimaryKey
    public String login = "";

    @ColumnInfo(name = "surname")
    public String surname;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "patronymic")
    public String patronymic;

    @ColumnInfo(name = "id")
    public String id;

    @Ignore
    @NonNull
    @Override
    public String toString(){
        return surname + " " + name + " " + patronymic;
    }
}

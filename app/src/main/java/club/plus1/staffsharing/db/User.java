package club.plus1.staffsharing.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @Ignore
    public static final int Company = 1;

    @Ignore
    public static final int Employee = 2;

    @NonNull
    @PrimaryKey
    public String login = "";

    @ColumnInfo(name = "userType")
    public int userType;

    @ColumnInfo(name = "password")
    public String password;
}

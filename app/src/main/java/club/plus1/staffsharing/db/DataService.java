package club.plus1.staffsharing.db;

import java.util.concurrent.Executors;

import club.plus1.staffsharing.common.App;

public class DataService {

    public static void restoreUser(User user){
        Executors.newSingleThreadExecutor().execute(DataService::restoreUserFromDB);
    }

    public static void saveUser(User user){
        Executors.newSingleThreadExecutor().execute(() -> DataService.saveUserToDB(user));
    }

    private static void saveUserToDB(User user){
        if (App.getDb() != null){
            if (!user.login.isEmpty()){
                App.user = App.getDb().userDao().readUser(user.login);
                if (App.user == null) {
                    App.user = new User();
                    App.user.login = user.login;
                    App.user.password = user.password;
                    App.user.userType = user.userType;
                    App.getDb().userDao().create(user);
                } else if (App.getDb().userDao().readUser(user.login, user.password) != null) {
                    App.getDb().userDao().update(user);
                }
            }
        }
    }

    private static void restoreUserFromDB(){
        App.user = App.getDb().userDao().readLast();
    }
}

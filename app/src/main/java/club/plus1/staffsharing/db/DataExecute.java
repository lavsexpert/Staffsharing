package club.plus1.staffsharing.db;

import java.util.concurrent.Executors;

public class DataExecute {


    public static void checkUser(User user){
        Executors.newSingleThreadExecutor().execute(() -> DataService.checkUser(user));
    }

    public static void restoreUser(){
        Executors.newSingleThreadExecutor().execute(DataService::restoreUserFromDB);
    }

    public static void saveUser(User user){
        Executors.newSingleThreadExecutor().execute(() -> DataService.saveUserToDB(user));
    }

    public static void restoreCompany(String login){
        Executors.newSingleThreadExecutor().execute(() -> DataService.restoreCompanyFromDB(login));
    }

    public static void saveCompany(Company company){
        Executors.newSingleThreadExecutor().execute(() -> DataService.saveCompanyToDB(company));
    }

    public static void restoreEmployee(String login){
        Executors.newSingleThreadExecutor().execute(() -> DataService.restoreEmployeeFromDB(login));
    }

    public static void saveEmployee(Employee employee){
        Executors.newSingleThreadExecutor().execute(() -> DataService.saveEmployeeToDB(employee));
    }
}

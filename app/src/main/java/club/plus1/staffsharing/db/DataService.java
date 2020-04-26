package club.plus1.staffsharing.db;

import club.plus1.staffsharing.common.App;

public class DataService {

    static void checkUser(User user){
        App.user = App.getDb().userDao().readUser(user.login, user.password);
    }

    static void saveUserToDB(User user){
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

    static void saveCompanyToDB(Company company){
        if (App.getDb() != null){
            if (!company.login.isEmpty()){
                App.company = App.getDb().companyDao().readByLogin(company.login);
                if (App.company == null) {
                    App.getDb().companyDao().create(company);
                    App.company = company;
                }
            }
        }
    }

    static void saveEmployeeToDB(Employee employee){
        if (App.getDb() != null){
            if (!employee.login.isEmpty()){
                App.employee = App.getDb().employeeDao().readByLogin(employee.login);
                if (App.employee == null) {
                    App.getDb().employeeDao().create(employee);
                    App.employee = employee;
                }
            }
        }
    }

    static void restoreUserFromDB(){
        App.user = App.getDb().userDao().readLast();
    }

    static void restoreCompanyFromDB(String login){
        App.company = App.getDb().companyDao().readByLogin(login);
    }

    static void restoreEmployeeFromDB(String login){
        App.employee = App.getDb().employeeDao().readByLogin(login);
    }

}

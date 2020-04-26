package club.plus1.staffsharing.ui.reg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.common.App;
import club.plus1.staffsharing.db.Company;
import club.plus1.staffsharing.db.DataExecute;
import club.plus1.staffsharing.db.DataService;
import club.plus1.staffsharing.db.Employee;
import club.plus1.staffsharing.db.User;
import club.plus1.staffsharing.ui.ProfileActivity;

public class RegActivity extends AppCompatActivity {

    EditText editLogin;
    EditText editPassword;
    EditText editRepeat;
    ViewPager viewPager;
    List<RegFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        fragments = new ArrayList<>();
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new RegFragmentAdapter(getSupportFragmentManager(), fragments));
        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        setTitle(getString(R.string.reg_title));
        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        editRepeat = findViewById(R.id.editRepeat);
    }

    public void onCompanySave(View view){
        if (editPassword.getText().toString().equals(editRepeat.getText().toString())){
            App.user = new User();
            if (editLogin.getText().toString().equals("admin")){
                App.user.userType = User.Admin;
            } else {
                App.user.userType = User.Company;
            }
            App.user.login = editLogin.getText().toString();
            App.user.password = editPassword.getText().toString();
            DataExecute.saveUser(App.user);
            App.company = new Company();
            App.company.login = App.user.login;
            App.company.name = fragments.get(0).editCompanyName.getText().toString();
            App.company.id = fragments.get(0).editCompanyId.getText().toString();
            DataExecute.saveCompany(App.company);
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else {
            String message = getString(R.string.error_reg_password_and_repeat_not_equal);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    public void onEmployeeSave(View view){
        if (editPassword.getText().toString().equals(editRepeat.getText().toString())){
            App.user = new User();
            if (editLogin.getText().toString().equals("admin")){
                App.user.userType = User.Admin;
            } else {
                App.user.userType = User.Employee;
            }
            App.user.login = editLogin.getText().toString();
            App.user.password = editPassword.getText().toString();
            DataExecute.saveUser(App.user);
            App.employee = new Employee();
            App.employee.login = App.user.login;
            App.employee.surname = fragments.get(1).editEmployeeSurname.getText().toString();
            App.employee.name = fragments.get(1).editEmployeeName.getText().toString();
            App.employee.patronymic = fragments.get(1).editEmployeePatronymic.getText().toString();
            App.employee.id = fragments.get(1).editEmployeeId.getText().toString();
            DataExecute.saveEmployee(App.employee);
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else {
            String message = getString(R.string.error_reg_password_and_repeat_not_equal);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}

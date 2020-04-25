package club.plus1.staffsharing.ui.reg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.common.App;
import club.plus1.staffsharing.db.DataService;
import club.plus1.staffsharing.db.User;
import club.plus1.staffsharing.ui.ProfileActivity;

public class RegActivity extends AppCompatActivity {

    EditText editLogin;
    EditText editPassword;
    EditText editRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        ViewPager viewPager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab);
        viewPager.setAdapter(new RegFragmentAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        setTitle(getString(R.string.reg_title));
        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        editRepeat = findViewById(R.id.editRepeat);
    }

    public void onCompanySave(View view){
        if (editPassword.getText().toString().equals(editRepeat.getText().toString())){
            App.user = new User();
            App.user.userType = User.Company;
            App.user.login = editLogin.getText().toString();
            App.user.password = editPassword.getText().toString();
            DataService.saveUser(App.user);
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
            App.user.userType = User.Employee;
            App.user.login = editLogin.getText().toString();
            App.user.password = editPassword.getText().toString();
            DataService.saveUser(App.user);
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else {
            String message = getString(R.string.error_reg_password_and_repeat_not_equal);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}

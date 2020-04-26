package club.plus1.staffsharing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.common.App;
import club.plus1.staffsharing.db.DataExecute;
import club.plus1.staffsharing.db.User;
import club.plus1.staffsharing.ui.offer.OfferActivity;
import club.plus1.staffsharing.ui.reg.RegActivity;
import club.plus1.staffsharing.ui.staff.StaffActivity;
import club.plus1.staffsharing.ui.work.WorkActivity;

public class EnterActivity extends AppCompatActivity {

    EditText editLogin;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
        setTitle(getString(R.string.enter_title));

        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);

        App.user = new User();
        DataExecute.restoreUser();
        editLogin.setText(App.user.login);
        editPassword.setText(App.user.password);
    }

    public void onStaff(View view){
        Intent intent = new Intent(this, StaffActivity.class);
        startActivity(intent);
    }

    public void onWork(View view){
        Intent intent = new Intent(this, WorkActivity.class);
        startActivity(intent);
    }

    public void onOffer(View view){
        Intent intent = new Intent(this, OfferActivity.class);
        startActivity(intent);
    }

    public void onReg(View view){
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }

    public void onEnter(View view){
        User user = new User();
        user.login = editLogin.getText().toString();
        user.password = editPassword.getText().toString();
        if (user.login.equals("admin")){
            user.userType = User.Admin;
            App.user = user;
        } else {
            DataExecute.checkUser(user);
        }
        if (App.user != null){
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else {
            String message;
            if (editLogin.getText().toString().isEmpty() || editPassword.getText().toString().isEmpty()){
                message = getString(R.string.error_enter_login_or_password_is_empty);
            } else {
                message = getString(R.string.error_enter_user_not_registered);
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}

package club.plus1.staffsharing.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.common.App;
import club.plus1.staffsharing.db.Company;
import club.plus1.staffsharing.db.DataExecute;
import club.plus1.staffsharing.db.User;

public class ProfileActivity extends AppCompatActivity {

    TextView textLogin;
    TextView textType;
    TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        textLogin = findViewById(R.id.textLogin);
        textType = findViewById(R.id.textType);
        textName = findViewById(R.id.textName);
        textLogin.setText(App.user.login);
        if (App.user.userType == User.Admin) {
            textType.setText("Администратор");
        } else if (App.user.userType == User.Company){
            textType.setText("Компания");
            DataExecute.restoreCompany(App.user.login);
            //textName.setText(App.company.toString());
        } else if (App.user.userType == User.Employee){
            textType.setText("Специалист");
            DataExecute.restoreEmployee(App.user.login);
            //textName.setText(App.employee.toString());
        }
        setTitle(getString(R.string.profile_title));
    }
}

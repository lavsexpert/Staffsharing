package club.plus1.staffsharing.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.common.App;
import club.plus1.staffsharing.db.User;

public class ProfileActivity extends AppCompatActivity {

    TextView textLogin;
    TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        textLogin = findViewById(R.id.textLogin);
        textName = findViewById(R.id.textName);
        textLogin.setText(App.user.login);
        if (App.user.userType == User.Company){
            textName.setText("Компания");
        } else if (App.user.userType == User.Employee){
            textName.setText("Специалист");
        }
        setTitle(getString(R.string.profile_title));
    }
}

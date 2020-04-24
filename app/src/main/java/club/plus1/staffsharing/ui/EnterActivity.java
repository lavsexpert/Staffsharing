package club.plus1.staffsharing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import club.plus1.staffsharing.R;

public class EnterActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText editLogin;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
        radioGroup = findViewById(R.id.radioGroup);
        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        setTitle(getString(R.string.enter_title));
    }

    public void onRegister(View view){
        Intent intent;
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radioCompany:
                intent = new Intent(this, CompanyActivity.class);
                break;
            case R.id.buttonRegister:
                intent = new Intent(this, EmployeeActivity.class);
                break;
            default:
                intent = new Intent(this, EmployeeActivity.class);
                break;
        }
        startActivity(intent);
    }

    public void onEnter(View view){
        Intent intent;
        int page = (int)(Math.random() * 100) % 2;
        if (page == 0) {
            intent = new Intent(this, CompanyActivity.class);
        } else {
            intent = new Intent(this, EmployeeActivity.class);
        }
        startActivity(intent);
    }
}

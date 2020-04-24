package club.plus1.staffsharing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.ui.offer.OfferActivity;
import club.plus1.staffsharing.ui.staff.StaffActivity;
import club.plus1.staffsharing.ui.work.WorkActivity;

public class EnterActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        setTitle(getString(R.string.enter_title));
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

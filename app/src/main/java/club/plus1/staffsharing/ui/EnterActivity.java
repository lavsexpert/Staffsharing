package club.plus1.staffsharing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.ui.offer.OfferActivity;
import club.plus1.staffsharing.ui.reg.RegActivity;
import club.plus1.staffsharing.ui.staff.StaffActivity;
import club.plus1.staffsharing.ui.work.WorkActivity;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
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

    public void onReg(View view){
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }

    public void onEnter(View view){
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }
}

package sereen.awad.safinalproject.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sereen.awad.safinalproject.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText etFullName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhone;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etFullName = findViewById(R.id.etFullName);
        etEmail= findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhone= findViewById(R.id.etPhone);
        btnRegister =findViewById(R.id.btnRegister);
    }
    public void onClickNextS(View v) {//نضع اسم الشاشة الحالية وبعدها اسم الشاشة التي ننتقل اليها
        Intent i = new Intent(RegisterActivity.this, SignInActivity.class);
        //تفعيل نشاط/شاشة جديدة بواسطة Intent
        startActivity(i);
    }
}
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
import androidx.lifecycle.ViewModelProvider;

import sereen.awad.safinalproject.R;
import sereen.awad.safinalproject.ViewModel.UserViewModel;
import sereen.awad.safinalproject.model.MyUserTable.MyUser;
import sereen.awad.safinalproject.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {
    private EditText etFullName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhone;
    private Button btnRegister;
    private UserViewModel userViewModel;
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
        btnRegister .setOnClickListener(v -> RegisterUser());
        userViewModel =new ViewModelProvider(this).get(UserViewModel.class);
    }
    private void RegisterUser() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        String phone = etPhone.getText().toString().trim();
        if (fullName.isEmpty()) {
            etFullName.setError("Full name is required");
            etFullName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            etPhone.setError("Phone number is required");
            etPhone.requestFocus();
            return;
        }
        if (password.length() < 8) {
            etPassword.setError("Password must be at least 8 characters");
            etPassword.requestFocus();
            return;
        }
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }

        if (!hasLetter || !hasDigit) {
            etPassword.setError("Password must include both letters and numbers");
            etPassword.requestFocus();
            return;
        }
    }
   /** if (!etPhone.matches("\\d{9,10}")) {
        etPhone.setError("Please enter a valid phone number");
        etPhone.requestFocus();
        return;
    }*/
    if (UserViewModel.isEmailExists(email)) {
        etEmail.setError("This email is already registered");
        etEmail.requestFocus();
        return;
    }}
    /**
    public boolean isEmailExists(String etEmail) {
        MyUser user = UserRepository.getUserByEmail(etEmail).getValue();
        if (user != null) {
            return true;  // الإيميل موجود مسبقاً في قاعدة البيانات
        } else {
            return false; // الإيميل جديد وغير مسجل من قبل
        }
    }*/
    public void onClickNextS(View v) {//نضع اسم الشاشة الحالية وبعدها اسم الشاشة التي ننتقل اليها
        Intent i = new Intent(RegisterActivity.this,SignInActivity.class);
        //تفعيل نشاط/شاشة جديدة بواسطة Intent
        startActivity(i);
    }
}
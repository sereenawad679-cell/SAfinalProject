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

import java.util.regex.Pattern;

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
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhone = findViewById(R.id.etPhone);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> RegisterUser());
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
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


        // 3. استعمال العمليات التابعة لـ UserViewModel لفحص الإيميل وإضافة المستعمل MyUser
            if (userViewModel.checkEmail(email) != null) {
                etEmail.setError("This email is already registered");
                etEmail.requestFocus();
                return;
            } else {
                MyUser user = new MyUser();
                user.setFullName(fullName);
                user.setEmail(email);
                user.setPassw(password);
                user.setPhone(phone);
                userViewModel.insert(user);
//            Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
//            startActivity(intent);
                finish();
            }
        }
    // 1. فحص البريد الإلكتروني
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return Pattern.matches(emailPattern, email);
    }

    // 2. فحص رقم الهاتف المحمول الإسرائيلي (محلي أو دولي)
    public static boolean isValidIsraeliMobile(String phone) {
        if (phone == null) return false;
        String israeliMobilePattern = "^(?:\\+?972|0)?5[0-9]-?[0-9]{7}$";
        return Pattern.matches(israeliMobilePattern, phone);
    }

    // 3. فحص كلمة المرور
    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(passwordPattern, password);
    }
//    public void onClickNextS(View v) {//نضع اسم الشاشة الحالية وبعدها اسم الشاشة التي ننتقل اليها
//        Intent i = new Intent(RegisterActivity.this, SignInActivity.class);
//        //تفعيل نشاط/شاشة جديدة بواسطة Intent
//        startActivity(i);
//    }

    }



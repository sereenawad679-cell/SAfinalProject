package sereen.awad.safinalproject.ViewPkg;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import sereen.awad.safinalproject.R;
import sereen.awad.safinalproject.ViewModel.UserViewModel;
import sereen.awad.safinalproject.model.MyUserTable.MyUser;

/*
 * شاشة تسجيل الدخول (SignInActivity)
 * تتيح للمستخدم تسجيل الدخول إلى التطبيق باستخدام البريد الإلكتروني وكلمة المرور.
 */
public class SignInActivity extends AppCompatActivity {

    // 1. تعريف الصفات (Variables) الخاصة بشاشة تسجيل الدخول
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private UserViewModel userViewModel;
    /*
     * تجهيز صفه ل ViewModel الملائم.
     * يستدعى عند إنشاء النشاط.
     * وتفعيل زر تسجيل الدخول، {@link ViewModel} يقوم بربط العناصر الرسومية، تهيئة
     *
     * @param savedInstanceState الحالة المحفوظة للنشاط إن وجدت.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ربط المتغيرات بعناصر التصميم في XML بواسطة الـ ID
        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        signInButton = findViewById(R.id.btn_sign_in);
        signInButton.setOnClickListener(v -> signInUser());
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }
    /*
     يقوم بالتحقق من صحة الحقول المدخلة، استدعاء عملية تسجيل الدخول
     عند النجاح MainActivity والانتقال لـ Toast وإدارة النتيجة (نجاح أو فشل) عبر
     */

    private void signInUser() {
        //استخراج فحوى الحقول
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
//فحص سلامة المدخلات
        if (email.isEmpty()) {
            emailEditText.setError("Email is required");
            emailEditText.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            passwordEditText.setError("Password is required");
            passwordEditText.requestFocus();
            return;
        }
/*استعمال عملية checkEmailPassw
 * التابعة لuserViewModel
 * الخاص بالمستعملMyUser والتي تعيد null إن لم يكن المستعمل موجودا حسب الايميل وكلمة السر
 * */

        MyUser user = (MyUser) userViewModel.checkEmailPassw(email, password);
        if (user != null) {
            Toast.makeText(this, "Welcome, " + user.getFullName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

}

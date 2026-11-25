package sereen.awad.safinalproject.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sereen.awad.safinalproject.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            });
/*في ملف الجافا الخاص بالشاشة، نستخدم Handler للانتظار لمدة ثانيتين ونصف (2500 مللي ثانية)
 ثم ننتقل عبر Intent إلى SignInActivity
ونستدعي finish() حتى لا يعود المستخدم إليها عند الضغط على زر الرجوع*/
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                Intent intent = new Intent(SplashScreenActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }, 1250);
        }
    }
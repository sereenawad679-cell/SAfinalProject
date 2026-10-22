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

public class AddTaskActivity extends AppCompatActivity {
    private EditText etTitle;
    private EditText etDescribtion;
    private View etPriority;
    private Button btnSaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etTitle = findViewById(R.id.etTitle);
        etDescribtion = findViewById(R.id.etDescribtion);
        etPriority = findViewById(R.id.etPriority);
        btnSaveTask = findViewById(R.id.btnSaveTask);
    }

    public void onClickNext(View v) {//نضع اسم الشاشة الحالية وبعدها اسم الشاشة التي ننتقل اليها
        Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
        //تفعيل نشاط/شاشة جديدة بواسطة Intent
        startActivity(i);
    }
}
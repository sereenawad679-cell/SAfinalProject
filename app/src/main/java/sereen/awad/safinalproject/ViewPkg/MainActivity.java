package sereen.awad.safinalproject.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sereen.awad.safinalproject.R;
import sereen.awad.safinalproject.model.AppDatabase;
import sereen.awad.safinalproject.model.MySubjectTable.MySubject;
import sereen.awad.safinalproject.model.MySubjectTable.MySubjectQuery;

public class MainActivity extends AppCompatActivity {
    private Button btnAddTaskScreen;
    private Button btnRegisterScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //بناء قاعدة بيانات وارجاع مؤشر عليها 1
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        //مؤشر لكائن عمليات لجدول 2
        MySubjectQuery subjectQuery=db.getMySubjectQuery();
        //بناء كائن من نوع الجدول وتحديد قيم الصفات 3
        MySubject s1=new MySubject();
        s1.setTitle("Math");
        MySubject s2 =new MySubject();
        s2.title="Computer";
        //إضافة كائن للجدول 4
        subjectQuery.insert(s1);
        subjectQuery.insert(s2);


        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnAddTaskScreen = findViewById(R.id.btnAddTaskScreen);
        btnRegisterScreen = findViewById(R.id.btnRegisterScreen);
    }
    public void onClickNextT(View v) {//نضع اسم الشاشة الحالية وبعدها اسم الشاشة التي ننتقل اليها
        Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
        //تفعيل نشاط/شاشة جديدة بواسطة Intent
        startActivity(i);
    }
    public void onClickNextR(View v) {//نضع اسم الشاشة الحالية وبعدها اسم الشاشة التي ننتقل اليها
        Intent i = new Intent(MainActivity.this, RegisterActivity.class);
        //تفعيل نشاط/شاشة جديدة بواسطة Intent
        startActivity(i);
    }
}
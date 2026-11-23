package sereen.awad.safinalproject.ViewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        AppDatabase db = AppDatabase.getDB(getApplicationContext());
        //مؤشر لكائن عمليات لجدول 2
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
        //بناء كائن من نوع الجدول وتحديد قيم الصفات 3
        MySubject s1 = new MySubject();
        s1.setTitle("Math");
        MySubject s2 = new MySubject();
        s2.title = "Computer";
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

    @Override//بناء القائمة
    //استعمال كائن بناء القائمة get
    //inflate دالة بناء وفتح القائمة
    //اسم ملف القائمةmain_menu
    public boolean onCreateOptionsMenu(Menu menu) {//دهس عملية بناء القائمة (من دوال دورة حياة النشاط)
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override//معالجة حدث اختيار عنصر من القائمة
    //العنصر الذي تم الضغط عليه من القائمةitem
    //(if) فحص من العنصر الذي تم اختياره حسب ال id
    //مقطع رد الفعل لحدث الضغط على العنصر
    public boolean onOptionsItemSelected(MenuItem item) {//دهس عملية معالجة حدث اختيار من القائمة
        if (item.getItemId() == R.id.itemSettings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itemSignOut) {
            Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,SignOutActivity.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.itemHistory) {
            Toast.makeText(this, "History", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(MainActivity.this,HistoryActivity.class);
            startActivity(i);
        }
        return true;
    }
}
package sereen.awad.safinalproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sereen.awad.safinalproject.data.AppDatabase;
import sereen.awad.safinalproject.data.MySubjectTable.MySubject;
import sereen.awad.safinalproject.data.MySubjectTable.MySubjectQuery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //بناء قاعدة بيانات وارجاع مؤشر عليها 1
        AppDatabase db=AppDatabase.getDB(getApplicationContext());
        //مؤشر لكائن عمليات لجدول 2
        MySubjectQuery subjectQuery=db.getMySubjectQuery();
        //بناء كائن من نوع الجدول وتحديد قيم الصفات 3
        //إضافة كائن للجدول 4
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
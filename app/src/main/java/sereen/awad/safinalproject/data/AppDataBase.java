package sereen.awad.safinalproject.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import sereen.awad.safinalproject.data.MySubjectTable.MySubject;
import sereen.awad.safinalproject.data.MySubjectTable.MySubjectQuery;
import sereen.awad.safinalproject.data.MyTaskTable.MyTask;
import sereen.awad.safinalproject.data.MyTaskTable.MyTaskQuery;
import sereen.awad.safinalproject.data.MyUserTable.MyUser;
import sereen.awad.safinalproject.data.MyUserTable.MyUserQuery;

/*
تعريف الجداول ورقم الاصدار
version
عند تغيير اي شي يخص جدول او داول علينا تغيير رقم الاصدار يتم بناء قاعدة البيانات من جديد
*/
@Database(entities = {MyUser.class, MySubject.class, MyTask.class},version = 1)
/**
 الفئة المسؤولة عن بناء قاعدة البيانات بكل جداولها
 وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
public abstract class AppDatabase extends RoomDatabase {
    /**
     كائن للتعامل مع قاعدة البيانات
     */
    private static AppDatabase db;
    /**
     يعيد كائن لعمليات جدول المستعملين
     @return
     */
    public abstract MyUserQuery getUserQuery();
    /**
     يعيد كائن لعمليات جدول الموضع
     @return
     */
    public abstract MySubjectQuery getMySubjectQuery();
    /**
     يعيد كائن لعمليات جدول المهمات
     @return
     */
    public abstract MyTaskQuery getMyTaskQuery();

    /**
     بناء قاعدة البيانات واعادة كائن يؤشر عليها
     @param context
     @return
     */
    public static AppDatabase getDB(Context context){
        if(db==null)
        {
            db = RoomDatabase.databaseBuilder(context, AppDatabase.class, "SereenDataBase")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }
}

package sereen.awad.safinalproject.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import sereen.awad.safinalproject.model.MyDressTable.MyDress;
import sereen.awad.safinalproject.model.MyDressTable.MyDressQuery;
import sereen.awad.safinalproject.model.MySubjectTable.MySubject;
import sereen.awad.safinalproject.model.MySubjectTable.MySubjectQuery;
import sereen.awad.safinalproject.model.MyTaskTable.MyTask;
import sereen.awad.safinalproject.model.MyTaskTable.MyTaskQuery;
import sereen.awad.safinalproject.model.MyUserTable.MyUser;
import sereen.awad.safinalproject.model.MyUserTable.MyUserQuery;

/*
تعريف الجداول ورقم الاصدار
version
عند تغيير اي شي يخص جدول او داول علينا تغيير رقم الاصدار يتم بناء قاعدة البيانات من جديد
*/
/**
 الفئة المسؤولة عن بناء قاعدة البيانات بكل جداولها
 وتوفر لنا كائن للتعامل مع قاعدة البيانات
 */
@Database(entities = {MyUser.class, MySubject.class, MyTask.class, MyDress.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    /**
     * كائن للتعامل مع قاعدة البيانات
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
     يعيد كائن لعمليات جدول الفساتين
     @return
     */
    public abstract MyDressQuery getMyDressQuery();

    /**
     بناء قاعدة البيانات واعادة كائن يؤشر عليها
     @param context
     @return
     */
    public static AppDatabase getDB(Context context){
        if(db==null)
        {
            db = Room.databaseBuilder(context, AppDatabase.class, "SereenDataBase")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }
}

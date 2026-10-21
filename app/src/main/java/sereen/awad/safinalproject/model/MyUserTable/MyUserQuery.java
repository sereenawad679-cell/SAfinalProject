package sereen.awad.safinalproject.model.MyUserTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * واجهة تحوي عمليات\دوال\استعلامات على قاعدة البيانات
 */
@Dao//لتحديد ان الواجهة تحتوي استعلامات على قاعدة بيانات
public interface MyUserQuery
{   //استخراج جميع المستعملين
@Query("SELECT*FROM MyUser")
    List<MyUser> getAll();
    // استخراج مستعمل حسب رقم المميز لهid
@Query("SELECT * FROM MyUser WHERE keyid IN (:userIds)")
    List<MyUser> loadAllByIds(int[] userIds);
    //هل المستعمل موجود حسب الايميل وكلمة السر
@Query("SELECT * FROM MyUser WHERE email =:myEmail AND passw = :myPassw LIMIT 1")
    List<MyUser> checkEmailPassw(String myEmail, String myPassw);
    //فحص هل الايميل موجود من قبل
    @Query("SELECT * FROM MyUser WHERE email = :myEmail LIMIT 1")
    MyUser checkEmail(String myEmail);
    // اضافة مستعمل او مجموعة مستعملين
@Insert
    void insertAll(MyUser... users);
    // حذف
    @Delete
    void delete();
    //حذف حسب الرقم المميز id
    @Query("Delete From MyUser WHERE keyid=:id ")

    void delete(int id);
    //اضافة مستعمل واحد
@Insert
    void insert(MyUser myUser);
    //تعديل مستعمل او قائمة مستعملين
@Update
    void update(MyUser...values);
    @Query("SELECT * FROM MyUser WHERE keyid=:keyId")

    LiveData<List<MyUser>> getUserByKeyId(long keyId);
    @Query("SELECT * FROM MyUser WHERE full_name=:fullName")

    LiveData<MyUser> getUserByfullName(String fullName);
    @Query("SELECT * FROM MyUser WHERE email=:email")

    LiveData<MyUser> getUserByemail( String email);
    @Query("SELECT * FROM MyUser WHERE Phone=:Phone")

    LiveData<MyUser> getUserByPhone(String Phone);
    @Query("SELECT * FROM MyUser WHERE passw=:passw")

    LiveData<MyUser> getUserBypassw(String passw);
@Delete
    void deleteByKeyId(long keyId);
}

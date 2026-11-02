package sereen.awad.safinalproject.model.MyUserTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * واجهة استعلامات جدول المستخدمين (MyUserQuery)
 * توفر العمليات والتعاملات الأساسية مع قاعدة البيانات الخاصة بالمستخدمين (CRUD Operations).
 */
@Dao
public interface MyUserQuery {

    /**
     * استخراج جميع المستخدمين من قاعدة البيانات كـ LiveData للمراقبة التلقائية.
     * @return قائمة بجميع المستخدمين.
     */
    @Query("SELECT * FROM MyUser")
    LiveData<List<MyUser>> getAllUsers();

    /**
     * استخراج مستخدم معين بناءً على معرفه الفريد (Key ID) كـ LiveData.
     * @param keyId معرف المستخدم.
     * @return كائن المستخدم المطلوب.
     */
    @Query("SELECT * FROM MyUser WHERE keyid = :keyId")
    LiveData<MyUser> getUserById(long keyId);

    /**
     * البحث عن مستخدمين حسب الاسم الكامل.
     * @param fullName الاسم الكامل.
     * @return قائمة المستخدمين المطابقة.
     */
    @Query("SELECT * FROM MyUser WHERE full_name = :fullName")
    LiveData<List<MyUser>> getUsersByFullName(String fullName);

    /**
     * البحث عن مستخدم حسب البريد الإلكتروني.
     * @param email البريد الإلكتروني.
     * @return المستخدم المطلوب.
     */
    @Query("SELECT * FROM MyUser WHERE email = :email")
    LiveData<MyUser> getUserByEmail(String email);

    /**
     * البحث عن مستخدمين حسب رقم الهاتف.
     * @param phone رقم الهاتف.
     * @return قائمة المستخدمين المطابقة.
     */
    @Query("SELECT * FROM MyUser WHERE Phone = :phone")
    LiveData<List<MyUser>> getUsersByPhone(String phone);

    /**
     * التحقق من وجود المستخدم عبر البريد الإلكتروني وكلمة المرور.
     * @param email البريد الإلكتروني.
     * @param passw كلمة المرور.
     * @return قائمة تحتوي على المستخدم إن وجد.
     */
    @Query("SELECT * FROM MyUser WHERE email = :email AND passw = :passw LIMIT 1")
    List<MyUser> checkEmailPassw(String email, String passw);

    /**
     * فحص هل البريد الإلكتروني مسجل مسبقاً.
     * @param email البريد الإلكتروني.
     * @return كائن المستخدم إن وجد، أو null.
     */
    @Query("SELECT * FROM MyUser WHERE email = :email LIMIT 1")
    MyUser checkEmail(String email);

    /**
     * إدراج مستخدم أو مجموعة مستخدمين.
     * @param users المستخدمون المراد إضافتهم.
     */
    @Insert
    void insertUser(MyUser... users);

    /**
     * تحديث بيانات مستخدم أو مجموعة مستخدمين.
     * @param users المستخدمون المراد تحديثهم.
     */
    @Update
    void updateUser(MyUser... users);

    /**
     * حذف مستخدم أو مجموعة مستخدمين.
     * @param users المستخدمون المراد حذفهم.
     */
    @Delete
    void deleteUser(MyUser... users);

    /**
     * حذف مستخدم حسب الرقم المميز (Key ID).
     * @param keyId معرف المستخدم.
     */
    @Query("DELETE FROM MyUser WHERE keyid = :keyId")
    void deleteUserById(long keyId);
}

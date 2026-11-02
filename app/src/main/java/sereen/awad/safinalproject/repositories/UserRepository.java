package sereen.awad.safinalproject.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import sereen.awad.safinalproject.model.AppDatabase;
import sereen.awad.safinalproject.model.MyUserTable.MyUser;
import sereen.awad.safinalproject.model.MyUserTable.MyUserQuery;

/**
 * مستودع المستخدمين (UserRepository)
 * يعمل كطبقة وسيطة ومنظمة للوصول إلى بيانات المستخدمين (MyUser).
 * يقوم بفصل قاعدة البيانات Room و {@link MyUserQuery} عن بقية أجزاء التطبيق (ViewModels).
 */
public class UserRepository {
    private final MyUserQuery userQuery; // واجهة الاستعلامات
    private final LiveData<List<MyUser>> allUsers; // قائمة جميع المستخدمين

    /**
     * منشئ الكلاس (Constructor)
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمستخدمين.
     *
     * @param application سياق التطبيق (Application Context).
     */
    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDB(application);
        userQuery = db.getUserQuery();
        allUsers = userQuery.getAllUsers();
    }

    /**
     * جلب جميع المستخدمين الموجودين في قاعدة البيانات كـ LiveData.
     *
     * @return قائمة بجميع المستخدمين المحدثة تلقائياً.
     */
    public LiveData<List<MyUser>> getAllUsers() {
        return allUsers;
    }

    /**
     * جلب مستخدم معين بناءً على معرفه الفريد (Key ID).
     *
     * @param keyId معرف المستخدم.
     * @return كائن المستخدم المطلوب كـ LiveData.
     */
    public LiveData<MyUser> getUserById(long keyId) {
        return userQuery.getUserById(keyId);
    }

    /**
     * البحث عن مستخدمين حسب الاسم الكامل.
     *
     * @param fullName الاسم الكامل للبحث عنه.
     * @return قائمة المستخدمين المطابقة.
     */
    public LiveData<List<MyUser>> getUsersByFullName(String fullName) {
        return userQuery.getUsersByFullName(fullName);
    }

    /**
     * جلب مستخدم حسب البريد الإلكتروني.
     *
     * @param email البريد الإلكتروني.
     * @return المستخدم المطلوب كـ LiveData.
     */
    public LiveData<MyUser> getUserByEmail(String email) {
        return userQuery.getUserByEmail(email);
    }

    /**
     * البحث عن مستخدمين حسب رقم الهاتف.
     *
     * @param phone رقم الهاتف.
     * @return قائمة المستخدمين المطابقة.
     */
    public LiveData<List<MyUser>> getUsersByPhone(String phone) {
        return userQuery.getUsersByPhone(phone);
    }

    /**
     * التحقق من البريد الإلكتروني وكلمة المرور لتسجيل الدخول.
     *
     * @param email البريد الإلكتروني.
     * @param passw كلمة المرور.
     * @return قائمة تحتوي على المستخدم إن وجد.
     */
    public List<MyUser> checkEmailPassw(String email, String passw) {
        return userQuery.checkEmailPassw(email, passw);
    }

    /**
     * فحص هل البريد الإلكتروني مسجل مسبقاً.
     *
     * @param email البريد الإلكتروني.
     * @return كائن المستخدم إن وجد.
     */
    public MyUser checkEmail(String email) {
        return userQuery.checkEmail(email);
    }

    /**
     * إدراج مستخدم أو عدة مستخدمين جدد في قاعدة البيانات.
     *
     * @param users المستخدمون المراد إضافتهم.
     */
    public void insert(MyUser... users) {
        userQuery.insertUser(users);
    }

    /**
     * تحديث بيانات مستخدم أو عدة مستخدمين.
     *
     * @param users المستخدمون المراد تحديثهم.
     */
    public void update(MyUser... users) {
        userQuery.updateUser(users);
    }

    /**
     * حذف مستخدم أو عدة مستخدمين من قاعدة البيانات.
     *
     * @param users المستخدمون المراد حذفهم.
     */
    public void delete(MyUser... users) {
        userQuery.deleteUser(users);
    }

    /**
     * حذف مستخدم محدد باستخدام معرفه الفريد (Key ID).
     *
     * @param keyId معرف المستخدم المراد حذفه.
     */
    public void deleteUserById(long keyId) {
        userQuery.deleteUserById(keyId);
    }
}

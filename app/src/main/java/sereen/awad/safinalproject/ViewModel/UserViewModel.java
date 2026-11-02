package sereen.awad.safinalproject.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import sereen.awad.safinalproject.model.MyUserTable.MyUser;
import sereen.awad.safinalproject.repositories.UserRepository;

/*
 * نموذج عرض المستخدمين (UserViewModel)
 * مسئول عن تجهيز وإدارة البيانات المتعلقة بالمستخدمين (MyUser) لصالح واجهات المستخدم (Views/Activities).
 * يقوم بالاحتفاظ بالبيانات وتجاوز عمليات إعادة إنشاء النشاط (Configuration Changes)
 * ويتعامل مع {@link UserRepository} لتنفيذ العمليات المختلفة.
 */
public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;
    private final LiveData<List<MyUser>> allUsers;

    /*
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة المستودع (UserRepository) وجلب قائمة جميع المستخدمين الأولية.
     *
     * @param application سياق التطبيق (Application Context) الممرر للـ AndroidViewModel.
     */
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
    }

    /*
     * جلب جميع المستخدمين كـ LiveData لمراقبتها من واجهة المستخدم.
     *
     * @return قائمة بجميع المستخدمين محدثة تلقائياً.
     */
    public LiveData<List<MyUser>> getAllUsers() {
        return allUsers;
    }

    /*
     * جلب مستخدم معين بناءً على معرفه الفريد (Key ID).
     *
     * @param keyId معرف المستخدم الفريد.
     * @return كائن المستخدم المطلوب.
     */
    public LiveData<MyUser> getUserById(long keyId) {
        return repository.getUserById(keyId);
    }

    /*
     * جلب مستخدم حسب البريد الإلكتروني.
     *
     * @param email البريد الإلكتروني.
     * @return المستخدم المطلوب كـ LiveData.
     */
    public LiveData<MyUser> getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }

    /*
     * البحث عن مستخدمين حسب الاسم الكامل.
     *
     * @param fullName الاسم الكامل.
     * @return قائمة المستخدمين المطابقة.
     */
    public LiveData<List<MyUser>> getUsersByFullName(String fullName) {
        return repository.getUsersByFullName(fullName);
    }

    /*
     * البحث عن مستخدمين حسب رقم الهاتف.
     *
     * @param phone رقم الهاتف.
     * @return قائمة المستخدمين المطابقة.
     */
    public LiveData<List<MyUser>> getUsersByPhone(String phone) {
        return repository.getUsersByPhone(phone);
    }

    /*
     * التحقق من البريد الإلكتروني وكلمة المرور لتسجيل الدخول.
     *
     * @param email البريد الإلكتروني.
     * @param passw كلمة المرور.
     * @return قائمة تحتوي على المستخدم إن وجد.
     */
    public List<MyUser> checkEmailPassw(String email, String passw) {
        return repository.checkEmailPassw(email, passw);
    }

    /*
     * فحص هل البريد الإلكتروني مسجل مسبقاً.
     *
     * @param email البريد الإلكتروني.
     * @return كائن المستخدم إن وجد.
     */
    public MyUser checkEmail(String email) {
        return repository.checkEmail(email);
    }

    /*
     * إدراج مستخدم أو عدة مستخدمين جدد عبر المستودع.
     *
     * @param users المستخدمون المراد إضافتهم.
     */
    public void insert(MyUser... users) {
        repository.insert(users);
    }

    /*
     * تحديث بيانات مستخدم أو عدة مستخدمين عبر المستودع.
     *
     * @param users المستخدمون المراد تحديثهم.
     */
    public void update(MyUser... users) {
        repository.update(users);
    }

    /*
     * حذف مستخدم أو عدة مستخدمين عبر المستودع.
     *
     * @param users المستخدمون المراد حذفهم.
     */
    public void delete(MyUser... users) {
        repository.delete(users);
    }

    /*
     * حذف مستخدم محدد باستخدام معرفه الفريد (Key ID).
     *
     * @param keyId معرف المستخدم المراد حذفه.
     */
    public void deleteUserById(long keyId) {
        repository.deleteUserById(keyId);
    }
}

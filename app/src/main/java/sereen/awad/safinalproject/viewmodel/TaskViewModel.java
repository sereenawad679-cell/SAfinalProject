package sereen.awad.safinalproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import sereen.awad.safinalproject.model.MyTaskTable.MyTask;
import sereen.awad.safinalproject.repositories.TaskRepository;

/*
 * نموذج عرض المهام (TaskViewModel) مسئول عن تجهيز وإدارة البيانات المتعلقة بالمهام (MyTask) لصالح واجهات المستخدم (Views/Activities).
 * يقوم بالاحتفاظ بالبيانات وتجاوز عمليات إعادة إنشاء النشاط (Configuration Changes) مثل دوران الشاشة،
 * ويتعامل مع {@link TaskRepository} لتنفيذ العمليات المختلفة.
 */
public class TaskViewModel extends AndroidViewModel {
    private final TaskRepository repository;
    private final LiveData<List<MyTask>> allTasks;

    /*
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة المستودع (TaskRepository) وجلب قائمة جميع المهام الأولية.
     *
     * @param application سياق التطبيق (Application Context) الممرر للـ AndroidViewModel.
     */
    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }

    /*
     * جلب جميع المهام كـ LiveData لمراقبتها من واجهة المستخدم.
     *
     * @return قائمة بجميع المهام محدثة تلقائياً.
     */
    public LiveData<List<MyTask>> getAllTasks() {
        return allTasks;
    }

    /*
     * جلب المهام الخاصة بمستخدم معين بناءً على معرف المستخدم (User ID).
     *
     * @param userId معرف المستخدم المراد جلب مهامه.
     * @return قائمة المهام الخاصة بالمستخدم.
     */
    public LiveData<List<MyTask>> getTasksByUserId(long userId) {
        return repository.getTasksByUserId(userId);
    }

    /*
     * جلب مهمة محددة بناءً على معرفها الفريد (Task ID).
     *
     * @param taskId معرف المهمة الفريد.
     * @return كائن المهمة المطلوب.
     */
    public LiveData<MyTask> getTaskById(long taskId) {
        return repository.getTaskById(taskId);
    }

    /*
     * البحث عن المهام التي تتطابق عناوينها مع النص المدخل.
     *
     * @param title النص أو الكلمة المراد البحث عنها في العنوان.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByTitle(String title) {
        return repository.getTasksByTitle(title);
    }

    /*
     * البحث عن المهام التي تتطابق أوصافها مع النص المدخل.
     *
     * @param text النص المراد البحث عنه.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByText(String text) {
        return repository.getTasksByText(text);
    }

    /*
     * جلب المهام المفلترة حسب مستوى الأولوية.
     *
     * @param priority مستوى الأولوية المطلوب.
     * @return قائمة المهام ذات الأولوية المحددة.
     */
    public LiveData<List<MyTask>> getTasksByPriority(int priority) {
        return repository.getTasksByPriority(priority);
    }

    /*
     * جلب المهام الخاصة بمستخدم معين والتي تتطابق مع عنوان معين.
     *
     * @param userId معرف المستخدم.
     * @param title  عنوان المهمة للبحث.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title) {
        return repository.getTasksByUserIdAndTitle(userId, title);
    }

    /*
     * إدراج مهمة أو عدة مهمات جديدة عبر المستودع.
     *
     * @param tasks المهام المراد إضافتها.
     */
    public void insert(MyTask... tasks) {
        repository.insert(tasks);
    }

    /*
     * تحديث مهمة أو عدة مهمات عبر المستودع.
     *
     * @param tasks المهام المراد تحديثها.
     */
    public void update(MyTask... tasks) {
        repository.updateTask(tasks);
    }

    /*
     * تحديث بيانات مهمة محددة (العنوان، الوصف، والأولوية) باستخدام معرف المهمة.
     *
     * @param taskId      معرف المهمة المراد تعديلها.
     * @param title       العنوان الجديد.
     * @param description الوصف الجديد.
     * @param priority    الأولوية الجديدة.
     */

    /*
     * حذف مهمة أو عدة مهمات عبر المستودع.
     *
     * @param tasks المهام المراد حذفها.
     */
    public void delete(MyTask... tasks) {
        repository.delete(tasks);
    }

    /*
     * حذف مهمة محددة باستخدام معرفها الفريد (Task ID).
     *
     * @param taskId معرف المهمة المراد حذفها.
     */
    public void deleteTaskById(long taskId) {
        repository.deleteTaskById(taskId);
    }
}




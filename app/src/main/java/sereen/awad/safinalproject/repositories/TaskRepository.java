package sereen.awad.safinalproject.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import java.util.List;

import sereen.awad.safinalproject.model.AppDatabase;
import sereen.awad.safinalproject.model.MyTaskTable.MyTask;
import sereen.awad.safinalproject.model.MyTaskTable.MyTaskQuery;

/*
 يعمل كطبقة وسيطة ومنظمة للوصول الى بيانات المهام (MyTask) مستودع المهام *
يقوم بفصل قاعدة البيانات *
* Room  و {@link MyTaskQuery}
  عن بقية أجزاء التطبيق (ViewModels) *
*/
public class TaskRepository
{
    private  MyTaskQuery taskQuery;//واجهة الاستعلامات
    private  LiveData<List<MyTask>> allTasks;//مبنى معطيات يحوي جميع المهام المستخرجة
    /*
      البحث عن المهام التي تتطابق عناوينها مع النص المدخل *
     * @param title النص أو الكلمة المراد البحث عنها في العنوان.
     * @return قائمة المهام المطابقة
     */

    /*
     * منشئ الكلاس (Constructor)
      يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمهام *
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */
    public TaskRepository(Application application){
        AppDatabase db=AppDatabase.getDB(application);
        taskQuery = db.getMyTaskQuery();
        allTasks = (LiveData<List<MyTask>>) taskQuery.getAllTasks();
    }
    /*
     *LiveData جلب جميع المهام الموجودة في قاعدة البيانات كـ
     * @return قائمة بجميع المهام المحدثة تلقائياً.
     */
    public LiveData<List<MyTask>>getAllTasks(){
        return allTasks;
    }
    /*جلب المهام المرتبطة بمعرف مستخدم معين (User ID)
    * @param userIdمعرف المستخدم المراد جلب مهامه
    * @return قائمة المهام الخاصة بالمستخدم المحدد
    */
    public LiveData<List<MyTask>> getTasksByUserId(long userId)
    {
        return taskQuery.getTasksByUserId(userId);
    }
     /* جلب مهمة معينة بناءً على معرفها الفريد (Task ID)
        * @param taskId معرف المهمة الفريد.
        * @return كائن المهمة المطلوب
    */
    public LiveData<MyTask> gettaskById(long taskId){
        return taskQuery.getTaskById(taskId);
    }
    /*
      البحث عن المهام التي تتطابق عناوينها مع النص المدخل *
     * @param title النص أو الكلمة المراد البحث عنها في العنوان.
     * @return قائمة المهام المطابقة.
     */
    public LiveData<List<MyTask>> getTasksByTitle(String title) {
        return taskQuery.getTasksByTitle(title);
    }

/*
  جلب المهام المفلترة حسب مستوى الأولوية *
 * @param priority مستوى الأولوية المطلوب.
 * @return قائمة المهام ذات الأولوية المحددة.
 */
public  LiveData<List<MyTask>> getTasksByPriority(int priority) {
    return taskQuery.getTasksByPriority(priority);
}

/*
 * جلب المهام الخاصة بمستخدم معين والتي تتطابق مع عنوان معين
 * @param userId معرف المستخدم.
 * @param title  عنوان المهمة للبحث.
 * @return قائمة المهام المطابقة.
 */
    public LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title) {
        return taskQuery.getTasksByUserIdAndTitle(userId, title);
    }


/*
 * إدراج مهمة أو عدة مهمات جديدة في قاعدة البيانات
 * @param tasks المهام المراد إضافتها.
 */
public void insert(MyTask...tasks)
{
    taskQuery.insertTask(tasks);
}

/*
 * تحديث مهمة أو عدة مهمات في قاعدة البيانات
 * @param tasks المهام المراد تحديثها.
 */
public void updateTask(MyTask...tasks) {
    taskQuery.updateTask(tasks);
}

    /*
     حذف مهمة أو عدة مهمات من قاعدة البيانات*
     * @param tasks المهام المراد حذفها.
     */
    public void delete(MyTask... tasks) {
        taskQuery.deleteTask(tasks);
    }


    /*
      حذف مهمة محددة باستخدام معرفها الفريد (Task ID)*
     * @param taskId معرف المهمة المراد حذفها.
     */
    public void deleteTaskById(long taskId) {
        taskQuery.deleteTaskById(taskId);
    }

    public LiveData<MyTask> getTaskById(long taskId) {
    }
}

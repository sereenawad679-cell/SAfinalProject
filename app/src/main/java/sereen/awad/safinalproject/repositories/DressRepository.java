package sereen.awad.safinalproject.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import sereen.awad.safinalproject.model.AppDatabase;
import sereen.awad.safinalproject.model.MyDressTable.MyDress;
import sereen.awad.safinalproject.model.MyDressTable.MyDressQuery;

/**
 * يعمل كطبقة وسيطة ومنظمة للوصول الى بيانات الفساتين (MyDress) مستودع الفساتين
 * يقوم بفصل قاعدة البيانات Room و MyDressQuery عن بقية أجزاء التطبيق (ViewModels)
 */
public class DressRepository {
    private final MyDressQuery dressQuery; // واجهة الاستعلامات
    private final LiveData<List<MyDress>> allDresses; // مبنى معطيات يحوي جميع الفساتين المستخرجة

    /**
     * منشئ الكلاس (Constructor)
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالفساتين
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */
    public DressRepository(Application application) {
        AppDatabase db = AppDatabase.getDB(application);
        dressQuery = db.getMyDressQuery();
        allDresses = dressQuery.getAllDresses();
    }

    public DressRepository(MyDressQuery dressQuery, LiveData<List<MyDress>> allDresses) {
        this.dressQuery = dressQuery;
        this.allDresses = allDresses;
    }

    /**
     * LiveData جلب جميع الفساتين الموجودة في قاعدة البيانات كـ
     * @return قائمة بجميع الفساتين المحدثة تلقائياً.
     */
    public LiveData<List<MyDress>> getAllDresses() {
        return allDresses;
    }

    /**
     * جلب فستان معين بناءً على معرفه الفريد (Dress ID)
     * @param dressId معرف الفستان الفريد.
     * @return كائن الفستان المطلوب.
     */
    public LiveData<MyDress> getDressById(long dressId) {
        return dressQuery.getDressById(dressId);
    }

    /**
     * البحث عن الفساتين التي تتطابق أسماؤها مع الاسم المدخل
     * @param name اسم الفستان للبحث.
     * @return قائمة الفساتين المطابقة.
     */
    public LiveData<List<MyDress>> getDressesByName(String name) {
        return dressQuery.getDressesByName(name);
    }

    /**
     * جلب الفساتين المفلترة حسب اللون
     * @param color اللون المطلوب.
     * @return قائمة الفساتين باللون المحدد.
     */
    public LiveData<List<MyDress>> getDressesByColor(String color) {
        return dressQuery.getDressesByColor(color);
    }

    /**
     * جلب الفساتين المفلترة حسب المقاس
     * @param size المقاس المطلوب.
     * @return قائمة الفساتين بالمقاس المحدد.
     */
    public LiveData<List<MyDress>> getDressesBySize(String size) {
        return dressQuery.getDressesBySize(size);
    }

    /**
     * جلب الفساتين المفلترة حسب المدينة
     * @param city المدينة المطلوبة.
     * @return قائمة الفساتين بالمدينة المحددة.
     */
    public LiveData<List<MyDress>> getDressesByCity(String city) {
        return dressQuery.getDressesByCity(city);
    }

    /**
     * إدراج فستان أو عدة فساتين جديدة في قاعدة البيانات
     * @param dresses الفساتين المراد إضافتها.
     */
    public void insert(MyDress... dresses) {
        dressQuery.insertDress(dresses);
    }

    /**
     * تحديث فستان أو عدة فساتين في قاعدة البيانات
     * @param dresses الفساتين المراد تحديثها.
     */
    public void updateDress(MyDress... dresses) {
        dressQuery.updateDress(dresses);
    }

    /**
     * حذف فستان أو عدة فساتين من قاعدة البيانات
     * @param dresses الفساتين المراد حذفها.
     */
    public void delete(MyDress... dresses) {
        dressQuery.deleteDress(dresses);
    }

    /**
     * حذف فستان محدد باستخدام معرفه الفريد (Dress ID)
     * @param dressId معرف الفستان المراد حذفه.
     */
    public void deleteDressById(long dressId) {
        dressQuery.deleteDressById(dressId);
    }
}

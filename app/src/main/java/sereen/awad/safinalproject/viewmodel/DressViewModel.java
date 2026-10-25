package sereen.awad.safinalproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import sereen.awad.safinalproject.model.MyDressTable.MyDress;
import sereen.awad.safinalproject.repositories.DressRepository;

/*
 * نموذج عرض الفساتين (DressViewModel) مسئول عن تجهيز وإدارة البيانات المتعلقة بالفساتين (MyDress) لصالح واجهات المستخدم.
 * يقوم بالاحتفاظ بالبيانات وتجاوز عمليات إعادة إنشاء النشاط (Configuration Changes)
 * ويتعامل مع {@link DressRepository} لتنفيذ العمليات المختلفة.
 */
public class DressViewModel extends AndroidViewModel {
    private final DressRepository repository;
    private final LiveData<List<MyDress>> allDresses;

    /*
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة المستودع (DressRepository) وجلب قائمة جميع الفساتين الأولية.
     *
     * @param application سياق التطبيق (Application Context) الممرر للـ AndroidViewModel.
     */
    public DressViewModel(@NonNull Application application) {
        super(application);
        repository = new DressRepository(application);
        allDresses = repository.getAllDresses();
    }

    /*
     * جلب جميع الفساتين كـ LiveData لمراقبتها من واجهة المستخدم.
     *
     * @return قائمة بجميع الفساتين محدثة تلقائياً.
     */
    public LiveData<List<MyDress>> getAllDresses() {
        return allDresses;
    }

    /*
     * جلب فستان معين بناءً على معرفه الفريد (Dress ID).
     *
     * @param dressId معرف الفستان الفريد.
     * @return كائن الفستان المطلوب.
     */
    public LiveData<MyDress> getDressById(long dressId) {
        return repository.getDressById(dressId);
    }

    /*
     * البحث عن الفساتين حسب الاسم.
     *
     * @param name اسم الفستان.
     * @return قائمة الفساتين المطابقة.
     */
    public LiveData<List<MyDress>> getDressesByName(String name) {
        return repository.getDressesByName(name);
    }

    /*
     * جلب الفساتين المفلترة حسب اللون.
     *
     * @param color اللون المطلوب.
     * @return قائمة الفساتين باللون المحدد.
     */
    public LiveData<List<MyDress>> getDressesByColor(String color) {
        return repository.getDressesByColor(color);
    }

    /*
     * جلب الفساتين المفلترة حسب المقاس.
     *
     * @param size المقاس المطلوب.
     * @return قائمة الفساتين بالمقاس المحدد.
     */
    public LiveData<List<MyDress>> getDressesBySize(String size) {
        return repository.getDressesBySize(size);
    }

    /*
     * جلب الفساتين المفلترة حسب القماش/المادة.
     *
     * @param material المادة المطلوبة.
     * @return قائمة الفساتين بالمادة المحددة.
     */
    public LiveData<List<MyDress>> getDressesByMaterial(String material) {
        return repository.getDressesByMaterial(material);
    }

    /*
     * جلب الفساتين المفلترة حسب الحالة.
     *
     * @param condition الحالة المطلوبة.
     * @return قائمة الفساتين بالحالة المحددة.
     */
    public LiveData<List<MyDress>> getDressesByCondition(String condition) {
        return repository.getDressesByCondition(condition);
    }

    /*
     * جلب الفساتين المفلترة حسب المدينة.
     *
     * @param city المدينة المطلوبة.
     * @return قائمة الفساتين بالمدينة المحددة.
     */
    public LiveData<List<MyDress>> getDressesByCity(String city) {
        return repository.getDressesByCity(city);
    }

    /*
     * جلب الفساتين المفلترة حسب الوصف.
     *
     * @param description الوصف المطلوب.
     * @return قائمة الفساتين بالوصف المحدد.
     */
    public LiveData<List<MyDress>> getDressesByDescription(String description) {
        return repository.getDressesByDescription(description);
    }

    /*
     * جلب الفساتين المفلترة حسب هل تم لبسه أم لا.
     *
     * @param hasBeenWorn حالة اللبس.
     * @return قائمة الفساتين المطابقة.
     */
    public LiveData<List<MyDress>> getDressesByHasBeenWorn(boolean hasBeenWorn) {
        return repository.getDressesByHasBeenWorn(hasBeenWorn);
    }

    /*
     * إدراج فستان أو عدة فساتين جديدة عبر المستودع.
     *
     * @param dresses الفساتين المراد إضافتها.
     */
    public void insert(MyDress... dresses) {
        repository.insert(dresses);
    }

    /*
     * تحديث فستان أو عدة فساتين عبر المستودع.
     *
     * @param dresses الفساتين المراد تحديثها.
     */
    public void update(MyDress... dresses) {
        repository.updateDress(dresses);
    }

    /*
     * حذف فستان أو عدة فساتين عبر المستودع.
     *
     * @param dresses الفساتين المراد حذفها.
     */
    public void delete(MyDress... dresses) {
        repository.delete(dresses);
    }

    /*
     * حذف فستان محدد باستخدام معرفه الفريد (Dress ID).
     *
     * @param dressId معرف الفستان المراد حذفه.
     */
    public void deleteDressById(long dressId) {
        repository.deleteDressById(dressId);
    }
}

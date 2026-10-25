package sereen.awad.safinalproject.model.MyDressTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/* واجهة استعلامات على جدول الفساتين */
@Dao
public interface
MyDressQuery {

    /*
     * إعادة جميع معطيات جدول الفساتين
     * @return قائمة من الفساتين
     */
    @Query("SELECT * FROM MyDress")
    LiveData<List<MyDress>> getAllDresses();

    /*
     * استخراج فستان بناءً على المعرف الفريد
     * @param dressId معرف الفستان
     * @return الفستان المطلوب
     */
    @Query("SELECT * FROM MyDress WHERE id = :dressId")
    LiveData<MyDress> getDressById(long dressId);

    /*
     * البحث عن الفساتين حسب الاسم
     * @param name اسم الفستان
     * @return قائمة الفساتين المطابقة
     */
    @Query("SELECT * FROM MyDress WHERE name = :name")
    LiveData<List<MyDress>> getDressesByName(String name);

    /*
     * استخراج الفساتين حسب اللون
     * @param color اللون
     * @return قائمة الفساتين باللون المحدد
     */
    @Query("SELECT * FROM MyDress WHERE color = :color")
    LiveData<List<MyDress>> getDressesByColor(String color);

    /*
     * استخراج الفساتين حسب المقاس
     * @param size المقاس
     * @return قائمة الفساتين بالمقاس المحدد
     */
    @Query("SELECT * FROM MyDress WHERE size = :size")
    LiveData<List<MyDress>> getDressesBySize(String size);

    /*
     * استخراج الفساتين حسب القماش/المادة
     * @param material القماش
     * @return قائمة الفساتين بالقماش المحدد
     */
    @Query("SELECT * FROM MyDress WHERE material = :material")
    LiveData<List<MyDress>> getDressesByMaterial(String material);

    /*
     * استخراج الفساتين حسب الحالة
     * @param condition الحالة
     * @return قائمة الفساتين بالحالة المحددة
     */
    @Query("SELECT * FROM MyDress WHERE condition = :condition")
    LiveData<List<MyDress>> getDressesByCondition(String condition);

    /*
     * استخراج الفساتين حسب المدينة
     * @param city المدينة
     * @return قائمة الفساتين بالمدينة المحددة
     */
    @Query("SELECT * FROM MyDress WHERE city = :city")
    LiveData<List<MyDress>> getDressesByCity(String city);

    /*
     * استخراج الفساتين حسب الوصف
     * @param description الوصف
     * @return قائمة الفساتين بالوصف المحدد
     */
    @Query("SELECT * FROM MyDress WHERE description = :description")
    LiveData<List<MyDress>> getDressesByDescription(String description);

    /*
     * استخراج الفساتين حسب هل تم لبسه أم لا
     * @param hasBeenWorn تم لبسه
     * @return قائمة الفساتين
     */
    @Query("SELECT * FROM MyDress WHERE hasBeenWorn = :hasBeenWorn")
    LiveData<List<MyDress>> getDressesByHasBeenWorn(boolean hasBeenWorn);

    /*
     * إدراج فساتين
     * @param dresses مجموعة فساتين
     */
    @Insert
    void insertDress(MyDress... dresses);

    /*
     * تحديث الفساتين
     * @param dresses مجموعة فساتين للتحديث
     */
    @Update
    void updateDress(MyDress... dresses);

    /*
     * حذف فستان أو فساتين
     * @param dresses مجموعة فساتين للحذف
     */
    @Delete
    void deleteDress(MyDress... dresses);

    /*
     * حذف فستان حسب الرقم المميز (id)
     * @param dressId معرف الفستان
     */
    @Query("DELETE FROM MyDress WHERE id = :dressId")
    void deleteDressById(long dressId);
}



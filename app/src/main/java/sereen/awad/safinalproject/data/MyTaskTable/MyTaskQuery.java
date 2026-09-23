package sereen.awad.safinalproject.data.MyTaskTable;

import androidx.room.Dao;
import androidx.room.Query;

/**واجهة  استعلامات على جدول معطيات*/
@Dao
public interface MyTaskQuery {
    /**اعادة جميع معطيات جدول المهماات
     * @return قائمة من المهمات
     */
    @Query("SELECT*FROM MyTask ORDER BY importance DESC")
    List<MyTask>getAllTasks();
     /**رجاع المهمات حسب المستعمل واذا انتهت ام لا ومرتبة تنازليا حسب الاهمية
      * رقم المستعمل
      * @param userid_p
      * @return
      */
     @Query("SELECT * FROM MyTask WHERE userId=:userid_p ORDER BY time DESC")
    List<MyTask>getAllTaskOrderBy(long userid_p);
     /**ارجاع المهمات حسب المستعمل واذا انتهت ام لا ومرتبة تنازليا حسب الاهمية
      *رقم المستعمل
      *  @param userid_p
      *  هل تمت أم لا
      *   @param isCompleted_p
      *   @return  قائمة امهمات
      */
     Query("SELECT * FROM MyTask WHERE userId=:userid_p AND isCompleted=:iscompleted_p"+ "ORDER BY importance DESC")
List<MyTask>getAllTaskOrderBy(long userid_p, boolean isCompleted_p);
}

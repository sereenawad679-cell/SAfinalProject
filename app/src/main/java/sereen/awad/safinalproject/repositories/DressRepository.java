package sereen.awad.safinalproject.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import sereen.awad.safinalproject.model.AppDatabase;
import sereen.awad.safinalproject.model.MyDressTable.MyDress;
import sereen.awad.safinalproject.model.MyDressTable.MyDressQuery;
import sereen.awad.safinalproject.model.MyTaskTable.MyTask;

public class DressRepository {
    private final MyDressQuery DressQuery;//واجهة الاستعلامات
    private final LiveData<List<MyDress>> allDresses;//مبنى معطيات يحوي جميع المهلام المستخرجة

    public DressRepository(MyDressQuery dressQuery, LiveData<List<MyDress>> allDresses) {
        DressQuery = dressQuery;
        this.allDresses = allDresses;
    }
    public DressRepository(Application application){
        AppDatabase db=AppDatabase.getDB(application);
        DressQuery = db.getMyDressQuery();
        allDresses = (LiveData<List<MyTask>>) DressQuery.getAllTasks();
    }
}

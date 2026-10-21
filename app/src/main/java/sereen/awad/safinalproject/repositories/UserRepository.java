package sereen.awad.safinalproject.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import sereen.awad.safinalproject.model.AppDatabase;
import sereen.awad.safinalproject.model.MyUserTable.MyUser;
import sereen.awad.safinalproject.model.MyUserTable.MyUserQuery;

public class UserRepository {
    private MyUserQuery UserQuery;//واجهة الاستعلامات
    private LiveData<List<MyUser>> allUsers;//مبنى معطيات يحوي جميع المستخدمين المستخرجين
    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDB(application);
        UserQuery= db.getUserQuery();
        allUsers = (LiveData<List<MyUser>>) UserQuery.getAll();
    }

    public LiveData<List<MyUser>> getAllUsers() {
        return allUsers;
    }
    public LiveData<List<MyUser>> getUserByKeyId(long keyId){
        return UserQuery.getUserByKeyId(keyId);
    }
    public LiveData<MyUser>getUserByfullName(String fullName){
        return UserQuery.getUserByfullName(fullName);
    }
    public LiveData<MyUser>getUserByemail(String email){

        return UserQuery.getUserByemail(email);
    }
    public LiveData<MyUser>getUserByPhone(String Phone){

        return UserQuery.getUserByPhone(Phone);
    }
    public LiveData<MyUser>getUserBypassw(String passw){

        return UserQuery.getUserBypassw(passw);
    }
    public List<MyUser> checkEmailPassw(String myEmail, String myPassw){
        return UserQuery.checkEmailPassw(myEmail,myPassw);

    }
    public void deleteByKeyId(long keyId){
         UserQuery.deleteByKeyId(keyId); }
}


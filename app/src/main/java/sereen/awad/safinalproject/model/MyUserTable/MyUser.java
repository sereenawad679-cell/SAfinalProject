package sereen.awad.safinalproject.model.MyUserTable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * فئة تمثل جدول المستخدمين (MyUser) في قاعدة البيانات.
 * تحتوي على بيانات المستخدم الشخصية ومعلومات الاعتماد (البريد وكلمة المرور).
 */
@Entity
public class MyUser {

    @PrimaryKey(autoGenerate = true)
    /** الرقم المميز للمستخدم (Primary Key) */
    public long keyid;

    @ColumnInfo(name = "full_name")
    /** الاسم الكامل للمستخدم */
    public String fullName;

    /** البريد الإلكتروني للمستخدم */
    public String email;

    /** رقم الهاتف للمستخدم */
    public String Phone;

    /** كلمة المرور للمستخدم */
    public String passw;

    /**
     * منشئ افتراضي فارغ (مطلوب بواسطة مكتبة Room).
     */
    public MyUser() {
    }

    /**
     * منشئ مع تحديد المعرف فقط.
     * @param keyid المعرف الفريد.
     */
    public MyUser(long keyid) {
        this.keyid = keyid;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "keyid=" + keyid +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", passw='" + passw + '\'' +
                '_';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public long getKeyid() {
        return keyid;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirestoreUid(String uid) {
    }
}

package sereen.awad.safinalproject.data.MyUserTable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class MyUser {
    //Entity = Table =جدول
//عندما نريد ان نتعامل مع هذه الفئة كجدول معطيات
    /**
     * فئة تمثل المستعمل
     */
        @PrimaryKey(autoGenerate = true)
        public long keyid;
        @ColumnInfo(name="full_name")
        public String fullName;
        public String email;
        public String Phone;
        public String passw;

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
                '}';
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



}

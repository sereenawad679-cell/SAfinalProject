package sereen.awad.safinalproject.model.MyTaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyTask {
    @PrimaryKey(autoGenerate = true)
    /**رقم المهمة*/
    public long keyId;
    /**رجة الأهمية 1-5*/
    public int importance;
    /**عنوان قصير*/
    public String shortTitle;
    /**نص المهمة*/
    public String text;
    /**زمن بناء المهمة*/
    public long time;
    /**هل تمت المهمة*/
    public boolean isCompleted;
    /**رقم موضوع المهمة*/
    public long subjId;
    /**رقم المستعمل الذي أضاف المهمة*/
    public long userId;
    public MyTask() {
    }

    public long getKeyId() {
        return keyId;
    }

    public int getImportance() {
        return importance;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public String getText() {
        return text;
    }

    public long getTime() {
        return time;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public long getSubjId() {
        return subjId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setSubjId(long subjId) {
        this.subjId = subjId;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }


    @Override
    public String toString() {
        return "MyTask{" +
                "keyId=" + keyId +
                ", importance=" + importance +
                ", shortTitle='" + shortTitle + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                ", subjId=" + subjId +
                ", userId=" + userId +
                '}';
    }
}

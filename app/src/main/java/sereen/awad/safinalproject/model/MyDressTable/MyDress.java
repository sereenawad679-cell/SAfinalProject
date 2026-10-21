package sereen.awad.safinalproject.model.MyDressTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyDress {
  @PrimaryKey(autoGenerate = true)
    public long id;
  public String name;
  public String size;
    public String color;
    public String material;
    public String condition;
    public String city;
    public String description;
    public boolean hasBeenWorn;
}

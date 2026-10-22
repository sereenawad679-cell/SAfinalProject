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

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSize() {
    return size;
  }

  public String getMaterial() {
    return material;
  }
  public String getColor() {
    return color;
  }

  public String getCondition() {
    return condition;
  }

  public String getCity() {
    return city;
  }

  public String getDescription() {
    return description;
  }

  public boolean isHasBeenWorn() {
    return hasBeenWorn;
  }

  public void setHasBeenWorn(boolean hasBeenWorn) {
    this.hasBeenWorn = hasBeenWorn;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public void setMaterial(String material) {
    this.material = material;
  }


  public void setColor(String color) {
    this.color = color;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "MyDress{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", size='" + size + '\'' +
            ", color='" + color + '\'' +
            ", material='" + material + '\'' +
            ", condition='" + condition + '\'' +
            ", city='" + city + '\'' +
            ", description='" + description + '\'' +
            ", hasBeenWorn=" + hasBeenWorn +
            '}';
  }
}

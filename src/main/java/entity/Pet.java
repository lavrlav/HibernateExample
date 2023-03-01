package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "animal", length = 20)
    private String animal;
    @Basic
    @Column(name = "name",  length = 20)
    private String name;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "color", length = 20)
    private String color;
    @Basic
    @Column(name = "owner_id")
    private Integer ownerId;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Owner ownersByOwnerId;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getAnimal() {
//        return animal;
//    }
//
//    public void setAnimal(String animal) {
//        this.animal = animal;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public Integer getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(Integer ownerId) {
//        this.ownerId = ownerId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Pet that = (Pet) o;
//
//        if (id != that.id) return false;
//        if (animal != null ? !animal.equals(that.animal) : that.animal != null) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (age != null ? !age.equals(that.age) : that.age != null) return false;
//        if (color != null ? !color.equals(that.color) : that.color != null) return false;
//        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (animal != null ? animal.hashCode() : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (age != null ? age.hashCode() : 0);
//        result = 31 * result + (color != null ? color.hashCode() : 0);
//        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
//        return result;
//    }
//
//    public Owner getOwnersByOwnerId() {
//        return ownersByOwnerId;
//    }
//
//    public void setOwnersByOwnerId(Owner ownersByOwnerId) {
//        this.ownersByOwnerId = ownersByOwnerId;
//    }
}

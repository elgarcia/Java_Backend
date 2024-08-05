package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Alumno {
    static public final int                 maxLengthName = 10;
    @EqualsAndHashCode.Include private long  code;
    private String                          name;
    private LocalDate                       date;

    {
        date = LocalDate.now();
        code = (long) (Math.random() * System.currentTimeMillis());
    }

    public Alumno(String nombre)
    {
        setName(nombre);
    }

    public void setName(String newName) {
        if (newName != null && newName.length() > maxLengthName){
            newName = newName.substring(0, maxLengthName);
        }
        this.name = newName;
    }

    public String getName() {
        return (name == null ? null: name.toUpperCase());
    }
}

package br.com.modeljpa.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author t1076986
 */
@Entity
@Table(name="marca")
public class Marca implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_marca", sequenceName = "seq_marca_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_marca", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message="O nome  deve ser preenchida")
    @NotNull(message="O nome não pode ser nulo")
    @Length(max =50, message="O nome pode ter até {max} caracteres")
    @Column(name = "nome",length = 50, nullable = false)
    private String nome;

    public Marca() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}

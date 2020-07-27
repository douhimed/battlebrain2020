package org.sqli.staysafe.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.sqli.staysafe.utilities.IdGenerator;

@Getter
@Setter
public class AbstractEntity {

    private long id;

    public AbstractEntity() {
        this.id = IdGenerator.generate(this.getClass().getName());
    }
}

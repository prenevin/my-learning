package com.prenevin.application.domain;


import com.prenevin.library.crud.domain.BaseDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tool", uniqueConstraints = @UniqueConstraint(name = "uq_tool_name", columnNames = "name"))
@NoArgsConstructor
@Getter
@Setter
public class Tool extends BaseDomain {

    @NotNull
    @Column(name = "name")
    private String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Tool tool = (Tool) o;

        return new EqualsBuilder()
            .append(getName(), tool.getName())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getName())
            .toHashCode();
    }
}

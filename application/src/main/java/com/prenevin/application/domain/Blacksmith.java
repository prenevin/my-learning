package com.prenevin.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blacksmith extends Person {

    @Column(name = "shop")
    private String shop;
    // Something to have in this class

    @ManyToMany
    @JoinTable(name = "blacksmith_tool",
        joinColumns = @JoinColumn(name = "tool_id"),
        inverseJoinColumns = @JoinColumn(name = "blacksmith_id"))
    private List<Tool> tools = new ArrayList<>();

    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

}

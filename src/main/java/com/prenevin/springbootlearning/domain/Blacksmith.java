package com.prenevin.springbootlearning.domain;

import javax.persistence.*;
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

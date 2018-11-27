package com.hiber.DBClass;


import javax.persistence.*;
import java.util.Set;

@Entity
public class SpentType extends EntityClass
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "spentType")
    private Set<Check> checks;

    @OneToMany(mappedBy = "spentType")
    private Set<Collision> collisions;

    public SpentType()
    {

    }

    public SpentType(String title, String description)
    {
        this.title = title;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return String.format("SpentType ID: %d\nTitle: %s\nDescription: %s",
                id, title, description);
    }
}

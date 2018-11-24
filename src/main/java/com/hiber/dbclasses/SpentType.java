package com.hiber.dbclasses;


import javax.persistence.*;

@Entity
@Table(name = "spenttypeid")
public class SpentType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

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

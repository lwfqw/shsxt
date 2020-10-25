package com.lwf.stream;

import java.util.Objects;

/**
 * @author lwf
 * @title: Panda
 * @projectName 10_24Code
 * @description: TODO
 * @date 2020/10/2411:10
 */
public class Panda {
    private int id;
    private String name;
    private String locate;

    public Panda() {
    }

    public Panda(int id, String name, String locate) {
        this.id = id;
        this.name = name;
        this.locate = locate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panda panda = (Panda) o;
        return id == panda.id &&
                Objects.equals(name, panda.name) &&
                Objects.equals(locate, panda.locate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, locate);
    }

    @Override
    public String toString() {
        return "Panda{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locate='" + locate + '\'' +
                '}';
    }
}

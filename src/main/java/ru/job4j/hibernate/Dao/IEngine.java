package ru.job4j.hibernate.Dao;

import ru.job4j.hibernate.Model.Engine;

import java.util.List;

public interface IEngine {

    void save(Engine engine);

    void update(Engine engine);

    void delete(Engine engine);

    List<Engine> findAll();

    Engine find (Engine engine);
}

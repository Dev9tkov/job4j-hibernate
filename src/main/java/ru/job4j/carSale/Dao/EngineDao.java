package ru.job4j.carSale.Dao;


import ru.job4j.carSale.Model.Engine;
import java.util.List;

public interface EngineDao {

    void save(Engine engine);

    void update(Engine engine);

    void delete(Engine engine);

    List<Engine> findAll();

    Engine find (Engine engine);
}

package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.Engine;

import java.util.List;

public class EngineDaoImpl extends AbstractDao implements EngineDao {

    private final static EngineDaoImpl INSTANCE = new EngineDaoImpl();

    private EngineDaoImpl() {
    }

    public static EngineDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Engine engine) {
        super.save(engine);
    }

    @Override
    public void update(Engine engine) {
        super.update(engine);
    }

    @Override
    public void delete(Engine engine) {
        super.delete(engine);
    }

    @Override
    public List<Engine> findAll() {
        return super.findAll("Engine");
    }

    @Override
    public Engine find(Engine engine) {
        return super.find(Engine.class, engine.getId());
    }
}

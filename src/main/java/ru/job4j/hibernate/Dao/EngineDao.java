package ru.job4j.hibernate.Dao;

import ru.job4j.hibernate.Model.Engine;

import java.util.List;

public class EngineDao extends AbstractDao implements IEngine {

    private final static IEngine INSTANCE = new EngineDao();

    private EngineDao() {
    }

    public static IEngine getInstance() {
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

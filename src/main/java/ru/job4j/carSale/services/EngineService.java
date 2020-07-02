package ru.job4j.carSale.services;

import ru.job4j.carSale.Dao.EngineDaoImpl;
import ru.job4j.carSale.Model.Engine;

import java.util.List;

public class EngineService {
    private static final EngineService INSTANCE = new EngineService();

    private static final EngineDaoImpl ENGINE_DAO = EngineDaoImpl.getInstance();

    public static EngineService getInstance() {
        return INSTANCE;
    }

    private EngineService() {
    }

    public void save(Engine engine) {
        ENGINE_DAO.save(engine);
    }

    public void delete(Engine engine) {
        ENGINE_DAO.delete(engine);
    }

    public void update(Engine engine) {
        ENGINE_DAO.update(engine);
    }

    public List<Engine> findAll() {
        return ENGINE_DAO.findAll();
    }

    public Engine find(Engine engine) {
        return ENGINE_DAO.find(engine);
    }
}

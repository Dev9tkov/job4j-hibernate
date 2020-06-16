package ru.job4j.hibernate.Dao;

import org.junit.Test;
import ru.job4j.hibernate.Model.Engine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EngineDaoTest {

    private IEngine iEngine = EngineDao.getInstance();

    @Test
    public void savEngine() {
        Engine engine = new Engine("benzin");
        iEngine.save(engine);
        assertThat(iEngine.findAll().size(), is (1));
    }

    @Test
    public void updateEngine() {
        Engine engine = new Engine("benzin");
        iEngine.save(engine);
        engine.setName("gaz");
        iEngine.update(engine);
        assertThat(iEngine.find(new Engine(engine.getId())).getName(), is("gaz"));
    }

    @Test
    public void deleteEngine() {
        Engine engine = new Engine("benzin");
        iEngine.save(engine);
        iEngine.delete(engine);
        assertThat(iEngine.findAll().size(), is (0));
    }

    @Test
    public void findEngine() {
        Engine engine = new Engine("benzin");
        iEngine.save(engine);
        assertThat(iEngine.find(new Engine(engine.getId())).getName(), is("benzin"));
    }
}
package t08_ObjectCommunicationAndEvents.p07_1984.repositories;

import t08_ObjectCommunicationAndEvents.p07_1984.model.Entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class EntityRepository {
    private Map<String, Entity> entities;

    public EntityRepository() {
        this.entities = new LinkedHashMap<>();
    }

    public Entity getById(String id) {
        return this.entities.get(id);
    }

    public void addEntity(Entity entity) {
        this.entities.put(entity.getId(), entity);
    }

    public Iterable<Entity> getAllEntities() {
        return this.entities.values();
    }
}

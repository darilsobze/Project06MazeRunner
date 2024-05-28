package h06.world;

import fopbot.FieldEntity;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;

/**
 * A field in a world which can contains entities.
 *
 * @author Nhan Huynh
 */
@DoNotTouch
public class Field {

    /**
     * The initial capacity of the array of entities.
     */
    private static final int INITIAL_CAPACITY = 10;

    /**
     * The entities on the field.
     */
    private FieldEntity[] entities;

    /**
     * The index of the next free slot in the array of entities.
     */
    private int nextFreeIndex;

    /**
     * Creates a new field with the initial capacity.
     */
    public Field() {
        this(INITIAL_CAPACITY);
    }

    /**
     * Creates a new field with the given capacity.
     *
     * @param capacity the initial capacity of the field
     */
    public Field(int capacity) {
        this.entities = new FieldEntity[capacity];
        this.nextFreeIndex = 0;
    }

    /**
     * Adds the given entity to the field.
     *
     * @param entity the entity to add
     */
    public void addEntity(FieldEntity entity) {
        // If array is full, increase its size
        if (nextFreeIndex == entities.length) {
            FieldEntity[] newEntities = new FieldEntity[entities.length * 2];
            for (int i = 0; i < entities.length; i++) {
                newEntities[i] = entities[i];
            }
            entities = newEntities;
        }
        entities[nextFreeIndex] = entity;
        nextFreeIndex++;
    }

    /**
     * Returns the entities on the field.
     *
     * @return the entities on the field
     */
    public FieldEntity[] getEntities() {
        return entities;
    }
}

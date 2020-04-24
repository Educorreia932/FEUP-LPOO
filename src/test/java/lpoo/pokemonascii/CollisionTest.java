package lpoo.pokemonascii;

import lpoo.pokemonascii.data.Obstacle;
import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.Rect;
import lpoo.pokemonascii.data.elements.CollidingElement;
import lpoo.pokemonascii.data.elements.Element;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollisionTest {
    Player player;
    Obstacle obstacle;

    @Before
    public void init(){
        obstacle = new Obstacle(0, 0, 10, 10);
        player = new Player();
    }

    @Test
    public void testGetHitbox(){
        CollidingElement subject = new Obstacle(0, 0, 10, 10);
        assertEquals(subject.getHitbox(), new Rect(10, 10));
    }

    @Test
    public void testCollisionCheck(){

        //Same Position & Same Sizes
        Position position = new Position(0,0 );
        CollidingElement subject = new Obstacle(0, 0, 5, 5);
        CollidingElement subject2 = new Obstacle(0, 0, 5, 5);
        assertTrue(subject.collides(position, subject2));

        //Same Position & Different Sizes
        subject = new Obstacle(0, 0, 15, 20);
        assertTrue(subject.collides(position, subject2));

        //Not colliding
        subject = new Obstacle(20, 30, 10, 10);
        assertFalse(subject.collides(position, subject2));

        //Touching
        subject = new Obstacle(5, 0, 1, 5);
        assertFalse(subject.collides(position, subject2));

        //Colliding
        subject = new Obstacle(1, 1, 10, 10);
        assertTrue(subject.collides(position, subject2));

        subject = new Obstacle(0, 4, 10, 10);
        assertTrue(subject.collides(position, subject2));

        subject = new Obstacle(0, 0, 4, 8);
        subject2 = new Obstacle(3, 3, 3, 3);
        assertTrue(subject.collides(position, subject2));

    }

}

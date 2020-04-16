package lpoo.pokemonascii.elements;

import lpoo.pokemonascii.geometry.Rect;

public interface CollidingElement extends Element {
    Rect getHitbox();
}

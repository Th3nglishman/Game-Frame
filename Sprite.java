

import java.awt.Image;

//Provides a convinient point of joining a hitbox and sprite
public class Sprite extends SpriteBase {
	private Hitbox box;

	// Constructor
	public Sprite(Image pic, int x, int y) {
		super(pic, x, y);
		box = new Hitbox(x, y, getWidth(), getHeight());
	}

	// Returns this hitbox
	public Hitbox getHitbox() {
		return box;
	}
}

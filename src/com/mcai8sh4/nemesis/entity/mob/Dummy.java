package com.mcai8sh4.nemesis.entity.mob;


import com.mcai8sh4.nemesis.graphics.AnimatedSprite;
import com.mcai8sh4.nemesis.graphics.Screen;
import com.mcai8sh4.nemesis.graphics.Sprite;
import com.mcai8sh4.nemesis.graphics.SpriteSheet;

public class Dummy extends Mob {

    private boolean walking = false;
    private int flip = 0;
    private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 32, 32, 2);
    private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 32, 32, 2);
    private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 32, 32, 2);
    private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 32, 32, 2);

    private AnimatedSprite animSprite = down;

    private int time = 0;
    int xa = 0;
    int ya = 0;

    public Dummy(int x, int y) {
        this.x = x << 4;
        this.y = y << 4;
        sprite = Sprite.dummy;
    }

    public void update() {
        time++;

        if (time % (random.nextInt(50) + 30) == 0) {
            xa = random.nextInt(3) - 1;
            ya = random.nextInt(3) - 1;
            if (random.nextInt(3) == 0) {
                xa = 0;
                ya = 0;
            }
        }

        if (walking) animSprite.update();
        else animSprite.setFrame(0);
        if (ya < 0) {
            animSprite = up;
            dir = Direction.UP;
            flip = 0;
        } else if (ya > 0) {
            animSprite = down;
            dir = Direction.DOWN;
            flip = 0;
        }
        if (xa < 0) {
            animSprite = left;
            dir = Direction.LEFT;
            flip = 1;
        } else if (xa > 0) {
            animSprite = right;
            dir = Direction.RIGHT;
            flip = 0;
        }
        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
    }

    public void render(Screen screen) {
        sprite = animSprite.getSprite();
        screen.renderMob((int)(x-16),(int) (y-16), this);
    }
}

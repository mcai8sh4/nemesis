package com.mcai8sh4.nemesis.graphics;

public class Sprite {

    public final int SIZE;
    private int x, y;
    private int width, height;
    public int[] pixels;
    protected SpriteSheet sheet;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
    public static Sprite wall = new Sprite(16, 0, 1, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0x303030);

    //  Spawn Level Sprites
    public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
    public static Sprite spawn_flower = new Sprite(16, 1, 0, SpriteSheet.spawn_level);
    public static Sprite spawn_rock = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
    public static Sprite spawn_wall = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
    public static Sprite spawn_floor = new Sprite(16, 1, 1, SpriteSheet.spawn_level);
    public static Sprite spawn_water = new Sprite(16, 2, 1, SpriteSheet.spawn_level);

    //  Player Sprites
    public static Sprite player_forward = new Sprite(32, 5, 6, SpriteSheet.tiles);
    public static Sprite player_forward_1 = new Sprite(32, 5, 7, SpriteSheet.tiles);

    public static Sprite player_back = new Sprite(32, 7, 6, SpriteSheet.tiles);
    public static Sprite player_back_1 = new Sprite(32, 7, 7, SpriteSheet.tiles);

    public static Sprite player_side = new Sprite(32, 6, 6, SpriteSheet.tiles);
    public static Sprite player_side_1 = new Sprite(32, 6, 7, SpriteSheet.tiles);

    public static Sprite dummy = new Sprite(32, 0, 0, SpriteSheet.dummy_down);

    // Projectile sprites
    public static Sprite projectile_player = new Sprite(16, 0, 0, SpriteSheet.projectile_player);

    // Particle Sprites
    public static Sprite particle_normal = new Sprite(3, 0xAAAAAA);

    protected Sprite(SpriteSheet sheet, int width, int height) {
        SIZE = (width == height) ? width : -1;
        this.width = width;
        this.height = height;
        this.sheet = sheet;

    }

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        this.width = SIZE;
        this.height = SIZE;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    public Sprite(int width, int height, int colour) {
        SIZE = -1;
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        setColour(colour);
    }

    public Sprite(int size, int colour) {
        SIZE = size;
        this.width = SIZE;
        this.height = SIZE;
        pixels = new int[SIZE * SIZE];
        setColour(colour);
    }

    public Sprite(int[] pixels, int width, int height) {
        SIZE = (width == height) ? width : -1;
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    private void setColour(int colour) {
        for (int i = 0; i < width * height; i++) {
            pixels[i] = colour;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void load() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.WIDTH];
            }
        }
    }
}


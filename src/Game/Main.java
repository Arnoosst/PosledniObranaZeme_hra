package Game;

public class Main {
    public static void main(String[] args) {
        World.loadMap("map.txt");
        System.out.println(World.moveTo(2));
        System.out.println(World.moveTo(3));
    }
}
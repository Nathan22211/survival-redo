package net.mcreator.survival.item;

public enum FireItemTypes {

    Sticks(2),
    IronStone(15),
    Netherite(500);

    public int damage;

    FireItemTypes(int damage) {
        this.damage = damage;
    }
}

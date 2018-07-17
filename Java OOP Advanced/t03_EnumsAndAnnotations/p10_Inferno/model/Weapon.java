package t03_EnumsAndAnnotations.p10_Inferno.model;

import t03_EnumsAndAnnotations.p10_Inferno.annotations.ClassInfo;
import t03_EnumsAndAnnotations.p10_Inferno.enums.Gem;
import t03_EnumsAndAnnotations.p10_Inferno.enums.WeaponType;

@ClassInfo(
        author = "Pesho"
        , revision = 3
        , description = "Used for Java OOP Advanced course - Enumerations and Annotations."
        , reviewers = {"Pesho", "Svetlio"}
)
public class Weapon implements Comparable<Weapon> {
    private String name;
    private WeaponType weaponType;
    private Gem[] gems;

    public Weapon(String name, String weaponType) {
        this.name = name;
        this.weaponType = WeaponType.valueOf(weaponType);
        this.gems = new Gem[this.weaponType.getSockets()];
    }

    public int getMinDamage() {
        int damage = this.weaponType.getMinDamage();
        damage += this.getStrength() * 2;
        damage += this.getAgility();
        return damage;
    }

    public int getMaxDamage() {
        int damage = this.weaponType.getMaxDamage();
        damage += this.getStrength() * 3;
        damage += this.getAgility() * 4;
        return damage;
    }

    public int getStrength() {
        int strength = 0;
        for (Gem gem : this.gems) {
            if (gem != null) {
                strength += gem.getStrength();
            }
        }
        return strength;
    }

    public int getAgility() {
        int agility = 0;
        for (Gem gem : this.gems) {
            if (gem != null) {
                agility += gem.getAgility();
            }
        }
        return agility;
    }

    public int getVitality() {
        int vitality = 0;
        for (Gem gem : this.gems) {
            if (gem != null) {
                vitality += gem.getVitality();
            }
        }
        return vitality;
    }

    public double getItemLevel() {
        return (this.getMinDamage() + this.getMaxDamage()) / 2.0
                + this.getStrength() + this.getAgility() + this.getVitality();
    }

    public void addGem(String gemType, int socketIndex) {
        if (socketIndex >= 0 && socketIndex < this.gems.length) {
            Gem gem = Gem.valueOf(gemType);
            this.gems[socketIndex] = gem;
        }
    }

    public void removeGem(int socketIndex) {
        if (socketIndex >= 0 && socketIndex < this.gems.length) {
            this.gems[socketIndex] = null;
        }
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.getItemLevel(), o.getItemLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality"
                , this.name, this.getMinDamage(), this.getMaxDamage(), this.getStrength()
                , this.getAgility(), this.getVitality());
    }
}

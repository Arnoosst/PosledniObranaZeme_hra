package Game.Items;


/**
 * Represents a crate map that leads to a crate containing a gemstone.
 * Extends items name, ID, and price amd adds a infoAboutMap.
 *
 * @author Vojtěch Malínek
 */
public class MapForCrate extends Item {

    private String infoAboutMap;

    public MapForCrate(String itemName, int itemID, int itemPrice, String infoAboutMap) {
        super(itemName, itemID, itemPrice );
        this.infoAboutMap = infoAboutMap;
    }

    public String getInfoAboutMap() {
        return infoAboutMap;
    }

}

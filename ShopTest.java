import static org.junit.Assert.*;
import org.junit.Test;

public class ShopTest {

    @Test
    public void testPrice() {
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2022, 900);
        assertEquals(900, comp.price);
    }

    @Test
    public void testUpdates() {
        Computer comp = new Computer("Dell", "Intel", 512, 16, "Windows", 2022, 900);
        comp.setOS("Linux");
        assertEquals("Linux", comp.operatingSystem);
    }

    @Test
    public void testEmptyInventory() {
        ResaleShop shop = new ResaleShop();
        assertEquals(0, shop.inventory.size());
    }

    @Test
    public void testMemory() {
        Computer comp = new Computer("Dell", "Intel", 512, 32, "Windows", 2022, 900);
        assertEquals(32, comp.memory);
    }

    @Test
    public void testAddsComputer() {
        ResaleShop shop = new ResaleShop();
        shop.inventory.clear();

        Computer comp = new Computer("Dell XPS", "Intel", 512, 16, "Windows", 2022, 900);
        shop.buy(comp);

        assertTrue(shop.inventory.contains(comp));
    }

    @Test(expected = RuntimeException.class)
    public void testThrowsInventory() {
        ResaleShop shop = new ResaleShop();
        shop.inventory.clear();

        Computer comp = new Computer("Dell XPS", "Intel", 512, 16, "Windows", 2022, 900);
        shop.inventory.add(comp);
        shop.buy(comp);
    }

    @Test(expected = RuntimeException.class)
    public void testThrowsNotInInventory() {
        ResaleShop shop = new ResaleShop();
        shop.inventory.clear();

        Computer comp = new Computer("Dell XPS", "Intel", 512, 16, "Windows", 2022, 900);
        shop.sell(comp);
    }

    @Test
    public void testPrint() {
        ResaleShop shop = new ResaleShop();
        try {
            shop.printInventory();
        } catch (Exception e) {
            fail("printInventory should not throw an exception");
        }
    }

    @Test
    public void testRefurbishPrice() {
        ResaleShop shop = new ResaleShop();
        shop.inventory.clear();

        Computer comp = new Computer("Old Laptop", "Intel", 128, 8, "Windows 7", 2010, 100);
        shop.inventory.add(comp);

        shop.refurbish(comp, "None");
        assertEquals(250, comp.price);
    }

    @Test
    public void testRefurbishDoesNotChange() {
        ResaleShop shop = new ResaleShop();
        shop.inventory.clear();

        Computer comp = new Computer("MacBook", "Intel", 256, 8, "OldOS", 2019, 500);
        shop.inventory.add(comp);

        shop.refurbish(comp, new String("None"));
        assertEquals("OldOS", comp.operatingSystem);
    }
}
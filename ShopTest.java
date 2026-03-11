import static org.junit.Assert.*;
import org.junit.Test;

public class ShopTest {

    @Test
    public void testPrice() {
        Computer laptop = new Computer("HP Pavilion", "AMD", 1024, 16, "Windows 11", 2026, 222);
        assertEquals(222, laptop.price);
    }

    @Test
    public void testUpdates() {
        Computer laptop = new Computer("Lenovo ThinkPad", "Intel", 512, 8, "Windows 10", 2005, 222);
        laptop.setOS("Ubuntu");
        assertEquals("Ubuntu", laptop.operatingSystem);
    }

    @Test
    public void testEmptyInventory() {
        ResaleShop store = new ResaleShop();
        assertEquals(0, store.inventory.size());
    }

    @Test
    public void testMemory() {
        Computer device = new Computer("Acer Aspire", "Intel", 256, 32, "Windows 11", 2026, 222);
        assertEquals(32, device.memory);
    }

    @Test
    public void testAddsComputer() {
        ResaleShop store = new ResaleShop();
        store.inventory.clear();

        Computer device = new Computer("Surface Laptop", "Intel", 512, 16, "Windows 11", 2026, 222);
        store.buy(device);

        assertTrue(store.inventory.contains(device));
    }

    @Test(expected = RuntimeException.class)
    public void testThrowsInventory() {
        ResaleShop store = new ResaleShop();
        store.inventory.clear();

        Computer device = new Computer("Surface Laptop", "Intel", 512, 16, "Windows 11", 2005, 222);
        store.inventory.add(device);
        store.buy(device);
    }

    @Test(expected = RuntimeException.class)
    public void testThrowsNotInInventory() {
        ResaleShop store = new ResaleShop();
        store.inventory.clear();

        Computer device = new Computer("Alienware M15", "Intel", 1024, 32, "Windows 11", 2026, 222);
        store.sell(device);
    }

    @Test
    public void testPrint() {
        ResaleShop store = new ResaleShop();
        try {
            store.printInventory();
        } catch (Exception e) {
            fail("printInventory should run without throwing an error");
        }
    }

    @Test
    public void testRefurbishPrice() {
        ResaleShop store = new ResaleShop();
        store.inventory.clear();

        Computer oldPC = new Computer("Old Dell Latitude", "Intel", 128, 8, "Windows 8", 2005, 222);
        store.inventory.add(oldPC);

        store.refurbish(oldPC, "None");
        assertEquals(250, oldPC.price);
    }

    @Test
    public void testRefurbishDoesNotChange() {
        ResaleShop store = new ResaleShop();
        store.inventory.clear();

        Computer mac = new Computer("MacBook Air", "Apple M1", 256, 8, "macOS Monterey", 2026, 222);
        store.inventory.add(mac);

        store.refurbish(mac, new String("None"));
        assertEquals("macOS Monterey", mac.operatingSystem);
    }
}
## Bug 1
Brief description:  
In `Computer。java`, new input price value would not change prices, since constructor always set `price`to 0.

Failed unit test:  
testPrice

## Bug 2
Brief description:  
In `Computer` the OS would not update to the new input OS, since `setOS` always sets operating system to "None".

Failed unit test:  
testUpdates

## Bug 3
Brief description:  
In `ResaleShop` a new shop should start with an empty inventory, but constructor automatically adds a computer into the inventory so it would be impossible for a new store.

Failed unit test:  
testEmptyInventory

## Bug 4
Brief description:  
In `Computer` new input memory value would not change memory, since constructor always set `memory` to 16.

Failed unit test:  
testMemory

## Bug 5
Brief description:  
In `ResaleShop` the `buy` method would not actually add the computer passed in as the parameter. Instead, the method creates a new computer object and assigns it to `newComputer`, so the original computer passed to the method is ignored and never added to the inventory.

Failed unit test:   
testAddsComputer

## Bug 6
Brief description:  
In `ResaleShop` the `buy` method should throw a `RuntimeException` when the computer is already in the inventory, according to the method comment. However, the method does not check whether the computer already exists in the inventory and simply adds it again.

Failed unit test:  
testThrowsInventory

## Bug 7
Brief description:  
Similar to Bug 6, in `ResaleShop` the `sell` method should throw a `RuntimeException` when trying to sell a computer that is not in the inventory. However, the method directly calls `inventory.remove(comp)` without checking if the computer exists in the inventory first, so no exception is thrown.

Failed unit test:  
testThrowsNotInInventory

## Bug 8
Brief description:  
In `ResaleShop` the `printInventory` loop condition is wrong (`<=` instead of `<`).

Failed unit test:  
testPrint

## Bug 9
Brief description:  
In `ResaleShop` the refurbish price logic seems incorrect. Computers made before 2012 are assigned a price of `2500`, which is inconsistent with the prices assigned to newer computers in the following conditions.

Failed unit test:  
testRefurbishPrice

## Bug 10
Brief description:  
In `ResaleShop`, the refurbish method uses != to compare strings instead of .equals()

Failed unit test:  
testRefurbishDoesNotChange
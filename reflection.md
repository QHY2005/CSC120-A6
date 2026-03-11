Use this file to record your reflection on this assignment.

What are your initial impressions of how `Unit Testing` affects your programming?
What worked, what didn't, what advice would you give someone taking this course in the future?

At the beginning of this assignment, I felt pretty nervous when I opened the files because almost every line of code had a red squiggly line under it. In my previous programming assignments, red squiggly lines usually meant that I had written something wrong in my own code, so seeing so many of them made me feel confused and worried. At first I thought I had already made many mistakes. Later I realized that this assignment was different because the code was intentionally written with bugs, and our goal was to use unit tests to identify those problems.

For this assignment, I implemented several unit tests in `ShopTest.java` to check whether different parts of the program behaved correctly. For example, `testPrice` checks whether the `Computer` constructor correctly sets the price when a new computer object is created. `testMemory` checks whether the constructor correctly stores the memory value passed into it. I also implemented `testUpdates` to verify whether the `setOS` method updates the operating system correctly.

Some of my tests focused on the behavior of the `ResaleShop` class. `testEmptyInventory` checks whether a new shop starts with an empty inventory. `testAddsComputer` verifies whether the `buy` method actually adds the computer passed as the parameter to the inventory. I also wrote `testThrowsInventory` and `testThrowsNotInInventory` to test whether the `buy` and `sell` methods throw exceptions when invalid actions occur, such as buying a computer that is already in inventory or selling one that does not exist.

Other tests check specific logic in the program. Such as`testPrint` checks whether the `printInventory` method runs without crashing,`testRefurbishPrice` verifies the pricing logic in the `refurbish` method for older computers. 

Finally, `testRefurbishDoesNotChange` checks whether the operating system remains unchanged when `"None"` is passed to the refurbish method.

Through this assignment, I learned that unit testing can help identify bugs by checking whether each method behaves the way we expect. When a test fails, it usually indicates that the code has a problem. 

My advice for future students is not to panic when you see red errors or failing tests. In this type of assignment, those failures actually help reveal where the bugs are in the program.


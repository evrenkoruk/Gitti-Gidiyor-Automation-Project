# GittiGidiyorProject
Java,Selenium Web Otomasyon Testi

A test automation project in Java using the Selenium library with the Maven Page Object Model structure.
'junit' library is used for Assertions and 'log4j' library is used for logging.

**Test Steps**

- Gittigidiyor.com homepage is opened.
- Login is done. It was checked.
- A random product was selected.
- Scrolled to the end of the page.
- 4 random items added to favourites.
- It's back to the homepage.
- Searched the word 'Bag' in the search box.
- The 6th product has been added to the cart. (As the 7th product is out of stock.)
- Go to cart.
- The number of products in the basket has been increased.
- Go to the payment page.
- Click the save button without entering the address information.
- Error message checked.
- Click the edit cart button.
- 2nd product from Favorites (I'll Buy Later) added to cart
- The 3rd product from the favorite products has been removed from the list. (The product element was registered during the first addition.)
- The homepage is opened in the side tab.
- Checked out.
- Side tab closed.
- All tabs closed. 


**Expected Result :**

- On Gittigidiyor.com;
- add to favorites,
- update cart,
- product deletion,
- adding products,
- open tab,
- product search,
- Performing login and logout operations.
- scrolling,
- Random selection of products,
- Switching between pages,
- See error message

**Actual Result:**

- All steps went smoothly. The test is successful. 

**Environment İnformation**

- Screen Resolution : 1920x1080
- Font Size : 100%
- Operating System: Windows 10
- Browser: Chrome
- IDE: IntelliJ
- Driver used: Chrome Web Driver

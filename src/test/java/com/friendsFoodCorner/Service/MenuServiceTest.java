package com.friendsFoodCorner.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.friendsFoodCorner.Entity.Cart;
import com.friendsFoodCorner.Entity.Menu;
import com.friendsFoodCorner.Exception.ItemNotFoundException;
import com.friendsFoodCorner.Repo.CartRepo;
import com.friendsFoodCorner.Repo.MenuRepo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration (classes = { MenuService.class })
@ExtendWith (SpringExtension.class)
class MenuServiceTest {
    @MockBean
    private CartRepo cartRepo;

    @MockBean
    private MenuRepo menuRepo;

    @Autowired
    private MenuService menuService;

    /**
     * Method under test: {@link MenuService#getItemById(int)}
     */
    @Test
    void testGetItemById() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        Optional<Menu> ofResult = Optional.of(menu);
        when(menuRepo.findById((Integer) any())).thenReturn(ofResult);
        when(menuRepo.existsById((Integer) any())).thenReturn(true);
        assertSame(menu, menuService.getItemById(1));
        verify(menuRepo).existsById((Integer) any());
        verify(menuRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link MenuService#getItemById(int)}
     */
    @Test
    void testGetItemById2() {
        when(menuRepo.findById((Integer) any())).thenThrow(new ItemNotFoundException("Msg"));
        when(menuRepo.existsById((Integer) any())).thenReturn(true);
        assertThrows(ItemNotFoundException.class, () -> menuService.getItemById(1));
        verify(menuRepo).existsById((Integer) any());
        verify(menuRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link MenuService#getItemById(int)}
     */
    @Test
    @Disabled ("TODO: Complete this test")
    void testGetItemById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.friendsFoodCorner.Service.MenuService.getItemById(MenuService.java:27)
        //   In order to prevent getItemById(int)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getItemById(int).
        //   See https://diff.blue/R013 to resolve this issue.

        when(menuRepo.findById((Integer) any())).thenReturn(Optional.empty());
        when(menuRepo.existsById((Integer) any())).thenReturn(true);
        menuService.getItemById(1);
    }

    /**
     * Method under test: {@link MenuService#getItemById(int)}
     */
    @Test
    void testGetItemById4() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        Optional<Menu> ofResult = Optional.of(menu);
        when(menuRepo.findById((Integer) any())).thenReturn(ofResult);
        when(menuRepo.existsById((Integer) any())).thenReturn(false);
        assertThrows(ItemNotFoundException.class, () -> menuService.getItemById(1));
        verify(menuRepo).existsById((Integer) any());
    }

    /**
     * Method under test: {@link MenuService#getAllItems()}
     */
    @Test
    void testGetAllItems() {
        when(menuRepo.findAll()).thenReturn(new ArrayList<>());
        assertTrue(menuService.getAllItems().isEmpty());
        verify(menuRepo).findAll();
    }

    /**
     * Method under test: {@link MenuService#getAllItems()}
     */
    @Test
    void testGetAllItems2() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(menu);
        when(menuRepo.findAll()).thenReturn(menuList);
        assertEquals(1, menuService.getAllItems().size());
        verify(menuRepo).findAll();
    }

    /**
     * Method under test: {@link MenuService#getAllItems()}
     */
    @Test
    void testGetAllItems3() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);

        Menu menu1 = new Menu();
        menu1.setCategory("Category");
        menu1.setId(1);
        menu1.setImage("Image");
        menu1.setItem("Item");
        menu1.setPrice(10.0d);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(menu1);
        menuList.add(menu);
        when(menuRepo.findAll()).thenReturn(menuList);
        assertEquals(2, menuService.getAllItems().size());
        verify(menuRepo).findAll();
    }

    /**
     * Method under test: {@link MenuService#getAllItems()}
     */
    @Test
    void testGetAllItems4() {
        when(menuRepo.findAll()).thenThrow(new ItemNotFoundException("Msg"));
        assertThrows(ItemNotFoundException.class, () -> menuService.getAllItems());
        verify(menuRepo).findAll();
    }

    /**
     * Method under test: {@link MenuService#save(Menu)}
     */
    @Test
    void testSave() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.save((Menu) any())).thenReturn(menu);

        Menu menu1 = new Menu();
        menu1.setCategory("Category");
        menu1.setId(1);
        menu1.setImage("Image");
        menu1.setItem("Item");
        menu1.setPrice(10.0d);
        menuService.save(menu1);
        verify(menuRepo).save((Menu) any());
        assertEquals("Category", menu1.getCategory());
        assertEquals(10.0d, menu1.getPrice());
        assertEquals("Item", menu1.getItem());
        assertEquals("Image", menu1.getImage());
        assertEquals(1, menu1.getId());
        List<Cart> allIt = menuService.getAllIt();
        assertTrue(allIt.isEmpty());
        assertEquals(allIt, menuService.getAllItems());
    }

    /**
     * Method under test: {@link MenuService#save(Menu)}
     */
    @Test
    void testSave2() {
        when(menuRepo.save((Menu) any())).thenThrow(new ItemNotFoundException("Msg"));

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        assertThrows(ItemNotFoundException.class, () -> menuService.save(menu));
        verify(menuRepo).save((Menu) any());
    }

    /**
     * Method under test: {@link MenuService#deleteItemById(int)}
     */
    @Test
    void testDeleteItemById() {
        doNothing().when(menuRepo).deleteById((Integer) any());
        when(menuRepo.existsById((Integer) any())).thenReturn(true);
        menuService.deleteItemById(1);
        verify(menuRepo).existsById((Integer) any());
        verify(menuRepo).deleteById((Integer) any());
        List<Cart> allIt = menuService.getAllIt();
        assertTrue(allIt.isEmpty());
        assertEquals(allIt, menuService.getAllItems());
    }

    /**
     * Method under test: {@link MenuService#deleteItemById(int)}
     */
    @Test
    void testDeleteItemById2() {
        doThrow(new ItemNotFoundException("Msg")).when(menuRepo).deleteById((Integer) any());
        when(menuRepo.existsById((Integer) any())).thenReturn(true);
        assertThrows(ItemNotFoundException.class, () -> menuService.deleteItemById(1));
        verify(menuRepo).existsById((Integer) any());
        verify(menuRepo).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link MenuService#deleteItemById(int)}
     */
    @Test
    void testDeleteItemById3() {
        doNothing().when(menuRepo).deleteById((Integer) any());
        when(menuRepo.existsById((Integer) any())).thenReturn(false);
        assertThrows(ItemNotFoundException.class, () -> menuService.deleteItemById(1));
        verify(menuRepo).existsById((Integer) any());
    }

    /**
     * Method under test: {@link MenuService#findAllItem(String)}
     */
    @Test
    void testFindAllItem() {
        when(menuRepo.findByCategory((String) any())).thenReturn(new ArrayList<>());
        assertTrue(menuService.findAllItem("Category").isEmpty());
        verify(menuRepo).findByCategory((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllItem(String)}
     */
    @Test
    void testFindAllItem2() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(menu);
        when(menuRepo.findByCategory((String) any())).thenReturn(menuList);
        assertEquals(1, menuService.findAllItem("Category").size());
        verify(menuRepo).findByCategory((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllItem(String)}
     */
    @Test
    void testFindAllItem3() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);

        Menu menu1 = new Menu();
        menu1.setCategory("Category");
        menu1.setId(1);
        menu1.setImage("Image");
        menu1.setItem("Item");
        menu1.setPrice(10.0d);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(menu1);
        menuList.add(menu);
        when(menuRepo.findByCategory((String) any())).thenReturn(menuList);
        assertEquals(2, menuService.findAllItem("Category").size());
        verify(menuRepo).findByCategory((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllItem(String)}
     */
    @Test
    void testFindAllItem4() {
        when(menuRepo.findByCategory((String) any())).thenThrow(new ItemNotFoundException("Msg"));
        assertThrows(ItemNotFoundException.class, () -> menuService.findAllItem("Category"));
        verify(menuRepo).findByCategory((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllItems(String)}
     */
    @Test
    void testFindAllItems() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);
        assertSame(menu, menuService.findAllItems("Item"));
        verify(menuRepo).findByItem((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllItems(String)}
     */
    @Test
    void testFindAllItems2() {
        when(menuRepo.findByItem((String) any())).thenThrow(new ItemNotFoundException("Msg"));
        assertThrows(ItemNotFoundException.class, () -> menuService.findAllItems("Item"));
        verify(menuRepo).findByItem((String) any());
    }

    /**
     * Method under test: {@link MenuService#getAllIt()}
     */
    @Test
    void testGetAllIt() {
        when(cartRepo.findAll()).thenReturn(new ArrayList<>());
        assertTrue(menuService.getAllIt().isEmpty());
        verify(cartRepo).findAll();
    }

    /**
     * Method under test: {@link MenuService#getAllIt()}
     */
    @Test
    void testGetAllIt2() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);

        ArrayList<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        when(cartRepo.findAll()).thenReturn(cartList);
        assertEquals(1, menuService.getAllIt().size());
        verify(cartRepo).findAll();
    }

    /**
     * Method under test: {@link MenuService#getAllIt()}
     */
    @Test
    void testGetAllIt3() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(10.0d);
        cart1.setTotal(10.0d);

        ArrayList<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart);
        when(cartRepo.findAll()).thenReturn(cartList);
        assertEquals(2, menuService.getAllIt().size());
        verify(cartRepo).findAll();
    }

    /**
     * Method under test: {@link MenuService#getAllIt()}
     */
    @Test
    void testGetAllIt4() {
        when(cartRepo.findAll()).thenThrow(new ItemNotFoundException("Msg"));
        assertThrows(ItemNotFoundException.class, () -> menuService.getAllIt());
        verify(cartRepo).findAll();
    }

    /**
     * Method under test: {@link MenuService#findAllIt(String)}
     */
    @Test
    void testFindAllIt() {
        when(cartRepo.findByName((String) any())).thenReturn(new ArrayList<>());
        assertTrue(menuService.findAllIt("Name").isEmpty());
        verify(cartRepo).findByName((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllIt(String)}
     */
    @Test
    void testFindAllIt2() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);

        ArrayList<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        when(cartRepo.findByName((String) any())).thenReturn(cartList);
        assertEquals(1, menuService.findAllIt("Name").size());
        verify(cartRepo).findByName((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllIt(String)}
     */
    @Test
    void testFindAllIt3() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(10.0d);
        cart1.setTotal(10.0d);

        ArrayList<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart);
        when(cartRepo.findByName((String) any())).thenReturn(cartList);
        assertEquals(2, menuService.findAllIt("Name").size());
        verify(cartRepo).findByName((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllIt(String)}
     */
    @Test
    void testFindAllIt4() {
        when(cartRepo.findByName((String) any())).thenThrow(new ItemNotFoundException("Msg"));
        assertThrows(ItemNotFoundException.class, () -> menuService.findAllIt("Name"));
        verify(cartRepo).findByName((String) any());
    }

    /**
     * Method under test: {@link MenuService#findCart(Cart)}
     */
    @Test
    void testFindCart() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        when(cartRepo.save((Cart) any())).thenReturn(cart);

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(10.0d);
        cart1.setTotal(10.0d);
        assertSame(menu, menuService.findCart(cart1));
        verify(cartRepo).save((Cart) any());
        verify(menuRepo).findByItem((String) any());
        assertEquals(100.0d, cart1.getTotal());
        assertEquals(10.0d, cart1.getQuantity());
        assertEquals(10.0d, cart1.getPrice());
        assertEquals("Name", cart1.getName());
        assertEquals("Item", cart1.getItem());
        assertEquals("Image", cart1.getImage());
    }

    /**
     * Method under test: {@link MenuService#findCart(Cart)}
     */
    @Test
    void testFindCart2() {
        when(cartRepo.save((Cart) any())).thenThrow(new ItemNotFoundException("Msg"));

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        assertThrows(ItemNotFoundException.class, () -> menuService.findCart(cart));
        verify(cartRepo).save((Cart) any());
        verify(menuRepo).findByItem((String) any());
    }

    /**
     * Method under test: {@link MenuService#findCart(Cart)}
     */
    @Test
    void testFindCart3() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        when(cartRepo.save((Cart) any())).thenReturn(cart);

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);
        Cart cart1 = mock(Cart.class);
        doNothing().when(cart1).setId(anyInt());
        doNothing().when(cart1).setImage((String) any());
        doNothing().when(cart1).setItem((String) any());
        doNothing().when(cart1).setName((String) any());
        doNothing().when(cart1).setOrdered_On((Date) any());
        doNothing().when(cart1).setPrice(anyDouble());
        doNothing().when(cart1).setQuantity(anyDouble());
        doNothing().when(cart1).setTotal(anyDouble());
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(10.0d);
        cart1.setTotal(10.0d);
        assertThrows(ArithmeticException.class, () -> menuService.findCart(cart1));
        verify(menuRepo).findByItem((String) any());
        verify(cart1).setId(anyInt());
        verify(cart1).setImage((String) any());
        verify(cart1).setItem((String) any());
        verify(cart1).setName((String) any());
        verify(cart1).setOrdered_On((Date) any());
        verify(cart1).setPrice(anyDouble());
        verify(cart1).setQuantity(anyDouble());
        verify(cart1).setTotal(anyDouble());
    }

    /**
     * Method under test: {@link MenuService#updatecart(Cart)}
     */
    @Test
    void testUpdatecart() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        when(cartRepo.save((Cart) any())).thenReturn(cart);

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(10.0d);
        cart1.setTotal(10.0d);
        Cart actualUpdatecartResult = menuService.updatecart(cart1);
        assertSame(cart1, actualUpdatecartResult);
        assertEquals(1, actualUpdatecartResult.getId());
        assertEquals(100.0d, actualUpdatecartResult.getTotal());
        assertEquals(10.0d, actualUpdatecartResult.getPrice());
        verify(cartRepo).save((Cart) any());
        verify(menuRepo).findByItem((String) any());
    }

    /**
     * Method under test: {@link MenuService#updatecart(Cart)}
     */
    @Test
    void testUpdatecart2() {
        when(cartRepo.save((Cart) any())).thenThrow(new ItemNotFoundException("Msg"));

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        assertThrows(ItemNotFoundException.class, () -> menuService.updatecart(cart));
        verify(cartRepo).save((Cart) any());
        verify(menuRepo).findByItem((String) any());
    }

    /**
     * Method under test: {@link MenuService#updatecart(Cart)}
     */
    @Test
    void testUpdatecart3() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        when(cartRepo.save((Cart) any())).thenReturn(cart);

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);
        Cart cart1 = mock(Cart.class);
        doNothing().when(cart1).setId(anyInt());
        doNothing().when(cart1).setImage((String) any());
        doNothing().when(cart1).setItem((String) any());
        doNothing().when(cart1).setName((String) any());
        doNothing().when(cart1).setOrdered_On((Date) any());
        doNothing().when(cart1).setPrice(anyDouble());
        doNothing().when(cart1).setQuantity(anyDouble());
        doNothing().when(cart1).setTotal(anyDouble());
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(10.0d);
        cart1.setTotal(10.0d);
        assertThrows(ArithmeticException.class, () -> menuService.updatecart(cart1));
        verify(cart1).setId(anyInt());
        verify(cart1).setImage((String) any());
        verify(cart1).setItem((String) any());
        verify(cart1).setName((String) any());
        verify(cart1).setOrdered_On((Date) any());
        verify(cart1).setPrice(anyDouble());
        verify(cart1).setQuantity(anyDouble());
        verify(cart1).setTotal(anyDouble());
    }

    /**
     * Method under test: {@link MenuService#deleteItem(int)}
     */
    @Test
    void testDeleteItem() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        when(cartRepo.deleteById(anyInt())).thenReturn(cart);
        when(cartRepo.existsById((Integer) any())).thenReturn(true);
        menuService.deleteItem(1);
        verify(cartRepo).existsById((Integer) any());
        verify(cartRepo).deleteById(anyInt());
        List<Cart> allIt = menuService.getAllIt();
        assertTrue(allIt.isEmpty());
        assertEquals(allIt, menuService.getAllItems());
    }

    /**
     * Method under test: {@link MenuService#deleteItem(int)}
     */
    @Test
    void testDeleteItem2() {
        when(cartRepo.deleteById(anyInt())).thenThrow(new ItemNotFoundException("Msg"));
        when(cartRepo.existsById((Integer) any())).thenReturn(true);
        assertThrows(ItemNotFoundException.class, () -> menuService.deleteItem(1));
        verify(cartRepo).existsById((Integer) any());
        verify(cartRepo).deleteById(anyInt());
    }

    /**
     * Method under test: {@link MenuService#deleteItem(int)}
     */
    @Test
    void testDeleteItem3() {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        when(cartRepo.deleteById(anyInt())).thenReturn(cart);
        when(cartRepo.existsById((Integer) any())).thenReturn(false);
        assertThrows(ItemNotFoundException.class, () -> menuService.deleteItem(1));
        verify(cartRepo).existsById((Integer) any());
    }
}


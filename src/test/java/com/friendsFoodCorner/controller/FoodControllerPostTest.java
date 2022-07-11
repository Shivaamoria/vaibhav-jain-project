package com.friendsFoodCorner.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsFoodCorner.Entity.Cart;
import com.friendsFoodCorner.Entity.Menu;
import com.friendsFoodCorner.Service.MenuService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration (classes = { FoodControllerPost.class })
@ExtendWith (SpringExtension.class)
class FoodControllerPostTest {
    @Autowired
    private FoodControllerPost foodControllerPost;

    @MockBean
    private MenuService menuService;

    /**
     * Method under test: {@link FoodControllerPost#getAllItems()}
     */
    @Test
    void testGetAllItems() throws Exception {
        when(menuService.getAllItems()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menu");
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FoodControllerPost#getAllItems()}
     */
    @Test
    void testGetAllItems2() throws Exception {
        when(menuService.getAllItems()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/menu");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(getResult).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FoodControllerPost#getAllIt()}
     */
    @Test
    void testGetAllIt() throws Exception {
        when(menuService.getAllIt()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart");
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FoodControllerPost#addCart(Cart)}
     */
    @Test
    void testAddCart() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.findCart((Cart) any())).thenReturn(menu);

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
        String content = (new ObjectMapper()).writeValueAsString(cart);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addcart").contentType(MediaType.APPLICATION_JSON).content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(
                               MockMvcResultMatchers.content().string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }

    /**
     * Method under test: {@link FoodControllerPost#delete(int)}
     */
    @Test
    void testDelete() throws Exception {
        doNothing().when(menuService).deleteItem(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cart/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link FoodControllerPost#delete(int)}
     */
    @Test
    void testDelete2() throws Exception {
        doNothing().when(menuService).deleteItem(anyInt());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/cart/{id}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(deleteResult).andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link FoodControllerPost#deleteItem(int)}
     */
    @Test
    void testDeleteItem() throws Exception {
        doNothing().when(menuService).deleteItemById(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/menu/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                       .andExpect(MockMvcResultMatchers.content().string("Product Deleted"));
    }

    /**
     * Method under test: {@link FoodControllerPost#deleteItem(int)}
     */
    @Test
    void testDeleteItem2() throws Exception {
        doNothing().when(menuService).deleteItemById(anyInt());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/menu/{id}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(deleteResult).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                       .andExpect(MockMvcResultMatchers.content().string("Product Deleted"));
    }

    /**
     * Method under test: {@link FoodControllerPost#addMenu(Menu)}
     */
    @Test
    void testAddMenu() throws Exception {
        when(menuService.save((Menu) any())).thenReturn("Save");

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addmenu").contentType(MediaType.APPLICATION_JSON).content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link FoodControllerPost#findAll(String)}
     */
    @Test
    void testFindAll() throws Exception {
        when(menuService.findAllIt((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/{name}", "Name");
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FoodControllerPost#findAll(String)}
     */
    @Test
    void testFindAll2() throws Exception {
        when(menuService.getAllIt()).thenReturn(new ArrayList<>());
        when(menuService.findAllIt((String) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/{name}", "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FoodControllerPost#getAllItem_name(String)}
     */
    @Test
    void testGetAllItem_name() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.findAllItems((String) any())).thenReturn(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mnu/{item}", "Item");
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(
                               MockMvcResultMatchers.content().string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }

    /**
     * Method under test: {@link FoodControllerPost#getAllItem_names(String)}
     */
    @Test
    void testGetAllItem_names() throws Exception {
        when(menuService.findAllItem((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/men/{category}", "Category");
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FoodControllerPost#getItem(int)}
     */
    @Test
    void testGetItem() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.getItemById(anyInt())).thenReturn(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menus/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }

    /**
     * Method under test: {@link FoodControllerPost#update(Cart)}
     */
    @Test
    void testUpdate() throws Exception {
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
        when(menuService.updatecart((Cart) any())).thenReturn(cart);

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
        String content = (new ObjectMapper()).writeValueAsString(cart1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/cart").contentType(MediaType.APPLICATION_JSON).content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                       .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content()
                                                                                                                                  .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"Ordered_On\":0,\"quantity\":10.0,\"total\":10.0,\"price\":10.0,\"name" + "\":\"Name\",\"ordered_On\":0}"));
    }
}


package valorless.valorlessutils.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import valorless.valorlessutils.utils.Utils;

/**
 * Represents a GUI with various actions and functionalities.
 */
public class GUI implements Listener {

    /**
     * Enumeration representing different actions that can be performed in the GUI.
     */
    public enum GUIAction {
        NONE, PREV_PAGE, NEXT_PAGE, CONFIRM, CANCEL, RETURN, OPEN_PAGE, CLOSE, OPEN_INVENTORY, GIVE_ITEM, GIVE_MONEY
    }
    
    /**
     * Represents an item within the GUI with associated action.
     */
    public class Item {
        public ItemStack item;
        public GUIAction action;
        
        /**
         * Constructs an Item with the given ItemStack and GUIAction.
         * @param item The ItemStack representing the item.
         * @param action The GUIAction associated with the item.
         */
        public Item(ItemStack item, GUIAction action) {
            this.item = item;
            this.action = action;
        }
        
        public ItemStack GetItemStack(){
            return item;
        }
        
        public GUIAction GetAction(){
            return action;
        }
    }

    /**
     * Represents a row within the GUI containing items.
     */
    public class Row {
        public List<Item> items;
        
        /**
         * Constructs a Row with an empty content list.
         */
        public Row() {
            items = new ArrayList<Item>(9);
        }
        
        /**
         * Sets an item at the specified index in the row.
         * @param index The index where the item should be set.
         * @param item The item to set.
         */
        public void SetItem(int index, Item item) {
            index = Utils.Clamp(index, 0, 8);
            items.set(index, item);
        }
        
        /**
         * Removes the item at the specified index from the row.
         * @param index The index of the item to remove.
         */
        public void RemoveItem(int index) {
            index = Utils.Clamp(index, 0, 8);
            items.set(index, null);
        }
        
        public Item GetItem(int index){
            return items.get(index);
        }
        
        /**
         * Sets the content of the row with the provided list of items.
         * @param content The list of items to set as the row's content.
         */
        public void SetItems(List<Item> items) {
            this.items = items;
        }
        
        public List<Item> GetItems(){
            return items;
        }
    }
    
    /**
     * Represents a page within the GUI consisting of multiple rows.
     */
    public class Page {
        public String title;
        public List<Row> rows;
        
        /**
         * Constructs an empty Page.
         */
        public Page() {}
        
        /**
         * Constructs a Page with the provided list of rows and title.
         * @param rows The list of rows in the page.
         * @param title The title of the page.
         */
        public Page(List<Row> rows, String title) {
            this.rows = rows;
            this.title = title;
        }
        
        /**
         * Sets the rows of the page with the provided list of rows.
         * @param rows The list of rows to set.
         */
        public void SetRows(List<Row> rows) {
            this.rows = rows;
        }
        
        public List<Row> GetRows(){
            return rows;
        }
        
        /**
         * Adds a row to the page.
         * @param row The row to add.
         */
        public void AddRow(Row row) {
            this.rows.add(row);
        }
        
        /**
         * Removes the row at the specified index from the page.
         * @param index The index of the row to remove.
         */
        public void RemoveRow(int index) {
            rows.remove(index);
        }
        
        public Row GetRow(int index){
            index = Utils.Clamp(index,0,5);
            return rows.get(index);
        }
        
        /**
         * Sets the title of the page.
         * @param title The title to set.
         */
        public void SetTitle(String title) {
            this.title = title;
        }
    }
    
    // Variables
    
    /**
     * List of listeners registered with the GUI.
     */
    public List<Listener> listeners;
    
    public List<Page> pages;
    
    public List<Page> pageHistory;
    
    public Inventory inventory;
    
    public Player player;
    
    public GUI(Player player) {
        this.player = player;
    }
    
    /**
     * Handles inventory click events in the GUI.
     * @param event The InventoryClickEvent.
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // More..
        // Implementation omitted for brevity.
        for (Listener listener : listeners) {
            try {
                //listener.onGUIEvent(GUIAction action, object... args);
            } catch (Exception e) {}
        }
    }
    
    /**
     * Registers a listener with the GUI.
     * @param listener The listener to register.
     */
    public void RegisterListener(Listener listener) {
        listeners.add(listener);
    }
    
    /**
     * Unregisters a listener from the GUI.
     * @param listener The listener to unregister.
     */
    public void UnregisterListener(Listener listener) {
        listeners.remove(listener);
    }
    
    public void OpenPage(int index){
        inventory = Bukkit.createInventory(null, 9, "");
        player.openInventory(inventory);
        pageHistory.add(pages.get(index));
    }
    
    public void AddPage(Page page){
        pages.add(page);
    }
    
    public void RemovePage(int index){
        pages.remove(index);
    }
    
    public Page GetPage(int index){
        return pages.get(index);
    }
}
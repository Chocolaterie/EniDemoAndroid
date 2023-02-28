package com.example.enidemo.game

class Item {

}

class InventoryComponent: ActorComponent() {

    var items : ArrayList<Item> = arrayListOf()
    var maxItemSlotCount = 64

    fun getItemCount() : Int {
        return items.size
    }

    fun addItem(item: Item) : Boolean {
        if (getItemCount() >= maxItemSlotCount){
            return false
        }

        items.add(item)
        return true
    }
}
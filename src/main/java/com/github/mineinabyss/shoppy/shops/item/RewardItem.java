package com.github.mineinabyss.shoppy.shops.item;

import com.github.mineinabyss.shoppy.shops.Reward;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

@SerializableAs("ShoppyRewardItem")
public class RewardItem extends ItemShop implements Reward {
    public RewardItem(ItemStack wantedItem) {
        super(wantedItem);
    }

    public static RewardItem deserialize(Map<String, Object> args) {
        RewardItem rewardItem = new RewardItem((ItemStack) args.get("item"));
        return rewardItem;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> args = new HashMap<>();
        args.put("==", "ShoppyRewardItem");
        args.put("item", item);
        return args;

    }

    public boolean reward(Player player) {
        return player.getInventory().addItem(item.clone()).isEmpty();
    }

    public static Reward defaultReward(){
        return new RewardItem(new ItemStack(Material.STONE));
    }
}

package com.github.mineinabyss.shoppy.gui;

import com.derongan.minecraft.guiy.gui.*;
import com.github.mineinabyss.shoppy.Shoppy;
import de.erethon.headlib.HeadLib;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CreateShopGUI extends GuiHolder {
    private Player player;
    private Shoppy plugin;
    private List<Layout> history = new ArrayList<>();
    private ClickableElement back;

    public CreateShopGUI(Player player, Shoppy plugin) {
        super(6, "Mine In Abyss - Stats", plugin);
        this.plugin = plugin;
        this.player = player;

        //create back button
        Element cell = Cell.forItemStack(HeadLib.RED_X.toItemStack("Back"));
        back = new ClickableElement(cell);
        back.setClickAction(clickEvent -> backInHistory());

        setElement(buildMain());
    }

    public Player getPlayer() {
        return player;
    }

    public void addBackButton(Layout layout) {
        history.add(layout);
        layout.addElement(8, 5, back);
    }

    public void backInHistory() {
        if (history.size() <= 1) {
            player.closeInventory();
            return;
        }
        Layout previous = history.get(history.size() - 2);
        history.remove(history.size() - 1);

        setElement(previous);
    }

    private Layout buildMain() {
        Layout layout = new Layout();

        Element name = Cell.forItemStack(HeadLib.CHECKMARK.toItemStack(), "Create");
        layout.addElement(0, 0, name);

        return layout;
    }
}
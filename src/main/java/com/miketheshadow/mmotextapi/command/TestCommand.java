package com.miketheshadow.mmotextapi.command;

import com.miketheshadow.mmotextapi.MMOTextAPI;
import com.miketheshadow.mmotextapi.text.StringToNumber;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TestCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            ItemStack stack = StringToNumber.generateTestItem("1");
            ItemStack stack1 = StringToNumber.generateTestItem("11");
            ItemStack stack2 = StringToNumber.generateTestItem("111");
            ItemStack stack3 = StringToNumber.generateTestItem("1111");
            ItemStack stack4 = StringToNumber.generateTestItem("11111");
            ItemStack stack5 = StringToNumber.generateTestItem("111111");
            ItemStack stack6 = StringToNumber.generateTestItem("1111111");
            ItemStack stack7 = StringToNumber.generateTestItem("11111111");
            player.getInventory().addItem(stack);
            player.getInventory().addItem(stack1);
            player.getInventory().addItem(stack2);
            player.getInventory().addItem(stack3);
            player.getInventory().addItem(stack4);
            player.getInventory().addItem(stack5);
            player.getInventory().addItem(stack6);
            player.getInventory().addItem(stack7);
        }
        return true;
    }
}

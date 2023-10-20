package de.kashqai.industrialcraft3.item;

import de.kashqai.industrialcraft3.IndustrialCraft3;
import de.kashqai.industrialcraft3.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustrialCraft3.MOD_ID);

    public static final RegistryObject<CreativeModeTab> IC3_TAB = CREATIVE_MODE_TABS.register("ic_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN_PLATE.get()))
                    .title(Component.translatable("creativetab.ic_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModItems.TIN_INGOT.get());
                        output.accept(ModItems.TIN_DUST.get());
                        output.accept(ModItems.SMALL_TIN_DUST.get());
                        output.accept(ModItems.TIN_PLATE.get());
                        output.accept(ModItems.RAW_TIN.get());
                        output.accept(ModItems.RAW_LEAD.get());
                        output.accept(ModItems.LEAD_INGOT.get());

                        output.accept(ModBlocks.TIN_BLOCK.get());
                        output.accept(ModBlocks.TIN_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE.get());
                        output.accept(ModBlocks.RAW_TIN_BLOCK.get());
                        output.accept(ModBlocks.LEAD_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_LEAD_ORE.get());
                        output.accept(ModBlocks.LEAD_BLOCK.get());

                        output.accept(ModBlocks.TIN_STAIRS.get());
                        output.accept(ModBlocks.TIN_SLAB.get());
                        output.accept(ModBlocks.TIN_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.TIN_BUTTON.get());
                        output.accept(ModBlocks.TIN_FENCE.get());
                        output.accept(ModBlocks.TIN_FENCE_GATE.get());
                        output.accept(ModBlocks.TIN_WALL.get());

                        output.accept(ModBlocks.ELECTRIC_FURNACE.get());





                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

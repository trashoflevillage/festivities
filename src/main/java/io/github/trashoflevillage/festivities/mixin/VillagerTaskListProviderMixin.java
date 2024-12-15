package io.github.trashoflevillage.festivities.mixin;

import com.google.common.collect.ImmutableList;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.datafixers.util.Pair;
import io.github.trashoflevillage.festivities.entity.ai.GiveHolidayGiftsTask;
import net.minecraft.entity.ai.brain.task.GiveGiftsToHeroTask;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.ai.brain.task.VillagerTaskListProvider;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

@Mixin(VillagerTaskListProvider.class)
public class VillagerTaskListProviderMixin {
    @ModifyReturnValue(method = "createWorkTasks", at = @At("TAIL"))
    private static ImmutableList<Pair<Integer, ? extends Task<? super VillagerEntity>>> createWorkTasks(ImmutableList<Pair<Integer, ? extends Task<? super VillagerEntity>>> original) {
        List list = new ArrayList(original);
        list.add(Pair.of(3, new GiveHolidayGiftsTask(100)));
        return ImmutableList.copyOf(list);
    }

    @ModifyReturnValue(method = "createMeetTasks", at = @At("TAIL"))
    private static ImmutableList<Pair<Integer, ? extends Task<? super VillagerEntity>>> createMeetTasks(ImmutableList<Pair<Integer, ? extends Task<? super VillagerEntity>>> original) {
        List list = new ArrayList(original);
        list.add(Pair.of(3, new GiveHolidayGiftsTask(100)));
        return ImmutableList.copyOf(list);
    }

    @ModifyReturnValue(method = "createIdleTasks", at = @At("TAIL"))
    private static ImmutableList<Pair<Integer, ? extends Task<? super VillagerEntity>>> createIdleTasks(ImmutableList<Pair<Integer, ? extends Task<? super VillagerEntity>>> original) {
        List list = new ArrayList(original);
        list.add(Pair.of(3, new GiveHolidayGiftsTask(100)));
        return ImmutableList.copyOf(list);
    }
}

package net.lizistired.starminerrecrafted.mixin;


import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static net.lizistired.starminerrecrafted.basics.blockentities.GravityCoreBlockEntity.relativeDirection;

@Mixin(DebugHud.class)
public abstract class MixinDebugScreenOverlay {

    @Inject(method = "getRightText", at = @At("RETURN"))
    private void appendDebugDirectionText(CallbackInfoReturnable<List<String>> cir) {
        List<String> messages = cir.getReturnValue();
        messages.add("");
        messages.add("Direction: " + relativeDirection.toString().toUpperCase());
        messages.add("");
    }
}

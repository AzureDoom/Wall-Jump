package genandnic.walljump.mixin.client;

import genandnic.walljump.FallingSound;
import genandnic.walljump.WallJumpClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ClientWorld.class)
public class ClientWorldFallingSoundMixin {

    @Inject(method = "addPlayer", at = @At(value = "TAIL"))
    private void addPlayerFallingSound(int id, AbstractClientPlayerEntity player, CallbackInfo ci) {

        if(player == MinecraftClient.getInstance().player) {

            WallJumpClient.FALLING_SOUND = new FallingSound(MinecraftClient.getInstance().player, Random.create());
            MinecraftClient.getInstance().getSoundManager().play(WallJumpClient.FALLING_SOUND);

        }
    }
}

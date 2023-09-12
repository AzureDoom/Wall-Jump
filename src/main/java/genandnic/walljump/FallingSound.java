package genandnic.walljump;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

@Environment(EnvType.CLIENT)
public class FallingSound extends AbstractTickableSoundInstance {

	private final LocalPlayer player;

	public FallingSound(LocalPlayer player, RandomSource random) {
		super(SoundEvents.ELYTRA_FLYING, SoundSource.PLAYERS, random);
		this.player = player;
		this.looping = true;
		this.delay = 0;
		this.volume = Float.MIN_VALUE;
	}

	@Override
	public void tick() {
		var length = (float) player.getDeltaMovement().lengthSqr();
		if (length >= 1.0 && player.isAlive()) {
			this.volume = Mth.clamp((length - 1.0F) / 4.0F, 0.0F, 2.0F);
			if (this.volume > 0.8)
				this.pitch = 1.0F + (this.volume - 0.8F);
			else
				this.pitch = 1.0F;
		} else {
			this.stop();
		}
	}
}

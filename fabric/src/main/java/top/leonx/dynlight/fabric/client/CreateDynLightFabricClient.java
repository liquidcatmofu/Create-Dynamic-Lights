package top.leonx.dynlight.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import top.leonx.dynlight.fabric.LambModEventHandler;

public final class CreateDynLightFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // If there is SodiumDynamicLights, register the event handler
        if (FabricLoader.getInstance().isModLoaded("sodiumdynamiclights")) {
            LambModEventHandler.register();
        }
    }
}

package top.leonx.dynlight;

import com.mojang.logging.LogUtils;
import com.simibubi.create.api.behaviour.movement.MovementBehaviour;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;

import java.util.Collection;

public class CreateDynLight {
    public static final String MOD_ID = "createdynlight";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        registerGlobalBehaviourProvider();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @Deprecated
    public static void registerBehaviours(Collection<Block> blocks){
        LOGGER.info("Registering DynLightMovementBehaviours to REGISTRY");
        blocks.forEach(block -> {
            var lightEmission = block.defaultBlockState().getLightEmission();
            // すでに登録済みでないか確認してから登録
            if (MovementBehaviour.REGISTRY.get(block) == null) {
                MovementBehaviour.REGISTRY.register(block, new LightMovementBehaviour(lightEmission));
            }
        });
    }

    public static void registerGlobalBehaviourProvider(){
        var provider = new LightBehaviourProvider();
        MovementBehaviour.REGISTRY.registerProvider(provider);
        LOGGER.info("Registered LightBehaviourProvider to MovementBehaviour.REGISTRY");
    }
}
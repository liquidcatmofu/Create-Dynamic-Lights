package top.leonx.dynlight.config;

import net.createmod.catnip.config.ConfigBase;
import org.jetbrains.annotations.NotNull;

public class CreateDynLightCommon extends ConfigBase {

    @Override
    public @NotNull String getName() {
        return "dynamic light common";
    }

    public final ConfigBool enable = b(false, "enable", Comments.enable);

    public static class Comments {
        public static final String enable = "Enable dynamic light.";
    }
}

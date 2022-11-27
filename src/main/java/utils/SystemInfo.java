package utils;

/**
 * This class contains all the helper methods related with System.
 */
public class SystemInfo {

    /**
     * This method provides the platform (OS) information.
     *
     * @return Platform type.
     */
    public static PlatformType getPlatformType() {
        String platform = System.getProperty("os.name", "").toLowerCase();
        if (platform.contains(PlatformType.WINDOWS.toString().toLowerCase())) {
            return PlatformType.WINDOWS;
        } else if (platform.contains(PlatformType.MAC.toString().toLowerCase())) {
            return PlatformType.MAC;
        } else if (platform.contains(PlatformType.LINUX.toString().toLowerCase())) {
            return PlatformType.LINUX;
        } else {
            return PlatformType.UNKNOWN;
        }
    }
}
